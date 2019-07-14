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

public class Administrador extends Persona {
    
    private String admUsername;
    private String admPasword;
    
    
    
    /*
    * Constructor de la Clase Administrador que es subclase de la clase Persona
    */
    public Administrador(String admUsername, String admPasword, int perId, String perNombre, 
                         String perApellido, String perCedula, String perTelCelular, String perTelConvencional, 
                         String perDireccion, String perCorreo) {
        
        super(perId, perNombre, perApellido, perCedula, perTelCelular, perTelConvencional, perDireccion, perCorreo);
        this.admUsername = admUsername;
        this.admPasword = admPasword;
    }
    
    
    /*
    * Getters y Setters de la clase Administrador
    */

    public String getAdmUsername() {
        return admUsername;
    }

    public void setAdmUsername(String admUsername) {
        this.admUsername = admUsername;
    }

    public String getAdmPasword() {
        return admPasword;
    }

    public void setAdmPasword(String admPasword) {
        this.admPasword = admPasword;
    }

}

