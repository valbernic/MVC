package Jugador;

public class Main {
    public static void main(String[] args) {
        // 1. Creación de Entidades (Jugador y Enemigo)
        Jugador jugador = new Jugador("Guerrero Arturo", 100, 1, 18);
        Enemigo enemigo = new Enemigo("Goblin Feroz", 70, 1, "Bestia", 12);

        // 2. Creación de la Vista
        CombateView vista = new CombateView();

        // 3. Creación del Controlador e inicio del combate
        CombateController controlador = new CombateController(jugador, enemigo, vista);
        controlador.ejecutarCombate();
    }
}