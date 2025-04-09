package src;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Teclado {
    private Tablero tablero;
    private Jugador jugador;

    public Teclado(Tablero pTablero, Jugador pJugador) {
        this.tablero = pTablero;
        this.jugador = pJugador;
    }

    public void Moverse() {
        Scanner scanner = new Scanner(System.in); // No cerrar el Scanner para que no se pare el programa.
        String movimiento;
        Map<String, int[]> movimientos = new HashMap<>();
        movimientos.put("w", new int[] {-1, 0}); // Arriba
        movimientos.put("s", new int[] {1, 0});  // Abajo
        movimientos.put("a", new int[] {0, -1}); // Izquierda
        movimientos.put("d", new int[] {0, 1});  // Derecha
    
        while (true) {
            System.out.println("Introduce un movimiento (w/a/s/d): ");
            movimiento = scanner.nextLine().trim(); // Leer el movimiento del usuario.
    
            if (movimientos.containsKey(movimiento)) {
                int[] desplazamiento = movimientos.get(movimiento); // Obtener el desplazamiento correspondiente 
                jugador.mover(desplazamiento[0], desplazamiento[1], tablero);
                break; // Salir del bucle si el movimiento es válido.
            } else {
                System.out.println("Movimiento no válido. Intenta de nuevo.");
            }
        }
    }
}