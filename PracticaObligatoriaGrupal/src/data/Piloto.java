/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.io.Serializable;

/**
 *
 * @author victor m martinezs severiano
 */
public class Piloto implements Serializable {   //victor, he puesto que sea serializable la clase piloto para poderla guardar en el archivo(David)
 private String  nombre , apellido;
 private int edad ,puntos;
 private transient Escuderia escuderia;         //aqui he puesto transient para que al guardarlo en el archivo, como no tiene escuderia (es un piloto libre) se borre la informacion automaticamente(David)
 private Coche coche;
 private transient boolean tipo;                //aqui he puesto transient para que al guardarlo en el archivo, se borre la informacion automaticamente(David)
 private double  tiempo,altura, peso,reflejos, agresividad, paciencia, valentia, valor, sueldo;

   public Piloto(Piloto p){
       this.setAgresividad(p.agresividad);
     this.setAltura(p.altura);
     this.setApellido(p.apellido);
     this.setEdad(p.edad);
     this.setEscuderia(p.escuderia);
     this.setNombre(p.nombre);
     this.setPaciencia(p.paciencia);
     this.setPeso(p.peso);
     this.setReflejos(p.reflejos);
     this.setValentia(p.valentia);
     this.calcular();
       
       
   }
   public Piloto(String nombre, String apellido,int edad,Escuderia escuderia,int altura,int peso,
           double reflejos,double agresividad,double paciencia,double valentia){
     this.setAgresividad(agresividad);
     this.setAltura(altura);
     this.setApellido(apellido);
     this.setEdad(edad);
     this.setEscuderia(escuderia);
     this.setNombre(nombre);
     this.setPaciencia(paciencia);
     this.setPeso(peso);
     this.setReflejos(reflejos);
     this.setValentia(valentia);
     this.calcular();
       
   }
   public Piloto(String nombre, String apellido,int edad,int altura,int peso,
           double reflejos,double agresividad,double paciencia,double valentia){
     this.setAgresividad(agresividad);
     this.setAltura(altura);
     this.setApellido(apellido);
     this.setEdad(edad);
     this.setEscuderia(escuderia);
     this.setNombre(nombre);
     this.setPaciencia(paciencia);
     this.setPeso(peso);
     this.setReflejos(reflejos);
     this.setValentia(valentia);
     this.calcular();
       
   }
   public void mejorar() { /* coje una caracteristica le suma un valor y la devuelve*/
       if (this.tipo) {
       this.setAgresividad(this.getAgresividad()+ 0.1);  //vueltas de entrenamiento
       this.setPaciencia(this.getPaciencia()+ 0.1);
       this.setReflejos(this.getReflejos()+ 0.1);
       this.setValentia(this.getValentia()+ 0.1);
       this.calcular();
       }
       this.setAgresividad(this.getAgresividad()+ 0.05);
       this.setPaciencia(this.getPaciencia()+ 0.05);
       this.setReflejos(this.getReflejos()+ 0.05);
       this.setValentia(this.getValentia()+ 0.05); 
       this.calcular();
   }
   public double participarcarrera(){ //coje el valor del piloto para sumarlo al cohe en el metodo carrera
    return this.getValor();
}
   public void Conducir(Coche coche){ //asigna un coche a un piloto
       this.setCoche(coche);
   }
   public void contrato(Escuderia contratante){ //ficha por un escuderia
     this.setEscuderia(contratante);
   }
   public void despido(){ //despedido por la scuderia
       this.setEscuderia(null);
   }
   public void calcular(){ //metodo para modificar el valor de un piloto sumando todas los aributos
    this.setValor(this.getAgresividad()+ this.getPaciencia()+ this.getReflejos()+this.getValentia());
   }
   public void calcularsueldo (){ //calcula el sueldo segun sea sustituto o no/
     double x = this.valor;
     x=x*50;
      if (this.isTipo()) { //añade peligrosidad
          x+=50;  
      }
      this.setSueldo(x); //modifica el sueldo
   }   
   
   
   
   ////////////////////////////////////////////////////////////////////////////////////////////////////
  ////////////////////////////////////////////////////////////////////////////////////////////////////
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public Coche getCoche() {
        return coche;
    }

    public void setCoche(Coche coche) {
        this.coche = coche;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getReflejos() {
        return reflejos;
    }

    public void setReflejos(double reflejos) {
        if (this.reflejos > 5){
         this.reflejos = 5;
        }
        else if (this.reflejos < 0){
        this.reflejos = 0;
        }
        this.reflejos = reflejos;
    }

    public double getAgresividad() {
        return agresividad;
    }

    public void setAgresividad(double agresividad) {
        if (this.agresividad > 5){
         this.agresividad = 5;
        }
        else if (this.agresividad < 0){
        this.agresividad = 0;
        }
        this.agresividad = agresividad;
    }

    public double getPaciencia() {
        return paciencia;
    }

    public void setPaciencia(double paciencia) {
        if (this.paciencia > 5){
         this.paciencia = 5;
        }
        else if (this.paciencia < 0){
        this.paciencia = 0;
        }
        this.paciencia = paciencia;
    }

    public double getValentia() {
        return valentia;
    }

    public void setValentia(double valentia) {
        if (this.valentia > 5){
         this.valentia = 5;
        }
        else if (this.valentia < 0){
        this.valentia = 0;
        }
        this.valentia = valentia;
    }
    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }
    
    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public Escuderia getEscuderia() {
        return escuderia;
    }

    public void setEscuderia(Escuderia escuderia) {
        this.escuderia = escuderia;
    }

    public boolean isTipo() {
        return tipo;
    }

    public void setTipo(boolean tipo) {
        this.tipo = tipo;
    }

    public double getTiempo() {
        return tiempo;
    }

    public void setTiempo(double tiempo) {
        this.tiempo = tiempo;
    }
 
 
}
