/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Vistas;

import Controladores.ContadoresControl;
import Controladores.DContadoresControl;
import Controladores.EmpresaControl;
import javax.swing.table.DefaultTableModel;
import proyectosjava.VariablesGlobales;

/**
 *
 * @author ivanruiz
 */
public class Contador extends javax.swing.JInternalFrame {
private EmpresaControl EmpCont = new EmpresaControl();
private ContadoresControl ContCont = new ContadoresControl();
private DContadoresControl DContCont = new DContadoresControl();
    public Integer Id = 0;
    public String Codigo = "";
    public String Nombre = "";
    public String Digitos = "0";
    public String Desde = "";
    public String Hasta = "";
    public String Empresa_id = "";
    public Object[][] DatosEmpresa;
    public Object[][] DatosContadores;
    public Object[][] DatosDContadores;

    public Integer TotalRegistros = 0;
    public Integer Siguiente = 0;
    public Integer Anterior = 0;
    public Integer Registros = 0;


    /**
     * Creates new form Contador
     */
    public Contador() {
        initComponents();
         Object[][] DatosEmpresas = EmpCont.BuscarEmpresa("", "", "", "", "", "", "", "", Integer.toString(0));
        jtextempresa_id.removeAllItems();
        for (int i = 0; i < DatosEmpresas.length; i++) {
            String Item = (String) DatosEmpresas[i][8] + "-" + (String) DatosEmpresas[i][0];

            jtextempresa_id.addItem(Item);
        }
        
        DatosEmpresa = EmpCont.getDatoEmpresa(VariablesGlobales.EmpresaSelecionada.toString());
        jtextempresa_id.setSelectedItem(VariablesGlobales.EmpresaSelecionada.toString() + "-" + DatosEmpresa[0][0]);
    }
    
     public void ObtenerDatosDetalle(String Id) {
          String[] columNames = {"Contador", "Utilizado S/N", "Contadores Id"};
       
        DatosDContadores = DContCont.getDatoDContador(Id);
        // se colocan los datos en la tabla
        DefaultTableModel datos = new DefaultTableModel(DatosDContadores,columNames);
        jTable1.setModel(datos);
     
     }
    
      public void ObtenerDatos() {

        String Item = "";

        Id = 0;
        Nombre = jtextnombre.getText();
        Codigo = jtextcodigo.getText();
        Digitos = jtextdigitos.getText();
        Desde = jtextdesde.getText();
        Hasta = jtexthasta.getText();
        
        
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
        jtextdigitos.setText("0");
        jtextdesde.setText("");
        jtexthasta.setText("");
        
        DatosEmpresa = EmpCont.getDatoEmpresa(VariablesGlobales.EmpresaSelecionada.toString());
        jtextempresa_id.setSelectedItem(VariablesGlobales.EmpresaSelecionada.toString() + "-" + DatosEmpresa[0][0]);
        //jtexttiposdearticulos_id.setSelectedItem("");
    }
     
      public void EventoGrabar() {
        ObtenerDatos();

        if (ContCont.Existe_Contador(Id, Codigo, Nombre, Integer.parseInt(Digitos), Desde, Hasta, Empresa_id)){
            ContCont.ActualizarContador(Codigo, Nombre, Integer.parseInt(Digitos), Desde, Hasta, Empresa_id,Integer.toString(ContCont.Id));
            
            ContCont.CrearDetalleContador(Codigo, Nombre, Integer.parseInt(Digitos), Desde, Hasta, Empresa_id, Integer.toString(ContCont.Id));
            
                    
        } else {
            ContCont.CrearContador(Codigo, Nombre, Integer.parseInt(Digitos), Desde, Hasta, Empresa_id);
            if (ContCont.Existe_Contador(Id, Codigo, Nombre, Integer.parseInt(Digitos), Desde, Hasta, Empresa_id)){
             ContCont.CrearDetalleContador(Codigo, Nombre, Integer.parseInt(Digitos), Desde, Hasta, Empresa_id, Integer.toString(ContCont.Id));
           
            }
        }
    }
      
      
        public void EventoEliminar() {

    }

    public void EventoImprimir() {

    }
    
