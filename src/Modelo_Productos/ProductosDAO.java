package Modelo_Productos;
import ConectorDB.Conexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class ProductosDAO {
    Conexion conexion;

    public ProductosDAO() {
        conexion = new Conexion();
    }

    public String insertProducto(String cod_products, String nombre, int cantidad, double precio, String marca, String cod_sucursal) {
        String rptaRegistro = null;
        try (Connection accesoDB = conexion.getConexion();
             CallableStatement cs = accesoDB.prepareCall("{call sp_Productos_insertar(?,?,?,?,?,?)}")) {
            cs.setString(1, cod_products);
            cs.setString(2, nombre);
            cs.setInt(3, cantidad);
            cs.setDouble(4, precio);
            cs.setString(5, marca);
            cs.setString(6, cod_sucursal);
            int numFAfectas = cs.executeUpdate();
            if (numFAfectas > 0) {
                rptaRegistro = "Registro Exitoso";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rptaRegistro;
    }

    public List<Productos> listProducto() {
        List<Productos> listaProducto = new ArrayList<>();
        try (Connection accesoDB = conexion.getConexion();
             CallableStatement cs = accesoDB.prepareCall("{call sp_Productos_listar()}");
             ResultSet rs = cs.executeQuery()) {
            while (rs.next()) {
                Productos produc = new Productos();
                produc.setCod_products(rs.getString(1));
                produc.setNombre(rs.getString(2));
                produc.setCantidad(rs.getInt(3));
                produc.setPrecio(rs.getDouble(4));
                produc.setMarca(rs.getString(5));
                produc.setCod_sucursal(rs.getString(6));
                listaProducto.add(produc);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaProducto;
    }

    public int EditarProductos(String cod_productos, String nom_product, int cantidad, Double Precio, String marca, String cod_sucursal) {
        int numFA = 0;
        try (Connection accDB = conexion.getConexion();
             CallableStatement cs = accDB.prepareCall("{call sp_Editar_Producto(?,?,?,?,?,?)}")) {
            cs.setString(1, cod_productos);
            cs.setString(2, nom_product);
            cs.setInt(3, cantidad);
            cs.setDouble(4, Precio);
            cs.setString(5, marca);
            cs.setString(6, cod_sucursal);
            numFA = cs.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return numFA;
    }

    public int EliminarProducto(String cod_productos) {
        int numFA = 0;
        try (Connection accDB = conexion.getConexion();
             CallableStatement cs = accDB.prepareCall("{call sp_Eliminar_Producto(?)}")) {
            cs.setString(1, cod_productos);
            numFA = cs.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return numFA;
    }

    public ArrayList<Productos> BuscarProductoxNombre(String nom_product) {
        ArrayList<Productos> listaProductos = new ArrayList<>();
        try (Connection accDB = conexion.getConexion();
             CallableStatement cs = accDB.prepareCall("{call sp_Producto_BuscarxNombre(?)}")) {
            cs.setString(1, nom_product);
            try (ResultSet rs = cs.executeQuery()) {
                while (rs.next()) {
                    Productos produc = new Productos();
                    produc.setCod_products(rs.getString(1));
                    produc.setNombre(rs.getString(2));
                    produc.setCantidad(rs.getInt(3));
                    produc.setPrecio(rs.getDouble(4));
                    produc.setMarca(rs.getString(5));
                    produc.setCod_sucursal(rs.getString(6));
                    listaProductos.add(produc);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaProductos;
    }
}
