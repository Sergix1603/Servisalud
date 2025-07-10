package Controlador;

import Modelo_Empleados.EmpleadoDAO;
import Vista.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class ControladorCRUD_Empleados implements ActionListener, KeyListener {
    private Empleados vistaCrudEmple;
    private EmpleadoDAO modeloCrudEmple;

    public ControladorCRUD_Empleados(Empleados vistaCrudEmple, EmpleadoDAO modeloCrudEmple) {
        this.vistaCrudEmple = vistaCrudEmple;
        this.modeloCrudEmple = modeloCrudEmple;

        // Registrar los listeners para los botones
        this.vistaCrudEmple.BTN_REGISTRAR.addActionListener(this);
        this.vistaCrudEmple.BTN_LISTAR.addActionListener(this);
        this.vistaCrudEmple.BTN_MODIFICAR.addActionListener(this);
        this.vistaCrudEmple.BTN_ELIMINAR.addActionListener(this);
        this.vistaCrudEmple.BTN_Confirmar.addActionListener(this);
        
        // Registrar los listeners para los campos de texto
        this.vistaCrudEmple.txt_cod_emple3.addKeyListener(this);
        this.vistaCrudEmple.txt_nom_emple.addKeyListener(this);
        this.vistaCrudEmple.txt_ape_emple.addKeyListener(this);
        this.vistaCrudEmple.txt_DNI1.addKeyListener(this);
        this.vistaCrudEmple.txt_Especialidad.addKeyListener(this);
        this.vistaCrudEmple.txt_Busqueda.addKeyListener(this);
        this.vistaCrudEmple.Jcombo_sedes.addKeyListener(this);
    }

    public void llenarTabla(JTable tablaD) {
        DefaultTableModel modeloT = new DefaultTableModel();
        tablaD.setModel(modeloT);
        modeloT.addColumn("Código");
        modeloT.addColumn("Nombre");
        modeloT.addColumn("Apellido");
        modeloT.addColumn("DNI");
        modeloT.addColumn("Especialidad");
        modeloT.addColumn("Código Sucursal");

        Object[] columna = new Object[6];
        ArrayList<Modelo_Empleados.Empleados> listaEmpleados = modeloCrudEmple.listEmpleados();

        for (Modelo_Empleados.Empleados empleado : listaEmpleados) {
            columna[0] = empleado.getCod_empleado();
            columna[1] = empleado.getEmple_nom();
            columna[2] = empleado.getEmple_ape();
            columna[3] = empleado.getDNI();
            columna[4] = empleado.getEspecialidad();
            columna[5] = empleado.getCod_sucursal();
            modeloT.addRow(columna);
        }

        limpiarElementos();
    }

    public void limpiarElementos() {
        vistaCrudEmple.txt_cod_emple3.setText("");
        vistaCrudEmple.txt_nom_emple.setText("");
        vistaCrudEmple.txt_ape_emple.setText("");
        vistaCrudEmple.txt_DNI1.setText("");
        vistaCrudEmple.txt_Especialidad.setText("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source == vistaCrudEmple.BTN_REGISTRAR) {
            registrarEmpleado();
        } else if (source == vistaCrudEmple.BTN_LISTAR) {
            llenarTabla(vistaCrudEmple.TABLA_DATOS);
            JOptionPane.showMessageDialog(null, "Lista de Registros");
        } else if (source == vistaCrudEmple.BTN_MODIFICAR) {
            cargarDatosEmpleado();
        } else if (source == vistaCrudEmple.BTN_Confirmar) {
            modificarEmpleado();
        } else if (source == vistaCrudEmple.BTN_ELIMINAR) {
            eliminarEmpleados();
        }
    }

    private void registrarEmpleado() {
    // Obtener los valores de los campos
    String codEmpleado = vistaCrudEmple.txt_cod_emple3.getText();
    String nombre = vistaCrudEmple.txt_nom_emple.getText();
    String apellido = vistaCrudEmple.txt_ape_emple.getText();
    String dni = vistaCrudEmple.txt_DNI1.getText();
    String especialidad = vistaCrudEmple.txt_Especialidad.getText();
    String codSucursal = (String) vistaCrudEmple.Jcombo_sedes.getSelectedItem();

    // Verificar si algún campo está vacío
    if (codEmpleado.isEmpty() || nombre.isEmpty() || apellido.isEmpty() || dni.isEmpty() || especialidad.isEmpty() || codSucursal == null) {
        JOptionPane.showMessageDialog(null, "Todos los campos deben estar completos.");
        return;  // Salir del método sin continuar con el registro
    }

    // Proceder con el registro si todos los campos están completos
    String respuesta = modeloCrudEmple.insertEmpleado(codEmpleado, nombre, apellido, dni, especialidad, codSucursal);
    JOptionPane.showMessageDialog(null, respuesta != null ? respuesta : "Registro Erróneo");
}


    private void cargarDatosEmpleado() {
        int filaEditar = vistaCrudEmple.TABLA_DATOS.getSelectedRow();

        if (filaEditar >= 0) {
            vistaCrudEmple.txt_cod_emple3.setText(String.valueOf(vistaCrudEmple.TABLA_DATOS.getValueAt(filaEditar, 0)));
            vistaCrudEmple.txt_nom_emple.setText(String.valueOf(vistaCrudEmple.TABLA_DATOS.getValueAt(filaEditar, 1)));
            vistaCrudEmple.txt_ape_emple.setText(String.valueOf(vistaCrudEmple.TABLA_DATOS.getValueAt(filaEditar, 2)));
            vistaCrudEmple.txt_DNI1.setText(String.valueOf(vistaCrudEmple.TABLA_DATOS.getValueAt(filaEditar, 3)));
            vistaCrudEmple.txt_Especialidad.setText(String.valueOf(vistaCrudEmple.TABLA_DATOS.getValueAt(filaEditar, 4)));
            String sucursal = String.valueOf(vistaCrudEmple.TABLA_DATOS.getValueAt(filaEditar, 5));
            vistaCrudEmple.Jcombo_sedes.setSelectedItem(sucursal);
            
            vistaCrudEmple.txt_cod_emple3.setEditable(false);
            vistaCrudEmple.BTN_REGISTRAR.setEnabled(false);
            vistaCrudEmple.BTN_MODIFICAR.setEnabled(false);
            vistaCrudEmple.BTN_ELIMINAR.setEnabled(false);
            vistaCrudEmple.txt_Busqueda.setEnabled(false);
        } else {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una fila para su edición");
        }
    }

    private void modificarEmpleado() {
        String codEmpleado = vistaCrudEmple.txt_cod_emple3.getText();
        String nombre = vistaCrudEmple.txt_nom_emple.getText();
        String apellido = vistaCrudEmple.txt_ape_emple.getText();
        String dni = vistaCrudEmple.txt_DNI1.getText();
        String especialidad = vistaCrudEmple.txt_Especialidad.getText();
        String codSucursal = (String) vistaCrudEmple.Jcombo_sedes.getSelectedItem();

        int respuesta = modeloCrudEmple.editarEmpleado(codEmpleado, nombre, apellido, dni, especialidad, codSucursal);
        
        if (respuesta > 0) {
            JOptionPane.showMessageDialog(null, "Modificación Exitosa");
        } else {
            JOptionPane.showMessageDialog(null, "No se pudo realizar la modificación");
        }

        limpiarElementos();
        habilitarBotones();
    }

    private void habilitarBotones() {
        vistaCrudEmple.BTN_REGISTRAR.setEnabled(true);
        vistaCrudEmple.BTN_MODIFICAR.setEnabled(true);
        vistaCrudEmple.BTN_ELIMINAR.setEnabled(true);
        vistaCrudEmple.txt_Busqueda.setEnabled(true);
        vistaCrudEmple.BTN_Confirmar.setEnabled(true);
    }

    private void eliminarEmpleados() {
        int filaInicio = vistaCrudEmple.TABLA_DATOS.getSelectedRow();
        int numFS = vistaCrudEmple.TABLA_DATOS.getSelectedRowCount();

        if (filaInicio >= 0) {
            ArrayList<String> listaEmpleados = new ArrayList<>();
            for (int i = 0; i < numFS; i++) {
                String codEmpleado = String.valueOf(vistaCrudEmple.TABLA_DATOS.getValueAt(i + filaInicio, 0));
                listaEmpleados.add(codEmpleado);
            }

            int respuesta = JOptionPane.showConfirmDialog(null, "¿Está seguro de que quiere eliminar los siguientes registros: " + listaEmpleados + "?");
            if (respuesta == JOptionPane.YES_OPTION) {
                for (String codEmpleado : listaEmpleados) {
                    modeloCrudEmple.eliminarEmpleado(codEmpleado);
                }
                llenarTabla(vistaCrudEmple.TABLA_DATOS);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione al menos una fila a eliminar");
        }
    }

    @Override
public void keyTyped(KeyEvent e) {
    // Validación del campo DNI para que solo acepte números y tenga un máximo de 8 caracteres
    if (e.getSource() == vistaCrudEmple.txt_DNI1) {
        char c = e.getKeyChar();
        String dniText = vistaCrudEmple.txt_DNI1.getText();
        
        // Permitir solo números y bloquear más de 8 caracteres
        if (!Character.isDigit(c) || dniText.length() >= 8) {
            e.consume();  // No permite caracteres fuera del rango 0-9 o más de 8 caracteres
        }
    }
    
    // Validación del campo Nombre para que solo acepte letras
    if (e.getSource() == vistaCrudEmple.txt_nom_emple) {
        char c = e.getKeyChar();
        
        // Verificar que sea una letra (mayúscula o minúscula)
        if (!Character.isLetter(c) && c != ' ') {  // Permitir espacios
            e.consume();  // Si no es letra, cancelar la entrada
        }
    }
    
    // Validación del campo Apellido para que solo acepte letras
    if (e.getSource() == vistaCrudEmple.txt_ape_emple) {
        char c = e.getKeyChar();
        
        // Verificar que sea una letra (mayúscula o minúscula)
        if (!Character.isLetter(c) && c != ' ') {  // Permitir espacios
            e.consume();  // Si no es letra, cancelar la entrada
        }
    }
}

    @Override
    public void keyPressed(KeyEvent e) {
        // Método vacío, se puede implementar si es necesario
    }

    @Override
public void keyReleased(KeyEvent e) {
    // Validación de los campos para que no queden vacíos
    if (e.getSource() == vistaCrudEmple.txt_cod_emple3 ||
        e.getSource() == vistaCrudEmple.txt_nom_emple ||
        e.getSource() == vistaCrudEmple.txt_ape_emple ||
        e.getSource() == vistaCrudEmple.txt_DNI1 ||
        e.getSource() == vistaCrudEmple.txt_Especialidad ||
        e.getSource() == vistaCrudEmple.Jcombo_sedes) {

        // Verificar si algún campo está vacío y lanzar mensaje si es necesario
        if (isAnyFieldEmpty()) {
            JOptionPane.showMessageDialog(null, "Todos los campos deben estar completos.");
        }
    }
    
    // Búsqueda de empleados por especialidad
    if (e.getSource() == vistaCrudEmple.txt_Busqueda) {
        String especialidad = vistaCrudEmple.txt_Busqueda.getText();
        ArrayList<Modelo_Empleados.Empleados> listaBuscada = modeloCrudEmple.BuscarEmpleadoxEspecialidad(especialidad);

        DefaultTableModel modeloT = new DefaultTableModel();
        vistaCrudEmple.TABLA_DATOS.setModel(modeloT);
        modeloT.addColumn("Código");
        modeloT.addColumn("Nombre");
        modeloT.addColumn("Apellido");
        modeloT.addColumn("DNI");
        modeloT.addColumn("Especialidad");
        modeloT.addColumn("Código Sucursal");

        for (Modelo_Empleados.Empleados empleado : listaBuscada) {
            Object[] columna = new Object[6];
            columna[0] = empleado.getCod_empleado();
            columna[1] = empleado.getEmple_nom();
            columna[2] = empleado.getEmple_ape();
            columna[3] = empleado.getDNI();
            columna[4] = empleado.getEspecialidad();
            columna[5] = empleado.getCod_sucursal();
            modeloT.addRow(columna);
        }
    }

    // Validación adicional para el DNI cuando el usuario termina de escribir
    if (e.getSource() == vistaCrudEmple.txt_DNI1) {
        String dniText = vistaCrudEmple.txt_DNI1.getText();
        
        // Si el campo tiene caracteres no numéricos o excede los 8 caracteres, muestra un mensaje
        if (!dniText.matches("[0-9]{1,8}")) {  // Solo números y longitud máxima 8
            JOptionPane.showMessageDialog(null, "Por favor, digite los números correspondientes a su DNI.");
            // Se limpia el campo para evitar entradas incorrectas
            vistaCrudEmple.txt_DNI1.setText("");
        }
    }
}

// Método para verificar si algún campo está vacío
private boolean isAnyFieldEmpty() {
    return vistaCrudEmple.txt_cod_emple3.getText().isEmpty() ||
           vistaCrudEmple.txt_nom_emple.getText().isEmpty() ||
           vistaCrudEmple.txt_ape_emple.getText().isEmpty() ||
           vistaCrudEmple.txt_DNI1.getText().isEmpty() ||
           vistaCrudEmple.txt_Especialidad.getText().isEmpty() ||
           vistaCrudEmple.Jcombo_sedes.getSelectedItem() == null;
}

    }
