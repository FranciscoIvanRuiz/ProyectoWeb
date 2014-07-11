/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package BaseDatos;
import java.sql.*;

/**
 *
 * @author Francisco Ivan Ruiz Simbana (francisco.ivan.ruiz@gmail.com)
 *
 */
public class Conexion {
    
   private final String Base = "test";
   private final String Usuario = "root";
   private final String Contrasena = "1980";
   private final String url = "jdbc:mysql://localhost/"+Base;

   Connection conn = null;

   /** Constructor de DbConnection */
   public Conexion() {
      try{
         //obtenemos el driver de para mysql
         Class.forName("com.mysql.jdbc.Driver");
         //obtenemos la conexión
         conn = DriverManager.getConnection(url,Usuario,Contrasena);
         if (conn!=null){
            System.out.println("Conexión a base de datos "+Base+". listo");
         }
      }catch(SQLException e){
         System.out.println(e);
      }catch(ClassNotFoundException e){
         System.out.println(e);
      }
   }
   /**Permite retornar la conexión*/
   public Connection getConnection(){
      return conn;
   }

   public void desconectar(){
      conn = null;
      System.out.println("La conexion a la  base de datos "+Base+" a terminado");
   }
}
