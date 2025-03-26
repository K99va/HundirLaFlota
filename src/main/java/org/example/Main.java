package org.example;

import org.example.builder.ShipBuilder.ShipBuilder;
import org.example.barcos.Ship;
import org.example.hash.ShipHashTable;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ShipHashTable shipHashTable = new ShipHashTable();

        for (int i = 0; i < 3; i++) {
            System.out.println("Introduce el nombre del barco:");
            String name = scanner.nextLine();

            System.out.println("Introduce el número del barco:");
            int number = scanner.nextInt();
            scanner.nextLine(); // Consumir newline

            System.out.println("Introduce el tipo del barco (battleship, frigate, canoe):");
            String type = scanner.nextLine();

            System.out.println("Introduce el nivel del barco:");
            int level = scanner.nextInt();
            scanner.nextLine(); // Consumir newline

            Ship ship = new ShipBuilder().setName(name).setNumber(number).setType(type).setLevel(level).build();
            shipHashTable.addShip(ship);
        }

        System.out.println("Barcos agregados correctamente en la tabla hash.");
    }
}
