package org.example.builder.ShipBuilder;

import org.example.barcos.Battleship;
import org.example.barcos.Ship;
import org.example.barcos.Frigate;
import org.example.barcos.Canoe;


public class ShipBuilder {
    private String type;

    public ShipBuilder setType(String type) {
        this.type = type;
        return this;
    }

    public Ship build() {
        switch (type.toLowerCase()) {
            case "battleship":
                return new Battleship();
            case "frigate":
                return new Frigate();
            case "canoe":
                return new Canoe();
            default:
                throw new IllegalArgumentException("Tipo de barco no válido");
        }
    }
}