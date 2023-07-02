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
public class Modulo {
    public int id;
    public String nombre;
    public String sigla;
    public int idcarrera;
    public int idhorario;
    public String estado;
    
    
    public Modulo(){
    
    }
    
    
    public int registrar() {
        String sql = "INSERT INTO modulos (id, nombre, sigla, idcarrera, idhorario, estado) VALUES (?,?,?,?,?,?);";
        return DBConection.getConexion().registrar("modulos", sql,id, nombre, sigla, idcarrera, idhorario, estado);
    }

    public int eliminar() {
        String sql = "DELETE FROM modulos WHERE id=?";
        return DBConection.getConexion().eliminar(sql, id);
    }

    public int modificar() {
        String sql = "UPDATE modulos set id=?, nombre=?, sigla=?, idcarrera=?, idhorario=? , estado=? WHERE id=?";
        return DBConection.getConexion().modificar(sql, id, nombre, sigla, idcarrera, idhorario, estado,id);
    }
    
    public ArrayList<String> listar() {
        String sql = "SELECT * FROM modulos";
        ResultSet rs = DBConection.getConexion().listar(sql);
        try {
            ArrayList<String> lista = new ArrayList<>();
            while (rs.next()) {
                   String cadena = "ID: "+rs.getInt("id") + " Nombre: " + rs.getString("nombre") + " Sigla: " + rs.getString("sigla") + " idcarrera: " + rs.getInt("idcarrera") +  " idhorario: " + rs.getInt("idhorario") + " estado: " + rs.getString("estado") +"\n";
                
                lista.add(cadena);
            }
            return lista;
        } catch (Exception ex) {
            System.err.println("Lista De Modulos: " + ex.getMessage());
            return new ArrayList<>();
        }
    }
}
