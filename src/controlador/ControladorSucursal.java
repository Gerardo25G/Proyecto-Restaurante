/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.sql.Connection;
import modelo.Sucursal;
import conexion.Conexion;
import java.awt.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Isaac Chavez ECh
 */
public class ControladorSucursal {
    ArrayList<Sucursal> sucursalList = new ArrayList<Sucursal>();
    
    /*
    *Metodoo que anade una sucursal
    *Recibe como parametro un objeto de tipo Sucursal
    *Retorna un boleano
    */
    public boolean anadirSucursal(Sucursal s){
        int ciu = buscarCiudad(s.getSucCiudad());
        boolean r = false;
        Connection con = null;
        String sql = "BEGIN "
                    + "p_agregar_sucursal(?, ?, ?, ?, ?); "
                    + "END;";
        
        try{
			con = Conexion.getConnection();
			PreparedStatement ps= con.prepareStatement(sql);
		    
                        //ps.setInt(1,s.getSucId());
                        ps.setString(1, s.getSucNombre());
                        ps.setString(2, s.getSucCalleP());
                        ps.setString(3, s.getSucCalleS());
                        ps.setString(4, s.getSucTelCon());
                        ps.setInt(5, ciu);
			
		    
		    ps.executeUpdate();
		    if(sucursalList.add(s)){
                        r=true;
                    }
		    
		} catch (Exception e) {
		    e.printStackTrace();
		} finally {
			Conexion.close(con);
		}

                
        return r;
    }
    
    /**
     * 
     * @return 
     */
    public ArrayList<Sucursal> listarSucursales(){
        sucursalList.clear();
        Connection con = null;
        String sql = " SELECT * "
                    + " FROM rest_sucursales ";
        
        try {
            con = Conexion.getConnection();
            PreparedStatement ps= con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            
            while(rs.next()){
                //id
                int id = rs.getInt("suc_id");
                //Nombre
                String nombre = rs.getString("suc_nombre").trim();
                //C Principal
                String principal = rs.getString("suc_calle_p").trim();
                //CSecundaria
                String secundaria = rs.getString("suc_calle_s").trim();
                //Telefono
                String telefono = rs.getString("suc_telf_con").trim();
                //id ciudad
                int idc = rs.getInt("rest_ciudades_ciu_id");
                ArrayList<String> resul = obtenerUbicacion(idc);
                //ciudad
                String ciudad = resul.get(1);
                //Privincia
                String provincia = resul.get(0);
                //System.out.println(ciudad+"---"+provincia);
                Sucursal sucursal = new Sucursal(id, nombre, principal, secundaria, telefono, provincia, ciudad);
                sucursalList.add(sucursal);
                
                
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Conexion.close(con);
        }       
        
        return sucursalList;
    }
    
    /*
    *Metodo que toma los datos de las provincias de la BD
    *No recive ningun parametro
    *retorna un arraylist de tipo String
    */
     public ArrayList<String> listarProvincias(){
        ArrayList<String> provinciasList = new ArrayList<>();
        String sql = "SELECT  *  "
                    +"FROM rest_provincias ";
        Connection con = null;
        
        try {
            con = Conexion.getConnection();
            PreparedStatement ps= con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
			        //System.out.println(rs.getDate("FECHA_NAC"));
			        
                
                //int id = (rs.getInt("prov_id"));
                //String ids = Integer.toString(id);
                String nombre = rs.getString("prov_nombre").trim();
                System.out.println(nombre);
                //String cadena = nombre+"-"+ids;
        
                provinciasList.add(nombre);
                //cadena = "";
			        
            }
			   
	} catch (Exception e) {
            e.printStackTrace();
	} finally {
            Conexion.close(con);
	}
			

        
        
        return provinciasList;
    }

     
    public ArrayList<String> listarCiudades(){
        ArrayList<String> ciudadesList = new ArrayList<>();
        String sql = "SELECT  *  "
                    +"FROM rest_ciudades ";
        Connection con = null;
        
        try {
            con = Conexion.getConnection();
            PreparedStatement ps= con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
			        //System.out.println(rs.getDate("FECHA_NAC"));
			        
                
                //int id = (rs.getInt("prov_id"));
                //String ids = Integer.toString(id);
                String nombre = rs.getString("ciu_nombre").trim();
                System.out.println(nombre);
                //String cadena = nombre+"-"+ids;
        
                ciudadesList.add(nombre);
                //cadena = "";
			        
            }
			   
	} catch (Exception e) {
            e.printStackTrace();
	} finally {
            Conexion.close(con);
	}

        return ciudadesList;
    }
     
     

     /*
     *Metodo que busca una provincia en la base de datos
     *Recibe como parametro el nombre de la provincia
     *retorna un int  
     */
    public int buscarProvincia(String nombre){
         int r = 0;
         Connection con = null;
         String sql = " SELECT * "
                    + " FROM rest_provincias "
                    + " WHERE UPPER(prov_nombre) = UPPER(?) ";
        try {
            con = Conexion.getConnection();
            PreparedStatement ps= con.prepareStatement(sql);
            //mando los datos
            ps.setString(1, nombre);	    
            ps.executeUpdate();
            
            //recibo los datos
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                r = rs.getInt("prov_id");
            }    
            
            
	} catch (Exception e) {
            e.printStackTrace();
	} finally {
            Conexion.close(con);
	}
         
         return r;
     }
     
     
    public Sucursal buscarSucursal(String nombre){
        Sucursal aux = null;
        Sucursal suc = null;
        for(int i=0;i<sucursalList.size();i++){
            suc = sucursalList.get(i);
            if(nombre.equalsIgnoreCase(suc.getSucNombre())==true){
                aux = suc;
                break;
            }
        }
        return aux;
    }
     
     /*
     *Metodo que busca una ciudad
     */
    public int buscarCiudad (String nombre){
        int r=0;
         Connection con = null;
         String sql = " SELECT * "
                    + " FROM rest_ciudades "
                    + " WHERE UPPER(ciu_nombre) = UPPER(?) ";
        try {
            con = Conexion.getConnection();
            PreparedStatement ps= con.prepareStatement(sql);
            //mando los datos
            ps.setString(1,nombre);	    
            ps.executeUpdate();
            
            //recibo los datos
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                r = rs.getInt("ciu_id");
            }    
            
            
	} catch (Exception e) {
            e.printStackTrace();
	} finally {
            Conexion.close(con);
	}
         
         return r;
     }

     
     /**
      * 
      * @param id
      * @return 
      */
    private ArrayList<String> obtenerUbicacion(int id){
         Connection con = null;
         ArrayList<String> resultado = new ArrayList<>();
         String sql = " SELECT ciu_nombre, prov_nombre "
                    + " FROM rest_ciudades c, rest_provincias p "
                    + " WHERE c.ciu_id = "+ id +" AND c.rest_provincias_prov_id = p.prov_id ";
        try {
            con = Conexion.getConnection();
            PreparedStatement ps= con.prepareStatement(sql);
            
            //recibo los datos
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                String ciudad = rs.getString("ciu_nombre").trim();
                resultado.add(ciudad);
                String provincia = rs.getString("prov_nombre").trim();
                resultado.add(provincia);
            }    
            
            
	} catch (Exception e) {
            e.printStackTrace();
	} finally {
            Conexion.close(con);
	}
         
         return resultado;
     }

}
