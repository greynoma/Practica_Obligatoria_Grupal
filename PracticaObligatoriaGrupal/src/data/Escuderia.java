/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author David Sánchez Dueñas
 */
public class Escuderia implements Serializable{
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
    
    /**
    *Ficha un piloto para la escuderia
    * 
     * @param archivo: Ubicacion del archivo donde buscar el piloto ejem: /tmp/pilotos.bin
     * @param nombrePiloto: Nombre del piloto a fichar
    */
    public void ficharPiloto(String archivo, String nombrePiloto, String apellidoPiloto){
        ArrayList<Piloto> pilotos = new ArrayList();
        File comprobarFichero = new File(archivo);
        int seleccion=0;
        Scanner escaner = new Scanner (System.in);
        
        //1º Acceder al archivo y crear flujo de lectura (comprobar que existe el archivo)
        if (comprobarFichero.exists()) {
            try{
                FileInputStream fileIn = new FileInputStream(archivo);
                ObjectInputStream in = new ObjectInputStream(fileIn);
                
                //2º Obtener el arrayList
                pilotos = (ArrayList<Piloto>) in.readObject();

                //por alguna extraña razon no me deja cerrar los Stream en el finally
                in.close();
                fileIn.close();
            }
            catch(IOException i){
                System.out.println("Se ha detectado un error: ");
                i.printStackTrace();
            }
            catch(ClassNotFoundException c){
                System.out.println("No se ha encontrado lo que buscaba");
                c.printStackTrace();
            }
            finally{//aqui deberia cerrar los Stream pero no me deja
            }
            
            //3º Buscar al piloto y comprueba si se quiere guardar como probador u oficial,
            for (int i = 0; i < pilotos.size(); i++) {
                if (pilotos.get(i).getNombre().equals(nombrePiloto) && pilotos.get(i).getApellido().equals(apellidoPiloto)) {
                    System.out.print("Seleccione una opcion, el piloto "+nombrePiloto+" "+apellidoPiloto+" sera:");
                    while(seleccion!=1 | seleccion!=2){
                        System.out.println(" probador(1), oficial(2)");
                        seleccion = escaner.nextInt();
                        System.out.println("");
                    }

                    //4ºdespues añadirlo como hice con los coches (Comprobar que existe el piloto y que hay hueco)
                    boolean insertado=false;
                    if (seleccion==2) {
                        for (int x = 0; x < this.pilotoOficial.length; x++) {  //for que recorre las dos posiciones del array
                            if (this.pilotoOficial[x]==null & !insertado) {    //si esta vacio y no se ha insertado...
                                this.pilotoOficial[x]=pilotos.get(i);//lo insertas
                                this.pilotoOficial[x].setTipo(true);//le haces piloto oficial
                                System.out.println("Hay actualmente "+(x+1)+" piloto/s oficial/es en la escuderia");
                                insertado=true;

                                //4º Eliminar piloto del ArrayList
                                pilotos.remove(i);
                        } 
                        }
                        if(!insertado){ //si despues de comprobar el array no se ha insertado, es que estaba lleno
                            System.out.println("Se ha alcanzado el numero maximo de pilotos oficiales para esta escuderia: "+this.pilotoOficial.length+", piloto no insertado");
                        }
                    }
                    else if(seleccion==1){
                        for (int x = 0; x < this.pilotoProbador.length; x++) {  //for que recorre las dos posiciones del array
                            if (this.pilotoProbador[x]==null & !insertado) {    //si esta vacio y no se ha insertado...
                                this.pilotoProbador[x]=pilotos.get(i);//lo insertas
                                this.pilotoOficial[x].setTipo(false);//le haces piloto probador
                                System.out.println("Hay actualmente "+(x+1)+" piloto/s probador/es en la escuderia");
                                insertado=true;

                                //4º Eliminar piloto del ArrayList
                                pilotos.remove(i);
                        } 
                        }
                        if(!insertado){ //si despues de comprobar el array no se ha insertado, es que estaba lleno
                            System.out.println("Se ha alcanzado el numero maximo de pilotos probadores para esta escuderia: "+this.pilotoProbador.length+", piloto no insertado");
                        }
                    }
                    i=pilotos.size()-1;
                }
                else{
                    System.out.println("El piloto "+nombrePiloto+" "+apellidoPiloto+" no se ha encontrado");
                }

            }
                
                //5º Sobreescribir archivo guardando el nuevo ArrayList sin piloto
                try{
                    FileOutputStream fileOut = new FileOutputStream(archivo);
                    ObjectOutputStream out = new ObjectOutputStream(fileOut);
                    out.writeObject(pilotos);
                    out.close();
                    fileOut.close();
                    System.out.printf("El array de pilotos ha sido guardado de nuevo en el archivo ("+comprobarFichero.getPath()+")");
                }
                catch(IOException i){
                    System.out.println("Se ha detectado un error: ");
                    i.printStackTrace();
                }

        }
        else{
            System.out.println("Archivo con nombre ("+comprobarFichero.getPath()+") no encontrado");
        }
            

    }
    public void comprobarLimite(){}//Es demasiado facil, no hace falta ni usarlo
    public void descartarPiloto(){}
    public void iniciarEntrenamiento(){}
    public void realizarPago(){}
    public void iniciarMundial(){}
    public void pagarSueldo(){}
    
    /**
     *comprueba rapidamente si las deudas exceden el dinero de la escuderia, me parece un metodo demasiado sencillo...
     * @param deudas: lo que tiene que pagar la escuderia, admite decimales
     * @return: devuelve true si puede pagarlo o false en caso contrario
     */
    public boolean comprobarDinero(double deudas){//Quiza es un metodo demasiado sencillo
        return this.presupuesto>deudas;
    }
    
    
    
    
    /**
    *Crea un coche a partir de datos y lo introduce en el array de coches de la escuderia
    * 
    */
    public void crearCoche(String modelo, double neumaticos, double potencia, double aerodinamica){
        boolean insertado=false;
        for (int i = 0; i < this.coches.length; i++) {  //for que recorre las dos posiciones del array
            if (this.coches[i]==null & !insertado) {    //si esta vacio y no se ha insertado...
            this.coches[i]=new Coche(modelo, neumaticos, potencia, aerodinamica);//lo insertas
            System.out.println("Hay actualmente "+(i+1)+" vehiculo/s en la escuderia");
            insertado=true;
            } 
        }
        if(!insertado){ //si despues de comprobar el array no se ha insertado, es que estaba lleno
            System.out.println("Se ha alcanzado el numero maximo de coches para esta escuderia: "+this.coches.length+", vehiculo no insertado");
        }
    }
    
    /**
    *Crea un coche a partir de otro coche existente y lo introduce en el array de coches de la escuderia
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
