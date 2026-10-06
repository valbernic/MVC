package Item;

import java.util.List;
import java.util.Scanner;

public class InventarioView {
    private Scanner scanner;

    public InventarioView() {
        scanner = new Scanner(System.in);
    }

    public int mostrarMenu() {
        System.out.println("\n===== SISTEMA DE INVENTARIO =====");
        System.out.println("1. Agregar ítem");
        System.out.println("2. Ver inventario");
        System.out.println("3. Eliminar ítem");
        System.out.println("4. Mostrar detalles");
        System.out.println("5. Salir");
        System.out.print("Seleccione una opción: ");
        return scanner.nextInt();
    }

    public Item ingresarItem() {
        scanner.nextLine();
        System.out.println("\n--- INGRESAR ÍTEM ---");
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Cantidad: ");
        int cantidad = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Tipo: ");
        String tipo = scanner.nextLine();
        System.out.print("Descripción: ");
        String descripcion = scanner.nextLine();
        return new Item(nombre, cantidad, tipo, descripcion);
    }

    public String ingresarNombre() {
        scanner.nextLine();
        System.out.print("Ingrese el nombre del ítem: ");
        return scanner.nextLine();
    }

    public void mostrarInventario(List<Item> items) {
        System.out.println("\n--- INVENTARIO ---");
        if (items.isEmpty()) {
            System.out.println("El inventario está vacío.");
            return;
        }

        for (Item item : items) {
            System.out.println(
                "- " + item.getNombre()
                + " | Cantidad: " + item.getCantidad()
                + " | Tipo: " + item.getTipo()
            );
        }
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public void mostrarDetallesItem(Item item) {
        if (item != null) {
            System.out.println("\n--- DETALLES DEL ÍTEM ---");
            System.out.println("Nombre: " + item.getNombre());
            System.out.println("Cantidad: " + item.getCantidad());
            System.out.println("Tipo: " + item.getTipo());
            System.out.println("Descripción: " + item.getDescripcion());
        } else {
            System.out.println("Ítem no encontrado.");
        }
    }
}