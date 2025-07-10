package Modelo_Ventas;

import Modelo_Empleados.Empleados;
import Modelo_Pacientes.Pacientes;
import Modelo_Productos.Productos;
import Modelo_Sucursal.Sucursal; // Importación correcta de la clase Sucursal
import java.util.ArrayList;
import java.util.List;

public class Ventas {
    String cod_venta, fecha, emple_ape, paci_ape, nom_Producto, nivel_urgencia, cod_sede;
    Empleados empleado; // Objeto empleado
    Pacientes paciente; // Objeto paciente
    List<Productos> productos; // Lista de productos
    Sucursal sucursal; // Objeto sucursal

    public Ventas() {
        cod_venta = "";
        fecha = "";
        emple_ape = "";
        paci_ape = "";
        nom_Producto = "";
        nivel_urgencia = "";
        cod_sede = "";
        empleado = new Empleados(); // Inicializando el objeto Empleados
        paciente = new Pacientes(); // Inicializando el objeto Pacientes
        productos = new ArrayList<>(); // Inicializando la lista de Productos (ahora no es null)
        sucursal = new Sucursal(); // Inicializando el objeto Sucursal
    }

    // Métodos getters y setters
    public String getCod_venta() {
        return cod_venta;
    }

    public void setCod_venta(String cod_venta) {
        this.cod_venta = cod_venta;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getEmple_ape() {
        return emple_ape;
    }

    public void setEmple_ape(String emple_ape) {
        this.emple_ape = emple_ape;
    }

    public String getPaci_ape() {
        return paci_ape;
    }

    public void setPaci_ape(String paci_ape) {
        this.paci_ape = paci_ape;
    }

    public String getNom_Producto() {
        return nom_Producto;
    }

    public void setNom_Producto(String nom_Producto) {
        this.nom_Producto = nom_Producto;
    }

    public String getNivel_urgencia() {
        return nivel_urgencia;
    }

    public void setNivel_urgencia(String nivel_urgencia) {
        this.nivel_urgencia = nivel_urgencia;
    }

    public String getCod_sede() {
        return cod_sede;
    }

    public void setCod_sede(String cod_sede) {
        this.cod_sede = cod_sede;
    }

    public Empleados getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleados empleado) {
        this.empleado = empleado;
    }

    public Pacientes getPaciente() {
        return paciente;
    }

    public void setPaciente(Pacientes paciente) {
        this.paciente = paciente;
    }

    public List<Productos> getProductos() {
        return productos;
    }

    public void setProductos(List<Productos> productos) {
        this.productos = productos;
    }

    public Sucursal getSucursal() { // Getter para la propiedad Sucursal
        return sucursal;
    }

    public void setSucursal(Sucursal sucursal) { // Setter para la propiedad Sucursal
        this.sucursal = sucursal;
    }
}
