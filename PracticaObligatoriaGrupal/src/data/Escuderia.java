/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.ArrayList;

/**
 *
 * @author David Sánchez Dueñas
 */
public class Escuderia {
    private String dueño, nombre, pais;
    private int añoFundacion, puntosMundial;
    private double presupuesto;
    private ArrayList <String> directivos= new ArrayList<>();
    private Piloto[] pilotoOficial= new Piloto[2];
    private Piloto[] pilotoProbador= new Piloto[2];
    private Coche[] coches=new Coche[2];
    
    /**
     * Crea una escuderia a partir de los parametros especificados, 
     * NO RELLENA EL ARRAY COCHE NI LOS ARRAY DE PILOTOS, deben ser rellenados manualmente
     * @param dueño: propietario de la escuderia
     * @param nombre: nombre de la escuderia
     * @param pais: ubicacion de la sede de la escuderia
     * @param añoFundacion: año en formato entero (int)
     * @param puntosMundial: puntos obtenidos durante el mundial
     * @param presupuesto: capital del que dispone, admite decimales
     * @param directivos: arrayList de String con los nombres de los directivos
     */
    public Escuderia(String dueño, String nombre, String pais, int añoFundacion, int puntosMundial, double presupuesto, ArrayList <String> directivos) {
        this.añoFundacion=añoFundacion;
        this.directivos=directivos;
        this.dueño=dueño;
        this.nombre=nombre;
        this.pais=pais;
        this.puntosMundial=puntosMundial;
        this.presupuesto=presupuesto;
    }

    /**
     * Permite clonar una escuderia a partir de otra ya existente
     * 
     */
    public Escuderia(Escuderia e) {
        this.añoFundacion=e.getAñoFundacion();
        this.coches=e.getCoches();
        this.directivos=e.getDirectivos();
        this.dueño=e.getDueño();
        this.nombre=e.getNombre();
        this.pais=e.getPais();
        this.pilotoOficial=e.getPilotoOficial();
        this.pilotoProbador=e.getPilotoProbador();
        this.puntosMundial=e.getPuntosMundial();
        this.presupuesto=e.getPresupuesto();
    }
    
    public void ficharPiloto(){}
    public void comprobarLimite(){}
    public void descartarPiloto(){}
    public void iniciarEntrenamiento(){}
    public void realizarPago(){}
    public void iniciarMundial(){}
    public void pagarSueldo(){}
    public void comprobarDinero(){}
    
    
    
    
    /**
    *Crea un coche a partir de datos y lo introduce en el array coches de la escuderia
    * 
    */
    public void crearCoche(String modelo, double neumaticos, double potencia, double aerodinamica){
        boolean insertado=false;
        for (int i = 0; i < this.coches.length; i++) {
            if (this.coches[i]==null & !insertado) {
            this.coches[i]=new Coche(modelo, neumaticos, potencia, aerodinamica);
            System.out.println("Hay actualmente "+(i+1)+" vehiculo/s en la escuderia");
            insertado=true;
            } 
        }
        if(!insertado){
            System.out.println("Se ha alcanzado el numero maximo de coches para esta escuderia: "+this.coches.length+", vehiculo no insertado");
        }
    }
    
    /**
    *Crea un coche a partir de otro coche existente y lo introduce en el array coches de la escuderia
    * 
    */
    public void crearCoche(Coche c){
        boolean insertado=false;
        for (int i = 0; i < this.coches.length; i++) {
            if (this.coches[i]==null & !insertado) {
            this.coches[i]=new Coche(c.getModelo(), c.getNeumaticos(), c.getPotencia(), c.getAerodinamica());
            System.out.println("Hay actualmente "+(i+1)+" vehiculo/s en la escuderia");
            insertado=true;
            } 
        }
        if(!insertado){
            System.out.println("Se ha alcanzado el numero maximo de coches para esta escuderia: "+this.coches.length+", vehiculo no insertado");
        }
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    /////////////SETERS Y GETERS/////////////////////////////////////////
    public String getDueño() {
        return dueño;
    }

    public void setDueño(String dueño) {
        this.dueño = dueño;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public int getAñoFundacion() {
        return añoFundacion;
    }

    public void setAñoFundacion(int añoFundacion) {
        this.añoFundacion = añoFundacion;
    }

    public int getPuntosMundial() {
        return puntosMundial;
    }

    public void setPuntosMundial(int puntosMundial) {
        this.puntosMundial = puntosMundial;
    }

    public double getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(double presupuesto) {
        this.presupuesto = presupuesto;
    }

    public ArrayList<String> getDirectivos() {
        return directivos;
    }

    public void setDirectivos(ArrayList<String> directivos) {
        this.directivos = directivos;
    }

    public Piloto[] getPilotoOficial() {
        return pilotoOficial;
    }

    public void setPilotoOficial(Piloto[] pilotoOficial) {
        this.pilotoOficial = pilotoOficial;
    }

    public Piloto[] getPilotoProbador() {
        return pilotoProbador;
    }

    public void setPilotoProbador(Piloto[] pilotoProbador) {
        this.pilotoProbador = pilotoProbador;
    }

    public Coche[] getCoches() {
        return coches;
    }

    public void setCoches(Coche[] coches) {
        this.coches = coches;
    }
}
