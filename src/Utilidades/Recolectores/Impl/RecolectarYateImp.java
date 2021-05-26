/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilidades.Recolectores.Impl;

import Entidades.Vehiculos;
import Entidades.Yate;
import Entidades.colores;
import Utilidades.Recolectores.IRecolector;
import java.util.Scanner;

//Factory Method
public class RecolectarYateImp implements IRecolector {

    Scanner entrada = new Scanner(System.in);

    @Override
    public String getReferencia() {
        System.out.println("Ingrese referencia:");
        return entrada.next();
    }

    @Override
    public String getVelocidadMax() {
        System.out.println("Ingrese velocidad maxima:");
        return entrada.next();
    }

    @Override
    public colores getColor() {
        colores color = null;
        boolean valido = true;
        do {
            try {
                System.out.println("Ingrese color");
                for (colores colorIndice : colores.values()) {  //Muestro los valores del ENUM
                    System.out.println("   " + colorIndice.ordinal() + ". " + colorIndice.toString()); //Muestro el indice y el nombre
                }
                String colorSelec = entrada.next(); //capturo la entrada del usuario
                color = colores.values()[Integer.parseInt(colorSelec)];
                valido = true;
            } catch (Exception e) {
                System.out.println("El color ingresado no es valido");
                valido = false;
            }
        } while (!valido);
        return color;
    }

    @Override
    public Vehiculos obtenerVehivulo() {
        return new Yate(getReferencia(), Integer.parseInt(getVelocidadMax()), getColor(), getPesoMaximo());
    }

    public int getPesoMaximo() {
        boolean valido = true;
        int peso = 0;
        do {
            try {
                System.out.println("Ingrese peso maximo");
                peso = Integer.parseInt(entrada.next());
                valido = true;
            } catch (Exception e) {
                System.out.println("El valor introducido no es valido, intentalo nuevamente \n");
                valido = false;
            }
        } while (!valido);

        return peso;

    }

}
