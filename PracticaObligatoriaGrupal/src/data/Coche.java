/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.io.Serializable;

/**
 *
 * @author David Sánchez Dueñas
 */
public class Coche implements Serializable{
    private String modelo;

    private double neumaticos,potencia,aerodinamica; 

    /**
     * IMPORTANTE: Nunca se debe crear un coche utilizando su clase, debe crearse
     * a partir de escuderia, de forma que cuando se cree quede ligado a esta.
     * 
     */
    Coche(String modelo, double neumaticos, double potencia, double aerodinamica) {
        this.modelo=modelo;
        this.neumaticos=neumaticos;
        this.potencia=potencia;
        this.aerodinamica=aerodinamica;
    }
    
    public double getVelMaxRecta() {
        return(this.aerodinamica*30)+(this.potencia*20);
    }

    public double getVelMaxCurva() {
        return(this.aerodinamica*10)+(this.potencia*10)+(this.neumaticos*10);
    }

    public void mejorar(){
    
    }
    
    
    
    /////////////SETERS Y GETERS/////////////////////////////////////////
    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public double getNeumaticos() {
        return neumaticos;
    }

    public void setNeumaticos(double neumaticos) {
        this.neumaticos = neumaticos;
    }

    public double getPotencia() {
        return potencia;
    }

    public void setPotencia(double potencia) {
        this.potencia = potencia;
    }

    public double getAerodinamica() {
        return aerodinamica;
    }

    public void setAerodinamica(double aerodinamica) {
        this.aerodinamica = aerodinamica;
    }
}