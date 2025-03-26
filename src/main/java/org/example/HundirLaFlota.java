package org.example;

import org.example.gestores.GestorBarcos;
import org.example.modelos.*;
import org.example.builders.*;

public class HundirLaFlota {
    public static void main(String[] args) {
        // Configuración de barcos usando builders
        GestorBarcos gestor = new GestorBarcosBuilder()
                .agregarBarco(new BattleshipBuilder()
                        .conNumero("B001")
                        .conNombre("Acorazado Alpha")
                        .conNivel(1))
                .agregarBarco(new FrigateBuilder()
                        .conNumero("F001")
                        .conNombre("Fragata Veloz")
                        .conNivel(1))
                .agregarBarco(new CanoeBuilder()
                        .conNumero("C001")
                        .conNombre("Canoa Pequeña")
                        .conNivel(1))
                .build();

        // Construcción del juego (igual que antes pero usando barcos del gestor)
        Tablero tablero1 = new Tablero.TableroBuilder()
                .añadirBarco(gestor.buscarPorNumero("B001"))
                .añadirBarco(gestor.buscarPorNumero("F001"))
                .añadirBarco(gestor.buscarPorNumero("C001"))
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