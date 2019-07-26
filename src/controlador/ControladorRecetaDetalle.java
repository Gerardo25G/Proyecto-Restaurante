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
import modelo.Producto;
import modelo.Receta;
import modelo.RecetaDetalle;

/**
 *
 * @author Isaac Chavez ECh
 */
public class ControladorRecetaDetalle {
    ArrayList<RecetaDetalle> redList = new ArrayList<>();
    private ControladorProducto cp;
    private ControladorReceta cr;

    public ControladorRecetaDetalle(ControladorProducto cp, ControladorReceta cr) {
        this.cp = cp;
        this.cr = cr;
    }
    
    
    
    
    /**
     * Metodo que anade un componente de una receta
     * @param rd
     * @param plato_id
     * @return 
     */
    public boolean anadirRecetaDetalle(RecetaDetalle rd, int plato_id){
        boolean r1 = false;
        Connection con = null;
        String sql = "BEGIN "
                    +"p_agregar_receta(?, ?, ?); "
                    +"END; ";
         
        try{
            con = Conexion.getConnection();
            PreparedStatement ps= con.prepareStatement(sql);
            
            ps.setDouble(1 , rd.getCantidad());
            ps.setInt(2, rd.getProducto().getId());
            ps.setInt(3, plato_id);
            
            ps.executeUpdate();
            r1=true;
                	    
		    
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Conexion.close(con);
        }
        
        return r1;
    }
    
    /**
     * Metodo que lista TODAS las recetasDetalles y las anade a su respectiva Reseta
     * @return 
     */
    public ArrayList<RecetaDetalle> listarTodasRecetas(){
        redList.clear();
        Connection con = null;
        String sql = " SELECT * "
                    +" FROM rest_recetas ";
        
        try {
            con = Conexion.getConnection();
            PreparedStatement ps= con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            
            while(rs.next()){
                int id = rs.getInt("rec_id");
                Double cantidad = rs.getDouble("rec_cantidad");
                //Double precio = rs.getDouble("pc_precio");
                int producto_id = rs.getInt("rest_productos_pro_id");
                int receta_id = rs.getInt("rest_platos_pc_id");
                Producto producto = cp.buscarProductoId(producto_id);
                RecetaDetalle red = new RecetaDetalle(id, cantidad, producto);
                //Anade la recetaDetalle a la receta
                Receta receta = cr.buscarRecetaId(receta_id);
                receta.getRecetaDetalle().add(red);
                
                redList.add(red);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            Conexion.close(con);
        }
        return redList;
    }

    
    /**
     * Metodo que edita los datos de una receta detalle
     * @param rd
     * @param receta_id
     * @return 
     */
    public boolean editarRecetaDetalle(RecetaDetalle rd, int receta_id){
        boolean r = false;
        Connection con = null;
        String sql = "BEGIN "
                    +"p_editar_receta(?, ?, ?, ?); "
                    +"END;";
         
        try{
            con = Conexion.getConnection();
            PreparedStatement ps= con.prepareStatement(sql);
            //id RecetaDetalle
            ps.setInt(1, rd.getId());
            //cantidad del producto 
            ps.setDouble(2, rd.getCantidad());
            //id del producto
            ps.setDouble(3, rd.getProducto().getId());
            //id de la receta o plato
            ps.setInt(4, receta_id);

            
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
     * Metodo que busca a una receta detalle por el nombre de su producto
     * @return 
     */
    public RecetaDetalle buscarRecetaDetalle(String producto){
        RecetaDetalle rd = null;
        for(int i=0; i<redList.size();i++){
            RecetaDetalle aux = redList.get(i);
            if(aux.getProducto().getNombre().equalsIgnoreCase(producto)){
                rd = aux;
                break;
            }
        }
        return rd;
    }
   
    
    /**
     * Metodo que busca a una receta detalle por su id
     * @param id
     * @return 
     */
    public RecetaDetalle buscarRecetaDetalleId(int id){
        RecetaDetalle rd = null;
        for(int i=0; i<redList.size();i++){
            RecetaDetalle aux = redList.get(i);
            if(aux.getId()==id){
                rd = aux;
                break;
            }
        }
        return rd;
    }
    
    
    
    
    
    
    
    
    
    public boolean eliminarRecetaDetalle(int id){
        boolean r = false;
        Connection con = null;
        String sql = "BEGIN "
                    +"p_eliminar_receta(?); "
                    +"END;";
        RecetaDetalle rd = buscarRecetaDetalleId(id);
        if(rd != null){
            try {
                con = Conexion.getConnection();
                PreparedStatement ps= con.prepareStatement(sql);
                
                ps.setInt(1, rd.getId());
                
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
    
    
    
    
    
    
    public ControladorProducto getCp() {
        return cp;
    }

    public void setCp(ControladorProducto cp) {
        this.cp = cp;
    }

    public ControladorReceta getCr() {
        return cr;
    }

    public void setCr(ControladorReceta cr) {
        this.cr = cr;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
