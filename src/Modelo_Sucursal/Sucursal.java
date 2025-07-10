package Modelo_Sucursal;
public class Sucursal {
    String cod_sucursal,departamento,Direccion;
    String RUC,telefono;
    public Sucursal(){
        cod_sucursal="";
        departamento="";
        Direccion="";
        RUC="";
        telefono="";
    }
    public String getCod_sucursal() {
        return cod_sucursal;
    }
    public void setCod_sucursal(String cod_sucursal) {
        this.cod_sucursal = cod_sucursal;
    }
    public String getDepartamento() {
        return departamento;
    }
    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }
    public String getDireccion() {
        return Direccion;
    }
    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }
    public String getRUC() {
        return RUC;
    }
    public void setRUC(String RUC) {
        this.RUC = RUC;
    }
    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
