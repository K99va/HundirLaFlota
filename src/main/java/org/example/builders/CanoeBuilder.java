package org.example.builders;

import org.example.modelos.Canoe;

public class CanoeBuilder extends BarcoBuilder {
    @Override
    public BarcoBuilder construir() {
        this.barco = new Canoe();
        return this;
    }
}