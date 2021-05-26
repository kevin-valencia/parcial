/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilidades.Recolectores;

import Entidades.Vehiculos;
import Entidades.colores;

//Factory Method
public interface IRecolector {
    
    String getReferencia();
    String getVelocidadMax();
    colores getColor();
    Vehiculos obtenerVehivulo();
}
