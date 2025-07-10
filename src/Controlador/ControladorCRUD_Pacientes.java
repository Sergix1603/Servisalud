package Controlador;
import Modelo_Pacientes.PacienteDAO;
import Vista.Pacientes;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class ControladorCRUD_Pacientes implements ActionListener,KeyListener{
    Pacientes vistaCRUD_Paciente = new Pacientes();
    PacienteDAO modeloCRUD_Paciente = new PacienteDAO();
    
    public ControladorCRUD_Pacientes(Pacientes vistaCRUD_Paciente,PacienteDAO modeloCRUD_Paciente){
        this.modeloCRUD_Paciente = modeloCRUD_Paciente;
        this.vistaCRUD_Paciente = vistaCRUD_Paciente;

        this.vistaCRUD_Paciente.BTN_REGISTRAR4.addActionListener(this);
        this.vistaCRUD_Paciente.BTN_LISTAR.addActionListener(this);
        
        this.vistaCRUD_Paciente.BTN_MODIFICAR.addActionListener(this);
        this.vistaCRUD_Paciente.BTN_ELIMINAR.addActionListener(this);
        this.vistaCRUD_Paciente.BTN_CONFIRMAR.addActionListener(this);
        
        this.vistaCRUD_Paciente.txt_cod_paci1.addKeyListener(this);
        this.vistaCRUD_Paciente.txt_paci_nom.addKeyListener(this);
        this.vistaCRUD_Paciente.txt_paci_ape.addKeyListener(this);
        this.vistaCRUD_Paciente.txt_DNI.addKeyListener(this);
        this.vistaCRUD_Paciente.txt_Peso.addKeyListener(this);
        this.vistaCRUD_Paciente.txt_altura.addKeyListener(this);
        this.vistaCRUD_Paciente.txt_busqueda.addKeyListener(this);
        this.vistaCRUD_Paciente.txt_enfermedad2.addKeyListener(this);
        
        
    }
    public void InicializarCrud(){
        
    }
    public void LLenarTabla(JTable tablaD){
        DefaultTableModel modeloT = new DefaultTableModel();
        tablaD.setModel(modeloT);
        modeloT.addColumn("Codigo");
        modeloT.addColumn("Nombre");
        modeloT.addColumn("Apellido");
        modeloT.addColumn("DNI");
        modeloT.addColumn("Peso");
        modeloT.addColumn("Altura");
        modeloT.addColumn("IMC");
        modeloT.addColumn("Enfermedad");
        modeloT.addColumn("Nivel de Urgencia");
        modeloT.addColumn("Codigo Sucursal");
        Object[] columna = new Object[10];   
        
        int numRegistros= modeloCRUD_Paciente.listPacientes().size();
        for (int i=0;i<numRegistros;i++){
            columna[0]=modeloCRUD_Paciente.listPacientes().get(i).getCod_pacientes();
            columna[1]=modeloCRUD_Paciente.listPacientes().get(i).getNom_paciente();
            columna[2]=modeloCRUD_Paciente.listPacientes().get(i).getApe_paciente();
            columna[3]=modeloCRUD_Paciente.listPacientes().get(i).getDNI();
            columna[4]=modeloCRUD_Paciente.listPacientes().get(i).getPeso();
            columna[5]=modeloCRUD_Paciente.listPacientes().get(i).getAltura();
            columna[6]=modeloCRUD_Paciente.listPacientes().get(i).getIMC();
            columna[7]=modeloCRUD_Paciente.listPacientes().get(i).getEnfermedad();
            columna[8]=modeloCRUD_Paciente.listPacientes().get(i).getNivel_Urgencia();
            columna[9]=modeloCRUD_Paciente.listPacientes().get(i).getCod_Sucursal();
            modeloT.addRow(columna);
        }
        LimpiarElementos();
}
    public void LimpiarElementos(){
        vistaCRUD_Paciente.txt_cod_paci1.setText("");
        vistaCRUD_Paciente.txt_paci_nom.setText("");
        vistaCRUD_Paciente.txt_paci_ape.setText("");
        vistaCRUD_Paciente.txt_DNI.setText("");
        vistaCRUD_Paciente.txt_Peso.setText("");
        vistaCRUD_Paciente.txt_altura.setText("");
        vistaCRUD_Paciente.txt_busqueda.setText("");
        vistaCRUD_Paciente.txt_enfermedad2.setText("");
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vistaCRUD_Paciente.BTN_REGISTRAR4) {
    // Obtener los valores de los campos
    String cod_sucursal = vistaCRUD_Paciente.txt_cod_paci1.getText();
    String name = vistaCRUD_Paciente.txt_paci_nom.getText();
    String subname = vistaCRUD_Paciente.txt_paci_ape.getText();
    String dniStr = vistaCRUD_Paciente.txt_DNI.getText();
    String pesoStr = vistaCRUD_Paciente.txt_Peso.getText();
    String alturaStr = vistaCRUD_Paciente.txt_altura.getText();
    String enfermedad = vistaCRUD_Paciente.txt_enfermedad2.getText();
    String urgencia = (String) vistaCRUD_Paciente.Jcombo_urgencia.getSelectedItem();
    String cod_sede = (String) vistaCRUD_Paciente.Jcombo_sedes.getSelectedItem();

    // Validar campos vacíos
    if (cod_sucursal.isEmpty() || name.isEmpty() || subname.isEmpty() || dniStr.isEmpty() ||
        pesoStr.isEmpty() || alturaStr.isEmpty() || enfermedad.isEmpty() || urgencia == null || cod_sede == null) {
        JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos.");
        return;
    }

    // Validar DNI (solo números y 8 caracteres)
    if (!dniStr.matches("\\d{8}")) {
        JOptionPane.showMessageDialog(null, "El DNI debe ser numérico y contener 8 dígitos.");
        return;
    }

    // Validar Peso (número decimal con máximo 2 decimales)
    if (!pesoStr.matches("\\d+(\\.\\d{1,2})?")) {
        JOptionPane.showMessageDialog(null, "El peso debe ser un número decimal con máximo 2 decimales.");
        return;
    }

    // Validar Altura (número decimal con máximo 2 decimales)
    if (!alturaStr.matches("\\d+(\\.\\d{1,2})?")) {
        JOptionPane.showMessageDialog(null, "La altura debe ser un número decimal con máximo 2 decimales.");
        return;
    }

    // Validar Nombre y Apellido (solo letras)
    if (!name.matches("[a-zA-Z]+") || !subname.matches("[a-zA-Z]+")) {
        JOptionPane.showMessageDialog(null, "El nombre y apellido solo deben contener letras.");
        return;
    }

    // Convertir los valores de texto a sus respectivos tipos (int, double)
    int dni = Integer.parseInt(dniStr);
    double peso = Double.parseDouble(pesoStr);
    double altura = Double.parseDouble(alturaStr);

    // Insertar el paciente en la base de datos
    String rptaRegistro = modeloCRUD_Paciente.insertPaciente(cod_sucursal, name, subname, dni, peso, altura, enfermedad, urgencia, cod_sede);

    // Mostrar el resultado del registro
    if (rptaRegistro != null) {
        JOptionPane.showMessageDialog(null, rptaRegistro);
    } else {
        JOptionPane.showMessageDialog(null, "Registro Erroneo");
    }
}
            if(e.getSource()==vistaCRUD_Paciente.BTN_LISTAR){
                LLenarTabla(vistaCRUD_Paciente.TABLA_DATOS);
                JOptionPane.showMessageDialog(null, "Lista de Registros");
            }
            
            if(e.getSource()==vistaCRUD_Paciente.BTN_MODIFICAR){
            int filaEditar = vistaCRUD_Paciente.TABLA_DATOS.getSelectedRow();
            int numFS = vistaCRUD_Paciente.TABLA_DATOS.getSelectedRowCount();
            
            if(filaEditar >= 0 && numFS == 1){
                
                vistaCRUD_Paciente.txt_cod_paci1.setText(String.valueOf(vistaCRUD_Paciente.TABLA_DATOS.getValueAt(filaEditar, 0)));
                vistaCRUD_Paciente.txt_paci_nom.setText(String.valueOf(vistaCRUD_Paciente.TABLA_DATOS.getValueAt(filaEditar, 1)));
                vistaCRUD_Paciente.txt_paci_ape.setText(String.valueOf(vistaCRUD_Paciente.TABLA_DATOS.getValueAt(filaEditar, 2)));
                vistaCRUD_Paciente.txt_DNI.setText(String.valueOf(vistaCRUD_Paciente.TABLA_DATOS.getValueAt(filaEditar, 3)));
                vistaCRUD_Paciente.txt_Peso.setText(String.valueOf(vistaCRUD_Paciente.TABLA_DATOS.getValueAt(filaEditar, 4)));
                vistaCRUD_Paciente.txt_altura.setText(String.valueOf(vistaCRUD_Paciente.TABLA_DATOS.getValueAt(filaEditar, 5)));
                vistaCRUD_Paciente.txt_enfermedad2.setText(String.valueOf(vistaCRUD_Paciente.TABLA_DATOS.getValueAt(filaEditar, 7)));
                String urgencia=String.valueOf(vistaCRUD_Paciente.TABLA_DATOS.getValueAt(filaEditar, 8));
                vistaCRUD_Paciente.Jcombo_urgencia.setSelectedItem(urgencia);
                String sede=String.valueOf(vistaCRUD_Paciente.TABLA_DATOS.getValueAt(filaEditar, 9));
                vistaCRUD_Paciente.Jcombo_sedes.setSelectedItem(sede);
            
                
                vistaCRUD_Paciente.txt_cod_paci1.setEditable(true);
                vistaCRUD_Paciente.BTN_REGISTRAR4.setEnabled(false);
                vistaCRUD_Paciente.BTN_MODIFICAR.setEnabled(false);
                vistaCRUD_Paciente.BTN_ELIMINAR.setEnabled(false);
                vistaCRUD_Paciente.txt_busqueda.setEnabled(false);
            }else{
                JOptionPane.showMessageDialog(null, "Debe seleccionar una fila, almenos una para su edición");
            }
        }
            if(e.getSource() == vistaCRUD_Paciente.BTN_CONFIRMAR){
            
            String cod_sucursal=vistaCRUD_Paciente.txt_cod_paci1.getText();
            String name=vistaCRUD_Paciente.txt_paci_nom.getText();
            String subname=vistaCRUD_Paciente.txt_paci_ape.getText();
            int dni = Integer.parseInt(vistaCRUD_Paciente.txt_DNI.getText());
            Double peso=Double.parseDouble(vistaCRUD_Paciente.txt_Peso.getText());
            Double altura=Double.parseDouble(vistaCRUD_Paciente.txt_altura.getText());
            String enfermedad=vistaCRUD_Paciente.txt_enfermedad2.getText();
            String urgencia = (String)vistaCRUD_Paciente.Jcombo_urgencia.getSelectedItem();
            String cod_sede = (String)vistaCRUD_Paciente.Jcombo_sedes.getSelectedItem();
            
            
            int rptaEdit=modeloCRUD_Paciente.EditarPaciente(cod_sucursal,name,subname,dni,peso,altura,enfermedad,urgencia,cod_sede);
            
            if(rptaEdit>0){
                JOptionPane.showMessageDialog(null, "Modificación Exitosa");
            }else{
                JOptionPane.showMessageDialog(null, "No se pudo realizar la modificacion");
            }
            LimpiarElementos();
            vistaCRUD_Paciente.BTN_REGISTRAR4.setEnabled(true);
            vistaCRUD_Paciente.BTN_MODIFICAR.setEnabled(true);
            vistaCRUD_Paciente.BTN_ELIMINAR.setEnabled(true);
            vistaCRUD_Paciente.txt_busqueda.setEnabled(true);
            vistaCRUD_Paciente.BTN_CONFIRMAR.setEnabled(true);
        }
        if(e.getSource()==vistaCRUD_Paciente.BTN_ELIMINAR){
            int filaInicio = vistaCRUD_Paciente.TABLA_DATOS.getSelectedRow();
            int numFS = vistaCRUD_Paciente.TABLA_DATOS.getSelectedRowCount();
            ArrayList<String> ListaPacientes = new ArrayList();
            String cod_paci="";
            
            if(filaInicio>=0){
                for (int i = 0; i < numFS; i++) {
                    cod_paci=String.valueOf(vistaCRUD_Paciente.TABLA_DATOS.getValueAt(i+filaInicio,0));
                    ListaPacientes.add(cod_paci);
                }
                
                for (int i = 0; i < numFS; i++) {
                    int  RptUsuario = JOptionPane.showConfirmDialog(null,"Quiere eliminar registro con código "+cod_paci+"?");
                    if(RptUsuario==0){
                        modeloCRUD_Paciente.EliminarPaciente(cod_paci);
                    }
                }
                LLenarTabla(vistaCRUD_Paciente.TABLA_DATOS);
            }else{
                JOptionPane.showMessageDialog(null,"Seleccione al menos una fila a eliminar");
            }
        }
    }
    @Override
    public void keyTyped(KeyEvent e) {
        // Validación DNI: solo aceptar números
        if (e.getSource() == vistaCRUD_Paciente.txt_DNI) {
            char c = e.getKeyChar();
            if (c < '0' || c > '9' || vistaCRUD_Paciente.txt_DNI.getText().length() >= 8) {
                e.consume();
            }
        }

        // Validación Nombre y Apellido: solo aceptar letras y espacio
        if (e.getSource() == vistaCRUD_Paciente.txt_paci_nom || e.getSource() == vistaCRUD_Paciente.txt_paci_ape) {
            char c = e.getKeyChar();
            if (!Character.isLetter(c) && c != KeyEvent.VK_SPACE) {
                e.consume();
            }
        }

        // Validación Enfermedad: solo aceptar letras y espacio
        if (e.getSource() == vistaCRUD_Paciente.txt_enfermedad2) {
            char c = e.getKeyChar();
            if (!Character.isLetter(c) && c != KeyEvent.VK_SPACE) {
                e.consume();
            }
        }

        // Validación Peso y Altura: solo aceptar números y el punto decimal
        if (e.getSource() == vistaCRUD_Paciente.txt_Peso || e.getSource() == vistaCRUD_Paciente.txt_altura) {
            char c = e.getKeyChar();
            if (!(Character.isDigit(c) || c == KeyEvent.VK_PERIOD)) {
                e.consume();
            }

            // No permitir más de un punto decimal
            String text = ((javax.swing.JTextField) e.getSource()).getText();
            if (c == KeyEvent.VK_PERIOD && text.contains(".")) {
                e.consume();
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }
    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getSource()==vistaCRUD_Paciente.txt_busqueda){
            String apellido = vistaCRUD_Paciente.txt_busqueda.getText();
            DefaultTableModel modeloT = new DefaultTableModel();
            vistaCRUD_Paciente.TABLA_DATOS.setModel(modeloT);
            modeloT.addColumn("Codigo");
            modeloT.addColumn("Nombre");
            modeloT.addColumn("Apellido");
            modeloT.addColumn("DNI");
            modeloT.addColumn("Peso");
            modeloT.addColumn("Altura");
            modeloT.addColumn("IMC");
            modeloT.addColumn("Enfermedad");
            modeloT.addColumn("Nivel de Urgencia");
            modeloT.addColumn("Codigo Sucursal");
            
            Object[] columna = new Object[10];

            int numRegistros= modeloCRUD_Paciente.BuscarPacientexApellido(apellido).size();
            
            for (int i = 0 ;i < numRegistros ; i++){
                columna[0]=modeloCRUD_Paciente.BuscarPacientexApellido(apellido).get(i).getCod_pacientes();
                columna[1]=modeloCRUD_Paciente.BuscarPacientexApellido(apellido).get(i).getNom_paciente();
                columna[2]=modeloCRUD_Paciente.BuscarPacientexApellido(apellido).get(i).getApe_paciente();
                columna[3]=modeloCRUD_Paciente.BuscarPacientexApellido(apellido).get(i).getDNI();
                columna[4]=modeloCRUD_Paciente.BuscarPacientexApellido(apellido).get(i).getPeso();
                columna[5]=modeloCRUD_Paciente.BuscarPacientexApellido(apellido).get(i).getAltura();
                columna[6]=modeloCRUD_Paciente.BuscarPacientexApellido(apellido).get(i).getIMC();
                columna[7]=modeloCRUD_Paciente.BuscarPacientexApellido(apellido).get(i).getEnfermedad();
                columna[8]=modeloCRUD_Paciente.BuscarPacientexApellido(apellido).get(i).getNivel_Urgencia();
                columna[9]=modeloCRUD_Paciente.BuscarPacientexApellido(apellido).get(i).getCod_Sucursal();
                modeloT.addRow(columna);
            }
        }
    }   
}