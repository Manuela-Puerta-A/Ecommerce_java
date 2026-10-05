import java.util.Iterator;

public class Main {
    public static void main(String[] args) {

        // ===== CARRITO GENERAL: acepta Producto y tambien ProductoElectronico =====
        Carrito<Producto> carrito = new Carrito<>();

        carrito.agregarProducto(new Producto("Libro Cien anios de soledad", 45000, 2));
        carrito.agregarProducto(new Producto("Camiseta Seleccion", 120000, 1));
        carrito.agregarProducto(new ProductoElectronico("Audifonos", 150000, 1, "Sony", 6));
        carrito.agregarProducto(new ProductoElectronico("Portatil", 2500000, 1, "Lenovo", 24));

        System.out.println("--- Carrito general (recorrido con iterador) ---");
        Iterator<Producto> it = carrito.iterator();
        while (it.hasNext()) {
            Producto p = it.next();
            System.out.println(p + " | precio final: $" + p.getPrecio());
        }

        Producto mayor = carrito.obtenerMayorPrecio();
        if (mayor != null) {
            System.out.println("Producto de mayor precio: " + mayor.getNombre());
        }
        System.out.println("Total carrito general: $" + carrito.calcularTotal());

        // ===== CARRITO SOLO DE ELECTRONICOS =====
        Carrito<ProductoElectronico> carritoElectronicos = new Carrito<>();

        carritoElectronicos.agregarProducto(new ProductoElectronico("Celular", 1200000, 1, "Samsung", 12));
        carritoElectronicos.agregarProducto(new ProductoElectronico("Smart TV", 1800000, 1, "LG", 18));
        // carritoElectronicos.agregarProducto(new Producto("Libro", 45000, 1)); // ERROR: no es electronico

        System.out.println();
        System.out.println("--- Carrito de electronicos (recorrido con for-each) ---");
        for (ProductoElectronico e : carritoElectronicos) {
            System.out.print(e.getNombre() + " (" + e.getMarca() + ")");
            if (e.tieneGarantiaExtendida()) {
                System.out.println(" -> garantia extendida, precio final: $" + e.getPrecio());
            } else {
                System.out.println(" -> garantia normal, precio final: $" + e.getPrecio());
            }
        }
        System.out.println("Total electronicos: $" + carritoElectronicos.calcularTotal());
    }
}