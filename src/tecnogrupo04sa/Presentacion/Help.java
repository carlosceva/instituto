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
			+ " --------------USUARIOS-------------- "+ "\n"
                        + "registrar_usuario"+ "\n"
                        + "ID;NOMBRE;EMAIL;ROL;ESTADO;" + "\n" 
                        + "\n"
			+ "modificar_usuario"+ "\n"
                        + "ID;NOMBRE;EMAIL;ROL;ESTADO;" + "\n" 
                        + "\n"
                        + "eliminar_usuario" + "\n"
                        + "ID;" + "\n"
                        + "\n"
                        + "listar_usuarios" + "\n"
                        + "\n"
                        + "--------------Carreras--------------"+ "\n"
                        + "registrar_carrera" + "\n"
                        + "Id;Nombre_Carrera;Sigla_Carrera;Periodo_Carrera;estado_carrera" + "\n"
                        + "\n"
                        + "modificar_carrera" + "\n"
                        + "Id;Nombre_Carrera;Sigla_Carrera;Periodo_Carrera;" + "\n"
                        + "\n"
                        + "eliminar_carrera" + "\n"
                        + "ID;" + "\n"
                        + "\n"
                        + "listar_carreras" + "\n"
                        + "\n"
                        + "--------------Docentes--------------"+ "\n"
                        + "registrar_docente" + "\n"
                        + "Id;Nombre;Email;Telefono;Especialidad;Estado;" + "\n"
                        + "\n"
                        + "modificar_docente" + "\n"
                        + "Id;Nombre;Email;Telefono;Especialidad;Estado;" + "\n"
                        + "\n"
                        + "eliminar_docente" + "\n"
                        + "Id;" + "\n"
                        + "\n"
                        + "listar_docentes" + "\n"
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
                        + "listar_horarios" + "\n"
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
