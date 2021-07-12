/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.model;

import ec.edu.espol.util.GFG;
import ec.edu.espol.util.Util;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

/**
 *
 * @author Felipe
 */
public class Vendedor {
    private int id;
    private String nombre;
    private String apellido;
    private String organizacion;
    private String correoElectronico;
    private String clave;

    public Vendedor(String nombre, String apellido, String organizacion, 
            String correoElectronico, String clave) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.organizacion = organizacion;
        this.correoElectronico = correoElectronico;
        this.clave = clave;
    }
    
    public Vendedor(int id, String nombre, String apellido, 
            String organizacion, String correoElectronico, String clave) {
        this.id=id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.organizacion = organizacion;
        this.correoElectronico = correoElectronico;
        this.clave = clave;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getOrganizacion() {
        return organizacion;
    }

    public void setOrganizacion(String organizacion) {
        this.organizacion = organizacion;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = GFG.HashCode(clave);
    }

    @Override
    public String toString() {
        return "Vendedor{" + "identificador=" + id + ", nombre=" + 
                nombre + ", apellido=" + apellido + ", organizacion=" + 
                organizacion + ", correoElectronico=" + correoElectronico + 
                ", clave=" + clave + '}';
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
        Vendedor other = (Vendedor) obj;
        
        if (!Objects.equals(this.correoElectronico, other.correoElectronico)) {
            return false;
        }
        
        return true;
    }
    
    public void saveFile(String nomfile){
        
        try(PrintWriter pw = new PrintWriter(new FileOutputStream(new File(nomfile),true))){
            pw.println(this.id+"|"+this.nombre+"|"+this.apellido+"|"+this.organizacion+"|"+this.correoElectronico+"|"+this.clave);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public static void crearArchivoVendedor(){
        try{
            File file = new File("vendedores.txt");
            file.createNewFile();
        }catch(Exception e){
            e.getMessage();
        }
    }
    
    
    
    
    
    public static void nextVendedor(Scanner sc, String nombreArchivo){
        int id = Util.nextID(nombreArchivo);
        System.out.println("Ingrese su nombre");
        String n = sc.nextLine();
        System.out.println("Ingrese su apellido");
        String a = sc.nextLine();
        System.out.println("Ingrese su organizacion");
        String o = sc.nextLine();
        System.out.println("Ingrese su correo electronico");
        String ce = sc.nextLine();
        System.out.println("Ingrese su clave");
        String cl = GFG.HashCode(sc.nextLine());
        
        
        Vendedor v = new Vendedor(id,n,a,o,ce,cl);
        ArrayList<Vendedor> lineas = Vendedor.readFile(nombreArchivo);
        int size = lineas.size();
        
        if(size!=0){
            if(lineas.contains(v)){
                System.out.println("El usuario ya existe");
            }else{
                v.saveFile(nombreArchivo);
            }
            
        }else{
            v.saveFile(nombreArchivo);
        }

    }
    
    
    
    public static void saveFile(ArrayList<Vendedor> vendedores, String nomfile){
        try(PrintWriter pw = new PrintWriter(new FileOutputStream(new File(nomfile))))
        {
            for (Vendedor v : vendedores){
                pw.println(v.id+"|"+v.nombre+"|"+v.apellido+"|"+v.organizacion+"|"+v.correoElectronico+"|"+v.clave);
            }
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
    
    public static ArrayList<Vendedor> readFile(String nomfile){
        ArrayList<Vendedor> vendedores = new ArrayList<>();
        try(Scanner sc = new Scanner(new File(nomfile))){
            while (sc.hasNextLine())
            {
                String linea = sc.nextLine();
                String[] tokens = linea.split("\\|");
                Vendedor v = new Vendedor(Integer.parseInt(tokens[0]),tokens[1],tokens[2],tokens[3],tokens[4],tokens[5]);
                vendedores.add(v);
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return vendedores;
    }
    
    
    
    //metodo agregar archivo con identificador
    
    
}
