/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package BaseDatos;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;


/**
 *
 * @author Francisco Ivan Ruiz Simbana (francisco.ivan.ruiz@gmail.com)
 */
public class Sql {
    private Conexion con;

    public Sql(){
        con = new Conexion();
    }

     /*
    * INSERTRA UN NUEVO REGISTRO EN LA BASE DE DATOS
    * PARAMETROS(Un array de String con los datos a insertar,la instruccion sql)
    */
  public boolean Ejecutar_Insruccion_Sql(String datos[], String sql){
      boolean ok=false;
       try {
            PreparedStatement pstm = con.getConnection().prepareStatement(sql);
            for(int i=0; i<=datos.length-1;i++){
                pstm.setString(i+1, datos[i]);
            }
            pstm.execute();
            pstm.close();
            ok=true;
         }catch(SQLException e){
         System.out.println(e);
      }
      return ok;
   }

   public int LlavePrimaria(String from_where){
      int Id = 0; 
      try{
         PreparedStatement pstm = con.getConnection().prepareStatement("SELECT id as llaveprimaria  " + from_where);
         ResultSet res = pstm.executeQuery();
         res.next();
         Id = res.getInt("llaveprimaria");
         res.close();
         
      }catch(SQLException e){
        System.out.println(e);
      }
      if (Id >0){return Id;}else{return 0;}
   }
  
 
  public boolean existe(String campo, String from_where){
     int registros = 0;
     try{
         PreparedStatement pstm = con.getConnection().prepareStatement("SELECT count("+campo+") as total  " + from_where);
         ResultSet res = pstm.executeQuery();
         res.next();
         registros = res.getInt("total");
         res.close();
      }catch(SQLException e){
         System.out.println(e);
      }
     //true: existe
     //false: no existe
     if (registros >0){return true;}else{return false;}
  }

    public String GetDataString(String colName, String sql){
    String data ="";
      try{
         PreparedStatement pstm = con.getConnection().prepareStatement(sql);
         ResultSet res = pstm.executeQuery();
         while(res.next()){
            data = res.getString(colName);
         }
         res.close();
          }catch(SQLException e){
         System.out.println(e);
    }
    return data;
    }

    public Double GetDataDouble(String colName, String sql){
    double data =0;
      try{
         PreparedStatement pstm = con.getConnection().prepareStatement(sql);
         ResultSet res = pstm.executeQuery();
         while(res.next()){
            data = res.getDouble(colName);
         }
         res.close();
          }catch(SQLException e){
         System.out.println(e);
    }
    return data;
    }

    public Object[] GetColumna(String tabla, String colName, String sql){
      int registros = 0;
      //obtenemos la cantidad de registros existentes en la tabla
      try{
         PreparedStatement pstm = con.getConnection().prepareStatement("SELECT count(*) as total FROM " + tabla);
         ResultSet res = pstm.executeQuery();
         res.next();
         registros = res.getInt("total");
         res.close();
      }catch(SQLException e){
         System.out.println(e);
      }

    Object[] data = new Object[registros];
      try{
         PreparedStatement pstm = con.getConnection().prepareStatement(sql);
         ResultSet res = pstm.executeQuery();
         int i = 0;
         while(res.next()){
            data[i] = res.getObject(colName);
            i++;
         }
         res.close();
          }catch(SQLException e){
         System.out.println(e);
    }
    return data;
 }

      /*  METODO PARA OBTENER TODOS LOS DATOS DE UNA TABLA
    *  parametros (Un array con los nombres de las columnas, el nombre de la tabla, la instruccion sql)
    */
   public Object [][] GetTabla(String colName[], String tabla, String sql , String Where){
      int registros = 0;
      //obtenemos la cantidad de registros existentes en la tabla
      try{
         PreparedStatement pstm = con.getConnection().prepareStatement("SELECT count(*) as total FROM " + tabla + Where);
         ResultSet res = pstm.executeQuery();
         res.next();
         registros = res.getInt("total");
         res.close();
      }catch(SQLException e){
         System.out.println(e);
      }

    Object[][] data = new String[registros][colName.length];
    String col[] = new String[colName.length];
    //realizamos la consulta sql y llenamos los datos en "Object"
      try{
         PreparedStatement pstm = con.getConnection().prepareStatement(sql);
         ResultSet res = pstm.executeQuery();
         int i = 0;
         while(res.next()){
            for(int j=0; j<=colName.length-1;j++){
                col[j] = res.getString(colName[j]);
                data[i][j] = col[j];
            }
            i++;
         }
         res.close();
          }catch(SQLException e){
         System.out.println(e);
    }
    return data;
 }
}
