package org.example.barcos;


public class Battleship extends Ship {
    private boolean[] sections;

    public Battleship(String name, int number, int level) {
        super(5, name, number, "battleship", level);
        sections = new boolean[size];
    }

    public void hit(int position) {
        if (position >= 0 && position < size) {
            sections[position] = true;
        }
    }

    @Override
    public boolean isSunk() {
        for (boolean section : sections) {
            if (!section) {
                return false;
            }
        }
        return true;
    }
}
