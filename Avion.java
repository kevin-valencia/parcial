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
public class Avion extends Vehiculo{
    
    private double altitudMaxima;

    public Avion(double altitudMaxima, ColorEnum color, String referencia, double velocidadMaxima) {
        super(color, referencia, velocidadMaxima);
        this.altitudMaxima = altitudMaxima;
    }

    public Avion() {
    }

    public double getAltitudMaxima() {
        return altitudMaxima;
    }

    public void setAltitudMaxima(double altitudMaxima) {
        this.altitudMaxima = altitudMaxima;
    }
    
    @Override
    public String toString() {
        return "El avion con la referencia " + getReferencia() + " de color " + getColor() + " cuya velocidad maxima es " + getVelocidadMaxima() + " y con un maximo de " + getAltitudMaxima() + " de altitud";
    }
    
}
