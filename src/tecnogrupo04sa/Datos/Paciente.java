/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tecnogrupo04sa.Datos;

import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author CEVA
 */
public class Paciente {
   public int ci;
   public String nombre; 
   public String apellido;
   public String sexo;
   public int telefono; 
   public String direccion;
   public String fecha_nac; 
   
   public Paciente(){
       
   }
   
   public int registrar() {
        String sql = "INSERT INTO paciente (ci, nombre, apellido, sexo, telefono, direccion, fecha_nac) VALUES (?,?,?,?,?,?,?);";
        return DBConection.getConexion().registrar("paciente", sql, ci, nombre, apellido,sexo,telefono ,direccion,fecha_nac);
    }

    public int eliminar() {
        String sql = "DELETE FROM paciente WHERE ci=?";
        return DBConection.getConexion().eliminar(sql, ci);
    }

    public int modificar() {
        String sql = "UPDATE paciente set ci=?, nombre=?, apellido=?, sexo=?, telefono=? , direccion=?, fecha_nac=?  WHERE ci=?";
        return DBConection.getConexion().modificar(sql, ci, nombre, apellido, sexo, telefono,direccion, fecha_nac,ci);
    }
    
    public ArrayList<String> listar() {
        String sql = "SELECT * FROM paciente";
        ResultSet rs = DBConection.getConexion().listar(sql);
        try {
            ArrayList<String> lista = new ArrayList<>();
            while (rs.next()) {
                String paciente = "CI: "+rs.getInt("ci") + " Nombre: " + rs.getString("nombre") + " Apellido: " + rs.getString("apellido") + " Sexo: " + rs.getString("sexo") + " Telf: " + rs.getInt("telefono") + " Direccion: " + rs.getString("direccion") + " Fecha de Nac:" + rs.getString("fecha_nac") + "\n";
                lista.add(paciente);
            }
            return lista;
        } catch (Exception ex) {
            System.err.println("Lista De usuarios " + ex.getMessage());
            return new ArrayList<>();
        }
    }
   
}
