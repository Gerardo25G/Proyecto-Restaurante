/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Isaac Chavez ECh
 */
public class FacturaCabecera {
    private int id;
    private Date fecha_emision;
    private Double subtotal;
    private Double total;
    private Double iva;
    private ArrayList<FacturaDetalle> fac_List;
    private Cliente cli;

    public FacturaCabecera(int id, Date fecha_emision, Double subtotal, Double total, Double iva, ArrayList<FacturaDetalle> fac_List, Cliente cli) {
        this.id = id;
        this.fecha_emision = fecha_emision;
        this.subtotal = subtotal;
        this.total = total;
        this.iva = iva;
        this.fac_List = fac_List;
        this.cli = cli;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFecha_emision() {
        return fecha_emision;
    }

    public void setFecha_emision(Date fecha_emision) {
        this.fecha_emision = fecha_emision;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Double getIva() {
        return iva;
    }

    public void setIva(Double iva) {
        this.iva = iva;
    }

    public ArrayList<FacturaDetalle> getFac_List() {
        return fac_List;
    }

    public void setFac_List(ArrayList<FacturaDetalle> fac_List) {
        this.fac_List = fac_List;
    }

    public Cliente getCli() {
        return cli;
    }

    public void setCli(Cliente cli) {
        this.cli = cli;
    }

   

    
}