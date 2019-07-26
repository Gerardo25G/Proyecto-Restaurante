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
import modelo.Receta;
import modelo.RecetaDetalle;

/**
 *
 * @author Isaac Chavez ECh
 */
public class ControladorReceta {
    ArrayList<Receta> recList = new ArrayList<>();
    
    /**
     * Metodo que ande una receta
     * @param rec
     * @return 
     */
    public boolean anadirReceta(Receta rec){
        boolean r = false;
        Connection con = null;
        String sql = "BEGIN "
                    +"p_agregar_plato(?, ?); "
                    +"END; ";
         
        try{
            con = Conexion.getConnection();
            PreparedStatement ps= con.prepareStatement(sql);
            
            ps.setString(1, rec.getNombre());
            ps.setDouble(2, rec.getPrecio());
            
            
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
     * Metodo que lista las recetas
     * @return 
     */
    public ArrayList<Receta> listarRecetas(){
        recList.clear();
        Connection con = null;
        String sql = " SELECT * "
                    +" FROM rest_platos ";
        
        try {
            con = Conexion.getConnection();
            PreparedStatement ps= con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            
            while(rs.next()){
                int id = rs.getInt("pc_id");
                String nombre = rs.getString("pc_nombre").trim();
                Double precio = rs.getDouble("pc_precio");
                ArrayList<RecetaDetalle> r = new ArrayList<>();
                Receta rec = new Receta(id, nombre, precio, r);
                recList.add(rec);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            Conexion.close(con);
        }
        return recList;
    }
    
    
    /**
     * Metodo que busca una receta por su nombre
     * @param nombre
     * @return 
     */
    public Receta buscarReceta(String nombre){
        Receta rec = null;
        for(int i=0; i<recList.size();i++){
            Receta aux = recList.get(i);
            if(aux.getNombre().equalsIgnoreCase(nombre)==true){
                rec = aux;
                break;
            }
        }
        return rec;
    }
    
    
    /**
     * Metodo que busca una receta por su Id
     * @param id
     * @return 
     */
    public Receta buscarRecetaId(int id){
        Receta rec = null;
        for(int i=0; i<recList.size();i++){
            Receta aux = recList.get(i);
            if(aux.getId() == id){
                rec = aux;
                break;
            }
        }
        return rec;
    }
    
    
    
    /**
     * Metodo que elimina una receta
     * @param id
     * @return 
     */
    public boolean eliminarReceta(int id){
        boolean r = false;
        Connection con = null;
        String sql = "BEGIN "
                    +"p_eliminar_plato(?); "
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
    
    public boolean editarReceta(Receta rec){
        boolean r = false;
        Connection con = null;
        String sql = "BEGIN "
                    +"p_editar_plato(?, ?, ?); "
                    +"END; ";
         
        try{
            con = Conexion.getConnection();
            PreparedStatement ps= con.prepareStatement(sql);
            
            ps.setInt(1, rec.getId());
            ps.setString(2, rec.getNombre());
            ps.setDouble(3, rec.getPrecio());
            
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
