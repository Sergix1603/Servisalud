package Vista;

import ConectorDB.Conexion;
import java.awt.Graphics;
import java.awt.Image;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Pacientes extends javax.swing.JFrame {
    FondoPanel fondo = new FondoPanel();

    /**
     * Creates new form Pacientes
     */
    public Pacientes() {
        this.setContentPane(fondo);
        initComponents();
        this.setLocationRelativeTo(null);
        this.setExtendedState(this.MAXIMIZED_BOTH);
        updateCombo();
        updateComboUrgencia();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn_return = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TABLA_DATOS = new javax.swing.JTable();
        BTN_LISTAR = new javax.swing.JButton();
        BTN_CONFIRMAR = new javax.swing.JButton();
        BTN_ELIMINAR = new javax.swing.JButton();
        BTN_MODIFICAR = new javax.swing.JButton();
        BTN_REGISTRAR4 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txt_paci_ape = new javax.swing.JTextField();
        txt_paci_nom = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txt_altura = new javax.swing.JTextField();
        txt_Peso = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txt_cod_paci1 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txt_DNI = new javax.swing.JTextField();
        Jcombo_sedes = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        Jcombo_urgencia = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        txt_busqueda = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txt_enfermedad2 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_return.setFont(new java.awt.Font("Perpetua Titling MT", 0, 24)); // NOI18N
        btn_return.setText("Regresar");
        btn_return.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_return.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_returnActionPerformed(evt);
            }
        });
        getContentPane().add(btn_return, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 930, 202, 67));

        TABLA_DATOS.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Codigo", "Nombre", "Apellido", "DNI", "Peso", "Altura", "IMC", "Enfermedad", "Nivel de Urgencia", "Codigo Sucursal"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        TABLA_DATOS.setRowHeight(30);
        jScrollPane1.setViewportView(TABLA_DATOS);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 600, 1540, 296));

        BTN_LISTAR.setFont(new java.awt.Font("Perpetua Titling MT", 0, 24)); // NOI18N
        BTN_LISTAR.setText("Listar");
        BTN_LISTAR.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BTN_LISTAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_LISTARActionPerformed(evt);
            }
        });
        getContentPane().add(BTN_LISTAR, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 500, 202, 67));

        BTN_CONFIRMAR.setFont(new java.awt.Font("Perpetua Titling MT", 0, 24)); // NOI18N
        BTN_CONFIRMAR.setText("Confirmar");
        BTN_CONFIRMAR.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BTN_CONFIRMAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_CONFIRMARActionPerformed(evt);
            }
        });
        getContentPane().add(BTN_CONFIRMAR, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 500, 202, 67));

        BTN_ELIMINAR.setFont(new java.awt.Font("Perpetua Titling MT", 0, 24)); // NOI18N
        BTN_ELIMINAR.setText("Eliminar");
        BTN_ELIMINAR.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BTN_ELIMINAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_ELIMINARActionPerformed(evt);
            }
        });
        getContentPane().add(BTN_ELIMINAR, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 500, 202, 67));

        BTN_MODIFICAR.setFont(new java.awt.Font("Perpetua Titling MT", 0, 24)); // NOI18N
        BTN_MODIFICAR.setText("Modificar");
        BTN_MODIFICAR.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BTN_MODIFICAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_MODIFICARActionPerformed(evt);
            }
        });
        getContentPane().add(BTN_MODIFICAR, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 500, 202, 67));

        BTN_REGISTRAR4.setFont(new java.awt.Font("Perpetua Titling MT", 0, 24)); // NOI18N
        BTN_REGISTRAR4.setText("REGISTRAR");
        BTN_REGISTRAR4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BTN_REGISTRAR4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_REGISTRAR4ActionPerformed(evt);
            }
        });
        getContentPane().add(BTN_REGISTRAR4, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 500, 202, 67));

        jLabel1.setFont(new java.awt.Font("Lucida Sans", 0, 36)); // NOI18N
        jLabel1.setText("Nuestros Pacientes");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 14, -1, -1));

        jLabel2.setFont(new java.awt.Font("Lucida Sans", 0, 24)); // NOI18N
        jLabel2.setText("Ingrese los datos requeridos:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 75, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel4.setText("Código del Paciente:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(56, 134, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel5.setText("Apellido:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 250, -1, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel6.setText("Peso:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 310, -1, -1));

        txt_paci_ape.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        getContentPane().add(txt_paci_ape, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 250, 240, 41));

        txt_paci_nom.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        getContentPane().add(txt_paci_nom, new org.netbeans.lib.awtextra.AbsoluteConstraints(297, 189, 240, 41));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel7.setText("Nombre:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 193, -1, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel8.setText("Altura:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 380, -1, -1));

        txt_altura.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        getContentPane().add(txt_altura, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 380, 150, 41));

        txt_Peso.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        getContentPane().add(txt_Peso, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 310, 150, 41));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel9.setText("Buscar:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 410, -1, 30));

        txt_cod_paci1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        getContentPane().add(txt_cod_paci1, new org.netbeans.lib.awtextra.AbsoluteConstraints(297, 130, 194, 41));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel10.setText("DNI:");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 120, -1, 30));

        txt_DNI.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        getContentPane().add(txt_DNI, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 110, 194, -1));

        Jcombo_sedes.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Jcombo_sedes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Jcombo_sedesActionPerformed(evt);
            }
        });
        getContentPane().add(Jcombo_sedes, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 320, 271, 50));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel11.setText("Nivel de Urgencia:");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 240, -1, 30));

        Jcombo_urgencia.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Jcombo_urgencia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Alto", "Moderado", "Bajo" }));
        Jcombo_urgencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Jcombo_urgenciaActionPerformed(evt);
            }
        });
        getContentPane().add(Jcombo_urgencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 240, 271, 50));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel12.setText("Enfermedad:");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 180, -1, 30));

        txt_busqueda.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        getContentPane().add(txt_busqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 400, 280, 50));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel14.setText("Sucursal:");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 320, -1, 30));

        txt_enfermedad2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        getContentPane().add(txt_enfermedad2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 180, 194, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_returnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_returnActionPerformed
        Menu MN = new Menu();
        MN.setVisible(true);
        dispose();
    }//GEN-LAST:event_btn_returnActionPerformed

    private void BTN_LISTARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_LISTARActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BTN_LISTARActionPerformed

    private void BTN_CONFIRMARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_CONFIRMARActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BTN_CONFIRMARActionPerformed

    private void BTN_ELIMINARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_ELIMINARActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BTN_ELIMINARActionPerformed

    private void BTN_MODIFICARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_MODIFICARActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BTN_MODIFICARActionPerformed

    private void BTN_REGISTRAR4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_REGISTRAR4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BTN_REGISTRAR4ActionPerformed

    private void Jcombo_sedesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Jcombo_sedesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Jcombo_sedesActionPerformed

    private void Jcombo_urgenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Jcombo_urgenciaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Jcombo_urgenciaActionPerformed
