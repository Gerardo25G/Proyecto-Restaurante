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

/**
 *
 * @author GerardoG
 */
public class ControladorCliente {
    ArrayList<Cliente> cliList = new ArrayList<Cliente>();
    
    /*
    *Metodo que anade un cliente a la base de datos
    *recibe como parametro un objto de tipo cliente
    *retorna un boolean
    */
    public boolean anadirCliente(Cliente c){
        //Esto va en anadirPersona
        boolean r = false;
        Connection con = null;
        String sql = "BEGIN "
                    +"p_agregar_cliente(?, ?, ?, ?, ?, ?, ?); "
                    +"END;";
         
        try{
            con = Conexion.getConnection();
            PreparedStatement ps= con.prepareStatement(sql);
            
            ps.setString(1, c.getPerNombre());
            ps.setString(2, c.getPerApellido());
            ps.setString(3, c.getPerDireccion());
            ps.setString(4, c.getPerTelCelular());
            ps.setString(5, c.getPerCedula());
            ps.setString(6, c.getPerTelConvencional());
            ps.setString(7, c.getPerCorreo());
            
            
   
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
     * Metodo que toma los datos de la base de datos y los almacena en un arrayList
     * @return eList
     */
    public ArrayList<Cliente> listarClientes(){
        cliList.clear();
        Connection con = null;
        String sql = " SELECT * "
                    +" FROM rest_us_clientes ";
        try {
            con = Conexion.getConnection();
            PreparedStatement ps= con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            
            while(rs.next()){
                
                int id = rs.getInt("cli_id");
                String nombre = rs.getString("cli_nombre").trim();
                String apellido = rs.getString("cli_apellido").trim();
                String direccion = rs.getString("cli_direccion").trim();
                String telefono = rs.getString("cli_telefono").trim();
                String cedula = rs.getString("cli_cedula").trim();
                String convencional = rs.getString("cli_telf_convencional").trim();
                String correo = rs.getString("cli_email").trim();
                
                Cliente cli = new Cliente(id, nombre, apellido, cedula, telefono, convencional, direccion, correo);
                cliList.add(cli);
                //System.out.println(nombre);
                
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Conexion.close(con);
        }
        
        
        return cliList;
    }

    
    /**
     * Metodo que busca a un Cliente por su cedula
     * @param cedula
     * @return Cliente
     */
    public Cliente buscarCliente(String cedula){
        Cliente aux = null;
        Cliente cli = null;
        for(int i=0;i<cliList.size();i++){
            cli = cliList.get(i);
            if(cedula.equalsIgnoreCase(cli.getPerCedula())==true){
                aux = cli;
                break;
            }
        }
        return aux;
    }
    
    
    public Cliente buscarClienteID(int id){
        Cliente aux = null;
        Cliente cli = null;
        for(int i=0;i<cliList.size();i++){
            cli = cliList.get(i);
            if(cli.getPerId()==id){
                aux = cli;
                break;
            }
        }
        return aux;
    }

    /**
     * Metodo que elimina a un cliente con su respectiva membresia
     * @param cedula
     * @return 
     */
    public boolean eliminarCliente(String cedula){
        boolean r = false;
        Connection con = null;
        String sql = " BEGIN "
                    +" p_eliminar_cliente(?, ?); "
                    +" END;";
        Cliente cli = buscarCliente(cedula);
        if(cli != null){
            try {
                con = Conexion.getConnection();
                PreparedStatement ps= con.prepareStatement(sql);
                
                ps.setInt(1, cli.getPerId());
                ps.setInt(2,cli.getPerId() );
                
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
     * Metodo que edita los datos de un cliente
     * @param cli
     * @return 
     */
    public boolean editarCliente(Cliente cli){
        boolean r = false;
        Connection con = null;
        String sql = "BEGIN "
                    +"p_editar_cliente(?, ?, ?, ?, ?, ?, ?, ?); "
                    +"END; ";
         
        try{
            con = Conexion.getConnection();
            PreparedStatement ps= con.prepareStatement(sql);
            System.out.println(cli.getPerId());
            ps.setInt(1, cli.getPerId());
            ps.setString(2, cli.getPerNombre());
            ps.setString(3, cli.getPerApellido());
            ps.setString(4, cli.getPerDireccion());
            ps.setString(5, cli.getPerTelCelular());
            ps.setString(6, cli.getPerCedula());
            ps.setString(7, cli.getPerTelConvencional());
            ps.setString(8, cli.getPerCorreo());

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
     * @param cedula
     * @return 
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
