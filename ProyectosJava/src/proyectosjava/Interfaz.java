/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package proyectosjava;

import BaseDatos.Sql;
import Controladores.EmpresaControl;
import Vistas.Empresa;
import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;

/**
 *
 * @author ivanruiz
 */
public class Interfaz extends javax.swing.JFrame {
    
    private Sql mySql = new Sql();
    private EmpresaControl EmprCont=  new EmpresaControl();
    private Empresa Empr;
    
   

    /**
     * Creates new form Interfaz
     */
    public Interfaz() {
        initComponents();
        
        
         //se crea la raiz
         DefaultMutableTreeNode raiz = new DefaultMutableTreeNode("Sistema - Francisco Ruiz");
         DefaultMutableTreeNode empresa;
         DefaultMutableTreeNode modulo;
         DefaultMutableTreeNode submodulo;
         DefaultMutableTreeNode opcion;
         
          String[] columnas_empr={"id","nombre","ruc","correo"};
          Object[][] data_empr = mySql.GetTabla(columnas_empr, "empresas", "select * from empresas;"); 
          if( data_empr.length > 0)
              {
                  for (int i = 0; i < data_empr.length; i++) {
                        empresa = new DefaultMutableTreeNode(data_empr[i][1]);
                        raiz.add(empresa);
                        
                        String[] columnas_modu={"id","nombre"};
                        Object[][] data_modu = mySql.GetTabla(columnas_modu, "modulos", "select * from modulos;"); 
                        if( data_modu.length > 0)
                           {    
                               for (int j = 0; j < data_modu.length; j++) {
                                    modulo = new DefaultMutableTreeNode(data_modu[j][1]);
                                    empresa.add(modulo);
                                    
                                    String[] columnas_subm={"id","nombre"};
                                    Object[][] data_subm = mySql.GetTabla(columnas_subm, "submodulos", "select * from submodulos where modulos_id="+data_modu[j][0]+";"); 
              
                                     if( data_subm.length > 0)
                                        {
                                            for (int k = 0; k < data_subm.length; k++) {
                                                submodulo = new DefaultMutableTreeNode(data_subm[k][1]);
                                                modulo.add(submodulo);
                                                
                                                String[] columnas_opci={"id","nombre"};
                                                Object[][] data_opci = mySql.GetTabla(columnas_subm, "opciones", "select * from opciones where submodulo_modulos_id="+data_modu[j][0]+" and  submodulo_id="+data_subm[k][0]+";"); 
              
                                                 if( data_opci.length > 0)
                                                    {
                                                        for (int l = 0; l < data_opci.length; l++) {
                                                            opcion = new DefaultMutableTreeNode(data_opci[l][1]);
                                                            submodulo.add(opcion);
                                                        }
                                                    }
                                                
                                                
                                            }
                                        }
                         
                               }
      
                            }                  
                        
                        
                      
            
                  }
              }
          
  
            DefaultTreeModel modelo = new DefaultTreeModel(raiz);
            this.jTree1.setModel(modelo);
            
            DefaultTreeCellRenderer iconos = ( DefaultTreeCellRenderer)jTree1.getCellRenderer();
            iconos.setLeafIcon(new ImageIcon("src\\IconosSistema\\nuevo.png"));
            iconos.setOpenIcon(new ImageIcon("src\\IconosSistema\\detalle.png"));
            iconos.setClosedIcon(new ImageIcon("src\\IconosSistema\\Navegadores.png"));

       jTree1.getSelectionModel().addTreeSelectionListener(new TreeSelectionListener() {

           public void valueChanged(TreeSelectionEvent e) {
               // Se obtiene el Path seleccionado
               TreePath path = e.getPath();
               Object[] nodos = path.getPath();
               String txt="";
               for (Object nodo : nodos) {
                   txt += nodo.toString() + " | ";
               }
               
               System.out.println(txt);
             
           }
    });      

     
        
        
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTree1 = new javax.swing.JTree();
        panel = new javax.swing.JDesktopPane();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jScrollPane1.setViewportView(jTree1);

        panel.setBorder(javax.swing.BorderFactory.createTitledBorder("Sistema"));

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, 436, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(panel))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        if(EstaCerrado(Empr)){
            Empr = new Empresa(EmprCont);
            panel.add(Empr);
            Empr.show();
        }
        else{
            JOptionPane.showMessageDialog(this,"Error: La ventana ya esta abierta...");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Interfaz().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTree jTree1;
    private javax.swing.JDesktopPane panel;
    // End of variables declaration//GEN-END:variables
}
