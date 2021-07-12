/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.model;

import ec.edu.espol.util.Util;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Felipe
 */
public class Auto extends Vehiculo {
    private String vidrios;
    private String transmision;
   
  
    

    public Auto(int id, String placa, String marca, String modelo, 
            String tipoMotor, int año, double recorrido, String color, 
            String tipoCombustible, double precio, String vidrios, 
            String transmision) {
        
        super(id,placa,marca,modelo,tipoMotor,año,recorrido,color,
                tipoCombustible,precio);
        
        this.vidrios = vidrios;
        this.transmision = transmision;
        
        
    }

    public String getVidrios() {
        return vidrios;
    }

    public void setVidrios(String vidrios) {
        this.vidrios = vidrios;
    }

    public String getTransmision() {
        return transmision;
    }

    public void setTransmision(String transmision) {
        this.transmision = transmision;
    }
    
    @Override
    public String toString() {
        return "Vehiculo{" + "placa=" + placa + ", marca=" + marca + ", modelo="
                + modelo + ", tipoMotor=" + tipoMotor + ", anio=" + anio + 
                ", recorrido=" + recorrido + ", color=" + color + 
                ", tipoCombustible=" + tipoCombustible + ", precio=" + precio 
                + ", vidrios=" + vidrios + ", +transmision=" + transmision + '}';
    }
    

    

    
    public void saveFile(String nomfile){
        
        try(PrintWriter pw = new PrintWriter(new FileOutputStream(
                new File(nomfile),true))){
            pw.println(this.id+"|"+this.placa+"|"+this.marca+"|"+this.modelo+
                    "|"+this.tipoMotor+"|"+this.anio+"|"+this.recorrido+"|"
                    +this.color+"|"+this.tipoCombustible+"|"+this.precio+"|"
                    +this.vidrios+"|"+this.transmision);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public static void nextAuto(Scanner sc, String nombreArchivo, int id){
        String tipo="Auto";
        System.out.println("Ingrese su placa");
        String p = sc.nextLine();
        System.out.println("Ingrese su marca");
        String ma = sc.nextLine();
        System.out.println("Ingrese su modelo");
        String mo = sc.nextLine();
        System.out.println("Ingrese su tipo de motor");
        String tm = sc.nextLine();
        System.out.println("Ingrese el año");
        int an = Util.pedirIntPositivo();
        System.out.println("Ingrese el recorrido");
        double rec = Util.pedirDoublePositivo();
        System.out.println("Ingrese el color");
        String c = sc.nextLine();
        System.out.println("Ingrese el tipo de combustible");
        String com = sc.nextLine();
        System.out.println("Ingrese el precio");
        double pr = Util.pedirDoublePositivo();
        System.out.println("Ingrese los vidrios");
        String vi = sc.nextLine();
        System.out.println("Ingrese la transmision");
        String tr = sc.nextLine();
        
        
        Auto a = new Auto(id,p,ma,mo,tm,an,rec,c,com,pr,vi,tr);
        
        ArrayList<Vehiculo> vehiculos = Vehiculo.readFile(nombreArchivo);
        
        
        int size = vehiculos.size();
        
        if(size!=0){
            if(vehiculos.contains(a)){
                System.out.println("El vehiculo ya existe");
            }else{
                a.saveFile(nombreArchivo);
            }
            
        }else{
            a.saveFile(nombreArchivo);
        }

    }

    
    
    
    
    
    
}
