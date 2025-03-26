package org.example.modelos;

public class Canoe extends Barco {
    public Canoe(String numero, String nombre, int nivel) {
        super(1);
        this.numero = numero;
        this.nombre = nombre;
        this.tipo = "Canoe";
        this.nivel = nivel;
    }
}