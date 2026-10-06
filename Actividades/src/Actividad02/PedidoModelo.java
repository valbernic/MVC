package Actividad02;

import java.util.ArrayList;
import java.util.List;

public class PedidoModelo {
    private List<Pedido> pedidos;

    public PedidoModelo() {
        pedidos = new ArrayList<>();
    }

    public void agregarPedido(Pedido pedido) {
        pedidos.add(pedido);
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }
    
    public void eliminarPedido(int indice) {
        if (indice >= 0 && indice < pedidos.size()) {
            pedidos.remove(indice);
        }
    }

    public void actualizarPedido(int indice, String nuevoNombre) {
        if (indice >= 0 && indice < pedidos.size()) {
            pedidos.get(indice).setNombrePlato(nuevoNombre);
        }
    }

    public List<Pedido> buscarPorNombre(String nombre) {
        List<Pedido> encontrados = new ArrayList<>();
        for (Pedido pedido : pedidos) {
            if (pedido.getNombrePlato().equalsIgnoreCase(nombre)) {
                encontrados.add(pedido);
            }
        }
        return encontrados;
    }

    public List<Pedido> buscarPorTipo(String tipo) {

        List<Pedido> encontrados = new ArrayList<>();

        for (Pedido pedido : pedidos) {
            if (pedido.getTipo().equalsIgnoreCase(tipo)) {
                encontrados.add(pedido);
            }
        }
        return encontrados;
    }

    public int contarPorTipo(String tipo) {
        int contador = 0;

        for (Pedido pedido : pedidos) {
            if (pedido.getTipo().equalsIgnoreCase(tipo)) {
                contador++;
            }
        }
        return contador;
    }
}