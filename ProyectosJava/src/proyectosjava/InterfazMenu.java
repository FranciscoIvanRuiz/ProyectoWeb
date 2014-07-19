/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package proyectosjava;

import BaseDatos.Sql;
import Controladores.CentrosDeCostosControl;
import Controladores.EmpresaControl;
import Vistas.CentrosDeCostos;
import Vistas.Empresa;
import javax.swing.JInternalFrame;

/**
 *
 * @author ivanruiz
 */
public class InterfazMenu extends javax.swing.JFrame {
    
    /* Debemos definir en esta parte todas las pantallas que vamos a utilizar */
    private Empresa Empr;
    private EmpresaControl EmprCont=  new EmpresaControl();
    
    private CentrosDeCostos Cenc;
    private CentrosDeCostosControl CencCont=  new CentrosDeCostosControl();
    
    
    /* Fin Debemos definir en esta parte todas las pantallas que vamos a utilizar */
    
    private Sql mySql = new Sql();
    


    /**
     * Creates new form InterfazMenu
     */
    public InterfazMenu() {
        initComponents();
         this.setTitle("Sistema Financiero Contable");
        //formulario al centro de la pantalla
        this.setLocationRelativeTo(null);
       // panel.setBorder(new ImagenFondo());
    }
    
    
      private boolean EstaCerrado(Object obj){
        JInternalFrame[] activos=panel.getAllFrames();
        boolean cerrado=true;
        int i=0;
        while (i<activos.length && cerrado){
            if(activos[i]==obj){
		cerrado=false;
            }
            i++;
        }
    return cerrado;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        panel = new javax.swing.JDesktopPane();
        jToolBar1 = new javax.swing.JToolBar();
        jButtonnuevo = new javax.swing.JButton();
        jButtongrabar = new javax.swing.JButton();
        jButtoneliminar = new javax.swing.JButton();
        jButtonimprimir = new javax.swing.JButton();
        jButtonanterior = new javax.swing.JButton();
        siguiente = new javax.swing.JButton();
        jButtonbuscar = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();

        jMenu3.setText("File");
        jMenuBar2.add(jMenu3);

        jMenu4.setText("Edit");
        jMenuBar2.add(jMenu4);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jToolBar1.setRollover(true);

        jButtonnuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconosSistema/New file.png"))); // NOI18N
        jButtonnuevo.setText("Nuevo");
        jButtonnuevo.setFocusable(false);
        jButtonnuevo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonnuevo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonnuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonnuevoActionPerformed(evt);
            }
        });
        jToolBar1.add(jButtonnuevo);

        jButtongrabar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconosSistema/Save all.png"))); // NOI18N
        jButtongrabar.setText("Grabar");
        jButtongrabar.setFocusable(false);
        jButtongrabar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtongrabar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtongrabar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtongrabarActionPerformed(evt);
            }
        });
        jToolBar1.add(jButtongrabar);

        jButtoneliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconosSistema/Delete.png"))); // NOI18N
        jButtoneliminar.setText("Eliminar");
        jButtoneliminar.setFocusable(false);
        jButtoneliminar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtoneliminar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jButtoneliminar);

        jButtonimprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconosSistema/Print.png"))); // NOI18N
        jButtonimprimir.setText("Imprimir");
        jButtonimprimir.setFocusable(false);
        jButtonimprimir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonimprimir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jButtonimprimir);

        jButtonanterior.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconosSistema/Back.png"))); // NOI18N
        jButtonanterior.setText("Anterior");
        jButtonanterior.setFocusable(false);
        jButtonanterior.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonanterior.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonanterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonanteriorActionPerformed(evt);
            }
        });
        jToolBar1.add(jButtonanterior);

        siguiente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconosSistema/Forward.png"))); // NOI18N
        siguiente.setText("Siguiente");
        siguiente.setFocusable(false);
        siguiente.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        siguiente.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        siguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                siguienteActionPerformed(evt);
            }
        });
        jToolBar1.add(siguiente);

        jButtonbuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconosSistema/Find.png"))); // NOI18N
        jButtonbuscar.setText("Buscar");
        jButtonbuscar.setFocusable(false);
        jButtonbuscar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonbuscar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonbuscarActionPerformed(evt);
            }
        });
        jToolBar1.add(jButtonbuscar);

        jMenu1.setText("Empresa ");

        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconosSistema/Designer.png"))); // NOI18N
        jMenuItem1.setText("Selecionar Empresa");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconosSistema/Home.png"))); // NOI18N
        jMenuItem2.setText("Crear Empresa");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconosSistema/Diagram.png"))); // NOI18N
        jMenuItem4.setText("Crear Centros De Costos");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem4);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Personas");

        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconosSistema/Work area.png"))); // NOI18N
        jMenuItem3.setText("Crear Personas");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem3);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 743, Short.MAX_VALUE)
            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, 743, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, 337, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        
         if(EstaCerrado(Empr)){
            Empr = new Empresa();
            panel.add(Empr);
            Empr.show();
        }
        else{
            //JOptionPane.showMessageDialog(this,"Error: La ventana ya esta abierta...");
        }

    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jButtonanteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonanteriorActionPerformed
        // TODO add your handling code here:
         JInternalFrame selectedFrame = panel.getSelectedFrame();
        
        /*para cada ventana poner el evento*/
        if(selectedFrame instanceof Empresa){Empr.EventoAnterior();}
        if(selectedFrame instanceof CentrosDeCostos){Cenc.EventoAnterior();}
        /*fin para cada ventana poner el evento*/
    }//GEN-LAST:event_jButtonanteriorActionPerformed

    private void siguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_siguienteActionPerformed
 JInternalFrame selectedFrame = panel.getSelectedFrame();
        
        /*para cada ventana poner el evento*/
        if(selectedFrame instanceof Empresa){Empr.EventoSiguiente();}
        if(selectedFrame instanceof CentrosDeCostos){Cenc.EventoSiguiente();}
        /*fin para cada ventana poner el evento*/        // TODO add your handling code here:
    }//GEN-LAST:event_siguienteActionPerformed

    private void jButtonbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonbuscarActionPerformed
        // TODO add your handling code here:
         JInternalFrame selectedFrame = panel.getSelectedFrame();
        
        /*para cada ventana poner el evento*/
        if(selectedFrame instanceof Empresa){Empr.EventoBuscar();}
        if(selectedFrame instanceof CentrosDeCostos){Cenc.EventoBuscar();}
        /*fin para cada ventana poner el evento*/
    }//GEN-LAST:event_jButtonbuscarActionPerformed

    private void jButtonnuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonnuevoActionPerformed
        // TODO add your handling code here:
        JInternalFrame selectedFrame = panel.getSelectedFrame();
        
        /*para cada ventana poner el evento*/
        if(selectedFrame instanceof Empresa){Empr.EventoNuevo();}
        if(selectedFrame instanceof CentrosDeCostos){Cenc.EventoNuevo();}
        /*fin para cada ventana poner el evento*/
        
    }//GEN-LAST:event_jButtonnuevoActionPerformed

    private void jButtongrabarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtongrabarActionPerformed
        // TODO add your handling code here:
         JInternalFrame selectedFrame = panel.getSelectedFrame();
        
        /*para cada ventana poner el evento*/
        if(selectedFrame instanceof Empresa){Empr.EventoGrabar();}
        if(selectedFrame instanceof CentrosDeCostos){Cenc.EventoGrabar();}
        /*fin para cada ventana poner el evento*/
    }//GEN-LAST:event_jButtongrabarActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
        
        if(EstaCerrado(Cenc)){
            Cenc = new CentrosDeCostos();
            panel.add(Cenc);
            Cenc.show();
        }
        else{
            //JOptionPane.showMessageDialog(this,"Error: La ventana ya esta abierta...");
        }
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(InterfazMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterfazMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterfazMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterfazMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InterfazMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonanterior;
    private javax.swing.JButton jButtonbuscar;
    private javax.swing.JButton jButtoneliminar;
    private javax.swing.JButton jButtongrabar;
    private javax.swing.JButton jButtonimprimir;
    private javax.swing.JButton jButtonnuevo;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JDesktopPane panel;
    private javax.swing.JButton siguiente;
    // End of variables declaration//GEN-END:variables
}
