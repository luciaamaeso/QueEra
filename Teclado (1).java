package src;

import java.util.Scanner;

public class Teclado {
    private Scanner scanner;

    public Teclado() {
        this.scanner = new Scanner(System.in); // No cerrar el Scanner para evitar problemas con la entrada.
    }

    public Scanner getScanner() {
        return scanner;
    }
}