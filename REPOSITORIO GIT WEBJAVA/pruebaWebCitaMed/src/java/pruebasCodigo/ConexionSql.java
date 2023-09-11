/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package pruebasCodigo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;

/**
 *
 * @author Mario Gandara
 */
public class ConexionSql extends javax.swing.JFrame {

    /**
     * Creates new form ConexionSql
     */
    public ConexionSql() {
        initComponents();
    }

    public void buscarTablas(){
     String bases="";
        try{            
            Statement sql = Conexion.conector().createStatement();            
            String consulta="SHOW TABLES FROM citameddb;";
            ResultSet resultado = sql.executeQuery(consulta);
            
            while(resultado.next()){
            bases +=resultado.getString(1)+"\n";
            System.out.println("resultado :"+bases);
            
            }
             JOptionPane.showMessageDialog(null, bases);
             System.out.println("resultado :"+bases);
            }catch(SQLException ex){
             JOptionPane.showMessageDialog(null, ex);
             System.out.println("error"+ex);        
        }
    }
    public void mostrarUsuarios2() {
    StringBuilder bases = new StringBuilder(); // Usamos StringBuilder para una mejor eficiencia

    try {
        Connection conexion = Conexion.conector();
        Statement sql = conexion.createStatement();
        String consulta = "SELECT * FROM usuarios;";
        ResultSet resultado = sql.executeQuery(consulta);

        while (resultado.next()) {
            // Obtenemos todos los campos de cada registro
            int cedula = resultado.getInt("cedula_usuario");
            String nombre = resultado.getString("nombre_usuario");
            String apellidos = resultado.getString("apellidos_usuario");
            String celular = resultado.getString("celular_usuario");
            String direccion = resultado.getString("direccion_usuario");
            String email = resultado.getString("email_usuario");

            // Agregamos los valores al StringBuilder
            bases.append("Cedula: ").append(cedula).append("\n");
            bases.append("Nombre: ").append(nombre).append("\n");
            bases.append("Apellidos: ").append(apellidos).append("\n");
            bases.append("Celular: ").append(celular).append("\n");
            bases.append("Dirección: ").append(direccion).append("\n");
            bases.append("Email: ").append(email).append("\n");
            bases.append("\n");
        }

        JOptionPane.showMessageDialog(null, bases.toString());
        System.out.println("Resultado:\n" + bases.toString());
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, ex);
        System.out.println("Error: " + ex);
    }
}
    
     public void mostrarUsuarios(){
     String bases="";
        try{            
            Statement sql = Conexion.conector().createStatement();            
            String consulta="SELECT * FROM usuarios;;";
            ResultSet resultado = sql.executeQuery(consulta);
            
            while(resultado.next()){
            bases +=resultado.getString(1)+"\n";
            System.out.println("resultado :"+bases);
            
            }
             JOptionPane.showMessageDialog(null, bases);
             System.out.println("resultado :"+bases);
            }catch(SQLException ex){
             JOptionPane.showMessageDialog(null, ex);
             System.out.println("error"+ex);        
        }
    }
    
 public void insertarUsuario(String cedula, String nombre, String apellidos, String celular, String direccion, String email) {
    Connection conexion = null;
    PreparedStatement preparedStatement = null;

    try {
        // Obtiene la conexión desde la clase Conexion
        conexion = Conexion.conector();

        // Consulta SQL de inserción
        String sql = "INSERT INTO usuarios (cedula_usuario, nombre_usuario, apellidos_usuario, celular_usuario, direccion_usuario, email_usuario) VALUES (?, ?, ?, ?, ?, ?)";

        // Crea la declaración preparada
        preparedStatement = conexion.prepareStatement(sql);

        // Establece los valores de los parámetros
        preparedStatement.setString(1, cedula);
        preparedStatement.setString(2, nombre);
        preparedStatement.setString(3, apellidos);
        preparedStatement.setString(4, celular);
        preparedStatement.setString(5, direccion);
        preparedStatement.setString(6, email);

        // Ejecuta la inserción
        preparedStatement.executeUpdate();
        
        // Mostrar la lista de tablas después de la inserción
       // buscarTablas();
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
 
 
 
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnConectar = new javax.swing.JButton();
        Insertar = new javax.swing.JButton();
        MostrarUsuarios = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        Editar = new javax.swing.JButton();
        Eliminar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnConectar.setText("Conectar");
        btnConectar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConectarActionPerformed(evt);
            }
        });

        Insertar.setText("Insertar");
        Insertar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InsertarActionPerformed(evt);
            }
        });

        MostrarUsuarios.setText("Mostrar Usuarios");
        MostrarUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MostrarUsuariosActionPerformed(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        Editar.setText("Editar");
        Editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditarActionPerformed(evt);
            }
        });

        Eliminar.setText("Eliminar");
        Eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Editar)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnConectar)
                                .addGap(38, 38, 38)
                                .addComponent(Insertar)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(MostrarUsuarios))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addComponent(Eliminar)))))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnConectar)
                    .addComponent(Insertar)
                    .addComponent(MostrarUsuarios))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Editar)
                    .addComponent(Eliminar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnConectarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConectarActionPerformed
      
       buscarTablas();
       
    }//GEN-LAST:event_btnConectarActionPerformed

    private void InsertarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InsertarActionPerformed
        insertarUsuario("86073613", "MARIO DAVID", "GANDARA ROMERO", "3012710484", "MONTERIA", "mdgandara@soy.sena.edu.co");
    }//GEN-LAST:event_InsertarActionPerformed

    private void MostrarUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MostrarUsuariosActionPerformed
//        mostrarUsuarios();
        System.out.println("Segundo metodo");
        mostrarUsuarios2();
        //ejemplo
      //  String textoParaMostrar = mostrarUsuarios2();

        // Establecer el texto en jTextArea1
    //    jTextArea1.setText(textoParaMostrar);
    }//GEN-LAST:event_MostrarUsuariosActionPerformed

    private void EditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditarActionPerformed
       
        // creacion de la instancia u objeto
        UsuarioEditar usuarioEditar = new UsuarioEditar();
        // Verificar la existencia del usuario antes de editar
        int cedula = 86073613; // Cédula del usuario a editar
        if (usuarioEditar.usuarioExiste(cedula)) {
            System.out.println(usuarioEditar.usuarioExiste(cedula));
            // Ejemplo de edición de un usuario ficticio
            usuarioEditar.editarUsuario(86073613, "Juan Diego", "Arias Duque", "3002722164", "sincelejo", "nuevo@example.com");
        } 
    }//GEN-LAST:event_EditarActionPerformed

    private void EliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarActionPerformed
        // creacion de la instancia u objeto
        UsuarioBorrar usuarioBorrar = new UsuarioBorrar();
        // Verificar la existencia del usuario antes de editar
        int cedula = 86073613; // Cédula del usuario a editar
        if (usuarioBorrar.usuarioExiste(cedula)) {
            System.out.println(usuarioBorrar.usuarioExiste(cedula));
            // Ejemplo de edición de un usuario ficticio
            usuarioBorrar.borrarUsuario(cedula);
        } 
    }//GEN-LAST:event_EliminarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ConexionSql.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConexionSql.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConexionSql.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConexionSql.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConexionSql().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Editar;
    private javax.swing.JButton Eliminar;
    private javax.swing.JButton Insertar;
    private javax.swing.JButton MostrarUsuarios;
    private javax.swing.JButton btnConectar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
