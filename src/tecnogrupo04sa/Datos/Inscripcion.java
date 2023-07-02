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
public class Inscripcion {
    public int id;
    public int idalumno;
    public int idmodulo;
    public int idusuario;
    public String fecha;
    public int idoferta;
    public String estado;
    
    public Inscripcion(){
    
    }
    
    public int registrar() {
        String sql = "INSERT INTO inscripciones (id, idalumno, idmodulo, idusuario, fecha, idoferta, estado) VALUES (?,?,?,?,?,?,?);";
        return DBConection.getConexion().registrar("inscripciones", sql, id, idalumno, idmodulo, idusuario, fecha, idoferta, estado);
    }

    public int eliminar() {
        String sql = "DELETE FROM inscripciones WHERE id=?";
        return DBConection.getConexion().eliminar(sql, id);
    }

    public int modificar() {
        String sql = "UPDATE inscripciones set id=?, idalumno=?, idmodulo=?, idusuario=?, fecha=?, idoferta=?, estado=? WHERE id=?";
        return DBConection.getConexion().modificar(sql, id, idalumno, idmodulo, idusuario, fecha, idoferta, estado, id);
    }
    
    public ArrayList<String> listar() {
        String sql = "SELECT * FROM inscripciones";
        ResultSet rs = DBConection.getConexion().listar(sql);
        try {
            ArrayList<String> lista = new ArrayList<>();
            while (rs.next()) {
                String cadena = "ID: "+rs.getInt("id") + " ID alumno: " + rs.getInt("idalumno")+ " ID modulo " + rs.getInt("idmodulo")+ " ID usuario: " + rs.getInt("idusuario")+ " Fecha: " + rs.getString("fecha") + " ID oferta: " + rs.getInt("idoferta")+ " Estado: " + rs.getString("estado") + "\n";
                lista.add(cadena);
            }
            return lista;
        } catch (Exception ex) {
            System.err.println("Lista de inscripciones " + ex.getMessage());
            return new ArrayList<>();
        }
    }
    
}
