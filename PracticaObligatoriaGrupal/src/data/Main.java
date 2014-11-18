/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.io.IOException;

/**
 *
 * @author Phoenix
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        Mundial f1= new Mundial();
        Circuito monaco= new Circuito();
        f1.cargarDatosCircuito();
        f1.modificar();
        
        /*Escuderia mercedes= new Escuderia("Tom Morello", "Mercedes", "Tegucigalpa", 1985, 0, 10000.5, null);
        mercedes.crearCoche("M-100", 3, 2, 1);
        mercedes.crearCoche("M-105", 3, 2, 1);
        mercedes.crearCoche("M-205", 3, 2, 1);
        */   
    }
    
}
