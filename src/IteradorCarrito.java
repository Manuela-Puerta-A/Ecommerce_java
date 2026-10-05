import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

// Iterador propio en su propio archivo.
// Es generico (<T>) y recibe la lista del carrito por el constructor.
// Puede recorrer TODOS los elementos o EXCLUIR los de posicion par (2do, 4to, 6to...)
public class IteradorCarrito<T> implements Iterator<T> {

    private ArrayList<T> productos;
    private int posicion = 0;        // indice del siguiente producto a devolver
    private boolean excluirPares;    // true = salta los elementos en posicion par

    public IteradorCarrito(ArrayList<T> productos) {
        this.productos = productos;
        this.excluirPares = excluirPares;
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
        if (excluirPares) {
            posicion = posicion + 2;   // salta el siguiente (el de posicion par)
        } else {
            posicion = posicion + 1;   // recorrido normal
        }
        return producto;
    }
}