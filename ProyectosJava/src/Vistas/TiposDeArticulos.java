/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Vistas;

import Controladores.EmpresaControl;
import Controladores.TiposDeArticulosControl;
import proyectosjava.VariablesGlobales;

/**
 *
 * @author ivanruiz
 */
public class TiposDeArticulos extends javax.swing.JInternalFrame {
    
    
    private TiposDeArticulosControl TipaCont = new TiposDeArticulosControl();
    private EmpresaControl EmpCont = new EmpresaControl();

    public Integer Id = 0;
    public String Codigo = "";
    public String Nombre = "";
    public String Tipo = "";
    public String Empresa_id = "";
    public Object[][] DatosEmpresa;
     public Object[][] DatosTiposDeArticulos;

    public Integer TotalRegistros = 0;
    public Integer Siguiente = 0;
    public Integer Anterior = 0;
    public Integer Registros = 0;

    

    /**
     * Creates new form TiposDeArticulos
     */
    public TiposDeArticulos() {
        initComponents();
        Object[][] DatosEmpresas = EmpCont.BuscarEmpresa("", "", "", "", "", "", "", "", Integer.toString(0));
        jtextempresa_id.removeAllItems();
        for (int i = 0; i < DatosEmpresas.length; i++) {
            String Item = (String) DatosEmpresas[i][8] + "-" + (String) DatosEmpresas[i][0];

            jtextempresa_id.addItem(Item);
        }
        
        DatosEmpresa = EmpCont.getDatoEmpresa(VariablesGlobales.EmpresaSelecionada.toString());
        jtextempresa_id.setSelectedItem(VariablesGlobales.EmpresaSelecionada.toString() + "-" + DatosEmpresa[0][0]);
        jtexttipo.setSelectedItem("01-Bienes");
    }

    
    