private void updateCombo(){
        Statement st;
        Conexion con = new Conexion();
        Connection conexion = con.getConexion();
        String sql  = "select * from sucursales ";
        try {
                st=conexion.prepareStatement(sql);
                ResultSet rs = st.executeQuery(sql);
                while(rs.next()){
                    Jcombo_sedes.addItem(rs.getString("cod_sucursal"));
                }
            } catch (Exception e) {
            }
    }
private void updateComboUrgencia(){
        Statement st;
        Conexion con = new Conexion();
        Connection conexion = con.getConexion();
        String sql  = "select * from urgencias ";
        try {
                st=conexion.prepareStatement(sql);
                ResultSet rs = st.executeQuery(sql);
                while(rs.next()){
                    Jcombo_urgencia.addItem(rs.getString("nivel_urgencia"));
                }
            } catch (Exception e) {
            }
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
            java.util.logging.Logger.getLogger(Pacientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Pacientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Pacientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Pacientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Pacientes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton BTN_CONFIRMAR;
    public javax.swing.JButton BTN_ELIMINAR;
    public javax.swing.JButton BTN_LISTAR;
    public javax.swing.JButton BTN_MODIFICAR;
    public javax.swing.JButton BTN_REGISTRAR4;
    public javax.swing.JComboBox<String> Jcombo_sedes;
    public javax.swing.JComboBox<String> Jcombo_urgencia;
    public javax.swing.JTable TABLA_DATOS;
    public javax.swing.JButton btn_return;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTextField txt_DNI;
    public javax.swing.JTextField txt_Peso;
    public javax.swing.JTextField txt_altura;
    public javax.swing.JTextField txt_busqueda;
    public javax.swing.JTextField txt_cod_paci1;
    public javax.swing.JTextField txt_enfermedad2;
    public javax.swing.JTextField txt_paci_ape;
    public javax.swing.JTextField txt_paci_nom;
    // End of variables declaration//GEN-END:variables
class FondoPanel extends JPanel
    {
        private Image imagen;
        
        @Override
        public void paint(Graphics g)
        {
            imagen = new ImageIcon(getClass().getResource("/Pictures/pacientes.png")).getImage();
            
            g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
            
            setOpaque(false);
            
            super.paint(g);
        }
    }
}
