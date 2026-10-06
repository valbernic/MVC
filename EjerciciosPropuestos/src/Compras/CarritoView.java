package Compras;

import java.util.List;
import java.util.Scanner;

public class CarritoView {
    private Scanner scanner;

    public CarritoView() {
        scanner = new Scanner(System.in);
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public void mostrarCatalogo(List<Producto> productos) {
        System.out.println("\n--- CATÁLOGO DE PRODUCTOS ---");
        for (Producto p : productos) {
            System.out.println(
                "ID: " + p.getId() +
                " | " + p.getNombre() +
                " - S/ " + p.getPrecio()
            );
        }
    }

    public void mostrarCarrito(List<ElementoCarrito> carrito, double subtotal) {
        System.out.println("\n--- CARRITO DE COMPRAS ---");

        if (carrito.isEmpty()) {
            System.out.println("El carrito está vacío.");
            return;
        }
        for (ElementoCarrito item : carrito) {
            System.out.println(
                item.getProducto().getNombre() +
                " x" + item.getCantidad() +
                " = S/ " + item.getSubtotal()
            );
        }

        System.out.println("Subtotal: S/ " + subtotal);
    }

    public void mostrarHistorial(List<String> historial) {
        System.out.println("\n--- HISTORIAL DE COMPRAS ---");

        if (historial.isEmpty()) {
            System.out.println("No hay compras en el historial.");
        } else {
            for (String h : historial) {
                System.out.println("- " + h);
            }
        }
    }

    public int pedirEntero(String mensaje) {
        System.out.print(mensaje);
        return scanner.nextInt();
    }

    public String pedirTexto(String mensaje) {
        System.out.print(mensaje);
        return scanner.next();
    }

    public double pedirDouble(String mensaje) {
        System.out.print(mensaje);
        return scanner.nextDouble();
    }

    public void cerrarScanner() {
        scanner.close();
    }
}