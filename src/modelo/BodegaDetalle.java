/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Jessica
 */
public class BodegaDetalle {
    private int id;
    private Double cantidadTotal;
    private Producto producto;

    
    /**
     * Contructor de la clase bodegadetalle
     * @param id
     * @param cantidadTotal
     * @param producto 
     */
    public BodegaDetalle(int id, Double cantidadTotal, Producto producto) {
        this.id = id;
        this.cantidadTotal = cantidadTotal;
        this.producto = producto;
    }

    
    /**
     * Setts and Getts
     * @return 
     */
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Double getCantidadTotal() {
        return cantidadTotal;
    }

    public void setCantidadTotal(Double cantidadTotal) {
        this.cantidadTotal = cantidadTotal;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
    
    
    
}

