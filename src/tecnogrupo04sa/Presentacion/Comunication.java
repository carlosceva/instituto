/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tecnogrupo04sa.Presentacion;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.mail.Address;
import javax.mail.BodyPart;
import javax.mail.Flags;
import javax.mail.Message;
import javax.mail.Multipart;
import tecnogrupo04sa.Datos.Cita;
import tecnogrupo04sa.Datos.Diagnostico;
import tecnogrupo04sa.Datos.Doctor;
import tecnogrupo04sa.Datos.Empleado;
import tecnogrupo04sa.Datos.Especialidad;
import tecnogrupo04sa.Datos.Historial;
import tecnogrupo04sa.Datos.Horario;
import tecnogrupo04sa.Datos.Paciente;
import tecnogrupo04sa.Datos.Receta;
import tecnogrupo04sa.Datos.Servicio;
import tecnogrupo04sa.Datos.Tratamiento;
import tecnogrupo04sa.Datos.Estadisticas_cn;

import tecnogrupo04sa.Datos.Carrera;
import tecnogrupo04sa.Datos.Docente;
import tecnogrupo04sa.Datos.Usuario;

/**
 *
 * @author CEVA
 */
public class Comunication {
    List<Integer> ListMessageId;
    Paciente paciente;
    Doctor doctor;
    Especialidad especialidad;
    Servicio servicio;
    Cita cita;
    Diagnostico diagnostico;
    Historial historial;
    Receta receta;
    Tratamiento tratamiento;
    Estadisticas_cn estadistica;
    Empleado empleado;
    
    Carrera carrera;
    Docente docente;
    Horario horario;
    Usuario usuario;
    
