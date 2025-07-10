package Modelo_Laboratorio;
public class laboratorio {
    String cod_lab,nom_lab,ape_lab,Ruc,Marca;
    String telefono,cod_sede;
    
    public laboratorio(){
        cod_lab="";
        nom_lab="";
        ape_lab="";
        Ruc="";
        Marca="";
        telefono="";
        cod_sede="";
    }
    public String getCod_lab() {
        return cod_lab;
    }
    public void setCod_lab(String cod_lab) {
        this.cod_lab = cod_lab;
    }
    public String getNom_lab() {
        return nom_lab;
    }
    public void setNom_lab(String nom_lab) {
        this.nom_lab = nom_lab;
    }
    public String getApe_lab() {
        return ape_lab;
    }
    public void setApe_lab(String ape_lab) {
        this.ape_lab = ape_lab;
    }
    public String getRuc() {
        return Ruc;
    }
    public void setRuc(String Ruc) {
        this.Ruc = Ruc;
    }
    public String getMarca() {
        return Marca;
    }
    public void setMarca(String Marca) {
        this.Marca = Marca;
    }
    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public String getCod_sede() {
        return cod_sede;
    }
    public void setCod_sede(String cod_sede) {
        this.cod_sede = cod_sede;
    }
}

