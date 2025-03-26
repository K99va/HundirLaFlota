package org.example.barcos;

public class Canoe extends Ship {
    public Canoe(String name, int number, int level) {
        super(1, name, number, "canoe", level);
    }

    @Override
    public boolean isSunk() {
        return hits >= size;
    }
}