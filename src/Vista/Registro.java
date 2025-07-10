package Vista;
import ConectorDB.Guardado_Users;
import ConectorDB.registro;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class Registro extends javax.swing.JFrame {
    FondoPanel fondo = new FondoPanel();
    String usuario,contraseña;
    Guardado_Users GU;
    


    public Registro() {
        this.setContentPane(fondo);
        initComponents();
        this.setLocationRelativeTo(this);
        this.setResizable(false);
        GU=new Guardado_Users();
        rsscalelabel.RSScaleLabel.setScaleLabel(Regitro, "src/Pictures/Registro.png");
        
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        showPasswrd = new javax.swing.JCheckBox();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Usuario = new javax.swing.JTextField();
        Rpsswrd = new javax.swing.JPasswordField();
        Regitro = new javax.swing.JLabel();
        btnVolver = new javax.swing.JButton();
        btnRegistrar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        Confirmar_contraseña = new javax.swing.JPasswordField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        Apellidos = new javax.swing.JTextField();
        Nombres = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        DNI = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jComboGenero = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Lucida Sans", 1, 24)); // NOI18N
        jLabel1.setText("Registro de Nuevo Usuario");

        showPasswrd.setText("Mostrar Contraseña");
        showPasswrd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showPasswrdActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        jLabel2.setText("Correo o nombre de usuario:");

        jLabel3.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        jLabel3.setText("Contraseña:");

        Usuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UsuarioActionPerformed(evt);
            }
        });

        Rpsswrd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RpsswrdActionPerformed(evt);
            }
        });

        btnVolver.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        btnRegistrar.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnRegistrar.setText("Registrar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        jLabel4.setText("Confirmar Contraseña:");

        Confirmar_contraseña.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Confirmar_contraseñaActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        jLabel5.setText("Nombres:");

        jLabel6.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        jLabel6.setText("Apellidos:");

        Apellidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ApellidosActionPerformed(evt);
            }
        });

        Nombres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NombresActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        jLabel7.setText("DNI:");

        DNI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DNIActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        jLabel8.setText("Genero:");

        jComboGenero.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "(Seleccione su gènero)", "Masculino", "Femenino" }));
        jComboGenero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboGeneroActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(273, 273, 273)
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(DNI, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel5)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(Usuario)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(Rpsswrd, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(Nombres, javax.swing.GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE)
                                .addComponent(jLabel6)
                                .addComponent(jLabel8)
                                .addComponent(jComboGenero, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(Apellidos))
                            .addComponent(Confirmar_contraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                        .addComponent(Regitro, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(showPasswrd)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(228, 228, 228)
                                .addComponent(btnVolver)
                                .addGap(115, 115, 115)
                                .addComponent(btnRegistrar)))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel1)
                .addGap(30, 30, 30)
                .addComponent(jLabel7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(DNI, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(Nombres, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(Apellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboGenero, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Rpsswrd, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(Confirmar_contraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(showPasswrd)
                        .addGap(34, 34, 34))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(Regitro, javax.swing.GroupLayout.PREFERRED_SIZE, 461, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnVolver)
                    .addComponent(btnRegistrar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void showPasswrdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showPasswrdActionPerformed
        if(showPasswrd.isSelected()){
            Rpsswrd.setEchoChar((char)0);
            Confirmar_contraseña.setEchoChar((char) 0); // Muestra también la contraseña confirmada
        }else{
            Rpsswrd.setEchoChar('\u2022');
            Confirmar_contraseña.setEchoChar('\u2022'); // Oculta la contraseña confirmada
        }
    }//GEN-LAST:event_showPasswrdActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        Menu MN = new Menu();
        MN.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnVolverActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
         CapturaDatos();

    // Validación de los campos
    if (usuario.isEmpty() || contraseña.isEmpty() || Confirmar_contraseña.getText().isEmpty()) {
        JOptionPane.showMessageDialog(this, "Debe rellenar todos los campos.", "Advertencia", JOptionPane.WARNING_MESSAGE);
    } else if (!esNumeroValido(DNI.getText())) {
        JOptionPane.showMessageDialog(this, "El DNI debe contener solo números y tener exactamente 8 caracteres.", "Advertencia", JOptionPane.WARNING_MESSAGE);
    } else if (!validarGenero((String) jComboGenero.getSelectedItem())) {
        JOptionPane.showMessageDialog(this, "Seleccione un género válido (Masculino o Femenino).", "Advertencia", JOptionPane.WARNING_MESSAGE);
    } else if (!contraseña.equals(Confirmar_contraseña.getText())) {
        JOptionPane.showMessageDialog(this, "La contraseña y la confirmación deben coincidir.", "Advertencia", JOptionPane.WARNING_MESSAGE);
    } else if (!validarCorreo(usuario)) {
        JOptionPane.showMessageDialog(this, "Usuario no válido. Debe tener un formato de correo correcto.", "Advertencia", JOptionPane.WARNING_MESSAGE);
    } else if (!validarContraseña(contraseña)) {
        JOptionPane.showMessageDialog(this, "La contraseña debe tener al menos 8 caracteres y contener caracteres especiales.", "Contraseña no válida", JOptionPane.WARNING_MESSAGE);
    } else {
        // Verificar si el DNI ya existe
        int dni = Integer.parseInt(DNI.getText());
        if (GU.dniExistente(dni)) {
            JOptionPane.showMessageDialog(this, "El DNI ya está registrado.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Verificar si el usuario ya existe
        if (GU.usuarioExistente(usuario)) {
            JOptionPane.showMessageDialog(this, "El correo o nombre de usuario ya está registrado.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Si todo está correcto, registramos el nuevo usuario
        String nombres = Nombres.getText();
        String apellidos = Apellidos.getText();
        String genero = (String) jComboGenero.getSelectedItem();

        GU.guardarUsuario(new registro(dni, nombres, apellidos, genero, usuario, contraseña));

        JOptionPane.showMessageDialog(null, "Se registró un nuevo usuario.");
        Login L = new Login();
        L.setVisible(true);
        dispose();
    
}

}    

// Función para validar el género
private boolean validarGenero(String genero) {
    return "Masculino".equals(genero) || "Femenino".equals(genero);
}
private boolean esNumeroValido(String dni) {
    // Verifica que el DNI contenga exactamente 8 caracteres y que todos sean números
    return dni.matches("\\d{8}");
}



// Función para validar la contraseña
public boolean validarContraseña(String contraseña) {
    return contraseña.length() >= 8 && contraseña.matches(".*[!/@#$%^&*()_\\-,.?\":{}|<>].*");
    }//GEN-LAST:event_btnRegistrarActionPerformed
private boolean validarCorreo(String correo) {
        // Validar que el correo sea un Gmail
        return correo.contains("@") && correo.indexOf('@') < correo.length() - 1;
    }
    private void UsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UsuarioActionPerformed

    private void RpsswrdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RpsswrdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RpsswrdActionPerformed

    private void Confirmar_contraseñaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Confirmar_contraseñaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Confirmar_contraseñaActionPerformed

    private void ApellidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ApellidosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ApellidosActionPerformed

    private void NombresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NombresActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NombresActionPerformed

    private void DNIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DNIActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DNIActionPerformed

    private void jComboGeneroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboGeneroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboGeneroActionPerformed

    public void CapturaDatos(){
        
        usuario = Usuario.getText();
        contraseña=Rpsswrd.getText();
    }
    private void Limpiar(){
        Usuario.setText("");
        Rpsswrd.setText("");
        Usuario.requestFocus();
    }
    
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
            java.util.logging.Logger.getLogger(Registro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Registro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Registro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Registro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Registro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Apellidos;
    private javax.swing.JPasswordField Confirmar_contraseña;
    private javax.swing.JTextField DNI;
    private javax.swing.JTextField Nombres;
    private javax.swing.JLabel Regitro;
    private javax.swing.JPasswordField Rpsswrd;
    private javax.swing.JTextField Usuario;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JButton btnVolver;
    private javax.swing.JComboBox<String> jComboGenero;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JCheckBox showPasswrd;
    // End of variables declaration//GEN-END:variables
class FondoPanel extends JPanel
    {
        private Image imagen;
        
        @Override
        public void paint(Graphics g)
        {
            imagen = new ImageIcon(getClass().getResource("/Pictures/fondo_login.png")).getImage();
            
            g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
            
            setOpaque(false);
            
            super.paint(g);
        }
    }


}
