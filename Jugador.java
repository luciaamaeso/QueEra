package src;

import java.util.HashMap;
import java.util.Map;

public class Jugador {
    private static Jugador miJugador;
    private ListaObjetos inventario;
    private int posicionX;
    private int posicionY;
    private boolean ganado;
    private Teclado teclado;

    private Jugador() {
        this.inventario = new ListaObjetos();
        this.posicionX = 0;
        this.posicionY = 0;
        this.ganado = false;
        this.teclado = new Teclado(); // Instancia del teclado
    }

    public static Jugador getMiJugador() {
        if (miJugador == null) {
            miJugador = new Jugador();
        }
        return miJugador;
    }

    public void mover(Tablero tablero) {
        Map<String, int[]> movimientos = new HashMap<>();
        movimientos.put("w", new int[] {-1, 0}); // Arriba
        movimientos.put("s", new int[] {1, 0});  // Abajo
        movimientos.put("a", new int[] {0, -1}); // Izquierda
        movimientos.put("d", new int[] {0, 1});  // Derecha

        while (true) {
            System.out.println("Introduce un movimiento (w/a/s/d): ");
            String movimiento = teclado.getScanner().nextLine().trim(); // Leer el movimiento del usuario.

            if (movimientos.containsKey(movimiento)) {
                int[] desplazamiento = movimientos.get(movimiento); // Obtener el desplazamiento correspondiente
                int nuevaX = posicionX + desplazamiento[0];
                int nuevaY = posicionY + desplazamiento[1];

                if (tablero.esCasillaTransitable(nuevaX, nuevaY)) {
                    this.posicionX = nuevaX;
                    this.posicionY = nuevaY;
                    break; // Salir del bucle si el movimiento es válido.
                } else {
                    System.out.println("No puedes moverte a esa casilla.");
                }
            } else {
                System.out.println("Movimiento no válido. Intenta de nuevo.");
            }
        }
    }

    public int getPosicionX() {
        return posicionX;
    }

    public int getPosicionY() {
        return posicionY;
    }

    public ListaObjetos getInventario() {
        return inventario;
    }

    public boolean hasGanado() {
        return ganado;
    }

    public void setGanado(boolean ganado) {
        this.ganado = ganado;
    }

    public void reiniciar() {
        this.posicionX = 0;
        this.posicionY = 0;
        this.ganado = false;
        this.inventario = new ListaObjetos();
    }

    public void agregarObjeto(Objeto objeto) {
        inventario.agregarObjeto(objeto);
        System.out.println("Has recogido el objeto: " + objeto.getNombre());
    }
    public void usarObjeto(int idObjeto) {
        inventario.usarObjeto(idObjeto);
    }
    public boolean tieneObjeto(int idObjeto) {
        return inventario.tieneObjeto(idObjeto);
    }
}