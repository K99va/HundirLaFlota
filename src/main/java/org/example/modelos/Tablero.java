package org.example.modelos;

import java.util.ArrayList;
import java.util.List;

public class Tablero {
    private static final int FILAS = 12;
    private static final int COLUMNAS = 12;
    private List<Barco> barcos;
    private boolean[][] disparos;
    private int barcosHundidos;

    private Tablero(TableroBuilder builder) {
        this.barcos = builder.barcos;
        this.disparos = new boolean[FILAS][COLUMNAS];
        this.barcosHundidos = 0;
    }

    public int getFilas() {
        return FILAS;
    }

    public int getColumnas() {
        return COLUMNAS;
    }

    public boolean realizarDisparo(int x, int y) {
        if (x < 0 || x >= FILAS || y < 0 || y >= COLUMNAS || disparos[x][y]) {
            return false; // Disparo inválido o repetido
        }

        disparos[x][y] = true;
        boolean impacto = false;
        Posicion tiro = new Posicion(x, y);
        for (Barco barco : barcos) {
            if (!barco.estaHundido() && barcoEnPosicion(barco, x, y)) {
                barco.recibirImpacto(tiro);
                impacto = true;
                if (barco.estaHundido()) {
                    barcosHundidos++;
                }
            }
        }

        return impacto;
    }

    private boolean barcoEnPosicion(Barco barco, int x, int y) {
        // Implementación simplificada - en realidad necesitarías las posiciones exactas del barco
        return Math.random() < 0.3; // 30% de probabilidad de impacto para simular
    }

    public boolean todosBarcosHundidos() {
        return barcosHundidos == barcos.size();
    }

    public boolean[][] getDisparos() {
        return disparos;
    }

    public static class TableroBuilder {
        private List<Barco> barcos = new ArrayList<>();

        public TableroBuilder añadirBarco(Barco barco) {
            this.barcos.add(barco);
            return this;
        }

        public Tablero build() {
            return new Tablero(this);
        }
    }
}