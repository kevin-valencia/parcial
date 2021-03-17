/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vehiculos;

/**
 *
 * @author Kevin
 */
public class Carro extends Vehiculo{
    private int numeroDePuertas;

    public Carro(int numeroDePuertas, ColorEnum color, String referencia, double velocidadMaxima) {
        super(color, referencia, velocidadMaxima);
        this.numeroDePuertas = numeroDePuertas;
    }

    public Carro() {
    }

    public int getNumeroDePuertas() {
        return numeroDePuertas;
    }

    public void setNumeroDePuertas(int numeroDePuertas) {
        this.numeroDePuertas = numeroDePuertas;
    }

    @Override
    public String toString() {
        return "El carro con la referencia " + getReferencia() + " de color " + getColor() + " cuya velocidad maxima es " + getVelocidadMaxima() + " y con " + getNumeroDePuertas() + " puertas";
    }
    
}
