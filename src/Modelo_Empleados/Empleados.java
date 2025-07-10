package Modelo_Empleados;


public class Empleados {
    String cod_empleado,emple_nom,emple_ape;
    String DNI,Especialidad,cod_sucursal;
    public Empleados(){
        cod_empleado="";
        emple_nom="";
        emple_ape="";    
        DNI="";
        Especialidad="";
        cod_sucursal="";
    }
    public String getCod_empleado() {
        return cod_empleado;
    }
    public void setCod_empleado(String cod_empleado) {
        this.cod_empleado = cod_empleado;
    }
    public String getEmple_nom() {
        return emple_nom;
    }
    public void setEmple_nom(String emple_nom) { 
        this.emple_nom = emple_nom;
    }
    public String getEmple_ape() {
        return emple_ape;
    }
    public void setEmple_ape(String emple_ape) {
        this.emple_ape = emple_ape;
    }
    public String getDNI() {
        return DNI;
    }
    public void setDNI(String DNI) {
        this.DNI = DNI;
    }
    public String getEspecialidad() {
        return Especialidad;
    }
    public void setEspecialidad(String Especialidad) {
        this.Especialidad = Especialidad;
    }
    public String getCod_sucursal() {
        return cod_sucursal;
    }
    public void setCod_sucursal(String cod_sucursal) {
        this.cod_sucursal = cod_sucursal;
    }
}
