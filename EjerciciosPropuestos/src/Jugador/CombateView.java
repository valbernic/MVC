package Jugador;

public class CombateView {
	public void mostrarMensaje(String mensaje) {
        System.out.println("> " + mensaje);
    }

    public void mostrarEstadoCombate(Jugador jugador, Enemigo enemigo, int turno) {
        System.out.println("\n================ TURNO " + turno + " ================");
        System.out.println("Jugador: " + jugador.getNombre() + " [HP: " + jugador.getSalud() + "/" + jugador.getSaludMaxima() + "]");
        System.out.println("Enemigo: " + enemigo.getNombre() + " (" + enemigo.getTipo() + ") [HP: " + enemigo.getSalud() + "/" + enemigo.getSaludMaxima() + "]");
        System.out.println("----------------------------------------");
    }

    public void mostrarResultado(String ganador) {
        System.out.println("\n========================================");
        System.out.println("¡FIN DEL COMBATE!");
        System.out.println("Ganador: " + ganador);
        System.out.println("========================================\n");
    }
}
