package Controlador;
import Modelo_Ventas.PDFService;
import Modelo_Ventas.VentasDAO;
import Vista.Ventas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JTable;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class ControladorCRUD_Ventas implements ActionListener,KeyListener{
    Ventas VistaCrudVen = new Ventas();
    VentasDAO modeloCrudVen = new VentasDAO();
    public ControladorCRUD_Ventas(Ventas VistaCrudVen,VentasDAO modeloCrudVen){
        
        this.VistaCrudVen=VistaCrudVen;
        this.modeloCrudVen=modeloCrudVen;
        this.VistaCrudVen.BTN_REGISTRAR4.addActionListener(this);
        this.VistaCrudVen.BTN_LISTAR.addActionListener(this);
        
        this.VistaCrudVen.BTN_MODIFICAR.addActionListener(this);
        this.VistaCrudVen.BTN_ELIMINAR.addActionListener(this);
        this.VistaCrudVen.BTN_CONFIRMAR.addActionListener(this);
        this.VistaCrudVen.BTN_DESCARGAR.addActionListener(this);
        
        this.VistaCrudVen.txt_cod_venta2.addKeyListener(this);
        this.VistaCrudVen.txt_busqueda.addKeyListener(this);
        
    }
    public void InicializarCrud(){
        
    }
    public void LLenarTabla(JTable tablaD){
        DefaultTableModel modeloT = new DefaultTableModel();
        tablaD.setModel(modeloT);
        modeloT.addColumn("Codigo de Resultado");
        modeloT.addColumn("Fecha");
        modeloT.addColumn("Apellido de Empleado");
        modeloT.addColumn("Apellido de Paciente");
        modeloT.addColumn("Nombre del Producto");
        modeloT.addColumn("Urgencia");
        modeloT.addColumn("Codigo Sucursal");
        Object[] columna = new Object[7];
        
        int numRegistros= modeloCrudVen.listVentas().size();
        for (int i=0;i<numRegistros;i++){
            columna[0]=modeloCrudVen.listVentas().get(i).getCod_venta();
            columna[1]=modeloCrudVen.listVentas().get(i).getFecha();
            columna[2]=modeloCrudVen.listVentas().get(i).getEmple_ape();
            columna[3]=modeloCrudVen.listVentas().get(i).getPaci_ape();
            columna[4]=modeloCrudVen.listVentas().get(i).getNom_Producto();
            columna[5]=modeloCrudVen.listVentas().get(i).getNivel_urgencia();
            columna[6]=modeloCrudVen.listVentas().get(i).getCod_sede();
            modeloT.addRow(columna);
        }
        LimpiarElementos();
    }
    public void LimpiarElementos(){
        VistaCrudVen.txt_cod_venta2.setText("");
        VistaCrudVen.txt_busqueda.setText("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == VistaCrudVen.BTN_REGISTRAR4) {
        // Validate if fields are not empty
        if (VistaCrudVen.txt_cod_venta2.getText().isEmpty() ||
            VistaCrudVen.JdFecha.getDate() == null ||
            VistaCrudVen.Jcombo_ape_emple.getSelectedItem() == null ||
            VistaCrudVen.Jcombo_ape_paci.getSelectedItem() == null ||
            VistaCrudVen.Jcombo_products.getSelectedItem() == null ||
            VistaCrudVen.Jcombo_urg_nivel.getSelectedItem() == null ||
            VistaCrudVen.Jcombo_cod_sede.getSelectedItem() == null) {
                
            JOptionPane.showMessageDialog(null, "Todos los campos deben estar llenos antes de registrar.");
            return;  // Terminate if any field is empty
        }

        // Proceed with registration if all fields are filled
        String cod_venta = VistaCrudVen.txt_cod_venta2.getText();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
        String fecha = formatoFecha.format(VistaCrudVen.JdFecha.getDate());
        String selectedValue = (String) VistaCrudVen.Jcombo_ape_emple.getSelectedItem();
        String apellido = selectedValue.split(" - ")[0];
        String selectedValor = (String) VistaCrudVen.Jcombo_ape_paci.getSelectedItem();
        String ape_paci = selectedValor.split(" - ")[0];
        String nom_producto = (String) VistaCrudVen.Jcombo_products.getSelectedItem();
        String Urgencia = (String) VistaCrudVen.Jcombo_urg_nivel.getSelectedItem();
        String cod_sede = (String) VistaCrudVen.Jcombo_cod_sede.getSelectedItem();

        // Register in the database
        String rptaRegistro = modeloCrudVen.insertVenta(cod_venta, fecha, apellido, ape_paci, nom_producto, Urgencia, cod_sede);
        if (rptaRegistro != null) {
            JOptionPane.showMessageDialog(null, rptaRegistro);
        } else {
            JOptionPane.showMessageDialog(null, "Registro Erroneo");
        }
    }
        if(e.getSource()==VistaCrudVen.BTN_LISTAR){
            LLenarTabla(VistaCrudVen.TABLA_DATOS);
            JOptionPane.showMessageDialog(null, "Lista de Registros");
        }
        
        
        if(e.getSource()==VistaCrudVen.BTN_MODIFICAR){
            int filaEditar = VistaCrudVen.TABLA_DATOS.getSelectedRow();
            int numFS = VistaCrudVen.TABLA_DATOS.getSelectedRowCount();
            
            if(filaEditar >= 0 && numFS == 1){
                VistaCrudVen.txt_cod_venta2.setText(String.valueOf(VistaCrudVen.TABLA_DATOS.getValueAt(filaEditar, 0)));
                String fecha = String.valueOf(VistaCrudVen.TABLA_DATOS.getValueAt(filaEditar, 1));
                try {
                    SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
                    Date fechaSeleccionada = formatoFecha.parse(fecha);
                    VistaCrudVen.JdFecha.setDate(fechaSeleccionada);
                } catch (ParseException ex) {
                    ex.printStackTrace();
                }
                String ape_emple = String.valueOf(VistaCrudVen.TABLA_DATOS.getValueAt(filaEditar, 2));
                String[] ape_empleValues = ape_emple.split(", ");
                String firstApeEmple = ape_empleValues[0];
                VistaCrudVen.Jcombo_ape_emple.setSelectedItem(firstApeEmple);
                
                String ape_paci = String.valueOf(VistaCrudVen.TABLA_DATOS.getValueAt(filaEditar, 3));
                String[] ape_paciValues = ape_paci.split(", ");
                String firstApePaci = ape_paciValues[0];
                VistaCrudVen.Jcombo_ape_paci.setSelectedItem(firstApePaci);
                
                String Products =String.valueOf(VistaCrudVen.TABLA_DATOS.getValueAt(filaEditar, 4));
                VistaCrudVen.Jcombo_products.setSelectedItem(Products);
                String Nivel_urg =String.valueOf(VistaCrudVen.TABLA_DATOS.getValueAt(filaEditar, 5));
                VistaCrudVen.Jcombo_urg_nivel.setSelectedItem(Nivel_urg);
                String cod_sede =String.valueOf(VistaCrudVen.TABLA_DATOS.getValueAt(filaEditar, 6));
                VistaCrudVen.Jcombo_cod_sede.setSelectedItem(cod_sede);

                VistaCrudVen.txt_cod_venta2.setEditable(true);
                VistaCrudVen.BTN_REGISTRAR4.setEnabled(false);
                VistaCrudVen.BTN_MODIFICAR.setEnabled(false);
                VistaCrudVen.BTN_ELIMINAR.setEnabled(false);
                VistaCrudVen.txt_busqueda.setEnabled(false);
            }else{
                JOptionPane.showMessageDialog(null, "Debe seleccionar una fila, almenos una para su edición");
            }
        }
        if(e.getSource() == VistaCrudVen.BTN_CONFIRMAR){
            
            String cod_venta=VistaCrudVen.txt_cod_venta2.getText();
            SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
            String fecha=formatoFecha.format(VistaCrudVen.JdFecha.getDate());
            String ape_emple = ((String) VistaCrudVen.Jcombo_ape_emple.getSelectedItem()).split(" - ")[0];
            String ape_paci = ((String) VistaCrudVen.Jcombo_ape_paci.getSelectedItem()).split(" - ")[0];
            String nom_producto = (String)VistaCrudVen.Jcombo_products.getSelectedItem();
            String Urgencia = (String)VistaCrudVen.Jcombo_urg_nivel.getSelectedItem();
            String cod_sede = (String)VistaCrudVen.Jcombo_cod_sede.getSelectedItem();
            
            int rptaEdit=modeloCrudVen.EditarVenta(cod_venta, fecha, ape_emple, ape_paci, nom_producto,Urgencia,cod_sede);
            
            if(rptaEdit>0){
                JOptionPane.showMessageDialog(null, "Modificación Exitosa");
            }else{
                JOptionPane.showMessageDialog(null, "No se pudo realizar la modificacion");
            }
            LimpiarElementos();
            VistaCrudVen.BTN_REGISTRAR4.setEnabled(true);
            VistaCrudVen.BTN_MODIFICAR.setEnabled(true);
            VistaCrudVen.BTN_ELIMINAR.setEnabled(true);
            VistaCrudVen.txt_busqueda.setEnabled(true);
            VistaCrudVen.BTN_CONFIRMAR.setEnabled(true);
        }
        if(e.getSource()==VistaCrudVen.BTN_ELIMINAR){
            int filaInicio = VistaCrudVen.TABLA_DATOS.getSelectedRow();
            int numFS = VistaCrudVen.TABLA_DATOS.getSelectedRowCount();
            ArrayList<String> ListaVentas = new ArrayList();
            String cod_venta="";
            
            if(filaInicio>=0){
                for (int i = 0; i < numFS; i++) {
                    cod_venta=String.valueOf(VistaCrudVen.TABLA_DATOS.getValueAt(i+filaInicio,0));
                    ListaVentas.add(cod_venta);
                }
                
                for (int i = 0; i < numFS; i++) {
                    int  RptUsuario = JOptionPane.showConfirmDialog(null,"Quiere eliminar registro con código "+cod_venta+"?");
                    if(RptUsuario==0){
                        modeloCrudVen.EliminarVenta(cod_venta);
                    }
                }
                LLenarTabla(VistaCrudVen.TABLA_DATOS);
            }else{
                JOptionPane.showMessageDialog(null,"Seleccione al menos una fila a eliminar");
            }
        }
        if (e.getSource() == VistaCrudVen.BTN_DESCARGAR) {
    // Obtener la fila seleccionada
    int filaDescargar = VistaCrudVen.TABLA_DATOS.getSelectedRow();

    if (filaDescargar != -1) {  // Verifica si se ha seleccionado una fila
        try {
            DefaultTableModel model = (DefaultTableModel) VistaCrudVen.TABLA_DATOS.getModel();
            String cod_venta = model.getValueAt(filaDescargar, 0).toString();  // Obtiene el código de venta

            // Llamar al DAO para obtener la venta
            VentasDAO ventasDAO = new VentasDAO();
            Modelo_Ventas.Ventas venta = ventasDAO.obtenerReporteVenta(cod_venta);  // Obtener los detalles de la venta

            if (venta != null) {
                // Llamar al PDFService para generar el PDF con los datos de la venta
                PDFService.generarReportePDF(venta);  // Pasar el objeto venta a PDFService

                // Mensaje de éxito
                JOptionPane.showMessageDialog(null, "Datos exportados exitosamente a PDF.");
            } else {
                // Si no se encuentra la venta
                JOptionPane.showMessageDialog(null, "No se encontró la venta con el código: " + cod_venta);
            }
        } catch (Exception ex) {
            // Manejar error al exportar
            JOptionPane.showMessageDialog(null, "Error al exportar los datos: " + ex.getMessage());
        }
    } else {
        // No se ha seleccionado ninguna fila
        JOptionPane.showMessageDialog(null, "Por favor, seleccione una fila para exportar.");
    }
}

  
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }
    @Override
    public void keyPressed(KeyEvent e) {
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getSource()==VistaCrudVen.txt_busqueda){
            String ape_paci = VistaCrudVen.txt_busqueda.getText();
            DefaultTableModel modeloT = new DefaultTableModel();
            VistaCrudVen.TABLA_DATOS.setModel(modeloT);
            modeloT.addColumn("Codigo de Resultado");
            modeloT.addColumn("Fecha");
            modeloT.addColumn("Apellido de Empleado");
            modeloT.addColumn("Apellido de Paciente");
            modeloT.addColumn("Nombre del Producto");
            modeloT.addColumn("Urgencia");
            modeloT.addColumn("Codigo Sucursal");
            
            Object[] columna = new Object[7];

            int numRegistros= modeloCrudVen.BuscarVentaxApellidoPaciente(ape_paci).size();
            
            for (int i = 0 ;i < numRegistros ; i++){
                columna[0]=modeloCrudVen.BuscarVentaxApellidoPaciente(ape_paci).get(i).getCod_venta();
                columna[1]=modeloCrudVen.BuscarVentaxApellidoPaciente(ape_paci).get(i).getFecha();
                columna[2]=modeloCrudVen.BuscarVentaxApellidoPaciente(ape_paci).get(i).getEmple_ape();
                columna[3]=modeloCrudVen.BuscarVentaxApellidoPaciente(ape_paci).get(i).getPaci_ape();
                columna[4]=modeloCrudVen.BuscarVentaxApellidoPaciente(ape_paci).get(i).getNom_Producto();
                columna[5]=modeloCrudVen.BuscarVentaxApellidoPaciente(ape_paci).get(i).getNivel_urgencia();
                columna[6]=modeloCrudVen.BuscarVentaxApellidoPaciente(ape_paci).get(i).getCod_sede();
                modeloT.addRow(columna);
            }
        }
    }
}

