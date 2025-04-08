package Proyecto;

import java.util.ArrayList;
import java.util.Iterator;

public class ListaObjetos {
    private ArrayList<Objeto> lista;

    public ListaObjetos() {
        this.lista = new ArrayList<>();
    }

    public void buscarObjeto(Objeto pObjeto) {
        for (Objeto obj : lista) {
            if (obj.equals(pObjeto)) {
                System.out.println("Objeto encontrado: " + obj.getDescripcion());
                return;
            }
        }
        System.out.println("Objeto no encontrado.");
    }

    public Iterator<Objeto> getIterator() {
        return lista.iterator();
    }

    public boolean mismaSolucion(int pSolucion) {
        for (Objeto obj : lista) {
            if (obj.getSolucion() == pSolucion) {
                return true;
            }
        }
        return false;
    }

    public void agregarObjeto(Objeto pObjeto) {
        lista.add(pObjeto);
    }
}