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
public class Servicio {
    public int id_ser;
    public String nombre;
    public String descripcion;
    
    public Servicio(){
    
    }
    
    public int registrar() {
        String sql = "INSERT INTO servicio (id_ser, nombre, descripcion) VALUES (?,?,?);";
        return DBConection.getConexion().registrar("servicio", sql, id_ser, nombre,descripcion);
    }

    public int eliminar() {
        String sql = "DELETE FROM servicio WHERE id_ser=?";
        return DBConection.getConexion().eliminar(sql, id_ser);
    }

    public int modificar() {
        String sql = "UPDATE servicio set id_ser=?, nombre=?, descripcion=? WHERE id_ser=?";
        return DBConection.getConexion().modificar(sql, id_ser, nombre, descripcion, id_ser);
    }
    
    public ArrayList<String> listar() {
        String sql = "SELECT * FROM servicio";
        ResultSet rs = DBConection.getConexion().listar(sql);
        try {
            ArrayList<String> lista = new ArrayList<>();
            while (rs.next()) {
                String cadena = "ID: "+rs.getInt("id_ser") + " Nombre: " + rs.getString("nombre") + " Descripcion: " + rs.getString("descripcion") + "\n";
                lista.add(cadena);
            }
            return lista;
        } catch (Exception ex) {
            System.err.println("Lista de servicios " + ex.getMessage());
            return new ArrayList<>();
        }
    }
    
}
