/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
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
   
   public void darBaja(String archivo, Piloto p){  
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
            
            pilotos.remove(p);
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
   
   public void modificar(String archivo, Piloto p){  
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
            if (p.getEscuderia()==null){
            pilotos.get(pilotos.indexOf(p)).setNombre(p.getNombre());
            pilotos.get(pilotos.indexOf(p)).setApellido(p.getApellido());
            pilotos.get(pilotos.indexOf(p)).setEdad(p.getEdad());
            pilotos.get(pilotos.indexOf(p)).setAltura(p.getAltura());
            pilotos.get(pilotos.indexOf(p)).setPeso(p.getPeso());
            pilotos.get(pilotos.indexOf(p)).setReflejos(p.getReflejos());
            pilotos.get(pilotos.indexOf(p)).setAgresividad(p.getAgresividad());
            pilotos.get(pilotos.indexOf(p)).setPaciencia(p.getPaciencia());
            pilotos.get(pilotos.indexOf(p)).setValentia(p.getValentia());
            }
            else{
            pilotos.get(pilotos.indexOf(p)).setNombre(p.getNombre());
            pilotos.get(pilotos.indexOf(p)).setApellido(p.getApellido());
            pilotos.get(pilotos.indexOf(p)).setEdad(p.getEdad());
            pilotos.get(pilotos.indexOf(p)).setEscuderia(p.getEscuderia());
            pilotos.get(pilotos.indexOf(p)).setAltura(p.getAltura());
            pilotos.get(pilotos.indexOf(p)).setPeso(p.getPeso());
            pilotos.get(pilotos.indexOf(p)).setReflejos(p.getReflejos());
            pilotos.get(pilotos.indexOf(p)).setAgresividad(p.getAgresividad());
            pilotos.get(pilotos.indexOf(p)).setPaciencia(p.getPaciencia());
            pilotos.get(pilotos.indexOf(p)).setValentia(p.getValentia());
            
            
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
   
   public void darAlta(String archivo, Escuderia p){
        ArrayList<Escuderia> escuderias = new ArrayList();
        File comprobarFichero = new File(archivo);
        int seleccion=0;
        Scanner escaner = new Scanner (System.in);
        
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
   
   public void darBaja(String archivo, Escuderia p){
        ArrayList<Escuderia> escuderias = new ArrayList();
        File comprobarFichero = new File(archivo);
        int seleccion=0;
        Scanner escaner = new Scanner (System.in);
        
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
            
            escuderias.remove(p);
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
   
   public void modificar(String archivo, Escuderia p){
       ArrayList<Escuderia> escuderias = new ArrayList();
        File comprobarFichero = new File(archivo);
        int seleccion=0;
        Scanner escaner = new Scanner (System.in);
        
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
            
            escuderias.get(escuderias.indexOf(p)).setDueño(p.getDueño());
            escuderias.get(escuderias.indexOf(p)).setNombre(p.getNombre());
            escuderias.get(escuderias.indexOf(p)).setPais(p.getPais());
            escuderias.get(escuderias.indexOf(p)).setAñoFundacion(p.getAñoFundacion());
            escuderias.get(escuderias.indexOf(p)).setPuntosMundial(p.getPuntosMundial());
            escuderias.get(escuderias.indexOf(p)).setPresupuesto(p.getPresupuesto());
            escuderias.get(escuderias.indexOf(p)).setDirectivos(p.getDirectivos());
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
   
   public void darBaja(String archivo, Circuito p){
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
   

    public void modificar(String archivo, Circuito p){
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
            
            circuitos.get(circuitos.indexOf(p)).setNombre(p.getNombre());
            circuitos.get(circuitos.indexOf(p)).setPatrocinador(p.getPatrocinador());
            circuitos.get(circuitos.indexOf(p)).setPrecio(p.getPrecio());
            circuitos.get(circuitos.indexOf(p)).setPatrocinador(p.getPatrocinador());
            circuitos.get(circuitos.indexOf(p)).setRectas(p.getRectas());
            circuitos.get(circuitos.indexOf(p)).setCurvas(p.getCurvas());
            circuitos.get(circuitos.indexOf(p)).setAforo(p.getAforo());
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
    
    }
       

