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
public class Carrera {
    public int id;
    public String nombrecarrera;
    public String siglacarrera;
    public int periodocarrera;
    
    public Carrera(){
    }
    
    public int registrar() {
        String sql = "INSERT INTO carreras (id, nombrecarrera, siglacarrera, periodocarrera) VALUES (?,?,?,?);";
        return DBConection.getConexion().registrar("carreras", sql, id, nombrecarrera, siglacarrera, periodocarrera);
    }

    public int eliminar() {
        String sql = "DELETE FROM carreras WHERE id=?";
        return DBConection.getConexion().eliminar(sql, id);
    }

    public int modificar() {
        String sql = "UPDATE carreras set id=?, nombrecarrera=?, siglacarrera=?, periodocarrera=? WHERE id=?";
        return DBConection.getConexion().modificar(sql, id, nombrecarrera, siglacarrera, periodocarrera,id);
    }
    
    public ArrayList<String> listar() {
        String sql = "SELECT * FROM carreras";
        ResultSet rs = DBConection.getConexion().listar(sql);
        try {
            ArrayList<String> lista = new ArrayList<>();
            while (rs.next()) {
                String cadena = "ID: "+rs.getInt("id") + " Nombre: " + rs.getString("nombrecarrera") + " Sigla: " + rs.getString("siglacarrera") + " Periodo: " + rs.getInt("periodocarrera") + "\n";
                lista.add(cadena);
            }
            return lista;
        } catch (Exception ex) {
            System.err.println("Lista de carreras " + ex.getMessage());
            return new ArrayList<>();
        }
    }
}
