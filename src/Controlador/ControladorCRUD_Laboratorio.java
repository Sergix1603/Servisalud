package Controlador;

import Modelo_Laboratorio.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Vista.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ControladorCRUD_Laboratorio implements ActionListener,KeyListener{
    Laboratorios VistaCrudLab = new Laboratorios();
    LaboratorioDAO modeloCrudlba = new LaboratorioDAO();
    
    
    public ControladorCRUD_Laboratorio(Laboratorios VistaCrudLab,LaboratorioDAO modeloCrudlba){
        this.VistaCrudLab=VistaCrudLab;
        this.modeloCrudlba=modeloCrudlba;
        this.VistaCrudLab.BTN_REGISTRAR4.addActionListener(this);
        this.VistaCrudLab.BTN_LISTAR.addActionListener(this);
        
        this.VistaCrudLab.BTN_MODIFICAR.addActionListener(this);
        this.VistaCrudLab.BTN_ELIMINAR.addActionListener(this);
        this.VistaCrudLab.BTN_CONFIRMAR.addActionListener(this);
        
        this.VistaCrudLab.txt_cod_lab.addKeyListener(this);
        this.VistaCrudLab.TXT_Nombre_repartidor.addKeyListener(this);
        this.VistaCrudLab.TXT_Apellido_repartidor.addKeyListener(this);
        this.VistaCrudLab.txt_RUC_Lab.addKeyListener(this);
        this.VistaCrudLab.txt_TELEFONO.addKeyListener(this);
        this.VistaCrudLab.txt_Busqueda.addKeyListener(this);
        this.VistaCrudLab.txt_marca.addKeyListener(this);
        this.VistaCrudLab.Jcombo_sedes.addKeyListener(this);
    }
    public void InicializarCrud(){
        
    }
    public void LLenarTabla(JTable tablaD) {
    DefaultTableModel modeloT = new DefaultTableModel();
    tablaD.setModel(modeloT);
    modeloT.addColumn("Codigo de Laboratorio");
    modeloT.addColumn("Nombre del Repartidor");
    modeloT.addColumn("Apellido del Repartidor");
    modeloT.addColumn("RUC");
    modeloT.addColumn("MARCA");
    modeloT.addColumn("TELEFONO");
    modeloT.addColumn("CODIGO DE SEDE");

    ArrayList<laboratorio> laboratorios = modeloCrudlba.listLaboratorio();
    for (laboratorio lab : laboratorios) {
        Object[] columna = {
            lab.getCod_lab(),
            lab.getNom_lab(),
            lab.getApe_lab(),
            lab.getRuc(),
            lab.getMarca(),
            lab.getTelefono(),
            lab.getCod_sede()
        };
        modeloT.addRow(columna);
    }
    LimpiarElementos();
}
    public void LimpiarElementos(){
        VistaCrudLab.txt_cod_lab.setText("");
        VistaCrudLab.TXT_Nombre_repartidor.setText("");
        VistaCrudLab.TXT_Apellido_repartidor.setText("");
        VistaCrudLab.txt_RUC_Lab.setText("");
        VistaCrudLab.txt_TELEFONO.setText("");
        VistaCrudLab.txt_marca.setText("");
    }
    
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==VistaCrudLab.BTN_REGISTRAR4){
        // Obtener datos de la vista
        String cod_lab = VistaCrudLab.txt_cod_lab.getText();
        String Nom_lab = VistaCrudLab.TXT_Nombre_repartidor.getText();
        String Ape_lab = VistaCrudLab.TXT_Apellido_repartidor.getText();
        String RUC = VistaCrudLab.txt_RUC_Lab.getText();
        String marca = VistaCrudLab.txt_marca.getText();
        String telefono = VistaCrudLab.txt_TELEFONO.getText();
        String cod_sede = (String)VistaCrudLab.Jcombo_sedes.getSelectedItem();

        // Validación de campos vacíos
        if (cod_lab.isEmpty() || Nom_lab.isEmpty() || Ape_lab.isEmpty() || RUC.isEmpty() || marca.isEmpty() || telefono.isEmpty() || cod_sede.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Todos los campos deben ser completados.");
            return; // Detener la ejecución si hay campos vacíos
        }

        // Validación del RUC (solo números)
        if (!RUC.matches("[0-9]+")) {
            JOptionPane.showMessageDialog(null, "El RUC debe contener solo números.");
            return; // Detener la ejecución si el RUC no es válido
        }

        // Validación de nombre, apellido, y marca (solo letras y espacios)
        if (!Nom_lab.matches("[a-zA-Z ]+")) {
            JOptionPane.showMessageDialog(null, "El nombre del repartidor debe contener solo letras.");
            return; // Detener la ejecución si el nombre no es válido
        }
        if (!Ape_lab.matches("[a-zA-Z ]+")) {
            JOptionPane.showMessageDialog(null, "El apellido del repartidor debe contener solo letras.");
            return; // Detener la ejecución si el apellido no es válido
        }
        if (!marca.matches("[a-zA-Z ]+")) {
            JOptionPane.showMessageDialog(null, "La marca debe contener solo letras.");
            return; // Detener la ejecución si la marca no es válida
        }

        // Validación del teléfono (solo números)
        if (!telefono.matches("[0-9]+")) {
            JOptionPane.showMessageDialog(null, "El teléfono debe contener solo números.");
            return; // Detener la ejecución si el teléfono no es válido
        }

        // Proceder con el registro si todas las validaciones son correctas
        String rptaRegistro = modeloCrudlba.insertLaboratorio(cod_lab, Nom_lab, Ape_lab, RUC, marca, telefono, cod_sede);

        if (rptaRegistro != null) {
            JOptionPane.showMessageDialog(null, rptaRegistro);
        } else {
            JOptionPane.showMessageDialog(null, "Registro Erroneo");
        }
    }
        if(e.getSource()==VistaCrudLab.BTN_LISTAR){
            LLenarTabla(VistaCrudLab.TABLA_DATOS);
            JOptionPane.showMessageDialog(null, "Lista de Registros");
        }
        if(e.getSource()==VistaCrudLab.BTN_MODIFICAR){
            int filaEditar = VistaCrudLab.TABLA_DATOS.getSelectedRow();
            int numFS = VistaCrudLab.TABLA_DATOS.getSelectedRowCount();
            
            if(filaEditar >= 0 && numFS == 1){
                
                VistaCrudLab.txt_cod_lab.setText(String.valueOf(VistaCrudLab.TABLA_DATOS.getValueAt(filaEditar, 0)));
                VistaCrudLab.TXT_Nombre_repartidor.setText(String.valueOf(VistaCrudLab.TABLA_DATOS.getValueAt(filaEditar, 1)));
                VistaCrudLab.TXT_Apellido_repartidor.setText(String.valueOf(VistaCrudLab.TABLA_DATOS.getValueAt(filaEditar, 2)));
                VistaCrudLab.txt_RUC_Lab.setText(String.valueOf(VistaCrudLab.TABLA_DATOS.getValueAt(filaEditar, 3)));
                VistaCrudLab.txt_marca.setText(String.valueOf(VistaCrudLab.TABLA_DATOS.getValueAt(filaEditar, 4)));
                VistaCrudLab.txt_TELEFONO.setText(String.valueOf(VistaCrudLab.TABLA_DATOS.getValueAt(filaEditar, 5)));
                String sede=String.valueOf(VistaCrudLab.TABLA_DATOS.getValueAt(filaEditar, 6));
                VistaCrudLab.Jcombo_sedes.setSelectedItem(sede);
                
                VistaCrudLab.txt_cod_lab.setEditable(false);
                VistaCrudLab.BTN_REGISTRAR4.setEnabled(false);
                VistaCrudLab.BTN_MODIFICAR.setEnabled(false);
                VistaCrudLab.BTN_ELIMINAR.setEnabled(false);
                VistaCrudLab.txt_Busqueda.setEnabled(false);
            }else{
                JOptionPane.showMessageDialog(null, "Debe seleccionar una fila, almenos una para su edición");
            }
        }
        if(e.getSource() == VistaCrudLab.BTN_CONFIRMAR){
            
            String cod_lab=VistaCrudLab.txt_cod_lab.getText();
            String nom_lab=VistaCrudLab.TXT_Nombre_repartidor.getText();
            String apellido=VistaCrudLab.TXT_Apellido_repartidor.getText();
            String ruc=VistaCrudLab.txt_RUC_Lab.getText();
            String marca=VistaCrudLab.txt_marca.getText();
            String telefono=VistaCrudLab.txt_TELEFONO.getText();
            String cod_sede = (String) VistaCrudLab.Jcombo_sedes.getSelectedItem();
            
            
            int rptaEdit = modeloCrudlba.editarLaboratorio(cod_lab, nom_lab, apellido, ruc, marca, telefono, cod_sede);
            manejarRespuestaModificacion(rptaEdit);
            LimpiarElementos();
            
            if(rptaEdit>0){
                JOptionPane.showMessageDialog(null, "Modificación Exitosa");
            }else{
                JOptionPane.showMessageDialog(null, "No se pudo realizar la modificacion");
            }
            LimpiarElementos();
            VistaCrudLab.BTN_REGISTRAR4.setEnabled(true);
            VistaCrudLab.BTN_MODIFICAR.setEnabled(true);
            VistaCrudLab.BTN_ELIMINAR.setEnabled(true);
            VistaCrudLab.txt_Busqueda.setEnabled(true);
            VistaCrudLab.BTN_CONFIRMAR.setEnabled(true);
        }
        if(e.getSource()==VistaCrudLab.BTN_ELIMINAR){
            int filaInicio = VistaCrudLab.TABLA_DATOS.getSelectedRow();
            int numFS = VistaCrudLab.TABLA_DATOS.getSelectedRowCount();
            ArrayList<String> ListaLaboratorios = new ArrayList();
            String cod_Laboratorios="";
            
            if(filaInicio>=0){
                for (int i = 0; i < numFS; i++) {
                    cod_Laboratorios=String.valueOf(VistaCrudLab.TABLA_DATOS.getValueAt(i+filaInicio,0));
                    ListaLaboratorios.add(cod_Laboratorios);
                }
                
                for (int i = 0; i < numFS; i++) {
                    int  RptUsuario = JOptionPane.showConfirmDialog(null,"Quiere eliminar registro con código "+cod_Laboratorios+"?");
                    if(RptUsuario==0){
                        modeloCrudlba.eliminarLaboratorio(cod_Laboratorios);
                    }
                }
                LLenarTabla(VistaCrudLab.TABLA_DATOS);
            }else{
                JOptionPane.showMessageDialog(null,"Seleccione al menos una fila a eliminar");
            }
        }
    }
    private void manejarRespuestaModificacion(int rptaEdit) {
    if (rptaEdit > 0) {
        JOptionPane.showMessageDialog(null, "Modificación Exitosa");
        LLenarTabla(VistaCrudLab.TABLA_DATOS); // Recarga la tabla
    } else {
        JOptionPane.showMessageDialog(null, "No se pudo realizar la modificación");
    }
}


    @Override
