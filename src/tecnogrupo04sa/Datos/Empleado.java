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
public class Empleado {
    
    public int id_emp;
    public String nombre;
    public String apellido;
    public int telefono;
    public String cargo;
    
    public Empleado(){
    
    }
    
    public int registrar() {
        String sql = "INSERT INTO empleado (id_emp, nombre, apellido, telefono ,cargo) VALUES (?,?,?,?,?);";
        return DBConection.getConexion().registrar("empleado", sql, id_emp, nombre, apellido,telefono, cargo);
    }

    public int eliminar() {
        String sql = "DELETE FROM empleado WHERE id_emp=?";
        return DBConection.getConexion().eliminar(sql, id_emp);
    }

    public int modificar() {
        String sql = "UPDATE empleado set ci=?, nombre=?, apellido=?, telefono=? , cargo=?  WHERE ci=?";
        return DBConection.getConexion().modificar(sql, id_emp, nombre, apellido, telefono,cargo, id_emp);
    }
    
    public ArrayList<String> listar() {
        String sql = "SELECT * FROM empleado";
        ResultSet rs = DBConection.getConexion().listar(sql);
        try {
            ArrayList<String> lista = new ArrayList<>();
            while (rs.next()) {
                String cadena = rs.getInt("id_emp") + "  " + rs.getString("nombre") + "  " + rs.getString("apellido") +  rs.getInt("telefono") + "  " +rs.getString("cargo") + "\n";
                lista.add(cadena);
            }
            return lista;
        } catch (Exception ex) {
            System.err.println("Lista De Empleados: " + ex.getMessage());
            return new ArrayList<>();
        }
    }
    
}
