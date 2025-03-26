package org.example.barcos;

public class Frigate extends Ship {
    public Frigate() {
        super(3);
    }

    @Override
    public boolean isSunk() {
        return hits >= size;
    }
}