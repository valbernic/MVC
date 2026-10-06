package Jugador;
import java.util.Random;

public class CombateController {
	private Jugador jugador;
    private Enemigo enemigo;
    private CombateView vista;

    public CombateController(Jugador jugador, Enemigo enemigo, CombateView vista) {
        this.jugador = jugador;
        this.enemigo = enemigo;
        this.vista = vista;
    }

    public void ejecutarCombate() {
        vista.mostrarMensaje("¡Iniciando batalla entre " + jugador.getNombre() + " y " + enemigo.getNombre() + "!");
        int turno = 1;

        while (jugador.estaVivo() && enemigo.estaVivo()) {
            vista.mostrarEstadoCombate(jugador, enemigo, turno);

            // Turno del Jugador
            int danoJugador = jugador.atacar();
            enemigo.recibirDano(danoJugador);
            vista.mostrarMensaje(jugador.getNombre() + " ataca a " + enemigo.getNombre() + " causando " + danoJugador + " de daño.");

            // Verificar si el enemigo fue derrotado
            if (!enemigo.estaVivo()) {
                vista.mostrarMensaje("¡" + enemigo.getNombre() + " ha sido derrotado!");
                break;
            }

            // Turno del Enemigo (Ataque aleatorio / Acción)
            Random rand = new Random();
            boolean ataca = rand.nextBoolean();

            if (ataca) {
                int danoEnemigo = enemigo.atacar();
                jugador.recibirDano(danoEnemigo);
                vista.mostrarMensaje(enemigo.getNombre() + " contraataca causando " + danoEnemigo + " de daño.");
            } else {
                vista.mostrarMensaje(enemigo.getNombre() + " dudó y no realizó ningún ataque en este turno.");
            }

            turno++;
        }

        // Determinar ganador
        if (jugador.estaVivo()) {
            vista.mostrarResultado(jugador.getNombre());
        } else {
            vista.mostrarResultado(enemigo.getNombre());
        }
    }
}
