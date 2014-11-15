/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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
   private Scanner opcion;
   
   

   
   public void darAlta(Piloto a){  
   }
   public void darAlta(Escuderia a){
   }
    public void darAlta(Circuito a){
        
    }
   public void cargarDatosCircuito() throws IOException{
        FileReader lectorArchivo;
        JFileChooser browser;
        browser= new JFileChooser();
        int resultadoBrowser;
        resultadoBrowser= browser.showOpenDialog(null);
        if( resultadoBrowser != JFileChooser.APPROVE_OPTION){
            JOptionPane.showMessageDialog(null, "No se ha seleccionado nada");
            return;
        }
           try{
               lectorArchivo=new FileReader(browser.getSelectedFile());
           }catch(FileNotFoundException err){
               JOptionPane.showMessageDialog(null, "Archivo no encontrado" + err.getMessage());
               return;
           }
           BufferedReader textoArchivo;
           textoArchivo= new BufferedReader(lectorArchivo);
           int casilla;
           casilla=0;
           String lineaTexto;
           while (casilla  < dcir.length){

               try{
                   lineaTexto= textoArchivo.readLine();
               }catch(IOException err){
                   JOptionPane.showMessageDialog(null, err.getMessage());
                return;
               }

               if (lineaTexto==null){
                   break;
               }
               String [] valores;
               valores = lineaTexto.split(";");
               String [] recurv;
               recurv = lineaTexto.split("!");
               int precio= Integer.parseInt(valores[2]);
               double recta0= Double.parseDouble(recurv[1]);
               double recta1= Double.parseDouble(recurv[2]);
               double recta2= Double.parseDouble(recurv[3]);
               double recta3= Double.parseDouble(recurv[4]);
               double curva0= Double.parseDouble(recurv[5]);
               double curva1= Double.parseDouble(recurv[6]);
               double curva2= Double.parseDouble(recurv[7]);
               double curva3= Double.parseDouble(recurv[8]);


               dcir[casilla]= new DatosCircuito ();
               dcir[casilla].setNombre(valores[0]);
               dcir[casilla].setPatrocinador(valores[1]);
               dcir[casilla].setPrecio(precio);
               dcir[casilla].setRecta0(recta0);
               dcir[casilla].setRecta1(recta1);
               dcir[casilla].setRecta2(recta2);
               dcir[casilla].setRecta3(recta3);
               dcir[casilla].setCurva0(curva0);
               dcir[casilla].setCurva1(curva1);
               dcir[casilla].setCurva2(curva2);
               dcir[casilla].setCurva3(curva3);

               casilla++;

           }

           try{
                   lineaTexto= textoArchivo.readLine();
               }catch(IOException err){
                   JOptionPane.showMessageDialog(null, err.getMessage());
                return;
               }
           if (lineaTexto !=null){
               JOptionPane.showMessageDialog(null, "No hay espacio para cargar todos los circuitos");
           }

           String mostrar;
           mostrar= "";

           casilla=0;
           while(casilla < dcir.length){
               if (dcir[casilla] !=null){

               mostrar= mostrar +" Circuito["+casilla+"]- "+" Nombre: "+ dcir[casilla].getNombre()+"\n"
                                +" Patrocinador: "+dcir[casilla].getPatrocinador()+"\n"
                                +" Precio: "+dcir[casilla].getPrecio()+"\n"
                                +" Rectas: "+dcir[casilla].getRecta0()+","+dcir[casilla].getRecta1()+","+dcir[casilla].getRecta2()+","+dcir[casilla].getRecta3()+"\n"
                                +" Curvas: "+dcir[casilla].getCurva0()+","+dcir[casilla].getCurva1()+","+dcir[casilla].getCurva2()+","+dcir[casilla].getCurva3()+"\n\n";
               } 
               casilla++;
           }
           JOptionPane.showMessageDialog(null, mostrar);
           ArrayList<DatosCircuito> datcir =new ArrayList <DatosCircuito> (Arrays.asList(dcir));
   }   
    
       
       
    
   
   /*public void darBaja(Piloto a){  
   }
   public void darBaja(Escuderia a){
   }
   public void darBaja(Circuito a){
   }
   public void modificar(Piloto a){  
   }
   public void modificar(Escuderia a){
   }*/
   
    public void modificar(Circuito a)throws IOException{
        String respuesta;
        System.out.println ("Desea modificar algun rasgo de algun  circuito? Y/N"); // Preguntamos 
        
        respuesta = opcion.next(); 
            while (respuesta.equals("s") || respuesta.equals("S")){
                Double valor;
                int tramo;
                Double canon;
                String patrocinador;
                String nomcir;
                int circuito;
                String campo;
                System.out.println ("Que circuito desea modificar? 0/1/2/3/4");
                circuito=opcion.nextInt();
                if (dcir[circuito] ==null){break;}
                while (circuito==0 | circuito==1 | circuito==2 | circuito==3 |circuito==4){
                    int i=circuito;
                    System.out.println("Actualmente el circuito "+i+" tiene estas caracteristicas:");
                    System.out.println("Circuito["+i+"]");
                    System.out.println("Nombre: "+dcir[i].getNombre()+"\n"+
                                      "Patrocinador: "+dcir[i].getPatrocinador()+"\n"+
                                      "Precio: "+dcir[i].getPrecio()+"\n"+
                                      "Rectas: "+dcir[i].getRecta0()+","+dcir[i].getRecta1()+","+dcir[i].getRecta2()+","+dcir[i].getRecta3()+"\n"+
                                      "Curvas: "+dcir[i].getCurva0()+","+dcir[i].getCurva1()+","+dcir[i].getCurva2()+","+dcir[i].getCurva3()+"\n\n");

                    System.out.println ("Que campo desea modificar? N/P/€/R/C");
                    campo=opcion.next();
                    while (campo.equals("N")){
                        System.out.println("Como quieres que se llame el circuito "+i+"?");
                        nomcir=opcion.next();
                        dcir[i].setNombre(nomcir);
                    }
                    while (campo.equals("P")){
                        System.out.println("Cual es el nuevo patrocinador del circuito "+i+"?");
                        patrocinador=opcion.next();
                        dcir[i].setPatrocinador(patrocinador);
                    }
                    while (campo.equals("€")){
                        System.out.println("Cual es el nuevo canon del circuito "+i+"?");
                        canon=opcion.nextDouble();
                        dcir[i].setPrecio(canon);
                    }
                    while (campo.equals("R")){
                        System.out.println("Que recta desea modificar del circuito "+i+"? 0/1/2/3");
                        tramo=opcion.nextInt();
                        while (tramo==0){
                            System.out.println("¿Que valor quiere que tenga la recta "+tramo+"?");
                            valor=opcion.nextDouble();
                            dcir[i].setRecta0(valor);
                        }   
                        while (tramo==1){
                            System.out.println("¿Que valor quiere que tenga la recta "+tramo+"?");
                            valor=opcion.nextDouble();
                            dcir[i].setRecta1(valor);
                        }   
                        while (tramo==2){
                            System.out.println("¿Que valor quiere que tenga la recta "+tramo+"?");
                            valor=opcion.nextDouble();
                            dcir[i].setRecta2(valor);
                        }   
                        while (tramo==3){
                            System.out.println("¿Que valor quiere que tenga la recta "+tramo+"?");
                            valor=opcion.nextDouble();
                            dcir[i].setRecta3(valor);
                        }   
                    }
                    while (campo.equals("C")){
                        System.out.println("Que curva desea modificar del circuito "+i+"? 0/1/2/3");
                        tramo=opcion.nextInt();
                        while (tramo==0){
                            System.out.println("¿Que valor quiere que tenga la curva "+tramo+"?");
                            valor=opcion.nextDouble();
                            dcir[i].setCurva0(valor);
                        }   
                        while (tramo==1){
                            System.out.println("¿Que valor quiere que tenga la curva "+tramo+"?");
                            valor=opcion.nextDouble();
                            dcir[i].setCurva1(valor);
                        }   
                        while (tramo==2){
                            System.out.println("¿Que valor quiere que tenga la curva "+tramo+"?");
                            valor=opcion.nextDouble();
                            dcir[i].setCurva2(valor);
                        }   
                        while (tramo==3){
                            System.out.println("¿Que valor quiere que tenga la curva "+tramo+"?");
                            valor=opcion.nextDouble();
                            dcir[i].setCurva3(valor);
                        }    
                    }
                }

            }
        }

    
}
