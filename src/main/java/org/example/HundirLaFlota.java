package org.example;

import org.example.modelos.*;
import org.example.builders.*;

public class HundirLaFlota {
    public static void main(String[] args) {
        // Construir barcos para el jugador 1
        BattleshipBuilder battleshipBuilder1 = new BattleshipBuilder();
        FrigateBuilder frigateBuilder1 = new FrigateBuilder();
        CanoeBuilder canoeBuilder1 = new CanoeBuilder();

        Barco battleship1 = battleshipBuilder1.construir().getBarco();
        Barco frigate1 = frigateBuilder1.construir().getBarco();
        Barco canoe1 = canoeBuilder1.construir().getBarco();

        // Construir tablero para el jugador 1
        Tablero tablero1 = new Tablero.TableroBuilder()
                .añadirBarco(battleship1)
                .añadirBarco(frigate1)
                .añadirBarco(canoe1)
                .build();

        // Construir barcos para el jugador 2
        BattleshipBuilder battleshipBuilder2 = new BattleshipBuilder();
        FrigateBuilder frigateBuilder2 = new FrigateBuilder();
        CanoeBuilder canoeBuilder2 = new CanoeBuilder();

        Barco battleship2 = battleshipBuilder2.construir().getBarco();
        Barco frigate2 = frigateBuilder2.construir().getBarco();
        Barco canoe2 = canoeBuilder2.construir().getBarco();

        // Construir tablero para el jugador 2
        Tablero tablero2 = new Tablero.TableroBuilder()
                .añadirBarco(battleship2)
                .añadirBarco(frigate2)
                .añadirBarco(canoe2)
                .build();

        // Construir jugadores
        Jugador jugador1 = new Jugador.JugadorBuilder("Jugador 1")
                .conTablero(tablero1)
                .build();

        Jugador jugador2 = new Jugador.JugadorBuilder("Jugador 2")
                .conTablero(tablero2)
                .build();

        // Establecer tableros oponentes
        jugador1.setTableroOponente(tablero2);
        jugador2.setTableroOponente(tablero1);

        // Juego por turnos
        boolean juegoTerminado = false;
        Jugador jugadorActual = jugador1;
        Jugador oponente = jugador2;
        int turno = 1;

        while (!juegoTerminado) {
            System.out.println("\nTurno #" + turno + " - " + jugadorActual.getNombre());

            boolean impacto = jugadorActual.realizarDisparoAleatorio();
            System.out.println(impacto ? "¡Impacto!" : "Agua");

            if (oponente.getTablero().todosBarcosHundidos()) {
                System.out.println("\n¡" + jugadorActual.getNombre() + " ha ganado!");
                System.out.println("Total de turnos: " + turno);
                juegoTerminado = true;
            }

            // Cambiar turno
            Jugador temp = jugadorActual;
            jugadorActual = oponente;
            oponente = temp;
            turno++;
        }
    }
}