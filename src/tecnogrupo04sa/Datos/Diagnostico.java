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
public class Diagnostico {
    public int id_diag;
    public int codigo_cita;
    public int codigo_doc;
    public String detalle;
    
    public Diagnostico() {
    }
    
    public int registrar() {
        String sql = "INSERT INTO diagnostico (id_diag, codigo_cita,codigo_doc, detalle) VALUES (?,?,?,?);";
        return DBConection.getConexion().registrar("diagnostico", sql, id_diag, codigo_cita, codigo_doc, detalle);
    }

    public int eliminar() {
        String sql = "DELETE FROM diagnostico WHERE id_diag=?";
        return DBConection.getConexion().eliminar(sql, id_diag);
    }

    public int modificar() {
        String sql = "UPDATE diagnostico set id_diag=?, codigo_cita=?, codigo_doc=? , detalle=? WHERE id_diag=?";
        return DBConection.getConexion().modificar(sql, id_diag, codigo_cita, codigo_doc, detalle,id_diag);
    }
    
    public ArrayList<String> listar() {
        String sql = "SELECT * FROM diagnostico";
        ResultSet rs = DBConection.getConexion().listar(sql);
        try {
            ArrayList<String> lista = new ArrayList<>();
            while (rs.next()) {
                String cadena = "ID Diagnostico: "+rs.getInt("id_diag") + " Codigo cita: " + rs.getInt("codigo_cita") + " Codigo doctor: " + rs.getInt("codigo_doc") + " Detalle: " + rs.getString("detalle") + "\n";
                lista.add(cadena);
            }
            return lista;
        } catch (Exception ex) {
            System.err.println("Lista de diagnostico " + ex.getMessage());
            return new ArrayList<>();
        }
    }
}
