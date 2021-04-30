package Entidades;

//Prototype
public class Vehiculos implements IVehiculo{



        //private  final String color;
        private  final String referencia;
        private final int velocidadMaxima;
        private colores color;



        public Vehiculos(String referencia, int velocidadMaxima, colores color) {
            this.referencia = referencia;
            this.velocidadMaxima = velocidadMaxima;
            this.color= color;


        }



    public String getReferencia() {
        return referencia;
    }

    public int getVelocidadMaxima() {
        return velocidadMaxima;
    }

    public colores getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "Referencia: " + referencia +
                " Velocidad maxima: " + velocidadMaxima +
                " Color: " + color;
    }

    @Override
    public IVehiculo clonar() {
        Vehiculos v = null;
        try {
            v = (Vehiculos) clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return v;
    }

    public void setColor(colores color) {
        this.color = color;
    }
}

