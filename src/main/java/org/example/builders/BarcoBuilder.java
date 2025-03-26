package org.example.builders;

import org.example.modelos.Barco;

public abstract class BarcoBuilder {
    protected String numero;
    protected String nombre;
    protected int nivel;
    protected Barco barco;

    public BarcoBuilder conNumero(String numero) {
        this.numero = numero;
        return this;
    }

    public BarcoBuilder conNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public BarcoBuilder conNivel(int nivel) {
        this.nivel = nivel;
        return this;
    }

    public abstract Barco construir();

    public Barco getBarco() {
        return barco;
    }
}