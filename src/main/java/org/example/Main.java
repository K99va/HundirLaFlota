package org.example;

import org.example.builder.ShipBuilder.ShipBuilder;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce el nombre del Jugador 1:");
        Player player1 = new Player(scanner.nextLine());
        System.out.println("Introduce el nombre del Jugador 2:");
        Player player2 = new Player(scanner.nextLine());

        for (int i = 0; i < 3; i++) {
            System.out.println(player1.getName() + ", elige un barco (battleship, frigate, canoe):");
            player1.addShip(new ShipBuilder().setType(scanner.nextLine()).build());
            System.out.println(player2.getName() + ", elige un barco (battleship, frigate, canoe):");
            player2.addShip(new ShipBuilder().setType(scanner.nextLine()).build());
        }

        while (true) {
            player1.attack(player2);
            player2.attack(player1);

            if (player1.allShipsSunk() && player2.allShipsSunk()) {
                System.out.println("Empate. Ambos jugadores han perdido todos sus barcos.");
                break;
            } else if (player1.allShipsSunk()) {
                System.out.println(player2.getName() + " gana la partida.");
                break;
            } else if (player2.allShipsSunk()) {
                System.out.println(player1.getName() + " gana la partida.");
                break;
            }
        }
    }
}

