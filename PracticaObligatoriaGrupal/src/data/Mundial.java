/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sergio Lazaro Matesanz
 */

public class Mundial {
   private ArrayList<Piloto> npilotos =new ArrayList <> (); 
   private ArrayList<Escuderia> nescuderias =new ArrayList <> ();
   private Scanner escaner= new Scanner (System.in);
   private boolean comenzar2= false;
   
   

   
   public void darAlta(String archivo, Piloto p){
       if (archivo.charAt(0)=='/') {           archivo=new File("").getAbsolutePath()+archivo;       }
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
                //System.out.println("Se ha detectado un error: ");
                //i.printStackTrace();
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
                    System.out.println("El array de pilotos ha sido guardado de nuevo en el archivo ("+comprobarFichero.getPath()+")");
                }
                catch(IOException i){
                    System.out.println("Se ha detectado un error: ");
                    i.printStackTrace();
                }

        }
        else{
               try {
                   System.out.println("Archivo con nombre ("+comprobarFichero.getPath()+") no encontrado, creando archivo...");
                   
                   FileOutputStream out = new FileOutputStream(archivo);
                   out.write(0);
                   out.close();
                   this.darAlta(archivo, p);
               } catch (IOException ex) {
                   Logger.getLogger(Mundial.class.getName()).log(Level.SEVERE, null, ex);
               }
        }
   }
   
   public void darBaja(String archivo, String nombrePiloto, String apellidoPiloto){  
        if (archivo.charAt(0)=='/') {           archivo=new File("").getAbsolutePath()+archivo;       }
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
            if (pilotos.size()>0) {
                for (int i=0; i<pilotos.size(); i++){
                    if (nombrePiloto.equals(pilotos.get(i).getNombre()) && apellidoPiloto.equals(pilotos.get(i).getApellido())){
                        pilotos.remove(pilotos.get(i));
                    }    
                    }


                try{
                        FileOutputStream fileOut = new FileOutputStream(archivo);
                        ObjectOutputStream out = new ObjectOutputStream(fileOut);
                        out.writeObject(pilotos);
                        out.close();
                        fileOut.close();
                        System.out.println("El array de pilotos ha sido guardado de nuevo en el archivo ("+comprobarFichero.getPath()+")");
                    }
                    catch(IOException i){
                        System.out.println("Se ha detectado un error: ");
                        i.printStackTrace();
                    }
            }
        }
        else{
            System.out.println("Archivo con nombre ("+comprobarFichero.getPath()+") no encontrado");
        }
   }
   
   public void modificar(String archivo, String nombrePiloto, String apellidoPiloto){
       if (archivo.charAt(0)=='/') {           archivo=new File("").getAbsolutePath()+archivo;       }
       ArrayList<Piloto> pilotos = new ArrayList();
       ArrayList<Escuderia> escuderias= new ArrayList();
       ArrayList <String> directivos= new ArrayList();
       Scanner mundial= new Scanner (System.in);
        File comprobarFichero = new File(archivo);
        String dueno,nomescu,pais,nomdirectivos,nombreesc;
        int fundacion, pmun,numdirectivos;
        double presupuesto;
        

        
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
            if (pilotos.size()>0) {
                for (int i=0; i<pilotos.size(); i++){
                    if (nombrePiloto.equals(pilotos.get(i).getNombre()) && apellidoPiloto.equals(pilotos.get(i).getApellido())){
                        if ( pilotos.get(i).getEscuderia()!=null){
                        System.out.println("¿Que desea modificar?");
                        System.out.println("1.-Nombre/2.-Apellido/3.-Edad/4.-Escuderia/5.-Altura/6.-Peso/7.-Reflejos/8.-Agresividad/9.-Paciencia/10.-Valentia");
                        int respuesta = escaner.nextInt();
                        String nuevovalor;
                        int valor;
                        double valornuevo;
                        switch ( respuesta){
                            case 1: System.out.print("Introduzca el nuevo nombre: ");
                                    nuevovalor= escaner.next(); System.out.println("");
                                    pilotos.get(i).setNombre(nuevovalor);
                                    break;
                            case 2: System.out.println("Introduzca el nuevo apellido: ");
                                    nuevovalor= escaner.next(); System.out.println("");
                                    pilotos.get(i).setApellido(nuevovalor);
                                    break;
                            case 3: System.out.println("Introduzca la nueva edad: ");
                                    valor= escaner.nextInt();   System.out.println("");
                                    pilotos.get(i).setEdad(valor);
                                    break;
                            case 4: 
                                    for (int j = 0; j < escuderias.size(); j++) {
                                       if (escuderias.get(j).getNombre().equals(pilotos.get(i).getEscuderia().getNombre())){
                                           escuderias.get(j).descartarPiloto(archivo);
                                       }
                                    }
                                    System.out.print("Introduzca el nombre de la nueva escuderia:"); nombreesc=mundial.next(); System.out.println("");
                                    for (int j = 0; j < escuderias.size(); j++) {
                                        if (nombreesc.equals(escuderias.get(j).getNombre())){
                                            escuderias.get(i).ficharPiloto(archivo, nombrePiloto, apellidoPiloto);
                                        }
                                        else {
                                            System.out.print("Escoja el dueno de la escuderia "+ i+": ");     dueno=mundial.next();    System.out.println("");
                                            System.out.print("Escoja el nombre de la escuderia "+ i+": ");     nomescu=mundial.next();   System.out.println("");
                                            System.out.print("Escoja la nacionalidad de la escuderia "+ i+": ");     pais=mundial.next();   System.out.println("");
                                            System.out.print("Escoja la fecha de fundacion de la escuderia "+ i+": ");     fundacion=mundial.nextInt();   System.out.println("");
                                            System.out.print("Escoja la cantidad de puntos del mundial que posee la escuderia "+ i+": ");     pmun=mundial.nextInt();     System.out.println("");
                                            System.out.print("Escoja el presupuesto de la escuderia"+ i+": ");     presupuesto=mundial.nextDouble();       System.out.println("");
                                            System.out.print("Cuantos directivos tiene la escuderia?:");    numdirectivos=mundial.nextInt();    System.out.println("");
                                            for (int u=0; u< numdirectivos; u++){
                                                System.out.print("Nombre del directivo "+u+" :");   nomdirectivos=mundial.next();   System.out.println("");
                                                directivos.add(nomdirectivos); 
                                            }
                                            Escuderia aux = new Escuderia(dueno,nomescu,pais,fundacion,pmun,presupuesto,directivos);
                                            aux.ficharPiloto(archivo, nombrePiloto, apellidoPiloto);
                                            this.darAlta("datosEscuderia.dat", aux );
                                        }
                                    }
                                    break;
                            case 5: System.out.println("Introduzca la nueva altura: ");
                                    valornuevo=escaner.nextDouble();    System.out.println("");
                                    pilotos.get(i).setAltura(valornuevo);
                                    break;
                            case 6: System.out.println("Introduzca el nuevo peso: ");
                                    valornuevo=escaner.nextDouble();    System.out.println("");
                                    pilotos.get(i).setPeso(valornuevo);
                                    break;
                            case 7: System.out.println("Introduzca los nuevos reflejos: ");
                                    valornuevo=escaner.nextDouble();    System.out.println("");
                                    pilotos.get(i).setReflejos(valornuevo);
                                    break;
                            case 8: System.out.println("Introduzca la nueva agresividad: ");
                                    valornuevo=escaner.nextDouble();    System.out.println("");
                                    pilotos.get(i).setAgresividad(valornuevo);
                                    break;
                            case 9: System.out.println("Introduzca la nueva paciencia: ");
                                    valornuevo=escaner.nextDouble();    System.out.println("");
                                    pilotos.get(i).setPaciencia(valornuevo);
                                    break;
                            case 10:    System.out.println("Introduzca la nueva valentía: ");
                                        valornuevo=escaner.nextDouble();    System.out.println("");
                                        pilotos.get(i).setValentia(valornuevo);
                                        break;
                        }
                        }
                        else {
                            System.out.println("¿Que desea modificar?");
                            System.out.println("1.-Nombre/2.-Apellido/3.-Edad/4.-Altura/5.-Peso/6.-Reflejos/7.-Agresividad/8.-Paciencia/9.-Valentia");
                            int respuesta = escaner.nextInt();
                            String nuevovalor;
                            int valor;
                            double valornuevo;
                            switch ( respuesta){
                                case 1: System.out.print("Introduzca el nuevo nombre: ");
                                        nuevovalor= escaner.next(); System.out.println("");
                                        pilotos.get(i).setNombre(nuevovalor);
                                        break;
                                case 2: System.out.println("Introduzca el nuevo apellido: ");
                                        nuevovalor= escaner.next(); System.out.println("");
                                        pilotos.get(i).setApellido(nuevovalor);
                                        break;
                                case 3: System.out.println("Introduzca la nueva edad: ");
                                        valor= escaner.nextInt();   System.out.println("");
                                        pilotos.get(i).setEdad(valor);
                                        break;
                                case 4: System.out.println("Introduzca la nueva altura: ");
                                        valornuevo=escaner.nextDouble();    System.out.println("");
                                        pilotos.get(i).setAltura(valornuevo);
                                        break;
                                case 5: System.out.println("Introduzca el nuevo peso: ");
                                        valornuevo=escaner.nextDouble();    System.out.println("");
                                        pilotos.get(i).setPeso(valornuevo);
                                        break;
                                case 6: System.out.println("Introduzca los nuevos reflejos: ");
                                        valornuevo=escaner.nextDouble();    System.out.println("");
                                        pilotos.get(i).setReflejos(valornuevo);
                                        break;
                                case 7: System.out.println("Introduzca la nueva agresividad: ");
                                        valornuevo=escaner.nextDouble();    System.out.println("");
                                        pilotos.get(i).setAgresividad(valornuevo);
                                        break;
                                case 8: System.out.println("Introduzca la nueva paciencia: ");
                                        valornuevo=escaner.nextDouble();    System.out.println("");
                                        pilotos.get(i).setPaciencia(valornuevo);
                                        break;
                                case 9:    System.out.println("Introduzca la nueva valentía: ");
                                            valornuevo=escaner.nextDouble();    System.out.println("");
                                            pilotos.get(i).setValentia(valornuevo);
                                            break;
                        }
                        }
                    }    
                    }
            }
            
            
            try{
                    FileOutputStream fileOut = new FileOutputStream(archivo);
                    ObjectOutputStream out = new ObjectOutputStream(fileOut);
                    out.writeObject(pilotos);
                    out.close();
                    fileOut.close();
                    System.out.println("El array de pilotos ha sido guardado de nuevo en el archivo ("+comprobarFichero.getPath()+")");
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
        if (archivo.charAt(0)=='/') {           archivo=new File("").getAbsolutePath()+archivo;       }
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
                //System.out.println("Se ha detectado un error: ");
                //i.printStackTrace();
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
                    System.out.println("El array de escuderias ha sido guardado de nuevo en el archivo ("+comprobarFichero.getPath()+")");
                }
                catch(IOException i){
                    System.out.println("Se ha detectado un error: ");
                    i.printStackTrace();
                }

        }
        else{
               try {
                   System.out.println("Archivo con nombre ("+comprobarFichero.getPath()+") no encontrado, creando archivo...");
                   
                   FileOutputStream out = new FileOutputStream(archivo);
                   out.write(0);
                   out.close();
                   this.darAlta(archivo, p);
               } catch (IOException ex) {
                   Logger.getLogger(Mundial.class.getName()).log(Level.SEVERE, null, ex);
               }
        }
   }
   
   public void darBaja(String archivo, String nombreEscuderia){
        if (archivo.charAt(0)=='/') {           archivo=new File("").getAbsolutePath()+archivo;       }
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
            if (escuderias.size()>0) {
                for (int i=0; i<escuderias.size(); i++){
                    if (nombreEscuderia.equals(escuderias.get(i).getNombre())){
                        escuderias.remove(escuderias.get(i));
                    }    
                    }


                try{
                        FileOutputStream fileOut = new FileOutputStream(archivo);
                        ObjectOutputStream out = new ObjectOutputStream(fileOut);
                        out.writeObject(escuderias);
                        out.close();
                        fileOut.close();
                        System.out.println("El array de escuderias ha sido guardado de nuevo en el archivo ("+comprobarFichero.getPath()+")");
                    }
                    catch(IOException i){
                        System.out.println("Se ha detectado un error: ");
                        i.printStackTrace();
                    }
            }
        }
        else{
            System.out.println("Archivo con nombre ("+comprobarFichero.getPath()+") no encontrado");
        }
   }
   
   public void modificar(String archivo, String nombreEscuderia){ //case para recorrer piltoos
       if (archivo.charAt(0)=='/') {           archivo=new File("").getAbsolutePath()+archivo;       }
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
            if (escuderias.size()>0) {
                System.out.println("Que desea modificar?");
                System.out.println("1.-Dueño/2.-Nombre/3.-País/4.-AñoFundacion/5.-PuntosMundial/6.-Presupuesto/7.-Directivos");
                int respuesta;
                respuesta=escaner.nextInt();
                String nuevovalor;
                int valor;
                double valornuevo;
                ArrayList <String> nuevoDirectivo= new ArrayList <>();
                for (int i=0; i<escuderias.size(); i++){
                    if (nombreEscuderia.equals(escuderias.get(i).getNombre())){
                        switch (respuesta){ 
                            case 1: System.out.print("Cómo quieres que se llame el dueño de la esuderia?");
                                    nuevovalor= escaner.next();
                                    escuderias.get(i).setDueño(nuevovalor);
                                    break;
                            case 2: System.out.print("Cómo quieres que se llame la escuderia?");
                                    nuevovalor= escaner.next();
                                    escuderias.get(i).setNombre(nuevovalor);
                                    break;
                            case 3: System.out.print("Cuáles la nueva nacionalidad de la escuderia?");
                                    nuevovalor= escaner.next();
                                    escuderias.get(i).setPais(nuevovalor);
                                    break;
                            case 4: System.out.print("En qué año se fundó la escudería?");
                                    valor= escaner.nextInt();
                                    escuderias.get(i).setAñoFundacion(valor);
                                    break;
                            case 5: System.out.print("Cuántas puntos tiene ahora la escuderia?");
                                    valor= escaner.nextInt();
                                    escuderias.get(i).setPuntosMundial(valor);
                                    break;
                            case 6: System.out.print("Cuánto presupuesto tiene la escuderia?");
                                    valornuevo= escaner.nextDouble();
                                    escuderias.get(i).setPresupuesto(valornuevo);
                                    break;
                            case 7: System.out.print("Actualmente la escuderia tiene estos directivos?");
                                    for (int o=0; o < escuderias.get(i).getDirectivos().size(); o++){
                                        System.out.println("Directivo ["+o+"]: "+escuderias.get(o).getDirectivos());
                                    }
                                    System.out.println("");
                                    System.out.print("¿Qué directivo desea modificar?");
                                    respuesta= escaner.nextInt();   System.out.println("");
                                    for (int o=0; o < escuderias.get(i).getDirectivos().size(); o++)
                                        if (respuesta<= escuderias.get(o).getDirectivos().size()){
                                            System.out.print("Introduzca el nombre que desea: ");
                                            nuevovalor= escaner.next(); System.out.println("");
                                            nuevoDirectivo.add(nuevovalor);
                                            escuderias.get(i).setDirectivos(nuevoDirectivo);
                                    }

                                    break;
                        }

                    }    
                    }
                try{
                        FileOutputStream fileOut = new FileOutputStream(archivo);
                        ObjectOutputStream out = new ObjectOutputStream(fileOut);
                        out.writeObject(escuderias);
                        out.close();
                        fileOut.close();
                        System.out.println("El array de escuderias ha sido guardado de nuevo en el archivo ("+comprobarFichero.getPath()+")");
                    }
                    catch(IOException i){
                        System.out.println("Se ha detectado un error: ");
                        i.printStackTrace();
                    }

            }
        }
        else{
            System.out.println("Archivo con nombre ("+comprobarFichero.getPath()+") no encontrado");
        }
   
   }
   
   public void darAlta(String archivo, Circuito p){
           if (archivo.charAt(0)=='/') {           archivo=new File("").getAbsolutePath()+archivo;       }
        
        ArrayList <Circuito> circuitos= new ArrayList();
        File comprobarFichero = new File(archivo);
        
        //1º Acceder al archivo y crear flujo de lectura (comprobar que existe el archivo)
        if (comprobarFichero.exists()) {
            try{
                    FileInputStream fileIn = new FileInputStream(archivo); 
                    ObjectInputStream in = new ObjectInputStream(fileIn);
                    
                    circuitos = (ArrayList<Circuito>) in.readObject();
            }
            catch(IOException i){
                //System.out.println("Se ha detectado un error: ");
                //i.printStackTrace();
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
                    System.out.println("El array de circuitos ha sido guardado de nuevo en el archivo ("+comprobarFichero.getAbsolutePath()+")");
                }
                catch(IOException i){
                    System.out.println("Se ha detectado un error: ");
                    i.printStackTrace();
                }

        }
        else{
               try {
                   System.out.println("Archivo con nombre ("+comprobarFichero.getPath()+") no encontrado, creando archivo...");
                   
                   FileOutputStream out = new FileOutputStream(archivo);
                   out.write(0);
                   out.close();
                   this.darAlta(archivo, p);
               } catch (IOException ex) {
                   Logger.getLogger(Mundial.class.getName()).log(Level.SEVERE, null, ex);
               }
        }
   }
   
   public void darBajaCir(String archivo, String nombreCircuito){
        if (archivo.charAt(0)=='/') {           archivo=new File("").getAbsolutePath()+archivo;       }
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
            if (circuitos.size()>5) {
                for (int i=0; i<circuitos.size(); i++){
                    if (nombreCircuito.equals(circuitos.get(i).getNombre())){
                        circuitos.remove(circuitos.get(i));
                    }    
                    }
                
                try{
                        FileOutputStream fileOut = new FileOutputStream(archivo);
                        ObjectOutputStream out = new ObjectOutputStream(fileOut);
                        out.writeObject(circuitos);
                        out.close();
                        fileOut.close();
                        System.out.println("El array de circuitos ha sido guardado de nuevo en el archivo ("+comprobarFichero.getAbsolutePath()+")");
                    }
                    catch(IOException i){
                        System.out.println("Se ha detectado un error: ");
                        i.printStackTrace();
                    }
            }
            else{
                System.out.println("No puede dar de baja ningun circuito porque el Mundial requiere de 5 carreras.");
            }
        }
        else{
            System.out.println("Archivo con nombre ("+comprobarFichero.getPath()+") no encontrado");
        }
   }
   

    public void modificarCir(String archivo, String nombreCircuito){ // case para modifiicar
        if (archivo.charAt(0)=='/') {           archivo=new File("").getAbsolutePath()+archivo;       }
        ArrayList <Circuito> circuitos= new ArrayList<>();
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
            
            if (circuitos.size()>0) {
                System.out.println("Que desea modificar?");
                System.out.println("1.-Nombre/2.-Patrocinador/3.-Precio/4.-Rectas/5.-Curvas/6.-Aforo");
                int respuesta;
                respuesta= escaner.nextInt();
                String nuevovalor;
                int valor;

                for (int i=0; i<circuitos.size(); i++){
                    if (nombreCircuito.equals(circuitos.get(i).getNombre())){
                        switch (respuesta){ 
                            case 1: System.out.print("Cómo quieres que se llame el circuito?");
                                    nuevovalor= escaner.next();
                                    circuitos.get(i).setNombre(nuevovalor);
                                    break;
                            case 2: System.out.print("Cómo quieres que se llame el patrocinador?");
                                    nuevovalor= escaner.next();
                                    circuitos.get(i).setPatrocinador(nuevovalor);
                                    break;
                            case 3: System.out.print("Cuánto quieres que cueste el circuito?");
                                    valor= escaner.nextInt();
                                    circuitos.get(i).setPrecio(valor);
                                    break;
                            case 4: System.out.print("Cuántas rectas quieres que tenga el circuito?");
                                    valor= escaner.nextInt();
                                    circuitos.get(i).setRectas(valor);
                                    break;
                            case 5: System.out.print("Cuántas curvas quieres que tenga el circuito?");
                                    valor= escaner.nextInt();
                                    circuitos.get(i).setCurvas(valor);
                                    break;
                            case 6: System.out.print("Cuánto aforo quieres que tenga el circuito?");
                                    valor= escaner.nextInt();
                                    circuitos.get(i).setAforo(valor);
                                    break;
                        }
                    }
                }       

                try{
                        FileOutputStream fileOut = new FileOutputStream(archivo);
                        ObjectOutputStream out = new ObjectOutputStream(fileOut);
                        out.writeObject(circuitos);
                        out.close();
                        fileOut.close();
                        System.out.println("El array de circuitos ha sido guardado de nuevo en el archivo ("+comprobarFichero.getAbsolutePath()+")");
                    }
                    catch(IOException i){
                        System.out.println("Se ha detectado un error: ");
                        i.printStackTrace();
                    }

            }
        }
        else{
            System.out.println("Archivo con nombre ("+comprobarFichero.getPath()+") no encontrado");
        }
   }
   public void comenzarMundial(){   
       boolean comenzar=false;  
       boolean comprobacion=false;
       ArrayList <Circuito> integrantes= new ArrayList <>();
       ArrayList <Escuderia> participantes= new ArrayList <>();
       
       try{
                FileInputStream fileIn = new FileInputStream(new File("").getAbsolutePath()+"/datosCircuito.dat");
                ObjectInputStream in = new ObjectInputStream(fileIn);
                
                //2º Obtener el arrayList
                integrantes = (ArrayList<Circuito>) in.readObject();

                //por alguna extraña razon no me deja cerrar los Stream en el finally
                in.close();
                fileIn.close();
            }
            catch(IOException i){

            }
            catch(ClassNotFoundException c){
                System.out.println("No se ha encontrado lo que buscaba");
                c.printStackTrace();
            }
            finally{//aqui deberia cerrar los Stream pero no me deja
            }
        
            try{
                FileInputStream fileIn = new FileInputStream(new File("").getAbsolutePath()+"/datosEscuderia.dat");
                ObjectInputStream in = new ObjectInputStream(fileIn);
                
                //2º Obtener el arrayList
                participantes = (ArrayList<Escuderia>) in.readObject();

                //por alguna extraña razon no me deja cerrar los Stream en el finally
                in.close();
                fileIn.close();
            }
            catch(IOException i){

            }
            catch(ClassNotFoundException c){
                System.out.println("No se ha encontrado lo que buscaba");
                c.printStackTrace();
            }
            finally{//aqui deberia cerrar los Stream pero no me deja
            }
       
            System.out.println("Solo podrán correr en el circuito los pilotos oficiales que posean escuderia. Dichos pilotos son:");
            for (int i=0; i< participantes.size();i++){
                if (participantes.get(i).getPilotoOficial()!=null){
                    Piloto[] pilotos = participantes.get(i).getPilotoOficial();
                    for (int j = 0; j < pilotos.length; j++) {
                        if (pilotos[j]!=null){
                         System.out.println("Piloto ["+j+1+"]: "+pilotos[j].getNombre());
                         comprobacion=true;
                        }
                    }   
                }
            } 
            if (!comprobacion){
                        System.out.println("No hay pilotos oficiales en la escuderias");
            }
            while (comenzar==false){
                System.out.print("Introduzca el nombre del piloto que desea que corra el circuito:");  String nombrePil= escaner.next();    System.out.println("");
                System.out.print("Introduzca el apellido del piloto que desea que corra el circuito:");  String apellidoPil= escaner.next();    System.out.println("");
                for (int i=0; i< participantes.size();i++){
                    if (participantes.get(i).getPilotoOficial()!=null){
                        Piloto[] pilotos = participantes.get(i).getPilotoOficial();
                         for (int j = 0; j < pilotos.length; j++) {
                           if (pilotos[j]!=null){
                                if (nombrePil.equals(pilotos[j].getNombre()) && apellidoPil.equals(pilotos[j].getApellido()) && pilotos[j].getCoche()!=null){
                                    integrantes.get(i).setParticipante(pilotos);
                                    
                                }
                           }
                           else {
                               System.out.println("El piloto que ha introducido no es piloto Oficial");
                           }   
                         }
                    
                    }
                }
                System.out.println("Desea que corran mas pilotos? S/N");
                String respuesta= escaner.next();    System.out.println("");
                if (respuesta.equals("S") | respuesta.equals("s")){
                    comenzar=false;
                }
                else{
                    comenzar=true;
                }
            }
   comenzar2=true;
   }
   public void darSalida(ArrayList<Circuito> carrera, ArrayList<Piloto> pilotos, ArrayList<Escuderia> escuderias){

            comenzarMundial();
            if (comenzar2=true){
            for (int i=0; i<carrera.size(); i++){
                if (carrera.get(i)!=null){
                    carrera.get(i).tiempos(); //En mi opinion en la clase circuito, metodo tiempos, deberia haber un system.print que diga que piloto es el ganador.
                    carrera.get(i).puntos(); // Lo mismo que arriba
                    carrera.get(i).pagar();
                }
            }
            for (int i = 0; i < escuderias.size(); i++) {
                if (escuderias.get(i)!=null){
                       escuderias.get(i).reset();
                    }
            }
            }
   }

    }
       

