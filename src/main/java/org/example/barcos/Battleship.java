package org.example.barcos;

public class Battleship extends Ship {
    private boolean[] sections; // Cada parte del barco es independiente

    public Battleship() {
        super(5);
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
                boolean b = false;
                return b;
            }
        }
        return true;
    }
}
