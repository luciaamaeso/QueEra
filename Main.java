package src;

public class Main {
    public static void main(String[] args) {
        Tablero tablero = new Tablero();
        Jugador jugador = Jugador.getMiJugador();

        while (!jugador.hasGanado()) {
            tablero.mostrarTablero(jugador); // Mostrar el tablero.
            jugador.mover(tablero); // El jugador se mueve utilizando el teclado.
            tablero.getCasilla(jugador.getPosicionX(), jugador.getPosicionY()).pasarCosas();
        }

        System.out.println("¡Felicidades, has ganado el juego!");
    }
}