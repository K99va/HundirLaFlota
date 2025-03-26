package org.example;


import org.example.barcos.Ship;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


class Player {
    private String name;
    private List<Ship> ships;

    public Player(String name) {
        this.name = name;
        this.ships = new ArrayList<>();
    }

    public void addShip(Ship ship) {
        if (ships.size() < 3) {
            ships.add(ship);
        } else {
            System.out.println("No puedes añadir más de 3 barcos.");
        }
    }

    public boolean allShipsSunk() {
        return ships.stream().allMatch(Ship::isSunk);
    }

    public void attack(Player opponent) {
        if (!ships.isEmpty()) {
            Random rand = new Random();
            int target = rand.nextInt(opponent.ships.size());
            opponent.ships.get(target).hit();
        }
    }

    public String getName() {
        return name;
    }
}
