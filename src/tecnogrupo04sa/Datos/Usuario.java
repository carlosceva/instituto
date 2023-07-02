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
public class Usuario {
    public int id;
    public String nombre;
    public String email;
    public String rol;
    public String estado;
    
    public Usuario(){
    }
    
    public int registrar() {
        String sql = "INSERT INTO usuarios (id, nombre, email, rol, estado) VALUES (?,?,?,?,?);";
        return DBConection.getConexion().registrar("usuarios", sql, id, nombre, email, rol,estado);
    }

    public int eliminar() {
        String sql = "DELETE FROM usuarios WHERE id=?";
        return DBConection.getConexion().eliminar(sql, id);
    }

    public int modificar() {
        String sql = "UPDATE usuarios set id=?, nombre=?, email=?, rol=? , estado=? WHERE id=?";
        return DBConection.getConexion().modificar(sql, id, nombre, email, rol,estado,id);
    }
    
    public ArrayList<String> listar() {
        String sql = "SELECT * FROM usuarios";
        ResultSet rs = DBConection.getConexion().listar(sql);
        try {
            ArrayList<String> lista = new ArrayList<>();
            while (rs.next()) {
                String cadena = "ID: "+rs.getInt("id") + " Nombre: " + rs.getString("nombre") + " Email: " + rs.getString("email") + " Rol: " + rs.getString("rol") +  " estado: " + rs.getInt("estado") +"\n";
                lista.add(cadena);
            }
            return lista;
        } catch (Exception ex) {
            System.err.println("Lista de usuarios " + ex.getMessage());
            return new ArrayList<>();
        }
    }
    
}
