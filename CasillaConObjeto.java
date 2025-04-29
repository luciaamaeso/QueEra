package src;

public class CasillaConObjeto extends Casilla {
    private Objeto objeto;

    public CasillaConObjeto(String pDescripcion, boolean pTransitable, Objeto pObjeto) {
        super(pDescripcion, pTransitable);
        this.objeto = pObjeto;
    }

    @Override
    public void pasarCosas() {
        if (objeto != null) {
            System.out.println("Has encontrado un objeto: " + objeto.getNombre());
            Jugador jugador = Jugador.getMiJugador();
            jugador.agregarObjeto(objeto); // Agregar el objeto al inventario y mostrarlo
            objeto = null; // Eliminar el objeto de la casilla
            setVisible(true); // La casilla se vuelve transitable
        } else {
            System.out.println("Esta casilla ya no contiene ningún objeto.");
        }
    }
}

