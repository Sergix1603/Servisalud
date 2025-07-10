package ConectorDB;

import Vista.Menu;
import java.sql.CallableStatement;

import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

public class Guardado_Users {

    CallableStatement cs;
    Connection cn;
    PreparedStatement ps;
    ResultSet rs;
    public void guardarUsuario(registro r) {
        try {
        cn = Conexion.getConexion();
        String sql = "INSERT INTO usuarios (DNI, nombres, apellidos, genero, usuario, contraseña) VALUES (?, ?, ?, ?, ?, ?)";
        ps = cn.prepareStatement(sql);
        ps.setInt(1, r.getDNI());
        ps.setString(2, r.getNombres());
        ps.setString(3, r.getApellidos());
        ps.setString(4, r.getGenero());
        ps.setString(5, r.getUsuario());
        ps.setString(6, r.getContraseña());

        ps.execute();
    } catch (Exception a) {
        a.printStackTrace(); // Muestra la excepción para depurar
    } finally {
        try {
            if (ps != null) {
                ps.close();
            }
            if (cn != null) {
                cn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    }
    
    public boolean dniExistente(int dni) {
    try {
        cn = Conexion.getConexion();
        String sql = "SELECT COUNT(*) FROM usuarios WHERE DNI = ?";
        ps = cn.prepareStatement(sql);
        ps.setInt(1, dni);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return rs.getInt(1) > 0; // Retorna true si el DNI ya existe
        }
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        try {
            if (ps != null) ps.close();
            if (cn != null) cn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    return false;
}

public boolean usuarioExistente(String usuario) {
    try {
        cn = Conexion.getConexion();
        String sql = "SELECT COUNT(*) FROM usuarios WHERE usuario = ?";
        ps = cn.prepareStatement(sql);
        ps.setString(1, usuario);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return rs.getInt(1) > 0; // Retorna true si el usuario ya existe
        }
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        try {
            if (ps != null) ps.close();
            if (cn != null) cn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    return false;
}
    
    
    public boolean accederLogin(String usuario, String contraseña) {
    boolean accesoExitoso = false;
    // Validar si los campos de usuario o contraseña están vacíos
    if (usuario.isEmpty() || contraseña.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Se deben llenar ambos campos, si uno o ambos están vacíos.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        return accesoExitoso; // Retornar false para no continuar
    }

    try {
        cn = Conexion.getConexion();
        String sql = "SELECT * FROM usuarios WHERE usuario = ? AND contraseña = ?";
        ps = cn.prepareStatement(sql);
        ps.setString(1, usuario);
        ps.setString(2, contraseña);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            accesoExitoso = true;
            rs.close();
            ps.close();
            cn.close();

            // Iniciar el menú
            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    Menu menu = new Menu();
                    menu.setVisible(true);
                }
            });
        } else {
            JOptionPane.showMessageDialog(null, "Usuario y/o contraseña incorrecto", "Message", JOptionPane.ERROR_MESSAGE);
        }
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        try {
            if (ps != null) {
                ps.close();
            }
            if (cn != null) {
                cn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    return accesoExitoso;
}
}