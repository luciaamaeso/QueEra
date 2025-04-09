package src;

public class Jugador {
    private ListaObjetos inventario;
    private int posicionX;
    private int posicionY;
    private boolean ganado;
    private static Jugador miJugador = new Jugador();

    private Jugador() {
        this.inventario = new ListaObjetos();
        this.posicionX = 0;
        this.posicionY = 0;
        this.ganado = false;
    }

    public static Jugador getMiJugador() {
        return miJugador;
    }

    public ListaObjetos getInventario() {
        return inventario;
    }

    public int getPosicionX() {
        return posicionX;
    }

    public int getPosicionY() {
        return posicionY;
    }

    public void mover(int dx, int dy, Tablero tablero) {
        if (tablero == null) {
            System.out.println("Error: El tablero no puede ser nulo.");
            return;
        }

        int nuevaX = this.posicionX + dx;
        int nuevaY = this.posicionY + dy;

        if (tablero.esCasillaTransitable(nuevaX, nuevaY)) {
            this.posicionX = nuevaX;
            this.posicionY = nuevaY;
            System.out.println("Te has movido a la posición: (" + nuevaX + ", " + nuevaY + ")");
        } else {
            System.out.println("No puedes moverte a esa casilla.");
        }
    }

    public boolean hasGanado() {
        return ganado;
    }

    public void setGanado(boolean ganado) {
        this.ganado = ganado;
    }

    public void agregarObjeto(Objeto objeto) {
        if (objeto == null) {
            System.out.println("Error: No se puede agregar un objeto nulo al inventario.");
            return;
        }

        this.inventario.agregarObjeto(objeto);
        System.out.println("Has añadido un objeto al inventario: " + objeto.getNombre());
        this.inventario.mostrarInventario(); // Mostrar el inventario actualizado
    }

    public void usarObjeto(Objeto objeto) {
        if (objeto == null) {
            System.out.println("Error: No se puede usar un objeto nulo.");
            return;
        }

        if (inventario.buscarObjeto(objeto) != null) {
            System.out.println("Usando objeto: " + objeto.getDescripcion());
        } else {
            System.out.println("No tienes ese objeto en tu inventario.");
        }
    }

    public boolean tieneObjeto(int idObjeto) {
        return inventario.mismaSolucion(idObjeto); // Verifica si el objeto está en el inventario.
    }

    public void usarObjeto(int solucion) {
        if (inventario.mismaSolucion(solucion)) {
            inventario.eliminarObjeto(solucion);
            System.out.println("Has usado el objeto con solución: " + solucion);
        } else {
            System.out.println("No tienes el objeto con solución: " + solucion);
        }
    }

    public boolean solucionEncontrada(int solucion) {
        return inventario.mismaSolucion(solucion);
    }

    public void reiniciar() { // Reinicia el jugador a su posición inicial(esto es para cuando el jugador cae en una casilla al vacío).
        this.posicionX = 0;
        this.posicionY = 0;
        this.inventario = new ListaObjetos();
        this.ganado = false;
        System.out.println("El jugador ha sido reiniciado a la posición inicial.");
    }
}