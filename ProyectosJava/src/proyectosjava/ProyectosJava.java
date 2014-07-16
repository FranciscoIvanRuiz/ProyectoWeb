/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package proyectosjava;

import Vistas.Empresa;
import Vistas.Ingreso;
import javax.swing.UIManager;

/**
 * Clase principal donde arranca el proyecto
 * @author fruiz
 */
public class ProyectosJava {
    
    /* Debemos definir en esta parte todas las pantallas que vamos a utilizar */
    private Empresa Empr;
    /* Fin Debemos definir en esta parte todas las pantallas que vamos a utilizar */
     
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       //  new Ingreso().setVisible(true);
        
        try {

            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (ClassNotFoundException ex) {
            //java.util.logging.Logger.getLogger(CelsiusConverter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            //java.util.logging.Logger.getLogger(CelsiusConverter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
           // java.util.logging.Logger.getLogger(CelsiusConverter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
           // java.util.logging.Logger.getLogger(CelsiusConverter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
         new InterfazMenu().setVisible(true);
    }
    
}
