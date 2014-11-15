/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

 import java.util.ArrayList;
import java.util.Scanner;
   
/**
 *
 * @author victor
 */
public class Circuito {
    private String nombre,patrocinador;
    private double precio;
    private int rectas,curvas,aforo;
    private ArrayList <Curva> listaCurvas;
    private ArrayList <Recta> listaRectas;
    Scanner teclado = new Scanner(System.in);
    
    public Circuito(String nombre, String patrocinador,int rectas,int curvas,
           double precio,int aforo,ArrayList listaCurvas,ArrayList listaRectas){
        this.setNombre(nombre);
        this.setPatrocinador(patrocinador);
        this.setRectas(rectas);
        this.setCurvas(curvas);
        this.setPrecio(precio);
        this.listaCurvas = new ArrayList ();
        
    }
    public void añadirCurvas(){
    int c=this.curvas;
    int l;//tengo q poner un scan  para iniciar la l por teclado
    l=teclado.nextInt();
     for (int i=0; i == c ;i++){
      listaCurvas.add(new Curva(l));   
     }
    }
    
     public void añadirRectas(){
    int r=this.rectas;
    int l;//tengo q poner un scan  para iniciar la l por teclado
    l=teclado.nextInt();
     for (int i=0; i == r ;i++){
      listaCurvas.add(new Curva(l));   
     }
    }
    ////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

     public int getAforo() {
        return aforo;
    }

    public void setAforo(int nombre) {
        this.aforo = aforo;
    }
    
    public String getPatrocinador() {
        return patrocinador;
    }

    public void setPatrocinador(String patrocinador) {
        this.patrocinador = patrocinador;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getRectas() {
        return rectas;
    }

    public void setRectas(int rectas) {
        this.rectas = rectas;
        if (this.rectas < 0){
        this.rectas = 0;
        }
    }
    public int getCurvas() {
        return curvas;
    }

    public void setCurvas(int curvas) {
        this.curvas = curvas;
        if (this.curvas < 0){
        this.curvas = 0;
        }
    }
  
            
    
}
