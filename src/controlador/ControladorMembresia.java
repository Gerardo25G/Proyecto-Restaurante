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
import modelo.Cliente;
import modelo.Membresia;

/**
 *
 * @author GerardoG
 */
public class ControladorMembresia {
    ArrayList<Membresia> memList = new ArrayList<Membresia>();
    /**
     * Metodo que registra la suscripcion de un cliente a una membresia
     * @param m
     * @param cli
     * @return boolean
     */
    public boolean anadirMembresia(Membresia m, Cliente cli){
        boolean r = false;
        Connection con = null;
        String sql = "BEGIN "
                    +"p_agregar_membresia(?, ?, ?); "
                    +"END;";
         
        try{
            con = Conexion.getConnection();
            PreparedStatement ps= con.prepareStatement(sql);
            
            ps.setInt(1, m.getMemSaldo());
            ps.setDouble(2, m.getMemCosto());
            ps.setInt(3, cli.getPerId());

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
     * Metodo que lista todas las membresias
     * @return 
     */
    public ArrayList<Membresia> listarMembresias(){
        memList.clear();
        Connection con = null;
        String sql = " SELECT * "
                    +" FROM rest_cli_membresias_vip ";
        try {
            con = Conexion.getConnection();
            PreparedStatement ps= con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            
            while(rs.next()){
                
                int id = rs.getInt("vip_id");
                int saldo = rs.getInt("vip_cantidad_total");
                Double costo = rs.getDouble("vip_costo");
                
                
                Membresia m = new Membresia(id, saldo, costo);
                memList.add(m);
                //System.out.println(nombre);
                
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Conexion.close(con);
        }        
        
        return memList;
    }

    /**
     * Metodo que busca una membresia
     * @param cedula
     * @return 
     */
    public Membresia buscarMembresia(String cedula){
        Membresia mem = null;
        Connection con = null;
        String sql = " SELECT * "
                    + " FROM rest_us_clientes a, rest_cli_membresias_vip b "
                    + " WHERE a.cli_cedula = "+cedula+" AND b.rest_us_clientes_cli_id=a.cli_id ";
        try {
            con = Conexion.getConnection();
            PreparedStatement ps= con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            
            while(rs.next()){
                int id = rs.getInt("vip_id");
                int saldo = rs.getInt("vip_cantidad_total");
                double costo = rs.getDouble("vip_costo");
                
                Membresia aux = new Membresia(id, saldo, costo);
                mem = aux;
                
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Conexion.close(con);
        }
        return mem;
    }

    /**
     * 
     * @param id
     * @return 
     */
    public boolean eliminarMembresia(int id){
        boolean r = false;
        Connection con = null;
        String sql = " BEGIN "
                    +" p_eliminar_membresia(?); "
                    +" END;";
        
        
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
     * 
     * @param m
     * @param c
     * @return 
     */
    public boolean editarMembresia(Membresia m, Cliente c){
        boolean r = false;
        Connection con = null;
        String sql = "BEGIN "
                    +"p_editar_membresia(?, ?, ?, ?); "
                    +"END; ";
         
        try{
            con = Conexion.getConnection();
            PreparedStatement ps= con.prepareStatement(sql);
            
            ps.setInt(1, m.getMemId());
            ps.setInt(2, m.getMemSaldo());
            ps.setDouble(3, m.getMemCosto());
            ps.setInt(4, c.getPerId());
   
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
     * 
     * @param m
     * @return 
     */
    public boolean renovarMembresia(Membresia m){
        boolean r = false;
        Connection con = null;
        String sql = "BEGIN "
                    +"p_renovar_membresia(?); "
                    +"END; ";
         
        try{
            con = Conexion.getConnection();
            PreparedStatement ps= con.prepareStatement(sql);
            
            ps.setInt(1, m.getMemId());
   
            ps.executeUpdate();
            r=true;
                	    
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Conexion.close(con);
        }
        
        return r;
    }
    
    public boolean restarMembresia(Membresia m){
       boolean r = false;
        Connection con = null;
        String sql = "BEGIN "
                    +"p_restar_membresia(?); "
                    +"END; ";
         
        try{
            con = Conexion.getConnection();
            PreparedStatement ps= con.prepareStatement(sql);
            
            ps.setInt(1, m.getMemId());
   
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



