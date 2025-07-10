package Modelo_Ventas;
import ConectorDB.Conexion;
import Modelo_Empleados.Empleados;
import Modelo_Pacientes.Pacientes;
import Modelo_Productos.Productos;
import Modelo_Sucursal.Sucursal;
import com.lowagie.text.DocumentException;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VentasDAO {
    Conexion conexion;
    
    public VentasDAO() {
        conexion = new Conexion();
    }

    public String insertVenta(String cod_venta, String fecha, String emple_ape, String paci_ape, String nom_Producto, String nivel_urgencia, String cod_sede) {
        String rptaRegistro = null;
        try (Connection accesoDB = conexion.getConexion();
             CallableStatement cs = accesoDB.prepareCall("{call sp_Insertar_Resultado(?,?,?,?,?,?,?)}")) {
            cs.setString(1, cod_venta);
            cs.setString(2, fecha);
            cs.setString(3, emple_ape);
            cs.setString(4, paci_ape);
            cs.setString(5, nom_Producto);
            cs.setString(6, nivel_urgencia);
            cs.setString(7, cod_sede);
            int numFAfectas = cs.executeUpdate();
            if (numFAfectas > 0) {
                rptaRegistro = "Registro Exitoso";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rptaRegistro;
    }
    
    public Ventas obtenerReporteVenta(String cod_venta) {
    Ventas venta = null;
    try (Connection conn = conexion.getConexion();
         PreparedStatement ps = conn.prepareStatement("{CALL obtenerReporteVenta(?)}")) {
        // Configuramos el parámetro para el procedimiento almacenado
        ps.setString(1, cod_venta);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            // Instanciamos el objeto Venta
            venta = new Ventas();
            
            // Asignamos los datos de la venta
            venta.setCod_venta(rs.getString("Código de Venta"));
            venta.setFecha(rs.getString("Fecha de Venta"));
            
            // Asignamos los datos del empleado
            Empleados empleado = new Empleados();
            empleado.setEmple_nom(rs.getString("Nombre Empleado"));
            empleado.setEmple_ape(rs.getString("Apellido Empleado"));
            empleado.setDNI(rs.getString("DNI Empleado"));
            empleado.setEspecialidad(rs.getString("Especialidad Empleado"));
            venta.setEmpleado(empleado);
            
            // Asignamos los datos del paciente
            Pacientes paciente = new Pacientes();
            paciente.setNom_paciente(rs.getString("Nombre Paciente"));
            paciente.setApe_paciente(rs.getString("Apellido Paciente"));
            paciente.setDNI(rs.getInt("DNI Paciente"));
            paciente.setPeso(rs.getDouble("Peso Paciente"));
            paciente.setAltura(rs.getDouble("Altura Paciente"));
            paciente.setEnfermedad(rs.getString("Enfermedad"));
            paciente.setNivel_Urgencia(rs.getString("Nivel de Urgencia Paciente"));
            venta.setPaciente(paciente);
            
            // Asignamos los datos de los productos
            Productos producto = new Productos();
            producto.setNombre(rs.getString("Nombre Producto"));
            producto.setCantidad(rs.getInt("Cantidad Vendida"));
            producto.setPrecio(rs.getDouble("Precio Unitario"));
            venta.setProductos(List.of(producto)); // Suponemos que solo hay un producto

            // Asignamos los datos de la sucursal
            Sucursal sucursal = new Sucursal();
            sucursal.setDepartamento(rs.getString("Departamento Sucursal"));
            sucursal.setDireccion(rs.getString("Dirección Sucursal"));
            sucursal.setTelefono(rs.getString("Teléfono Sucursal"));
            venta.setSucursal(sucursal);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return venta;
}



    public ArrayList<Ventas> listVentas() {
        ArrayList<Ventas> listaventa = new ArrayList<>();
        Ventas venta;
        try (Connection acceDB = conexion.getConexion();
             PreparedStatement ps = acceDB.prepareStatement("select * from ventas");
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                venta = new Ventas();
                venta.setCod_venta(rs.getString(1));
                venta.setFecha(rs.getString(2));
                venta.setEmple_ape(rs.getString(3));
                venta.setPaci_ape(rs.getString(4));
                venta.setNom_Producto(rs.getString(5));
                venta.setNivel_urgencia(rs.getString(6));
                venta.setCod_sede(rs.getString(7));
                listaventa.add(venta);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaventa;
    }
    
        /*public Ventas obtenerReporteVenta(String codVenta) {
    String query = "{CALL obtenerReporteVenta(?)}"; // Llamada al procedure con un parámetro
    Ventas venta = null;

    try (Connection connection = conexion.getConexion();
         PreparedStatement stmt = connection.prepareStatement(query)) {
        stmt.setString(1, codVenta);

        try (ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                // Crear objeto Ventas y asociar datos obtenidos de la consulta
                venta = new Ventas();
                venta.setCod_venta(rs.getString("Código de Venta"));
                // Setear otros atributos de la venta, empleado, paciente, productos...
                // Ejemplo:
                Empleados empleado = new Empleados();
                empleado.setEmple_nom(rs.getString("Nombre Empleado"));
                empleado.setEmple_ape(rs.getString("Apellido Empleado"));
                // Rellenar más datos del empleado...

                Pacientes paciente = new Pacientes();
                paciente.setNom_paciente(rs.getString("Nombre Paciente"));
                // Rellenar más datos del paciente...

                // Asumir que hay una lista de productos que se extraen de la base de datos
                List<Productos> productos = new ArrayList<>();
                Productos producto = new Productos();
                producto.setNombre(rs.getString("Nombre Producto"));
                producto.setCantidad(rs.getInt("Cantidad Vendida"));
                // Agregar más datos del producto...
                productos.add(producto);
                
                // Setear los objetos en la venta
                venta.setEmpleado(empleado);
                venta.setPaciente(paciente);
                venta.setProductos(productos);
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return venta; // Retorna la venta con todos los datos
}*/


    public int EditarVenta(String cod_venta, String fecha, String emple_ape, String paci_ape, String nom_Producto, String nivel_urgencia, String cod_sede) {
        int numFA = 0;
        try (Connection accDB = conexion.getConexion();
             CallableStatement cs = accDB.prepareCall("{call sp_Editar_Resultado(?,?,?,?,?,?,?)}")) {
            cs.setString(1, cod_venta);
            cs.setString(2, fecha);
            cs.setString(3, emple_ape);
            cs.setString(4, paci_ape);
            cs.setString(5, nom_Producto);
            cs.setString(6, nivel_urgencia);
            cs.setString(7, cod_sede);
            numFA = cs.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return numFA;
    }

    public int EliminarVenta(String cod_venta) {
        int numFA = 0;
        try (Connection accDB = conexion.getConexion();
             CallableStatement cs = accDB.prepareCall("{call sp_Eliminar_Resultado(?)}")) {
            cs.setString(1, cod_venta);
            numFA = cs.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return numFA;
    }

    public ArrayList<Ventas> BuscarVentaxApellidoPaciente(String paci_ape) {
        ArrayList<Ventas> listaVentas = new ArrayList<>();
        Ventas venta;
        try (Connection accDB = conexion.getConexion();
             CallableStatement cs = accDB.prepareCall("{call sp_sucursal_ResultadoxApellidoCliente(?)}")) {
            cs.setString(1, paci_ape);
            try (ResultSet rs = cs.executeQuery()) {
                while (rs.next()) {
                    venta = new Ventas();
                    venta.setCod_venta(rs.getString(1));
                    venta.setFecha(rs.getString(2));
                    venta.setEmple_ape(rs.getString(3));
                    venta.setPaci_ape(rs.getString(4));
                    venta.setNom_Producto(rs.getString(5));
                    venta.setNivel_urgencia(rs.getString(6));
                    venta.setCod_sede(rs.getString(7));
                    listaVentas.add(venta);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaVentas;
    }
}
