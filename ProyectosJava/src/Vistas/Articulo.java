/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Vistas;

import Controladores.ArticuloControl;
import Controladores.EmpresaControl;
import Controladores.TiposDeArticulosControl;
import proyectosjava.VariablesGlobales;

/**
 *
 * @author ivanruiz
 */
public class Articulo extends javax.swing.JInternalFrame {

    private TiposDeArticulosControl TipaCont = new TiposDeArticulosControl();
    private EmpresaControl EmpCont = new EmpresaControl();
    private ArticuloControl ArtCont = new ArticuloControl();

    public Integer Id = 0;
    public String Codigo = "";
    public String Nombre = "";
    public String Tiposdearticulos_id = "";
    public String Empresa_id = "";
    public Object[][] DatosEmpresa;
    public Object[][] DatosTiposDeArticulos;
    public Object[][] DatosArticulo;
    

    public Integer TotalRegistros = 0;
    public Integer Siguiente = 0;
    public Integer Anterior = 0;
    public Integer Registros = 0;

    
    
    
    /**
     * Creates new form Articulo
     */
    public Articulo() {
        initComponents();
        
        Object[][] DatosEmpresas = EmpCont.BuscarEmpresa("", "", "", "", "", "", "", "", Integer.toString(0));
        jtextempresa_id.removeAllItems();
        for (int i = 0; i < DatosEmpresas.length; i++) {
            String Item = (String) DatosEmpresas[i][8] + "-" + (String) DatosEmpresas[i][0];

            jtextempresa_id.addItem(Item);
        }
        
        DatosEmpresa = EmpCont.getDatoEmpresa(VariablesGlobales.EmpresaSelecionada.toString());
        jtextempresa_id.setSelectedItem(VariablesGlobales.EmpresaSelecionada.toString() + "-" + DatosEmpresa[0][0]);
        
         Object[][] DatosTiposDeArticulo = TipaCont.BuscarTiposDeArticulos("", "","", VariablesGlobales.EmpresaSelecionada.toString(),  Integer.toString(0));
         
        jtexttiposdearticulos_id.removeAllItems();
        for (int i = 0; i < DatosTiposDeArticulo.length; i++) {
            String Item = (String) DatosTiposDeArticulo[i][4] + "-" + (String) DatosTiposDeArticulo[i][1];

            jtexttiposdearticulos_id.addItem(Item);
        }
        
    }
    
    
    
    public void ObtenerDatos() {
        
        String Item = "";
        
        Id = 0;
        Nombre = jtextnombre.getText();
        Codigo = jtextcodigo.getText();
        
         Item = (String) jtexttiposdearticulos_id.getSelectedItem();
         if (Item != null) {
            Tiposdearticulos_id = Item.substring(0, Item.indexOf("-"));
            System.out.println(Item.substring(0, Item.indexOf("-")));
        }

       
        Item = (String) jtextempresa_id.getSelectedItem();
        //Index =  (Int)jtextempresa_id.getSelectedIndex()
        if (Item != null) {
            Empresa_id = Item.substring(0, Item.indexOf("-"));
            System.out.println(Item.substring(0, Item.indexOf("-")));
        }

    }
    
     public void EventoNuevo() {
        jtextnombre.setText("");
        jtextcodigo.setText("");
        DatosEmpresa = EmpCont.getDatoEmpresa(VariablesGlobales.EmpresaSelecionada.toString());
        jtextempresa_id.setSelectedItem(VariablesGlobales.EmpresaSelecionada.toString() + "-" + DatosEmpresa[0][0]);
        //jtexttiposdearticulos_id.setSelectedItem("");
    }
     
     public void EventoGrabar() {
        ObtenerDatos();

        if (ArtCont.Existe_Articulo(Id, Codigo, Nombre, Tiposdearticulos_id, Empresa_id)) {
            ArtCont.ActualizarArticulo(Codigo, Nombre, Tiposdearticulos_id, Empresa_id, Integer.toString(ArtCont.Id));
        } else {
            ArtCont.CrearArticulo(Codigo, Nombre, Tiposdearticulos_id, Empresa_id);
        }
    }
     
     public void EventoEliminar() {

    }

