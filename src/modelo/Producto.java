/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author GerardoG
 */
public class Producto {
    
    private int id;
    private String nombre;
    private Double precio;
    private double peso;
    private TipoMedida medida;
    private Categoria categoria;

    /**
     * Contructor de la clase Producto
     * @param id
     * @param nombre
     * @param precio
     * @param peso
     * @param medida
     * @param categoria 
     */
    public Producto(int id, String nombre, Double precio, double peso, TipoMedida medida, Categoria categoria) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.peso = peso;
        this.medida = medida;
        this.categoria = categoria;
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

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public TipoMedida getMedida() {
        return medida;
    }

    public void setMedida(TipoMedida medida) {
        this.medida = medida;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
    
    /**
     * Setts and Getss
     */
    
    
}

