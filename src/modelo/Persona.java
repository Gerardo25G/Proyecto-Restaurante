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
public class Persona {
    
    private int perId;
    private String perNombre;
    private String perApellido;
    private String perCedula;
    private String perTelCelular;
    private String perTelConvencional;
    private String perDireccion;
    private String perCorreo;
    
    
    
/*
 * Constructor de la Clase Persona 
 */
    public Persona(int perId, String perNombre, String perApellido, String perCedula,
                    String perTelCelular, String perTelConvencional, String perDireccion,
                    String perCorreo) {
        this.perId = perId;
        this.perNombre = perNombre;
        this.perApellido = perApellido;
        this.perCedula = perCedula;
        this.perTelCelular = perTelCelular;
        this.perTelConvencional = perTelConvencional;
        this.perDireccion = perDireccion;
        this.perCorreo = perCorreo;
    }
    
    
    
    
    /*
    * Getters y Setters de la clase Persona
    */

    public int getPerId() {
        return perId;
    }

    public void setPerId(int perId) {
        this.perId = perId;
    }

    public String getPerNombre() {
        return perNombre;
    }

    public void setPerNombre(String perNombre) {
        this.perNombre = perNombre;
    }

    public String getPerApellido() {
        return perApellido;
    }

    public void setPerApellido(String perApellido) {
        this.perApellido = perApellido;
    }

    public String getPerCedula() {
        return perCedula;
    }

    public void setPerCedula(String perCedula) {
        this.perCedula = perCedula;
    }

    public String getPerTelCelular() {
        return perTelCelular;
    }

    public void setPerTelCelular(String perTelCelular) {
        this.perTelCelular = perTelCelular;
    }

    public String getPerTelConvencional() {
        return perTelConvencional;
    }

    public void setPerTelConvencional(String perTelConvencional) {
        this.perTelConvencional = perTelConvencional;
    }

    public String getPerDireccion() {
        return perDireccion;
    }

    public void setPerDireccion(String perDireccion) {
        this.perDireccion = perDireccion;
    }

    public String getPerCorreo() {
        return perCorreo;
    }

    public void setPerCorreo(String perCorreo) {
        this.perCorreo = perCorreo;
    }

    
}