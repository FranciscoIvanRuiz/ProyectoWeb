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
public class TiposDeArticulosControl {

    private Sql mySql = new Sql();
    public Integer Id = 0;
    private String Codigo = "";
    private String Nombre = "";
    private String Tipo = "";
    private String Empresa_id = "";

    public TiposDeArticulosControl() {

    }

    public boolean Existe_TiposDeArticulos(Integer Id, String Codigo, String Nombre, String Tipo, String Empresa_id) {
        this.Id = Id;
        this.Codigo = Codigo;
        this.Nombre = Nombre;
        this.Tipo = Tipo;
        this.Empresa_id = Empresa_id;

        this.Id = mySql.LlavePrimaria(" from tiposdearticulos where codigo='" + Codigo + "' ;");
        return mySql.existe("ID", " from tiposdearticulos where codigo='" + Codigo + "' ;");
    }

    public Object[][] getDatoTiposDeArticulos(Integer Id) {
        String[] columnas = {"codigo", "nombre", "tipo", "empresas_id"};
        Object[][] data = mySql.GetTabla(columnas, "tiposdearticulos", "select * from tiposdearticulos where id='" + Id + "';", "");
        return data;
    }

    public Object[][] getDatoTiposDeArticulos(String Id) {
        String[] columnas = {"codigo", "nombre", "tipo", "empresas_id"};
        Object[][] data = mySql.GetTabla(columnas, "tiposdearticulos", "select * from tiposdearticulos where id='" + Id + "';", "");
        return data;
    }

    public void CrearTiposDeArticulos(String Codigo, String Nombre, String Tipo, String Empresa_id) {
        String[] datos = {Codigo, Nombre, Tipo, Empresa_id};
        mySql.Ejecutar_Insruccion_Sql(datos, "insert into tiposdearticulos(codigo ,nombre,tipo,empresas_id) values(?,?,?,?);");
    }

    public void ActualizarTiposDeArticulos(String Codigo, String Nombre, String Tipo, String Empresa_id, String Id) {
        String[] datos = {Codigo, Nombre, Tipo, Empresa_id, Id};
        mySql.Ejecutar_Insruccion_Sql(datos, " update tiposdearticulos set codigo  = ?,nombre  = ?,tipo  = ?,empresas_id  = ? where id = ? ;");
    }

    public Object[][] BuscarTiposDeArticulos(String Codigo, String Nombre, String Tipo, String Empresa_id, String Id) {

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

        String[] columnas = {"codigo", "nombre", "tipo", "empresas_id", "id"};
        Object[][] data = mySql.GetTabla(columnas, "tiposdearticulos", "select * from tiposdearticulos  " + Condicion + ";", Condicion);
        return data;
    }

}
