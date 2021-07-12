/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.pruebapoo;

import ec.edu.espol.util.GFG;
import ec.edu.espol.model.Comprador;
import ec.edu.espol.model.Camioneta;
import ec.edu.espol.model.Motocicleta;
import ec.edu.espol.model.Vendedor;
import ec.edu.espol.model.Vehiculo;
import ec.edu.espol.model.Auto;
import ec.edu.espol.model.Oferta;
import ec.edu.espol.util.Util;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author Felipe
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        
        
        
        
        int opcion = 0;
        
        
        do{
            System.out.println("---MENU---");
            System.out.println("1. Vendedor");
            System.out.println("2. Comprador");
            System.out.println("3. Salir");
        
            System.out.println("Por favor digite la opcion: ");
            opcion = Util.pedirIntEnIntervalo(1, 3);
            
            switch(opcion){
                case 1:
                    int opcion1=0;
                    do{ //
                    System.out.println("---VENDEDOR---");
                    System.out.println("1. Registrar un nuevo vendedor");
                    System.out.println("2. Ingresar un nuevo vehiculo");
                    System.out.println("3. Aceptar oferta");
                    System.out.println("4. Regresar");
                
                    System.out.println("Por favor digite la opcion: ");
                    opcion1 = Util.pedirIntEnIntervalo(1, 4);
                    
                
                    switch(opcion1){
                        case 1:
                            Vendedor.crearArchivoVendedor();
                            Vendedor.nextVendedor(sc, "vendedores.txt");
                            
                            break;
                        case 2:
                            Util.comprobarUsuarioyClaveVend("vendedores.txt");
                            Vehiculo.crearArchivoVehiculo();
                            
                            
                            
                            ArrayList<Vendedor> vendedores = Vendedor.readFile("vendedores.txt");
                            for (Vendedor v: vendedores){
                                
                                   
                                    System.out.println("Ingrese tipo de vehiculo");
                                    String vehiculo = sc.nextLine().toLowerCase();
                                    switch(vehiculo){
                                        case "auto":
                                            Auto.nextAuto(sc,"vehiculos.txt",v.getId());
                                            break;
                                        case "camioneta":
                                            Camioneta.nextCamioneta(sc,"vehiculos.txt",v.getId());
                                            break;
                                        case "motocicleta":
                                            Motocicleta.nextMotocicleta(sc,"vehiculos.txt",v.getId());
                                            break;     
                                    
                                }
                                    break;
                            }
                            break;
                        case 3:
                            
                          System.out.println("Ingrese la placa del vehículo: ");
                          String placa= Util.pedirtec();
                          ArrayList<Oferta> ofertas = Oferta.searchByPlaca(placa);
                          ArrayList<String> correos = new ArrayList();
                          System.out.println(ofertas);
                          if(ofertas.size()!=0){
                                        Iterator<Oferta> iter = ofertas.iterator();
                                        ofertas.iterator();
                                        
                                        int tamaño = ofertas.size();
                                         for(int i = 0; i < ofertas.size(); i++) {
                                             do{
                                                 if (i==0) {
                                                     
                                                     System.out.println("Oferta "+(i+1));
                                                     System.out.println(ofertas.get(i));
                                                     System.out.println("1.Siguiente\n2.Aceptar");
                                                     int seleccion = Util.pedirIntEnIntervalo(1, 2);
                                                     if (seleccion == 1)
                                                          i++;
                                                     
                                                     else if (seleccion == 2){
                                                         //String archivo,String correo, String placa, double precio
                                                       correos.add(ofertas.get(i).getCorreo());
                                                       break;
                                                 }
                                                        
                                                 } else if(i>0 && i< tamaño-1){
                                                      System.out.println("Oferta "+(i+1));
                                                     System.out.println(ofertas.get(i));
                                                     System.out.println("1.Siguiente\n2.atras\n3.Aceptar");
                                                     int seleccion = Util.pedirIntEnIntervalo(1, 3);
                                                     switch(seleccion){
                                                         case 1: 
                                                             
                                                             i++;
                                                              System.out.println("Oferta "+(i+1));
                                                     System.out.println(ofertas.get(i));
                                                             break;
                                                         case 2:
                                                             i--;
                                                              System.out.println("Oferta "+(i+1));
                                                     System.out.println(ofertas.get(i));
                                                             break;
                                                         case 3:
                                                              correos.add(ofertas.get(i).getCorreo());
                                                             break;
                                                     }
                                                 }
                                                 else{
                                                     System.out.println("1.Atras\n2.Aceptar") ;
                                                     int seleccion= Util.pedirIntEnIntervalo(1, 2);
                                                     if(seleccion == 1){
                                                         i--;
                                                      System.out.println("Oferta "+(i+1));
                                                     System.out.println(ofertas.get(i));}
                                                     else if(seleccion == 2){
                                                          correos.add(ofertas.get(i).getCorreo());}
                                                         break;
                                                     
                                                 }
                                         
                                             }while(iter.hasNext());
                                         
                                            
                                                   }     
                                    }
                          
                          
                          
                            
                            
                            
                            //correo y clave
                            //ingresar placa de vehiculo
                            //mostrar ofertas una por una (con capacidad de regresar
                            // de ser necesario);
                            //aceptar oferta y eliminar el registro del vehiculo 
                            //ofertado
                            //enviar correo al usuario para confirmar que se acepto
                            //su oferta
                            break;
                        case 4:
                            //
                            break;
                    }
                    }while(opcion1!=4);
                
                    break;
                case 2:
                    //
                    System.out.println("---COMPRADOR---");
                    System.out.println("1. Registrar un nuevo comprador");
                    System.out.println("2. Ofertar por un vehiculo");
                
                    System.out.println("Por favor digite la opcion: ");
                    int opcion2 = Util.pedirIntEnIntervalo(1, 2);
                    
                
                    switch(opcion2){
                        case 1:
                            Comprador.crearArchivoComprador();
                            Comprador.nextComprador(sc, "compradores.txt");
                            break;
                        case 2:
                            StringBuilder s1 = new StringBuilder();
                            Util.comprobarUsuarioyClaveComprador("compradores.txt",s1);
                            String correo = s1.toString();
        
                            int opcion1_comprador=0;
                           
                            do{ 
                            System.out.println("---ESCOJA UN CRITERIO---");
                            System.out.println("1. Tipo de vehículo");
                            System.out.println("2. Recorrido");
                            System.out.println("3. Año");
                            System.out.println("4. Precio");
                            System.out.println("5. Continuar");
                            System.out.println("6. Regresar");
                
                            System.out.println("Por favor digite la opcion: ");
                            opcion1_comprador = Util.pedirIntEnIntervalo(1, 6);
                            ArrayList<Vehiculo> vehiculos = Vehiculo.readFile("vehiculos.txt");        
                            ArrayList<Vehiculo> vehiculos_encontrados = new ArrayList();
                            switch(opcion1_comprador){
                                // Se tiene que identificar el tipo de vehiculo en el archivo (habria que cambiar los metodos de auto,camioneta y moto)
                                case 1:
                                    System.out.println("Ingrese el tipo de vehiculo que busca: ");
                                    System.out.println("1.Auto\n2.Camioneta\n3.Motocicleta");
                                    int opcion_tipo=0;
                                    switch (opcion_tipo){
                                        case 1: 
                                         
                                                for (Vehiculo v: vehiculos){
                                                if (v instanceof Auto){
                                                    Auto au = (Auto)v;
                                                    vehiculos_encontrados.add(au);
                                                            }}
                                                break;
                                        case 2:
                                            for (Vehiculo v: vehiculos){
                                                if (v instanceof Camioneta){
                                                    Camioneta au = (Camioneta)v;
                                                    vehiculos_encontrados.add(au);
                                                            }}
                                            break;
                                        case 3:
                                             for (Vehiculo v: vehiculos){
                                                if (v instanceof Motocicleta){
                                                    Motocicleta au = (Motocicleta)v;
                                                    vehiculos_encontrados.add(au);
                                                            }}
                                             break;
                                        
                                    }
                                    
                           
                                case 2:
                                   
                                System.out.println("Ingrese el primer valor del rango del recorrido: ");
                                double val= Util.pedirDoublePositivo();
                                System.out.println("Ingrese el segundo valor del rango del recorrido: ");
                                double val_2= Util.pedirDoublePositivo();
                            for (int i =0; i>val && i<val_2;i++){
                                vehiculos_encontrados.add(Vehiculo.searchByrecorrido(vehiculos, i));   
                            }
                            break;
                                case 3:
                                    System.out.println("Ingrese el primer valor del rango del año: ");
                                int val1= Util.pedirIntPositivo();
                                System.out.println("Ingrese el segundo valor del rango del año: ");
                                int val2= Util.pedirIntPositivo();
                              
                            for (int i =0; i>val1 && i<val2;i++){
                                vehiculos_encontrados.add(Vehiculo.searchByanio(vehiculos, i));   
                            }
                            break;
                                case 4:
                                    System.out.println("Ingrese el primer valor del rango del Precio");
                                    double val01= Util.pedirDoublePositivo();
                                    System.out.println("Ingrese el segundo valor del rango del Precio");
                                    double val02= Util.pedirDoublePositivo();
                                     for (int i =0; i>val01 && i<val02;i++){
                                vehiculos_encontrados.add(Vehiculo.searchByprecio(vehiculos, i));   
                            }
                                     break;
                                case 5:
                                    if(vehiculos_encontrados.size()==0){
                                        Iterator<Vehiculo> iter = vehiculos.iterator();
                                        vehiculos.iterator();
                                        Oferta.crearArchivoOferta();
                                        int tamaño = vehiculos.size();
                                         for(int i = 0; i < vehiculos.size(); i++) {
                                             do{
                                                 if (i==0) {
                                                     
                                                     System.out.println("Vehiculo "+(i+1));
                                                     System.out.println(vehiculos.get(i));
                                                     System.out.println("1.Siguiente\n2.Ofertar");
                                                     int seleccion = Util.pedirIntEnIntervalo(1, 2);
                                                     if (seleccion == 1)
                                                          i++;
                                                     else if (seleccion == 2){
                                                         //String archivo,String correo, String placa, double precio
                                                         System.out.println("Ingrese el precio: ");
                                                       
                                                         double precio = Util.pedirDoublePositivo();
                                                      
                                                         Oferta.registrarOferta("oferta.txt", correo,vehiculos.get(i).getPlaca() , precio);
                                                 }
                                                         break;
                                                 } else if(i>0 && i< tamaño-1){
                                                      System.out.println("Vehiculo "+(i+1));
                                                     System.out.println(vehiculos.get(i));
                                                     System.out.println("1.Siguiente\n2.atras\n3.Ofertar");
                                                     int seleccion = Util.pedirIntEnIntervalo(1, 3);
                                                     switch(seleccion){
                                                         case 1: 
                                                             
                                                             i++;
                                                              System.out.println("Vehiculo "+(i+1));
                                                     System.out.println(vehiculos.get(i));
                                                             break;
                                                         case 2:
                                                             i--;
                                                              System.out.println("Vehiculo "+(i+1));
                                                     System.out.println(vehiculos.get(i));
                                                             break;
                                                         case 3:
                                                              System.out.println("Ingrese el precio: ");
                                                        
                                                         double precio = Util.pedirDoublePositivo();
                                                         
                                                         Oferta.registrarOferta("oferta.txt", correo,vehiculos.get(i).getPlaca() , precio);
                                                             break;
                                                     }
                                                 }
                                                 else{
                                                     System.out.println("1.Atras\n2.Ofertar") ;
                                                     int seleccion= Util.pedirIntEnIntervalo(1, 2);
                                                     if(seleccion == 1){
                                                         i--;
                                                      System.out.println("Vehiculo "+(i+1));
                                                     System.out.println(vehiculos.get(i));}
                                                     else if(seleccion == 2){
                                                          System.out.println("Ingrese el precio: ");
                                                        
                                                         double precio = Util.pedirDoublePositivo();
                                                   
                                                         Oferta.registrarOferta("oferta.txt", correo,vehiculos.get(i).getPlaca() , precio);}
                                                         break;
                                                     
                                                 }
                                         
                                             }while(iter.hasNext());
                                         
                                            
                                                   }     
                                    }
                                    else{
                                        Iterator<Vehiculo> iter = vehiculos_encontrados.iterator();
                                        
                                        int tamaño = vehiculos_encontrados.size();
                                        for(int i = 0; i < vehiculos_encontrados.size(); i++) {
                                            do{
                                                 if (i==0) {
                                                     System.out.println("Vehiculo"+i+1);
                                                     System.out.println(vehiculos.get(i));
                                                     System.out.println("1.Siguiente\n2.Ofertar");
                                                     int seleccion = Util.pedirIntEnIntervalo(1, 2);
                                                     if (seleccion == 1)
                                                          i++;
                                                     else if(seleccion == 2){
                                                         
                                                         System.out.println("Ingrese el precio: ");
                                                         double precio = Util.pedirDoublePositivo();
                                                        
                                                         Oferta.registrarOferta("oferta.txt", correo,vehiculos.get(i).getPlaca() , precio);
                                                     }
                                                         break;
                                                 } else if(i>0 && i< tamaño-1){
                                                     System.out.println("1.Siguiente\n2.atras\n3.Ofertar");
                                                     int seleccion = Util.pedirIntEnIntervalo(1, 3);
                                                     switch(seleccion){
                                                         case 1: 
                                                             i++;
                                                             break;
                                                         case 2:
                                                             i--;
                                                             break;
                                                         case 3:
                                                         
                                                         System.out.println("Ingrese el precio: ");
                                                         double precio = Util.pedirDoublePositivo();
                                                        
                                                         Oferta.registrarOferta("oferta.txt", correo,vehiculos.get(i).getPlaca() , precio);
                                                             break;
                                                     }
                                                 }
                                                 else{
                                                     System.out.println("1.Atras\n2.Ofertar") ;
                                                     int seleccion= Util.pedirIntEnIntervalo(1, 2);
                                                     if(seleccion == 1)
                                                         i--;
                                                     else if(seleccion ==2){
                                                         
                                                         System.out.println("Ingrese el precio: ");
                                                         double precio = Util.pedirDoublePositivo();
                                                        
                                                         Oferta.registrarOferta("oferta.txt", correo,vehiculos.get(i).getPlaca() , precio);
                                                     }
                                                         break;
                                                     
                                                 }
                                         
                                             }while(iter.hasNext());
                                            
                                           
                                                   }
                                        
                                    }
                                    
                                    break;
                                        
                                 
                            
                            }
                                
                            }while(opcion1_comprador != 6);
                    
                            
                            
                            //
                            //buscar vehiculos por criterios:
                            //tipo
                            //recorrido (rango)
                            //año (rango)
                            //precio (rango)
                            //
                            //se puede ingresar desde ningun criterio hasta todos;
                            //presentar vehiculos uno por uno
                            //realizar oferta -> ingresar precio ofertado
                            //agregar a la lista de ofertas de vehiculo
                            //registrar correo electronico con oferta
                            //
                            break;
                    }
                
                    break;
                case 3:
                    //
                    break;
            
            }
        }while(opcion!=3);
    }
    
}
