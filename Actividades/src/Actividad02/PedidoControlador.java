package Actividad02;
import java.util.List;

public class PedidoControlador {
    private PedidoModelo modelo;
    private PedidoVista vista;

    public PedidoControlador(PedidoModelo modelo, PedidoVista vista) {
        this.modelo = modelo;
        this.vista = vista;
    }

    public void agregarPedido(String nombre, String tipo) {
        if (!nombre.isEmpty() && !tipo.isEmpty()) {
            Pedido pedido = new Pedido(nombre, tipo);
            modelo.agregarPedido(pedido);
            vista.mostrarMensaje("Pedido agregado correctamente.");
        } else {
            vista.mostrarMensaje("Los datos no pueden estar vacíos.");
        }
    }

    public void mostrarPedidos() {
        List<Pedido> pedidos = modelo.getPedidos();
        vista.mostrarPedidos(pedidos);
    }

    public void eliminarPedido(int indice) {
        if (indice >= 0 && indice < modelo.getPedidos().size()) {
            modelo.eliminarPedido(indice);
            vista.mostrarMensaje("Pedido eliminado.");
        } else {
            vista.mostrarMensaje("Número de pedido inválido.");
        }
    }

    public void actualizarPedido(int indice, String nuevoNombre) {
        if (indice >= 0 && indice < modelo.getPedidos().size()) {
            modelo.actualizarPedido(indice, nuevoNombre);
            vista.mostrarMensaje("Pedido actualizado.");
        } else {
            vista.mostrarMensaje("Número de pedido inválido.");
        }
    }

    public void buscarPorNombre(String nombre) {
        List<Pedido> resultados = modelo.buscarPorNombre(nombre);
        vista.mostrarPedidos(resultados);
    }

    public void buscarPorTipo(String tipo) {
        List<Pedido> resultados = modelo.buscarPorTipo(tipo);
        vista.mostrarPedidos(resultados);
    }

    public void contarPedidos() {
        int total = modelo.getPedidos().size();
        vista.mostrarMensaje("Total de pedidos: " + total);
    }

    public void iniciar() {
        String opcion;
        do {
            vista.mostrarMenu();
            opcion = vista.solicitarOpcion();
            switch (opcion) {
                case "1":
                    String nombre = vista.solicitarNombrePlato();
                    String tipo = vista.solicitarTipo();
                    agregarPedido(nombre, tipo);
                    break;
                case "2":
                    mostrarPedidos();
                    break;
                case "3":
                    int indiceEliminar = vista.solicitarIndice();
                    eliminarPedido(indiceEliminar - 1);
                    break;
                case "4":
                    int indiceActualizar = vista.solicitarIndice();
                    String nuevoNombre = vista.solicitarNombrePlato();
                    actualizarPedido(indiceActualizar - 1, nuevoNombre);
                    break;
                case "5":
                    String nombreBuscar = vista.solicitarNombrePlato();
                    buscarPorNombre(nombreBuscar);
                    break;
                case "6":
                    String tipoBuscar = vista.solicitarTipo();
                    buscarPorTipo(tipoBuscar);
                    break;
                case "7":
                    contarPedidos();
                    break;
                case "8":
                    vista.mostrarMensaje("Saliendo del sistema...");
                    break;
                default:
                    vista.mostrarMensaje("Opción no válida.");
            }
        } while (!opcion.equals("8"));
        vista.cerrarScanner();
    }
}