package org.example.modelos;

public class Frigate extends Barco {
    public Frigate(String numero, String nombre, int nivel) {
        super(3);
        this.numero = numero;
        this.nombre = nombre;
        this.tipo = "Frigate";
        this.nivel = nivel;
    }
}