/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import BaseDatos.Sql;
import java.sql.Date;

/**
 *
 * @author USER
 */
public class MovimientosControl {

    private Sql mySql = new Sql();

    public Integer Id = 0;
    private String Empresas_id = "";
    private String Tipo = "";
    private String Proveedoresclientes_id = "";
    private String Transacciones_id = "";
    private String Serie1 = "";
    private String Serie2 = "";
    private String Factura = "";
    private Date Fecha;
    private String Secuencial = "";
    
    
    public MovimientosControl() {

    }

    public boolean Existe_Movimiento(Integer Id, String Empresas_id, String Tipo, String Proveedoresclientes_id,
            String Transacciones_id, String Serie1, String Serie2, String Factura,
            Date Fecha, String Secuencial) {

        this.Id = Id;
        this.Empresas_id = Empresas_id;
        this.Tipo = Tipo;
        this.Proveedoresclientes_id = Proveedoresclientes_id;
        this.Transacciones_id = Transacciones_id;
        this.Serie1 = Serie1;
        this.Serie2 = Serie2;
        this.Factura = Factura;
        this.Fecha = Fecha;
        this.Secuencial = Secuencial;

        this.Id = mySql.LlavePrimaria(" from movimientos where secuencial='" + Secuencial + "' and transacciones_id='" + Transacciones_id + "' ;");
        return mySql.existe("ID", " from movimientos where secuencial='" + Secuencial + "' and transacciones_id='" + Transacciones_id + "' ;");
    }

    public Object[][] getDatoMovimiento(Integer Id) {
        String[] columnas = {"empresas_id", "tipo", "proveedoresclientes_id", "transacciones_id", "serie1", "serie2", "factura", "fecha", "secuencial"};
        Object[][] data = mySql.GetTabla(columnas, "movimientos", "select * from movimientos where id='" + Id + "';", "");
        return data;
    }

    public Object[][] getDatoMovimiento(String Id) {
        String[] columnas = {"empresas_id", "tipo", "proveedoresclientes_id", "transacciones_id", "serie1", "serie2", "factura", "fecha", "secuencial"};
        Object[][] data = mySql.GetTabla(columnas, "movimientos", "select * from movimientos where id='" + Id + "';", "");
        return data;
    }

    public void CrearMovimiento(String Empresas_id, String Tipo, String Proveedoresclientes_id,
            String Transacciones_id, String Serie1, String Serie2, String Factura,
            Date Fecha, String Secuencial) {
        String[] datos = {Empresas_id, Tipo, Proveedoresclientes_id, Transacciones_id, Serie1, Serie2, Factura, Fecha.toString(), Secuencial};
        mySql.Ejecutar_Insruccion_Sql(datos, "insert into movimientos(empresas_id,tipo,proveedoresclientes_id,transacciones_id,serie1,serie2,factura,fecha,secuencial) values(?,?,?,?,?,?,?,?,?);");
    }

    public void ActualizarMovimiento(String Empresas_id, String Tipo, String Proveedoresclientes_id,
            String Transacciones_id, String Serie1, String Serie2, String Factura,
            Date Fecha, String Secuencial, String Id) {
        String[] datos = {Empresas_id, Tipo, Proveedoresclientes_id, Transacciones_id, Serie1, Serie2, Factura, Fecha.toString(), Secuencial, Id};
        mySql.Ejecutar_Insruccion_Sql(datos, " update movimientos set empresas_id=?,tipo=?,proveedoresclientes_id=?,transacciones_id=?,serie1=?,serie2=?,factura=?,fecha=?,secuencial=? where id = ? ;");
    }

    public Object[][] BuscarMovimiento(String Empresas_id, String Tipo, String Proveedoresclientes_id,
            String Transacciones_id, String Serie1, String Serie2, String Factura,
            Date Fecha, String Secuencial, String Id) {

        String Condicion = " where 1 = 1";

        if (Secuencial.length() > 0) {
            Condicion = Condicion + " and secuencial like '%" + Secuencial + "%'";
        }
        if (Transacciones_id.length() > 0) {
            Condicion = Condicion + " and transacciones_id like '%" + Transacciones_id + "%'";
        }
        if (Empresas_id.length() > 0) {
            Condicion = Condicion + " and empresas_id like '" + Empresas_id + "'";
        }

        if (Id.length() > 0) {
            
        }

        String[] columnas = {"empresas_id", "tipo", "proveedoresclientes_id", "transacciones_id", "serie1", "serie2", "factura", "fecha", "secuencial"};
        Object[][] data = mySql.GetTabla(columnas, "movimientos", "select * from movimientos  " + Condicion + ";", Condicion);
        return data;
    }
 
    
    
}
