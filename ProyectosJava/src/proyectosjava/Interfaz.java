/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package proyectosjava;

import BaseDatos.Sql;
import Controladores.EmpresaControl;
import Vistas.Empresa;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import javax.swing.Icon;
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
        this.setTitle("Sistema Financiero Contable");
        //formulario al centro de la pantalla
        this.setLocationRelativeTo(null);
        panel.setBorder(new ImagenFondo());
        
        
         //se crea la raiz
         DefaultMutableTreeNode raiz = new DefaultMutableTreeNode("Sistema Financiero Contable");
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
        
          
            ClassLoader cldr = this.getClass().getClassLoader();

            java.net.URL imageURL1   = cldr.getResource("IconosSistema/nuevo.png");
            java.net.URL imageURL2   = cldr.getResource("IconosSistema/detalle.png");
            java.net.URL imageURL3   = cldr.getResource("IconosSistema/Navegadores.png");
            
            ImageIcon a = new ImageIcon(imageURL1);
            ImageIcon b = new ImageIcon(imageURL2);
            ImageIcon c = new ImageIcon(imageURL3);
           
           // ImageIcon Nuevo = new ImageIcon(imgUrl);
            
//            Image imagenInterna = new ImageIcon(getClass().getResource("nuevo.png")).getImage();
            
             System.out.println(imageURL1);
            
            iconos.setLeafIcon(a);
            iconos.setOpenIcon(b);
            iconos.setClosedIcon(c);
            
            
            

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

       
        jTree1.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent me) {
                
               if (me.getClickCount()== 2)  {
                
                TreePath tp = jTree1.getPathForLocation(me.getX(), me.getY());
                if (tp != null) {
                    System.out.println(tp.toString());
                    
                    if(EstaCerrado(Empr)){
            Empr = new Empresa();
            panel.add(Empr);
            Empr.show();
        }
        else{
           // JOptionPane.showMessageDialog(this,"Error: La ventana ya esta abierta...");
        }
                    
                    
                } else {
                    System.out.println("");
                }
            }
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
        jToolBar1 = new javax.swing.JToolBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jScrollPane1.setViewportView(jTree1);

        panel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jToolBar1.setRollover(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, 448, Short.MAX_VALUE))
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 518, Short.MAX_VALUE)
                    .addComponent(panel)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JTree jTree1;
    private javax.swing.JDesktopPane panel;
    // End of variables declaration//GEN-END:variables
}
