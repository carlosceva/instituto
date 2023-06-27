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
public class Doctor {
    
    public int ci;
    public String nombre;
    public String apellida;
    public String sexo;
    public int telefono;
    public String direccion;
    public String fecha_nac;
    public int codigo_esp;
    
    public Doctor(){
    
    }
    
    public int registrar() {
        String sql = "INSERT INTO doctor (ci, nombre, apellida, sexo, telefono, direccion, fecha_nac, codigo_esp) VALUES (?,?,?,?,?,?,?,?);";
        return DBConection.getConexion().registrar("paciente", sql, ci, nombre, apellida,sexo,telefono ,direccion,fecha_nac, codigo_esp);
    }

    public int eliminar() {
        String sql = "DELETE FROM doctor WHERE ci=?";
        return DBConection.getConexion().eliminar(sql, ci);
    }

    public int modificar() {
        String sql = "UPDATE doctor set ci=?, nombre=?, apellida=?, sexo=?, telefono=? , direccion=?, fecha_nac=? ,codigo_esp=?  WHERE ci=?";
        return DBConection.getConexion().modificar(sql, ci, nombre, apellida, sexo, telefono,direccion, fecha_nac, codigo_esp, ci);
    }
    
    public ArrayList<String> listar() {
        String sql = "SELECT * FROM doctor";
        ResultSet rs = DBConection.getConexion().listar(sql);
        try {
            ArrayList<String> lista = new ArrayList<>();
            while (rs.next()) {
                String cadena = rs.getInt("ci") + "  " + rs.getString("nombre") + "  " + rs.getString("apellida") + "  " + rs.getString("sexo") + "  " + rs.getInt("telefono") + "  " +rs.getString("direccion") + "  " +rs.getString("fecha_nac")+ "  " + "  " +rs.getInt("codigo_esp") + "\n";
                lista.add(cadena);
            }
            return lista;
        } catch (Exception ex) {
            System.err.println("Lista De Doctores: " + ex.getMessage());
            return new ArrayList<>();
        }
    }
}
