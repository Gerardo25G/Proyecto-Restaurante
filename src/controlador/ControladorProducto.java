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
import modelo.Producto;
import modelo.TipoMedida;

/**
 *
 * @author GerardoG
 */
public class ControladorProducto {
    ArrayList<Producto> proList = new ArrayList<>();
    private final  ControladorCategoria cc;
    private final  ControladorTipoMedida ctm;
    
    /**
     * Contructor del controladorPoducto
     * @param cc 
     * @param ctm 
     */
    public ControladorProducto(ControladorCategoria cc,ControladorTipoMedida ctm) {
    this.cc = cc;
    this.ctm = ctm;
    }
    
    
    /**
     * Metodo que anade un producto en la base de datos
     * @param p
     * @return 
     */
    public boolean anadirProducto(Producto p, String origen){
        boolean r = false;
        Connection con = null;
        String sql = "BEGIN "
                    +"p_agregar_producto(?, ?, ?, ?, ?, ?);  "
                    +"END;";
         
        try{
            con = Conexion.getConnection();
            PreparedStatement ps= con.prepareStatement(sql);
            
            ps.setString(1, p.getNombre());
            ps.setDouble(2, p.getPrecio());
            ps.setInt(3, p.getCategoria().getId());
            ps.setInt(4, p.getMedida().getId());
            ps.setDouble(5, p.getPeso());
            ps.setString(6, origen);
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
     * Metodo que busca y retorna un producto
     * @param nombre
     * @return 
     */
    public Producto buscarProducto(String nombre){
        Producto pro = null;
        for(int i=0; i<proList.size();i++){
            Producto aux = proList.get(i);
            if(aux.getNombre().equalsIgnoreCase(nombre)==true){
                pro = aux;
                break;
            }
        }
        return pro;
    }

    /**
     * busqueda de un producto por su id
     * @param nombre
     * @return 
     */
    public Producto buscarProductoId(int id){
        Producto pro = null;
        for(int i=0; i<proList.size();i++){
            Producto aux = proList.get(i);
            if(aux.getId() == id){
                pro = aux;
                break;
            }
        }
        return pro;
    }    
    
    
    /**
     * Metodo que lista todos los productos y los almacena en un arrayList
     * @return 
     */
    public ArrayList<Producto> listarProductos(){
        proList.clear();
        Connection con = null;
        String sql = " SELECT * "
                    + " FROM rest_productos ";
        
        try {
            con = Conexion.getConnection();
            PreparedStatement ps= con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            
            while(rs.next()){
                int id = rs.getInt("pro_id");
                String nombre = rs.getString("pro_nombre").trim();
                double precio = rs.getDouble("pro_precio");
                int categoria_id = rs.getInt("rest_tip_productos_id");
                int medida_id = rs.getInt("rest_tip_medida_id");
                double peso = rs.getDouble("pro_peso");
                Categoria cat = cc.buscarCategoriaId(categoria_id);
                TipoMedida med = ctm.buscarMedidaId(medida_id);
                
                
                Producto p = new Producto(id, nombre, precio, peso, med, cat);
                proList.add(p);
                
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Conexion.close(con);
        }
        
        
        return proList;
    }

   
    /**
     * Metodo que edita los datos de un producto
     * @param p
     * @return 
     */
    public boolean editarProducto(Producto p, String origen){
       boolean r = false;
        Connection con = null;
        String sql = "BEGIN "
                    +"p_editar_producto(?, ?, ?, ?, ?, ?, ?); "
                    +"END;";
         
        try{
            con = Conexion.getConnection();
            PreparedStatement ps= con.prepareStatement(sql);
            //id producto
            ps.setInt(1, p.getId());
            //nombre del producto
            ps.setString(2, p.getNombre());
            //precio del producto
            ps.setDouble(3, p.getPrecio());
            //id de la categoria
            ps.setInt(4, p.getCategoria().getId());
            //ID DE LA MEDIDA
            ps.setInt(5, p.getMedida().getId());
            //peso de la unidad
            ps.setDouble(6, p.getPeso());
            //Origen
            ps.setString(7, origen);
            
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
     * Metodo que elimina un producto
     * @param nombre
     * @return 
     */
    public boolean eliminarProducto( String nombre){
        boolean r = false;
        Connection con = null;
        String sql = "BEGIN "
                    +"p_eliminar_producto(?); "
                    +"END;";
        Producto p = buscarProducto(nombre);
        if(p != null){
            try {
                con = Conexion.getConnection();
                PreparedStatement ps= con.prepareStatement(sql);
                
                ps.setInt(1, p.getId());
                
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
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public ControladorCategoria getCc() {
        return cc;
    }

    public ControladorTipoMedida getCtm() {
        return ctm;
    }



}
