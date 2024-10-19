package vista;

public class jpAddLeccion extends javax.swing.JPanel {
    
public jpAddLeccion() {
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        txtContenidoLec2 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        btnActualizarLec = new javax.swing.JButton();
        btnEliminarLec = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtFechaLec = new javax.swing.JTextField();
        txtTituloLec = new javax.swing.JTextField();
        txtBuscarLec = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbLeccion = new javax.swing.JTable();
        btnLimpiarLec = new javax.swing.JButton();
        txtContenidoLec = new javax.swing.JTextField();
        btnAgregarLec = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txtStatusLec = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        jLabel5.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel5.setText("Contenido:");

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(940, 400));

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnActualizarLec.setBackground(new java.awt.Color(76, 130, 252));
        btnActualizarLec.setFont(new java.awt.Font("Dubai", 0, 18)); // NOI18N
        btnActualizarLec.setForeground(new java.awt.Color(255, 255, 255));
        btnActualizarLec.setText("Actualizar");
        btnActualizarLec.setPreferredSize(new java.awt.Dimension(84, 39));

        btnEliminarLec.setBackground(new java.awt.Color(76, 130, 252));
        btnEliminarLec.setFont(new java.awt.Font("Dubai", 0, 18)); // NOI18N
        btnEliminarLec.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminarLec.setText("Eliminar");
        btnEliminarLec.setPreferredSize(new java.awt.Dimension(84, 39));
        btnEliminarLec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarLecActionPerformed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(47, 88, 212));
        jLabel1.setFont(new java.awt.Font("Nirmala UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(47, 88, 212));
        jLabel1.setText("UÑADE UNA LECCION NUEVA");

        txtFechaLec.setBackground(new java.awt.Color(235, 235, 250));
        txtFechaLec.setFont(new java.awt.Font("Roboto Light", 0, 18)); // NOI18N
        txtFechaLec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFechaLecActionPerformed(evt);
            }
        });

        txtTituloLec.setBackground(new java.awt.Color(235, 235, 250));
        txtTituloLec.setFont(new java.awt.Font("Roboto Light", 0, 18)); // NOI18N

        txtBuscarLec.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Roboto Light", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(47, 88, 212));
        jLabel2.setText("Titulo:");

        jLabel3.setFont(new java.awt.Font("Roboto Light", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(47, 88, 212));
        jLabel3.setText("Fecha:");

        jLabel4.setFont(new java.awt.Font("Roboto Light", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(47, 88, 212));
        jLabel4.setText("Contenido:");

        jtbLeccion.setBackground(new java.awt.Color(235, 235, 250));
        jtbLeccion.setFont(new java.awt.Font("Roboto Light", 0, 14)); // NOI18N
        jtbLeccion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jtbLeccion);

        btnLimpiarLec.setBackground(new java.awt.Color(76, 130, 252));
        btnLimpiarLec.setFont(new java.awt.Font("Dubai", 0, 18)); // NOI18N
        btnLimpiarLec.setForeground(new java.awt.Color(255, 255, 255));
        btnLimpiarLec.setText("Limpiar");
        btnLimpiarLec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarLecActionPerformed(evt);
            }
        });

        txtContenidoLec.setBackground(new java.awt.Color(235, 235, 250));
        txtContenidoLec.setFont(new java.awt.Font("Roboto Light", 0, 18)); // NOI18N

        btnAgregarLec.setBackground(new java.awt.Color(76, 130, 252));
        btnAgregarLec.setFont(new java.awt.Font("Dubai", 0, 18)); // NOI18N
        btnAgregarLec.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregarLec.setText("Agregar");
        btnAgregarLec.setPreferredSize(new java.awt.Dimension(84, 39));

        jLabel6.setFont(new java.awt.Font("Roboto Light", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(47, 88, 212));
        jLabel6.setText("Estado:");

        txtStatusLec.setBackground(new java.awt.Color(235, 235, 250));
        txtStatusLec.setFont(new java.awt.Font("Roboto Light", 0, 18)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Roboto Light", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(47, 88, 212));
        jLabel7.setText("Busca una lección");

        jLabel10.setIcon(new javax.swing.ImageIcon("C:\\Users\\Steven\\JavaProjects\\JavaTutoTech\\src\\vista\\img\\LeccionImage.png")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtBuscarLec))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnAgregarLec, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnEliminarLec, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnActualizarLec, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnLimpiarLec, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(2, 2, 2))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel6)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel2))
                                        .addGap(18, 18, 18))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(txtFechaLec)
                                        .addComponent(txtContenidoLec, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtStatusLec, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 451, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtTituloLec, javax.swing.GroupLayout.PREFERRED_SIZE, 451, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 110, Short.MAX_VALUE)
                                .addComponent(jLabel10)
                                .addGap(100, 100, 100))))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(221, 221, 221))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtTituloLec, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtFechaLec, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtContenidoLec, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtStatusLec, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(44, 44, 44)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7)
                            .addComponent(txtBuscarLec, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAgregarLec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEliminarLec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnLimpiarLec)
                            .addComponent(btnActualizarLec, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(26, 26, 26)
                        .addComponent(jLabel10)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(475, 475, 475))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtFechaLecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFechaLecActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechaLecActionPerformed

    private void btnLimpiarLecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarLecActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLimpiarLecActionPerformed

    private void btnEliminarLecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarLecActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEliminarLecActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnActualizarLec;
    public javax.swing.JButton btnAgregarLec;
    public javax.swing.JButton btnEliminarLec;
    public javax.swing.JButton btnLimpiarLec;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable jtbLeccion;
    public javax.swing.JTextField txtBuscarLec;
    public javax.swing.JTextField txtContenidoLec;
    public javax.swing.JTextField txtContenidoLec2;
    public javax.swing.JTextField txtFechaLec;
    public javax.swing.JTextField txtStatusLec;
    public javax.swing.JTextField txtTituloLec;
    // End of variables declaration//GEN-END:variables
}
