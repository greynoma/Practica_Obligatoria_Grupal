/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Phoenix
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        Scanner mundial= new Scanner(System.in);
        String nomcir,patro;
        int rectas,curvas;
        double precio;
        int numescu;
        int aforo;
        ArrayList <Circuito> liscur= new ArrayList<Circuito>();
        ArrayList <Circuito> lisrec= new ArrayList<Circuito>();
        double tramorecta,tramocurva;
        
        String nomescu;
        String dueno;
        String pais;
        int fundacion;
        int pmun;
        int numdirectivos;
        String nomdirectivos;
        double presupuesto;
        ArrayList <String> directivos= new ArrayList <String>();
        
        int numpilse;
        int numpilce;
        String nompilse;
        String nompilce;
        String apellidose;
        String apellidoce;
        int edadse;
        int edadce;
        int numerodirectivos;
        String nombredirectivos;
        double alturase;
        double alturace;
        double pesose;
        double pesoce;
        double reflejosse;
        double reflejosce;
        double agresividadse;
        double agresividadce;
        double valentiase;
        double valentiace;
        double pacienciase;
        double pacienciace;
     
        
        String nombreescuderia;
        String duenoescuderia;
        String paisescuderia;
        int fundacionescuderia;
        int pmunescuderia;
        double presupuestoescuderia;
        ArrayList <String> directivosescuderia= new ArrayList <String>();
        
        Mundial f1= new Mundial();
        System.out.println("Tiene que inscribir 5 circuitos.A continuacion se le preguntará por las caracteristicas de los circuitos.");
        for (int i=0; i<5;i++ ){
            System.out.print("Escoja el nombre del circuito "+ i+": ");     nomcir=mundial.next();    System.out.println("");
            System.out.print("Escoja el patrocinador del circuito "+ i+": ");     patro=mundial.next();   System.out.println("");
            System.out.print("Escoja el nº de rectas del circuito "+ i+": ");     rectas=mundial.nextInt();   System.out.println("");
            System.out.print("Escoja el nº de curvas del circuito "+ i+": ");     curvas=mundial.nextInt();   System.out.println("");
            System.out.print("Escoja el precio del circuito "+ i+": ");     precio=mundial.nextDouble();     System.out.println("");
            System.out.print("Escoja el aforo del circuito "+ i+": ");     aforo=mundial.nextInt();       System.out.println("");

            
            f1.darAlta("/datosCircuito.dat", new Circuito (nomcir,patro,rectas,curvas,precio,aforo));
        }
        System.out.println("Ahora debe de inscribir el numero de escuderias que desea. Dicho numero es...");    numescu= mundial.nextInt();
        for (int i=0; i<numescu; i++){
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
            f1.darAlta("/datosEscuderia.dat", new Escuderia(dueno,nomescu,pais,fundacion,pmun,presupuesto,directivos));
        }
        System.out.println("Por último debe de inscribir el numero de pilotos que desea.Recuerde que puede elegir que el piloto desde un inicio pertenezcaa una escuderia.");
        System.out.print("Numero de pilotos sin escuderia: ");    numpilse=mundial.nextInt(); System.out.println("");
        System.out.print("Numero de pilotos con escuderia: ");    numpilce=mundial.nextInt(); System.out.println("");
        for ( int i=0; i<numpilse; i++){
            System.out.print("Escoja el nombre del piloto "+i+" :"); nompilse=mundial.next();  System.out.println("");
            System.out.print("Escoja el apellido del piloto "+i+" :");   apellidose=mundial.next();    System.out.println("");
            System.out.print("Escoja la edad del piloto "+i+" :");   edadse=mundial.nextInt();     System.out.println("");
            System.out.print("Escoja la altura del piloto "+i+" :"); alturase=mundial.nextDouble();    System.out.println("");
            System.out.print("Escoja el peso del piloto "+i+" :");   pesose=mundial.nextDouble();      System.out.println("");
            System.out.print("Escoja los reflejos del piloto "+i+" (Recuerde: Los valores van de 1 a 5)");   reflejosse= mundial.nextDouble();   System.out.println("");
            System.out.print("Escoja la agresividad del piloto "+i+" (Recuerde: Los valores van de 1 a 5)");    agresividadse=mundial.nextDouble();   System.out.println("");
            System.out.print("Escoja la paciencia del piloto "+i+" (Recuerde: Los valores van de 1 a 5)");  pacienciase=mundial.nextDouble();     System.out.println("");
            System.out.print("Escoja la valentia del piloto "+i+" (Recuerde: Los valores van de 1 a 5)");   valentiase=mundial.nextDouble();      System.out.println("");
            f1.darAlta("/datosPiloto.dat", new Piloto(nompilse,apellidose,edadse,alturase,pesose,reflejosse,agresividadse,pacienciase,valentiase));
        }
        for ( int i=0; i<numpilce; i++){
            System.out.print("Escoja el nombre del piloto "+i+" :"); nompilce=mundial.next();  System.out.println("");
            System.out.print("Escoja el apellido del piloto "+i+" :");   apellidoce=mundial.next();    System.out.println("");
            System.out.print("Escoja la edad del piloto "+i+" :");   edadce=mundial.nextInt();     System.out.println("");
            System.out.print("Escoja el dueno de la escuderia a la que pertenece el piloto "+ i+": ");     duenoescuderia=mundial.next();    System.out.println("");
            System.out.print("Escoja el nombre de la escuderia a la que pertenece el piloto "+ i+": ");     nombreescuderia=mundial.next();   System.out.println("");
            System.out.print("Escoja la nacionalidad de la escuderia a la que pertenece el piloto "+ i+": ");     paisescuderia=mundial.next();   System.out.println("");
            System.out.print("Escoja la fecha de fundacion de la escuderia a la que pertenece el piloto "+ i+": ");     fundacionescuderia=mundial.nextInt();   System.out.println("");
            System.out.print("Escoja la cantidad de puntos del mundial que posee la escuderia del piloto "+ i+": ");     pmunescuderia=mundial.nextInt();     System.out.println("");
            System.out.print("Escoja el presupuesto de la escuderia a la que pertence el piloto "+ i+": ");     presupuestoescuderia=mundial.nextDouble();       System.out.println("");
            System.out.print("Cuantos directivos tiene la escuderia?:");    numerodirectivos=mundial.nextInt();    System.out.println("");
            for (int u=0; u< numerodirectivos; u++){
                System.out.print("Nombre del directivo "+u+" :");   nombredirectivos=mundial.next();   System.out.println("");
                directivos.add(nombredirectivos);
            }
            System.out.print("Escoja la altura del piloto "+i+" :"); alturace=mundial.nextDouble();    System.out.println("");
            System.out.print("Escoja el peso del piloto "+i+" :");   pesoce=mundial.nextDouble();      System.out.println("");
            System.out.print("Escoja los reflejos del piloto "+i+" (Recuerde: Los valores van de 1 a 5)");   reflejosce= mundial.nextDouble();   System.out.println("");
            System.out.print("Escoja la agresividad del piloto "+i+" (Recuerde: Los valores van de 1 a 5)");    agresividadce=mundial.nextDouble();   System.out.println("");
            System.out.print("Escoja la paciencia del piloto "+i+" (Recuerde: Los valores van de 1 a 5)");  pacienciace=mundial.nextDouble();     System.out.println("");
            System.out.print("Escoja la valentia del piloto "+i+" (Recuerde: Los valores van de 1 a 5)");   valentiace=mundial.nextDouble();      System.out.println("");
            f1.darAlta("/datosEscuderia.dat", new Escuderia(duenoescuderia,nombreescuderia,paisescuderia,fundacionescuderia,pmunescuderia,presupuestoescuderia,directivosescuderia));
            f1.darAlta("/datosPiloto.dat", new Piloto(nompilce,apellidoce,edadce,new Escuderia(duenoescuderia,nombreescuderia,paisescuderia,fundacionescuderia,pmunescuderia,presupuestoescuderia,directivosescuderia),alturace,pesoce,reflejosce,agresividadce,pacienciace,valentiace));
        }
        String respuesta;
        String opcion;
        int opcionescuderia;
        System.out.print("Los datos ya se han cargado.Desea hacer alguna modificacion? S/N"); respuesta=mundial.next(); System.out.println("");
        if (respuesta.equals("s") | respuesta.equals("S")){
            System.out.println("Que desea cambiar? E/P/C"); opcion=mundial.next();  System.out.println("");
            if (opcion.equals("e") | opcion.equals("E")){
                System.out.println("Ha elegido hacer cambios en Escuderia.Que desea hacer? 1.-Dar de Alta/ 2.-Dar de Baja/ 3.-Modificar datos");    opcionescuderia= mundial.nextInt();    System.out.println("");
                switch (opcionescuderia){
                    case 1:     System.out.println("Cuantas ecuderias va a dar de alta?");    numescu= mundial.nextInt();
                                for (int i=0; i<numescu; i++){
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
                                f1.darAlta("/datosEscuderia.dat", new Escuderia(dueno,nomescu,pais,fundacion,pmun,presupuesto,directivos));
                            }
                    case 2:     System.out.print("Introduzca el nombre de la escuderia que desea borrar: "); nomescu=mundial.next();    System.out.println("");
                                f1.darBaja("/datosEscuderia.dat", null);
                }
            }
        }
        /*Escuderia mercedes= new Escuderia("Tom Morello", "Mercedes", "Tegucigalpa", 1985, 0, 10000.5, null);
        mercedes.crearCoche("M-100", 3, 2, 1);
        mercedes.crearCoche("M-105", 3, 2, 1);
        mercedes.crearCoche("M-205", 3, 2, 1);
        mercedes.asignarVehiculos();
        System.out.println(mercedes.comprobarDinero(100000.92));*/
    }
    
}
