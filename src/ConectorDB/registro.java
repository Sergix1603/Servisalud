package ConectorDB;

public class registro {
    private int DNI;
    private String nombres;
    private String apellidos;
    private String genero;
    private String usuario;
    private String contraseña;

    public registro() {
    }

    public registro(int DNI, String nombres, String apellidos, String genero, String usuario, String contraseña) {
        this.DNI = DNI;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.genero = genero;
        this.usuario = usuario;
        this.contraseña = contraseña;
    }

    public int getDNI() {
        return DNI;
    }

    public void setDNI(int DNI) {
        this.DNI = DNI;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
    
    }
    
