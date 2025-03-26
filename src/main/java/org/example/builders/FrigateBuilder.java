package org.example.builders;

import org.example.modelos.Frigate;

public class FrigateBuilder extends BarcoBuilder {
    @Override
    public BarcoBuilder construir() {
        this.barco = new Frigate();
        return this;
    }
}