public void keyTyped(KeyEvent e) {
    // Validar solo números para el teléfono
    if (e.getSource() == VistaCrudLab.txt_TELEFONO) {
        char c = e.getKeyChar();
        if (c < '0' || c > '9') {
            e.consume(); // Evita que se ingresen caracteres no numéricos
        }
    }

    // Validar solo letras para nombre y apellido
    if (e.getSource() == VistaCrudLab.TXT_Nombre_repartidor || e.getSource() == VistaCrudLab.TXT_Apellido_repartidor || e.getSource() == VistaCrudLab.txt_marca) {
        char c = e.getKeyChar();
        if ((c < 'a' || c > 'z') && (c < 'A' || c > 'Z') && (c != (char) KeyEvent.VK_SPACE)) {
            e.consume(); // Evita que se ingresen caracteres no alfabéticos o espacios
        }
    }
}


    @Override
    public void keyPressed(KeyEvent e) {
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
    if (e.getSource() == VistaCrudLab.txt_Busqueda) {
        String marca = VistaCrudLab.txt_Busqueda.getText();
        ArrayList<laboratorio> laboratorios = modeloCrudlba.buscarLaboratorioxMarca(marca);
        DefaultTableModel modeloT = new DefaultTableModel();
        VistaCrudLab.TABLA_DATOS.setModel(modeloT);
        modeloT.addColumn("Codigo de Laboratorio");
        modeloT.addColumn("Nombre del Repartidor");
        modeloT.addColumn("Apellido del Repartidor");
        modeloT.addColumn("RUC");
        modeloT.addColumn("MARCA");
        modeloT.addColumn("TELEFONO");
        modeloT.addColumn("CODIGO DE SEDE");

        for (laboratorio lab : laboratorios) {
            Object[] columna = {
                lab.getCod_lab(),
                lab.getNom_lab(),
                lab.getApe_lab(),
                lab.getRuc(),
                lab.getMarca(),
                lab.getTelefono(),
                lab.getCod_sede()
            };
            modeloT.addRow(columna);
        }
    }
}
    
    
}
