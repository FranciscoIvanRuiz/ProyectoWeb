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
public class ArticuloControl {
private Sql mySql = new Sql();
    public Integer Id = 0;
    private String Codigo = "";
    private String Nombre = "";
    private String Tiposdearticulos_id = "";
    private String Empresa_id = "";

    public ArticuloControl() {

    }

    public boolean Existe_Articulo(Integer Id, String Codigo, String Nombre,  String Tiposdearticulos_id, String Empresa_id) {
        this.Id = Id;
        this.Codigo = Codigo;
        this.Nombre = Nombre;
        this.Tiposdearticulos_id = Tiposdearticulos_id;
        this.Empresa_id = Empresa_id;

        this.Id = mySql.LlavePrimaria(" from articulos where codigo='" + Codigo + "' ;");
        return mySql.existe("ID", " from articulos where codigo='" + Codigo + "' ;");
    }

    public Object[][] getDatoArticulo(Integer Id) {
        String[] columnas = {"codigo", "nombre","tiposdearticulos_id", "empresa_id"};
        Object[][] data = mySql.GetTabla(columnas, "articulos", "select * from articulos where id='" + Id + "';", "");
        return data;
    }

    public Object[][] getDatoArticulo(String Id) {
        String[] columnas = {"codigo", "nombre","tiposdearticulos_id", "empresa_id"};
        Object[][] data = mySql.GetTabla(columnas, "articulos", "select * from articulos where id='" + Id + "';", "");
        return data;
    }

    public void CrearArticulo(String Codigo, String Nombre, String Tiposdearticulos_id, String Empresa_id) {
        String[] datos = {Codigo, Nombre, Tiposdearticulos_id, Empresa_id};
        mySql.Ejecutar_Insruccion_Sql(datos, "insert into articulos(codigo ,nombre,tiposdearticulos_id,empresa_id) values(?,?,?,?);");
    }

    public void ActualizarArticulo(String Codigo, String Nombre, String Tiposdearticulos_id, String Empresa_id, String Id) {
        String[] datos = {Codigo, Nombre, Tiposdearticulos_id, Empresa_id, Id};
        mySql.Ejecutar_Insruccion_Sql(datos, " update articulos set codigo  = ?,nombre  = ?,tiposdearticulos_id  = ?,empresa_id  = ? where id = ? ;");
    }

    public Object[][] BuscarArticulo(String Codigo, String Nombre, String Tiposdearticulos_id, String Empresa_id, String Id) {

        String Condicion = " where 1 = 1";

        if (Codigo.length() > 0) {
            Condicion = Condicion + " and codigo like '%" + Codigo + "%'";
        }
        if (Nombre.length() > 0) {
            Condicion = Condicion + " and nombre like '%" + Nombre + "%'";
        }
        if (Empresa_id.length() > 0) {
            Condicion = Condicion + " and empresa_id like '" + Empresa_id + "'";
        }

        if (Id.length() > 0) {
        }

        String[] columnas = {"codigo", "nombre","tiposdearticulos_id", "empresa_id"};
        Object[][] data = mySql.GetTabla(columnas, "articulos", "select * from articulos  " + Condicion + ";", Condicion);
        return data;
    }

}
