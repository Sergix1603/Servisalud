package Modelo_Sucursal;
import ConectorDB.Conexion;
import java.sql.*;
import java.util.ArrayList;

public class SucursalDAO {
    Conexion conexion;

    public SucursalDAO() {
        conexion = new Conexion();
    }

    
    
    
   /* @Before
    public void setUp() {
        sucursalDAO = new SucursalDAO();
    }

    @Test
    public void testInsertSucursal() {
        // Insertar una nueva sucursal y verificar que el resultado no sea null (indica éxito)
        String rptaRegistro = sucursalDAO.insertSucursal("002", "12345678902", "Arequipa", "Av. Prueba 123", "987654322");
        assertTrue("La inserción debería ser exitosa", rptaRegistro.contains("Registro Exitoso"));
    }

    @Test
    public void testEliminarSucursal() {
        // Primero, insertar una sucursal de prueba
        sucursalDAO.insertSucursal("003", "12345678903", "Cusco", "Av. Prueba 456", "987654323");
        
        // Eliminar la sucursal de prueba
        int rptaEliminar = sucursalDAO.EliminarSucursal("003");
        assertTrue("La eliminación debería ser exitosa", rptaEliminar > 0);

        // Verificar que la sucursal ya no está en la lista después de eliminarla
        ArrayList<Sucursal> sucursales = sucursalDAO.BuscarSucursalxDepartamento("Cusco");
        boolean existeSucursal = sucursales.stream().anyMatch(s -> s.getCod_sucursal().equals("003"));
        assertFalse("La sucursal eliminada no debería existir en la lista", existeSucursal);
    }*/
    
    
    
    
    
    
    
  
    
    public String insertSucursal(String cod_sucursal, String RUC, String departamento, String Direccion, String telefono) {
        String rptaRegistro = null;
        try (Connection accesoDB = conexion.getConexion();
             CallableStatement cs = accesoDB.prepareCall("{call sp_sucursal_insertar(?,?,?,?,?)}")) {
            cs.setString(1, cod_sucursal);
            cs.setString(2, RUC);
            cs.setString(3, departamento);
            cs.setString(4, Direccion);
            cs.setString(5, telefono);
            int numFAfectas = cs.executeUpdate();
            if (numFAfectas > 0) {
                rptaRegistro = "Registro Exitoso";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rptaRegistro;
    }

    public ArrayList<Sucursal> listSucursal() {
        ArrayList<Sucursal> listaSucursal = new ArrayList<>();
        try (Connection acceDB = conexion.getConexion();
             PreparedStatement ps = acceDB.prepareStatement("select * from sucursales");
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Sucursal sucursal = new Sucursal();
                sucursal.setCod_sucursal(rs.getString(1));
                sucursal.setRUC(rs.getString(2));
                sucursal.setDepartamento(rs.getString(3));
                sucursal.setDireccion(rs.getString(4));
                sucursal.setTelefono(rs.getString(5));
                listaSucursal.add(sucursal);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaSucursal;
    }

    public int EditarSucursal(String cod_sucursal, String RUC, String departamento, String Direccion, String telefono) {
        int numFA = 0;
        try (Connection accDB = conexion.getConexion();
             CallableStatement cs = accDB.prepareCall("{call sp_Editar_Sucursal(?,?,?,?,?)}")) {
            cs.setString(1, cod_sucursal);
            cs.setString(2, RUC);
            cs.setString(3, departamento);
            cs.setString(4, Direccion);
            cs.setString(5, telefono);
            numFA = cs.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return numFA;
    }

    public int EliminarSucursal(String cod_sucursal) {
        int numFA = 0;
        try (Connection accDB = conexion.getConexion();
             CallableStatement cs = accDB.prepareCall("{call sp_Eliminar_Sucursal(?)}")) {
            cs.setString(1, cod_sucursal);
            numFA = cs.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return numFA;
    }

    public ArrayList<Sucursal> BuscarSucursalxDepartamento(String departamento) {
        ArrayList<Sucursal> listaSucursales = new ArrayList<>();
        try (Connection accDB = conexion.getConexion();
             CallableStatement cs = accDB.prepareCall("{call sp_sucursal_BuscarxDepartamento(?)}")) {
            cs.setString(1, departamento);
            try (ResultSet rs = cs.executeQuery()) {
                while (rs.next()) {
                    Sucursal sucursal = new Sucursal();
                    sucursal.setCod_sucursal(rs.getString(1));
                    sucursal.setRUC(rs.getString(2));
                    sucursal.setDepartamento(rs.getString(3));
                    sucursal.setDireccion(rs.getString(4));
                    sucursal.setTelefono(rs.getString(5));
                    listaSucursales.add(sucursal);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaSucursales;
    }
}
