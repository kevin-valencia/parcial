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
public class Yate extends Vehiculo{
    private double pesoMaximo;

    public Yate(double pesoMaximo, ColorEnum color, String referencia, double velocidadMaxima) {
        super(color, referencia, velocidadMaxima);
        this.pesoMaximo = pesoMaximo;
    }

    public Yate() {
    }

    public double getPesoMaximo() {
        return pesoMaximo;
    }

    public void setPesoMaximo(double pesoMaximo) {
        this.pesoMaximo = pesoMaximo;
    }
    
    @Override
    public String toString() {
        return "El yate con la referencia " + getReferencia() + " de color " + getColor() + " cuya velocidad maxima es " + getVelocidadMaxima() + " y con un maximo de " + getPesoMaximo() + " de peso";
    }
    
}
