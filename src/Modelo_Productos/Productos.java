package Modelo_Productos;

public class Productos {
    private int cantidad;
    private String nombre, cod_products, cod_sucursal, marca;
    private Double precio;

    public Productos() {
        cod_products = "";
        nombre = "";
        cantidad = 0; // Inicializamos a 0
        precio = 0.0; // Inicializamos a 0.0 para evitar null
        marca = "";
        cod_sucursal = "";
    }

    public Productos(int cantidad, String nombre, String cod_products, String cod_sucursal, String marca, Double precio) {
        setCantidad(cantidad);
        this.nombre = nombre;
        this.cod_products = cod_products;
        this.cod_sucursal = cod_sucursal;
        this.marca = marca;
        setPrecio(precio);
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        if (cantidad < 0) {
            throw new IllegalArgumentException("La cantidad no puede ser negativa");
        }
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCod_products() {
        return cod_products;
    }

    public void setCod_products(String cod_products) {
        this.cod_products = cod_products;
    }

    public String getCod_sucursal() {
        return cod_sucursal;
    }

    public void setCod_sucursal(String cod_sucursal) {
        this.cod_sucursal = cod_sucursal;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        if (precio != null && precio < 0) {
            throw new IllegalArgumentException("El precio no puede ser negativo");
        }
        this.precio = precio != null ? precio : 0.0; // Asignar 0.0 si es null
    }

    public double getTotal() {
        return cantidad * (precio != null ? precio : 0.0); // Maneja null
    }
}
