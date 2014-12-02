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
import java.util.ArrayList;
import java.util.Scanner;



public class Mundial {
   private ArrayList<Piloto> npilotos =new ArrayList <Piloto> (); 
   private ArrayList<Escuderia> nescuderias =new ArrayList <Escuderia> ();
   private boolean comienzo;
   private DatosCircuito[] dcir= new DatosCircuito[5];
   private ArrayList<DatosCircuito> datcir =new ArrayList <DatosCircuito> ();
   
   
   

   
   public void darAlta(String archivo, Piloto p){  
       ArrayList<Piloto> pilotos = new ArrayList();
        File comprobarFichero = new File(archivo);

        
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
            
            pilotos.add(p);
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
   
   public void darBaja(String archivo, String nombrePiloto, String apellidoPiloto){  
        ArrayList<Piloto> pilotos = new ArrayList();
        File comprobarFichero = new File(archivo);

        
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
            
            for (int i=0; i<pilotos.size(); i++){
                if (nombrePiloto==pilotos.get(i).getNombre() && apellidoPiloto==pilotos.get(i).getApellido()){
                    pilotos.remove(pilotos.get(i));
                }    
                }
            
            
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
   
   public void modificar(String archivo, String nombrePiloto, String apellidoPiloto){  
       ArrayList<Piloto> pilotos = new ArrayList();
        File comprobarFichero = new File(archivo);

        
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
            for (int i=0; i<pilotos.size(); i++){
                if (nombrePiloto==pilotos.get(i).getNombre() && apellidoPiloto==pilotos.get(i).getApellido()){

                }    
                }
            
            
            
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

        
        }else{
            System.out.println("Archivo con nombre ("+comprobarFichero.getPath()+") no encontrado");
        }
   
   }
   
   public void darAlta(String archivo, Escuderia p){
        ArrayList<Escuderia> escuderias = new ArrayList();
        File comprobarFichero = new File(archivo);

        
        //1º Acceder al archivo y crear flujo de lectura (comprobar que existe el archivo)
        if (comprobarFichero.exists()) {
            try{
                FileInputStream fileIn = new FileInputStream(archivo);
                ObjectInputStream in = new ObjectInputStream(fileIn);
                
                //2º Obtener el arrayList
                escuderias = (ArrayList<Escuderia>) in.readObject();

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
            
            escuderias.add(p);
            try{
                    FileOutputStream fileOut = new FileOutputStream(archivo);
                    ObjectOutputStream out = new ObjectOutputStream(fileOut);
                    out.writeObject(escuderias);
                    out.close();
                    fileOut.close();
                    System.out.printf("El array de escuderias ha sido guardado de nuevo en el archivo ("+comprobarFichero.getPath()+")");
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
   
   public void darBaja(String archivo, String nombreEscuderia){
        ArrayList<Escuderia> escuderias = new ArrayList();
        File comprobarFichero = new File(archivo);

        
        //1º Acceder al archivo y crear flujo de lectura (comprobar que existe el archivo)
        if (comprobarFichero.exists()) {
            try{
                FileInputStream fileIn = new FileInputStream(archivo);
                ObjectInputStream in = new ObjectInputStream(fileIn);
                
                //2º Obtener el arrayList
                escuderias = (ArrayList<Escuderia>) in.readObject();

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
            
            for (int i=0; i<escuderias.size(); i++){
                if (nombreEscuderia==escuderias.get(i).getNombre()){
                    escuderias.remove(escuderias.get(i));
                }    
                }
            

            try{
                    FileOutputStream fileOut = new FileOutputStream(archivo);
                    ObjectOutputStream out = new ObjectOutputStream(fileOut);
                    out.writeObject(escuderias);
                    out.close();
                    fileOut.close();
                    System.out.printf("El array de escuderias ha sido guardado de nuevo en el archivo ("+comprobarFichero.getPath()+")");
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
   
   public void modificar(String archivo, String nombreEscuderia){ //case para recorrer piltoos
       ArrayList<Escuderia> escuderias = new ArrayList();
        File comprobarFichero = new File(archivo);
        
        //1º Acceder al archivo y crear flujo de lectura (comprobar que existe el archivo)
        if (comprobarFichero.exists()) {
            try{
                FileInputStream fileIn = new FileInputStream(archivo);
                ObjectInputStream in = new ObjectInputStream(fileIn);
                
                //2º Obtener el arrayList
                escuderias = (ArrayList<Escuderia>) in.readObject();

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
            
            for (int i=0; i<escuderias.size(); i++){
                if (nombreEscuderia==escuderias.get(i).getNombre()){

                }    
                }
            try{
                    FileOutputStream fileOut = new FileOutputStream(archivo);
                    ObjectOutputStream out = new ObjectOutputStream(fileOut);
                    out.writeObject(escuderias);
                    out.close();
                    fileOut.close();
                    System.out.printf("El array de escuderias ha sido guardado de nuevo en el archivo ("+comprobarFichero.getPath()+")");
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
   
   public void darAlta(String archivo, Circuito p){
        ArrayList <Circuito> circuitos= new ArrayList<Circuito>();
        File comprobarFichero = new File(archivo);
        
        //1º Acceder al archivo y crear flujo de lectura (comprobar que existe el archivo)
        if (comprobarFichero.exists()) {
            try{
                FileInputStream fileIn = new FileInputStream(archivo);
                ObjectInputStream in = new ObjectInputStream(fileIn);
                
                circuitos = (ArrayList<Circuito>) in.readObject();


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
            
            circuitos.add(p);
            
            try{
                    FileOutputStream fileOut = new FileOutputStream(archivo);
                    ObjectOutputStream out = new ObjectOutputStream(fileOut);
                    out.writeObject(circuitos);
                    out.close();
                    fileOut.close();
                    System.out.printf("El array de circuitos ha sido guardado de nuevo en el archivo ("+comprobarFichero.getAbsolutePath()+")");
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
   
   public void darBaja(String archivo, String){
        ArrayList <Circuito> circuitos= new ArrayList<Circuito>();
        File comprobarFichero = new File(archivo);
        
        //1º Acceder al archivo y crear flujo de lectura (comprobar que existe el archivo)
        if (comprobarFichero.exists()) {
            try{
                FileInputStream fileIn = new FileInputStream(archivo);
                ObjectInputStream in = new ObjectInputStream(fileIn);
                
                circuitos = (ArrayList<Circuito>) in.readObject();


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
            
            circuitos.remove(p);
            
            try{
                    FileOutputStream fileOut = new FileOutputStream(archivo);
                    ObjectOutputStream out = new ObjectOutputStream(fileOut);
                    out.writeObject(circuitos);
                    out.close();
                    fileOut.close();
                    System.out.printf("El array de circuitos ha sido guardado de nuevo en el archivo ("+comprobarFichero.getAbsolutePath()+")");
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
   

    public void modificar(String archivo, Circuito p){ // case para modifiicar
        ArrayList <Circuito> circuitos= new ArrayList<Circuito>();
        File comprobarFichero = new File(archivo);
        Scanner escaner= new Scanner (System.in);
        
        //1º Acceder al archivo y crear flujo de lectura (comprobar que existe el archivo)
        if (comprobarFichero.exists()) {
            try{
                FileInputStream fileIn = new FileInputStream(archivo);
                ObjectInputStream in = new ObjectInputStream(fileIn);
                
                circuitos = (ArrayList<Circuito>) in.readObject();


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
            
            String nombre;
            String patrocinador;
            Double precio;
            Double rectas;
            Double curvas;
            int aforo;
            System.out.println("Que desea modificar?\n");
            System.out.print("1.-Nombre/2.-Patrocinador/3.-Precio/4.-Rectas/5.-Curvas/6.-Aforo/7.-");
            circuitos.get(circuitos.indexOf(p)).setNombre(());
            circuitos.get(circuitos.indexOf(p)).setPatrocinador();
            circuitos.get(circuitos.indexOf(p)).setPrecio();
            circuitos.get(circuitos.indexOf(p)).setRectas();
            circuitos.get(circuitos.indexOf(p)).setCurvas();
            circuitos.get(circuitos.indexOf(p)).setAforo();
            circuitos.get(circuitos.indexOf(p)).añadirCurvas();
            circuitos.get(circuitos.indexOf(p)).añadirRectas();
            
            try{
                    FileOutputStream fileOut = new FileOutputStream(archivo);
                    ObjectOutputStream out = new ObjectOutputStream(fileOut);
                    out.writeObject(circuitos);
                    out.close();
                    fileOut.close();
                    System.out.printf("El array de circuitos ha sido guardado de nuevo en el archivo ("+comprobarFichero.getAbsolutePath()+")");
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
   public void comenzarMundial(){   
   }
   public void darSalida(){
   }
    }
       

