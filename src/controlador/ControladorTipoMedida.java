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
import modelo.TipoMedida;

/**
 *
 * @author Isaac Chavez ECh
 */
public class ControladorTipoMedida {
    ArrayList<TipoMedida> medList = new ArrayList<TipoMedida>();
    
    /**
     * Metodo que anade un TipoMedida
     * @param tm
     * @return 
     */
    public boolean anadirMedida(TipoMedida tm){
       boolean r = false;
        Connection con = null;
        String sql = "BEGIN "
                    +"p_agregar_medida(?); "
                    +"END; ";
         
        try{
            con = Conexion.getConnection();
            PreparedStatement ps= con.prepareStatement(sql);
            
            ps.setString(1, tm.getNombre());
            
            
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
     * Metodo que busca y en caso de encontrar retorna el TipoMedida buscado
     * @param nombre
     * @return 
     */
    public TipoMedida buscarMedida(String nombre){
        TipoMedida tm = null;
        for(int i=0; i<medList.size();i++){
            TipoMedida aux = medList.get(i);
            if(aux.getNombre().equalsIgnoreCase(nombre)==true){
                tm = aux;
                break;
            }
        }
        return tm;
    }
    
    
    /**
     * Metodo que lista los diferentes TipoMedida
     * @return 
     */
    public ArrayList<TipoMedida> listarMedidas(){
        medList.clear();
        Connection con = null;
        String sql = " SELECT * "
                    +" FROM rest_tip_medida ";
        
        try {
            con = Conexion.getConnection();
            PreparedStatement ps= con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            
            while(rs.next()){
                int id = rs.getInt("med_id");
                String nombre = rs.getString("med_tipo_medida").trim();
                
                TipoMedida tm = new TipoMedida(id, nombre);
                medList.add(tm);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            Conexion.close(con);
        }
        return medList;
    }
    
    /**
     * Metodo que edita los datos del tipo de medida
     * @param tm
     * @return 
     */
    public boolean editarMedida(TipoMedida tm){
        boolean r = false;
        Connection con = null;
        String sql = "BEGIN "
                    +"p_editar_medida(?, ?); "
                    +"END; ";
         
        try{
            con = Conexion.getConnection();
            PreparedStatement ps= con.prepareStatement(sql);
            
            ps.setInt(1, tm.getId());
            ps.setString(2, tm.getNombre());
   
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
     * Metodo que elimina un TipoMedida
     * @param id
     * @return 
     */
    public boolean eliminarMedida(int id){
        boolean r = false;
        Connection con = null;
        String sql = "BEGIN "
                    +"p_eliminar_medida(?); "
                    +"END;";
        try {
            con = Conexion.getConnection();
            PreparedStatement ps= con.prepareStatement(sql);
                
            ps.setInt(1, id);
               
                
            ps.executeUpdate();
            r=true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            Conexion.close(con);
        }
        return r;
    }
    
    
    /**
     * Metodo que busca a un tipo de medida por su ID
     * @param id
     * @return 
     */
    public TipoMedida buscarMedidaId(int id){
        TipoMedida tm = null;
        for(int i=0; i<medList.size();i++){
            TipoMedida aux = medList.get(i);
            if(aux.getId() == id){
                tm = aux;
                break;
            }
        }
        return tm;
    }
}
