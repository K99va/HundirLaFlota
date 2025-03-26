package org.example.builders;

import org.example.modelos.Battleship;

public class BattleshipBuilder extends BarcoBuilder {
    @Override
    public BarcoBuilder construir() {
        this.barco = new Battleship();
        return this;
    }
}