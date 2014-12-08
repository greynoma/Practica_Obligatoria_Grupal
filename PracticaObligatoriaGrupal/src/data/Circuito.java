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
    private double precio,tiempoCoche,tiempoPiloto;
    private int rectas,curvas,aforo,lCurva,lRecta;
    private ArrayList <Curva> listaCurvas; //si lo pones ArrayList <int> ¿funcionara?
    private ArrayList <Recta> listaRectas;
    private ArrayList <Piloto> participante;
    Scanner teclado = new Scanner(System.in);
    private ArrayList <Piloto> posicion;
    
    
    public Circuito(String nombre, String patrocinador,int rectas,int curvas,
           double precio,int aforo){
        this.setNombre(nombre);
        this.setPatrocinador(patrocinador);
        this.setRectas(rectas);
        this.setCurvas(curvas);
        this.setPrecio(precio);
        this.añadirCurvas();
        this.añadirRectas();
        this.setAforo(aforo);
        
    }
    /**
     * metes el valor de cada curva individual por orden
     */
    public void añadirCurvas(){
    int c=this.curvas;
    int l;//tengo q poner un scan  para iniciar la l por teclado
    l=teclado.nextInt();
     for (int i=0; i <= c ;i++){
      listaCurvas.add(new Curva(l));   
     }
    }
    /**
     * metes el valor de cada recta individual por orden
     */
     public void añadirRectas(){
    int r=this.rectas;
    int l;//tengo q poner un scan  para iniciar la l por teclado
    l=teclado.nextInt();
     for (int i=0; i <= r ;i++){
      listaRectas.add(new Recta(l));   
     }
    }
     /**
     * segun la posicion en la que esten se les paara a las escuderias
     * un premio
     */
     public void pagar (){
       // tengo que cojer la escuderia del piloto y sumarler al presupuesto el premio
         posicion.get(0).getEscuderia().setPresupuesto(posicion.get(0).getEscuderia().getPresupuesto()+100000);
         posicion.get(1).getEscuderia().setPresupuesto(posicion.get(1).getEscuderia().getPresupuesto()+75000);
         posicion.get(2).getEscuderia().setPresupuesto(posicion.get(2).getEscuderia().getPresupuesto()+50000);
         posicion.get(3).getEscuderia().setPresupuesto(posicion.get(3).getEscuderia().getPresupuesto()+25000);
         posicion.get(4).getEscuderia().setPresupuesto(posicion.get(4).getEscuderia().getPresupuesto()+15000);
         posicion.get(5).getEscuderia().setPresupuesto(posicion.get(5).getEscuderia().getPresupuesto()+10000);
     }
     /**
     * se le suman puntos a los pilotos
     */
     public void puntos(){
         posicion.get(0).setPuntos(posicion.get(0).getPuntos()+25);
         posicion.get(1).setPuntos(posicion.get(1).getPuntos()+18);
         posicion.get(2).setPuntos(posicion.get(2).getPuntos()+15);
         posicion.get(3).setPuntos(posicion.get(3).getPuntos()+12);
         posicion.get(4).setPuntos(posicion.get(4).getPuntos()+10);
         posicion.get(5).setPuntos(posicion.get(5).getPuntos()+8);
         posicion.get(6).setPuntos(posicion.get(6).getPuntos()+6);
         posicion.get(7).setPuntos(posicion.get(7).getPuntos()+4);
         posicion.get(8).setPuntos(posicion.get(8).getPuntos()+2);
         posicion.get(9).setPuntos(posicion.get(9).getPuntos()+1);
     }
     public void tiempos(){  //coge el tiempo de participante para saber las posiciones
         for (int i=0; i <= this.curvas ;i++){
             lCurva=+listaCurvas.get(i).getL(); //arry list tienes que usar .get(i) para cojer el objeto
         }
         for (int i=0; i <= this.curvas ;i++){
             lRecta=+listaRectas.get(i).getL(); //arry list tienes que usar .get(i) para cojer el objeto
         }
         for (int i=0;i<=participante.size(); i++){
             participante.get(i).setTiempo(((lRecta/participante.get(i).getCoche().getVelMaxRecta())+(lCurva/participante.get(i).getCoche().getVelMaxCurva()))-( participante.get(i).getValor()*0.1));
             posicion.add(participante.get(i));
         } //ahora hay que ordenar los tiempos para la clasificacion
         
         for (int i=0; i<=participante.size()-1;i++){
             for(int j=0; j<=participante.size()-i;i++){
              if (posicion.get(j).getTiempo()> posicion.get(j+1).getTiempo()){
               Piloto aux= posicion.get(j);//hay que crear aux como piloto
                posicion.add(j, posicion.get(j+1));
                posicion.add(j+1, aux);    
               } //se acaba el if 
             }//ordena
         }//termina de ordenar
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

    public ArrayList<Piloto> getParticipante() {
        return participante;
    }

    public void setParticipante(ArrayList<Piloto> participante) {
        this.participante = participante;
    }

    
}
