package src;

public class CasillaConMisterio extends Casilla {
    private int solucionRequerida;

    public CasillaConMisterio(String pDescripcion, boolean pTransitable, int pSolucionRequerida) {
        super(pDescripcion, pTransitable);
        this.solucionRequerida = pSolucionRequerida;
    }

    @Override
    public void pasarCosas() {
        Jugador jugador = Jugador.getMiJugador();
        if (jugador.tieneObjeto(solucionRequerida)) {
            System.out.println("Has resuelto el misterio: " + getDescripcion());
            jugador.usarObjeto(solucionRequerida); // Eliminar el objeto del inventario del jugador
            solucionRequerida = -1; // El misterio se resuelve
            setVisible(true); // La casilla se vuelve transitable
        } else {
            System.out.println("No tienes el objeto necesario para resolver este misterio.");
        }
    }
}
