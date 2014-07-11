/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controladores;
import BaseDatos.Sql;

/**
 *
 * @author Francisco Ivan Ruiz Simbana (francisco.ivan.ruiz@gmail.com)
 */
public class UsuarioControl {
    private Sql mySql = new Sql();
    public Integer Id=0;
    private String Usuario="";
    private String Clave="";
    
     public UsuarioControl(){    
    }

     
     
      public boolean Existe_Usuario(Integer Id , String Usuario , String Clave){
        this.Id=Id;
        this.Usuario=Usuario;
        this.Clave=Clave;
        this.Id = mySql.LlavePrimaria(" from usuarios where usuario='"+Usuario+"' and clave='"+Clave+"';");
        return mySql.existe("ID", " from usuarios where usuario='"+Usuario+"' and clave='"+Clave+"';");
    }

     public String getNombreUsuario(){        
        return mySql.GetDataString("nombre", "select nombre from usuarios where id='"+this.Id+"';");
    }
     
       public String getClaveUsuario(){        
        return mySql.GetDataString("clave", "select clave from usuarios where id='"+this.Id+"';");
    }
}
