/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pruebasCodigo;
/**
 *
 * @author Mario Gandara
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class UsuarioBorrar {

    // Método para verificar si un usuario existe por su cédula
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

    // Método para editar un usuario existente o metodo UPDATE
    public void borrarUsuario(int cedula) {
        if (usuarioExiste(cedula)) {
            Connection conexion = null;
            PreparedStatement preparedStatement = null;

            try {
                // Obtener la conexión desde la clase Conexion
                conexion = Conexion.conector(); // Utiliza el método conector de tu clase Conexion

                // Consulta SQL de actualización
                String sql = "DELETE FROM usuarios WHERE cedula_usuario=?";
                preparedStatement = conexion.prepareStatement(sql);

                // Establecer los valores de los parámetros
                
                preparedStatement.setInt(1, cedula);

                // Ejecutar la actualización
                int filasActualizadas = preparedStatement.executeUpdate();

                if (filasActualizadas > 0) {
                    JOptionPane.showMessageDialog(null, "Registro de usuario actualizado correctamente.");
                } else {
                    JOptionPane.showMessageDialog(null, "No se pudo actualizar el registro de usuario.");
                }

            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error al actualizar el registro de usuario: " + e.getMessage());
            } finally {
                try {
                    // Cerrar la conexión y la declaración preparada
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
        } else {
            JOptionPane.showMessageDialog(null, "El usuario con cédula " + cedula + " no existe.");
        }
    }

   
}

