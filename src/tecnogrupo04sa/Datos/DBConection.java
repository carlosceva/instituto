/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tecnogrupo04sa.Datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Date;
import javax.swing.JOptionPane;
import tecnogrupo04sa.Presentacion.SMTP;

/**
 *
 * @author CEVA
 */
public class DBConection {
    private static DBConection instancia = null;
    
    private final String usuario="grupo05sa";
    private final String contrasenia="grup005grup005";
    private final String bd="db_grupo05sa";
    private final String host="mail.tecnoweb.org.bo";
    private final String puerto="5432";
    private final String url;
    private Statement sentencia = null; 
    private Connection conexion = null;
    
    public DBConection(){
        url = "jdbc:postgresql://"+host+":"+puerto+"/"+bd;
        Boolean error = false;
        try {
            Class.forName("org.postgresql.Driver");
            conexion = DriverManager.getConnection(url, usuario, contrasenia);
            if (conexion != null) 
                sentencia = conexion.createStatement();
            else
                error = true;
        } catch (Exception ex) {
            error = true;
        }finally{
            if (error)
                System.err.println("<Bd> No se logró conectar con el servidor "
                        + "de base de datos");
            else
                System.out.println("Conexión exitosa con: "+ url);
        }
    }
    
    private static void crearInstancia(){
        synchronized(DBConection.class){
            if (instancia == null){
                instancia = new DBConection();
            }
        }
    }
    
    public static DBConection getConexion(){
        if (instancia == null) crearInstancia();
        return instancia;
    }
    
    @Override
    public Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }
           
    public ResultSet listar(String sql){
        try {
            ResultSet res =  sentencia.executeQuery(sql);
            System.out.println("<Bd> " + sql);
            return res;
        } catch (Exception ex) {
            System.err.println("<Bd> Hubo un problema al ejecutar una consulta");
            System.err.println("<Bd> CONSULTA: " + sql);
            System.err.println("<Bd> " + ex.getMessage());
            return null;
        }       
    }
    
    private int ejecutarConsulta(String sql, Object... valores){
        PreparedStatement ps = null;
        try {
            ps = conexion.prepareStatement(sql);
            for (int i = 0; i < valores.length; i++) {
                if ( valores[i] instanceof Integer) {
                    ps.setInt(i + 1, (int) valores[i]);
                }else{
                    ps.setObject(i + 1, valores[i]);
                }
            }
            System.out.println("<Bd> " + ps.toString());
            int res = ps.executeUpdate();
            return res;
        } catch (SQLException ex) {
            System.out.println("<Bd> Hubo un problema al ejecutar una consulta");
            if (ps !=null) System.out.println("<Bd> CONSULTA: " + ps.toString());
            System.out.println("<Bd> " + ex.getMessage());
            return -1;
        }
    }
    
    public int registrar(String tabla,String sql, Object... valores){
        try {
            int res = ejecutarConsulta(sql, valores);
            if (res <= 0) {
                System.out.println("No se ha ejecutado la consulta");
                return res;
            }
            
            ResultSet rs = listar("SELECT id FROM " + tabla +" ORDER BY id DESC limit 1");
            if (rs == null) return -1;
            int idNuevo = 0;
            while(rs.next()){
                idNuevo  = rs.getInt("id");
            }    
            System.out.println("Inserción en "+ tabla +" id: " + idNuevo);
            return idNuevo;
        } catch (Exception ex) {
            System.out.println("<Bd.insert> " + ex.getMessage());
            return -1;
        }
    }
    
    public int modificar(String sql, Object... valores){
        return ejecutarConsulta(sql, valores);
    }    
    
    public int eliminar(String sql, Object... valores){
        return ejecutarConsulta(sql, valores);
    }
    
    public String PorcentajesDePacientesXsexo() throws SQLException {
        String Resultado = "";
        int total = 0;
        ResultSet re = sentencia.executeQuery("SELECT  count(*) as total  FROM paciente;");
        try {
            while (re.next()) {
                total = re.getInt("total");
            }
        } catch (Exception e) {
        }
        ResultSet rs = sentencia.executeQuery("SELECT  sexo,count(*) as cant\n"
                + "  FROM paciente \n"
                + "  group by sexo\n"
                + "  order by 2 desc; ");
        try {
            Resultado += "Nro ,    Sexo ,    Cantidad, Porcentaje<br>";
            int nro = 1;
            float porcentaje = 0.00f;
            while (rs.next()) {
                String aux = "";

                String sexo = rs.getString("sexo");
                int cant = rs.getInt("cant");
                porcentaje = (float) (cant * 100) / total;
                aux = nro + " , " + sexo + " , " + cant + " , " + String.format("%.2f", porcentaje) + "<br>\n";
                nro++;
                Resultado = Resultado + "\n" + aux;

            }
            Resultado = Resultado + "Total Paciente ===> " + total + "<br>";
            //conex.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return Resultado;
    }
    
     public String frecuPacientesXServicio() throws SQLException {

        String Resultado = "";
        int total = 0;
        ResultSet re = sentencia.executeQuery("SELECT  count(*) as total\n"
                + "  FROM  cita ");
        try {
            while (re.next()) {
                total = re.getInt("total");
            }
        } catch (Exception e) {
        }
        ResultSet rs = sentencia.executeQuery("SELECT i.codigo_ser, c.nombre,  p.fecha,count(*)as nro_paciente\n"
                + "  FROM servicio c,cita i,horario p\n"
                + "  where  c.id_ser=i.codigo_ser and p.id_hora=i.codigo_hora\n"
                + "  group by i.codigo_ser,c.nombre,p.fecha\n"
                + "  order by nro_paciente desc;");
        try {
            Resultado += "Nro ,    Curso ,  Nombre,  Cantidad, Porcentaje<br>";
            int nro = 1;
            float porcentaje = 0.00f;
            while (rs.next()) {
                String aux = "";

                int cursocod = rs.getInt("codigo_ser");
                String nombre = rs.getString("nombre");
                String anio = rs.getString("fecha");
                int cant = rs.getInt("nro_estudiante");
                porcentaje = (float) (cant * 100) / total;
                aux = nro + " , " + cursocod + " , " + nombre + " , " + anio + " , " + String.format("%.2f", porcentaje) + "<br>\n";
                nro++;
                Resultado = Resultado + "\n" + aux;

            }
            Resultado = Resultado + "Total Paciente ===> " + total + "<br>";
            //conex.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return Resultado;
    }
    
   
}
