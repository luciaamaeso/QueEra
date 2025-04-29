package src;

public class Tablero {
    private Casilla[][] tablero;

    public Tablero() {
        tablero = new Casilla[10][10];
        inicializarTablero();
    }

    public void inicializarTablero() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                tablero[i][j] = new Casilla("Casilla vacía", true);
            }
        }

        // Casillas con objetos .
        tablero[6][5] = new CasillaConObjeto("Papiro antiguo", true, new Objeto(2, "Desencripta el texto antiguo!", "Papiro antiguo"));
        tablero[2][7] = new CasillaConObjeto("Imán atado con cuerda", true, new Objeto(3, "Coge lo que se encuentra al fondo del pozo!", "Imán atado con cuerda"));
        tablero[5][1] = new CasillaConObjeto("Papel con numeros", true, new Objeto(4, "Hay un candado en alguna parte, encuentralo!", "Papel con numeros"));
        tablero[8][6] = new CasillaConObjeto("Movimientos inscritos en la pared", true, new Objeto(5, "Parecen trucos del GTA!", "Movimientos inscritos en la pared"));

        // Casillas con misterios .
        tablero[1][8] = new CasillaConMisterio("Entrada de texto antiguo", true, 2); // Requiere el Papiro antiguo
        tablero[3][3] = new CasillaConMisterio("Pozo con algo metálico al fondo", true, 3); // Requiere el Imán atado con cuerda
        tablero[6][4] = new CasillaConMisterio("Candado", true, 4); // Requiere el Papel con numeros
        tablero[9][2] = new CasillaConMisterio("Candado con joystick", true, 5); // Requiere los Movimientos inscritos en la pared

        // Casilla con llave dorada, corre a la salida! 
        tablero[4][9] = new CasillaConObjeto("Casilla con llave dorada", true, new Objeto(1, "Llave dorada", "Corre a la salida!"));

        // Casilla final.
        tablero[9][9] = new CasillaFinal("Casilla final", true);

        // Casillas al vacío.
        tablero[0][5] = new CasillaAlVacio("Casilla al vacío", true);
        tablero[3][7] = new CasillaAlVacio("Casilla al vacío", true);
        tablero[6][0] = new CasillaAlVacio("Casilla al vacío", true);
        tablero[8][8] = new CasillaAlVacio("Casilla al vacío", true);
    }

    public Casilla getCasilla(int x, int y) {
        if (x >= 0 && x < 10 && y >= 0 && y < 10) {
            return tablero[x][y];
        }
        return null; // Fuera de límites
    }

    public void mostrarTablero(Jugador jugador) {
        for (int i = 0; i < 10; i++) { // Filas
            for (int j = 0; j < 10; j++) { // Columnas
                // Mostrar la posición del jugador, objetos, misterios y casillas vacías
                // [J] = Jugador, [M] = Misterio, [O] = Objeto, [F] = Final, [X] = Al vacío, [ ] = Transitable, [#] = No transitable
                if (i == jugador.getPosicionX() && j == jugador.getPosicionY()) {
                    System.out.print("[J]"); // Posición del jugador
                } else if (tablero[i][j] instanceof CasillaConMisterio) { 
                    System.out.print("[M]");
                } else if (tablero[i][j] instanceof CasillaConObjeto) {
                    System.out.print("[O]");
                } else if (tablero[i][j] instanceof CasillaFinal) {
                    System.out.print("[F]");
                } else if (tablero[i][j] instanceof CasillaAlVacio) {
                    System.out.print("[X]"); 
                } else if (tablero[i][j].verSiTransitable()) {
                    System.out.print("[ ]");
                } else {
                    System.out.print("[#]");
                }
            }
            System.out.println();
        }
    }

    public boolean esCasillaTransitable(int x, int y) {
        if (x < 0 || y < 0 || x >= tablero.length || y >= tablero[0].length) {
            return false; // Fuera de los límites del tablero.
        }
        return tablero[x][y].verSiTransitable();
    }

}

