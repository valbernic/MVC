package Actividad01;
import java.util.List;
//singleton = 1 only one communication with BD

public class PedidoControlador {
	private PedidoModelo modelo;
	private PedidoVista vista;
	
	public PedidoControlador(PedidoModelo modelo, PedidoVista vista) {
		this.modelo = modelo;
		this.vista = vista;
	}
	
	public void agregarPedido(String nombrePlato) {
		if (!nombrePlato.isEmpty()) {
			modelo.agregarPedido(new Pedido(nombrePlato));
			vista.mostrarMensaje("Pedido agregado " + nombrePlato);
		} else {
			vista.mostrarMensaje("Nombre del plato vacio ");
		}
	}
	
	public void mostrarPedidos() {
		List<Pedido> pedidos = modelo.getPedidos();
		vista.mostrarPedidos(pedidos);
	}
	public void iniciar() {
		String opcion;
		do {
		    vista.mostrarMenu();
		    opcion = vista.solicitarOpcion();

		    switch (opcion) {
		        case "1":
		            String nombrePlato = vista.solicitarNombrePlato();
		            agregarPedido(nombrePlato);
		            break;

		        case "2":
		            mostrarPedidos();
		            break;

		        case "3":
		            vista.mostrarMensaje("Saliendo...");
		            break;

		        default:
		            vista.mostrarMensaje("Opción no válida. Inténtalo de nuevo.");
		            break;
		    }
		} while (!opcion.equals("3"));
		vista.cerrarScanner();
	}
}
