// ProductoElectronico HEREDA de Producto: tiene todo lo de Producto + marca y garantia
public class ProductoElectronico extends Producto {

    private String marca;
    private int mesesGarantia;

    // Recargo que se cobra si la garantia es extendida (mas de 12 meses)
    private static final double RECARGO_GARANTIA = 50000;

    public ProductoElectronico(String nombre, double precio, int cantidad,
                               String marca, int mesesGarantia) {
        super(nombre, precio, cantidad);   // llama al constructor de Producto
        this.marca = marca;
        this.mesesGarantia = mesesGarantia;
    }

    public String getMarca() {
        return marca;
    }

    public int getMesesGarantia() {
        return mesesGarantia;
    }

    public boolean tieneGarantiaExtendida() {
        return mesesGarantia > 12;
    }

    // Sobrescribe el precio: si tiene garantia extendida se suma el recargo
    @Override
    public double getPrecio() {
        double precioFinal = super.getPrecio();
        if (tieneGarantiaExtendida()) {
            precioFinal = precioFinal + RECARGO_GARANTIA;
        }
        return precioFinal;
    }

    @Override
    public String toString() {
        return super.toString() + " | marca: " + marca + " | garantia: " + mesesGarantia + " meses";
    }
}
