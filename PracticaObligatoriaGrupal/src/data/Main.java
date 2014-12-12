/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

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
                case 1:
                        System.out.println("Tiene que inscribir 5 circuitos.A continuacion se le preguntará por las caracteristicas de los circuitos.");
                        for (int i=0; i<5;i++ ){
                            System.out.print("Escoja el nombre del circuito "+ (i+1)+": ");     nombre=mundial.next();    System.out.println("");
                            System.out.print("Escoja el patrocinador del circuito "+ (i+1)+": ");     patro=mundial.next();   System.out.println("");
                            System.out.print("Escoja el nº de rectas del circuito "+ (i+1)+": ");     rectas=mundial.nextInt();   System.out.println("");
                            System.out.print("Escoja el nº de curvas del circuito "+ (i+1)+": ");     curvas=mundial.nextInt();   System.out.println("");
                            System.out.print("Escoja el precio del circuito "+ (i+1)+": ");     precio=mundial.nextDouble();     System.out.println("");
                            System.out.print("Escoja el aforo del circuito "+ (i+1)+": ");     aforo=mundial.nextInt();       System.out.println("");


                            f1.darAlta("/datosCircuito.dat", new Circuito (nombre,patro,rectas,curvas,precio,aforo));
                            this.actualizarDatos();
                        }
                        System.out.println("Ahora debe de inscribir el numero de escuderias que desea. Dicho numero es...");    numescu= mundial.nextInt();
                        for (int i=0; i<numescu; i++){
                            System.out.print("Escoja el dueno de la escuderia "+ (i+1)+": ");     dueno=mundial.next();    System.out.println("");
                            System.out.print("Escoja el nombre de la escuderia "+ (i+1)+": ");     nombre=mundial.next();   System.out.println("");
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
                        System.out.println("Por último debe de inscribir el numero de pilotos que desea.Recuerde que puede elegir que el piloto desde un inicio pertenezca a una escuderia.");
                        System.out.print("Numero de pilotos sin escuderia: ");    numpilse=mundial.nextInt(); System.out.println("");
                        System.out.print("Numero de pilotos con escuderia: ");    numpilce=mundial.nextInt(); System.out.println("");
                        for ( int i=0; i<numpilse; i++){
                            System.out.print("Escoja el nombre del piloto "+(i+1)+" :"); nombre=mundial.next();  System.out.println("");
                            System.out.print("Escoja el apellido del piloto "+(i+1)+" :");   apellido=mundial.next();    System.out.println("");
                            System.out.print("Escoja la edad del piloto "+(i+1)+" :");   edad=mundial.nextInt();     System.out.println("");
                            System.out.print("Escoja la altura del piloto "+(i+1)+" :"); altura=mundial.nextDouble();    System.out.println("");
                            System.out.print("Escoja el peso del piloto "+(i+1)+" :");   peso=mundial.nextDouble();      System.out.println("");
                            System.out.print("Escoja los reflejos del piloto "+(i+1)+" (Recuerde: Los valores van de 1 a 5)");   reflejos= mundial.nextDouble();   System.out.println("");
                            System.out.print("Escoja la agresividad del piloto "+(i+1)+" (Recuerde: Los valores van de 1 a 5)");    agresividad=mundial.nextDouble();   System.out.println("");
                            System.out.print("Escoja la paciencia del piloto "+(i+1)+" (Recuerde: Los valores van de 1 a 5)");  paciencia=mundial.nextDouble();     System.out.println("");
                            System.out.print("Escoja la valentia del piloto "+(i+1)+" (Recuerde: Los valores van de 1 a 5)");   valentia=mundial.nextDouble();      System.out.println("");
                            f1.darAlta("/datosPiloto.dat", new Piloto(nombre,apellido,edad,altura,peso,reflejos,agresividad,paciencia,valentia));
                        }
                        for ( int i=0; i<numpilce; i++){
                            System.out.print("Escoja el nombre del piloto "+(i+1)+" :"); nombre=mundial.next();  System.out.println("");
                            System.out.print("Escoja el apellido del piloto "+(i+1)+" :");   apellido=mundial.next();    System.out.println("");
                            System.out.print("Escoja la edad del piloto "+(i+1)+" :");   edad=mundial.nextInt();     System.out.println("");
                            System.out.print("Escoja el dueno de la escuderia a la que pertenece el piloto "+ (i+1)+": ");     dueno=mundial.next();    System.out.println("");
                            System.out.print("Escoja el nombre de la escuderia a la que pertenece el piloto "+ (i+1)+": ");     nombreescuderia=mundial.next();   System.out.println("");
                            System.out.print("Escoja la nacionalidad de la escuderia a la que pertenece el piloto "+ (i+1)+": ");     pais=mundial.next();   System.out.println("");
                            System.out.print("Escoja la fecha de fundacion de la escuderia a la que pertenece el piloto "+ (i+1)+": ");     fundacion=mundial.nextInt();   System.out.println("");
                            System.out.print("Escoja la cantidad de puntos del mundial que posee la escuderia del piloto "+ (i+1)+": ");     pmun=mundial.nextInt();     System.out.println("");
                            System.out.print("Escoja el presupuesto de la escuderia a la que pertence el piloto "+ (i+1)+": ");     presupuesto=mundial.nextDouble();       System.out.println("");
                            System.out.print("Cuantos directivos tiene la escuderia?:");    numdirectivos=mundial.nextInt();    System.out.println("");
                            for (int u=0; u< numdirectivos; u++){
                                System.out.print("Nombre del directivo "+(u+1)+" :");   nomdirectivos=mundial.next();   System.out.println("");
                                directivos.add(nomdirectivos);
                            }
                            System.out.print("Escoja la altura del piloto "+(i+1)+" :"); altura=mundial.nextDouble();    System.out.println("");
                            System.out.print("Escoja el peso del piloto "+(i+1)+" :");   peso=mundial.nextDouble();      System.out.println("");
                            System.out.print("Escoja los reflejos del piloto "+(i+1)+" (Recuerde: Los valores van de 1 a 5)");   reflejos= mundial.nextDouble();   System.out.println("");
                            System.out.print("Escoja la agresividad del piloto "+(i+1)+" (Recuerde: Los valores van de 1 a 5)");    agresividad=mundial.nextDouble();   System.out.println("");
                            System.out.print("Escoja la paciencia del piloto "+(i+1)+" (Recuerde: Los valores van de 1 a 5)");  paciencia=mundial.nextDouble();     System.out.println("");
                            System.out.print("Escoja la valentia del piloto "+(i+1)+" (Recuerde: Los valores van de 1 a 5)");   valentia=mundial.nextDouble();      System.out.println("");
                            
                            for (int j=0; j< escuderias.size(); j++){
                                if (nombreescuderia.equals(escuderias.get(j).getNombre())){
                                    escuderias.get(j).ficharPiloto("/datosPiloto.dat", nombre, apellido);
                                    this.actualizarDatos();
                                    comprobacion=true;
                                    j=escuderias.size();
                                }
                            }
                            if (!comprobacion){
                                f1.darAlta("/datosEscuderia.dat", new Escuderia(dueno,nombreescuderia,pais,fundacion,pmun,presupuesto,directivos));
                                f1.darAlta("/datosPiloto.dat", new Piloto(nombre,apellido,edad,new Escuderia(dueno,nombreescuderia,pais,fundacion,pmun,presupuesto,directivos),altura,peso,reflejos,agresividad,paciencia,valentia));
                                this.actualizarDatos();
                            }
                            
                            }

                            System.out.print("Los datos ya se han cargado.Desea hacer alguna modificacion? S/N"); respuesta=mundial.next(); System.out.println("");
                            while (respuesta.equals("s") | respuesta.equals("S")){
                                System.out.println("Que desea cambiar? E/P/C"); respuesta=mundial.next();  System.out.println("");
                                if (respuesta.equals("e") | respuesta.equals("E")){
                                    System.out.println("Ha elegido hacer cambios en Escuderia.Que desea hacer? 1.-Dar de Alta/ 2.-Dar de Baja/ 3.-Modificar datos");    opcionMun= mundial.nextInt();    System.out.println("");
                                    if(opcionMun<=3 & opcionMun>=1){
                                    switch (opcionMun){
                                        case 1:     System.out.println("Cuantas ecuderias va a dar de alta?");    numescu= mundial.nextInt();
                                                    for (int i=0; i<numescu; i++){
                                                        System.out.print("Escoja el dueno de la escuderia "+ (i+1)+": ");     dueno=mundial.next();    System.out.println("");
                                                        System.out.print("Escoja el nombre de la escuderia "+(i+1)+": ");     nombre=mundial.next();   System.out.println("");
                                                        System.out.print("Escoja la nacionalidad de la escuderia "+ (i+1)+": ");     pais=mundial.next();   System.out.println("");
                                                        System.out.print("Escoja la fecha de fundacion de la escuderia "+ (i+1)+": ");     fundacion=mundial.nextInt();   System.out.println("");
                                                        System.out.print("Escoja la cantidad de puntos del mundial que posee la escuderia "+ (i+1)+": ");     pmun=mundial.nextInt();     System.out.println("");
                                                        System.out.print("Escoja el presupuesto de la escuderia"+ (i+1)+": ");     presupuesto=mundial.nextDouble();       System.out.println("");
                                                        System.out.print("Cuantos directivos tiene la escuderia?:");    numdirectivos=mundial.nextInt();    System.out.println("");
                                                    for (int u=0; u< numdirectivos; u++){
                                                        System.out.print("Nombre del directivo "+(u+1)+" :");   nomdirectivos=mundial.next();   System.out.println("");
                                                        directivos.add(nomdirectivos);
                                                    }
                                                    f1.darAlta("/datosEscuderia.dat", new Escuderia(dueno,nombre,pais,fundacion,pmun,presupuesto,directivos));
                                                    this.actualizarDatos();
                                                    }
                                                    break;
                                        case 2:     System.out.print("Introduzca el nombre de la escuderia que desea borrar: "); nombre=mundial.next();    System.out.println("");
                                                    f1.darBaja("/datosEscuderia.dat", nombre);
                                                    this.actualizarDatos();
                                                    break;
                                        case 3:     System.out.print("Introduzca el nombre de la escuderia que desea modificar: "); nombre=mundial.next();    System.out.println(""); 
                                                    f1.modificar("/datosEscuderia.dat", nombre);
                                                    this.actualizarDatos();
                                                    break;
                                    }            
                                    }
                                }
                                if (respuesta.equals("p") | respuesta.equals("P")){
                                    System.out.print("Ha elegido hacer cambios en Piloto.Que desea hacer? 1.-Dar de Alta/ 2.-Dar de Baja/ 3.-Modificar datos");    opcionMun=mundial.nextInt();    System.out.println("");
                                    while (opcionMun==1 || opcionMun==2 || opcionMun==3){
                                        switch (opcionMun){
                                            case 1:     System.out.println("Hay dos tipos de pilotos. Escoja el tipo de piloto que va a dar de alta. 1.-Sin escuderia/ 2.- Con escuderia"); campo=mundial.nextInt();    System.out.println("");
                                                        if (campo==1){
                                                        System.out.print("Escoja el nombre del piloto: "); nombre=mundial.next();  System.out.println("");
                                                        System.out.print("Escoja el apellido del piloto: ");   apellido=mundial.next();    System.out.println("");
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
                                                        else if (campo==2){
                                                            System.out.print("Escoja el nombre del piloto:"); nombre=mundial.next();  System.out.println("");
                                                            System.out.print("Escoja el apellido del piloto:");   apellido=mundial.next();    System.out.println("");
                                                            System.out.print("Escoja la edad del piloto:");   edad=mundial.nextInt();     System.out.println("");
                                                            System.out.print("Escoja el dueno de la escuderia a la que pertenece el piloto: ");     dueno=mundial.next();    System.out.println("");
                                                            System.out.print("Escoja el nombre de la escuderia a la que pertenece el piloto: ");     nombreescuderia=mundial.next();   System.out.println("");
                                                            System.out.print("Escoja la nacionalidad de la escuderia a la que pertenece el piloto: ");     pais=mundial.next();   System.out.println("");
                                                            System.out.print("Escoja la fecha de fundacion de la escuderia a la que pertenece el piloto: ");     fundacion=mundial.nextInt();   System.out.println("");
                                                            System.out.print("Escoja la cantidad de puntos del mundial que posee la escuderia del piloto: ");     pmun=mundial.nextInt();     System.out.println("");
                                                            System.out.print("Escoja el presupuesto de la escuderia a la que pertence el piloto: ");     presupuesto=mundial.nextDouble();       System.out.println("");
                                                            System.out.print("Cuantos directivos tiene la escuderia?: ");    numdirectivos=mundial.nextInt();    System.out.println("");
                                                            for (int u=0; u< numdirectivos; u++){
                                                                System.out.print("Nombre del directivo "+u+" :");   nomdirectivos=mundial.next();   System.out.println("");
                                                                directivos.add(nomdirectivos);
                                                            }
                                                            System.out.print("Escoja la altura del piloto: "); altura=mundial.nextDouble();    System.out.println("");
                                                            System.out.print("Escoja el peso del piloto: ");   peso=mundial.nextDouble();      System.out.println("");
                                                            System.out.print("Escoja los reflejos del piloto  (Recuerde: Los valores van de 1 a 5) ");   reflejos= mundial.nextDouble();   System.out.println("");
                                                            System.out.print("Escoja la agresividad del piloto  (Recuerde: Los valores van de 1 a 5) ");    agresividad=mundial.nextDouble();   System.out.println("");
                                                            System.out.print("Escoja la paciencia del piloto  (Recuerde: Los valores van de 1 a 5) ");  paciencia=mundial.nextDouble();     System.out.println("");
                                                            System.out.print("Escoja la valentia del piloto  (Recuerde: Los valores van de 1 a 5) ");   valentia=mundial.nextDouble();      System.out.println("");



                                                            for (int i=0; i< escuderias.size(); i++){
                                                                if (nombreescuderia.equals(escuderias.get(i).getNombre())){
                                                                    escuderias.get(i).ficharPiloto("/datosPiloto.dat", nombre, apellido);
                                                                    this.actualizarDatos();
                                                                    comprobacion=true;
                                                                    i=escuderias.size();
                                                                }
                                                            }
                                                            if (!comprobacion){
                                                                f1.darAlta("/datosEscuderia.dat", new Escuderia(dueno,nombreescuderia,pais,fundacion,pmun,presupuesto,directivos));
                                                                f1.darAlta("/datosPiloto.dat", new Piloto(nombre,apellido,edad,new Escuderia(dueno,nombreescuderia,pais,fundacion,pmun,presupuesto,directivos),altura,peso,reflejos,agresividad,paciencia,valentia));
                                                                this.actualizarDatos();
                                                            }
                                                        }
                                                        break;
                                            case 2: System.out.print("Introduzca el nombre del piloto: ");   nombre=mundial.next();   System.out.println("");
                                                    System.out.print("Introduzca el apellido del piloto: ");    apellido=mundial.next();  System.out.println("");
                                                    f1.darBaja("/datosPiloto.dat",nombre,apellido);
                                                    this.actualizarDatos();
                                                    break;
                                            case 3: System.out.print("Introduzca el nombre del piloto: ");   nombre=mundial.next();   System.out.println("");
                                                    System.out.print("Introduzca el apellido del piloto: ");    apellido=mundial.next();  System.out.println("");
                                                    f1.modificar("/datosPiloto.dat",nombre,apellido);
                                                    this.actualizarDatos();
                                                    break;
                                    }
                                }
                                }
                                if (respuesta.equals("c") | respuesta.equals("C")){
                                    System.out.println("Ha elegido hacer cambios en Circuito.Que desea hacer? 1.-Dar de Alta/ 2.-Dar de Baja/ 3.-Modificar datos");    opcionMun= mundial.nextInt();    System.out.println("");
                                    while (opcionMun<=3 & opcionMun>=1){
                                    switch (opcionMun){
                                        case 1:     
                                                    System.out.print("Escoja el nombre del circuito: ");     nombre=mundial.next();    System.out.println("");
                                                    System.out.print("Escoja el patrocinador del circuito: ");     patro=mundial.next();   System.out.println("");
                                                    System.out.print("Escoja el nº de rectas del circuito: ");     rectas=mundial.nextInt();   System.out.println("");
                                                    System.out.print("Escoja el nº de curvas del circuito: ");     curvas=mundial.nextInt();   System.out.println("");
                                                    System.out.print("Escoja el precio del circuito: ");     precio=mundial.nextDouble();     System.out.println("");
                                                    System.out.print("Escoja el aforo del circuito: ");     aforo=mundial.nextInt();       System.out.println("");

                                                    f1.darAlta("/datosCircuito.dat", new Circuito (nombre,patro,rectas,curvas,precio,aforo));
                                                    this.actualizarDatos();
                                                    break;
                                        case 2:     System.out.print("Introduzca el nombre del circuito que desea borrar: "); nombre=mundial.next();    System.out.println("");
                                                    f1.darBaja("/datosCircuito.dat", nombre);
                                                    this.actualizarDatos();
                                                    break;
                                        case 3:     System.out.print("Introduzca el nombre del circuito que desea modificar: "); nombre=mundial.next();    System.out.println(""); 
                                                    f1.modificar("/datosCircuito.dat", nombre);
                                                    this.actualizarDatos();
                                                    break;
                                    }            
                                    }
                                }
                                
                                System.out.print("Los datos ya se han cargado.Desea hacer alguna modificacion? S/N "); respuesta=mundial.next(); System.out.println("");
                                
                            }
                            menuavanzar=true;
                            break;    

                case 2: //if (menuavanzar==true){
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
                            

                            System.out.print("Tambien le damos la opcion de inciar un entrenamiento. Para ello debe de coger un piloto, un coche y un circuito.Desea iniciar el entrenamiento?: ");   respuesta=mundial.next();   System.out.println("");
                            while (respuesta.equals("s") | respuesta.equals("S")){
                                System.out.print("Que piloto va iniciar el entrenamiento?: ");
                                System.out.println("Introduzca el nombre: ");   nombre=mundial.next();  System.out.println("");
                                System.out.println("Introduzca el apellido: "); apellido=mundial.next();   System.out.println("");
                                System.out.print("Que coche se va a utilizar?: ");  nombrecoche=mundial.next(); System.out.println("");
                                System.out.println("En que circuito se va a realizar el entrenamiento?: "); nombrecircuito=mundial.next();
                                for (int i=0; i< pilotos.size(); i++){
                                    if ( nombre.equals(pilotos.get(i).getNombre()) && apellido.equals(pilotos.get(i).getApellido())){
                                        for (int j = 0; j < escuderias.size(); j++) {
                                            if (nombrecoche.equals(coches.get(j).getModelo())){
                                                for (int k = 0; k < circuitos.size(); k++) {
                                                    if (nombrecircuito.equals(circuitos.get(k).getNombre())){
                                                        escuderias.get(j).iniciarEntrenamiento(pilotos.get(i), coches.get(j), circuitos.get(k));
                                                    }
                                                    else{
                                                        System.out.println("No existe ese circuito.");
                                                    }
                                                }
                                            }
                                            else{
                                                System.out.println("No existe ese coche.");
                                            }

                                        }
                                    }
                                    else {
                                        System.out.println("No existe ese piloto.");
                                    }
                                }  
                                System.out.print("Desea que entrene otro piloto? S/N "); respuesta=mundial.next();   System.out.println(""); 
                            }
                        //}
                        //else{
                        //    System.out.println("Primero debe de insertar datos.");
                        //}
                        menuavanzar2=true;
                        break;
                case 3: //if (menuavanzar==true && menuavanzar2==true){
                            System.out.println("El mundial va a comenzar:");
                            f1.darSalida();
                        //}
                        //else{
                        //    System.out.println("Primero debe de insertar datos, y despues realizar las operaciones internas( Iniciar entrenamiento no tiene que ejecutarse obligatoriamente )");
                        //}
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