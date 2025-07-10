package Modelo_Pacientes;
import ConectorDB.Conexion;
import java.sql.*;
import java.util.ArrayList;

public class PacienteDAO {
    Conexion conexion;

    public PacienteDAO() {
        conexion = new Conexion();
    }

    // Método para insertar paciente
    public String insertPaciente(String cod_pacientes, String nom_paciente, String ape_paciente, int DNI, double peso, double altura, String Enfermedad, String Nivel_urgencia, String Cod_Sucursal) {
        String rptaRegistro = null;
        Connection accesoDB = null;
        CallableStatement cs = null;

        try {
            accesoDB = conexion.getConexion();
            cs = accesoDB.prepareCall("{call sp_Pacientes_insertar(?,?,?,?,?,?,?,?,?)}");
            cs.setString(1, cod_pacientes);
            cs.setString(2, nom_paciente);
            cs.setString(3, ape_paciente);
            cs.setInt(4, DNI);
            cs.setDouble(5, peso);
            cs.setDouble(6, altura);
            cs.setString(7, Enfermedad);
            cs.setString(8, Nivel_urgencia);
            cs.setString(9, Cod_Sucursal);

            int numFAfectas = cs.executeUpdate();
            if (numFAfectas > 0) {
                rptaRegistro = "Registro Exitoso";
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (cs != null) {
                    cs.close();
                }
                if (accesoDB != null) {
                    accesoDB.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return rptaRegistro;
    }

    // Método para listar pacientes
    public ArrayList<Pacientes> listPacientes() {
        ArrayList<Pacientes> listaPacientes = new ArrayList<>();
        Pacientes paci = null;
        Connection accDB = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            accDB = conexion.getConexion();
            ps = accDB.prepareStatement("SELECT * FROM pacientes");
            rs = ps.executeQuery();

            while (rs.next()) {
                paci = new Pacientes();
                paci.setCod_pacientes(rs.getString(1));
                paci.setNom_paciente(rs.getString(2));
                paci.setApe_paciente(rs.getString(3));
                paci.setDNI(rs.getInt(4));
                paci.setPeso(rs.getDouble(5));
                paci.setAltura(rs.getDouble(6));
                paci.setEnfermedad(rs.getString(7));
                paci.setNivel_Urgencia(rs.getString(8));
                paci.setCod_Sucursal(rs.getString(9));
                listaPacientes.add(paci);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (accDB != null) {
                    accDB.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return listaPacientes;
    }

    // Método para editar paciente
    public int EditarPaciente(String cod_pacientes, String nom_paciente, String ape_paciente, int DNI, double peso, double altura, String Enfermedad, String Nivel_urgencia, String Cod_Sucursal) {
        int numFA = 0;
        Connection accDB = null;
        CallableStatement cs = null;

        try {
            accDB = conexion.getConexion();
            cs = accDB.prepareCall("{call sp_Editar_Paciente(?,?,?,?,?,?,?,?,?)}");
            cs.setString(1, cod_pacientes);
            cs.setString(2, nom_paciente);
            cs.setString(3, ape_paciente);
            cs.setInt(4, DNI);
            cs.setDouble(5, peso);
            cs.setDouble(6, altura);
            cs.setString(7, Enfermedad);
            cs.setString(8, Nivel_urgencia);
            cs.setString(9, Cod_Sucursal);

            numFA = cs.executeUpdate();
            System.out.println("Pacientes modificados: " + numFA);

        } catch (SQLException e) {
            System.err.println("Error al editar paciente: " + e.getMessage());
        } finally {
            try {
                if (cs != null) {
                    cs.close();
                }
                if (accDB != null) {
                    accDB.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return numFA;
    }

    // Método para eliminar paciente
    public int EliminarPaciente(String cod_pacientes) {
        int numFA = 0;
        Connection accDB = null;
        CallableStatement cs = null;

        try {
            accDB = conexion.getConexion();
            cs = accDB.prepareCall("{call sp_Eliminar_Paciente(?)}");
            cs.setString(1, cod_pacientes);

            numFA = cs.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (cs != null) {
                    cs.close();
                }
                if (accDB != null) {
                    accDB.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return numFA;
    }

    // Método para buscar pacientes por apellido
    public ArrayList<Pacientes> BuscarPacientexApellido(String ape_paciente) {
        ArrayList<Pacientes> listaPacientes = new ArrayList<>();
        Pacientes paci = null;
        Connection accDB = null;
        CallableStatement cs = null;
        ResultSet rs = null;

        try {
            accDB = conexion.getConexion();
            cs = accDB.prepareCall("{call sp_Paciente_BuscarxApellido(?)}");
            cs.setString(1, ape_paciente);
            rs = cs.executeQuery();

            while (rs.next()) {
                paci = new Pacientes();
                paci.setCod_pacientes(rs.getString(1));
                paci.setNom_paciente(rs.getString(2));
                paci.setApe_paciente(rs.getString(3));
                paci.setDNI(rs.getInt(4));
                paci.setPeso(rs.getDouble(5));
                paci.setAltura(rs.getDouble(6));
                paci.setEnfermedad(rs.getString(7));
                paci.setNivel_Urgencia(rs.getString(8));
                paci.setCod_Sucursal(rs.getString(9));
                listaPacientes.add(paci);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (cs != null) {
                    cs.close();
                }
                if (accDB != null) {
                    accDB.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return listaPacientes;
    }
}
