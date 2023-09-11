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

public class UsuarioEditar {
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
    public void editarUsuario(int cedula, String nuevoNombre, String nuevosApellidos, String nuevoCelular, String nuevaDireccion, String nuevoEmail) {
        if (usuarioExiste(cedula)) {
            Connection conexion = null;
            PreparedStatement preparedStatement = null;

            try {
                // Obtener la conexión desde la clase Conexion
                conexion = Conexion.conector(); // Utiliza el método conector de tu clase Conexion

                // Consulta SQL de actualización
                String sql = "UPDATE usuarios SET nombre_usuario=?, apellidos_usuario=?, celular_usuario=?, direccion_usuario=?, email_usuario=? WHERE cedula_usuario=?";
                preparedStatement = conexion.prepareStatement(sql);

                // Establecer los valores de los parámetros
                preparedStatement.setString(1, nuevoNombre);
                preparedStatement.setString(2, nuevosApellidos);
                preparedStatement.setString(3, nuevoCelular);
                preparedStatement.setString(4, nuevaDireccion);
                preparedStatement.setString(5, nuevoEmail);
                preparedStatement.setInt(6, cedula);

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
/**
    public static void main(String[] args) {
        // creacion de la instancia u objeto
        UsuarioEditar usuarioEditar = new UsuarioEditar();

        // Verificar la existencia del usuario antes de editar
        int cedula = 86073613; // Cédula del usuario a editar
        if (usuarioEditar.usuarioExiste(cedula)) {
            // Ejemplo de edición de un usuario ficticio
            usuarioEditar.editarUsuario(cedula, "NuevoNombre", "NuevosApellidos", "5555555555", "NuevaDireccion", "nuevo@example.com");
        }
    }**/
}

