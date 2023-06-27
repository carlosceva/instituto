/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tecnogrupo04sa;

import tecnogrupo04sa.Presentacion.Comunication;

/**
 *
 * @author CEVA
 */
public class TecnoGrupo04sa {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Comunication c = new Comunication();
        while (true) {
                c.waitMessages();
                System.out.println("Esperando e-mail....");
        }
    }
    
}
