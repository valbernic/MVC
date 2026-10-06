package Item;

public class InventarioController {
    private InventarioModel modelo;
    private InventarioView vista;

    public InventarioController(InventarioModel modelo, InventarioView vista) {
        this.modelo = modelo;
        this.vista = vista;
    }

    public void agregarItem(Item item) {
        modelo.agregarItem(item);
        vista.mostrarMensaje("Ítem agregado: " + item.getNombre());
    }

    public void eliminarItem(String nombre) {
        Item item = modelo.buscarItem(nombre);
        if (item != null && modelo.eliminarItem(item)) {
            vista.mostrarMensaje("Ítem eliminado: " + nombre);
        } else {
            vista.mostrarMensaje("No se pudo eliminar el ítem.");
        }
    }

    public void verInventario() {
        vista.mostrarInventario(modelo.obtenerItems());
    }

    public void mostrarDetalles(String nombre) {
        Item item = modelo.buscarItem(nombre);
        vista.mostrarDetallesItem(item);
    }

    public Item buscarItem(String nombre) {
        return modelo.buscarItem(nombre);
    }
    
    public void iniciar() {

        int opcion;

        do {
            opcion = vista.mostrarMenu();
            switch (opcion) {
                case 1:
                    Item item = vista.ingresarItem();
                    agregarItem(item);
                    break;
                case 2:
                    verInventario();
                    break;
                case 3:
                    String nombreEliminar = vista.ingresarNombre();
                    eliminarItem(nombreEliminar);
                    break;
                case 4:
                    String nombreDetalle = vista.ingresarNombre();
                    mostrarDetalles(nombreDetalle);
                    break;
                case 5:
                    vista.mostrarMensaje("Saliendo del sistema...");
                    break;
                default:
                    vista.mostrarMensaje("Opción no válida.");

            }
        } while (opcion != 5);
    }
}
