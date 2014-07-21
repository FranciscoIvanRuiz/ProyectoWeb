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
public class ParametrosControl {

    private Sql mySql = new Sql();
    public Integer Ventas = 0;
    public Integer Compras = 0;
    public Integer Nventas = 0;
    public Integer Ncompras = 0;
    private Integer Empresa_id = 0;

    public ParametrosControl() {

    }

    public boolean Existe_Parametro(Integer Ventas, Integer Compras, Integer Nventas, Integer Ncompras, Integer Empresa_id) {
        this.Ventas = Ventas;
        this.Compras = Compras;
        this.Nventas = Nventas;
        this.Ncompras = Ncompras;
        this.Empresa_id = Empresa_id;

        this.Empresa_id = mySql.LlavePrimaria(" from parametros where empresa_id='" + Empresa_id + "' ;");
        return mySql.existe("ID", " from contadores where empresa_id='" + Empresa_id + "' ;");
    }

    public Object[][] getDatoParametro(Integer Empresa_id) {
        String[] columnas = {"ventas", "compras", "nventas", "ncompras", "empresas_id"};
        Object[][] data = mySql.GetTabla(columnas, "parametros", "select * from parametros where empresa_id='" + Empresa_id + "';", "");
        return data;
    }

    public Object[][] getDatoParametro(String Empresa_id) {
        String[] columnas = {"ventas", "compras", "nventas", "ncompras", "empresas_id"};
        Object[][] data = mySql.GetTabla(columnas, "parametros", "select * from parametros where empresa_id='" + Empresa_id + "';", "");
        return data;
    }

    public void CrearParametro(Integer Ventas, Integer Compras, Integer Nventas, Integer Ncompras, Integer Empresa_id) {
        String[] datos = {Ventas.toString(), Compras.toString(), Nventas.toString(), Ncompras.toString(), Empresa_id.toString()};
        mySql.Ejecutar_Insruccion_Sql(datos, "insert into parametros(ventas ,compras,nventas,ncompras,empresas_id) values(?,?,?,?,?);");
    }

    public void ActualizarParametro(Integer Ventas, Integer Compras, Integer Nventas, Integer Ncompras, Integer Empresa_id) {
        String[] datos = {Ventas.toString(), Compras.toString(), Nventas.toString(), Ncompras.toString(), Empresa_id.toString()};
        mySql.Ejecutar_Insruccion_Sql(datos, " update parametros set ventas  = ?,compras  = ?,nventas  = ? ,ncomompras=?  where empresas_id = ? ;");
    }

    public Object[][] BuscarParametro(Integer Ventas, Integer Compras, Integer Nventas, Integer Ncompras, Integer Empresa_id) {

        String Condicion = " where 1 = 1";

        if (Empresa_id.toString().length() > 0) {
            Condicion = Condicion + " and empresas_id like '" + Empresa_id + "'";
        }

        String[] columnas = {"ventas", "compras", "nventas", "ncompras", "empresas_id"};
        Object[][] data = mySql.GetTabla(columnas, "parametros", "select * from parametros  " + Condicion + ";", Condicion);
        return data;
    }

}
