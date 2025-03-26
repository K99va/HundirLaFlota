package org.example.builders;

import org.example.modelos.Barco;

public abstract class BarcoBuilder {
    protected Barco barco;

    public abstract BarcoBuilder construir();

    public Barco getBarco() {
        return barco;
    }
}