    public void ObtenerDatos() {
        
        String Item = "";
        
        Id = 0;
        Nombre = jtextnombre.getText();
        Codigo = jtextcodigo.getText();
        
         Item = (String) jtexttipo.getSelectedItem();
         if (Item != null) {
            Tipo = Item.substring(0, Item.indexOf("-"));
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
        jtexttipo.setSelectedItem("01-Bienes");
    }

    public void EventoGrabar() {
        ObtenerDatos();

        if (TipaCont.Existe_TiposDeArticulos(Id, Codigo, Nombre, Tipo, Empresa_id)) {
            TipaCont.ActualizarTiposDeArticulos(Codigo, Nombre, Tipo, Empresa_id, Integer.toString(TipaCont.Id));
        } else {
            TipaCont.CrearTiposDeArticulos(Codigo, Nombre, Tipo, Empresa_id);
        }
    }
    
    
    public void EventoEliminar() {

    }

    public void EventoImprimir() {

    }
    
    
    public void EventoSiguiente() {
        jtextcodigo.setText(DatosTiposDeArticulos[Registros][0].toString());
        jtextnombre.setText(DatosTiposDeArticulos[Registros][1].toString());
        
        
        
        switch (DatosTiposDeArticulos[Registros][2].toString()) {
                case "01":
                    jtexttipo.setSelectedItem(DatosTiposDeArticulos[Registros][2].toString() + "-Bienes");
                    break;
                case "02":
                     jtexttipo.setSelectedItem(DatosTiposDeArticulos[Registros][2].toString() + "-Servicios");
                    break;
                case "03":
                     jtexttipo.setSelectedItem(DatosTiposDeArticulos[Registros][2].toString() + "-Transporte");
                    break;
        
        }
        DatosEmpresa = EmpCont.getDatoEmpresa(DatosTiposDeArticulos[Registros][3].toString());
        jtextempresa_id.setSelectedItem(DatosTiposDeArticulos[Registros][3].toString() + "-" + DatosEmpresa[0][0]);
    
           Registros = Registros + 1;
           if (Registros>TotalRegistros ){Registros = TotalRegistros  ;}
           System.out.println("Siguiente" + Registros + "Total" + TotalRegistros);
           
    }
    
    
    public void EventoAnterior() {

        jtextcodigo.setText(DatosTiposDeArticulos[Registros][0].toString());
        jtextnombre.setText(DatosTiposDeArticulos[Registros][1].toString());

        switch (DatosTiposDeArticulos[Registros][2].toString()) {
                case "01":
                    jtexttipo.setSelectedItem(DatosTiposDeArticulos[Registros][2].toString() + "-Bienes");
                    break;
                case "02":
                     jtexttipo.setSelectedItem(DatosTiposDeArticulos[Registros][2].toString() + "-Servicios");
                    break;
                case "03":
                     jtexttipo.setSelectedItem(DatosTiposDeArticulos[Registros][2].toString() + "-Transporte");
                    break;
        
        }
        DatosEmpresa = EmpCont.getDatoEmpresa(DatosTiposDeArticulos[Registros][3].toString());
        jtextempresa_id.setSelectedItem(DatosTiposDeArticulos[Registros][3].toString() + "-" + DatosEmpresa[0][0]);

        Registros = Registros - 1;
        if (Registros < 0) {
            Registros = 0;
        }

        System.out.println("Anterior" + Registros + "Total" + TotalRegistros);

    }

    public void EventoBuscar() {
            ObtenerDatos();
             DatosTiposDeArticulos = TipaCont.BuscarTiposDeArticulos(Codigo, Nombre, Tipo, Empresa_id, Integer.toString(Id));
                    TotalRegistros = DatosTiposDeArticulos.length - 1   ;
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
        jtexttipo = new javax.swing.JComboBox();
        jtextempresa_id = new javax.swing.JComboBox();

        setClosable(true);
        setTitle("Tipos De Articulos");

        jLabel1.setText("Codigo:");

        jLabel2.setText("Nombre:");

        jLabel3.setText("Tipo:");

        jLabel4.setText("Empresa:");

        jtextcodigo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtextcodigoFocusLost(evt);
            }
        });

        jtexttipo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "01-Bienes", "02-Servicios", "03-Transporte" }));

        jtextempresa_id.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtextcodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtextnombre)
                    .addComponent(jtexttipo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jtextempresa_id, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(89, 89, 89))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jtextcodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jtextnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jtexttipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jtextempresa_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtextcodigoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtextcodigoFocusLost
        // TODO add your handling code here:
        
         ObtenerDatos();

        if (TipaCont.Existe_TiposDeArticulos(Id, Codigo, Nombre, Tipo, Empresa_id)) {
            DatosTiposDeArticulos = TipaCont.getDatoTiposDeArticulos(TipaCont.Id);
            
           
        jtextcodigo.setText(DatosTiposDeArticulos[0][0].toString());
        jtextnombre.setText(DatosTiposDeArticulos[0][1].toString());
        
                switch (DatosTiposDeArticulos[0][2].toString()) {
                case "01":
                    jtexttipo.setSelectedItem(DatosTiposDeArticulos[0][2].toString() + "-Bienes");
                    break;
                    case "02":
                      jtexttipo.setSelectedItem(DatosTiposDeArticulos[0][2].toString() + "-Servicios");
                    break;
                        case "03":
                    jtexttipo.setSelectedItem(DatosTiposDeArticulos[0][2].toString() + "-Transporte");
                    break;
            }
        

        if (DatosTiposDeArticulos[0][2].toString() == "01") {
             
            jtexttipo.setSelectedItem(DatosTiposDeArticulos[0][2].toString() + "-Bienes");
        }

        if (DatosTiposDeArticulos[0][2].toString() == "02") {
            jtexttipo.setSelectedItem(DatosTiposDeArticulos[0][2].toString() + "-Servicios");
        }

        if (DatosTiposDeArticulos[0][2].toString() == "03") {
            jtexttipo.setSelectedItem(DatosTiposDeArticulos[0][2].toString() + "-Transporte");
        }

        DatosEmpresa = EmpCont.getDatoEmpresa(DatosTiposDeArticulos[0][3].toString());
        jtextempresa_id.setSelectedItem(DatosTiposDeArticulos[0][3].toString() + "-" + DatosEmpresa[0][0]);

        }
        
    }//GEN-LAST:event_jtextcodigoFocusLost


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField jtextcodigo;
    private javax.swing.JComboBox jtextempresa_id;
    private javax.swing.JTextField jtextnombre;
    private javax.swing.JComboBox jtexttipo;
    // End of variables declaration//GEN-END:variables
}
