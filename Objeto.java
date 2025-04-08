package Proyecto;

public class Objeto {
    private int solucion;
    private String descripcion;

    public Objeto(int pSolucion, String pDescripcion) {
        this.solucion = pSolucion;
        this.descripcion = pDescripcion;
    }

    public int getSolucion() {
        return solucion;
    }

    public String getDescripcion() {
        return descripcion;
    }
}