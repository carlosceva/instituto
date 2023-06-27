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
public class Especialidad {
    public int id_esp;
    public String nombre;
    
    public Especialidad(){
    }
    
    public int registrar() {
        String sql = "INSERT INTO especialidad (id_esp, nombre) VALUES (?,?);";
        return DBConection.getConexion().registrar("especialidad", sql, id_esp, nombre);
    }

    public int eliminar() {
        String sql = "DELETE FROM especialidad WHERE id_esp=?";
        return DBConection.getConexion().eliminar(sql, id_esp);
    }

    public int modificar() {
        String sql = "UPDATE especialidad set id_esp=?, nombre=? WHERE id_esp=?";
        return DBConection.getConexion().modificar(sql, id_esp, nombre,id_esp);
    }
    
    public ArrayList<String> listar() {
        String sql = "SELECT * FROM especialidad";
        ResultSet rs = DBConection.getConexion().listar(sql);
        try {
            ArrayList<String> lista = new ArrayList<>();
            while (rs.next()) {
                String cadena = "ID: "+rs.getInt("id_esp") + " Nombre: " + rs.getString("nombre") + "\n";
                lista.add(cadena);
            }
            return lista;
        } catch (Exception ex) {
            System.err.println("Lista de especialidades " + ex.getMessage());
            return new ArrayList<>();
        }
    }
    
}
