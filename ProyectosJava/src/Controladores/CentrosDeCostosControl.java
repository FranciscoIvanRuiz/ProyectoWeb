/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controladores;

import BaseDatos.Sql;

/**
 *
 * @author ivanruiz
 */
public class CentrosDeCostosControl {
    
    private Sql mySql = new Sql();
        public Integer Id = 0;
    private String Codigo = "";
    private String Nombre = "";
    private String Empresa_id = "";
    
    
    public CentrosDeCostosControl(){}
    
    
    
    
    public boolean Existe_CentroDeCosto(Integer Id, String Nombre, String Codigo, String Empresa_id){
        this.Id = Id;
        this.Nombre = Nombre;
        this.Codigo = Codigo;
        this.Empresa_id = Empresa_id;
        
        System.out.println(Codigo);

        this.Id = mySql.LlavePrimaria(" from centrosdecostos where codigo='" + Codigo + "' ;");
        return mySql.existe("ID", " from centrosdecostos where codigo='" + Codigo + "' ;");
    }
    
    
    
    
     public Object[][] getDatoCentroDeCosto(Integer Id) {
        String[] columnas = {"nombre", "codigo", "empresa_id"};
        Object[][] data = mySql.GetTabla(columnas, "centrosdecostos", "select * from centrosdecostos where id='" + Id + "';","");
        return data;
    }

    public void CrearCentroDeCosto(String Nombre, String Codigo, String Empresa_id) {
        String[] datos = {Nombre, Codigo, Empresa_id};
        mySql.Ejecutar_Insruccion_Sql(datos, "insert into centrosdecostos(nombre ,codigo,empresa_id) values(?,?,?);");
    }
    
    
    public void ActualizarCentroDeCosto(String Nombre, String Codigo, String Empresa_id, String Id) {
        String[] datos = {Nombre, Codigo, Empresa_id,Id};
        mySql.Ejecutar_Insruccion_Sql(datos, " update centrosdecostos set nombre  = ?,codigo  = ?,empresa_id  = ? where id = ? ;");
    }
    
    
    public Object[][] BuscarCentroDeCosto(String Nombre, String Codigo, String Empresa_id, String Id) {
        
        String Condicion= " where 1 = 1";
        
        if (Nombre.length() > 0) {
            Condicion = Condicion + " and nombre like '%"+Nombre+"%'" ;
        }
        if (Codigo.length() > 0) {
            Condicion = Condicion + " and codigo like '%"+Codigo+"%'" ;
        }
        if (Empresa_id.length() > 0) {
            Condicion = Condicion + " and empresa_id like '%"+Empresa_id+"%'" ;
        }
        
        if (Id.length() > 0) {
        }

       
        String[] columnas = {"nombre", "codigo", "empresa_id",  "id"};
        Object[][] data = mySql.GetTabla(columnas, "centrosdecostos", "select * from centrosdecostos  " + Condicion + ";",Condicion);
        return data;
    }

    
}


