/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package primerexamen;

import Vehiculos.Avion;
import Vehiculos.Carro;
import Vehiculos.ColorEnum;
import Vehiculos.Vehiculo;
import Vehiculos.Yate;
import java.util.Scanner;

/**
 *
 * @author Kevin
 */
public class PrimerExamen {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner l = new Scanner(System.in);
        Vehiculo[] garaje = new Vehiculo[10];
        int opcion = 0, opcion2 = 0, lleno = 0;

        while (opcion != 3) {
            System.out.println("Seleccione una opcion:  ");
            System.out.println("    1. Agregar vehiculo.");
            System.out.println("    2. Mostrar garaje.");
            System.out.println("    3. Salir.");
            System.out.print("> ");
            opcion = l.nextInt();
            System.out.println("");
            l.nextLine();

            switch (opcion) {
                case 1:
                    if (lleno != 10) {
                        System.out.println("¿Cual es el tipo de vehiculo?");
                        System.out.println("    1. Avion.");
                        System.out.println("    2. Yate.");
                        System.out.println("    3. Carro.");
                        System.out.println("    4. Salir.");
                        System.out.print("> ");
                        opcion2 = l.nextInt();
                        l.nextLine();
                        System.out.println("");
                        String r = "";
                        System.out.println("Digite la referencia: ");
                        System.out.print("> ");
                        r = l.nextLine();
                        System.out.println("");
                        String c = "";
                        System.out.println("Digite el color (NEGRO, BLANCO, AZUL, VERDE, GRIS): ");
                        System.out.print("> ");
                        c = l.nextLine().toUpperCase().trim().replaceAll(" ", "");
                        System.out.println("");
                        double v = 0;
                        System.out.println("Digite la velocidad maxima: ");
                        System.out.print("> ");
                        v = l.nextDouble();
                        System.out.println("");
                        Vehiculo ve = null;
                        switch (opcion2) {
                            case 1:
                                double a = 0;
                                System.out.println("Digite la altitud maxima: ");
                                System.out.print("> ");
                                a = l.nextDouble();
                                ve = new Avion(a, Enum.valueOf(ColorEnum.class, c), r, v);
                                break;

                            case 2:
                                double y = 0;
                                System.out.println("Digite el peso maximo: ");
                                System.out.print("> ");
                                y = l.nextDouble();
                                ve = new Yate(y, Enum.valueOf(ColorEnum.class, c), r, v);
                                break;

                            case 3:
                                double p = 0;
                                System.out.println("Digite el numero de puertas: ");
                                System.out.print("> ");
                                p = l.nextDouble();
                                ve = new Carro((int) p, Enum.valueOf(ColorEnum.class, c), r, v);
                                break;

                            case 4:
                                System.out.println("Volviendo al menu");
                                break;
                            default:
                                System.out.println("Opcion no valida");
                        }
                        System.out.println("");
                        if (ve != null) {
                            garaje[lleno] = ve;
                            lleno++;
                        }

                    }
                    break;

                case 2:
                    System.out.println("Vehiculos del garaje: ");
                    for (int i = 0; i < lleno; i++) {
                        System.out.println(garaje[i]);
                    }
                    break;

                case 3:
                    System.out.println("Terminando programa");
                    break;
                default:
                    System.out.println("Opcion no valida");
            }
            System.out.println("");
        }
    }

}
