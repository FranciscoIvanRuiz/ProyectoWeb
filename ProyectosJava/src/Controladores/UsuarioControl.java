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
    private String Id_Usuario="";
    
     public UsuarioControl(){    
    }

      public boolean Existe_Usuario(String Id){
        this.Id_Usuario=Id;
        return mySql.existe("ID", " from usuarios where id='"+Id+"';");
    }

     public String getNombreUsuario(){        
        return mySql.GetDataString("nombre", "select nombre from usuarios where id='"+this.Id_Usuario+"';");
    }
     
       public String getClaveUsuario(){        
        return mySql.GetDataString("clave", "select clave from usuarios where id='"+this.Id_Usuario+"';");
    }
}
