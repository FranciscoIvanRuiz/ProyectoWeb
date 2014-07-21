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
public class TransaccionesControl {
   private Sql mySql = new Sql();
   
    public Integer Id = 0;
    private String Codigo = "";
    private String Nombre = "";
    private String Tipo = "";
    private String Empresa_id = "";

    public TransaccionesControl() {

    }

    public boolean Existe_Transaccion(Integer Id, String Codigo, String Nombre,  String Tipo, String Empresa_id) {
        this.Id = Id;
        this.Codigo = Codigo;
        this.Nombre = Nombre;
        this.Tipo = Tipo;
        this.Empresa_id = Empresa_id;

        this.Id = mySql.LlavePrimaria(" from transacciones where codigo='" + Codigo + "' ;");
        return mySql.existe("ID", " from transacciones where codigo='" + Codigo + "' ;");
    }

    public Object[][] getDatoTransaccion(Integer Id) {
        String[] columnas = {"codigo", "nombre", "tipo",  "empresas_id"};
        Object[][] data = mySql.GetTabla(columnas, "transacciones", "select * from transacciones where id='" + Id + "';", "");
        return data;
    }

    public Object[][] getDatoTransaccion(String Id) {
         String[] columnas = {"codigo", "nombre", "tipo",  "empresas_id"};
        Object[][] data = mySql.GetTabla(columnas, "transacciones", "select * from transacciones where id='" + Id + "';", "");
        return data;
    }

    public void CrearTransaccion(String Codigo, String Nombre,  String Tipo, String Empresa_id) {
        String[] datos = {Codigo, Nombre, Tipo, Empresa_id};
        mySql.Ejecutar_Insruccion_Sql(datos, "insert into transacciones(codigo ,nombre,tipo,empresas_id) values(?,?,?,?);");
    }

    public void ActualizarTransaccion(String Codigo, String Nombre,  String Tipo, String Empresa_id, String Id) {
        String[] datos = {Codigo, Nombre, Tipo, Empresa_id, Id};
        mySql.Ejecutar_Insruccion_Sql(datos, " update transacciones set codigo  = ?,nombre  = ?,tipo=?, empresas_id  = ? where id = ? ;");
    }

    public Object[][] BuscarTransaccion(String Codigo, String Nombre,  String Tipo, String Empresa_id, String Id) {

        String Condicion = " where 1 = 1";

        if (Codigo.length() > 0) {
            Condicion = Condicion + " and codigo like '%" + Codigo + "%'";
        }
        if (Nombre.length() > 0) {
            Condicion = Condicion + " and nombre like '%" + Nombre + "%'";
        }
        if (Empresa_id.length() > 0) {
            Condicion = Condicion + " and empresas_id like '" + Empresa_id + "'";
        }

        if (Id.length() > 0) {
        }

        String[] columnas = {"codigo", "nombre", "tipo",  "empresas_id"};
        Object[][] data = mySql.GetTabla(columnas, "transacciones", "select * from transacciones  " + Condicion + ";", Condicion);
        return data;
    }
 
}
