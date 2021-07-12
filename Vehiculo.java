/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.model;

import ec.edu.espol.model.Auto;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

/**
 *
 * @author Felipe
 */
public class Vehiculo {


    protected int id;
    protected String placa;
    protected String marca;
    protected String modelo;
    protected String tipoMotor;
    protected int anio;
    protected double recorrido;
    protected String color;
    protected String tipoCombustible;
    protected double precio;
   

    public Vehiculo(int id, String placa, String marca, String modelo, 
            String tipoMotor, int anio, double recorrido, String color, 
            String tipoCombustible, double precio) {
        this.id = id;
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.tipoMotor = tipoMotor;
        this.anio = anio;
        this.recorrido = recorrido;
        this.color = color;
        this.tipoCombustible = tipoCombustible;
        this.precio = precio;
        
    }
    
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }    

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getTipoMotor() {
        return tipoMotor;
    }

    public void setTipoMotor(String tipoMotor) {
        this.tipoMotor = tipoMotor;
    }

    public int getAño() {
        return anio;
    }

    public void setAño(int año) {
        this.anio = año;
    }

    public double getRecorrido() {
        return recorrido;
    }

    public void setRecorrido(double recorrido) {
        this.recorrido = recorrido;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTipoCombustible() {
        return tipoCombustible;
    }

    public void setTipoCombustible(String tipoCombustible) {
        this.tipoCombustible = tipoCombustible;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    

    @Override
    public String toString() {
        return "Vehiculo{" + "placa=" + placa + ", marca=" + marca + ", modelo="
                + modelo + ", tipoMotor=" + tipoMotor + ", anio=" + anio + 
                ", recorrido=" + recorrido + ", color=" + color + 
                ", tipoCombustible=" + tipoCombustible + ", precio=" + precio 
                + '}';
    }
    
    public static void crearArchivoVehiculo(){
        try{
            File file = new File("vehiculos.txt");
            file.createNewFile();
        }catch(Exception e){
            e.getMessage();
        }
    }    

    public static ArrayList<Vehiculo> readFile(String nomfile){
        ArrayList<Vehiculo> vehiculos = new ArrayList<>();
        try(Scanner sc = new Scanner(new File(nomfile))){
            while (sc.hasNextLine())
            {
                String linea = sc.nextLine();
                String[] tokens = linea.split("\\|");
                
                if (tokens.length==12){
                    Auto a = new Auto(Integer.parseInt(tokens[0]),tokens[1],
                        tokens[2],tokens[3],tokens[4],
                        Integer.parseInt(tokens[5]),
                        Double.parseDouble(tokens[6]),tokens[7],tokens[8],
                        Double.parseDouble(tokens[9]),tokens[10],tokens[11]);
                    
                    vehiculos.add(a);
                }
                
                if (tokens.length==13){
                    Camioneta ca = new Camioneta(Integer.parseInt(tokens[0]),tokens[1],
                        tokens[2],tokens[3],tokens[4],
                        Integer.parseInt(tokens[5]),
                        Double.parseDouble(tokens[6]),tokens[7],tokens[8],
                        Double.parseDouble(tokens[9]),tokens[10],tokens[11],tokens[12]);
                    
                    vehiculos.add(ca);
                }
                
                if (tokens.length==10){
                    Motocicleta mot = new Motocicleta(Integer.parseInt(tokens[0]),tokens[1],
                        tokens[2],tokens[3],tokens[4],
                        Integer.parseInt(tokens[5]),
                        Double.parseDouble(tokens[6]),tokens[7],tokens[8],
                        Double.parseDouble(tokens[9]));
                    
                    vehiculos.add(mot);
                }
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return vehiculos;
    }
    public static Vehiculo searchByanio(ArrayList<Vehiculo> vehiculos,int anio ){
        for(Vehiculo v: vehiculos){
            if(v.anio == anio)
                return v;
            
        }
        return null;
    }
    public static Vehiculo searchByrecorrido(ArrayList<Vehiculo> vehiculos,double recorrido){
        for(Vehiculo v: vehiculos){
            if(v.recorrido == recorrido)
                return v;
        }
        return null;
    }
       public static Vehiculo searchByprecio(ArrayList<Vehiculo> vehiculos,double precio){
        for(Vehiculo v: vehiculos){
            if(v.precio == precio)
                return v;
        }
        return null;
    }
       
    
    
    
    

    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Vehiculo other = (Vehiculo) obj;
        
        if (!Objects.equals(this.placa, other.placa)) {
            return false;
        }
        
        return true;
    }
    


    
    
    
    
    
    
}
