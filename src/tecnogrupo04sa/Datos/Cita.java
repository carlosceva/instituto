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
public class Cita {
    public int id_cita;
    public int codigo_pa;
    public int codigo_ser;
    public int codigo_hora;
    public String fecha_cita;
    
    public Cita() {

    }
    
    public int registrar() {
        String sql = "INSERT INTO cita (id_cita, codigo_pa, codigo_ser, codigo_hora, fecha_cita) VALUES (?,?,?,?,?);";
        return DBConection.getConexion().registrar("cita", sql, id_cita, codigo_pa, codigo_ser, codigo_hora, fecha_cita);
    }

    public int eliminar() {
        String sql = "DELETE FROM cita WHERE id_cita=?";
        return DBConection.getConexion().eliminar(sql, id_cita);
    }

    public int modificar() {
        String sql = "UPDATE cita set id_cita=?, codigo_pa=?, codigo_ser=? , codigo_hora=? WHERE id_cita=?";
        return DBConection.getConexion().modificar(sql, id_cita, codigo_pa, codigo_ser, codigo_hora, id_cita, fecha_cita);
    }
    
    public ArrayList<String> listar() {
        String sql = "SELECT * FROM cita";
        ResultSet rs = DBConection.getConexion().listar(sql);
        try {
            ArrayList<String> lista = new ArrayList<>();
            while (rs.next()) {
                String cadena = "ID CITA: "+rs.getInt("id_cita") + " Codigo paciente: " + rs.getInt("codigo_pa") + " Codigo servicio: " + rs.getInt("codigo_ser") + " Codigo hora: " + rs.getInt("codigo_hora") + " Fecha cita: " + rs.getString("fecha_cita") + "\n";
                lista.add(cadena);
            }
            return lista;
        } catch (Exception ex) {
            System.err.println("Lista de citas " + ex.getMessage());
            return new ArrayList<>();
        }
    }
    
}
