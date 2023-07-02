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
 * @author Balu
 */
public class Nota {
     public int id;
    public int idalumno;
    public int idmodulo;
    public int nota ;
    public String fecha;
    public String estado;
    public Nota(){
    }
    
    public int registrar() {
        String sql = "INSERT INTO notas (id, idalumno, idmodulo,nota,fecha,estado) VALUES (?,?,?,?,?,?);";
        return DBConection.getConexion().registrar("carreras", sql, id, idalumno, idmodulo, nota,fecha,estado);
    }

    public int eliminar() {
        String sql = "DELETE FROM notas WHERE id=?";
        return DBConection.getConexion().eliminar(sql, id);
    }

    public int modificar() {
        String sql = "UPDATE notas set id=?, idalumno=?, idmodulo=?, nota=? ,fecha=? , estado=? WHERE id=?";
        return DBConection.getConexion().modificar(sql, id, idalumno, idmodulo, nota,fecha,estado,id);
    }
    
    public ArrayList<String> listar() {
        String sql = "SELECT * FROM notas";
        ResultSet rs = DBConection.getConexion().listar(sql);
        try {
            ArrayList<String> lista = new ArrayList<>();
            while (rs.next()) {
                String cadena = "ID: "+rs.getInt("id") + " idalumno: " + rs.getInt(idalumno) + " idmodulo : " + rs.getInt(idmodulo) + " Nota: " + rs.getInt(nota) +  " FECHA: " + rs.getInt(fecha)+ " estado: " + rs.getInt("estado") +"\n";
                lista.add(cadena);
            }
            return lista;
        } catch (Exception ex) {
            System.err.println("Lista de notas " + ex.getMessage());
            return new ArrayList<>();
        }
    }
}
