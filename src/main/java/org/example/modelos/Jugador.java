package org.example.modelos;

import java.util.Random;

public class Jugador {
    private String nombre;
    private Tablero tablero;
    private Tablero tableroOponente;
    private Random random;

    private Jugador(JugadorBuilder builder) {
        this.nombre = builder.nombre;
        this.tablero = builder.tablero;
        this.random = new Random();
    }

    public boolean realizarDisparoAleatorio() {
        if (tableroOponente == null) {
            throw new IllegalStateException("Tablero oponente no establecido");
        }

        boolean[][] disparosRealizados = tableroOponente.getDisparos();
        int filas = tableroOponente.getFilas();
        int columnas = tableroOponente.getColumnas();

        // Contar disparos no realizados
        int disparosDisponibles = 0;
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (!disparosRealizados[i][j]) {
                    disparosDisponibles++;
                }
            }
        }

        if (disparosDisponibles == 0) {
            return false; // No quedan casillas por disparar
        }

        // Seleccionar un disparo aleatorio entre los disponibles
        int objetivo = random.nextInt(disparosDisponibles) + 1;
        int contador = 0;

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (!disparosRealizados[i][j]) {
                    contador++;
                    if (contador == objetivo) {
                        return tableroOponente.realizarDisparo(i, j);
                    }
                }
            }
        }

        return false;
    }

    public void setTableroOponente(Tablero tableroOponente) {
        this.tableroOponente = tableroOponente;
    }

    public Tablero getTablero() {
        return tablero;
    }

    public String getNombre() {
        return nombre;
    }

    public static class JugadorBuilder {
        private String nombre;
        private Tablero tablero;

        public JugadorBuilder(String nombre) {
            this.nombre = nombre;
        }

        public JugadorBuilder conTablero(Tablero tablero) {
            this.tablero = tablero;
            return this;
        }

        public Jugador build() {
            return new Jugador(this);
        }
    }
}