package Modelo_Empleados;

import ConectorDB.Conexion;
import java.sql.*;
import java.util.ArrayList;

public class EmpleadoDAO {
    private Conexion conexion;

    public EmpleadoDAO() {
        conexion = new Conexion();
    }

    public String insertEmpleado(String cod_emp, String nombre, String apellido, String dni, String telefono, String cod_sucursal) {
        String rptaRegistro = null;

        try (Connection accesoDB = conexion.getConexion();
             CallableStatement cs = accesoDB.prepareCall("{call sp_Empleado_insertar(?,?,?,?,?,?)}")) {

            cs.setString(1, cod_emp);
            cs.setString(2, nombre);
            cs.setString(3, apellido);
            cs.setString(4, dni);
            cs.setString(5, telefono);
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

    public ArrayList<Empleados> listEmpleados() {
        ArrayList<Empleados> listaEmpleados = new ArrayList<>();

        try (Connection accesoDB = conexion.getConexion();
             PreparedStatement ps = accesoDB.prepareStatement("SELECT * FROM empleados");
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Empleados emp = new Empleados();
                emp.setCod_empleado(rs.getString(1));
                emp.setEmple_nom(rs.getString(2));
                emp.setEmple_ape(rs.getString(3));
                emp.setDNI(rs.getString(4));
                emp.setEspecialidad(rs.getString(5));
                emp.setCod_sucursal(rs.getString(6));
                listaEmpleados.add(emp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listaEmpleados;
    }

    public int editarEmpleado(String cod_emp, String nombre, String apellido, String dni, String telefono, String cod_sucursal) {
        int numFA = 0;

        try (Connection accesoDB = conexion.getConexion();
             CallableStatement cs = accesoDB.prepareCall("{call sp_Editar_Empleado(?,?,?,?,?,?)}")) {

            cs.setString(1, cod_emp);
            cs.setString(2, nombre);
            cs.setString(3, apellido);
            cs.setString(4, dni);
            cs.setString(5, telefono);
            cs.setString(6, cod_sucursal);

            numFA = cs.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return numFA;
    }

    public void eliminarEmpleado(String cod_empleado) {
        String sql = "DELETE FROM empleados WHERE cod_empleado = ?";

        try (Connection accesoDB = conexion.getConexion();
             PreparedStatement pst = accesoDB.prepareStatement(sql)) {

            pst.setString(1, cod_empleado);
            pst.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al eliminar empleado: " + e.getMessage());
        }
    }

    public ArrayList<Empleados> BuscarEmpleadoxEspecialidad(String especialidad) {
        ArrayList<Empleados> listaEmpleados = new ArrayList<>();

        try (Connection accesoDB = conexion.getConexion();
             CallableStatement cs = accesoDB.prepareCall("{call sp_Empleado_BuscarxEspecialidad(?)}")) {

            cs.setString(1, especialidad);
            try (ResultSet rs = cs.executeQuery()) {
                while (rs.next()) {
                    Empleados emp = new Empleados();
                    emp.setCod_empleado(rs.getString(1));
                    emp.setEmple_nom(rs.getString(2));
                    emp.setEmple_ape(rs.getString(3));
                    emp.setDNI(rs.getString(4));
                    emp.setEspecialidad(rs.getString(5));
                    emp.setCod_sucursal(rs.getString(6));
                    listaEmpleados.add(emp);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listaEmpleados;
    }
}