     public void EventoSiguiente() {
        jtextcodigo.setText(DatosContadores[Registros][0].toString());
        jtextnombre.setText(DatosContadores[Registros][1].toString());
        jtextdigitos.setText(DatosContadores[Registros][2].toString());
        jtextdesde.setText(DatosContadores[Registros][3].toString());
        jtexthasta.setText(DatosContadores[Registros][4].toString());
        
       
        DatosEmpresa = EmpCont.getDatoEmpresa(DatosContadores[Registros][5].toString());
        jtextempresa_id.setSelectedItem(DatosContadores[Registros][5].toString() + "-" + DatosEmpresa[0][0]);
    
           Registros = Registros + 1;
           if (Registros>TotalRegistros ){Registros = TotalRegistros  ;}
           System.out.println("Siguiente" + Registros + "Total" + TotalRegistros);
           
    }
    
    
    public void EventoAnterior() {

       jtextcodigo.setText(DatosContadores[Registros][0].toString());
        jtextnombre.setText(DatosContadores[Registros][1].toString());
        jtextdigitos.setText(DatosContadores[Registros][2].toString());
        jtextdesde.setText(DatosContadores[Registros][3].toString());
        jtexthasta.setText(DatosContadores[Registros][4].toString());
        
       
        DatosEmpresa = EmpCont.getDatoEmpresa(DatosContadores[Registros][5].toString());
        jtextempresa_id.setSelectedItem(DatosContadores[Registros][5].toString() + "-" + DatosEmpresa[0][0]);
    
        Registros = Registros - 1;
        if (Registros < 0) {
            Registros = 0;
        }

        System.out.println("Anterior" + Registros + "Total" + TotalRegistros);

    } 
     
    public void EventoBuscar() {
        ObtenerDatos();
        DatosContadores = ContCont.BuscarContador(Codigo, Nombre, Integer.parseInt(Digitos), Desde, Hasta, Empresa_id, Integer.toString(Id));

        TotalRegistros = DatosContadores.length - 1;
        if (TotalRegistros - 1 < 0) {
            TotalRegistros = 0;
        }
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
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jtextcodigo = new javax.swing.JTextField();
        jtextnombre = new javax.swing.JTextField();
        jtextdigitos = new javax.swing.JFormattedTextField();
        jtextempresa_id = new javax.swing.JComboBox();
        jtextdesde = new javax.swing.JFormattedTextField();
        jtexthasta = new javax.swing.JFormattedTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setClosable(true);
        setTitle("Contadores");

        jLabel1.setText("Codigo:");

        jLabel2.setText("Nombre:");

        jLabel3.setText("Digitos:");

        jLabel4.setText("Desde:");

        jLabel5.setText("Hasta:");

        jLabel6.setText("Empresa:");

        jtextcodigo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtextcodigoFocusLost(evt);
            }
        });

        jtextdigitos.setText("0");

        jtextempresa_id.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jtextempresa_id.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jtextempresa_idItemStateChanged(evt);
            }
        });

        jtextdesde.setText("1");

        jtexthasta.setText("999999");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jtextcodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtextnombre)
                    .addComponent(jtexthasta, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
                    .addComponent(jtextdesde)
                    .addComponent(jtextdigitos)
                    .addComponent(jtextempresa_id, 0, 215, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jtextcodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jtextnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jtextdigitos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jtextdesde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jtexthasta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jtextempresa_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtextempresa_idItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jtextempresa_idItemStateChanged
        // TODO add your handling code here:
         String Item="";
        Item = (String)jtextempresa_id.getSelectedItem();
        //Index =  (Int)jtextempresa_id.getSelectedIndex()
       if (Item!=null){
           Empresa_id = Item.substring(0,  Item.indexOf("-"));
          /// System.out.println(Item.substring(0,  Item.indexOf("-")));
       }
        
    }//GEN-LAST:event_jtextempresa_idItemStateChanged

    private void jtextcodigoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtextcodigoFocusLost
        // TODO add your handling code here:
        
         ObtenerDatos();
        
       
         

        if (ContCont.Existe_Contador(Id, Codigo, Nombre, Integer.parseInt(Digitos) , Desde, Hasta, Empresa_id)) {
            
            DatosContadores = ContCont.getDatoContador(ContCont.Id);
            
           
        jtextcodigo.setText(DatosContadores[0][0].toString());
        jtextnombre.setText(DatosContadores[0][1].toString());
         jtextdigitos.setText(DatosContadores[0][2].toString());
          jtextdesde.setText(DatosContadores[0][3].toString());
           jtexthasta.setText(DatosContadores[0][4].toString());
        
        DatosEmpresa = EmpCont.getDatoEmpresa(DatosContadores[0][5].toString());
        jtextempresa_id.setSelectedItem(DatosContadores[0][5].toString() + "-" + DatosEmpresa[0][0]);
            
        ObtenerDatosDetalle(ContCont.Id.toString());
        
        }
        
        
    }//GEN-LAST:event_jtextcodigoFocusLost


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jtextcodigo;
    private javax.swing.JFormattedTextField jtextdesde;
    private javax.swing.JFormattedTextField jtextdigitos;
    private javax.swing.JComboBox jtextempresa_id;
    private javax.swing.JFormattedTextField jtexthasta;
    private javax.swing.JTextField jtextnombre;
    // End of variables declaration//GEN-END:variables
}
