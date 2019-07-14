/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Isaac Chavez ECh
 */
public class RecetaDetalle {
    private int id;
    private double cantidad;
    private Producto producto;

    
    /**
     * Contructor de la clase DetalleReceta
     * @param id
     * @param cantidad
     * @param producto 
     */
    public RecetaDetalle(int id, double cantidad, Producto producto) {
        this.id = id;
        this.cantidad = cantidad;
        this.producto = producto;
    }

    
    
    
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
    
    
    /**
     * Getts and Setts
     */
    
    
}
