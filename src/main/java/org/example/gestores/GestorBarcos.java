package org.example.gestores;

import org.example.modelos.Barco;
import java.util.HashMap;
import java.util.LinkedList;

public class GestorBarcos {
    private static GestorBarcos instance;
    private HashMap<String, LinkedList<Barco>> tablaPorTipo;
    private Barco[] tablaPorNumero;
    private Barco[] tablaPorNombre;

    private GestorBarcos() {
        // Constructor privado para singleton
    }

    public static synchronized GestorBarcos getInstance() {
        if (instance == null) {
            instance = new GestorBarcos();
        }
        return instance;
    }

    protected void inicializarTablas(HashMap<String, LinkedList<Barco>> tablaPorTipo,
                                     Barco[] tablaPorNumero,
                                     Barco[] tablaPorNombre) {
        this.tablaPorTipo = tablaPorTipo;
        this.tablaPorNumero = tablaPorNumero;
        this.tablaPorNombre = tablaPorNombre;
    }

    // Métodos de búsqueda
    public LinkedList<Barco> buscarPorTipo(String tipo) {
        return tablaPorTipo.getOrDefault(tipo, new LinkedList<>());
    }

    public Barco buscarPorNumero(String numero) {
        int indice = hashNumero(numero);
        Barco barco = tablaPorNumero[indice];

        while (barco != null && !barco.getNumero().equals(numero)) {
            indice = (indice + 1) % tablaPorNumero.length;
            barco = tablaPorNumero[indice];
        }

        return barco;
    }

    public Barco buscarPorNombre(String nombre) {
        int indice = hashNombre(nombre);
        Barco barco = tablaPorNombre[indice];

        while (barco != null && !barco.getNombre().equals(nombre)) {
            indice = (indice + 1) % tablaPorNombre.length;
            barco = tablaPorNombre[indice];
        }

        return barco;
    }

    // Funciones hash internas (consistentes con el builder)
    private int hashNumero(String numero) {
        return Math.abs(numero.hashCode()) % tablaPorNumero.length;
    }

    private int hashNombre(String nombre) {
        return Math.abs(nombre.hashCode()) % tablaPorNombre.length;
    }
}