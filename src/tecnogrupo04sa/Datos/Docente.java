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
 * @author CevaLaptop
 */
public class Docente {
    public int id;
    public String nombre;
    public String email;
    public int telefono;
    public String especialidad;
        
    public Docente(){
    }
    
    public int registrar() {
        String sql = "INSERT INTO docentes (id, nombre, email, telefono, especialidad) VALUES (?,?,?,?);";
        return DBConection.getConexion().registrar("docentes", sql, id, nombre, email, telefono, especialidad);
    }

    public int eliminar() {
        String sql = "DELETE FROM docentes WHERE id=?";
        return DBConection.getConexion().eliminar(sql, id);
    }

    public int modificar() {
        String sql = "UPDATE docentes set id=?, nombre=?, email=?, telefono=?, especialidad=? WHERE id=?";
        return DBConection.getConexion().modificar(sql, id, nombre, email, telefono, especialidad,id);
    }
    
    public ArrayList<String> listar() {
        String sql = "SELECT * FROM docentes";
        ResultSet rs = DBConection.getConexion().listar(sql);
        try {
            ArrayList<String> lista = new ArrayList<>();
            while (rs.next()) {
                String cadena = "ID: "+rs.getInt("id") + " Nombre: " + rs.getString("nombre") + " Email: " + rs.getString("email") + " Telefono: " + rs.getInt("telefono") + " Especialidad: " + rs.getInt("especialidad") + "\n";
                lista.add(cadena);
            }
            return lista;
        } catch (Exception ex) {
            System.err.println("Lista de docentes " + ex.getMessage());
            return new ArrayList<>();
        }
    }
}
