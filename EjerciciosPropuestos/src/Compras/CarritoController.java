package Compras;

public class CarritoController {
    private CarritoModel modelo;
    private CarritoView vista;

    public CarritoController(CarritoModel modelo, CarritoView vista) {
        this.modelo = modelo;
        this.vista = vista;
    }

    public void registrarProducto(String id, String nombre, double precio) {
        modelo.agregarProductoCatalogo(new Producto(id, nombre, precio));
    }

    public void verCatalogo() {
        vista.mostrarCatalogo(modelo.getCatalogo());
    }

    public void agregarProductoAlCarrito(String id, int cantidad) {
        modelo.agregarAlCarrito(id, cantidad);
        vista.mostrarMensaje("Producto agregado al carrito.");
    }

    public void eliminarProductoDelCarrito(String id) {
        if (modelo.eliminarDelCarrito(id)) {
            vista.mostrarMensaje("Producto eliminado del carrito.");
        } else {
            vista.mostrarMensaje("El producto no se encuentra en el carrito.");
        }
    }

    public void verCarrito() {
        vista.mostrarCarrito(modelo.getCarrito(), modelo.calcularSubtotal());
    }

    public void procesarCompra(double porcentajeDescuento, double costoEnvio) {
        if (modelo.getCarrito().isEmpty()) {
            vista.mostrarMensaje("No se puede realizar la compra: El carrito está vacío.");
            return;
        }
        double total = modelo.calcularTotal(porcentajeDescuento, costoEnvio);
        modelo.realizarCompra(porcentajeDescuento, costoEnvio);
        vista.mostrarMensaje("¡Compra procesada con éxito! Total pagado: S/ " + total);
    }

    public void verHistorial() {
        vista.mostrarHistorial(modelo.getHistorialCompras());
    }

    public void iniciar() {
        int opcion;
        do {
            vista.mostrarMensaje("\n===== MENÚ CARRITO =====");
            vista.mostrarMensaje("1. Registrar producto");
            vista.mostrarMensaje("2. Ver catálogo");
            vista.mostrarMensaje("3. Agregar producto al carrito");
            vista.mostrarMensaje("4. Eliminar producto del carrito");
            vista.mostrarMensaje("5. Ver carrito");
            vista.mostrarMensaje("6. Procesar compra");
            vista.mostrarMensaje("7. Ver historial");
            vista.mostrarMensaje("8. Salir");
            opcion = vista.pedirEntero("Seleccione una opción: ");
            switch (opcion) {
                case 1:
                    String id = vista.pedirTexto("Ingrese ID: ");
                    String nombre = vista.pedirTexto("Ingrese nombre: ");
                    double precio = vista.pedirDouble("Ingrese precio: ");
                    registrarProducto(id, nombre, precio);
                    vista.mostrarMensaje("Producto registrado.");
                    break;
                case 2:
                    verCatalogo();
                    break;
                case 3:
                    id = vista.pedirTexto("Ingrese ID del producto: ");
                    int cantidad = vista.pedirEntero("Ingrese cantidad: ");
                    agregarProductoAlCarrito(id, cantidad);
                    break;
                case 4:
                    id = vista.pedirTexto("Ingrese ID del producto: ");
                    eliminarProductoDelCarrito(id);
                    break;
                case 5:
                    verCarrito();
                    break;
                case 6:
                    double descuento = vista.pedirDouble(
                        "Ingrese porcentaje de descuento: "
                    );
                    double envio = vista.pedirDouble(
                        "Ingrese costo de envío: "
                    );
                    procesarCompra(descuento, envio);
                    break;
                case 7:
                    verHistorial();
                    break;
                case 8:
                    vista.mostrarMensaje("Saliendo del programa...");
                    break;
                default:
                    vista.mostrarMensaje("Opción no válida.");
            }
        } while (opcion != 8);
        vista.cerrarScanner();
    }
}
