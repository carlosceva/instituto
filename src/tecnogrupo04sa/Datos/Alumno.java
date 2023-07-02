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
 
public class Alumno {
    public int id;
    public String nombre;
    public String fechanac;
    public String sexo;
    public String email;
    public int telefono;
    public int idcarrera;
    public String estado;
    public Alumno(){
    }
     public int registrar() {
        String sql ="INSERT INTO alumnos  (id, nombre, fechanac, sexo,email,telefono,idcarrera,estado) VALUES (?,?,?,?,?,?,?,?)";
        return DBConection.getConexion().registrar("alumnos", sql, id, nombre, fechanac, sexo,email,telefono,idcarrera,estado );
    }

    public int eliminar() {
        String sql = "DELETE FROM alumnos WHERE id=?";
        return DBConection.getConexion().eliminar(sql, id);
    }

    public int modificar() {
        String sql = "UPDATE alumnos set id=?, nombre=?, fechanac=?, sexo=? , email=? , telefono=? , idcarrera=? , estado=? WHERE id=?";
        return DBConection.getConexion().modificar(sql, id, nombre, fechanac, sexo,email,telefono,idcarrera,estado,id);
    }
    
    public ArrayList<String> listar() {
        String sql = "SELECT  FROM alumnos";
        ResultSet rs = DBConection.getConexion().listar(sql);
        try {
            ArrayList<String> lista = new ArrayList();
            while (rs.next()) {
                String cadena = "ID "+rs.getInt(id) + " Nombre"  + rs.getString(nombre) +  "Fechanacimiento"  + rs.getString(fechanac) +  "Sexo " + rs.getString(sexo) + " Email " + rs.getString(email) +  " telefono " + rs.getInt(telefono) + " Idcarrera " + rs.getInt(idcarrera)+ " estado"  + rs.getString(estado) +"\n";
                lista.add(cadena);
            }
            return lista;
        } catch (Exception ex) {
            System.err.println("Lista de alumnos " + ex.getMessage());
            return new ArrayList();
        }
    }
}
