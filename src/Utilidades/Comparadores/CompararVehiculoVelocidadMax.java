/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilidades.Comparadores;

import Entidades.Vehiculos;
import java.util.Comparator;

/**
 *
 * @author Santiago
 */
public class CompararVehiculoVelocidadMax implements Comparator<Vehiculos>{

    @Override
    public int compare(Vehiculos v1, Vehiculos v2) {
        if(v1.getVelocidadMaxima() > v2.getVelocidadMaxima()){
            return -1;
        }else if(v1.getVelocidadMaxima() == v2.getVelocidadMaxima()){
            return 0;
        }else{
            return 1;
        }
    }
    
    
    
}
