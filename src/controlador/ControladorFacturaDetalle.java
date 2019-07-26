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
import modelo.FacturaCabecera;
import modelo.FacturaDetalle;
import modelo.Receta;

/**
 *
 * @author Isaac Chavez ECh
 */
public class ControladorFacturaDetalle {
    ArrayList<FacturaDetalle>detalleList = new ArrayList<>();
    ControladorReceta cr;
    ControladorFacturaCabecera cfc;

    
    /**
     * 
     * @param cr
     * @param cfc 
     */
    public ControladorFacturaDetalle(ControladorReceta cr, ControladorFacturaCabecera cfc) {
        this.cr = cr;
        this.cfc = cfc;
    }
    
    
    
    public boolean anadirDetalle(ArrayList<FacturaDetalle> fdd, int id_cabecera){
        boolean r = false;
        Connection con = null;
        String sql = "BEGIN "
                    +"p_agregar_detalle(?, ?, ?, ?, ?, ?); "
                    +"END; ";
         
        try{
            con = Conexion.getConnection();
            PreparedStatement ps= con.prepareStatement(sql);
           
            for(int i = 0;i<fdd.size();i++){   
                FacturaDetalle fd = fdd.get(i);
                //cantidad
                ps.setInt(1, fd.getCantidad());
                //Precio
                ps.setDouble(2, fd.getPrecio());
                //total
                ps.setDouble(3, fd.getTotal());
                //Cabecera
                ps.setInt(4, id_cabecera);
                //plato
                ps.setInt(5, fd.getReceta().getId());
                ////descuento
                ps.setDouble(6, fd.getDescuento());

                ps.executeUpdate();
                r=true;
            }
	    
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Conexion.close(con);
        }
        
        return r;
    }
    
    
    public ArrayList<FacturaDetalle> listarDetalles(){
        detalleList.clear();
        Connection con = null;
        String sql = " SELECT * "
                    +" FROM rest_det_facturas ";
        try {
            con = Conexion.getConnection();
            PreparedStatement ps= con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            
            while(rs.next()){
                //id detalle
                int id = rs.getInt("det_fac");
                //cantidad
                int cantidad = rs.getInt("det_fac_cantidad");
                //precio
                Double precio = rs.getDouble("det_fac_precio");
                //total
                Double total = rs.getDouble("det_fac_subtotal");
                //id cabecera
                int id_cabecera = rs.getInt("rest_cab_facturas_cab_fac_id");
                //id receta
                int id_receta = rs.getInt("rest_platos_pc_id");
                //descuento
                Double descuento = rs.getDouble("det_fac_descuento");
                //busquedas
                Receta receta = cr.buscarRecetaId(id_receta);
                FacturaCabecera fc = cfc.buscarFactura(id_cabecera);
                FacturaDetalle fd = new FacturaDetalle(id, cantidad, total, precio, receta, descuento);
                //anadimos
                
                fc.getFac_List().add(fd);
                detalleList.add(fd);
                
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Conexion.close(con);
        }        
        
        return detalleList;
    }
}
