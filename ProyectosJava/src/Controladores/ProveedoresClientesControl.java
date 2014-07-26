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
public class ProveedoresClientesControl {

    private Sql mySql = new Sql();

    public Integer Id = 0;
    public String Codigo = "";
    public String Ruc = "";
    public String Nombres = "";
    public String Direccion = "";
    public String Telefono1 = "";
    public String Telefono2 = "";
    public String Telefono3 = "";
    public String Correo = "";
    public String Representante = "";
    public String Empresas_id = "";
    public Integer Renta = 0;
    public Integer Rentaservicio = 0;
    public Integer Rentatransporte = 0;
    public Integer Iva = 0;
    public Integer Ivaservicios = 0;
    public Integer Ivatransporte = 0;
    public String Tipo = "";

    public ProveedoresClientesControl() {

    }

    public boolean Existe_ProveedoresClientes(Integer Id, String Codigo, String Ruc, String Nombres, String Direccion, String Telefono1, String Telefono2, String Telefono3, String Correo, String Representante, String Empresas_id, Integer Renta, Integer Rentaservicio, Integer Rentatransporte, Integer Iva, Integer Ivaservicios, Integer Ivatransporte, String Tipo) {
        this.Id = Id;
        this.Codigo = Codigo;
        this.Ruc = Ruc;
        this.Nombres = Nombres;
        this.Direccion = Direccion;
        this.Telefono1 = Telefono1;
        this.Telefono2 = Telefono2;
        this.Telefono3 = Telefono3;
        this.Correo = Correo;
        this.Representante = Representante;
        this.Empresas_id = Empresas_id;
        this.Renta = Renta;
        this.Rentaservicio = Rentaservicio;
        this.Rentatransporte = Rentatransporte;
        this.Iva = Iva;
        this.Ivaservicios = Ivaservicios;
        this.Ivatransporte = Ivatransporte;
        this.Tipo = Tipo;

        this.Id = mySql.LlavePrimaria(" from proveedoresclientes where codigo='" + Codigo + "' ;");
        return mySql.existe("ID", " from proveedoresclientes where codigo='" + Codigo + "' ;");
    }

    public Object[][] getDatoProveedoresClientes(Integer Id) {
        String[] columnas = {"codigo", "ruc", "nombres", "direccion", "telefono1", "telefono2", "telefono3", "correo", "representante", "empresas_id", "renta", "rentaservicio", "rentatransporte", "iva", "ivaservicios", "ivatransporte", "tipo"};
        Object[][] data = mySql.GetTabla(columnas, "proveedoresclientes", "select * from proveedoresclientes where id='" + Id + "';", "");
        return data;
    }

    public Object[][] getDatoProveedoresClientes(String Id) {
        String[] columnas = {"codigo", "ruc", "nombres", "direccion", "telefono1", "telefono2", "telefono3", "correo", "representante", "empresas_id", "renta", "rentaservicio", "rentatransporte", "iva", "ivaservicios", "ivatransporte", "tipo"};
        Object[][] data = mySql.GetTabla(columnas, "proveedoresclientes", "select * from proveedoresclientes where id='" + Id + "';", "");
        return data;
    }

    public void CrearProveedoresClientes(String Codigo, String Ruc, String Nombres, String Direccion, String Telefono1, String Telefono2, String Telefono3, String Correo, String Representante, String Empresas_id, Integer Renta, Integer Rentaservicio, Integer Rentatransporte, Integer Iva, Integer Ivaservicios, Integer Ivatransporte, String Tipo) {
        String[] datos = {
            Codigo, Ruc, Nombres, Direccion, Telefono1, Telefono2, Telefono3, Correo, Representante, Empresas_id, Integer.toString(Renta), Integer.toString(Rentaservicio), Integer.toString(Rentatransporte), Integer.toString(Iva), Integer.toString(Ivaservicios), Integer.toString(Ivatransporte), Tipo
        };
        mySql.Ejecutar_Insruccion_Sql(datos, "insert into proveedoresclientes(codigo ,nombre,porcentaje) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);");
    }

    public void ActualizarProveedoresClientes(String Codigo, String Ruc, String Nombres, String Direccion, String Telefono1, String Telefono2, String Telefono3, String Correo, String Representante, String Empresas_id, Integer Renta, Integer Rentaservicio, Integer Rentatransporte, Integer Iva, Integer Ivaservicios, Integer Ivatransporte, String Tipo, String Id) {
        String[] datos = {Codigo, Ruc, Nombres, Direccion, Telefono1, Telefono2, Telefono3, Correo, Representante, Empresas_id, Integer.toString(Renta), Integer.toString(Rentaservicio), Integer.toString(Rentatransporte), Integer.toString(Iva), Integer.toString(Ivaservicios), Integer.toString(Ivatransporte), Tipo, Id};
        mySql.Ejecutar_Insruccion_Sql(datos, " update proveedoresclientes set codigo=?,ruc=?, nombres=?,direccion=?, telefono1=?,telefono2=?, telefono3=?,correo=?, representante=?, empresas_id=?, renta=?, rentaservicio=?,rentatransporte=?, iva=?, ivaservicios=?, ivatransporte=?, tipo=? where id = ? ;");
    }

    public Object[][] BuscarProveedoresClientes(String Codigo, String Ruc, String Nombres, String Direccion, String Telefono1, String Telefono2, String Telefono3, String Correo, String Representante, String Empresas_id, Integer Renta, Integer Rentaservicio, Integer Rentatransporte, Integer Iva, Integer Ivaservicios, Integer Ivatransporte, String Tipo, String Id) {

        String Condicion = " where 1 = 1";

        if (Codigo.length() > 0) {
            Condicion = Condicion + " and codigo like '%" + Codigo + "%'";
        }
        if (Nombres.length() > 0) {
            Condicion = Condicion + " and nombres like '%" + Nombres + "%'";
        }
        if (Ruc.length() > 0) {
            Condicion = Condicion + " and ruc like '" + Ruc + "'";
        }

        if (Id.length() > 0) {
        }

        String[] columnas = {"codigo", "ruc", "nombres", "direccion", "telefono1", "telefono2", "telefono3", "correo", "representante", "empresas_id", "renta", "rentaservicio", "rentatransporte", "iva", "ivaservicios", "ivatransporte", "tipo"};
        Object[][] data = mySql.GetTabla(columnas, "proveedoresclientes", "select * from proveedoresclientes  " + Condicion + ";", Condicion);
        return data;
    }

}
