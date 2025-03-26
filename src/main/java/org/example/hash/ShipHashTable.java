package org.example.hash;

import org.example.barcos.Ship;
import java.util.HashMap;
import java.util.Map;

public class ShipHashTable {
    private Map<String, Map<Integer, Map<String, Ship>>> shipTable;

    public ShipHashTable() {
        shipTable = new HashMap<>();
    }

    public void addShip(Ship ship) {
        shipTable.putIfAbsent(ship.getType(), new HashMap<>());
        Map<Integer, Map<String, Ship>> numberTable = shipTable.get(ship.getType());

        numberTable.putIfAbsent(ship.getNumber(), new HashMap<>());
        Map<String, Ship> nameTable = numberTable.get(ship.getNumber());

        nameTable.put(ship.getName(), ship);
    }

    public Ship getShip(String type, int number, String name) {
        return shipTable.getOrDefault(type, new HashMap<>())
                .getOrDefault(number, new HashMap<>())
                .get(name);
    }
}