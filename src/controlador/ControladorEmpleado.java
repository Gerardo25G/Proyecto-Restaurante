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
import modelo.Empleado;
import modelo.Sucursal;

/**
 *
 * @author GerardoG
 */
public class ControladorEmpleado {
    ArrayList<Empleado> empList = new ArrayList<Empleado>();
    
    
    
   
    
    
   /**
    * Metodo que anade un empleado a la BD
    * @param em
     * @param sucursal
    * @return 
    */
    public boolean anadirEmpleado(Empleado em, Sucursal sucursal){
        
        boolean r = false;
        Connection con = null;
        String sql = "BEGIN "
                    +"p_agregar_trabajador(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?); "
                    +"END;";
         
        try{
            con = Conexion.getConnection();
            PreparedStatement ps= con.prepareStatement(sql);
            
            ps.setString(1, em.getPerNombre());
            ps.setString(2, em.getPerApellido());
            ps.setString(3, em.getPerCedula());
            ps.setString(4, em.getPerTelCelular());
            ps.setString(5, em.getPerTelConvencional());
            ps.setString(6, em.getPerDireccion());
            ps.setString(7, em.getPerCorreo());
            ps.setInt(8, sucursal.getSucId());
            ps.setString(9, "E");
            ps.setString(10, em.getEmpUsername());
            ps.setString(11, em.getEmpPassword());
   
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
     * Metodo que lista los empleados de la BD
     * @return 
     */
    public ArrayList<Empleado> listarEmpleados(){
        empList.clear();
        Connection con = null;
        String sql = " SELECT * "
                    + " FROM rest_tipo_usuarios, rest_tip_usuario "
                    + "WHERE rest_tip_usuario.rest_tipo_usuarios_us_id=rest_tipo_usuarios.us_id ";
        
        try {
            con = Conexion.getConnection();
            PreparedStatement ps= con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            
            while(rs.next()){
                String username = rs.getString("tip_us_username").trim();
                String pasword = rs.getString("tip_us_password").trim();
                int id = rs.getInt("tip_us_id");
                String nombre = rs.getString("us_nombre").trim();
                String apellido = rs.getString("us_apellido").trim();
                String cedula = rs.getString("us_cedula").trim() ;
                String celular = rs.getString("us_telf_cel").trim();
                String convencional = rs.getString("us_telf_con").trim();
                String direccion =rs.getString("us_direccion").trim();
                String correo = rs.getString("us_email").trim();
                String tipoT = rs.getString("tip_us_tipo");
                
                Empleado em = new Empleado(username, pasword, id, nombre, apellido, cedula, celular,
                                            convencional, direccion, correo);
                //System.out.println(nombre);
                if(!"A".equals(tipoT)){
                    empList.add(em);
                    //System.out.println(em.getEmpUsername()+em.getEmpPassword()+"aqui");
                }
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Conexion.close(con);
        }       
        
        return empList;
    }

    /**
     * Metodo que busca a un empleado
     * @param cedula
     * @return 
     */
    public Empleado buscarEmpleado(String cedula){
        Empleado emp = null;
        for(int i=0; i<empList.size();i++){
            Empleado aux = empList.get(i);
            if(aux.getPerCedula().equalsIgnoreCase(cedula)==true){
                emp = aux;
                break;
            }
        }
        return emp;
    }


    /**
     * Metodo que elimina a un empleado
     * @param cedula
     * @return 
     */
    public boolean eliminarEmpleado(String cedula){
        boolean r = false;
        Connection con = null;
        String sql = "BEGIN "
                    +"p_eliminar_trabajador(?, ?); "
                    +"END;";
        Empleado emp = buscarEmpleado(cedula); 
        if(emp != null){
            try {
                con = Conexion.getConnection();
                PreparedStatement ps= con.prepareStatement(sql);
                
                ps.setInt(1, emp.getPerId());
                ps.setInt(2, emp.getPerId());
                
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

    /**
     * Metodo que edita los datos de un empleado
     * @param em
     * @param sucursal
     * @return 
     */
    public boolean editarEmpleado(Empleado em, Sucursal sucursal){
        boolean r = false;
        Connection con = null;
        String sql = "BEGIN "
                    +"p_editar_trabajador(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?); "
                    +"END;";
         
        try{
            con = Conexion.getConnection();
            PreparedStatement ps= con.prepareStatement(sql);
            
            ps.setInt(1, em.getPerId());
            ps.setString(2, em.getPerNombre());
            ps.setString(3, em.getPerApellido());
            ps.setString(4, em.getPerCedula());
            ps.setString(5, em.getPerTelCelular());
            ps.setString(6, em.getPerTelConvencional());
            ps.setString(7, em.getPerDireccion());
            ps.setString(8, em.getPerCorreo());
            ps.setInt(9, em.getPerId());
            ps.setInt(10, sucursal.getSucId());
            ps.setString(11, em.getEmpUsername());
            ps.setString(12, em.getEmpPassword());
   
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
     * Metodo que valida la cedula
     */
     public boolean validarCedula(String cedula) {
        boolean r = false;
	int suma2=0;
        int vec[]=new int [10];
		    
	for (int j=0;j<cedula.length();j++){
            vec[j]=Integer.parseInt(cedula.substring(j,j+1));
	}
		    
	boolean num=false;     
	for (int i=0;i<9;i++){
            if (num==false){
                if (vec[i]*2>=10){
                    suma2=suma2+vec[i]*2-9;
		}else {
                    suma2=suma2+vec[i]*2;
		}
                num=true;
            }else{                       
                suma2=suma2+vec[i]*1;
		num=false;                 
            }
        }
        int mod=suma2%10;
        mod=10-mod;
        if (mod==vec[9]){
            r = true;
        }else {
            r = false;
	}
	 return r;
	}

}
