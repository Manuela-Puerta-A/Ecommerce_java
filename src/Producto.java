public class Producto implements productosI {

    private String nombre;
    private double precio;
    private int cantidad;

    public Producto(String nombre, double precio, int cantidad) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public double getPrecio() {
        return precio;
    }

    @Override
    public double getCantidad() {
        return cantidad;
    }

    @Override
    public String toString() {
        return nombre + " | cantidad: " + cantidad + " | precio: $" + precio;
    }
}