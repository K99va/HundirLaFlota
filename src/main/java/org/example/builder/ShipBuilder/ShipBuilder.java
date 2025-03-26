package org.example.builder.ShipBuilder;

import org.example.barcos.Battleship;
import org.example.barcos.Canoe;
import org.example.barcos.Frigate;
import org.example.barcos.Ship;

public class ShipBuilder {
    private String type;
    private String name;
    private int number;
    private int level;

    public ShipBuilder setType(String type) {
        this.type = type;
        return this;
    }

    public ShipBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public ShipBuilder setNumber(int number) {
        this.number = number;
        return this;
    }

    public ShipBuilder setLevel(int level) {
        this.level = level;
        return this;
    }

    public Ship build() {
        switch (type.toLowerCase()) {
            case "battleship":
                return new Battleship(name, number, level);
            case "frigate":
                return new Frigate(name, number, level);
            case "canoe":
                return new Canoe(name, number, level);
            default:
                throw new IllegalArgumentException("Tipo de barco no válido");
        }
    }
}
