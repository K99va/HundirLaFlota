package org.example.barcos;

public abstract class Ship {
    protected int size;
    protected int hits;
    protected String name;
    protected int number;
    protected String type;
    protected int level;

    public Ship(int size, String name, int number, String type, int level) {
        this.size = size;
        this.hits = 0;
        this.name = name;
        this.number = number;
        this.type = type;
        this.level = level;
    }

    public abstract boolean isSunk();

    public void hit() {
        hits++;
    }

    public String getType() {
        return type;
    }

    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }
}