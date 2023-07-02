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
    public int id;
    public String horainicio;
    public String horafin;
    public String turno;
    public String estado;
    
    public Horario(){
    }
    
    public int registrar() {
        String sql = "INSERT INTO horarios (id, horainicio, horafin, turno, estado) VALUES (?,?,?,?,?);";
        return DBConection.getConexion().registrar("horarios", sql, id, horainicio, horafin, turno, estado);
    }

    public int eliminar() {
        String sql = "DELETE FROM horarios WHERE id=?";
        return DBConection.getConexion().eliminar(sql, id);
    }

    public int modificar() {
        String sql = "UPDATE horarios set id=?, horainicio=?, horafin=?, turno=?, estado=? WHERE id=?";
        return DBConection.getConexion().modificar(sql, id, horainicio, horafin, turno, estado, id);
    }
    
    public ArrayList<String> listar() {
        String sql = "SELECT * FROM horarios";
        ResultSet rs = DBConection.getConexion().listar(sql);
        try {
            ArrayList<String> lista = new ArrayList<>();
            while (rs.next()) {
                String cadena = "ID: "+rs.getInt("id") + " Hora inicio: " + rs.getString("horainicio")+ " Hora fin: " + rs.getString("horafin")+ " Turno: " + rs.getString("turno") + "\n";
                lista.add(cadena);
            }
            return lista;
        } catch (Exception ex) {
            System.err.println("Lista de horarios " + ex.getMessage());
            return new ArrayList<>();
        }
    }
}
