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
public class Empleado extends Persona {
    
    private String empUsername;
    private String empPassword;
    
    
    

    public Empleado(String empUsername, String empPassword, int perId, String perNombre, 
                    String perApellido, String perCedula, String perTelCelular, String perTelConvencional,
                    String perDireccion, String perCorreo) {
        super(perId, perNombre, perApellido, perCedula, perTelCelular, perTelConvencional, perDireccion, perCorreo);
        this.empUsername = empUsername;
        this.empPassword = empPassword;
    }

    
    
    
    
    
    
    
    
    /*
    Getts and Setts
    */
    public String getEmpUsername() {
        return empUsername;
    }

    public void setEmpUsername(String empUsername) {
        this.empUsername = empUsername;
    }

    public String getEmpPassword() {
        return empPassword;
    }

    public void setEmpPassword(String empPassword) {
        this.empPassword = empPassword;
    }
    
    
    
}
