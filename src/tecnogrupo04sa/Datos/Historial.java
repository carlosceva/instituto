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
public class Historial {
    public int id_his;
    public int codigo_tra;
    public String fecha;
    
    public Historial() {
    }
    
    public int registrar() {
        String sql = "INSERT INTO historial (id_his, codigo_tra, fecha) VALUES (?,?,?);";
        return DBConection.getConexion().registrar("historial", sql, id_his, codigo_tra, fecha);
    }

    public int eliminar() {
        String sql = "DELETE FROM historial WHERE id_his=?";
        return DBConection.getConexion().eliminar(sql, id_his);
    }

    public int modificar() {
        String sql = "UPDATE historial set id_his=?, codigo_tra=?, fecha=? WHERE id_his=?";
        return DBConection.getConexion().modificar(sql, id_his, codigo_tra, fecha, id_his);
    }
    
    public ArrayList<String> listar() {
        String sql = "select id_his,id_cita,paciente.ci,paciente.nombre,tratamiento.observacion,historial.fecha from historial,tratamiento,diagnostico,cita,paciente where historial.codigo_tra=tratamiento.id_tra and diagnostico.id_diag=tratamiento.codigo_diag and diagnostico.codigo_cita=cita.id_cita and paciente.ci=cita.codigo_pa order by(paciente.ci)";
        ResultSet rs = DBConection.getConexion().listar(sql);
        try {
            ArrayList<String> lista = new ArrayList<>();
            while (rs.next()) {
                String cadena = "Cod Paciente: "+rs.getInt("ci")+"; "+ " Codigo historico: "+ rs.getInt("id_his")+"\n "+"Paciente: "+rs.getString("nombre")+"\n "+" observacion: " + rs.getString("observacion")+"\n "+" fecha: " + rs.getString("fecha") + "\n";
                lista.add(cadena);
            }
            return lista;
        } catch (Exception ex) {
            System.err.println("Lista de historial " + ex.getMessage());
            return new ArrayList<>();
        }
    }
}
