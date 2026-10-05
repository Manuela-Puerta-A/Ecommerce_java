import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

// Iterador propio en su propio archivo.
// Es generico (<T>) y recibe la lista del carrito por el constructor.
public class IteradorCarrito<T> implements Iterator<T> {

    private ArrayList<T> productos;
    private int posicion = 0;   // indice del siguiente producto a devolver

    public IteradorCarrito(ArrayList<T> productos) {
        this.productos = productos;
    }

    @Override
    public boolean hasNext() {
        return posicion < productos.size();
    }

    @Override
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException("No hay mas productos en el carrito");
        }
        T producto = productos.get(posicion);
        posicion++;
        return producto;
    }
}