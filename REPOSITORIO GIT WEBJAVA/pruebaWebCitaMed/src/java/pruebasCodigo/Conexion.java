/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pruebasCodigo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author MARIO GANDARA
 */
public class Conexion {
  /**  
    public static Connection getConexion(){
    String conexionUrl="jdbc:mysql://localhost:3309;"
            +"database=citameddb;"
            +"user=root;"
            +"password=543201;"
            +"loginTimeout=30;";
        try{
            Connection con=DriverManager.getConnection(conexionUrl);
            return con;
            }catch(SQLException ex){
                System.out.println(ex.toString());
                return null;
            }
    }
    **/   
    private static Connection con;
  // Declaramos los datos de conexion a la bd
    private static final String driver="com.mysql.cj.jdbc.Driver";
    private static final String user="root";
    private static final String pass="543201";
    private static final String url="jdbc:mysql://localhost:3309/citameddb";
  // Funcion que va conectarse a mi bd de mysql  
    public static Connection conector() {
  // Reseteamos a null la conexion a la bd
        con=null;
        try{
            Class.forName(driver);
            // Nos conectamos a la bd
            con= (Connection) DriverManager.getConnection(url, user, pass);
            // Si la conexion fue exitosa mostramos un mensaje de conexion exitosa
            if (con!=null){
                System.out.println("Conexion establecida");              
            }
        }
        // Si la conexion NO fue exitosa mostramos un mensaje de error
        catch (ClassNotFoundException | SQLException e){
            System.out.println("Error de conexion" + e);
            System.out.println("error"+e);
        }
        return con;
    }
    
    
}
