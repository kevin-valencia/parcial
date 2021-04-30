package Utilidades;

import Entidades.Avion;
import Entidades.Carro;
import Entidades.Vehiculos;
import Entidades.Yate;
import Entidades.colores;
import Utilidades.Recolectores.Impl.RecolectarAvionImp;
import Utilidades.Recolectores.Impl.RecolectarCarroImp;
import Utilidades.Recolectores.Impl.RecolectarYateImp;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Santiago
 */
public class Menu {

    private Scanner entrada;
    private Garaje garaje = Garaje.getInstancia();

    public Menu() {
        entrada = new Scanner(System.in);
    }

    private void imprimirMenu() {
        System.out.println("¿Deseas agregar un vehiculo?"
                + "\n 1. Sí"
                + "\n 2. Mostrar garaje"
                + "\n 3. Clonar vehiculo en el garaje"
                + "\n 4. Salir");
    }

    private void imprimirMenuVehiculos() {
        System.out.println("Elija una opción: "
                + "\n A. Avion"
                + "\n B. Yate"
                + "\n C. Carro"
                + "\n D. Salir");
    }

    private void correrMenuVehiculos() {
        String opcionVehiculo = "Z";
        do {
            if (garaje.garajeLleno()) {
                System.out.println("El garaje esta lleno");
                break;
            } else {
                opcionVehiculo = elegirOpcionVehiculo();
            }
        } while (opcionVehiculo != "D");
    }

    public void correrMenu() {
        int opcion = 0;
        do {
            imprimirMenu();
            opcion = elegirOpcion();
        } while (opcion != 4);
    }

    private int elegirOpcion() {
        int opcion = 0;
        try {
            opcion = Integer.parseInt(entrada.next());
        } catch (Exception e) {
            System.out.println("El valor introducido en el menú no es valido");
        }

        switch (opcion) {
            case 1:
                correrMenuVehiculos();
                break;
            case 2:
                if (garaje.garajeVacio()) {
                    System.out.println("El garaje esta vacio");
                } else {
                    System.out.println(garaje);
                }
                break;

            case 3:
                if (garaje.garajeVacio()) {
                    System.out.println("No hay vehiculo clonar");
                } else {
                    try {
                        System.out.println(garaje);
                        System.out.println("");
                        System.out.println("Seleccione un vehiculo (El numero)");
                        String v = entrada.next();
                        Vehiculos ve = garaje.obtenerVehiculoPorNumero(Integer.parseInt(v));
                        if (ve == null) {
                            System.out.println("El valor que ingreso no es valido o esta por fuera del limite");
                        } else {
                            garaje.guardarEnGaraje(ve);
                        }

                    } catch (Exception e) {
                        System.out.println("El valor ingresado no es valido");
                    }
                }
                break;

            case 4:
                System.out.println("Hasta luego!");
                break;
            default:
                System.out.println("Digitaste una opcion incorrecta ");
        }
        return opcion;
    }

    private String elegirOpcionVehiculo() {
        imprimirMenuVehiculos();
        String opcionVehiculo = "Z";
        try {
            opcionVehiculo = entrada.next().toUpperCase();
        } catch (Exception e) {
            System.out.println("El valor introducido en el menú no es valido");
        }

        switch (opcionVehiculo) {

            case "A":
                System.out.println("Ingrese los datos del avion");

                garaje.guardarEnGaraje(new RecolectarAvionImp().obtenerVehivulo());
                System.out.println("vehiculo Agregado");
                break;

            case "B":
                System.out.println("Ingrese los datos del Yate");

                garaje.guardarEnGaraje(new RecolectarYateImp().obtenerVehivulo());
                System.out.println("vehiculo agregado");
                break;
            case "C":
                System.out.println("Ingrese los datos del Carro");

                garaje.guardarEnGaraje(new RecolectarCarroImp().obtenerVehivulo());
                System.out.println("vehiculo agregado");
                break;
            case "D":
                System.out.println("Hasta luego! ");
                opcionVehiculo = "D";
                break;

            default:
                System.out.println("digitaste una opcion incorrecta ");
        }
        return opcionVehiculo;
    }
}
