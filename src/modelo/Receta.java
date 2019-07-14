/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author GerardoG
 */
public class Receta {

    private int id;
    private String nombre;
    private Double precio;
    private ArrayList<RecetaDetalle> recetaDetalle = new ArrayList<>();

    
    /**
     * 
     * @param id
     * @param nombre
     * @param precio
     * @param recetaDetalle 
     */
    public Receta(int id, String nombre, Double precio, ArrayList<RecetaDetalle> recetaDetalle) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.recetaDetalle = recetaDetalle;
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

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public ArrayList<RecetaDetalle> getRecetaDetalle() {
        return recetaDetalle;
    }

    public void setRecetaDetalle(ArrayList<RecetaDetalle> recetaDetalle) {
        this.recetaDetalle = recetaDetalle;
    }

}

