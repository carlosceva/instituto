/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tecnogrupo04sa.Presentacion;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 *
 * @author ceva
 */
public class comandoPOP3 {
      private String servidor;
  private String usuario;
  private String password;
  private String comando;
  private int puerto;

  private Socket socket;
  private BufferedReader entrada;
  private DataOutputStream salida;

  public comandoPOP3(String servidor, String usuario, String password) {
    this.servidor = servidor;
    this.usuario = usuario;
    this.password = password;
    this.comando = "";
    this.puerto = 110;

    this.socket = null;
    this.entrada = null;
    this.salida = null;
  }

  public comandoPOP3() {
    this("mail.tecnoweb.org.bo", "grupo05sa", "grup005grup005");
  }

  private void connect() {
    try {
      socket = new Socket(servidor, puerto);
      entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
      salida = new DataOutputStream(socket.getOutputStream());
    } catch (UnknownHostException e) {
      System.out.println("No se pudo conectar con el servidor indicado");
    } catch (IOException e) {
      System.out.println("Error I/O");
    }
  }

  private boolean login() {
    boolean status = true;
    try {
      comando = "USER " + usuario + "\r\n";
      salida.writeBytes(comando);
      comando = "PASS " + password + "\r\n";
      salida.writeBytes(comando);
    } catch (UnknownHostException e) {
      System.out.println("No se pudo conectar con el servidor indicado");
      status = false;
    } catch (IOException e) {
      System.out.println("Error I/O");
      status = false;
    }
    return status;
  }

  private boolean isConnected() {
    return socket != null && entrada != null && salida != null;
  }

  public String listar() {
    connect();
    String message = (isConnected() && login()) ? list() : "";
    quit();
    return message;
  }

  public String leer(String index) {
    connect();
    String message = (isConnected() && login()) ? retr(index) : "";
    quit();
    return message;
  }

  public void eliminar(String index) {
    connect();
    if (isConnected() && login()) {
      dele(index);
        System.out.println("Eliminado correctamente!");
    }
    quit();
  }

  private String list() {
    String data = "";
    try {
      comando = "LIST \r\n";
      salida.writeBytes(comando);
      data = getMultiline(entrada);
    } catch (UnknownHostException e) {
      System.out.println("No se pudo conectar con el servidor indicado");
    } catch (IOException e) {
      System.out.println("Error I/O");
    }
    return data;
  }

  private String retr(String index) {
    String data = "";
    try {
      comando = "RETR " + index + "\n";
      salida.writeBytes(comando);
      data = getMultiline(entrada);
    } catch (UnknownHostException e) {
      System.out.println("No se pudo conectar con el servidor indicado");
    } catch (IOException e) {
      System.out.println("Error I/O");
    }
    return data;
  }

  private boolean dele(String index) {
    boolean status = true;
    try {
      comando = "DELE " + index + "\r\n";
      salida.writeBytes(comando);
    } catch (UnknownHostException e) {
      System.out.println("No se pudo conectar con el servidor indicado");
      status = false;
    } catch (IOException e) {
      System.out.println("Error I/O");
      status = false;
    }
    try {
      Thread.sleep(5500);
    } catch (Exception e) {
    }

    return status;
  }

  private boolean quit() {
    boolean status = true;
    if (salida != null) {
      try {
        comando = "QUIT\r\n";
        salida.writeBytes(comando);
      } catch (UnknownHostException e) {
        System.out.println("No se pudo conectar con el servidor indicado");
        status = false;
      } catch (IOException e) {
        System.out.println("Error I/O");
        status = false;
      }
    }    
    return status;
  }

  private String getMultiline(BufferedReader in) throws IOException {
    String lines = "";
    while (true) {
      String line = in.readLine();
      if (line == null) {
        throw new IOException(" S : Server unawares closed the connection.");
      }
      if (line.equals(".")) {
        break;
      }
      if ((line.length() > 0) && (line.charAt(0) == '.')) {
        line = line.substring(1);
      }
      lines = lines + "\n" + line;
    }
    return lines;
  }
    
}
