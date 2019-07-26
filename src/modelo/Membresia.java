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
public class Membresia {
    
    private int memId;
    private int memSaldo;
    private double memCosto;

    
    /*
        Constructor de la clase Membresia
    */
    public Membresia(int memId, int memSaldo, double memCosto) {
        this.memId = memId;
        this.memSaldo = memSaldo;
        this.memCosto = memCosto;
    }
    
    
    /*
        Sets and getts de la clase Membresia
    */

    public int getMemId() {
        return memId;
    }

    public void setMemId(int memId) {
        this.memId = memId;
    }

    public int getMemSaldo() {
        return memSaldo;
    }

    public void setMemSaldo(int memSaldo) {
        this.memSaldo = memSaldo;
    }

    public double getMemCosto() {
        return memCosto;
    }

    public void setMemCosto(double memCosto) {
        this.memCosto = memCosto;
    }
    
    
    
}
