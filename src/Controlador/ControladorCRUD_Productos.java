package Controlador;

import Modelo_Productos.ProductosDAO;
import Vista.Productos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class ControladorCRUD_Productos implements ActionListener,KeyListener {
    Productos vistaCRUD_Products = new Productos();
    ProductosDAO modeloCRUD_Products = new ProductosDAO();
    
    public ControladorCRUD_Productos(Productos vistaCRUD_Products,ProductosDAO modeloCRUD_Products){
        this.vistaCRUD_Products = vistaCRUD_Products;
    this.modeloCRUD_Products = modeloCRUD_Products;

    this.vistaCRUD_Products.BTN_REGISTRAR.addActionListener(this);
    this.vistaCRUD_Products.BTN_LISTAR.addActionListener(this);
        
        this.vistaCRUD_Products.BTN_MODIFICAR.addActionListener(this);
        this.vistaCRUD_Products.BTN_ELIMINAR.addActionListener(this);
        this.vistaCRUD_Products.BTN_Confirmar.addActionListener(this);
        
        this.vistaCRUD_Products.txt_cod_prod.addKeyListener(this);
        this.vistaCRUD_Products.txt_cantidad.addKeyListener(this);
        this.vistaCRUD_Products.txt_Nombre.addKeyListener(this);
        this.vistaCRUD_Products.txt_precio.addKeyListener(this);
        this.vistaCRUD_Products.txt_Busqueda.addKeyListener(this);
    }
    public void InicializarCrud(){
        
    }
    public void LLenarTabla(JTable tablaD){
        DefaultTableModel modeloT = new DefaultTableModel();
        tablaD.setModel(modeloT);
        modeloT.addColumn("Codigo de Producto");
        modeloT.addColumn("Nombre");
        modeloT.addColumn("Cantidad");
        modeloT.addColumn("Precio");
        modeloT.addColumn("Total");
        modeloT.addColumn("Marca");
        modeloT.addColumn("Codigo de Sucursal");
        
         List<Modelo_Productos.Productos> lista = modeloCRUD_Products.listProducto();
    for (Modelo_Productos.Productos producto : lista) {
        Object[] columna = new Object[7];
        columna[0] = producto.getCod_products();
        columna[1] = producto.getNombre();
        columna[2] = producto.getCantidad();
        columna[3] = producto.getPrecio();
        columna[4] = producto.getTotal();
        columna[5] = producto.getMarca();
        columna[6] = producto.getCod_sucursal();
        modeloT.addRow(columna);
    }
    LimpiarElementos();
}
    public void LimpiarElementos(){
        vistaCRUD_Products.txt_Nombre.setText("");
        vistaCRUD_Products.txt_cantidad.setText("");
        vistaCRUD_Products.txt_cod_prod.setText("");
        vistaCRUD_Products.txt_precio.setText("");
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vistaCRUD_Products.BTN_REGISTRAR) {
        // Obtener los valores de los campos
        String cod_sucursal = vistaCRUD_Products.txt_cod_prod.getText();
        String name = vistaCRUD_Products.txt_Nombre.getText();
        String cantidadStr = vistaCRUD_Products.txt_cantidad.getText();
        String precioStr = vistaCRUD_Products.txt_precio.getText();
        String marc = (String) vistaCRUD_Products.Jcombo_Marcas.getSelectedItem();
        String cod_sede = (String) vistaCRUD_Products.Jcombo_sedes.getSelectedItem();
        
        // Verificar que los campos no estén vacíos
        if (cod_sucursal.isEmpty() || name.isEmpty() || cantidadStr.isEmpty() || precioStr.isEmpty() || marc.isEmpty() || cod_sede.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Todos los campos deben estar completos.");
            return;
        }

        // Validar que la cantidad sea un número entero
        int cantidad;
        try {
            cantidad = Integer.parseInt(cantidadStr);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "La cantidad debe ser un número entero.");
            return;
        }

        // Validar que el precio sea un número con hasta 2 decimales
        Double precio;
        if (!precioStr.matches("\\d+(\\.\\d{1,2})?")) {  // Expresión regular para validar precio
            JOptionPane.showMessageDialog(null, "El precio debe ser un número con hasta 2 decimales.");
            return;
        } else {
            precio = Double.parseDouble(precioStr);
        }

        // Realizar el registro
        String rptaRegistro = modeloCRUD_Products.insertProducto(cod_sucursal, name, cantidad, precio, marc, cod_sede);
        if (rptaRegistro != null) {
            JOptionPane.showMessageDialog(null, rptaRegistro);
        } else {
            JOptionPane.showMessageDialog(null, "Registro Erróneo");
        }

        LimpiarElementos();  // Limpiar los campos después del registro
    }
            
            if (e.getSource() == vistaCRUD_Products.BTN_LISTAR) {
    LLenarTabla(vistaCRUD_Products.TABLA_DATOS);
    JOptionPane.showMessageDialog(null, "Lista de Registros");
}

            
            if(e.getSource()==vistaCRUD_Products.BTN_MODIFICAR){
            int filaEditar = vistaCRUD_Products.TABLA_DATOS.getSelectedRow();
            int numFS = vistaCRUD_Products.TABLA_DATOS.getSelectedRowCount();
            
            if(filaEditar >= 0 && numFS == 1){
                
                vistaCRUD_Products.txt_cod_prod.setText(String.valueOf(vistaCRUD_Products.TABLA_DATOS.getValueAt(filaEditar, 0)));
                vistaCRUD_Products.txt_Nombre.setText(String.valueOf(vistaCRUD_Products.TABLA_DATOS.getValueAt(filaEditar, 1)));
                vistaCRUD_Products.txt_cantidad.setText(String.valueOf(vistaCRUD_Products.TABLA_DATOS.getValueAt(filaEditar, 2)));
                vistaCRUD_Products.txt_precio.setText(String.valueOf(vistaCRUD_Products.TABLA_DATOS.getValueAt(filaEditar, 3)));
                String sede=String.valueOf(vistaCRUD_Products.TABLA_DATOS.getValueAt(filaEditar, 4));
                vistaCRUD_Products.Jcombo_sedes.setSelectedItem(sede);
                String marca=String.valueOf(vistaCRUD_Products.TABLA_DATOS.getValueAt(filaEditar, 5));
                vistaCRUD_Products.Jcombo_Marcas.setSelectedItem(marca);
                
                vistaCRUD_Products.txt_cod_prod.setEditable(true);
                vistaCRUD_Products.BTN_REGISTRAR.setEnabled(false);
                vistaCRUD_Products.BTN_MODIFICAR.setEnabled(false);
                vistaCRUD_Products.BTN_ELIMINAR.setEnabled(false);
                vistaCRUD_Products.txt_Busqueda.setEnabled(false);
            }else{
                JOptionPane.showMessageDialog(null, "Debe seleccionar una fila, almenos una para su edición");
            }
        }
        if(e.getSource() == vistaCRUD_Products.BTN_Confirmar){
            
            String cod_pro=vistaCRUD_Products.txt_cod_prod.getText();
            String nompro=vistaCRUD_Products.txt_Nombre.getText();
            int cant = Integer.parseInt(vistaCRUD_Products.txt_cantidad.getText());
            Double price=Double.parseDouble(vistaCRUD_Products.txt_precio.getText());
            String marc = (String)vistaCRUD_Products.Jcombo_Marcas.getSelectedItem();
            String cod_sede = (String)vistaCRUD_Products.Jcombo_sedes.getSelectedItem();
            
            
            int rptaEdit=modeloCRUD_Products.EditarProductos(cod_pro,nompro,cant,price,marc,cod_sede);
            
            if(rptaEdit>0){
                JOptionPane.showMessageDialog(null, "Modificación Exitosa");
            }else{
                JOptionPane.showMessageDialog(null, "No se pudo realizar la modificacion");
            }
            LimpiarElementos();
            vistaCRUD_Products.BTN_REGISTRAR.setEnabled(true);
            vistaCRUD_Products.BTN_MODIFICAR.setEnabled(true);
            vistaCRUD_Products.BTN_ELIMINAR.setEnabled(true);
            vistaCRUD_Products.txt_Busqueda.setEnabled(true);
            vistaCRUD_Products.BTN_Confirmar.setEnabled(true);
        }
        
        if(e.getSource()==vistaCRUD_Products.BTN_ELIMINAR){
            int filaInicio = vistaCRUD_Products.TABLA_DATOS.getSelectedRow();
            int numFS = vistaCRUD_Products.TABLA_DATOS.getSelectedRowCount();
            ArrayList<String> ListaProductos = new ArrayList();
            String cod_pro="";
            
            if(filaInicio>=0){
                for (int i = 0; i < numFS; i++) {
                    cod_pro=String.valueOf(vistaCRUD_Products.TABLA_DATOS.getValueAt(i+filaInicio,0));
                    ListaProductos.add(cod_pro);
                }
                
                for (int i = 0; i < numFS; i++) {
                    int  RptUsuario = JOptionPane.showConfirmDialog(null,"Quiere eliminar registro con código "+cod_pro+"?");
                    if(RptUsuario==0){
                        modeloCRUD_Products.EliminarProducto(cod_pro);
                    }
                }
                LLenarTabla(vistaCRUD_Products.TABLA_DATOS);
            }else{
                JOptionPane.showMessageDialog(null,"Seleccione al menos una fila a eliminar");
            }
        }
            
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
        if(e.getSource()==vistaCRUD_Products.txt_Nombre){
            char c = e.getKeyChar();
            if((c<'a'||c>'z') && (c<'A'||c>'Z') && (c!=(char)KeyEvent.VK_SPACE)){
                e.consume();
            }
        } 
    }

    @Override
    public void keyPressed(KeyEvent e) {
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
    if (e.getSource() == vistaCRUD_Products.txt_Busqueda) {
        String nombre = vistaCRUD_Products.txt_Busqueda.getText();
        ArrayList<Modelo_Productos.Productos> listaBuscada = modeloCRUD_Products.BuscarProductoxNombre(nombre);
        
        DefaultTableModel modeloT = new DefaultTableModel();
        vistaCRUD_Products.TABLA_DATOS.setModel(modeloT);
        modeloT.addColumn("Codigo de Producto");
        modeloT.addColumn("Nombre");
        modeloT.addColumn("Cantidad");
        modeloT.addColumn("Precio");
        modeloT.addColumn("Total");
        modeloT.addColumn("Marca");
        modeloT.addColumn("Codigo de Sucursal");
        
        for (Modelo_Productos.Productos producto : listaBuscada) {
            Object[] columna = new Object[7];
            columna[0] = producto.getCod_products();
            columna[1] = producto.getNombre();
            columna[2] = producto.getCantidad();
            columna[3] = producto.getPrecio();
            columna[4] = producto.getTotal();
            columna[5] = producto.getMarca();
            columna[6] = producto.getCod_sucursal();
            modeloT.addRow(columna);
        }
    }
}
}

