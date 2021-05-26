package Entidades;


import Entidades.Vehiculos;

public class Yate  extends Vehiculos{




    private final int pesoMaximo;

    public Yate(String referencia, int velocidadMaxima, colores color, int pesoMaximo) {
        super(referencia, velocidadMaxima, color);
        this.pesoMaximo = pesoMaximo;
    }

    @Override
    public String toString() {
        return super.toString() +
                " Peso maximo: " + this.pesoMaximo;
    }
}