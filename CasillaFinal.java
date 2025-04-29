package src;

public class CasillaFinal extends Casilla {
    public CasillaFinal(String pDescripcion, boolean pTransitable) {
        super(pDescripcion, pTransitable);
    }

    @Override
    public void pasarCosas() {
        Jugador jugador = Jugador.getMiJugador();
        if (jugador.getInventario().mismaSolucion(1)) { // La llave tiene solución 1
            System.out.println("¡Has usado la llave y ganado el juego!");
            jugador.setGanado(true);
        } else {
            System.out.println("Necesitas una llave para ganar.");
        }
    }
}

