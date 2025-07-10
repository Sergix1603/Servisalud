package Modelo_Ventas;

import Modelo_Empleados.Empleados;
import Modelo_Pacientes.Pacientes;
import Modelo_Productos.Productos;
import Modelo_Sucursal.Sucursal;
import Vista.Sucursales;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class PDFService {

    public static void generarReportePDF(Ventas venta) throws DocumentException, IOException {
        if (venta == null) {
            throw new IOException("No se encontró la venta para generar el reporte.");
        }

        Empleados empleado = venta.getEmpleado();
        Pacientes paciente = venta.getPaciente();
        List<Productos> productos = venta.getProductos();
        Sucursal sucursal = venta.getSucursal(); // Suponiendo que la venta tiene una sucursal asociada

        // Verificar si los datos de empleado y paciente están disponibles
        if (empleado == null || paciente == null || productos == null || productos.isEmpty() || sucursal == null) {
            throw new IOException("Datos incompletos para generar el reporte.");
        }

        // Ruta de la carpeta donde se guardará el archivo PDF
        String carpeta = "C:/RESULTADOS_SERVISALUD";
        File folder = new File(carpeta);
        if (!folder.exists()) {
            folder.mkdirs();
        }

        // Ruta del archivo PDF
        String pdfFilePath = carpeta + "/" + venta.getCod_venta() + ".pdf";

        // Crear documento PDF
        Document documento = new Document();
        PdfWriter.getInstance(documento, new FileOutputStream(pdfFilePath));
        documento.open();

        // Título
        documento.add(new Paragraph("Reporte de Venta"));
        documento.add(new Chunk("\n")); // Salto de línea

        // Tabla para los detalles de la venta
        PdfPTable tabla = new PdfPTable(2); // Número de columnas (Campo y Valor)

        // Información de la venta
        tabla.addCell("Campo");
        tabla.addCell("Valor");

        tabla.addCell("Código de Venta");
        tabla.addCell(venta.getCod_venta());

        tabla.addCell("Fecha de Venta");
        tabla.addCell(venta.getFecha().toString());

        // Información del empleado
        tabla.addCell("Empleado");
        tabla.addCell(empleado.getEmple_nom() + " " + empleado.getEmple_ape());

        tabla.addCell("DNI del Empleado");
        tabla.addCell(empleado.getDNI());

        tabla.addCell("Especialidad");
        tabla.addCell(empleado.getEspecialidad());

        // Información del paciente
        tabla.addCell("Paciente");
        tabla.addCell(paciente.getNom_paciente() + " " + paciente.getApe_paciente());

        tabla.addCell("DNI del Paciente");
        tabla.addCell(String.valueOf(paciente.getDNI()));

        tabla.addCell("Peso");
        tabla.addCell(String.valueOf(paciente.getPeso()));

        tabla.addCell("Altura");
        tabla.addCell(String.valueOf(paciente.getAltura()));

        tabla.addCell("IMC");
        tabla.addCell(String.format("%.2f", paciente.getPeso() / (paciente.getAltura() * paciente.getAltura())));

        tabla.addCell("Enfermedad");
        tabla.addCell(paciente.getEnfermedad());

        tabla.addCell("Nivel de Urgencia");
        tabla.addCell(paciente.getNivel_Urgencia());

        // Información de los productos vendidos
        tabla.addCell("Producto");
        tabla.addCell("Cantidad Vendida");

        tabla.addCell("Precio Unitario");
        tabla.addCell("Total Producto");

        double totalVenta = 0;
        for (Productos producto : productos) {
            tabla.addCell(producto.getNombre());
            tabla.addCell(String.valueOf(producto.getCantidad()));

            tabla.addCell(String.valueOf(producto.getPrecio()));
            double totalProducto = producto.getCantidad() * producto.getPrecio();
            tabla.addCell(String.format("%.2f", totalProducto));

            totalVenta += totalProducto;
        }

        // Información de la sucursal
        tabla.addCell("Departamento Sucursal");
        tabla.addCell(sucursal.getDepartamento());

        tabla.addCell("Dirección Sucursal");
        tabla.addCell(sucursal.getDireccion());

        tabla.addCell("Teléfono Sucursal");
        tabla.addCell(sucursal.getTelefono());

        // Agregar la tabla al documento
        documento.add(tabla);

        // Agregar el total de la venta
        documento.add(new Chunk("\n"));
        documento.add(new Paragraph("Total Venta: " + String.format("%.2f", totalVenta)));

        // Cerrar documento
        documento.close();
    }
}
