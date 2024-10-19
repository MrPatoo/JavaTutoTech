package vista;

import controlador.ctrlMenuPrincipal;
import java.awt.CardLayout;
import javax.swing.JPanel;
import modelo.Leccion;
import modelo.Tutoria;

public class frmMenuPrincipal extends javax.swing.JFrame {
    public frmMenuPrincipal() {
        initComponents();
        this.setLocationRelativeTo(this);  // Centra la ventana
    }
    public static void initfrmMenuPrincipal(){
        frmMenuPrincipal vista = new frmMenuPrincipal();
        
        // Paneles y modelos
        jpAddTutoria panelTutoria = new jpAddTutoria();
        Tutoria modeloTutoria = new Tutoria();
        
        jpAddLeccion panelLeccion = new jpAddLeccion();
        Leccion modeloLeccion = new Leccion();
        
        // Controlador
        ctrlMenuPrincipal controlador = new ctrlMenuPrincipal(vista, panelTutoria, modeloTutoria, panelLeccion, modeloLeccion);     
        vista.setVisible(true);
    }
@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnIrTutoria = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnIrLeccion = new javax.swing.JButton();
        jpContenedor = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(47, 88, 212));

        btnIrTutoria.setBackground(new java.awt.Color(76, 130, 252));
        btnIrTutoria.setFont(new java.awt.Font("Roboto Light", 0, 18)); // NOI18N
        btnIrTutoria.setForeground(new java.awt.Color(255, 255, 255));
        btnIrTutoria.setText("Agregar Tutoría");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/img/Imagen1.png"))); // NOI18N
        jLabel1.setText("jLabel1");

        btnIrLeccion.setBackground(new java.awt.Color(76, 130, 252));
        btnIrLeccion.setFont(new java.awt.Font("Roboto Light", 0, 18)); // NOI18N
        btnIrLeccion.setForeground(new java.awt.Color(255, 255, 255));
        btnIrLeccion.setText("Agregar Leccion");
        btnIrLeccion.setMaximumSize(new java.awt.Dimension(116, 26));
        btnIrLeccion.setMinimumSize(new java.awt.Dimension(116, 26));
        btnIrLeccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIrLeccionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnIrLeccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnIrTutoria, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(btnIrTutoria, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(75, 75, 75)
                .addComponent(btnIrLeccion, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(259, Short.MAX_VALUE))
        );

        jpContenedor.setBackground(new java.awt.Color(255, 255, 255));
        jpContenedor.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jpContenedor, javax.swing.GroupLayout.PREFERRED_SIZE, 972, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jpContenedor, javax.swing.GroupLayout.PREFERRED_SIZE, 706, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIrLeccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIrLeccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnIrLeccionActionPerformed
public static void main(String args[]) {
       java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                initfrmMenuPrincipal();
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnIrLeccion;
    public javax.swing.JButton btnIrTutoria;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JPanel jpContenedor;
    // End of variables declaration//GEN-END:variables
}
