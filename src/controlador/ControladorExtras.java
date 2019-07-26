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
import modelo.Administrador;
import modelo.Extra1;

/**
 *
 * @author Isaac Chavez ECh
 */
public class ControladorExtras {
    
    public ArrayList<Extra1> reporteMensual(){
        ArrayList<Extra1> extra1List = new ArrayList<>();
        Connection con = null;
        String sql = " SELECT  c.NOMBRE , c.CANTIDAD, (PRECIO*CANTIDAD) monto_total, c.suc_nombre "
                    + " FROM(SELECT pla.pc_nombre NOMBRE,sum(df.det_fac_cantidad) CANTIDAD,pla.pc_precio PRECIO, s.suc_nombre "
                    + " FROM rest_platos pla, rest_det_facturas df, REST_CAB_FACTURAS cf, rest_sucursales s "
                    + " WHERE pla.pc_id=df.rest_platos_pc_id AND df.rest_cab_facturas_cab_fac_id=cf.cab_fac_id "
                    + " AND cf.cab_fac_fecha_emision>='01/Jul/2019' AND cf.cab_fac_fecha_emision<'30/Jul/2019' and cf.rest_sucursales_suc_id=s.suc_id "
                    + " GROUP BY pla.pc_nombre,pla.pc_precio, s.suc_nombre"
                    + " ORDER BY 2 desc) c "
                    + " ORDER BY 3 desc";
        
        try {
            con = Conexion.getConnection();
            PreparedStatement ps= con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            
            while(rs.next()){
                String nombre = rs.getString("nombre").trim();
                int cantidades = rs.getInt("cantidad");
                Double monto = rs.getDouble("monto_total");
                String sucursal = rs.getString("suc_nombre".trim());
                //System.out.println(sucursal);
                Extra1 extra = new Extra1(nombre, cantidades, monto, sucursal);
                
                extra1List.add(extra);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Conexion.close(con);
        }
        
        
        return extra1List;
    }
    
}
