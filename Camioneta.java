/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.model;

import ec.edu.espol.model.Vehiculo;
import ec.edu.espol.util.Util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Felipe
 */
public class Camioneta extends Vehiculo {
    private String vidrios;
    private String transmision;
    private String traccion;


    public Camioneta(int id, String placa, String marca, String modelo,
                     String tipoMotor, int año, double recorrido, String color,
                     String tipoCombustible, double precio, String vidrios,
                     String transmision, String traccion) {
        super(id, placa, marca, modelo, tipoMotor, año, recorrido, color,
                tipoCombustible, precio);

        this.vidrios = vidrios;
        this.transmision = transmision;
        this.traccion = traccion;


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

    public String getTraccion() {
        return traccion;
    }

    public void setTraccion(String traccion) {
        this.traccion = traccion;
    }


    @Override
    public String toString() {
        return "Vehiculo{" + "placa=" + placa + ", marca=" + marca + ", modelo="
                + modelo + ", tipoMotor=" + tipoMotor + ", anio=" + anio +
                ", recorrido=" + recorrido + ", color=" + color +
                ", tipoCombustible=" + tipoCombustible + ", precio=" + precio
                + ", vidrios=" + vidrios + ", transmision=" + transmision + ", traccion=" + traccion + '}';
    }


    public void saveFile(String nomfile) {

        try (PrintWriter pw = new PrintWriter(new FileOutputStream(
                new File(nomfile), true))) {
            pw.println(this.id + "|" + this.placa + "|" + this.marca + "|" + this.modelo +
                    "|" + this.tipoMotor + "|" + this.anio + "|" + this.recorrido + "|"
                    + this.color + "|" + this.tipoCombustible + "|" + this.precio + "|"
                    + this.vidrios + "|" + this.transmision);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void nextCamioneta(Scanner sc, String nombreArchivo, int id) {

        String placa = insertarCaracteristica("placa", sc);
        String marca = insertarCaracteristica("marca", sc);
        String modelo = insertarCaracteristica("modelo", sc);
        String tipoDeMotor = insertarCaracteristica("tipo de motor", sc);
        String color = insertarCaracteristica("color", sc);
        String combustible = insertarCaracteristica("combustible", sc);
        String vidrios = insertarCaracteristica("vidrios", sc);
        String transmision = insertarCaracteristica("transmision", sc);
        String traccion = insertarCaracteristica("traccion", sc);

        System.out.println("Ingrese el año");
        int year = Util.pedirInt();
        System.out.println("Ingrese el recorrido");
        double recorrido = Util.pedirDoublePositivo();
        System.out.println("Ingrese el precio");
        double precio = Util.pedirDoublePositivo();

        Camioneta camioneta = new Camioneta(id, placa, marca, modelo, tipoDeMotor, year, recorrido, color, combustible, precio, vidrios, transmision, traccion);

        ArrayList<Vehiculo> vehiculos = Vehiculo.readFile(nombreArchivo);


        int size = vehiculos.size();

        if (size != 0) {
            if (vehiculos.contains(camioneta)) {
                System.out.println("El vehiculo ya existe");
            } else {
                camioneta.saveFile(nombreArchivo);
            }

        } else {
            camioneta.saveFile(nombreArchivo);
        }

    }


}
