package src;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestSuite {

    private Tablero tablero;
    private Jugador jugador;

    @BeforeEach
    public void setUp() {
        tablero = new Tablero();
        jugador = Jugador.getMiJugador();
        jugador.reiniciar(); // Reinicia el jugador antes de cada prueba
    }

    @Test
    public void testJugadorMovimientoValido() {
        jugador.mover(1, 0, tablero); // Mover hacia abajo
        assertEquals(1, jugador.getPosicionX());
        assertEquals(0, jugador.getPosicionY());
    }

    @Test
    public void testJugadorMovimientoInvalido() {
        jugador.mover(-1, 0, tablero); // Movimiento fuera del tablero
        assertEquals(0, jugador.getPosicionX());
        assertEquals(0, jugador.getPosicionY());
    }

    @Test
    public void testCasillaConObjeto() {
        Casilla casilla = tablero.getCasilla(6, 5); // Casilla con un objeto
        casilla.pasarCosas();
        assertTrue(jugador.getInventario().mismaSolucion(2)); // Verifica que el objeto se agregó al inventario
    }

    @Test
    public void testCasillaConMisterioResuelto() {
        // Agregar el objeto necesario al inventario
        jugador.agregarObjeto(new Objeto(2, "Desencripta el texto antiguo!", "Papiro antiguo"));
        Casilla casilla = tablero.getCasilla(1, 8); // Casilla con un misterio
        casilla.pasarCosas();
        assertFalse(jugador.getInventario().mismaSolucion(2)); // Verifica que el objeto fue usado
    }

    @Test
    public void testCasillaConMisterioNoResuelto() {
        Casilla casilla = tablero.getCasilla(1, 8); // Casilla con un misterio
        casilla.pasarCosas();
        assertFalse(jugador.getInventario().mismaSolucion(2)); // Verifica que no se usó ningún objeto
    }

    @Test
    public void testCasillaFinalSinLlave() {
        Casilla casilla = tablero.getCasilla(9, 9); // Casilla final
        casilla.pasarCosas();
        assertFalse(jugador.hasGanado()); // Verifica que el jugador no ha ganado
    }

    @Test
    public void testCasillaFinalConLlave() {
        // Agregar la llave dorada al inventario
        jugador.agregarObjeto(new Objeto(1, "Llave dorada", "Corre a la salida!"));
        Casilla casilla = tablero.getCasilla(9, 9); // Casilla final
        casilla.pasarCosas();
        assertTrue(jugador.hasGanado()); // Verifica que el jugador ha ganado
    }

    @Test
    public void testCasillaAlVacio() {
        Casilla casilla = tablero.getCasilla(0, 5); // Casilla al vacío
        casilla.pasarCosas();
        assertEquals(0, jugador.getPosicionX()); // Verifica que el jugador fue reiniciado
        assertEquals(0, jugador.getPosicionY());
    }

    @Test
    public void testListaObjetosAgregarYEliminar() {
        ListaObjetos inventario = new ListaObjetos();
        Objeto objeto = new Objeto(3, "Imán atado con cuerda", "Coge lo que se encuentra al fondo del pozo!");
        inventario.agregarObjeto(objeto);
        assertTrue(inventario.mismaSolucion(3)); // Verifica que el objeto fue agregado
        inventario.eliminarObjeto(3);
        assertFalse(inventario.mismaSolucion(3)); // Verifica que el objeto fue eliminado
    }

    @Test
    public void testMostrarInventario() {
        ListaObjetos inventario = jugador.getInventario();
        Objeto objeto = new Objeto(4, "Papel con números", "Hay un candado en alguna parte, encuéntralo!");
        inventario.agregarObjeto(objeto);
        assertDoesNotThrow(() -> inventario.mostrarInventario()); // Verifica que no hay errores al mostrar el inventario
    }
}
