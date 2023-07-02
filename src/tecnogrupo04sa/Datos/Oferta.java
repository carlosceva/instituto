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
public class Oferta {
    public int id;
    public int idcarrera;
    public int idmodulo;
    public int iddocente;
    public String fechainicio;
    public String fechafin;
    public String estado;
    
    public Oferta(){
    
    }
    
    public int registrar() {
        String sql = "INSERT INTO ofertas (id, idcarrera, idmodulo, iddocente, fechainicio, fechafin, estado) VALUES (?,?,?,?,?,?,?);";
        return DBConection.getConexion().registrar("inscripciones", sql, id, idcarrera, idmodulo, iddocente, fechainicio, fechafin, estado);
    }

    public int eliminar() {
        String sql = "DELETE FROM ofertas WHERE id=?";
        return DBConection.getConexion().eliminar(sql,id);
    }

    public int modificar() {
        String sql = "UPDATE ofertas set id=?, idcarrera=?, idmodulo=?, iddocente=?, fechainicio=?, fechafin=?, estado=? WHERE id=?";
        return DBConection.getConexion().modificar(sql, id, idcarrera, idmodulo, iddocente, fechainicio, fechafin, estado, id);
    }
    
    public ArrayList<String> listar() {
        String sql = "SELECT * FROM ofertas";
        ResultSet rs = DBConection.getConexion().listar(sql);
        try {
            ArrayList<String> lista = new ArrayList<>();
            while (rs.next()) {
                String cadena = "ID: "+rs.getInt("id") + " ID carrera: " + rs.getInt("idcarrera")+ " ID modulo " + rs.getInt("idmodulo")+ " ID docente: " + rs.getInt("iddocente")+ " Fecha inicio: " + rs.getString("fecha") + " Fecha fin: " + rs.getString("fechafin")+ " Estado: " + rs.getString("estado") + "\n";
                lista.add(cadena);
            }
            return lista;
        } catch (Exception ex) {
            System.err.println("Lista de ofertas " + ex.getMessage());
            return new ArrayList<>();
        }
    }
    
}
