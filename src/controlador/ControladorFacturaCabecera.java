/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import modelo.Cliente;
import modelo.FacturaCabecera;
import modelo.FacturaDetalle;
import modelo.Sucursal;

/**
 *
 * @author Isaac Chavez ECh
 */
public class ControladorFacturaCabecera {
    ArrayList<FacturaCabecera> fcabList = new ArrayList<>();
    ControladorCliente cc;

    public ControladorFacturaCabecera(ControladorCliente cc) {
        this.cc = cc;
    }
   
    /**
     * Metodo que anade una facturaCabecera
     * @param fc
     * @return 
     */
    public boolean anadirFacturaCabecera(FacturaCabecera fc, Sucursal sucursal){
        boolean r = false;
        Connection con = null;
        String sql = "BEGIN "
                    +"p_agregar_cabecera(?, ?, ?, ?, ?); "
                    +"END; ";
         
        try{
            con = Conexion.getConnection();
            PreparedStatement ps= con.prepareStatement(sql);
            
            //subtotal
            ps.setDouble(1, fc.getSubtotal());
            //iva
            ps.setDouble(2, fc.getIva());
            //total
            ps.setDouble(3, fc.getTotal());
            //Sucursal id
            ps.setInt(4, sucursal.getSucId());
            System.out.println(sucursal.getSucId());
            //Cliente
            ps.setInt(5, fc.getCli().getPerId());
            
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
     * Metodo que anade una factura cf
     * @param fc
     * @return 
     */
    public boolean anadirFacturaCabeceraFinal(FacturaCabecera fc, Sucursal sucursal){
        boolean r = false;
        Connection con = null;
        String sql = "BEGIN "
                    +"p_agregar_cabecera_final(?, ?, ?, ?, ?); "
                    +"END; ";
         
        try{
            con = Conexion.getConnection();
            PreparedStatement ps= con.prepareStatement(sql);
            
            //subtotal
            ps.setDouble(1, fc.getSubtotal());
            //iva
            ps.setDouble(2, fc.getIva());
            //total
            ps.setDouble(3, fc.getTotal());
            //Sucursal
            ps.setInt(4, sucursal.getSucId());
            //Cliente
            ps.setInt(5, 3);
            
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
     * Metodo que enlista las facturascabeceras
     * @return 
     */
    public ArrayList<FacturaCabecera> listarCabeceras(){
        fcabList.clear();
        Connection con = null;
        String sql = " SELECT * "
                    +" FROM rest_cab_facturas ";
        try {
            con = Conexion.getConnection();
            PreparedStatement ps= con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            
            while(rs.next()){
                
                int id = rs.getInt("cab_fac_id");
                Date fecha = rs.getDate("cab_fac_fecha_emision");
                Double subtotal = rs.getDouble("cab_fac_subtotal");
                Double iva = rs.getDouble("cab_fac_iva");
                Double total = rs.getDouble("cab_fac_total");
                ArrayList<FacturaDetalle> fd = new ArrayList<>();
                int cli_id = rs.getInt("rest_us_clientes_cli_id");
                Cliente cli = cc.buscarClienteID(cli_id);
                FacturaCabecera fc = new FacturaCabecera(id, fecha, subtotal, total, iva, fd, cli);
                fcabList.add(fc);
                //System.out.println(cli.getPerCedula());
                
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Conexion.close(con);
        }        
        
        return fcabList;
    }
    
    
    /**
     * Solo al momento de facturar
     * @param id_cliente
     * @return 
     */
    public int buscarId(int id_cliente){
        Connection con = null;
        int id = 0;
        String sql = " SELECT MAX(cab_fac_id) as id "
                    +" FROM rest_cab_facturas "
                    +" WHERE rest_us_clientes_cli_id = "+id_cliente;
        try {
            con = Conexion.getConnection();
            PreparedStatement ps= con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            
            while(rs.next()){
                
                id = rs.getInt("id");
                //System.out.println(id);
                
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Conexion.close(con);
        }        
        
        return id;
    }
    
    /**
     * Metodo que busca una fCabecera por su id 
     * @param id
     * @return 
     */
    public FacturaCabecera buscarFactura(int id){
        FacturaCabecera f= null;
        for(int i = 0;i<fcabList.size();i++){
            FacturaCabecera aux = fcabList.get(i);
            if(aux.getId()==id){
                f = aux;
                
                break;
            }
        }
        return f;
    }
    
    /**
     * Metodo Que calcula el IVA
     * @param subtotal
     * @param iva
     * @return 
     */
    public Double calcularIVA(Double subtotal, Double iva){
        Double total = 0.0;
        Double Civa = iva*0.01;
        total = Civa*subtotal;
        return total;
    }
    
    /**
     * Metodo Que calcula el descuento
     * @param descuento
     * @param productos
     * @return 
     */
    public Double calcularDescuento(Double descuento, ArrayList<Double> productos){
        Double total = 0.0;
        descuento = descuento*0.01;
        for(int i =0;i<productos.size();i++){
            Double aux = productos.get(i);
            Double mul =  descuento*aux;
            total = total+mul;
        }
        return total;
    }
    
    
    /**
     * Metodo que calcula el subtotal
     * @param productos
     * @return 
     */
    public Double calcularSubTotal(ArrayList<Double> productos){
        Double subtotal = 0.0;
        for(int i =0;i<productos.size();i++){
            Double aux = productos.get(i);
            subtotal = subtotal+aux;
        }
        return subtotal;
    }
    
    
    /**
     * Metodo que calcula el total de una factura
     * @param iva
     * @param descuento
     * @param subtotal
     * @return 
     */
    public Double calcularTotal(Double iva, Double descuento, Double subtotal ){
        Double total = 0.0;
        total = iva-descuento+subtotal;
        return total;
    }
}