    int nro = -1;
    public Comunication()
    {
        ListMessageId = new ArrayList<>();
        paciente = new Paciente();
        doctor = new Doctor();
        especialidad = new Especialidad();
        servicio = new Servicio();
        cita = new Cita();
        diagnostico = new Diagnostico();
        historial = new Historial();
        receta = new Receta();
        tratamiento = new Tratamiento();
        empleado = new Empleado();
        
        carrera = new Carrera();
        docente = new Docente();
        horario = new Horario();
        usuario = new Usuario();
    }
    
    
    public void waitMessages(){
        try {
            POP servidorInbox = new POP(Help.miCorreo, Help.miContraseña, Help.servidorSMTP);
            for (Message message : servidorInbox.messages) {
                boolean isMine = false;
                for (Address address : message.getFrom()) {
                    if (address.toString().equals(Help.miCorreo + Help.dominio)) {
                        isMine = true;
                    }
                }
                if ((!message.isSet(Flags.Flag.SEEN) || !message.isSet(Flags.Flag.ANSWERED)) && !isMine
                        && !ListMessageId.contains(message.getMessageNumber())) {

                    System.out.println("/***************************************/");
                    System.out.println("MessageNumber: " + message.getMessageNumber());
                    System.out.println("SENT DATE:" + message.getSentDate());
                    System.out.println("SUBJECT:" + message.getSubject());
                    if (message.isMimeType("multipart/*")) {
                        Object msgContent = message.getContent();
                        if (msgContent instanceof Multipart) {

                            Multipart multipart = (Multipart) msgContent;
                            System.out.println("CONTENT: ");

                            BodyPart bodyPart = multipart.getBodyPart(0);
                            System.out.println(bodyPart.getContent());

                            Analizar(message.getSubject(), bodyPart.getContent().toString(),
                                    message.getFrom()[0].toString());
                        }
                    } else if (message.isMimeType("text/plain")) {
                        System.out.println("CONTENT: " + message.getContent());

                        Analizar(message.getSubject(), message.getContent().toString(),
                                message.getFrom()[0].toString());
                    }
                    ListMessageId.add(message.getMessageNumber());
                    message.setFlag(Flags.Flag.SEEN, true);
                    message.setFlag(Flags.Flag.ANSWERED, true);
                }
            }
            if (servidorInbox.store != null) {
                servidorInbox.store.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private void Analizar(String sAsunto, String sMensaje, String sCorreo){
        String[] split = sAsunto.split(" ");
        System.out.println("-------------------" + sCorreo + " Correo Enviado------------------");
		try {
                    String[] lista;
                    switch (split[0]) {
                        //-----------------------USUARIO-----------------------
                        case"registrar_usuario":
                                lista = sMensaje.split(";");
                                usuario.id = Integer.valueOf(lista[0]);
                                usuario.nombre = lista[1];
                                usuario.email = lista[2];
                                usuario.rol = lista[3];
                                usuario.estado = lista[4];
                                usuario.registrar();
                                new SMTP(sCorreo, "Usuario Registrado Correctamente", sMensaje);
                            break;
                        case"modificar_usuario":
                                lista = sMensaje.split(";");
                                usuario.id = Integer.valueOf(lista[0]);
                                usuario.nombre = lista[1];
                                usuario.email = lista[2];
                                usuario.rol = lista[3];
                                usuario.estado = lista[4];
                                usuario.modificar();
                                new SMTP(sCorreo, "Usuario modificado correctamente", sMensaje);
                            break;
                        case"eliminar_usuario":
                                lista = sMensaje.split(";");
                                usuario.id = Integer.valueOf(lista[0]);
                                usuario.eliminar();
                                new SMTP(sCorreo, "Usuario Eliminado Correctamente", sMensaje);
                            break;
                        case"listar_usuarios":
                                new SMTP(sCorreo, "Listado de usuarios", usuario.listar().toString());
                            break;
                            
                        //----------------------Carrera--------------------
                        case"registrar_carrera":
                                lista = sMensaje.split(";");
                                carrera.id = Integer.valueOf(lista[0]);
                                carrera.nombrecarrera = lista[1];
                                carrera.siglacarrera = lista[2];
                                carrera.periodocarrera = Integer.valueOf(lista[3]);
                                carrera.estadocarrera = lista[4];
                                carrera.registrar();
                                new SMTP(sCorreo, "Carrera registrada correctamente", sMensaje);
                            break;
                        case"modificar_carrera":
                                lista = sMensaje.split(";");
                                carrera.id = Integer.valueOf(lista[0]);
                                carrera.nombrecarrera = lista[1];
                                carrera.siglacarrera = lista[2];
                                carrera.periodocarrera = Integer.valueOf(lista[3]);
                                carrera.estadocarrera = lista[4];
                                carrera.modificar();
                                new SMTP(sCorreo, "Carrera modificada correctamente", sMensaje);
                            break;
                        case"eliminar_carrera":
                                lista = sMensaje.split(";");
                                carrera.id = Integer.valueOf(lista[0]);
                                System.out.println("El id a eliminar es el: " + carrera.id);
                                carrera.eliminar();
                                new SMTP(sCorreo, "Carrera Eliminada Correctamente", sMensaje);
                            break;
                        case"listar_carreras":
                                new SMTP(sCorreo, "Listado de carreras", carrera.listar().toString());
                            break;
                        //-----------------------Docente-----------------------    
                        case"registrar_docente":
                                lista = sMensaje.split(";");
                                docente.id = Integer.valueOf(lista[0]);
                                docente.nombre = lista[1];
                                docente.email=lista[2];
                                docente.telefono = Integer.valueOf(lista[3]);
                                docente.especialidad=lista[4];
                                docente.estado=lista[5];
                                docente.registrar();
                                new SMTP(sCorreo, "Docente registrado correctamente", sMensaje);
                            break;
                        case"modificar_docente":
                                lista = sMensaje.split(";");
                                docente.id = Integer.valueOf(lista[0]);
                                docente.nombre = lista[1];
                                docente.email=lista[2];
                                docente.telefono = Integer.valueOf(lista[3]);
                                docente.especialidad=lista[4];
                                docente.estado=lista[5];
                                docente.modificar();
                                new SMTP(sCorreo, "Docente modificado correctamente", sMensaje);
                            break;
                        case"eliminar_docente":
                                lista = sMensaje.split(";");
                                docente.id = Integer.valueOf(lista[0]);
                                docente.eliminar();
                                new SMTP(sCorreo, "Docente Eliminado Correctamente", sMensaje);
                            break;
                        case"listar_docentes":
                                new SMTP(sCorreo, "Listado de docentes", docente.listar().toString());
                            break;
                        //------------------------HORARIOS-----------------------    
                        case "registrar_horario":
                                lista=sMensaje.split(";");
                                horario.id=Integer.valueOf(lista[0]);
                                horario.horainicio=lista[1];
                                horario.horafin=lista[2];
                                horario.turno=lista[3];
                                horario.estado=lista[4];
                                horario.registrar();
                            new SMTP(sCorreo, "Horario registrado correctamente", sMensaje);
                            break;
                        case "modificar_horario":
                                lista=sMensaje.split(";");
                                horario.id=Integer.valueOf(lista[0]);
                                horario.horainicio=lista[1];
                                horario.horafin=lista[2];
                                horario.turno=lista[3];
                                horario.estado=lista[4];
                                horario.modificar();
                            new SMTP(sCorreo, "Horario modificado correctamente", sMensaje);
                            break;
                        case"eliminar_horario":
                                lista = sMensaje.split(";");
                                horario.id = Integer.valueOf(lista[0]);
                                horario.eliminar();
                                new SMTP(sCorreo, "Horario Eliminado Correctamente", sMensaje);
                            break;
                        case"listar_horarios":
                                new SMTP(sCorreo, "Listado de Horarios Correctamente", horario.listar().toString());
                            break;
                        //----------------------ESTADISTICAS-------------------- 
                            case"porcentaje_pacientes":
                                new SMTP(sCorreo, "Lista de reporte", Estadistica_1());
                            break; 
                            
                            case"frecuencia_servicios":
                                new SMTP(sCorreo, "Lista de reporte", Estadistica_2());
                            break;
                              
                        //------------------------DEFAULT-----------------------    
			default:
                            new SMTP(sCorreo, "Correo de Ayuda", Help.UserSupport);
                            break;  
			}
		} catch (Exception ex) {
                    new SMTP(sCorreo, "Correo de Ayuda", Help.UserSupport);
		}
                //Ciclo para borrar mensajes
                            /*nro = getMessageCount();
                            System.out.println("Nro Mensajes: " + nro);
                            for (int i = 1; i <= nro; i++) {
                                System.out.println("Procediendo a eliminar mensajes...");
                                eliminar(Integer.toString(i));
                            }*/
    }
    
    private String Estadistica_1() throws SQLException {
        Estadisticas_cn re = new Estadisticas_cn();
        return re.PorcentajePacienteHyM();
    }
    
    private String Estadistica_2() throws SQLException {
        Estadisticas_cn re = new Estadisticas_cn();
        return re.frecPacientesXservicio();
    }
    
    public static void eliminar(String index) {
    comandoPOP3 client = new comandoPOP3();
    client.eliminar(index);
  }
    public static int getMessageCount() {
    comandoPOP3 client = new comandoPOP3();
    String data = client.listar();
    String number = "0";

    if (!data.isEmpty()) {
      data = data.split("\n")[4];
      int index = 4;
      while (data.charAt(index) != ' ') {
        number += data.charAt(index);
        index++;
      }
    }
    return Integer.parseInt(number);
  }
}
