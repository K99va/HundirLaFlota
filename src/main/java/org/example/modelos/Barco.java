package org.example.modelos;

import java.util.ArrayList;
import java.util.List;

public abstract class Barco {
    protected int tamaño;
    protected List<Posicion> posiciones;
    protected List<Boolean> impactos;
    protected String numero;
    protected String nombre;
    protected String tipo;
    protected int nivel;

    public Barco(int tamaño) {
        this.tamaño = tamaño;
        this.posiciones = new ArrayList<>();
        this.impactos = new ArrayList<>();
        for (int i = 0; i < tamaño; i++) {
            impactos.add(false);
        }
    }

    public void establecerPosiciones(List<Posicion> posiciones) {
        if (posiciones.size() != tamaño) {
            throw new IllegalArgumentException("Número de posiciones incorrecto");
        }
        this.posiciones = posiciones;
    }

    public boolean recibirImpacto(Posicion posicion) {
        for (int i = 0; i < posiciones.size(); i++) {
            if (posiciones.get(i).equals(posicion)) {
                impactos.set(i, true);
                return true;
            }
        }
        return false;
    }

    public String getNumero() {
        return numero;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public int getNivel() {
        return nivel;
    }

    public boolean estaHundido() {
        return impactos.stream().allMatch(b -> b);
    }

    public int getTamaño() {
        return tamaño;
    }
}