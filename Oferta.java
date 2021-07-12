/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Felipe
 */
public class Oferta {
    private String correo;
    private double precioOfertado;
    private String placa;

    public Oferta(String placa ,String correo,double precioOfertado) {
        this.correo = correo;
        this.precioOfertado = precioOfertado;
        this.placa= placa;
    }

    public String getCorreo() {
        return correo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public double getPrecioOfertado() {
        return precioOfertado;
    }

    public void setPrecioOfertado(double precioOfertado) {
        this.precioOfertado = precioOfertado;
    }
    
      public static void crearArchivoOferta(){
        try{
            File file = new File("oferta.txt");
            file.createNewFile();
        }catch(Exception e){
            e.getMessage();
        }
    }
     public static void registrarOferta(String archivo,String correo, String placa, double precio){
        try(FileWriter fw = new FileWriter(archivo,true);
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter out = new PrintWriter(bw)){
            out.println(placa+";"+correo+";"+precio);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }}
      public static ArrayList<Oferta> readFileOferta(String nomfile){
        ArrayList<Oferta> ofertas = new ArrayList<>();
        try(Scanner sc = new Scanner(new File(nomfile))){
            while (sc.hasNextLine())
            {
                String linea = sc.nextLine();
                String[] tokens = linea.split(";");
                Oferta o = new Oferta(tokens[0],tokens[1],Double.parseDouble(tokens[2]));
                ofertas.add(o);
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return ofertas;
    }
      
         public static ArrayList<Oferta> searchByPlaca(String placa){
        ArrayList<Oferta> ofertas = Oferta.readFileOferta("oferta.txt");
        ArrayList<Oferta> ofertas_elegidas = new ArrayList<Oferta>();
             for(Oferta o: ofertas){
            if(o.placa.equals(placa))
                ofertas_elegidas.add(o);
                
               
        }
        return ofertas_elegidas;
    }
   @Override
    public String toString() {
        return "correo: "+this.correo+" precio ofertado: "+this.precioOfertado+" placa:"+this.placa;
              
    }
    
         
         
         
     
     
}


     

