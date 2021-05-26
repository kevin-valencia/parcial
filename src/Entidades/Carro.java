package Entidades;

public class Carro extends Vehiculos {


    private final int numerodepuertas;

    public Carro(String referencia, int velocidadMaxima, colores color, int numerodepuertas) {
        super(referencia, velocidadMaxima, color);
        this.numerodepuertas = numerodepuertas;
    }

    @Override
    public String toString() {
        return super.toString() +
                " Numero de puertas: " + this.numerodepuertas;
    }
}