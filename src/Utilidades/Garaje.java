/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilidades;

import Entidades.Vehiculos;
import excepciones.GarajeException;
import java.util.ArrayList;

//Singleton
public class Garaje {

    private final int MAXIMO_TAMAÑO_GARAJE = 10;
    private static Garaje garaje;
    ArrayList<Vehiculos> vehiculos;

    private Garaje() {
        vehiculos = new ArrayList<>();
    }

    public static Garaje getInstancia() {
        if (garaje == null) {
            garaje = new Garaje();
        }
        return garaje;
    }

    public void guardarEnGaraje(Vehiculos vehiculo) {
        if (!garajeLleno()) {
            vehiculos.add(vehiculo);
            System.out.println("Se agrego el vehiculo");
        } else {
            System.out.println("El garaje esta lleno");
            System.out.println(vehiculos);
            throw new GarajeException("El garaje esta totalemente lleno");
        }
    }

    public boolean garajeLleno() {
        if (vehiculos.size() < MAXIMO_TAMAÑO_GARAJE) {
            return false;
        }
        return true;
    }

    public boolean garajeVacio() {
        if (vehiculos.size() == 0) {
            return true;
        }
        return false;
    }

    public int obtenerNumeroVehiculos() {
        return vehiculos.size();
    }

    public Vehiculos obtenerVehiculoPorNumero(int posicion) {
        Vehiculos vehiculo = null;
        try {
            vehiculo = vehiculos.get(posicion - 1);
        } catch (Exception e) {
            System.out.println("El valor ingresado no es valido o no existe");
        }
        return vehiculo;
    }

    @Override
    public String toString() {
        String t = "Garaje con " + vehiculos.size() + " vehiculo(s):\n";
        int contador = 1;
        for (Vehiculos vehiculo : vehiculos) {
            t += "\n" + contador + ". " + vehiculo;
            contador += 1;
        }
        return t;
    }

}
