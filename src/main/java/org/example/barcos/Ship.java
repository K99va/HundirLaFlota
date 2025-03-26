package org.example.barcos;

public abstract class Ship {
    protected int size;
    protected int hits;

    public Ship(int size) {
        this.size = size;
        this.hits = 0;
    }

    public abstract boolean isSunk();

    public void hit() {
        hits++;
    }
}