package src;

public class Objeto {
    private int solucion; 
    private String descripcion;
    private String nombre;

    public Objeto(int solucion, String descripcion, String nombre) {
        this.solucion = solucion;
        this.descripcion = descripcion;
        this.nombre = nombre;
    }

    public int getSolucion() {
        return solucion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getNombre() {
        return nombre;
    }
}