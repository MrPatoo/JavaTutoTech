/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;

import controlador.CambioClaveController;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import modelo.CambioClave;

/**
 *
 * @author Estudiante
 */
public class frmCambioContrasenia extends javax.swing.JFrame {

    /**
     * Creates new form frmCambioContraseña
     */
    public frmCambioContrasenia() {
        initComponents();
    }

    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLblCode = new javax.swing.JLabel();
        jTxtClave2 = new javax.swing.JTextField();
        jTxtCode = new javax.swing.JTextField();
        jLblClave1 = new javax.swing.JLabel();
        jLblClave2 = new javax.swing.JLabel();
        jTxtClave1 = new javax.swing.JTextField();
        jBtnEnviar = new javax.swing.JButton();

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/img/Imagen1.png"))); // NOI18N
        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(37, 78, 97));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/img/Imagen1.png"))); // NOI18N
        jLabel2.setText("jLabel1");

        jLblCode.setBackground(new java.awt.Color(47, 88, 212));
        jLblCode.setFont(new java.awt.Font("Nirmala UI", 1, 18)); // NOI18N
        jLblCode.setForeground(new java.awt.Color(47, 88, 212));
        jLblCode.setText("INGRESA EL CODIGO ENVIADO");

        jTxtClave2.setBackground(new java.awt.Color(235, 235, 250));
        jTxtClave2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxtClave2ActionPerformed(evt);
            }
        });

        jTxtCode.setBackground(new java.awt.Color(235, 235, 250));
        jTxtCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxtCodeActionPerformed(evt);
            }
        });

        jLblClave1.setFont(new java.awt.Font("Roboto Light", 0, 12)); // NOI18N
        jLblClave1.setForeground(new java.awt.Color(47, 88, 212));
        jLblClave1.setText("Nueva Clave");

        jLblClave2.setBackground(new java.awt.Color(47, 88, 212));
        jLblClave2.setFont(new java.awt.Font("Roboto Light", 0, 12)); // NOI18N
        jLblClave2.setForeground(new java.awt.Color(47, 88, 212));
        jLblClave2.setText("Repetir clave");

        jTxtClave1.setBackground(new java.awt.Color(235, 235, 250));
        jTxtClave1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxtClave1ActionPerformed(evt);
            }
        });

        jBtnEnviar.setBackground(new java.awt.Color(76, 130, 252));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(291, 291, 291)
                        .addComponent(jBtnEnviar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(jLblClave1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTxtClave1, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(jLblClave2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTxtClave2, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(38, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLblCode, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTxtCode, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jTxtCode, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLblCode)))
                .addGap(99, 99, 99)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLblClave1)
                    .addComponent(jTxtClave2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLblClave2)
                    .addComponent(jTxtClave1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtnEnviar)
                .addContainerGap(8, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTxtClave2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtClave2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxtClave2ActionPerformed

    private void jTxtCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtCodeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxtCodeActionPerformed

    private void jTxtClave1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtClave1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxtClave1ActionPerformed

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
            java.util.logging.Logger.getLogger(frmCambioContrasenia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmCambioContrasenia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmCambioContrasenia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmCambioContrasenia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmCambioContrasenia().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnEnviar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLblClave1;
    private javax.swing.JLabel jLblClave2;
    private javax.swing.JLabel jLblCode;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTxtClave1;
    private javax.swing.JTextField jTxtClave2;
    private javax.swing.JTextField jTxtCode;
    // End of variables declaration//GEN-END:variables

    public JLabel getjLblClave1() {
        return jLblClave1;
    }

    public void setjLblClave1(JLabel jLblClave1) {
        this.jLblClave1 = jLblClave1;
    }

    public JLabel getjLblClave2() {
        return jLblClave2;
    }

    public void setjLblClave2(JLabel jLblClave2) {
        this.jLblClave2 = jLblClave2;
    }

    public JLabel getjLblCode() {
        return jLblCode;
    }

    public void setjLblCode(JLabel jLblCode) {
        this.jLblCode = jLblCode;
    }

    public JTextField getjTxtClave1() {
        return jTxtClave1;
    }

    public void setjTxtClave1(JTextField jTxtClave1) {
        this.jTxtClave1 = jTxtClave1;
    }

    public JTextField getjTxtClave2() {
        return jTxtClave2;
    }

    public void setjTxtClave2(JTextField jTxtClave2) {
        this.jTxtClave2 = jTxtClave2;
    }

    public JTextField getjTxtCode() {
        return jTxtCode;
    }

    public void setjTxtCode(JTextField jTxtCode) {
        this.jTxtCode = jTxtCode;
    }

    public JButton getjBtnEnviar() {
        return jBtnEnviar;
    }

    public void setjBtnEnviar(JButton jBtnEnviar) {
        this.jBtnEnviar = jBtnEnviar;
    }

}
