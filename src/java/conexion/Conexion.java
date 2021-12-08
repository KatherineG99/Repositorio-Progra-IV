/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;
import java.sql.Connection;
import java.sql.DriverManager;


public class Conexion {
     static String bd = "EmSoftware";
    static String user = "root";
    static String pass = "root";
    static String url = "jdbc:mysql://localhost:3306/" + bd + "?useSSL=false";
    Connection conn= null;

    public Conexion() {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn=DriverManager.getConnection(url, user, pass);
            if(conn!=null){
                System.out.println("exito en la conexion");
            }
        }catch(Exception e){
            System.out.println("Error conexion "+e);
            
        }
        
    }
    
    public Connection conectar(){
        return conn;
    }
    
    public void desconectar()throws Exception{
        conn.close();
    }
    
  /* public static void main(String[] args) {
        Conexion conn = new Conexion();
    }*/
}
