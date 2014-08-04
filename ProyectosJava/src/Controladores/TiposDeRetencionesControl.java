/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controladores;

import BaseDatos.Sql;

/**
 *
 * @author USER
 */
public class TiposDeRetencionesControl {
    private Sql mySql = new Sql();
   
    public Integer Id = 0;
    private String Codigo = "";
    private String Nombre = "";
    private Double Porcentaje = 0.00;

    public TiposDeRetencionesControl() {

    }

    
       public boolean Existe_TiposDeRetenciones(Integer Id, String Codigo, String Nombre,  Double Porcentaje) {
        this.Id = Id;
        this.Codigo = Codigo;
        this.Nombre = Nombre;
        this.Porcentaje = Porcentaje;

        this.Id = mySql.LlavePrimaria(" from tiposderetenciones where codigo='" + Codigo + "' ;");
        return mySql.existe("ID", " from tiposderetenciones where codigo='" + Codigo + "' ;");
    }

    public Object[][] getDatoTiposDeRetenciones(Integer Id) {
        String[] columnas = {"codigo", "nombre","porcentaje"};
        Object[][] data = mySql.GetTabla(columnas, "tiposderetenciones", "select * from tiposderetenciones where id='" + Id + "';", "");
        return data;
    }

    public Object[][] getDatoTiposDeRetenciones(String Id) {
        String[] columnas = {"codigo", "nombre","porcentaje"};
        Object[][] data = mySql.GetTabla(columnas, "tiposderetenciones", "select * from tiposderetenciones where id='" + Id + "';", "");
        return data;
    }

    public void CrearTiposDeRetenciones(String Codigo, String Nombre, Double Porcentaje) {
        String[] datos = {Codigo, Nombre,  String.valueOf(Porcentaje)};
        mySql.Ejecutar_Insruccion_Sql(datos, "insert into tiposderetenciones(codigo ,nombre,porcentaje) values(?,?,?);");
    }

    public void ActualizarTiposDeRetencion(String Codigo, String Nombre, Double Porcentaje, String Id) {
        String[] datos = {Codigo, Nombre, String.valueOf(Porcentaje), Id};
        mySql.Ejecutar_Insruccion_Sql(datos, " update tiposderetenciones set codigo  = ?,nombre  = ?,porcentaje  = ? where id = ? ;");
    }

    public Object[][] BuscarTiposDeRetenciones(String Codigo, String Nombre, Double Porcentaje, String Id) {

        String Condicion = " where 1 = 1";

        if (Codigo.length() > 0) {
            Condicion = Condicion + " and codigo like '%" + Codigo + "%'";
        }
        if (Nombre.length() > 0) {
            Condicion = Condicion + " and nombre like '%" + Nombre + "%'";
        }
        if (String.valueOf(Porcentaje).length() > 0) {
            Condicion = Condicion + " and porcentaje like '" + Porcentaje + "'";
        }

        if (Id.length() > 0) {
        }

        String[] columnas = {"codigo", "nombre","porcentaje"};
        Object[][] data = mySql.GetTabla(columnas, "tiposderetenciones", "select * from tiposderetenciones  " + Condicion + ";", Condicion);
        return data;
    }

}
