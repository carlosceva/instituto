/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tecnogrupo04sa.Presentacion;

/**
 *
 * @author CEVA
 */
public class Help {
    public static final String UserSupport = "-----------Menu de Ayuda-----------"+ "\n"
			+ " --------------USUARIOS balusiño-------------- "+ "\n"
                        + "registrar_paciente"+ "\n"
                        + "CI;NOMBRE;APELLIDO;SEXO;TELEFONO;DIRECCION;FECHA_NAC;" + "\n" 
                        + "\n"
			+ "modificar_paciente"+ "\n"
                        + "CI;NOMBRE;APELLIDO;SEXO;TELEFONO;DIRECCION;FECHA_NAC;" + "\n"
                        + "\n"
                        + "eliminar_paciente" + "\n"
                        + "CI;" + "\n"
                        + "\n"
                        + "listar_paciente" + "\n"
                        + "\n"
                        + "registrar_doctor"+ "\n"
                        + "CI;NOMBRE;APELLIDO;SEXO;TELEFONO;DIRECCION;FECHA_NAC;CODIGO_ESP;" + "\n" 
                        + "\n"
			+ "modificar_doctor"+ "\n"
                        + "CI;NOMBRE;APELLIDO;SEXO;TELEFONO;DIRECCION;FECHA_NAC;CODIGO_ESP;" + "\n"
                        + "\n"
                        + "eliminar_doctor" + "\n"
                        + "CI;" + "\n"
                        + "\n"
                        + "listar_doctor" + "\n"
                        + "\n"
                        + "registrar_empleado"+ "\n"
                        + "CI;NOMBRE;APELLIDO;TELEFONO;CARGO;" + "\n" 
                        + "\n"
			+ "modificar_empleado"+ "\n"
                        + "CI;NOMBRE;APELLIDO;TELEFONO;CARGO;" + "\n" 
                        + "\n"
                        + "eliminar_empleado" + "\n"
                        + "CI;" + "\n"
                        + "\n"
                        + "listar_empleado" + "\n"
                        + "\n"
                        + "--------------Carreras--------------"+ "\n"
                        + "registrar_carrera" + "\n"
                        + "Id;Nombre_Carrera;Sigla_Carrera;Periodo_Carrera;" + "\n"
                        + "\n"
                        + "modificar_carrera" + "\n"
                        + "Id;Nombre_Carrera;Sigla_Carrera;Periodo_Carrera;" + "\n"
                        + "\n"
                        + "eliminar_carrera" + "\n"
                        + "ID_ESP;" + "\n"
                        + "\n"
                        + "listar_carrera" + "\n"
                        + "\n"
                        + "--------------Docentes--------------"+ "\n"
                        + "registrar_docente" + "\n"
                        + "Id;Nombre;Email;Telefono;Especialidad;" + "\n"
                        + "\n"
                        + "modificar_docente" + "\n"
                        + "Id;Nombre;Email;Telefono;Especialidad;" + "\n"
                        + "\n"
                        + "eliminar_docente" + "\n"
                        + "Id;" + "\n"
                        + "\n"
                        + "listar_docente" + "\n"
                        + "\n"
                        + "--------------HORARIO--------------"+ "\n"
                        + "registrar_horario" + "\n"
                        + "ID_HORA;HORA;" + "\n"
                        + "\n"
                        + "modificar_horario" + "\n"
                        + "ID_HORA;HORA;" + "\n"
                        + "\n"
                        + "eliminar_horario" + "\n"
                        + "ID_HORA;" + "\n"
                        + "\n"
                        + "listar_horario" + "\n"
                        + "\n"
                        + "--------------CITA--------------"+ "\n"
                        + "registrar_cita" + "\n"
                        + "ID_CITA;CODIGO_PA;CODIGO_SER;CODIGO_HORA;FECHA;" + "\n"
                        + "\n"
                        + "modificar_cita" + "\n"
                        + "ID_CITA;CODIGO_PA;CODIGO_SER;CODIGO_HORA;FECHA;" + "\n"
                        + "\n"
                        + "eliminar_cita" + "\n"
                        + "ID_CITA;" + "\n"
                        + "\n"
                        + "listar_cita" + "\n"
                        + "\n"
                        + "--------------DIAGNOSTICO--------------"+ "\n"
                        + "registrar_diagnostico" + "\n"
                        + "ID_DIAG;CODIGO_CITA;CODIGO_DOC;DETALLE;" + "\n"
                        + "\n"
                        + "modificar_diagnostico" + "\n"
                        + "ID_DIAG;CODIGO_CITA;CODIGO_DOC;DETALLE;" + "\n"
                        + "\n"
                        + "eliminar_diagnostico" + "\n"
                        + "ID_DIAG;" + "\n"
                        + "\n"
                        + "listar_diagnostico" + "\n"
                        + "\n"
                        + "--------------HISTORIAL--------------"+ "\n"
                        + "registrar_historial" + "\n"
                        + "ID_HIS;CODIGO_TRA;FECHA;" + "\n"
                        + "\n"
                        + "modificar_historial" + "\n"
                        + "ID_HIS;CODIGO_TRA;FECHA;" + "\n"
                        + "\n"
                        + "eliminar_historial" + "\n"
                        + "ID_HIS;" + "\n"
                        + "\n"
                        + "listar_historial" + "\n"
                        + "\n"
                        + "--------------RECETA--------------"+ "\n"
                        + "registrar_receta" + "\n"
                        + "ID_REC;CODIGO_TRA;DETALLE;" + "\n"
                        + "\n"
                        + "modificar_receta" + "\n"
                        + "ID_REC;CODIGO_TRA;DETALLE;" + "\n"
                        + "\n"
                        + "eliminar_receta" + "\n"
                        + "ID_REC;" + "\n"
                        + "\n"
                        + "listar_receta" + "\n"
                        + "\n"
                        + "--------------TRATAMIENTO--------------"+ "\n"
                        + "registrar_tratamiento" + "\n"
                        + "ID_TRA;CODIGO_DIAG;FECHA_TRA;OBSERVACION;PROXIMA_CITA;" + "\n"
                        + "\n"
                        + "modificar_tratamiento" + "\n"
                        + "ID_TRA;CODIGO_DIAG;FECHA_TRA;OBSERVACION;PROXIMA_CITA;" + "\n"
                        + "\n"
                        + "eliminar_tratamiento" + "\n"
                        + "ID_TRA;" + "\n"
                        + "\n"
                        + "listar_tratamiento" + "\n"
                        + "\n"
                        + "-------------ESTADISTICAS DEL INSTITUTO----------------"+ "\n"
                        + "Porcentaje de pacientes por sexo" + "\n"
                        + "porcentaje_pacientes" + "\n"
                        + "\n"
                        + "Frecuencia de pacientes por servicio" + "\n"
                        + "frecuencia_servicios" + "\n"
                        + "\n"
                        ;
   
    
    public static final String miCorreo = "grupo05sa";
    public static final String miContraseña = "grup005grup005";
    public static final String servidorSMTP = "mail.tecnoweb.org.bo";
    public static final String puertoEnvio = "25";
    public static final String dominio = "@tecnoweb.org.bo";
}
