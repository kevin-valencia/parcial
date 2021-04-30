package Entidades;

public class Avion extends Vehiculos{

    private final String altitudMaxima;

    public Avion (String referencia, int velocidadMaxima, colores color, String altitudMaxima) {
        super(referencia, velocidadMaxima, color);
        this.altitudMaxima = altitudMaxima;
    }

   @Override
    public String toString() {
        return super.toString() +
                " Altitud maxima: " + this.altitudMaxima;
    }


}
