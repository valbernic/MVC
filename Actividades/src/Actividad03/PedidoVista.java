package Actividad03;

import java.util.List;
import java.util.Scanner;

public class PedidoVista {
    private Scanner scanner;

    public PedidoVista() {
        scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        System.out.println("\n===== SISTEMA DE PEDIDOS =====");
        System.out.println("1. Agregar pedido");
        System.out.println("2. Mostrar pedidos");
        System.out.println("3. Eliminar pedido");
        System.out.println("4. Actualizar pedido");
        System.out.println("5. Buscar por nombre");
        System.out.println("6. Buscar por tipo");
        System.out.println("7. Completar pedido");
        System.out.println("8. Mostrar pedidos por estado");
        System.out.println("9. Contar pedidos");
        System.out.println("10. Mostrar historial");
        System.out.println("11. Salir");
    }

    public String solicitarOpcion() {
        System.out.print("Seleccione una opción: ");
        return scanner.nextLine();
    }

    public String solicitarNombrePlato() {
        System.out.print("Ingrese el nombre del plato: ");
        return scanner.nextLine();
    }

    public String solicitarTipo() {
        System.out.print("Ingrese el tipo de plato: ");
        return scanner.nextLine();
    }

    public int solicitarIndice() {
        System.out.print("Ingrese el número del pedido: ");
        return Integer.parseInt(scanner.nextLine());
    }

    public void mostrarPedidos(List<Pedido> pedidos) {
        if (pedidos.isEmpty()) {
            System.out.println("No hay pedidos.");
        } else {
            System.out.println("\n===== PEDIDOS =====");
            for (int i = 0; i < pedidos.size(); i++) {
                Pedido pedido = pedidos.get(i);
                System.out.println(
                    (i + 1) + ". " +
                    pedido.getNombrePlato() +
                    " | Tipo: " + pedido.getTipo() +
                    " | Estado: " + pedido.getEstado()
                );
            }
        }
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public void cerrarScanner() {
        scanner.close();
    }
}
