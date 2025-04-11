package src;

import java.util.ArrayList;
import java.util.Iterator;

public class ListaObjetos {
    private ArrayList<Objeto> lista;

    public ListaObjetos() {
        this.lista = new ArrayList<>();
    }

    public Objeto buscarObjeto(Objeto pObjeto) {
        Iterator<Objeto> itr = getIterator(); 

        while (itr.hasNext()) {
            Objeto obj = itr.next(); 
            if (obj.equals(pObjeto)) {
                System.out.println("Objeto encontrado: " + obj.getDescripcion());
                return obj; 
            }
        }

        System.out.println("Objeto no encontrado."); 
        return null; // En caso de no encontrar el objeto devuelve null
    }

    private Iterator<Objeto> getIterator() {
        return lista.iterator();
    }


    public boolean mismaSolucion(int solucion) {
        Iterator<Objeto> itr = lista.iterator();
        while (itr.hasNext()) {
            Objeto obj = itr.next();
            if (obj.getSolucion() == solucion) {
                return true;
            }
        }
        return false;
    }

    public void agregarObjeto(Objeto pObjeto) {
        lista.add(pObjeto);
    }

    public void eliminarObjeto(int solucion) {
        Iterator<Objeto> itr = lista.iterator();
        while (itr.hasNext()) {
            Objeto obj = itr.next();
            if (obj.getSolucion() == solucion) {
                itr.remove(); // Eliminar el objeto usando el iterador
                System.out.println("Objeto con solución " + solucion + " eliminado del inventario.");
                return;
            }
        }
        System.out.println("No se encontró un objeto con solución " + solucion + " en el inventario.");
    }

    public void mostrarInventario() {
        if (lista.isEmpty()) {
            System.out.println("El inventario está vacío.");
        } else {
            System.out.println("Inventario actual:");
            for (Objeto obj : lista) {
                System.out.println("- " + obj.getNombre() + ": " + obj.getDescripcion());
            }
        }
    }
}
