package Compras;

import java.util.ArrayList;
import java.util.List;

public class CarritoModel {
    private List<Producto> catalogo = new ArrayList<>();
    private List<ElementoCarrito> carrito = new ArrayList<>();
    private List<String> historialCompras = new ArrayList<>();

    public void agregarProductoCatalogo(Producto p) { catalogo.add(p); }
    public List<Producto> getCatalogo() { return catalogo; }

    public void agregarAlCarrito(String idProducto, int cantidad) {
        for (ElementoCarrito item : carrito) {
            if (item.getProducto().getId().equalsIgnoreCase(idProducto)) {
                item.setCantidad(item.getCantidad() + cantidad);
                return;
            }
        }
        for (Producto p : catalogo) {
            if (p.getId().equalsIgnoreCase(idProducto)) {
                carrito.add(new ElementoCarrito(p, cantidad));
                return;
            }
        }
    }

    public boolean eliminarDelCarrito(String idProducto) {
        return carrito.removeIf(item -> item.getProducto().getId().equalsIgnoreCase(idProducto));
    }

    public List<ElementoCarrito> getCarrito() { return carrito; }

    public double calcularSubtotal() {
        double subtotal = 0;
        for (ElementoCarrito item : carrito) {
            subtotal += item.getSubtotal();
        }
        return subtotal;
    }

    public double calcularTotal(double porcentajeDescuento, double costoEnvio) {
        double subtotal = calcularSubtotal();
        double descuento = subtotal * (porcentajeDescuento / 100.0);
        return (subtotal - descuento) + costoEnvio;
    }

    public void realizarCompra(double descuento, double costoEnvio) {
        if (carrito.isEmpty()) return;
        double total = calcularTotal(descuento, costoEnvio);
        historialCompras.add("Compra realizada. Ítems: " + carrito.size() + " | Total pagado: S/ " + total);
        carrito.clear();
    }

    public List<String> getHistorialCompras() { return historialCompras; }
}
