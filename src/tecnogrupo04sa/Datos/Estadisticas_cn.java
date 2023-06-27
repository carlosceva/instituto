/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tecnogrupo04sa.Datos;

import java.sql.SQLException;

/**
 *
 * @author Ronil
 */
public class Estadisticas_cn {

    DBConection estadisticas;

    public Estadisticas_cn() {
        estadisticas = new DBConection();
    }

    public String PorcentajePacienteHyM() throws SQLException {
        return estadisticas.PorcentajesDePacientesXsexo();
    }
    public String frecPacientesXservicio() throws SQLException {
        return estadisticas.frecuPacientesXServicio();
    }

   
}
