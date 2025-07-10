package Modelo_Laboratorio;

import ConectorDB.Conexion;
import java.sql.*;
import java.util.ArrayList;

public class LaboratorioDAO {
    private Conexion conexion;

    public LaboratorioDAO() {
        conexion = new Conexion();
    }

    public String insertLaboratorio(String cod_lab, String nom_lab, String ape_lab, String Ruc, String Marca, String telefono, String cod_sede) {
        String rptaRegistro = null;

        try (Connection accesoDB = conexion.getConexion();
             CallableStatement cs = accesoDB.prepareCall("{call sp_Laboratorio_insertar(?,?,?,?,?,?,?)}")) {

            cs.setString(1, cod_lab);
            cs.setString(2, nom_lab);
            cs.setString(3, ape_lab);
            cs.setString(4, Ruc);
            cs.setString(5, Marca);
            cs.setString(6, telefono);
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

    public ArrayList<laboratorio> listLaboratorio() {
        ArrayList<laboratorio> listaLaboratorio = new ArrayList<>();

        try (Connection accesoDB = conexion.getConexion();
             PreparedStatement ps = accesoDB.prepareStatement("SELECT * FROM laboratorios");
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                laboratorio lab = new laboratorio();
                lab.setCod_lab(rs.getString(1));
                lab.setNom_lab(rs.getString(2));
                lab.setApe_lab(rs.getString(3));
                lab.setRuc(rs.getString(4));
                lab.setMarca(rs.getString(5));
                lab.setTelefono(rs.getString(6));
                lab.setCod_sede(rs.getString(7));
                listaLaboratorio.add(lab);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listaLaboratorio;
    }

    public int editarLaboratorio(String cod_lab, String nom_lab, String ape_lab, String Ruc, String Marca, String telefono, String cod_sede) {
        int numFA = 0;

        try (Connection accesoDB = conexion.getConexion();
             CallableStatement cs = accesoDB.prepareCall("{call sp_Editar_laboratorio(?,?,?,?,?,?,?)}")) {

            cs.setString(1, cod_lab);
            cs.setString(2, nom_lab);
            cs.setString(3, ape_lab);
            cs.setString(4, Ruc);
            cs.setString(5, Marca);
            cs.setString(6, telefono);
            cs.setString(7, cod_sede);

            numFA = cs.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return numFA;
    }

    public int eliminarLaboratorio(String cod_lab) {
        int numFA = 0;

        try (Connection accesoDB = conexion.getConexion();
             CallableStatement cs = accesoDB.prepareCall("{call sp_Eliminar_Laboratorio(?)}")) {

            cs.setString(1, cod_lab);
            numFA = cs.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return numFA;
    }

    public ArrayList<laboratorio> buscarLaboratorioxMarca(String Marca) {
        ArrayList<laboratorio> listaLaboratorios = new ArrayList<>();

        try (Connection accesoDB = conexion.getConexion();
             CallableStatement cs = accesoDB.prepareCall("{call sp_Laboratorio_BuscarxMarca(?)}")) {

            cs.setString(1, Marca);
            try (ResultSet rs = cs.executeQuery()) {
                while (rs.next()) {
                    laboratorio lab = new laboratorio();
                    lab.setCod_lab(rs.getString(1));
                    lab.setNom_lab(rs.getString(2));
                    lab.setApe_lab(rs.getString(3));
                    lab.setRuc(rs.getString(4));
                    lab.setMarca(rs.getString(5));
                    lab.setTelefono(rs.getString(6));
                    lab.setCod_sede(rs.getString(7));
                    listaLaboratorios.add(lab);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listaLaboratorios;
    }
}
