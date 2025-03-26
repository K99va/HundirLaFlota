package org.example.modelos;


public class Battleship extends Barco {
    public Battleship(String numero, String nombre, int nivel) {
        super(5);
        this.numero = numero;
        this.nombre = nombre;
        this.tipo = "Battleship";
        this.nivel = nivel;
    }
    // ... resto de la implementación
}