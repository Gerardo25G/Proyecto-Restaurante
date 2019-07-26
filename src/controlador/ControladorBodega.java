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
import modelo.Bodega;
import modelo.BodegaDetalle;
import modelo.FacturaDetalle;
import modelo.Producto;
import modelo.Receta;
import modelo.RecetaDetalle;
import modelo.Sucursal;

/**
 *
 * @author Jessica
 */
public class ControladorBodega {
    
    ArrayList<Bodega> bodList = new ArrayList<>();
    ControladorProducto cp;

    public ControladorBodega(ControladorProducto cp) {
        this.cp = cp;
    }
    
    
    /**
     * Metodo que anade una bodega a un producto
     * @param bodega
     * @param bodegaDetalle
     * @param sucursal
     * @return 
     */
    public boolean anadirBodega(Bodega bodega, BodegaDetalle bodegaDetalle, Sucursal sucursal){
        boolean r1 = false;
        Connection con = null;
        String sql = "BEGIN "
                    +"p_agregar_bodega(?, ?, ?, ?); "
                    +"END; ";
         
        try{
            con = Conexion.getConnection();
            PreparedStatement ps= con.prepareStatement(sql);
            
            ps.setDouble(1, bodegaDetalle.getCantidadTotal());
            //Sucursal_id
            ps.setInt(2, sucursal.getSucId());
            //producto id
            ps.setInt(3, bodegaDetalle.getProducto().getId());
            //nombre de la bodega
            ps.setString(4, bodegaDetalle.getProducto().getNombre()+sucursal.getSucNombre());

            
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
     * Metodo que adiciona un valor a una bodega
     * @param bodega
     * @param sumando
     * @return 
     */
    public boolean sumarBodega(Bodega bodega, double sumando, Sucursal sucursal){
        boolean r1 = false;
        Connection con = null;
        String sql = "BEGIN "
                    +"p_sumar_bodega(?, ?, ?); "
                    +"END; ";
         
        try{
            con = Conexion.getConnection();
            PreparedStatement ps= con.prepareStatement(sql);
            
            ps.setDouble(1, sumando);
            ps.setInt(2, bodega.getId());
            ps.setInt(3, sucursal.getSucId());
            
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
     * Metodo que lista los objetos de una bodega
     * @return 
     */
    public ArrayList<Bodega> listarBodega(){
        bodList.clear();
        Connection con = null;
        String sql = " SELECT * "
                    +" FROM rest_suc_productos ";
        
        try {
            con = Conexion.getConnection();
            PreparedStatement ps= con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            
            while(rs.next()){
                int id = rs.getInt("suc_pro_id");
                Double cantidad = rs.getDouble("suc_pro_cantidad_total");
                int pro_id = rs.getInt("rest_productos_pro_id");
                String nombre = rs.getString("suc_pro_nombre").trim();
                
                ArrayList<BodegaDetalle> b = new ArrayList<>();
                Producto producto = cp.buscarProductoId(pro_id);
                BodegaDetalle BodegaDetalle = new BodegaDetalle(id, cantidad, producto);
                b.add(BodegaDetalle);
                
                Bodega bodega = new Bodega(id, nombre, b);
                bodList.add(bodega);
                
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            Conexion.close(con);
        }
        return bodList;
    }
    
    
    /**
     * Metodo que busca a una bodega
     * @param nombre
     * @return 
     */
    public Bodega buscarBodega(String nombre){
        Bodega bod = null;
        for(int i=0; i<bodList.size();i++){
            Bodega aux = bodList.get(i);
            if(aux.getNombre().equalsIgnoreCase(nombre)==true){
                bod = aux;
                break;
            }
        }
        return bod;
    }

    /**
     * Metodo que elimina el registro de una bodega
     * @param bodega
     * @param sucursal
     * @return 
     */
    public boolean eliminarBodega(Bodega bodega, Sucursal sucursal){
        boolean r = false;
        Connection con = null;
        String sql = "BEGIN "
                    +"p_eliminar_bodega(?, ?); "
                    +"END;";
        try {
            con = Conexion.getConnection();
            PreparedStatement ps= con.prepareStatement(sql);
                
            ps.setInt(1, bodega.getId());
            ps.setInt(2, sucursal.getSucId());
                
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
     * Metodo que edita los datos de una bodega
     * @param bodega
     * @return 
     */
    public boolean editarBodega(Bodega bodega, Sucursal sucursal){
        boolean r = false;
        Connection con = null;
        String sql = "BEGIN "
                    +"p_editar_bodega(?, ?, ?, ?, ?); "
                    +"END; ";
         
        try{
            con = Conexion.getConnection();
            PreparedStatement ps= con.prepareStatement(sql);
            //id de la bodega
            ps.setInt(1, bodega.getId());
            //cantidad total de la bodega
            ps.setDouble(2, bodega.getDetalleBodega().get(0).getCantidadTotal());
            //Sucursal a la que pertenece la bodega
            ps.setInt(3, sucursal.getSucId());
            //producto de la bodega
            ps.setInt(4, bodega.getDetalleBodega().get(0).getProducto().getId());
            //nombre de la bodega
            ps.setString(5, bodega.getNombre());
   
            ps.executeUpdate();
            r=true;
                	    
		    
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Conexion.close(con);
        }
        
        return r;
    }
    
    
    public boolean restarBodega(ArrayList<FacturaDetalle> fd, Sucursal sucursal){
        boolean r = false;
        Connection con = null;
        String sql = "BEGIN "
                    +"p_restar_bodega(?, ?, ?); "
                    +"END; ";
         
        try{
            con = Conexion.getConnection();
            PreparedStatement ps= con.prepareStatement(sql);
            for(int i = 0;i<fd.size();i++){ 
                FacturaDetalle aux = fd.get(i);
                Receta receta = aux.getReceta();
                ArrayList<RecetaDetalle> recetaList = receta.getRecetaDetalle();
                for(int j=0;j<recetaList.size();j++){
                    RecetaDetalle rd = recetaList.get(j);
                    Producto producto = rd.getProducto();
                    Bodega bodega = buscarBodega(producto.getNombre()+sucursal.getSucNombre());
                    Double sustraendo = aux.getCantidad()*rd.getCantidad();
                    //System.out.println("el sustraendo es"+sustraendo+producto.getNombre()+"Bodega");
                    ps.setInt(1, bodega.getId());
                    ps.setDouble(2, sustraendo);
                    ps.setInt(3, sucursal.getSucId());
                    ps.executeUpdate();
                }

            }    
            r=true;
                	    
		    
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Conexion.close(con);
        }
        
        return r;
    }
    
    
    
    
    
    public ControladorProducto getCp() {
        return cp;
    }
}