    public void EventoImprimir() {

    }
    
    
    public void EventoSiguiente() {
        jtextcodigo.setText(DatosArticulo[Registros][0].toString());
        jtextnombre.setText(DatosArticulo[Registros][1].toString());
        
        DatosTiposDeArticulos = TipaCont.getDatoTiposDeArticulos(DatosArticulo[Registros][2].toString());
        jtexttiposdearticulos_id.setSelectedItem(DatosArticulo[Registros][2].toString() +"-"+  DatosTiposDeArticulos[0][1]);
        
        DatosEmpresa = EmpCont.getDatoEmpresa(DatosArticulo[Registros][3].toString());
        jtextempresa_id.setSelectedItem(DatosArticulo[Registros][3].toString() + "-" + DatosEmpresa[0][0]);
    
           Registros = Registros + 1;
           if (Registros>TotalRegistros ){Registros = TotalRegistros  ;}
           System.out.println("Siguiente" + Registros + "Total" + TotalRegistros);
           
    }
    
    
    public void EventoAnterior() {

        jtextcodigo.setText(DatosArticulo[Registros][0].toString());
        jtextnombre.setText(DatosArticulo[Registros][1].toString());
        
        DatosTiposDeArticulos = TipaCont.getDatoTiposDeArticulos(DatosArticulo[Registros][2].toString());
        jtexttiposdearticulos_id.setSelectedItem(DatosArticulo[Registros][2].toString() +"-"+  DatosTiposDeArticulos[0][1]);
        
        DatosEmpresa = EmpCont.getDatoEmpresa(DatosArticulo[Registros][3].toString());
        jtextempresa_id.setSelectedItem(DatosArticulo[Registros][3].toString() + "-" + DatosEmpresa[0][0]);
    
        Registros = Registros - 1;
        if (Registros < 0) {
            Registros = 0;
        }

        System.out.println("Anterior" + Registros + "Total" + TotalRegistros);

    } 
     
     public void EventoBuscar() {
            ObtenerDatos();
             DatosArticulo = ArtCont.BuscarArticulo(Codigo, Nombre, Tiposdearticulos_id, Empresa_id, Integer.toString(Id));
                    TotalRegistros = DatosArticulo.length - 1   ;
             if (TotalRegistros - 1 < 0 ){TotalRegistros=0;}
             System.out.println("Buscar-----" + TotalRegistros);
             
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jtextcodigo = new javax.swing.JTextField();
        jtextnombre = new javax.swing.JTextField();
        jtexttiposdearticulos_id = new javax.swing.JComboBox();
        jtextempresa_id = new javax.swing.JComboBox();

        setClosable(true);
        setTitle("Articulos");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel1.setText("Codigo:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel2.setText("Nombre:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel3.setText("Tipo de Articulo:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel4.setText("Empresa:");

        jtextcodigo.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jtextcodigo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtextcodigoFocusLost(evt);
            }
        });

        jtextnombre.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N

        jtexttiposdearticulos_id.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jtexttiposdearticulos_id.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jtextempresa_id.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jtextempresa_id.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jtextempresa_id.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jtextempresa_idItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jtextcodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 146, Short.MAX_VALUE))
                    .addComponent(jtextnombre)
                    .addComponent(jtexttiposdearticulos_id, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jtextempresa_id, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(123, 123, 123))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jtextcodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jtextnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jtexttiposdearticulos_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtextempresa_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtextcodigoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtextcodigoFocusLost
        // TODO add your handling code here:
        
         ObtenerDatos();

        if (ArtCont.Existe_Articulo(Id, Codigo, Nombre, Tiposdearticulos_id, Empresa_id)) {
            DatosArticulo = ArtCont.getDatoArticulo(ArtCont.Id);
            
           
        jtextcodigo.setText(DatosArticulo[0][0].toString());
        jtextnombre.setText(DatosArticulo[0][1].toString());
        
        DatosTiposDeArticulos = TipaCont.getDatoTiposDeArticulos(DatosArticulo[0][2].toString());
        jtexttiposdearticulos_id.setSelectedItem(DatosArticulo[0][2].toString() +"-"+ DatosTiposDeArticulos[0][1]);
        
        
        DatosEmpresa = EmpCont.getDatoEmpresa(DatosTiposDeArticulos[0][3].toString());
        jtextempresa_id.setSelectedItem(DatosTiposDeArticulos[0][3].toString() + "-" + DatosEmpresa[0][0]);

        }
        
    }//GEN-LAST:event_jtextcodigoFocusLost

    private void jtextempresa_idItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jtextempresa_idItemStateChanged
        // TODO add your handling code here:
        
        String Item = "";
        Item = (String) jtextempresa_id.getSelectedItem();
        //Index =  (Int)jtextempresa_id.getSelectedIndex()
        if (Item != null) {
            Empresa_id = Item.substring(0, Item.indexOf("-"));

            Object[][] DatosTiposDeArticulo = TipaCont.BuscarTiposDeArticulos("", "", "", Empresa_id, Integer.toString(0));

            jtexttiposdearticulos_id.removeAllItems();
            for (int i = 0; i < DatosTiposDeArticulo.length; i++) {
                Item = (String) DatosTiposDeArticulo[i][4] + "-" + (String) DatosTiposDeArticulo[i][1];
                jtexttiposdearticulos_id.addItem(Item);
            }
        }
    }//GEN-LAST:event_jtextempresa_idItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField jtextcodigo;
    private javax.swing.JComboBox jtextempresa_id;
    private javax.swing.JTextField jtextnombre;
    private javax.swing.JComboBox jtexttiposdearticulos_id;
    // End of variables declaration//GEN-END:variables
}
