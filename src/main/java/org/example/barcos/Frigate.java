package org.example.barcos;

public class Frigate extends Ship {
    public Frigate(String name, int number, int level) {
        super(3, name, number, "frigate", level);
    }

    @Override
    public boolean isSunk() {
        return hits >= size;
    }
}