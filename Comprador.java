/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.model;

import ec.edu.espol.util.GFG;
import ec.edu.espol.util.Util;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

/**
 *
 * @author Felipe
 */
public class Comprador {
    private int id;
    private String nombre;
    private String apellido;
    private String correoElectronico;
    private String organizacion;
    private String clave;

    public Comprador(int id, String nombre, String apellido, 
            String correoElectronico, String organizacion, String clave) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correoElectronico = correoElectronico;
        this.organizacion = organizacion;
        this.clave = clave;
    }
    
    public int getId(){
        return id;
    }
    
    public void setId(int id){
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

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getOrganizacion() {
        return organizacion;
    }

    public void setOrganizacion(String organizacion) {
        this.organizacion = organizacion;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    @Override
    public String toString() {
        return "Comprador{" + "nombre=" + nombre + ", apellido=" + apellido + 
                ", correoElectronico=" + correoElectronico + ", organizacion=" 
                + organizacion + ", clave=" + clave + '}';
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
        Comprador other = (Comprador) obj;
        
        if (!Objects.equals(this.correoElectronico, other.correoElectronico)) {
            return false;
        }
        
        return true;
    }
    
    public static void crearArchivoComprador(){
        try{
            File file = new File("compradores.txt");
            file.createNewFile();
        }catch(Exception e){
            e.getMessage();
        }
    }
    
    public static ArrayList<Comprador> readFile(String nomfile){
        ArrayList<Comprador> compradores = new ArrayList<>();
        try(Scanner sc = new Scanner(new File(nomfile))){
            while (sc.hasNextLine())
            {
                String linea = sc.nextLine();
                String[] tokens = linea.split("\\|");
                Comprador comp = new Comprador(Integer.parseInt(tokens[0]),
                        tokens[1],tokens[2],
                        tokens[3],tokens[4],tokens[5]);
                compradores.add(comp);
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return compradores;
    }
    
    public void saveFile(String nomfile){
        
        try(PrintWriter pw = new PrintWriter(new FileOutputStream
        (new File(nomfile),true))){
            pw.println(this.id+"|"+this.nombre+"|"+this.apellido+"|"+
                    this.organizacion+"|"+this.correoElectronico+"|"+
                    this.clave);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public static void nextComprador(Scanner sc, String nombreArchivo){
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
        
        
        Comprador comp = new Comprador(id,n,a,o,ce,cl);
        ArrayList<Comprador> lineas = Comprador.readFile(nombreArchivo);
        int size = lineas.size();
        
        if(size!=0){
            if(lineas.contains(comp)){
                System.out.println("El usuario ya existe");
            }else{
                comp.saveFile(nombreArchivo);
            }
            
        }else{
            comp.saveFile(nombreArchivo);
        }

    }
    public static void registrarOferta(String archivo,String correo, String placa, double precio){
        try(FileWriter fw = new FileWriter(archivo,true);
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter out = new PrintWriter(bw)){
            out.println(placa+";"+correo+";"+precio);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
    }
    public static void inicioSesionComprador(Scanner sc){
         System.out.println("Ingrese su correo: ");
        String correo = sc.next();
        System.out.println("Ingrese su contraseña: ");
        String contrasenia = sc.next();
        if(Util.comprobarenarchivo("compradores.txt", correo)&& Util.comprobarenarchivo("compradores.txt", contrasenia)){
            
        
        }
    }
    
}
