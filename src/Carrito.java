import java.util.ArrayList;
import java.util.Iterator;

// Carrito generico: T puede ser cualquier clase que implemente productosI
// Implementa Iterable para poder recorrerlo con nuestro propio iterador
public class Carrito<T extends productosI> implements Iterable<T> {

    private ArrayList<T> productos;

    public Carrito() {
        productos = new ArrayList<>();
    }

    // 1. Agregar productos
    public void agregarProducto(T producto) {
        productos.add(producto);
    }

    // 2. Obtener el producto de mayor precio (usando nuestro iterador)
    public T obtenerMayorPrecio() {
        if (productos.isEmpty()) {
            return null;
        }
        Iterator<T> it = iterator();
        T mayor = it.next();
        while (it.hasNext()) {
            T actual = it.next();
            if (actual.getPrecio() > mayor.getPrecio()) {
                mayor = actual;
            }
        }
        return mayor;
    }

    // 3. Calcular el precio total (precio x cantidad de cada producto)
    public double calcularTotal() {
        double total = 0;
        for (T p : this) {          // este for-each usa nuestro iterador
            total = total + (p.getPrecio() * p.getCantidad());
        }
        return total;
    }
    // 4. Iterador propio: le pasamos la lista al iterador
    @Override
    public Iterator<T> iterator() {
        return new IteradorCarrito<>(productos);
    }


}