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
    
    ////////////////////////CONSTRUCTORES//////////////////////////////////////////////////////////////////////////////////////////
    /**
     * Crea una escuderia a partir de los parametros especificados, 
     * NO RELLENA EL ARRAY COCHE NI LOS ARRAY DE PILOTOS, deben ser rellenados manualmente despues
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
     * @param e: escuderia que se desea clonar
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
    
    
    ////////////////////////METODOS//////////////////////////////////////////////////////////////////////////////////////////
    /**
    *Ficha un piloto para la escuderia
    * 
     * @param archivo: Ubicacion del archivo donde buscar el piloto ejem: /tmp/pilotos.bin
     * @param nombrePiloto: Nombre del piloto a fichar
     * @param apellidoPiloto: Apellido del piloto a fichar
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
                                if (this.realizarPago(this.pilotoOficial[x].calcularsueldo())) {//compruebo que puedo pagarle
                                    this.pilotoOficial[x].setEscuderia(this);//le ligas a esta escuderia
                                    System.out.println("Hay actualmente "+(x+1)+" piloto/s oficial/es en la escuderia");
                                    insertado=true;

                                    //4º Eliminar piloto del ArrayList
                                    pilotos.remove(i);
                                }
                                else{
                                    this.pilotoOficial[x]=null;
                                    System.out.println("No dispones de capital para contratar al piloto");
                                }
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
                                this.pilotoProbador[x].setTipo(false);//le haces piloto probador
                                if (this.realizarPago(this.pilotoProbador[x].calcularsueldo())) {//compruebo que puedo pagarle y le pago
                                    this.pilotoProbador[x].setEscuderia(this);//le ligas a esta escuderia
                                    System.out.println("Hay actualmente "+(x+1)+" piloto/s probador/es en la escuderia");
                                    insertado=true;

                                    //4º Eliminar piloto del ArrayList
                                    pilotos.remove(i);
                                }
                                else{
                                    this.pilotoProbador[x]=null;
                                    System.out.println("No dispones de capital para contratar al piloto");
                                }
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

    /**
     *Paga a cualquier entidad despues de comprobar que hay suficiente dinero para pagar, si no se puede pagar, devuelve false y si se puede, true
     * @param pago: dinero que se debe descontar del capital de la escuderia
     */
    private boolean realizarPago(double pago) {
        if (this.comprobarDinero(pago)) {
            this.presupuesto-=pago;
            return true;
        }
        else{
            System.out.println("no se puede pagar, no hay suficiente dinero");
            return false;
        }
    }
    
    /**
     *Es el antiguo comenzarMundial, asigna a cada piloto oficial un vehiculo con el que correr
     * 
     */
    public void asignarVehiculos(){
        int seleccion=-1;

        for (int i = 0; i < this.pilotoOficial.length; i++) {
            if (this.pilotoOficial[i]!=null) {
                System.out.println("Que coche desea asignar al piloto: "+this.pilotoOficial[i].getNombre()+" "+this.pilotoOficial[i].getApellido()+"?");
                while (seleccion<0 | seleccion>2) {
                    for (int j = 0; j < this.coches.length; j++) {
                        System.out.println((j+1)+" - "+this.coches[j].getModelo());
                    }
                    System.out.println("0 - ninguno");
                    seleccion=Integer.parseInt(new Scanner(System.in).toString());
                }
                switch (seleccion) {
                    case 0:  this.pilotoOficial[i].setCoche(null);
                             break;
                    case 1:  this.pilotoOficial[i].setCoche(this.coches[0]);
                             break;
                    case 2:  this.pilotoOficial[i].setCoche(this.coches[1]);
                             break;
                }
                System.out.println("Coche asignado con exito");
            }
        }
    }
    
    /**
     *Lanza una carrera individual, mejora las estadisticas del piloto y del vehiculo y por otro lado paga el precio del circuito
     * el entrenamiento no se realiza si no hay presupuesto para pagar al circuito y al piloto
     * 
     * @param piloto: que se quiere entrenar
     * @param coche: vehiculo que se quiere utilizar (no se usa el por defecto del piloto)
     * @param circuito: circuito donde se quiere entrenar (influira en el precio del entrenamiento)
     */
    public void iniciarEntrenamiento(Piloto piloto, Coche coche, Circuito circuito){
        if (this.realizarPago(circuito.getPrecio()+piloto.calcularsueldo())) {
            piloto.mejorar();
            coche.mejorar();
        }
    }
    
    /**
     *Elimina pilotos de la escuderia, estos pilotos son guardados de nuevo en el archivo de pilotos libres, en el proceso
     * se les borra automaticamente la escuderia, el coche y el tipo
     * 
     * @param archivo: archivo donde se almacenan los pilotos libres
     */
    public void descartarPiloto(String archivo){
        ArrayList<Piloto> pilotos = new ArrayList();
        File comprobarFichero = new File(archivo);
        int seleccion=-1;
        boolean lleno = true;
        
        while (seleccion<0 | seleccion>2) { //que tipo de piloto se debe descartar?
            System.out.println("Que tipo de piloto desea descartar?");
            System.out.println("1 - Oficial");
            System.out.println("2 - Probador");
            System.out.println("0 - Ninguno");
            seleccion=Integer.parseInt(new Scanner(System.in).toString());
        }
        if (seleccion==1) {     
            //compruebo que solo haya uno
            for (int j = 0; j < this.pilotoOficial.length; j++) {
                if (this.pilotoOficial[j]==null) {//si falta uno...
                    lleno=false;//el array no esta lleno
                }
                else if(this.pilotoOficial[j]!=null){//si este no esta vacio
                    seleccion=j+1;//le selecciono
                }
            }
            if (!lleno & seleccion==-1) {//no hay ningun piloto en el array
                System.out.println("No hay pilotos de este tipo en la escuderia");
            }
            else if(!lleno & seleccion>-1){//hay un solo piloto en el array
                System.out.println("Solo se ha detectado un piloto de este tipo en la escuderia");
            }
            else if (lleno) {//si hay mas de uno...
                System.out.println("Indique que piloto oficial quiere dar de baja");
                while (seleccion<1 | seleccion>2) {
                    for (int j = 0; j < this.pilotoOficial.length; j++) {   //muestro los que hay en el array
                            System.out.println((j+1)+" - "+this.pilotoOficial[j].getNombre()+" "+this.pilotoOficial[j].getApellido());
                        }
                    seleccion=Integer.parseInt(new Scanner(System.in).toString());
                }
            }

            //accedo al archivo, guardo al piloto en pilotos libres...
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

                this.pilotoOficial[seleccion-1].despido(); //le despido
                this.pilotoOficial[seleccion-1].setCoche(null); //le quito su coche
                pilotos.add(this.pilotoOficial[seleccion-1]); //le guardo en el array
                this.pilotoOficial[seleccion-1]=null;// y lo borro de la escuderia

                //por ultimo guardo en el archivo el array actualizado
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
                System.out.println("no se ha encontrado el archivo");
            }
        }
        else if(seleccion==2){
            //compruebo que solo haya uno
            for (int j = 0; j < this.pilotoProbador.length; j++) {
                if (this.pilotoProbador[j]==null) {//si falta uno...
                    lleno=false;//el array no esta lleno
                }
                else if(this.pilotoProbador[j]!=null){//si este no esta vacio
                    seleccion=j+1;//le selecciono
                }
            }
            if (!lleno & seleccion==-1) {//no hay ningun piloto en el array
                System.out.println("No hay pilotos de este tipo en la escuderia");
            }
            else if(!lleno & seleccion>-1){//hay un solo piloto en el array
                System.out.println("Solo se ha detectado un piloto de este tipo en la escuderia");
            }
            else if (lleno) {//si hay mas de uno...
                System.out.println("Indique que piloto probador quiere dar de baja");
                while (seleccion<1 | seleccion>2) {
                    for (int j = 0; j < this.pilotoProbador.length; j++) {   //muestro los que hay en el array
                            System.out.println((j+1)+" - "+this.pilotoProbador[j].getNombre()+" "+this.pilotoProbador[j].getApellido());
                        }
                    seleccion=Integer.parseInt(new Scanner(System.in).toString());
                }
            }

            //accedo al archivo, guardo al piloto en pilotos libres...
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

                this.pilotoProbador[seleccion-1].despido(); //le despido
                pilotos.add(this.pilotoProbador[seleccion-1]); //le guardo en el array
                this.pilotoProbador[seleccion-1]=null;// y lo borro de la escuderia

                //por ultimo guardo en el archivo el array actualizado
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
                System.out.println("no se ha encontrado el archivo");
            }
        }

    }
    
    /**
     *comprueba rapidamente si las deudas exceden el dinero de la escuderia
     * @param deudas: lo que tiene que pagar la escuderia, admite decimales
     * @return: devuelve true si puede pagarlo o false en caso contrario
     */
    public boolean comprobarDinero(double deudas){
        return this.presupuesto>deudas;
    }

    /**
    *Crea un coche a partir de datos y lo introduce en el array de coches de la escuderia
    * 
     * @param modelo: nombre del vehiculo
     * @param neumaticos: valor del 1-5
     * @param potencia: valor del 1-5
     * @param aerodinamica: valor del 1-5
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
            System.out.println("Se ha alcanzado el numero maximo de coches para esta escuderia: "+(this.coches.length+1)+", vehiculo no insertado");
        }
    }
    
    /**
    *Crea un coche a partir de otro coche existente y lo introduce en el array de coches de la escuderia
    * 
    * @param c: coche a clonar dentro de la escuderia
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
    
    /**
     *Reinicia a 0 los puntos mundial de la escuderia y los puntos mundial de los pilotos oficiales 
     */
    void reset() {
        this.puntosMundial=0;
        for (int i = 0; i < this.pilotoProbador.length; i++) {
            if (this.pilotoProbador[i]!=null) {
                this.pilotoProbador[i].setPuntos(0);
            }
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