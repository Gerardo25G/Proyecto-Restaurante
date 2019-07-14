/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author Jessica
 */
public class Bodega {
    
    private int id;
    private String nombre;
    private ArrayList<BodegaDetalle> detalleBodega = new ArrayList<>();

    /**
     * Contructor de la clase BodegaDetalle
     * @param id
     * @param nombre
     * @param detalleBodega 
     */
    public Bodega(int id, String nombre, ArrayList<BodegaDetalle> detalleBodega) {
        this.id = id;
        this.nombre = nombre;
        this.detalleBodega = detalleBodega;
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<BodegaDetalle> getDetalleBodega() {
        return detalleBodega;
    }

    public void setDetalleBodega(ArrayList<BodegaDetalle> detalleBodega) {
        this.detalleBodega = detalleBodega;
    }
    
    
    
}
