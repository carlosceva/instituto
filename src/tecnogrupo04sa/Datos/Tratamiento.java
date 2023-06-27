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
public class Tratamiento {
    public int id_tra;
    public int codigo_diag;
    public String fecha_tra;
    public String observacion;
    public String proxima_cita;

    public Tratamiento() {
    }
    
    public int registrar() {
        String sql = "INSERT INTO tratamiento (id_tra, codigo_diag, fecha_tra, observacion, proxima_cita) VALUES (?,?,?,?,?);";
        return DBConection.getConexion().registrar("tratamiento", sql, id_tra, codigo_diag, fecha_tra, observacion, proxima_cita);
    }

    public int eliminar() {
        String sql = "DELETE FROM tratamiento WHERE id_diag=?";
        return DBConection.getConexion().eliminar(sql, id_tra);
    }

    public int modificar() {
        String sql = "UPDATE tratamiento set id_tra=?, codigo_diag=?, fecha_tra=? , observacion=? , proxima_cita=? WHERE id_tra=?";
        return DBConection.getConexion().modificar(sql, id_tra, codigo_diag, fecha_tra, observacion, proxima_cita, id_tra);
    }
    
    public ArrayList<String> listar() {
        String sql = "SELECT * FROM tratamiento";
        ResultSet rs = DBConection.getConexion().listar(sql);
        try {
            ArrayList<String> lista = new ArrayList<>();
            while (rs.next()) {
                String cadena = "ID tratamiento: "+rs.getInt("id_tra") + " Codigo diagnostico: " + rs.getInt("codigo_diag") + " Fecha tratamiento: " + rs.getString("fecha_tra") + " Observacion: " + rs.getString("observacion") + " Proxima cita: " + rs.getString("proxima_cita") + "\n";
                lista.add(cadena);
            }
            return lista;
        } catch (Exception ex) {
            System.err.println("Lista de tratamiento " + ex.getMessage());
            return new ArrayList<>();
        }
    }
    
}
