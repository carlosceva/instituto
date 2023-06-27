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
public class Horario {
    public int id_hora;
    public String hora;
    
    public Horario(){
    }
    
    public int registrar() {
        String sql = "INSERT INTO horario (id_hora, hora) VALUES (?,?);";
        return DBConection.getConexion().registrar("horario", sql, id_hora, hora);
    }

    public int eliminar() {
        String sql = "DELETE FROM horario WHERE id_hora=?";
        return DBConection.getConexion().eliminar(sql, id_hora);
    }

    public int modificar() {
        String sql = "UPDATE horario set id_hora=?, hora=? WHERE id_hora=?";
        return DBConection.getConexion().modificar(sql, id_hora, hora, id_hora);
    }
    
    public ArrayList<String> listar() {
        String sql = "SELECT * FROM horario";
        ResultSet rs = DBConection.getConexion().listar(sql);
        try {
            ArrayList<String> lista = new ArrayList<>();
            while (rs.next()) {
                String cadena = "ID: "+rs.getInt("id_hora") + " Hora: " + rs.getString("hora") + "\n";
                lista.add(cadena);
            }
            return lista;
        } catch (Exception ex) {
            System.err.println("Lista de horarios " + ex.getMessage());
            return new ArrayList<>();
        }
    }
}
