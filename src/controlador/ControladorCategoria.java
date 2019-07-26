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
import modelo.Categoria;


/**
 *
 * @author Jessica
 */
public class ControladorCategoria {
    
    ArrayList<Categoria> catList = new ArrayList<Categoria>();
    
    /**
     * Metodo que anade una categoria
     * @param cat
     * @return 
     */
    public boolean anadirCategoria(String cat){
        boolean r = false;
        Connection con = null;
        String sql = "BEGIN "
                    +"p_agregar_categoria(?); "
                    +"END; ";
         
        try{
            con = Conexion.getConnection();
            PreparedStatement ps= con.prepareStatement(sql);
            
            ps.setString(1, cat);
            
            
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
     * Metodo que lista todas las categoria
     * @return 
     */
    public ArrayList<Categoria> listarCategorias(){
        catList.clear();
        Connection con = null;
        String sql = " SELECT * "
                    +" FROM rest_tip_productos ";
        
        try {
            con = Conexion.getConnection();
            PreparedStatement ps= con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            
            while(rs.next()){
                int id = rs.getInt("tp_id");
                String nombre = rs.getString("tp_nombre").trim();
                
                Categoria cat = new Categoria(id, nombre);
                catList.add(cat);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            Conexion.close(con);
        }
        return catList;
    }
    
    
    /**
     * Metodo que busca una categoria por su nombre
     * @param nombre
     * @return 
     */
    public Categoria buscarCategoria(String nombre){
        Categoria cat = null;
        for(int i=0; i<catList.size();i++){
            Categoria aux = catList.get(i);
            if(aux.getNombre().equalsIgnoreCase(nombre)==true){
                cat = aux;
                break;
            }
        }
        return cat;
    }
    
    
    /**
     * Metodo que busca una categoria por su id
     * @param id
     * @return 
     */
    public Categoria buscarCategoriaId(int id){
        Categoria cat = null;
        for(int i=0; i<catList.size();i++){
            Categoria aux = catList.get(i);
            if(aux.getId() == id){
                cat = aux;
                break;
            }
        }
        return cat;
    }
    
    
    /**
     * Metodo que elimina una categoria por su ID
     * @param id
     * @return 
     */
    public boolean eliminarCategoria(int id){
        boolean r = false;
        Connection con = null;
        String sql = "BEGIN "
                    +"p_eliminar_categoria(?); "
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
     * Metodo que busca y edita los datos de una categoria
     * @param cat
     * @return 
     */
    public boolean editarCategoria(Categoria cat){
        boolean r = false;
        Connection con = null;
        String sql = "BEGIN "
                    +"p_editar_categoria(?, ?); "
                    +"END; ";
         
        try{
            con = Conexion.getConnection();
            PreparedStatement ps= con.prepareStatement(sql);
            
            ps.setInt(1, cat.getId());
            ps.setString(2, cat.getNombre());
   
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
