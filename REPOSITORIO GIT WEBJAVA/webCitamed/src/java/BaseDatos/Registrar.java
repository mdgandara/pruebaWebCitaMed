/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BaseDatos;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;

/**
 *
 * @author Sena
 */
public class Registrar {
    
    public boolean usuarioExiste(int cedula) {
        Connection conexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            // Obtener la conexión desde la clase Conexion
            conexion = Conexion.conector(); // Utiliza el método conector de tu clase Conexion
            // Consulta SQL para buscar un usuario por su cédula
            String sql = "SELECT * FROM usuarios WHERE cedula_usuario=?";
            preparedStatement = conexion.prepareStatement(sql);
            preparedStatement.setInt(1, cedula);
            resultSet = preparedStatement.executeQuery();
            // Si se encuentra al menos un registro, el usuario existe
          //  System.out.println("Busqueda");
         //   System.out.println(resultSet.next());
            return resultSet.next();           

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al verificar la existencia del usuario: " + e.getMessage());
            return false;
        } finally {
            try {
                // Cerrar la conexión, la declaración preparada y el resultado
                if (resultSet != null) {
                    resultSet.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (conexion != null) {
                    conexion.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }



public void insertarUsuario( String nombre, String apellido, int cedula, String celular, String email, String password ) {
    Connection conexion = null;
    PreparedStatement preparedStatement = null;

    try {
        // Obtiene la conexión desde la clase Conexion
        conexion = Conexion.conector();
        
        // Consulta SQL de inserción
         String sql = "INSERT INTO usuarios (nombre, apellido, cedula, celular, email, password) VALUES (?, ?, ?, ?, ?, ?)";
          PreparedStatement statement = conexion.prepareStatement(sql);
                            statement.setString(1, nombre);
                            statement.setString(2, apellido);
                            statement.setInt(3, cedula);
                            statement.setString(4, celular);
                            statement.setString(5, email);
                            statement.setString(6, password);

    // Ejecutar la consulta
    int filasAfectadas = statement.executeUpdate();

        // Ejecuta la inserción
       
        
        preparedStatement.executeUpdate();
        
        // Mostrar la lista de tablas después de la inserción
//        buscarTablas();
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        try {
            // Cierra la conexión y la declaración preparada
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (conexion != null) {
                conexion.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
} // fin insertarUsuarios
    
    
    
}
