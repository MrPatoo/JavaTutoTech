package vista;

import controlador.CtrlLogin;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import modelo.Usuario;

public class FrmLogin extends javax.swing.JFrame {
    public FrmLogin() {
        initComponents();   
    }
    public static void initFrmLogin(){
        Usuario modelo = new Usuario();
        FrmLogin vista = new FrmLogin();
        CtrlLogin controlador = new CtrlLogin(modelo, vista);        
        vista.setVisible(true);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jBtnInicia = new javax.swing.JButton();
        jTxtPass = new javax.swing.JPasswordField();
        jTxtMail = new javax.swing.JTextField();
        lblRecupera = new javax.swing.JLabel();
        lblCrearCta = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(47, 88, 212));
        jLabel2.setText("Correo Electronico:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 270, -1, -1));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(47, 88, 212));
        jLabel3.setText("Clave:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 380, -1, -1));

        jBtnInicia.setBackground(new java.awt.Color(76, 130, 252));
        jBtnInicia.setFont(new java.awt.Font("Roboto Medium", 0, 12)); // NOI18N
        jBtnInicia.setForeground(new java.awt.Color(255, 255, 255));
        jBtnInicia.setText("Ingresar");
        jBtnInicia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnIniciaActionPerformed(evt);
            }
        });
        jPanel1.add(jBtnInicia, new org.netbeans.lib.awtextra.AbsoluteConstraints(83, 482, 124, 41));

        jTxtPass.setBackground(new java.awt.Color(235, 235, 250));
        jTxtPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxtPassActionPerformed(evt);
            }
        });
        jPanel1.add(jTxtPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 410, 427, 30));

        jTxtMail.setBackground(new java.awt.Color(235, 235, 250));
        jTxtMail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxtMailActionPerformed(evt);
            }
        });
        jPanel1.add(jTxtMail, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 300, 427, 30));

        lblRecupera.setFont(new java.awt.Font("Roboto Light", 0, 14)); // NOI18N
        lblRecupera.setForeground(new java.awt.Color(47, 88, 212));
        lblRecupera.setText("¿No recuerdas tu clave?");
        jPanel1.add(lblRecupera, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 530, -1, -1));

        lblCrearCta.setFont(new java.awt.Font("Roboto Light", 0, 14)); // NOI18N
        lblCrearCta.setForeground(new java.awt.Color(47, 88, 212));
        lblCrearCta.setText("¿Desea crear cuenta?");
        jPanel1.add(lblCrearCta, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 530, -1, -1));

        jLabel4.setFont(new java.awt.Font("Nirmala UI", 1, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(47, 88, 212));
        jLabel4.setText("BIENVENIDO A TUTOTECH");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(61, 91, -1, -1));

        jPanel2.setLayout(new javax.swing.OverlayLayout(jPanel2));

        jLabel5.setIcon(new javax.swing.ImageIcon("C:\\Users\\Steven\\JavaProjects\\JavaTutoTech\\src\\vista\\img\\Register.png")); // NOI18N
        jPanel2.add(jLabel5);

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(591, 0, -1, -1));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(61, 157, 447, 10));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/img/iconlogin.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 580, -1, -1));

        jLabel7.setFont(new java.awt.Font("Roboto Thin", 0, 18)); // NOI18N
        jLabel7.setText("Inicia sesion para continuar");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(186, 173, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTxtMailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtMailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxtMailActionPerformed

    private void jBtnIniciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnIniciaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtnIniciaActionPerformed

    private void jTxtPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtPassActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxtPassActionPerformed
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
            java.util.logging.Logger.getLogger(FrmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            initFrmLogin();
            }
        });
    }   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton jBtnInicia;
    public javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    public javax.swing.JLabel jLabel4;
    public javax.swing.JLabel jLabel5;
    public javax.swing.JLabel jLabel7;
    public javax.swing.JPanel jPanel1;
    public javax.swing.JPanel jPanel2;
    public javax.swing.JSeparator jSeparator1;
    public javax.swing.JTextField jTxtMail;
    public javax.swing.JPasswordField jTxtPass;
    public javax.swing.JLabel lblCrearCta;
    public javax.swing.JLabel lblRecupera;
    // End of variables declaration//GEN-END:variables

    public JButton getjBtnInicia() {
        return jBtnInicia;
    }
    public void setjBtnInicia(JButton jBtnInicia) {
        this.jBtnInicia = jBtnInicia;
    }
    public JTextField getjTxtMail() {
        return jTxtMail;
    }
    public void setjTxtMail(JTextField jTxtMail) {
        this.jTxtMail = jTxtMail;
    }
    public JPasswordField getjTxtPass() {
        return jTxtPass;
    }
    public void setjTxtPass(JPasswordField jTxtPass) {
        this.jTxtPass = jTxtPass;
    }  
    public JLabel getLblRecupera() {
        return lblRecupera;
    }
    public void setLblRecupera(JLabel lblRecupera) {
        this.lblRecupera = lblRecupera;
    }
    public JLabel getLblCrearCta() {
        return lblCrearCta;
    }
    public void setLblCrearCta(JLabel lblCrearCta) {
        this.lblCrearCta = lblCrearCta;
    }
    
    

}
