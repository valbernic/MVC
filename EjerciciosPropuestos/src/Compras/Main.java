package Compras;

public class Main {
    public static void main(String[] args) {
        CarritoModel model = new CarritoModel();
        CarritoView view = new CarritoView();
        CarritoController controller = new CarritoController(model, view);
        
        controller.iniciar();

    }
}