/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import gui.VentanaPrincipal;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Phoenix
 */
public class Main {
Scanner mundial= new Scanner(System.in);
        String patro;
        int rectas,curvas;
        double precio;
        int numescu;
        int aforo;
        
        String dueno;
        String pais;
        int fundacion;
        int pmun;
        int numdirectivos;
        String nomdirectivos;
        double presupuesto;
        ArrayList <String> directivos= new ArrayList <>();
        ArrayList <Escuderia> escuderias= new ArrayList ();
        ArrayList <Piloto> pilotos= new ArrayList ();
        ArrayList <Circuito> circuitos= new ArrayList ();
        ArrayList <Coche> coches= new ArrayList ();
        
        double potencia;
        double aerodinamica;
        double neumaticos;
        
        int numpilse;
        int numpilce;
        String nombre;
        String nombrecircuito;
        String nombrecoche;
        String apellido;
        int edad;
        double altura;
        double peso;
        double reflejos;
        double agresividad;
        double valentia;
        double paciencia;
        String nombreescuderia;
        int menu=4;
        boolean menuavanzar=false;
        boolean menuavanzar2=false;
        
        String respuesta;
        int campo;
        int opcionMun;
        boolean comprobacion=false;
        boolean comprobacion2=false;
        boolean comprobacion3=false;
        boolean comprobacion4=false;
        
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        Main programa=new Main();
        programa.inicializar();
    }

    private void inicializar() {
        
        
        Mundial f1= new Mundial();
        this.actualizarDatos();
        while (menu!=0){
            System.out.println("MENU:");
            System.out.println("1.- Operaciones de insercion");
            System.out.println("2.- Operaciones internas");
            System.out.println("3.- Iniciar Mundial");
            System.out.println("0.- Salir");
            System.out.println("Elija una opcion del menu.");
            menu=mundial.nextInt();
            switch (menu){
                case 1: System.out.print("Desea inscribir circuitos? S/N ");  respuesta=mundial.next();   System.out.println("");   
                        if(respuesta.equals("S") | respuesta.equals("s")){
                            if (circuitos.size()<5){
                                int numcir= 5-circuitos.size();
                                System.out.println("Tiene que inscribir "+numcir+" circuitos.A continuacion se le preguntará por las caracteristicas de los circuitos.");
                                for (int i=circuitos.size(); i<numcir;i++ ){
                                    System.out.print("Escoja el nombre del circuito "+ (i+1)+": ");     nombre=mundial.next();    System.out.println("");
                                    System.out.print("Escoja el patrocinador del circuito "+ (i+1)+": ");     patro=mundial.next();   System.out.println("");
                                    System.out.print("Escoja el nº de rectas del circuito "+ (i+1)+": ");     rectas=mundial.nextInt();   System.out.println("");
                                    System.out.print("Escoja el nº de curvas del circuito "+ (i+1)+": ");     curvas=mundial.nextInt();   System.out.println("");
                                    System.out.print("Escoja el precio del circuito "+ (i+1)+": ");     precio=mundial.nextDouble();     System.out.println("");
                                    System.out.print("Escoja el aforo del circuito "+ (i+1)+": ");     aforo=mundial.nextInt();       System.out.println("");


                                    f1.darAlta("/datosCircuito.dat", new Circuito (nombre,patro,rectas,curvas,precio,aforo));
                                    this.actualizarDatos();
                            }
                            }
                            else{
                                System.out.println("Ya hay 5 circuitos. Dichos circuitos son:");
                                for ( int i=0; i<circuitos.size(); i++){
                                    System.out.println("Circuito ["+(i+1)+"]: "+circuitos.get(i).getNombre());
                                }
                            }
                        }
                        else{
                                System.out.println("Los circuitos son:");
                                for ( int i=0; i<circuitos.size(); i++){
                                    System.out.println("Circuito ["+(i+1)+"]: "+circuitos.get(i).getNombre());
                                }
                        }
                        System.out.print("Desea inscribir escuderias? S/N ");  respuesta=mundial.next();   System.out.println("");   
                        if(respuesta.equals("S") | respuesta.equals("s")){
                            System.out.println("Ahora debe de inscribir el numero de escuderias que desea. Dicho numero es...");    numescu= mundial.nextInt();
                            for (int i=0; i<numescu; i++){
                                System.out.print("Escoja el nombre de la escuderia "+ (i+1)+": ");     nombre=mundial.next();   System.out.println("");
                                for (int j = 0; j < escuderias.size(); j++) {
                                    if( nombre.equals(escuderias.get(j).getNombre())){
                                        System.out.println("Ya existe una escuderia con ese nombre.No se dára de alta.");
                                        comprobacion=true;
                                    }
                                }
                                if (!comprobacion){
                                System.out.print("Escoja el dueño de la escuderia "+ (i+1)+": ");     dueno=mundial.next();    System.out.println("");
                                System.out.print("Escoja la nacionalidad de la escuderia "+ (i+1)+": ");     pais=mundial.next();   System.out.println("");
                                System.out.print("Escoja la fecha de fundacion de la escuderia "+ (i+1)+": ");     fundacion=mundial.nextInt();   System.out.println("");
                                System.out.print("Escoja la cantidad de puntos del mundial que posee la escuderia "+ (i+1)+": ");     pmun=mundial.nextInt();     System.out.println("");
                                System.out.print("Escoja el presupuesto de la escuderia "+ (i+1)+": ");     presupuesto=mundial.nextDouble();       System.out.println("");
                                System.out.print("Cuantos directivos tiene la escuderia?: ");    numdirectivos=mundial.nextInt();    System.out.println("");
                                for (int u=0; u< numdirectivos; u++){
                                    System.out.print("Nombre del directivo "+(u+1)+" :");   nomdirectivos=mundial.next();   System.out.println("");
                                    directivos.add(nomdirectivos);
                                }
                                f1.darAlta("/datosEscuderia.dat", new Escuderia(dueno,nombre,pais,fundacion,pmun,presupuesto,directivos));
                                this.actualizarDatos();
                                }
                                
                            }
                        }
                        else{
                            System.out.println("Estas son las escuderias que hay (se mostrara un maximo de 20 escuderias):");
                                for ( int i=0; i<escuderias.size(); i++){
                                    if (i+1>15){
                                        i=escuderias.size();
                                    }
                                    else{
                                        System.out.println("Escuderias ["+(i+1)+"]: "+escuderias.get(i).getNombre());
                                    }
                                }
                        }
                        System.out.print("Desea inscribir pilotos? S/N ");  respuesta=mundial.next();   System.out.println("");   
                        if(respuesta.equals("S") | respuesta.equals("s")){
                            System.out.println("Por último debe de inscribir el numero de pilotos que desea.Recuerde que puede elegir que el piloto desde un inicio pertenezca a una escuderia.");
                            System.out.print("Numero de pilotos sin escuderia: ");    numpilse=mundial.nextInt(); System.out.println("");
                            System.out.print("Numero de pilotos con escuderia: ");    numpilce=mundial.nextInt(); System.out.println("");
                            for ( int i=0; i<numpilse; i++){
                                System.out.print("Escoja el nombre del piloto sin escuderia "+(i+1)+" :"); nombre=mundial.next();  System.out.println("");
                                System.out.print("Escoja el apellido del piloto sin escuderia "+(i+1)+" :");   apellido=mundial.next();    System.out.println("");
                                for (int j=0; j <pilotos.size(); j++){
                                    if (nombre.equals(pilotos.get(j).getNombre()) && apellido.equals(pilotos.get(j).getApellido())){
                                        System.out.println("Ya exite otro piloto con ese nombre y apellido. No se le dará de alta.");
                                        comprobacion3=true;
                                    }
                                }
                                if(!comprobacion3){
                                System.out.print("Escoja la edad del piloto sin escuderia "+(i+1)+" :");   edad=mundial.nextInt();     System.out.println("");
                                System.out.print("Escoja la altura del piloto sin escuderia "+(i+1)+" :"); altura=mundial.nextDouble();    System.out.println("");
                                System.out.print("Escoja el peso del piloto sin escuderia "+(i+1)+" :");   peso=mundial.nextDouble();      System.out.println("");
                                System.out.print("Escoja los reflejos del piloto sin escuderia "+(i+1)+" (Recuerde: Los valores van de 1 a 5)");   reflejos= mundial.nextDouble();   System.out.println("");
                                System.out.print("Escoja la agresividad del piloto sin escuderia "+(i+1)+" (Recuerde: Los valores van de 1 a 5)");    agresividad=mundial.nextDouble();   System.out.println("");
                                System.out.print("Escoja la paciencia del piloto sin escuderia "+(i+1)+" (Recuerde: Los valores van de 1 a 5)");  paciencia=mundial.nextDouble();     System.out.println("");
                                System.out.print("Escoja la valentia del piloto sin escuderia "+(i+1)+" (Recuerde: Los valores van de 1 a 5)");   valentia=mundial.nextDouble();      System.out.println("");
                                
                                f1.darAlta("/datosPiloto.dat", new Piloto(nombre,apellido,edad,altura,peso,reflejos,agresividad,paciencia,valentia));
                                this.actualizarDatos();
                                }
                            }
                            for ( int i=0; i<numpilce; i++){
                                System.out.print("Escoja el nombre del piloto con escuderia "+(i+1)+" :"); nombre=mundial.next();  System.out.println("");
                                System.out.print("Escoja el apellido del piloto con escuderia "+(i+1)+" :");   apellido=mundial.next();    System.out.println("");
                                for (int j=0; j <pilotos.size(); j++){
                                    if (nombre.equals(pilotos.get(j).getNombre()) && apellido.equals(pilotos.get(j).getApellido())){
                                        System.out.println("Ya exite otro piloto con ese nombre y apellido. No se le dará de alta.");
                                        comprobacion3=true;
                                    }
                                }
                                if(!comprobacion3){
                                System.out.print("Escoja la edad del piloto con escuderia "+(i+1)+" :");   edad=mundial.nextInt();     System.out.println("");
                                System.out.print("Escoja la altura del piloto "+(i+1)+" :"); altura=mundial.nextDouble();    System.out.println("");
                                System.out.print("Escoja el peso del piloto "+(i+1)+" :");   peso=mundial.nextDouble();      System.out.println("");
                                System.out.print("Escoja los reflejos del piloto "+(i+1)+" (Recuerde: Los valores van de 1 a 5)");   reflejos= mundial.nextDouble();   System.out.println("");
                                System.out.print("Escoja la agresividad del piloto "+(i+1)+" (Recuerde: Los valores van de 1 a 5)");    agresividad=mundial.nextDouble();   System.out.println("");
                                System.out.print("Escoja la paciencia del piloto "+(i+1)+" (Recuerde: Los valores van de 1 a 5)");  paciencia=mundial.nextDouble();     System.out.println("");
                                System.out.print("Escoja la valentia del piloto "+(i+1)+" (Recuerde: Los valores van de 1 a 5)");   valentia=mundial.nextDouble();      System.out.println("");
                                f1.darAlta("/datosPiloto.dat", new Piloto(nombre,apellido,edad,altura,peso,reflejos,agresividad,paciencia,valentia));
                                this.actualizarDatos();
                                }
                                System.out.print("Escoja el nombre de la escuderia a la que va a pertenecer el piloto con escuderia "+ (i+1)+": ");     nombreescuderia=mundial.next();   System.out.println("");
                                for (int u=0; u< escuderias.size(); u++){
                                    if (nombreescuderia.equals(escuderias.get(u).getNombre())){
                                        for (int j=0; j< pilotos.size();j++){
                                            if (nombre.equals(pilotos.get(j).getNombre()) && apellido.equals(pilotos.get(j).getApellido())){
                                                if (pilotos.get(j).getEscuderia()!=null){
                                                    pilotos.get(j).getEscuderia().descartarPiloto("/datosEscuderia.dat");
                                                    escuderias.get(u).ficharPiloto("/datosPiloto.dat", nombre, apellido);
                                                    this.actualizarDatos();
                                                    comprobacion4=true;
                                                }
                                                else{
                                                    escuderias.get(u).ficharPiloto("/datosPiloto.dat", nombre, apellido);
                                                    this.actualizarDatos();
                                                    comprobacion4=true; 
                                                }
                                            }
                                        
                                        }
                                    comprobacion2=true;
                                    }
                                    
                                }
                                if (!comprobacion2){
                                    System.out.println("No existe esa escuderia.");
                                }
                                if (!comprobacion4){
                                    System.out.println("Ese piloto no existe.");
                                }
                                if(!comprobacion2){
                                    System.out.print("Escoja el dueño de la escuderia a la que pertenece el piloto con escuderia "+ (i+1)+": ");     dueno=mundial.next();    System.out.println("");
                                    System.out.print("Escoja la nacionalidad de la escuderia a la que pertenece el piloto con escuderia "+ (i+1)+": ");     pais=mundial.next();   System.out.println("");
                                    System.out.print("Escoja la fecha de fundacion de la escuderia a la que pertenece el piloto con escuderia "+ (i+1)+": ");     fundacion=mundial.nextInt();   System.out.println("");
                                    System.out.print("Escoja la cantidad de puntos del mundial que posee la escuderia del piloto con escuderia "+ (i+1)+": ");     pmun=mundial.nextInt();     System.out.println("");
                                    System.out.print("Escoja el presupuesto de la escuderia a la que pertence el piloto con escuderia "+ (i+1)+": ");     presupuesto=mundial.nextDouble();       System.out.println("");
                                    System.out.print("Cuantos directivos tiene la escuderia?:");    numdirectivos=mundial.nextInt();    System.out.println("");
                                    for (int u=0; u< numdirectivos; u++){
                                        System.out.print("Nombre del directivo "+(u+1)+" :");   nomdirectivos=mundial.next();   System.out.println("");
                                        directivos.add(nomdirectivos);
                                    }
                                    Escuderia aux= new Escuderia(dueno,nombreescuderia,pais,fundacion,pmun,presupuesto,directivos);
                                    f1.darAlta("/datosEscuderia.dat", aux);
                                    this.actualizarDatos();
                                    
                                    for (int j=0; j< pilotos.size();j++){
                                            if (nombre.equals(pilotos.get(j).getNombre()) && apellido.equals(pilotos.get(j).getApellido())){
                                                if (pilotos.get(j).getEscuderia()!=null){
                                                    pilotos.get(j).getEscuderia().descartarPiloto("/datosEscuderia.dat");
                                                    aux.ficharPiloto("/datosPiloto.dat", nombre, apellido);
                                                    this.actualizarDatos();
                                                }
                                                else{
                                                    aux.ficharPiloto("/datosPiloto.dat", nombre, apellido);
                                                    this.actualizarDatos();
                                                }
                                            }
                                        
                                        }
                                }

                                }
                        }
                        else{
                            System.out.println("Estos son los pilotos que hay (se mostrara un maximo de 20 pilotos):");
                                for ( int i=0; i<pilotos.size(); i++){
                                    if (i+1>15){
                                        i=pilotos.size();
                                    }
                                    else{
                                        System.out.println("Piloto ["+(i+1)+"]: "+pilotos.get(i).getNombre()+" "+pilotos.get(i).getApellido());
                                    }
                                }
                        }
                            System.out.print("Los datos ya se han cargado.Desea hacer alguna modificacion? S/N "); respuesta=mundial.next(); System.out.println("");
                            while (respuesta.equals("s") | respuesta.equals("S")){
                                System.out.println("Que desea cambiar? E/P/C"); respuesta=mundial.next();  System.out.println("");
                                if (respuesta.equals("e") | respuesta.equals("E")){
                                    System.out.println("Ha elegido hacer cambios en Escuderia.Que desea hacer? 1.-Dar de Alta/ 2.-Dar de Baja/ 3.-Modificar datos");    opcionMun= mundial.nextInt();    System.out.println("");
                                    if(opcionMun<=3 & opcionMun>=1){
                                    switch (opcionMun){
                                        case 1:     
                                                System.out.print("Escoja el nombre de la escuderia: ");     nombre=mundial.next();   System.out.println("");
                                                for (int i = 0; i < escuderias.size(); i++) {
                                                    if( nombre.equals(escuderias.get(i).getNombre())){
                                                        System.out.println("Ya existe una escuderia con ese nombre. No se dara de alta.");
                                                        comprobacion2=true;
                                                    }
                                                }
                                                if (!comprobacion2){
                                                System.out.print("Escoja el dueño de la escuderia: ");     dueno=mundial.next();    System.out.println("");
                                                System.out.print("Escoja la nacionalidad de la escuderia: ");     pais=mundial.next();   System.out.println("");
                                                System.out.print("Escoja la fecha de fundacion de la escuderia: ");     fundacion=mundial.nextInt();   System.out.println("");
                                                System.out.print("Escoja la cantidad de puntos del mundial que posee la escuderia: ");     pmun=mundial.nextInt();     System.out.println("");
                                                System.out.print("Escoja el presupuesto de la escuderia: ");     presupuesto=mundial.nextDouble();       System.out.println("");
                                                System.out.print("Cuantos directivos tiene la escuderia?: ");    numdirectivos=mundial.nextInt();    System.out.println("");
                                                for (int u=0; u< numdirectivos; u++){
                                                    System.out.print("Nombre del directivo "+(u+1)+" :");   nomdirectivos=mundial.next();   System.out.println("");
                                                    directivos.add(nomdirectivos);
                                                }
                                                f1.darAlta("/datosEscuderia.dat", new Escuderia(dueno,nombre,pais,fundacion,pmun,presupuesto,directivos));
                                                this.actualizarDatos();
                                                }
                                                opcionMun=4;
                                                break;
                                        case 2:     System.out.print("Introduzca el nombre de la escuderia que desea borrar: "); nombre=mundial.next();    System.out.println("");
                                                    f1.darBaja("/datosEscuderia.dat", nombre);
                                                    this.actualizarDatos();
                                                    opcionMun=4;
                                                    break;
                                        case 3:     System.out.print("Introduzca el nombre de la escuderia que desea modificar: "); nombre=mundial.next();    System.out.println(""); 
                                                    f1.modificar("/datosEscuderia.dat", nombre);
                                                    this.actualizarDatos();
                                                    opcionMun=4;
                                                    break;
                                    }
                                        System.out.println("Desea hacer mas cambios? 1.-Dar de Alta/ 2.-Dar de Baja/ 3.-Modificar datos/ 0.-Volver ");    opcionMun= mundial.nextInt();    System.out.println("");
                                    }
                                }
                                if (respuesta.equals("p") | respuesta.equals("P")){
                                    System.out.print("Ha elegido hacer cambios en Piloto.Que desea hacer? 1.-Dar de Alta/ 2.-Dar de Baja/ 3.-Modificar datos ");    opcionMun=mundial.nextInt();    System.out.println("");
                                    while (opcionMun==1 || opcionMun==2 || opcionMun==3){
                                        switch (opcionMun){
                                            case 1:     System.out.println("Hay dos tipos de pilotos. Escoja el tipo de piloto que va a dar de alta. 1.-Sin escuderia/ 2.- Con escuderia"); campo=mundial.nextInt();    System.out.println("");
                                                        if (campo==1){
                                                            System.out.print("Escoja el nombre del piloto: "); nombre=mundial.next();  System.out.println("");
                                                            System.out.print("Escoja el apellido del piloto: ");   apellido=mundial.next();    System.out.println("");
                                                            for (int i = 0; i < pilotos.size(); i++) {
                                                                if (nombre.equals(pilotos.get(i).getNombre()) && pilotos.equals(pilotos.get(i).getApellido())){
                                                                    System.out.println("Ya existe ese piloto. No se dará de alta.");
                                                                    comprobacion=true;
                                                                }
                                                            }
                                                            if (!comprobacion){
                                                            System.out.print("Escoja la edad del piloto: ");   edad=mundial.nextInt();     System.out.println("");
                                                            System.out.print("Escoja la altura del piloto: "); altura=mundial.nextDouble();    System.out.println("");
                                                            System.out.print("Escoja el peso del piloto: ");   peso=mundial.nextDouble();      System.out.println("");
                                                            System.out.print("Escoja los reflejos del piloto  (Recuerde: Los valores van de 1 a 5) ");   reflejos= mundial.nextDouble();   System.out.println("");
                                                            System.out.print("Escoja la agresividad del piloto  (Recuerde: Los valores van de 1 a 5) ");    agresividad=mundial.nextDouble();   System.out.println("");
                                                            System.out.print("Escoja la paciencia del piloto  (Recuerde: Los valores van de 1 a 5) ");  paciencia=mundial.nextDouble();     System.out.println("");
                                                            System.out.print("Escoja la valentia del piloto (Recuerde: Los valores van de 1 a 5) ");   valentia=mundial.nextDouble();      System.out.println("");
                                                            f1.darAlta("/datosPiloto.dat", new Piloto(nombre,apellido,edad,altura,peso,reflejos,agresividad,paciencia,valentia));
                                                            this.actualizarDatos();
                                                            }
                                                        }
                                                        else if (campo==2){
                                                            System.out.print("Escoja el nombre del piloto:"); nombre=mundial.next();  System.out.println("");
                                                            System.out.print("Escoja el apellido del piloto:");   apellido=mundial.next();    System.out.println("");
                                                            for (int i = 0; i < pilotos.size(); i++) {
                                                                if (nombre.equals(pilotos.get(i).getNombre()) && pilotos.equals(pilotos.get(i).getApellido())){
                                                                    System.out.println("Ya existe ese piloto. No se dará de alta, pero se le podrá asignar una escuderia.");
                                                                    comprobacion2=true;
                                                                }
                                                            }
                                                            if (!comprobacion2){
                                                            System.out.print("Escoja la edad del piloto:");   edad=mundial.nextInt();     System.out.println("");
                                                            System.out.print("Escoja la altura del piloto: "); altura=mundial.nextDouble();    System.out.println("");
                                                            System.out.print("Escoja el peso del piloto: ");   peso=mundial.nextDouble();      System.out.println("");
                                                            System.out.print("Escoja los reflejos del piloto  (Recuerde: Los valores van de 1 a 5) ");   reflejos= mundial.nextDouble();   System.out.println("");
                                                            System.out.print("Escoja la agresividad del piloto  (Recuerde: Los valores van de 1 a 5) ");    agresividad=mundial.nextDouble();   System.out.println("");
                                                            System.out.print("Escoja la paciencia del piloto  (Recuerde: Los valores van de 1 a 5) ");  paciencia=mundial.nextDouble();     System.out.println("");
                                                            System.out.print("Escoja la valentia del piloto  (Recuerde: Los valores van de 1 a 5) ");   valentia=mundial.nextDouble();      System.out.println("");
                                                            f1.darAlta("/datosPiloto.dat", new Piloto(nombre,apellido,edad,altura,peso,reflejos,agresividad,paciencia,valentia));
                                                            }
                                                            System.out.println("Desea asignar una escuderia al piloto?: S/N "); respuesta=mundial.next();   System.out.println("");
                                                            while (respuesta.equals("S") || respuesta.equals("s")){}
                                                                System.out.print("Escoja el nombre de la escuderia a la que va a pertenecer el piloto: ");     nombreescuderia=mundial.next();   System.out.println("");
                                                                for (int i = 0; i < escuderias.size(); i++) {
                                                                    if( nombreescuderia.equals(escuderias.get(i).getNombre())){
                                                                        System.out.println("Ya existe otra escuderia con ese nombre. No se dará de alta, pero se podrá asignar pilotos.");
                                                                        comprobacion2=true;
                                                                    }
                                                                }
                                                                if (!comprobacion2){
                                                                System.out.print("Escoja el dueño de la escuderia a la que pertenece el piloto: ");     dueno=mundial.next();    System.out.println("");
                                                                System.out.print("Escoja la nacionalidad de la escuderia a la que pertenece el piloto: ");     pais=mundial.next();   System.out.println("");
                                                                System.out.print("Escoja la fecha de fundacion de la escuderia a la que pertenece el piloto: ");     fundacion=mundial.nextInt();   System.out.println("");
                                                                System.out.print("Escoja la cantidad de puntos del mundial que posee la escuderia del piloto: ");     pmun=mundial.nextInt();     System.out.println("");
                                                                System.out.print("Escoja el presupuesto de la escuderia a la que pertence el piloto: ");     presupuesto=mundial.nextDouble();       System.out.println("");
                                                                System.out.print("Cuantos directivos tiene la escuderia?: ");    numdirectivos=mundial.nextInt();    System.out.println("");
                                                                for (int u=0; u< numdirectivos; u++){
                                                                    System.out.print("Nombre del directivo "+u+" :");   nomdirectivos=mundial.next();   System.out.println("");
                                                                    directivos.add(nomdirectivos);
                                                                }
                                                                f1.darAlta("/datosEscuderia.dat",new Escuderia(dueno, nombreescuderia, pais, fundacion, pmun, presupuesto, directivos));
                                                                this.actualizarDatos();
                                                                }



                                                                for (int i=0; i< escuderias.size(); i++){
                                                                    if (nombreescuderia.equals(escuderias.get(i).getNombre())){
                                                                        for (int j=0; j< pilotos.size();j++){
                                                                            if (nombre.equals(pilotos.get(j).getNombre()) && apellido.equals(pilotos.get(j).getApellido())){
                                                                                if (pilotos.get(j).getEscuderia()!=null){
                                                                                    pilotos.get(j).getEscuderia().descartarPiloto("/datosEscuderia.dat");
                                                                                    escuderias.get(i).ficharPiloto("/datosPiloto", nombre, apellido);
                                                                                    this.actualizarDatos();
                                                                                    comprobacion4=true;
                                                                                }
                                                                                else{
                                                                                    escuderias.get(i).ficharPiloto("/datosPiloto", nombre, apellido);
                                                                                    this.actualizarDatos();
                                                                                    comprobacion4=true;   
                                                                                }
                                                                            }
                                                                            
                                                                        }
                                                                    }
                                                                comprobacion3=true;
                                                                }
                                                                if (!comprobacion3){
                                                                    System.out.println("No existe esa escuderia.");
                                                                }
                                                            }
                                                        opcionMun=4;    
                                                        break;
                                            case 2: System.out.print("Introduzca el nombre del piloto: ");   nombre=mundial.next();   System.out.println("");
                                                    System.out.print("Introduzca el apellido del piloto: ");    apellido=mundial.next();  System.out.println("");
                                                    f1.darBaja("/datosPiloto.dat",nombre,apellido);
                                                    this.actualizarDatos();
                                                    opcionMun=4;
                                                    break;
                                            case 3: System.out.print("Introduzca el nombre del piloto: ");   nombre=mundial.next();   System.out.println("");
                                                    System.out.print("Introduzca el apellido del piloto: ");    apellido=mundial.next();  System.out.println("");
                                                    f1.modificar("/datosPiloto.dat",nombre,apellido);
                                                    this.actualizarDatos();
                                                    opcionMun=4;
                                                    break;
                                    }
                                        System.out.println("Desea hacer mas cambios? 1.-Dar de Alta/ 2.-Dar de Baja/ 3.-Modificar datos/ 0.-Volver ");    opcionMun= mundial.nextInt();    System.out.println("");
                                }
                                }
                                if (respuesta.equals("c") | respuesta.equals("C")){
                                    System.out.println("Ha elegido hacer cambios en Circuito.Que desea hacer? 1.-Dar de Alta/ 2.-Dar de Baja/ 3.-Modificar datos ");    opcionMun= mundial.nextInt();    System.out.println("");
                                    while (opcionMun<=3 & opcionMun>=1){
                                        switch (opcionMun){
                                            case 1:     if (circuitos.size()<5){
                                                            System.out.print("Escoja el nombre del circuito: ");     nombre=mundial.next();    System.out.println("");
                                                            System.out.print("Escoja el patrocinador del circuito: ");     patro=mundial.next();   System.out.println("");
                                                            System.out.print("Escoja el nº de rectas del circuito: ");     rectas=mundial.nextInt();   System.out.println("");
                                                            System.out.print("Escoja el nº de curvas del circuito: ");     curvas=mundial.nextInt();   System.out.println("");
                                                            System.out.print("Escoja el precio del circuito: ");     precio=mundial.nextDouble();     System.out.println("");
                                                            System.out.print("Escoja el aforo del circuito: ");     aforo=mundial.nextInt();       System.out.println("");

                                                            f1.darAlta("/datosCircuito.dat", new Circuito (nombre,patro,rectas,curvas,precio,aforo));
                                                            this.actualizarDatos();
                                                        }
                                                        else {
                                                            System.out.println("Ya existen 5 circuitos.");
                                                        }
                                                        opcionMun=4;
                                                        break;
                                            case 2:     
                                                        System.out.print("Introduzca el nombre del circuito que desea borrar: "); nombre=mundial.next();    System.out.println("");
                                                        f1.darBajaCir("/datosCircuito.dat", nombre);
                                                        this.actualizarDatos();
                                                        opcionMun=4;
                                                        break;
                                            case 3:     System.out.print("Introduzca el nombre del circuito que desea modificar: "); nombre=mundial.next();    System.out.println(""); 
                                                        f1.modificarCir("/datosCircuito.dat", nombre);
                                                        this.actualizarDatos();
                                                        opcionMun=4;
                                                        break;
                                        }            
                                    System.out.println("Desea hacer mas cambios? 1.-Dar de Alta/ 2.-Dar de Baja/ 3.-Modificar datos/ 0.-Volver ");    opcionMun= mundial.nextInt();    System.out.println("");
                                    }
                                }
                                
                                System.out.print("Los datos ya se han cargado.Desea hacer alguna modificacion? S/N "); respuesta=mundial.next(); System.out.println("");
                                
                            }
                            
                            break;    

                case 2:     if (escuderias.size()>0 && pilotos.size()>0 && circuitos.size()>0){
                            System.out.println("Ahora deberá crear coches para las escuderias que desee y asignar vehículos.");
                            System.out.println("Introduzca el nombre de la escuderia en la que desee crear el coche: ");    nombre=mundial.next();  System.out.println("");
                            for (int i=0; i< escuderias.size(); i++){
                                if ( nombre.equals(escuderias.get(i).getNombre())){
                                    System.out.print("Introduzca el modelo del coche: ");   nombre=mundial.next();  System.out.println("");
                                    System.out.print("Introduzca los neumaticos del coche: ");   neumaticos=mundial.nextDouble();  System.out.println("");
                                    System.out.print("Introduzca la potencia del coche: ");   potencia=mundial.nextDouble();  System.out.println("");
                                    System.out.print("Introduzca la aerodinamica del coche: ");   aerodinamica=mundial.nextDouble();  System.out.println("");
                                    escuderias.get(i).crearCoche(nombre,neumaticos,potencia,aerodinamica);
                                    escuderias.get(i).asignarVehiculos();
                                    this.actualizarDatos();
                                    comprobacion=true;
                                }
                            }
                            if (!comprobacion){
                                    System.out.println("Esa escuderia no existe.");
                            }
                            
                            this.actualizarDatos();
                            System.out.print("Tambien le damos la opcion de inciar un entrenamiento. Para ello debe de coger un piloto, un coche y un circuito.Desea iniciar el entrenamiento?: ");   respuesta=mundial.next();   System.out.println("");
                            while (respuesta.equals("s") | respuesta.equals("S")){
                                System.out.print("Que piloto va iniciar el entrenamiento?: ");
                                System.out.println("Introduzca el nombre: ");   nombre=mundial.next();  System.out.println("");
                                System.out.println("Introduzca el apellido: "); apellido=mundial.next();   System.out.println("");
                                System.out.print("Que coche se va a utilizar?: ");  nombrecoche=mundial.next(); System.out.println("");
                                System.out.println("En que circuito se va a realizar el entrenamiento?: "); nombrecircuito=mundial.next();
                                for (int i=0; i< pilotos.size(); i++){
                                    if ( nombre.equals(pilotos.get(i).getNombre()) && apellido.equals(pilotos.get(i).getApellido())){
                                        for (int j = 0; j < coches.size(); j++) {
                                            if (nombrecoche.equals(coches.get(j).getModelo())){
                                                for (int k = 0; k < circuitos.size(); k++) {
                                                    if (nombrecircuito.equals(circuitos.get(k).getNombre())){
                                                        escuderias.get(j).iniciarEntrenamiento(pilotos.get(i), coches.get(j), circuitos.get(k));
                                                        System.out.println("El piloto "+pilotos.get(i).getNombre()+" "+pilotos.get(i).getApellido()+" ha realizado el entrenamiento");
                                                        comprobacion3=true;
                                                    }
                                                    else{
                                                        System.out.println("No existe ese circuito.");
                                                    }
                                                }
                                                comprobacion2=true;
                                            }
                                            else{
                                                System.out.println("No existe ese coche.");
                                            }

                                        }
                                        comprobacion=true;
                                    }
                                }
                                if(!comprobacion){
                                    System.out.println("No existe ese piloto.");
                                }
                                if(!comprobacion2){
                                    System.out.println("No existe ese coche.");
                                }
                                if(!comprobacion3){
                                    System.out.println("No existe ese circuito.");
                                }
                                System.out.print("Desea que entrene otro piloto? S/N "); respuesta=mundial.next();   System.out.println(""); 
                            }
                }
                        else{
                           System.out.println("Primero debe de insertar datos.");
                        }
                        break;
                case 3: if (circuitos.size()==5 && escuderias.size()>0){
                            System.out.println("El mundial va a comenzar:");
                            this.actualizarDatos();
                            f1.darSalida();
                        }
                        else{
                            System.out.println("Primero debe de insertar datos, y despues realizar las operaciones internas( Iniciar entrenamiento no tiene que ejecutarse obligatoriamente )");
                        }
                        break;
            }
        }
                /*Escuderia mercedes= new Escuderia("Tom Morello", "Mercedes", "Tegucigalpa", 1985, 0, 10000.5, null);
                mercedes.crearCoche("M-100", 3, 2, 1);
                mercedes.crearCoche("M-105", 3, 2, 1);
                mercedes.crearCoche("M-205", 3, 2, 1);
                mercedes.asignarVehiculos();
                System.out.println(mercedes.comprobarDinero(100000.92));*/
    }
    
    private void actualizarDatos() {
        
        try{
                FileInputStream fileIn = new FileInputStream(new File("").getAbsolutePath()+"/datosPiloto.dat");
                ObjectInputStream in = new ObjectInputStream(fileIn);
                
                //2º Obtener el arrayList
                this.pilotos = (ArrayList<Piloto>) in.readObject();

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
                FileInputStream fileIn = new FileInputStream(new File("").getAbsolutePath()+"/datosCircuito.dat");
                ObjectInputStream in = new ObjectInputStream(fileIn);
                
                //2º Obtener el arrayList
                this.circuitos = (ArrayList<Circuito>) in.readObject();

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
                this.escuderias = (ArrayList<Escuderia>) in.readObject();

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
    }
}