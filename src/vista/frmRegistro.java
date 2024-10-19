/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;
import controlador.CtrlRegistro;
import controlador.ctrlMenuPrincipal;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import modelo.Tutoria;
import modelo.Usuario;

public class frmRegistro extends javax.swing.JFrame {

    public frmRegistro() {
        initComponents();
    }
    
    public static void initfrmRegistro(){
        Usuario modelo = new Usuario();
        frmRegistro vista = new frmRegistro();
        //tienen que ir todos en orden
        CtrlRegistro controlador = new CtrlRegistro(modelo, vista);        
        vista.setVisible(true);          
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel21 = new javax.swing.JLabel();
        btnRegistrar = new javax.swing.JButton();
        txtContra = new javax.swing.JPasswordField();
        txtCorreo = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        lbIrasesion = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtedad = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        btnRegUser = new javax.swing.JButton();
        txtClave = new javax.swing.JPasswordField();
        txtMail = new javax.swing.JTextField();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        lblSesion = new javax.swing.JLabel();
        txtNombreUser = new javax.swing.JTextField();
        txtEdadU = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        jLabel21.setBackground(new java.awt.Color(255, 255, 255));
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Clave:");

        btnRegistrar.setText("Registrar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        txtCorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCorreoActionPerformed(evt);
            }
        });

        jLabel22.setBackground(new java.awt.Color(255, 255, 255));
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Edad:");

        jLabel23.setBackground(new java.awt.Color(255, 255, 255));
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("Nombre de usuario:");

        lbIrasesion.setForeground(new java.awt.Color(102, 255, 102));
        lbIrasesion.setText("¿YA TIENES CUENTA? inicia sesion aqui");

        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });

        txtedad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtedadActionPerformed(evt);
            }
        });

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/img/Imagen1.png"))); // NOI18N
        jLabel19.setText("jLabel1");

        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Correo Electronico:");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));
        jPanel12.setPreferredSize(new java.awt.Dimension(1252, 841));

        jLabel45.setFont(new java.awt.Font("Roboto Medium", 0, 12)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(47, 88, 212));
        jLabel45.setText("Correo Electronico:");

        jLabel46.setBackground(new java.awt.Color(255, 255, 255));
        jLabel46.setFont(new java.awt.Font("Roboto Medium", 0, 12)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(47, 88, 212));
        jLabel46.setText("Clave:");

        btnRegUser.setBackground(new java.awt.Color(76, 130, 252));
        btnRegUser.setFont(new java.awt.Font("Roboto Medium", 0, 12)); // NOI18N
        btnRegUser.setForeground(new java.awt.Color(255, 255, 255));
        btnRegUser.setText("Registrar");
        btnRegUser.setPreferredSize(new java.awt.Dimension(73, 23));
        btnRegUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegUserActionPerformed(evt);
            }
        });

        txtClave.setBackground(new java.awt.Color(235, 235, 250));

        txtMail.setBackground(new java.awt.Color(235, 235, 250));
        txtMail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMailActionPerformed(evt);
            }
        });

        jLabel47.setBackground(new java.awt.Color(255, 255, 255));
        jLabel47.setFont(new java.awt.Font("Roboto Medium", 0, 12)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(47, 88, 212));
        jLabel47.setText("Edad:");

        jLabel48.setBackground(new java.awt.Color(255, 255, 255));
        jLabel48.setFont(new java.awt.Font("Roboto Medium", 0, 12)); // NOI18N
        jLabel48.setForeground(new java.awt.Color(47, 88, 212));
        jLabel48.setText("Nombre de usuario:");

        lblSesion.setForeground(new java.awt.Color(47, 88, 212));
        lblSesion.setText("¿YA TIENES CUENTA? inicia sesion aqui");

        txtNombreUser.setBackground(new java.awt.Color(235, 235, 250));
        txtNombreUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreUserActionPerformed(evt);
            }
        });

        txtEdadU.setBackground(new java.awt.Color(235, 235, 250));
        txtEdadU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEdadUActionPerformed(evt);
            }
        });

        jPanel1.setLayout(new javax.swing.OverlayLayout(jPanel1));

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Steven\\JavaProjects\\JavaTutoTech\\src\\vista\\img\\login.png")); // NOI18N
        jLabel1.setPreferredSize(new java.awt.Dimension(655, 850));
        jPanel1.add(jLabel1);

        jLabel2.setFont(new java.awt.Font("Nirmala UI", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(47, 88, 212));
        jLabel2.setText("REGISTRATE");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/img/Group 1.jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addContainerGap(58, Short.MAX_VALUE)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNombreUser, javax.swing.GroupLayout.PREFERRED_SIZE, 473, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMail, javax.swing.GroupLayout.PREFERRED_SIZE, 473, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEdadU, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtClave, javax.swing.GroupLayout.PREFERRED_SIZE, 473, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnRegUser, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel46)
                            .addComponent(jLabel47)
                            .addComponent(jLabel48)
                            .addComponent(jLabel45)
                            .addComponent(jLabel3))
                        .addGap(51, 51, 51))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addGap(190, 190, 190)
                                .addComponent(jLabel2))
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addGap(188, 188, 188)
                                .addComponent(lblSesion)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(jLabel2)
                .addGap(10, 10, 10)
                .addComponent(jLabel45)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtMail, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel48)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNombreUser, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel47)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtEdadU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel46)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtClave, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnRegUser, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addComponent(lblSesion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(63, 63, 63))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, 1239, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, 846, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void txtCorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCorreoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCorreoActionPerformed

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void txtedadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtedadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtedadActionPerformed

    private void txtEdadUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEdadUActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEdadUActionPerformed

    private void txtNombreUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreUserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreUserActionPerformed

    private void txtMailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMailActionPerformed

    private void btnRegUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegUserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRegUserActionPerformed
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
            java.util.logging.Logger.getLogger(frmRegistro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmRegistro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmRegistro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmRegistro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmRegistro().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnRegUser;
    public javax.swing.JButton btnRegistrar;
    public javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel12;
    public javax.swing.JLabel lbIrasesion;
    public javax.swing.JLabel lblSesion;
    public javax.swing.JPasswordField txtClave;
    private javax.swing.JPasswordField txtContra;
    private javax.swing.JTextField txtCorreo;
    public javax.swing.JTextField txtEdadU;
    public javax.swing.JTextField txtMail;
    private javax.swing.JTextField txtNombre;
    public javax.swing.JTextField txtNombreUser;
    private javax.swing.JTextField txtedad;
    // End of variables declaration//GEN-END:variables

    public JButton getBtnRegUser() {
        return btnRegUser;
    }
    public void setBtnRegUser(JButton btnRegUser) {
        this.btnRegUser = btnRegUser;
    }
    public JLabel getLblSesion() {
        return lblSesion;
    }
    public void setLblSesion(JLabel lblSesion) {
        this.lblSesion = lblSesion;
    }
    public JPasswordField getTxtClave() {
        return txtClave;
    }
    public void setTxtClave(JPasswordField txtClave) {
        this.txtClave = txtClave;
    }
    public JTextField getTxtEdadU() {
        return txtEdadU;
    }
    public void setTxtEdadU(JTextField txtEdadU) {
        this.txtEdadU = txtEdadU;
    }
    public JTextField getTxtMail() {
        return txtMail;
    }
    public void setTxtMail(JTextField txtMail) {
        this.txtMail = txtMail;
    }
    public JTextField getTxtNombreUser() {
        return txtNombreUser;
    }
    public void setTxtNombreUser(JTextField txtNombreUser) {
        this.txtNombreUser = txtNombreUser;
    }
}
