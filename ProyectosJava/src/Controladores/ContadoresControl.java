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
public class ContadoresControl {

    private Sql mySql = new Sql();
    public Integer Id = 0;
    private String Codigo = "";
    private String Nombre = "";
    private Integer Digitos = 0;
    private String Desde = "";
    private String Hasta = "";
    private String Empresa_id = "";

    public ContadoresControl() {

    }

    public boolean Existe_Contador(Integer Id, String Codigo, String Nombre, Integer Digitos, String Desde, String Hasta, String Empresa_id) {
        this.Id = Id;
        this.Codigo = Codigo;
        this.Nombre = Nombre;
        this.Digitos = Digitos;
        this.Desde = Desde;
        this.Hasta = Hasta;
        this.Empresa_id = Empresa_id;

        this.Id = mySql.LlavePrimaria(" from contadores where codigo='" + Codigo + "' ;");
        return mySql.existe("ID", " from contadores where codigo='" + Codigo + "' ;");
    }

    public Object[][] getDatoContador(Integer Id) {
        String[] columnas = {"codigo", "nombre", "digitos", "desde", "hasta", "empresas_id"};
        Object[][] data = mySql.GetTabla(columnas, "contadores", "select * from contadores where id='" + Id + "';", "");
        return data;
    }

    public Object[][] getDatoContador(String Id) {
        String[] columnas = {"codigo", "nombre", "digitos", "desde", "hasta", "empresas_id"};
        Object[][] data = mySql.GetTabla(columnas, "contadores", "select * from contadores where id='" + Id + "';", "");
        return data;
    }

    public void CrearContador(String Codigo, String Nombre, Integer Digitos, String Desde, String Hasta, String Empresa_id) {
        String[] datos = {Codigo, Nombre, Digitos.toString(), Desde, Hasta, Empresa_id};
        mySql.Ejecutar_Insruccion_Sql(datos, "insert into contadores(codigo ,nombre,digitos,desde,hasta,empresas_id) values(?,?,?,?,?,?);");
    }

    public void ActualizarContador(String Codigo, String Nombre, Integer Digitos, String Desde, String Hasta, String Empresa_id, String Id) {
        String[] datos = {Codigo, Nombre, Digitos.toString(), Desde, Hasta, Empresa_id, Id};
        mySql.Ejecutar_Insruccion_Sql(datos, " update contadores set codigo  = ?,nombre  = ?,digitos  = ? ,desde=? , hasta=?, empresas_id  = ? where id = ? ;");
    }

    public Object[][] BuscarContador(String Codigo, String Nombre, Integer Digitos, String Desde, String Hasta, String Empresa_id, String Id) {

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

        String[] columnas = {"codigo", "nombre", "digitos", "desde", "hasta", "empresas_id"};
        Object[][] data = mySql.GetTabla(columnas, "contadores", "select * from contadores  " + Condicion + ";", Condicion);
        return data;
    }

}
