/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

/**
 *
 * @author Phoenix
 */
public class Coche {
//david te he hecho estos dos metodos que los necesitaba para el circuito
    private double neumaticos,potencia,aerodinamica; 
    
    public double getVelMaxRecta() {
        return(this.aerodinamica*30)+(this.potencia*20);
        
    }

    public double getVelMaxCurva() {
        return(this.aerodinamica*10)+(this.potencia*10)+(this.neumaticos*10);
    }
    
}
