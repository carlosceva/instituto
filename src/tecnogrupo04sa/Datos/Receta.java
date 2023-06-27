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
public class Receta {
    public int id_rec;
    public int codigo_tra;
    public String detalle;
    
    public Receta() {
    }
    
    public int registrar() {
        String sql = "INSERT INTO receta (id_rec, codigo_tra, detalle) VALUES (?,?,?);";
        return DBConection.getConexion().registrar("receta", sql, id_rec, codigo_tra, detalle);
    }

    public int eliminar() {
        String sql = "DELETE FROM receta WHERE id_rec=?";
        return DBConection.getConexion().eliminar(sql, id_rec);
    }

    public int modificar() {
        String sql = "UPDATE receta set id_rec=?, codigo_tra=?, detalle=? WHERE id_rec=?";
        return DBConection.getConexion().modificar(sql, id_rec, codigo_tra, detalle, id_rec);
    }
    
    public ArrayList<String> listar() {
        String sql = "SELECT * FROM receta";
        ResultSet rs = DBConection.getConexion().listar(sql);
        try {
            ArrayList<String> lista = new ArrayList<>();
            while (rs.next()) {
                String cadena = "ID receta: "+rs.getInt("id_rec") + " Codigo tratamiento: " + rs.getInt("codigo_tra") + " Detalle: " + rs.getString("detalle") + "\n";
                lista.add(cadena);
            }
            return lista;
        } catch (Exception ex) {
            System.err.println("Lista de receta " + ex.getMessage());
            return new ArrayList<>();
        }
    }
}
