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
public class FacturaDetalle {
    private int id;
    private int cantidad;
    private Double total;
    private Double precio;
    private Receta receta;
    private Double descuento;

    
    /**
     * Constructor de la clase FacturaDetalle
     * @param id
     * @param cantidad
     * @param total
     * @param precio
     * @param receta 
     * @param descuento 
     */
    public FacturaDetalle(int id, int cantidad, Double total, Double precio, Receta receta, Double descuento) {
        this.id = id;
        this.cantidad = cantidad;
        this.total = total;
        this.precio = precio;
        this.receta = receta;
        this.descuento = descuento;
    }

    
    /**
     * Getts and Setts
     * @return 
     */
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Receta getReceta() {
        return receta;
    }

    public void setReceta(Receta receta) {
        this.receta = receta;
    }

    public Double getDescuento() {
        return descuento;
    }

    public void setDescuento(Double descuento) {
        this.descuento = descuento;
    }
    
    
    
    
    
}
