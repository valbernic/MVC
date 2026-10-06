package Jugador;

public class Jugador {
    private String nombre;
    private int salud;
    private int saludMaxima;
    private int nivel;
    private int ataqueBase;

    public Jugador(String nombre, int salud, int nivel, int ataqueBase) {
        this.nombre = nombre;
        this.salud = salud;
        this.saludMaxima = salud;
        this.nivel = nivel;
        this.ataqueBase = ataqueBase;
    }

    public String getNombre() { return nombre; }
    public int getSalud() { return salud; }
    public int getSaludMaxima() { return saludMaxima; }
    public int getNivel() { return nivel; }

    public int atacar() {
        // Cálculo de daño con una pequeña variación aleatoria
        int variacion = (int) (Math.random() * 5);
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