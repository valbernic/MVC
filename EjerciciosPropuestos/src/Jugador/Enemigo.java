package Jugador;

public class Enemigo {
	private String nombre;
    private int salud;
    private int saludMaxima;
    private int nivel;
    private String tipo;
    private int ataqueBase;

    public Enemigo(String nombre, int salud, int nivel, String tipo, int ataqueBase) {
        this.nombre = nombre;
        this.salud = salud;
        this.saludMaxima = salud;
        this.nivel = nivel;
        this.tipo = tipo;
        this.ataqueBase = ataqueBase;
    }

    public String getNombre() { return nombre; }
    public int getSalud() { return salud; }
    public int getSaludMaxima() { return saludMaxima; }
    public int getNivel() { return nivel; }
    public String getTipo() { return tipo; }

    public int atacar() {
        int variacion = (int) (Math.random() * 6);
        return ataqueBase + variacion;
    }

    public void recibirDano(int cantidad) {
        this.salud -= cantidad;
        if (this.salud < 0) this.salud = 0;
    }

    public boolean estaVivo() {
        return this.salud > 0;
    }
}
