package ConectorDB;
import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
    public static Connection getConexion() {
        Connection cn = null;
        
        // Validar carga del driver
        try {
            System.out.println("Cargando el driver JDBC...");
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver JDBC cargado exitosamente.");
        } catch (ClassNotFoundException e) {
            System.err.println("ERROR: No se pudo cargar el driver JDBC.");
            e.printStackTrace(); // Imprime más detalles del error
            return null; // Detener ejecución si no se puede cargar el driver
        }

        // Validar conexión con la base de datos
        try {
            System.out.println("Estableciendo conexión con la base de datos...");
            String url = "jdbc:mysql://localhost:3306/servisalud?useSSL=false&serverTimezone=UTC";
            String user = "root";
            String password = "Pollito"; // Si root no tiene contraseña, deja esto vacío: ""

            cn = DriverManager.getConnection(url, user, password);
            System.out.println("Conexión con la base de datos exitosa.");
        } catch (Exception e) {
            System.err.println("ERROR en la conexión a la base de datos.");
            e.printStackTrace(); // Imprime más detalles del error
        }

        // Validar si la conexión fue exitosa o no
        if (cn != null) {
            System.out.println("La conexión fue validada correctamente.");
        } else {
            System.err.println("ERROR: La conexión no pudo ser establecida.");
        }

        return cn;
    }
}