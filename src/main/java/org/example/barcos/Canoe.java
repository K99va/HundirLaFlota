package org.example.barcos;

public class Canoe extends Ship {
    public Canoe() {
        super(1);
    }

    @Override
    public boolean isSunk() {
        return hits >= size;
    }
}
