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
 * @author andre
 */
public class Calendario {
     public int id;
    public int idusuario;
    public String fecha;
    public String descripcion;
    public String estado;
    
    public Calendario(){
    
    }
    
    
    public int registrar() {
        String sql = "INSERT INTO calendarios (id,idusuario, fecha, descripcion,  estado) VALUES (?,?,?,?,?);";
        return DBConection.getConexion().registrar("calendarios", sql,id,idusuario, fecha, descripcion,  estado);
    }

    public int eliminar() {
        String sql = "DELETE FROM calendarios WHERE id=?";
        return DBConection.getConexion().eliminar(sql, id);
    }

    public int modificar() {
        String sql = "UPDATE calendarios set id=?, idusuario=?, fecha=?, descripcion=?,  estado=? WHERE id=?";
        return DBConection.getConexion().modificar(sql, id,idusuario, fecha, descripcion,  estado,id);
    }
    
    public ArrayList<String> listar() {
        String sql = "SELECT * FROM calendarios";
        ResultSet rs = DBConection.getConexion().listar(sql);
        try {
            ArrayList<String> lista = new ArrayList<>();
            while (rs.next()) {
                   String cadena = "ID: "+rs.getInt("id") + " Idusuario: " + rs.getInt("idusuario") + " Fecha: " + rs.getString("fecha") + " Descripcion: " + rs.getString("descripcion") +  " Estado: " + rs.getString("estado") +"\n";
                
                lista.add(cadena);
            }
            return lista;
        } catch (Exception ex) {
            System.err.println("Lista De Calendarios: " + ex.getMessage());
            return new ArrayList<>();
        }
    }
    
}
