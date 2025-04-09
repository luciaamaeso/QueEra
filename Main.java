package src;

public class Main {
    public static void main(String[] args) {
        Tablero tablero = new Tablero();
        Jugador jugador = Jugador.getMiJugador();
        Teclado teclado = new Teclado(tablero, jugador);

        while (!jugador.hasGanado()) {
            tablero.mostrarTablero(jugador); // Mostrar el tablero.
            teclado.Moverse(); // Capta el movimiento del jugador.
            tablero.getCasilla(jugador.getPosicionX(), jugador.getPosicionY()).pasarCosas();
        }

        System.out.println("¡Felicidades, has ganado el juego!");
    }
}