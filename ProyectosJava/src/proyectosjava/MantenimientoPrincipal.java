/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package proyectosjava;

/**
 *
 * @author fruiz
 */
public class MantenimientoPrincipal extends javax.swing.JInternalFrame {

    /**
     * Creates new form MantenimientoPrincipal
     */
    public MantenimientoPrincipal() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        jButtonnuevo = new javax.swing.JButton();
        jButtongrabar = new javax.swing.JButton();
        jButtoneliminar = new javax.swing.JButton();
        jButtonimprimir = new javax.swing.JButton();
        jButtonanterior = new javax.swing.JButton();
        siguiente = new javax.swing.JButton();
        jButtonbuscar = new javax.swing.JButton();

        jToolBar1.setRollover(true);

        jButtonnuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconosSistema/New file.png"))); // NOI18N
        jButtonnuevo.setText("Nuevo");
        jButtonnuevo.setFocusable(false);
        jButtonnuevo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonnuevo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jButtonnuevo);

        jButtongrabar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconosSistema/Save all.png"))); // NOI18N
        jButtongrabar.setText("Grabar");
        jButtongrabar.setFocusable(false);
        jButtongrabar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtongrabar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 561, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 211, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonanteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonanteriorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonanteriorActionPerformed

    private void jButtonbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonbuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonbuscarActionPerformed

    private void siguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_siguienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_siguienteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonanterior;
    private javax.swing.JButton jButtonbuscar;
    private javax.swing.JButton jButtoneliminar;
    private javax.swing.JButton jButtongrabar;
    private javax.swing.JButton jButtonimprimir;
    private javax.swing.JButton jButtonnuevo;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JButton siguiente;
    // End of variables declaration//GEN-END:variables
}