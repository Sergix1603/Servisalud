package Modelo_Pacientes;
public class Pacientes {
    String cod_pacientes,nom_paciente,ape_paciente,enfermedad,Nivel_Urgencia,Cod_Sucursal;
    int DNI;
    Double Altura, peso,IMC;
    public Pacientes(){
        cod_pacientes="";
        nom_paciente="";
        ape_paciente="";
        DNI=0;
        enfermedad="";
        Altura=0.0;
        peso=0.0;
        IMC=0.0;
        Nivel_Urgencia="";
        Cod_Sucursal="";
    }
    public String getCod_pacientes() {
        return cod_pacientes;
    }
    public void setCod_pacientes(String cod_pacientes) {
        this.cod_pacientes = cod_pacientes;
    }
    public String getNom_paciente() {
        return nom_paciente;
    }
    public void setNom_paciente(String nom_paciente) {
        this.nom_paciente = nom_paciente;
    }
    public String getApe_paciente() {
        return ape_paciente;
    }
    public void setApe_paciente(String ape_paciente) {
        this.ape_paciente = ape_paciente;
    }
    public String getEnfermedad() {
        return enfermedad;
    }
    public void setEnfermedad(String enfermedad) {
        this.enfermedad = enfermedad;
    }
    public String getNivel_Urgencia() {
        return Nivel_Urgencia;
    }
    public void setNivel_Urgencia(String Nivel_Urgencia) {
        this.Nivel_Urgencia = Nivel_Urgencia;
    }
    public double getIMC() {
    double imc;
    imc = peso / (Altura * Altura);
    imc = Math.round(imc * 100.0) / 100.0;
    return imc;
    }
    public String getCod_Sucursal() {
        return Cod_Sucursal;
    }
    public void setCod_Sucursal(String Cod_Sucursal) {
        this.Cod_Sucursal = Cod_Sucursal;
    }
    public int getDNI() {
        return DNI;
    }
    public void setDNI(int DNI) {
        this.DNI = DNI;
    }
    public Double getAltura() {
        return Altura;
    }
    public void setAltura(Double Altura) {
        this.Altura = Altura;
    }
    public Double getPeso() {
        return peso;
    }
    public void setPeso(Double peso) {
        this.peso = peso;
    }
}
