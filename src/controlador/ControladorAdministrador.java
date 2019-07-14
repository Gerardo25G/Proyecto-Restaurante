/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import modelo.Administrador;


/**
 *
 * @author GerardoG
 */
public class ControladorAdministrador {
    ArrayList<Administrador> adminList = new ArrayList<Administrador>();
    

   
    
    /**
     * Metodo que anade un Administrador a la base de datos
     * @param a
     * @return boolean
     */
    public boolean anadirAdministrador(Administrador a){
        boolean r = false;
        Connection con = null;
        String sql = "BEGIN "
                    +"p_agregar_trabajador(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?); "
                    +"END;";
         
        try{
            con = Conexion.getConnection();
            PreparedStatement ps= con.prepareStatement(sql);
            
            ps.setString(1, a.getPerNombre());
            ps.setString(2, a.getPerApellido());
            ps.setString(3, a.getPerCedula());
            ps.setString(4, a.getPerTelCelular());
            ps.setString(5, a.getPerTelConvencional());
            ps.setString(6, a.getPerDireccion());
            ps.setString(7, a.getPerCorreo());
            //id de la sucursal
            ps.setInt(8, 1);
            ps.setString(9, "A");
            ps.setString(10, a.getAdmUsername());
            ps.setString(11, a.getAdmPasword());
   
            ps.executeUpdate();
            r=true;
                	    
		    
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Conexion.close(con);
        }
        
        return r;
    }
    
    
    
    /**
     * Metodo que lista los administradores de la base de datos
     * @return list
     */
    public ArrayList<Administrador> listarAdministradores(){
        adminList.clear();
        Connection con = null;
        String sql = " SELECT * "
                    + " FROM rest_tip_usuario r, rest_tipo_usuarios t "
                    + " WHERE r.tip_us_id = t.us_id ";
        
        try {
            con = Conexion.getConnection();
            PreparedStatement ps= con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            
            while(rs.next()){
                String username = rs.getString("tip_us_username").trim();
                String pasword = rs.getString("tip_us_password").trim();
                int id = rs.getInt("tip_us_id");
                String nombre = rs.getString("us_nombre").trim();
                String apellido = rs.getString("us_apellido").trim();
                String cedula = rs.getString("us_cedula") ;
                String celular = rs.getString("us_telf_cel").trim();
                String convencional = rs.getString("us_telf_con").trim();
                String direccion =rs.getString("us_direccion").trim();
                String correo = rs.getString("us_email").trim();
                String tipoT = rs.getString("tip_us_tipo");
                Administrador adm = new Administrador(username, pasword, id, nombre, apellido,
                                                cedula, celular, convencional, direccion, correo);
                if(!"E".equals(tipoT)){
                    adminList.add(adm);
                }
                
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Conexion.close(con);
        }
        
        
        return adminList;
    }
    
    /**
     * Metodo que elimina un Administrador
     * @param cedula
     * @return 
     */
    public boolean eliminarAdministrador(String cedula){
        boolean r = false;
        Connection con = null;
        String sql = "BEGIN "
                    +"p_eliminar_trabajador(?, ?); "
                    +"END;";
        Administrador adm = buscarAdministrador(cedula); 
        if(adm != null){
            try {
                con = Conexion.getConnection();
                PreparedStatement ps= con.prepareStatement(sql);
                
                ps.setInt(1, adm.getPerId());
                ps.setInt(2, adm.getPerId());
                
                ps.executeUpdate();
                r=true;
            } catch (Exception e) {
                e.printStackTrace();
            } finally{
                Conexion.close(con);
            }
                
        }

        return r;
    }
    
    
    /**
     * Metodo que busca a un Administrador
     * @param cedula
     * @return 
     */
    public Administrador buscarAdministrador(String cedula){
        Administrador adm = null;
        for(int i=0; i<adminList.size();i++){
            Administrador aux = adminList.get(i);
            if(aux.getPerCedula().equals(cedula)==true){
                adm = aux;
                break;
            }
        }
        return adm;
    }
    
    /**
     * Metodo que adita los datos de un administrador
     * @param a
     * @return 
     */
    public boolean editarAdministrador(Administrador a){
        boolean r = false;
        Connection con = null;
        String sql = "BEGIN "
                    +"p_editar_trabajador(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?); "
                    +"END;";
         
        try{
            con = Conexion.getConnection();
            PreparedStatement ps= con.prepareStatement(sql);
            
            ps.setInt(1, a.getPerId());
            ps.setString(2, a.getPerNombre());
            ps.setString(3, a.getPerApellido());
            ps.setString(4, a.getPerCedula());
            ps.setString(5, a.getPerTelCelular());
            ps.setString(6, a.getPerTelConvencional());
            ps.setString(7, a.getPerDireccion());
            ps.setString(8, a.getPerCorreo());
            ps.setInt(9, a.getPerId());
            ps.setString(10, a.getAdmUsername());
            ps.setString(11, a.getAdmPasword());
   
            ps.executeUpdate();
            r=true;
                	    
		    
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Conexion.close(con);
        }
        
        return r;
    }
}

