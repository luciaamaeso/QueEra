package src;

public class CasillaAlVacio extends Casilla {
    public CasillaAlVacio(String pDescripcion, boolean pTransitable) {
        super(pDescripcion, pTransitable);
    }

    @Override
    public void pasarCosas() {
        System.out.println("¡Has caído al vacío! El juego se reiniciará.");
        Jugador jugador = Jugador.getMiJugador();
        jugador.reiniciar();
    }
}