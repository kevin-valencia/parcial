/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilidades;

import Entidades.Vehiculos;
import Entidades.colores;
import Utilidades.Comparadores.CompararVehiculoVelocidadMax;
import excepciones.GarajeException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.toList;

//Singleton
public class Garaje {

    private final int MAXIMO_TAMAÑO_GARAJE = 10;
    private static Garaje garaje;
    ArrayList<Vehiculos> vehiculos;
    String referencias;

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

    public void sort() {
        if (vehiculos == null || vehiculos.size() == 0) {
            System.out.println("No se puede ordenar una lista vacia");
        } else {
            Collections.sort(vehiculos, new CompararVehiculoVelocidadMax());
        }
    }

    public Vehiculos max() {
        if (vehiculos == null || vehiculos.size() == 0) {
            System.out.println("No se puede buscar en una lista vacia");
            return null;
        } else {
            return Collections.max(vehiculos, new CompararVehiculoVelocidadMax());
        }
    }

    public Vehiculos min() {
        if (vehiculos == null || vehiculos.size() == 0) {
            System.out.println("No se puede buscar en una lista vacia");
            return null;
        } else {
            return Collections.min(vehiculos, new CompararVehiculoVelocidadMax());
        }
    }

    public void filterNegroAzul() {
        if (vehiculos == null || vehiculos.isEmpty()) {
            System.out.println("No se puede ordenar una lista vacia");
        } else {
            System.out.println("Los vehiculos de color azul o negro");
            vehiculos.stream().filter(v -> v.getColor() == colores.Negro || v.getColor() == colores.Azul).forEach(System.out::println);
        }
    }

    public String stringVerdeBlanco() {
        if (vehiculos == null || vehiculos.isEmpty()) {
            System.out.println("No se puede ordenar una lista vacia");
            referencias = "";
            return referencias;
        } else {
            System.out.println("Los vehiculos de color blanco o verde");
            referencias = vehiculos
                    .stream()
                    .filter(v -> v.getColor() == colores.Verde || v.getColor() == colores.Blanco).map(v -> v.getReferencia())
                    .reduce("", (acumulator, element) -> acumulator + " " + element);
            return referencias;
        }
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
