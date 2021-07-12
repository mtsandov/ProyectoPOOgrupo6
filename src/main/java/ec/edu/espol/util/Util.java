/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Felipe
 */
public class Util {
    private Util(){}
    
   public static String[] lineaConPalabra(String archivo,String palabra){
       try(BufferedReader leer = new BufferedReader(new FileReader(archivo))){
            String linea;
            while ((linea = leer.readLine()) != null){
            String[] terminos = linea.split("\\|");
                for (String termino: terminos){
                    if (termino.equals(palabra)){
                        return terminos;
                        }
                    }
            }
   } catch (Exception e) {
            System.out.println(e.getMessage());
        }
       return null;
    }
     public static int pedirInt(){
        Scanner sc = new Scanner(System.in);
        String cad;
        do {
            cad = sc.nextLine();
            if (cad.matches(""))
                System.out.println("Entrada inválida, intentelo de nuevo.");
            else if (cad.matches("[0-9]*") || cad.matches("-[0-9]*"))
                break;
            else
                System.out.println("Entrada inválida, intentelo de nuevo.");
        } while (true);
    return Integer.parseInt(cad);
    }
     public static int pedirIntPositivo(){
        Scanner sc = new Scanner(System.in);
        String cad;
        do {
            cad = sc.nextLine();
            if (cad.matches(""))
                System.out.println("Entrada inválida, intentelo de nuevo.");
            else if (cad.matches("[0-9]*"))
                break;
            else
                System.out.println("Entrada inválida, intentelo de nuevo.");
        } while (true);
    return Integer.parseInt(cad);
    }
     
     public static double pedirDoublePositivo(){
    Scanner sc = new Scanner(System.in);
    String cad;
        do {
            cad = sc.nextLine();
            if (cad.matches(""))
                System.out.println("Entrada inválida, intentelo de nuevo.");
            else if (cad.matches("[0-9]*.[0-9]*"))
                break;
            else
                System.out.println("Entrada inválida, intentelo de nuevo.");
        } while (true);
    return Double.parseDouble(cad);
    }
     
      public static int pedirIntEnIntervalo(int inicio,int fin){ //Pide un int en un intervalo definido (Bueno para los menús)
        int num;
        do{
            num = pedirIntPositivo();
            if (num >= inicio && num <= fin)
                break;
            else
               System.out.println("Entrada inválida, intentelo de nuevo."); 
        } while(true);
        return num;}
    
    public static String pedirtec(){
        Scanner sc = new Scanner(System.in);
        String tec = sc.nextLine();
        return tec;
    }
    public static int nextID(String nomfile){
        int id = 0;
        
        try(Scanner sc = new Scanner(new File(nomfile))){
            while(sc.hasNextLine()){
                String linea = sc.nextLine();
                String[] tokens = linea.split("\\|");
                id = Integer.parseInt(tokens[0]);
            }
        }catch(Exception e){
            
        }
        return id+1;}
        
      
        public static boolean comprobarenarchivo(String archivo, String palabra){
            try(BufferedReader leer = new BufferedReader(new FileReader(archivo))){
            String linea;
            int prueba = 0;
            while ((linea = leer.readLine()) != null){
            String[] terminos = linea.split("\\|");
            for (String termino: terminos){
                if (termino.equals(palabra))
                    prueba++;
                }
            }
            if (prueba>0)
               return false;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return true;
            
        }
        public static void comprobarRegistro(String a, String[] b, String c, ArrayList<String> cads){
        if (Arrays.asList(b).indexOf(c) == 2 || Arrays.asList(b).indexOf(c) == 4){
            while (true){
                String tec = Util.pedirtec();
                if (Util.comprobarenarchivo(a,tec)){
                    cads.add(tec);
                    break;}
                else
                    System.out.println("Ese nombre de usuario o correo electrónico ya fue registrado, intentelo de nuevo.");
            }
        }
        else{
        String cad = Util.pedirtec();
        cads.add(cad);
        }
        }
        public static void comprobarUsuarioyClaveVend(String a){
        while(true){
            
            System.out.println("Ingrese su correo: ");
            String correo = Util.pedirtec();
            System.out.println("Ingrese clave");
            Scanner sc = new Scanner(System.in);
            String contra = GFG.HashCode(sc.nextLine());
            String[] terminos;
            if(Util.comprobarenarchivo(a, correo))
                System.out.println("Usuario o contraseña incorrectos.\nAsegurese que tiene una cuenta de vendedor creada.");
            else if(!Util.comprobarenarchivo(a, correo)){
                terminos = Util.lineaConPalabra(a, correo);
                if(terminos[4].equals(correo) && terminos[5].equals(contra))
                    break;
                else
                 System.out.println("Usuario o contraseña incorrectos.");
            }
        }
        
    }
        
          public static void comprobarUsuarioyClaveComprador(String a,StringBuilder b){
        while(true){
            
            System.out.println("Ingrese su correo: ");
            String correo = Util.pedirtec();
            System.out.println("Ingrese clave");
            Scanner sc = new Scanner(System.in);
            String contra = GFG.HashCode(sc.nextLine());
            String[] terminos;
            if(Util.comprobarenarchivo(a, correo))
                System.out.println("Usuario o contraseña incorrectos.\nAsegurese que tiene una cuenta de comprador creada.");
            else if(!Util.comprobarenarchivo(a, correo)){
                terminos = Util.lineaConPalabra(a, correo);
                if(terminos[3].equals(correo) && terminos[5].equals(contra)){
                    b.append(correo);
                    break;
                }else{
                 System.out.println("Usuario o contraseña incorrectos.");
                }
            }
        }
        
    }
        
        
        
        
        
        
         public static void comprobarUsuarioyClaveComprador(String a){
        while(true){
            
            System.out.println("Ingrese su correo: ");
            String correo = Util.pedirtec();
            System.out.println("Ingrese clave");
            Scanner sc = new Scanner(System.in);
            String contra = GFG.HashCode(sc.nextLine());
            String[] terminos;
            if(Util.comprobarenarchivo(a, correo))
                System.out.println("Usuario o contraseña incorrectos.\nAsegurese que tiene una cuenta de comprador creada.");
            else if(!Util.comprobarenarchivo(a, correo)){
                terminos = Util.lineaConPalabra(a, correo);
                if(terminos[3].equals(correo) && terminos[5].equals(contra))
                    break;
                else
                 System.out.println("Usuario o contraseña incorrectos.");
            }
        }
        
    }
         
         
        
         
         
    public static void comprobarPlaca(String a, String[] b, String c, ArrayList datos){
        if (Arrays.asList(b).indexOf(c) == 0){
            while (true){
                String cad = Util.pedirtec();
                if (Util.comprobarenarchivo(a,cad)){
                    datos.add(cad);
                    break;}
                else
                    System.out.println("Ese número de matrícula ya esta registrado, intentelo de nuevo.");
            }
        }
        else if (Arrays.asList(b).indexOf(c) == 4){
                int num = Util.pedirIntPositivo();
                datos.add(num);
        }
        else if (Arrays.asList(b).indexOf(c) == 5 || Arrays.asList(b).indexOf(c) == Arrays.asList(b).size()-1){
                double num = Util.pedirDoublePositivo();
                datos.add(num);}
        else{
        String cad = Util.pedirtec();
        datos.add(cad);
        }
    }      
}


