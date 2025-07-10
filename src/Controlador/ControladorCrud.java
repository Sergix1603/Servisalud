package Controlador;
import Modelo_Sucursal.Sucursal;
import Modelo_Sucursal.SucursalDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Vista.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class ControladorCrud implements ActionListener,KeyListener{
    
    Sucursales vistaCRUD = new Sucursales();
    SucursalDAO modeloCRUD = new SucursalDAO();
    
    public ControladorCrud(Sucursales vistaCRUD,SucursalDAO modeloCRUD){
        this.modeloCRUD=modeloCRUD;
        this.vistaCRUD = vistaCRUD;
        
        this.vistaCRUD.BTN_REGISTRAR.addActionListener(this);
        this.vistaCRUD.BTN_LISTAR.addActionListener(this);
        
        this.vistaCRUD.BTN_MODIFICAR.addActionListener(this);
        this.vistaCRUD.BTN_ELIMINAR.addActionListener(this);
        this.vistaCRUD.BTN_Confirmar.addActionListener(this);
        
        this.vistaCRUD.txt_RUC_SUCURSAL.addKeyListener(this);
        this.vistaCRUD.TXT_DEPARTAMENTO.addKeyListener(this);
        this.vistaCRUD.TXT_DIRECCION.addKeyListener(this);
        this.vistaCRUD.TXT_TELEFONO.addKeyListener(this);
        this.vistaCRUD.TXT_Busqueda.addKeyListener(this);
        
        
    }
    public void InicializarCrud(){
        
    }
    public void LLenarTabla(JTable tablaD){
        DefaultTableModel modeloT = new DefaultTableModel();
        tablaD.setModel(modeloT);
        modeloT.addColumn("CODIGO");
        modeloT.addColumn("RUC");
        modeloT.addColumn("DEPARTAMENTO");
        modeloT.addColumn("DIRECCION");
        modeloT.addColumn("TELEFONO");
        Object[] columna = new Object[5];
        
        ArrayList<Sucursal> sucursales = modeloCRUD.listSucursal();
        for (Sucursal sucursal : sucursales) {
            columna[0] = sucursal.getCod_sucursal();
            columna[1] = sucursal.getRUC();
            columna[2] = sucursal.getDepartamento();
            columna[3] = sucursal.getDireccion();
            columna[4] = sucursal.getTelefono();
            modeloT.addRow(columna);
                }
                LimpiarElementos();
    }
    public void LimpiarElementos(){
        vistaCRUD.txt_cod_sucursal.setText("");
        vistaCRUD.txt_cod_sucursal.setEditable(true);
        vistaCRUD.txt_RUC_SUCURSAL.setText("");
        vistaCRUD.TXT_DEPARTAMENTO.setText("");
        vistaCRUD.TXT_DIRECCION.setText("");
        vistaCRUD.TXT_TELEFONO.setText("");
    }
    
    
    public void actionPerformed(ActionEvent e){
        if (e.getSource() == vistaCRUD.BTN_REGISTRAR) {
        // Obtener los valores de los campos
        String cod_sucursal = vistaCRUD.txt_cod_sucursal.getText();
        String RUC = vistaCRUD.txt_RUC_SUCURSAL.getText();
        String departamento = vistaCRUD.TXT_DEPARTAMENTO.getText();
        String direccion = vistaCRUD.TXT_DIRECCION.getText();
        String telefono = vistaCRUD.TXT_TELEFONO.getText();

        // Validar si alguno de los campos está vacío
        if (cod_sucursal.isEmpty() || RUC.isEmpty() || departamento.isEmpty() || direccion.isEmpty() || telefono.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Todos los campos deben estar completos.");
            return;  // Detener el método si algún campo está vacío
        }

        // Si los campos están completos, realizar el registro
        String rptaRegistro = modeloCRUD.insertSucursal(cod_sucursal, RUC, departamento, direccion, telefono);
        if (rptaRegistro != null) {
            JOptionPane.showMessageDialog(null, rptaRegistro);
        } else {
            JOptionPane.showMessageDialog(null, "Registro Erróneo");
        }
    }
        if(e.getSource()==vistaCRUD.BTN_LISTAR){
            LLenarTabla(vistaCRUD.TABLA_DATOS);
            JOptionPane.showMessageDialog(null, "Lista de Registros");
        }
        
        if(e.getSource()==vistaCRUD.BTN_MODIFICAR){
            int filaEditar = vistaCRUD.TABLA_DATOS.getSelectedRow();
            int numFS = vistaCRUD.TABLA_DATOS.getSelectedRowCount();
            
            if(filaEditar >= 0 && numFS == 1){
                
                vistaCRUD.txt_cod_sucursal.setText(String.valueOf(vistaCRUD.TABLA_DATOS.getValueAt(filaEditar, 0)));
                vistaCRUD.txt_RUC_SUCURSAL.setText(String.valueOf(vistaCRUD.TABLA_DATOS.getValueAt(filaEditar, 1)));
                vistaCRUD.TXT_DEPARTAMENTO.setText(String.valueOf(vistaCRUD.TABLA_DATOS.getValueAt(filaEditar, 2)));
                vistaCRUD.TXT_DIRECCION.setText(String.valueOf(vistaCRUD.TABLA_DATOS.getValueAt(filaEditar, 3)));
                vistaCRUD.TXT_TELEFONO.setText(String.valueOf(vistaCRUD.TABLA_DATOS.getValueAt(filaEditar, 4)));
                
                vistaCRUD.txt_cod_sucursal.setEditable(false);
                vistaCRUD.BTN_REGISTRAR.setEnabled(false);
                vistaCRUD.BTN_MODIFICAR.setEnabled(false);
                vistaCRUD.BTN_ELIMINAR.setEnabled(false);
                vistaCRUD.TXT_Busqueda.setEnabled(false);
            }else{
                JOptionPane.showMessageDialog(null, "Debe seleccionar una fila, almenos una para su edición");
            }
        }
        
        if(e.getSource() == vistaCRUD.BTN_Confirmar){
            
            String cod_sucursal=vistaCRUD.txt_cod_sucursal.getText();
            String RUC=vistaCRUD.txt_RUC_SUCURSAL.getText();
            String departamento=vistaCRUD.TXT_DEPARTAMENTO.getText();
            String direccion=vistaCRUD.TXT_DIRECCION.getText();
            String telefono=vistaCRUD.TXT_TELEFONO.getText();
            
            int rptaEdit=modeloCRUD.EditarSucursal(cod_sucursal, RUC, departamento, direccion, telefono);
            
            if(rptaEdit>0){
                JOptionPane.showMessageDialog(null, "Modificación Exitosa");
            }else{
                JOptionPane.showMessageDialog(null, "No se pudo realizar la modificacion");
            }
            LimpiarElementos();
            vistaCRUD.BTN_REGISTRAR.setEnabled(true);
            vistaCRUD.BTN_MODIFICAR.setEnabled(true);
            vistaCRUD.BTN_ELIMINAR.setEnabled(true);
            vistaCRUD.TXT_Busqueda.setEnabled(true);
            vistaCRUD.BTN_Confirmar.setEnabled(true);
        }
        
        if(e.getSource()==vistaCRUD.BTN_ELIMINAR){
            int filaInicio = vistaCRUD.TABLA_DATOS.getSelectedRow();
            int numFS = vistaCRUD.TABLA_DATOS.getSelectedRowCount();
            ArrayList<String> ListaSucursales = new ArrayList();
            String cod_sucursales="";
            
            if(filaInicio>=0){
                for (int i = 0; i < numFS; i++) {
                    cod_sucursales=String.valueOf(vistaCRUD.TABLA_DATOS.getValueAt(i+filaInicio,0));
                    ListaSucursales.add(cod_sucursales);
                }
                
                for (int i = 0; i < numFS; i++) {
                    int  RptUsuario = JOptionPane.showConfirmDialog(null,"Quiere eliminar registro con código "+cod_sucursales+"?");
                    if(RptUsuario==0){
                        modeloCRUD.EliminarSucursal(cod_sucursales);
                    }
                }
                LLenarTabla(vistaCRUD.TABLA_DATOS);
            }else{
                JOptionPane.showMessageDialog(null,"Seleccione al menos una fila a eliminar");
            }
        }
    }

    @Override
public void keyTyped(KeyEvent e) {
    // Validación para el código de la sucursal (acepta números del 0 al 5)
    if (e.getSource() == vistaCRUD.txt_cod_sucursal) {
        char c = e.getKeyChar();
        if (c < '0' || c > '5') {
            e.consume();
        }
    }

    // Validación para el campo RUC (solo números y máximo de 11 dígitos)
    if (e.getSource() == vistaCRUD.txt_RUC_SUCURSAL) {
        char c = e.getKeyChar();
        if (!Character.isDigit(c)) {
            e.consume();
            JOptionPane.showMessageDialog(null, "El RUC solo acepta números.");
        }
        if (vistaCRUD.txt_RUC_SUCURSAL.getText().length() >= 11) {
            e.consume();
            JOptionPane.showMessageDialog(null, "El RUC no puede tener más de 11 dígitos.");
        }
    }

    // Validación para el campo teléfono (solo números)
    if (e.getSource() == vistaCRUD.TXT_TELEFONO) {
        char c = e.getKeyChar();
        if (!Character.isDigit(c)) {
            e.consume();
            JOptionPane.showMessageDialog(null, "El teléfono solo acepta números.");
        }
    }

    // Validación para el campo departamento (solo letras y espacios)
    if (e.getSource() == vistaCRUD.TXT_DEPARTAMENTO) {
        char c = e.getKeyChar();
        if (!Character.isLetter(c) && c != (char) KeyEvent.VK_SPACE) {
            e.consume();
            JOptionPane.showMessageDialog(null, "El departamento solo acepta letras y espacios.");
        }
    }
}


    @Override
    public void keyPressed(KeyEvent e) {
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getSource() == vistaCRUD.TXT_Busqueda) {
        String departamento = vistaCRUD.TXT_Busqueda.getText();
        DefaultTableModel modeloT = new DefaultTableModel();
        vistaCRUD.TABLA_DATOS.setModel(modeloT);
        modeloT.addColumn("CODIGO");
        modeloT.addColumn("RUC");
        modeloT.addColumn("DEPARTAMENTO");
        modeloT.addColumn("DIRECCION");
        modeloT.addColumn("TELEFONO");
        
        Object[] columna = new Object[5];

        ArrayList<Sucursal> resultados = modeloCRUD.BuscarSucursalxDepartamento(departamento);
        for (Sucursal sucursal : resultados) {
            columna[0] = sucursal.getCod_sucursal();
            columna[1] = sucursal.getRUC();
            columna[2] = sucursal.getDepartamento();
            columna[3] = sucursal.getDireccion();
            columna[4] = sucursal.getTelefono();
            modeloT.addRow(columna);
        }
    }
    }
}
