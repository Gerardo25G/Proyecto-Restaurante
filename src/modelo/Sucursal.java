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
public class Sucursal {
    private int sucId;
    private String sucNombre;
    private String sucCalleP;
    private String sucCalleS;
    private String sucTelCon;
    private String sucProvincia;
    private String sucCiudad;
    //falta stock, facturacab,empleados

    /*
    *Constructor de la clase Sucursal
    */
    public Sucursal(int sucId, String sucNombre, String sucCalleP, 
                    String sucCalleS, String sucTelCon, 
                    String sucProvincia, String sucCiudad) {
        this.sucId = sucId;
        this.sucNombre = sucNombre;
        this.sucCalleP = sucCalleP;
        this.sucCalleS = sucCalleS;
        this.sucTelCon = sucTelCon;
        this.sucProvincia = sucProvincia;
        this.sucCiudad = sucCiudad;
    }
   
    
    /*
    *Getts y Setts de la clase Sucursal
    */

    public int getSucId() {
        return sucId;
    }

    public void setSucId(int sucId) {
        this.sucId = sucId;
    }

    public String getSucNombre() {
        return sucNombre;
    }

    public void setSucNombre(String sucNombre) {
        this.sucNombre = sucNombre;
    }

    public String getSucCalleP() {
        return sucCalleP;
    }

    public void setSucCalleP(String sucCalleP) {
        this.sucCalleP = sucCalleP;
    }

    public String getSucCalleS() {
        return sucCalleS;
    }

    public void setSucCalleS(String sucCalleS) {
        this.sucCalleS = sucCalleS;
    }

    public String getSucTelCon() {
        return sucTelCon;
    }

    public void setSucTelCon(String sucTelCon) {
        this.sucTelCon = sucTelCon;
    }

    public String getSucProvincia() {
        return sucProvincia;
    }

    public void setSucProvincia(String sucProvincia) {
        this.sucProvincia = sucProvincia;
    }

    public String getSucCiudad() {
        return sucCiudad;
    }

    public void setSucCiudad(String sucCiudad) {
        this.sucCiudad = sucCiudad;
    }
    
    
    
    
    
}
