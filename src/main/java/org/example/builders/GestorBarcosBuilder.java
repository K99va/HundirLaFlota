package org.example.builders;

import org.example.builders.BarcoBuilder;
import org.example.modelos.Barco;
import org.example.gestores.GestorBarcos;
import java.util.HashMap;
import java.util.LinkedList;

public class GestorBarcosBuilder {
    private final GestorBarcos gestorBarcos;
    private final HashMap<String, LinkedList<Barco>> tablaPorTipo;
    private final Barco[] tablaPorNumero;
    private final Barco[] tablaPorNombre;
    private static final int TAMANO_TABLA_NUMERO = 15;
    private static final int TAMANO_TABLA_NOMBRE = 15;

    public GestorBarcosBuilder() {
        this.gestorBarcos = GestorBarcos.getInstance();
        this.tablaPorTipo = new HashMap<>();
        this.tablaPorNumero = new Barco[TAMANO_TABLA_NUMERO];
        this.tablaPorNombre = new Barco[TAMANO_TABLA_NOMBRE];
    }

    // Método para agregar un barco usando su builder
    public GestorBarcosBuilder agregarBarco(BarcoBuilder barcoBuilder) {
        Barco barco = barcoBuilder.construir().getBarco();
        agregarATablas(barco);
        return this;
    }

    // Método para agregar un barco ya construido
    public GestorBarcosBuilder agregarBarco(Barco barco) {
        agregarATablas(barco);
        return this;
    }

    private void agregarATablas(Barco barco) {
        // Agregar a tabla por tipo
        agregarATablaPorTipo(barco);

        // Agregar a tabla por número
        agregarATablaPorNumero(barco);

        // Agregar a tabla por nombre
        agregarATablaPorNombre(barco);
    }

    private void agregarATablaPorTipo(Barco barco) {
        // Para barcos multi-tipo
        if (barco instanceof MultiTipoBarco) {
            MultiTipoBarco multiTipoBarco = (MultiTipoBarco) barco;
            for (String tipo : multiTipoBarco.getTipos()) {
                tablaPorTipo.computeIfAbsent(tipo, k -> new LinkedList<>()).add(barco);
            }
        } else {
            tablaPorTipo.computeIfAbsent(barco.getTipo(), k -> new LinkedList<>()).add(barco);
        }
    }

    private void agregarATablaPorNumero(Barco barco) {
        int indice = hashNumero(barco.getNumero());
        if (tablaPorNumero[indice] != null) {
            indice = sondeoLineal(indice, tablaPorNumero);
        }
        tablaPorNumero[indice] = barco;
    }

    private void agregarATablaPorNombre(Barco barco) {
        int indice = hashNombre(barco.getNombre());
        if (tablaPorNombre[indice] != null) {
            indice = sondeoLineal(indice, tablaPorNombre);
        }
        tablaPorNombre[indice] = barco;
    }

    // Funciones hash auxiliares
    private int hashNumero(String numero) {
        return Math.abs(numero.hashCode()) % TAMANO_TABLA_NUMERO;
    }

    private int hashNombre(String nombre) {
        return Math.abs(nombre.hashCode()) % TAMANO_TABLA_NOMBRE;
    }

    // Manejo de colisiones con sondeo lineal
    private int sondeoLineal(int indice, Barco[] tabla) {
        int nuevoIndice = indice;
        while (tabla[nuevoIndice] != null) {
            nuevoIndice = (nuevoIndice + 1) % tabla.length;
            if (nuevoIndice == indice) {
                throw new RuntimeException("Tabla llena, no se puede agregar más barcos");
            }
        }
        return nuevoIndice;
    }

    // Método para construir el gestor final
    public GestorBarcos build() {
        gestorBarcos.inicializarTablas(tablaPorTipo, tablaPorNumero, tablaPorNombre);
        return gestorBarcos;
    }
}

