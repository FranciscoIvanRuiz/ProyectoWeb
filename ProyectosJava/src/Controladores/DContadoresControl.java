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
public class DContadoresControl {
    
        private Sql mySql = new Sql();
    public Integer Id = 0;
    private String Codigo = "";
    private String Utilizado = "";
    private String Contadores_id = "";

        public DContadoresControl() {

    }
        
        
            public boolean Existe_DContador(Integer Id, String Codigo, String Utilizado, String Contadores_id) {
        this.Id = Id;
        this.Codigo = Codigo;
        this.Utilizado = Utilizado;
        this.Contadores_id = Contadores_id;

        this.Id = mySql.LlavePrimaria(" from dcontadores where codigo='" + Codigo + "' ;");
        return mySql.existe("ID", " from dcontadores where codigo='" + Codigo + "' ;");
    }

    public Object[][] getDatoDContador(Integer Id) {
        String[] columnas = {"codigo", "utilizado", "contadores_id"};
        Object[][] data = mySql.GetTabla(columnas, "dcontadores", "select * from dcontadores where id='" + Id + "';", "");
        return data;
    }

    public Object[][] getDatoDContador(String Id) {
        String[] columnas = {"codigo", "utilizado", "contadores_id"};
        Object[][] data = mySql.GetTabla(columnas, "dcontadores", "select * from dcontadores where id='" + Id + "';", "");
        return data;
    }

    public void CrearDContador(String Codigo, String Utilizado,  String Contadores_id) {
        String[] datos = {Codigo, Utilizado, Contadores_id};
        mySql.Ejecutar_Insruccion_Sql(datos, "insert into dcontadores(codigo ,utilizado,contadores_id) values(?,?,?);");
    }

    public void ActualizarDContador(String Codigo, String Utilizado,  String Contadores_id ,String Id) {
        String[] datos = {Codigo, Utilizado, Contadores_id, Id};
        mySql.Ejecutar_Insruccion_Sql(datos, " update dcontadores set codigo  = ?,utilizado  = ?,contadores_id  = ? where id = ? ;");
    }

    public Object[][] BuscarDContador(String Codigo, String Utilizado,  String Contadores_id ,String Id) {

        String Condicion = " where 1 = 1";

        if (Codigo.length() > 0) {
            Condicion = Condicion + " and codigo like '%" + Codigo + "%'";
        }
        if (Utilizado.length() > 0) {
            Condicion = Condicion + " and utilizado like '%" + Utilizado + "%'";
        }
        if (Contadores_id.length() > 0) {
            Condicion = Condicion + " and contadores_id like '" + Contadores_id + "'";
        }

        if (Id.length() > 0) {
        }

        String[] columnas = {"codigo", "utilizado", "contadores_id"};
        Object[][] data = mySql.GetTabla(columnas, "dcontadores", "select * from dcontadores  " + Condicion + ";", Condicion);
        return data;
    }

}
