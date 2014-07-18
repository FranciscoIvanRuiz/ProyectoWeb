/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import BaseDatos.Sql;
import javax.swing.JOptionPane;

/**
 *
 * @author ivanruiz
 */
public class EmpresaControl {

    private Sql mySql = new Sql();
    public Integer Id = 0;
    private String Nombre = "";
    private String Ruc = "";
    private String Telefono = "";
    private String Fax = "";
    private String Correo = "";
    private String Direccion = "";
    private String Web = "";
    private String Personas_id = "";

    public EmpresaControl() {
    }

    public boolean Existe_Empresa(Integer Id, String Nombre, String Ruc, String Telefono, String Fax, String Correo, String Direccion, String Web, String Personas_id) {
        this.Id = Id;
        this.Nombre = Nombre;
        this.Ruc = Ruc;
        this.Telefono = Telefono;
        this.Fax = Fax;
        this.Correo = Correo;
        this.Direccion = Direccion;
        this.Web = Web;
        this.Personas_id = Personas_id;

        System.out.println(Ruc);

        this.Id = mySql.LlavePrimaria(" from empresas where ruc='" + Ruc + "' ;");
        return mySql.existe("ID", " from empresas where ruc='" + Ruc + "' ;");
    }

    public Object[][] getDatoEmpresa(Integer Id) {
        String[] columnas = {"nombre", "ruc", "telefono", "fax", "correo", "direccion", "web", "personas_id"};
        Object[][] data = mySql.GetTabla(columnas, "empresas", "select * from empresas where id='" + Id + "';");
        return data;
    }

    public void CrearEmpresa(String Nombre, String Ruc, String Telefono, String Fax, String Correo, String Direccion, String Web, String Personas_id) {
        String[] datos = {Nombre, Ruc, Telefono, Fax, Correo, Direccion, Web, Personas_id};
        mySql.Ejecutar_Insruccion_Sql(datos, "insert into empresas(nombre ,ruc,telefono,fax,correo,direccion,web,personas_id) values(?,?,?,?,?,?,?,?);");
    }
    
    
   public void ActualizarEmpresa(String Nombre, String Ruc, String Telefono, String Fax, String Correo, String Direccion, String Web, String Personas_id , String Id) {
        String[] datos = {Nombre, Ruc, Telefono, Fax, Correo, Direccion, Web, Personas_id,Id};
        mySql.Ejecutar_Insruccion_Sql(datos, " update empresas set nombre  = ?,ruc  = ?,telefono  = ?,fax  = ?,correo  = ?,direccion  = ?,web  = ?,personas_id  = ? where id = ? ;");
    }
    
    
    public Object[][] BuscarEmpresa(String Nombre, String Ruc, String Telefono, String Fax, String Correo, String Direccion, String Web, String Personas_id, String Id) {

        if (Nombre.length()>0){}
        if (Ruc.length()>0){}
        if (Telefono.length()>0){}
       if (Fax.length()>0){}
       if (Correo.length()>0){}
       if (Direccion.length()>0){}
       if (Web.length()>0){}
       if (Personas_id.length()>0){}
       if (Id.length()>0){}
        
        String[] columnas = {"nombre", "ruc", "telefono", "fax", "correo", "direccion", "web", "personas_id", "id"};
        Object[][] data = mySql.GetTabla(columnas, "empresas", "select * from empresas where id='" + Id + "';");
        return data;
    }
    
}
