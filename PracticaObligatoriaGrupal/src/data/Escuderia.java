/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.ArrayList;

/**
 *
 * @author Phoenix
 */
public class Escuderia {
    private String dueño, nombre, pais;
    private int añoFundacion, puntosMundial;
    private double presupuesto;
    private ArrayList <String> directivos= new ArrayList<>();
    private Piloto[] pilotoOficial= new Piloto[2];
    private Piloto[] pilotoProbador= new Piloto[2];
    private Coche[] coches=new Coche[2];
    
    public Escuderia(String dueño, String nombre, String pais, int añoFundacion, int puntosMundial, double presupuesto, ArrayList <String> directivos, Piloto[] pilotoOficial, Piloto[] pilotoProbador, Coche[] coches) {
        this.añoFundacion=añoFundacion;
        this.coches=coches;
        this.directivos=directivos;
        this.dueño=dueño;
        this.nombre=nombre;
        this.pais=pais;
        this.pilotoOficial=pilotoOficial;
        this.pilotoProbador=pilotoProbador;
        this.puntosMundial=puntosMundial;
        this.presupuesto=presupuesto;
    }

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
