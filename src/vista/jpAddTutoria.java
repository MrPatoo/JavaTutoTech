package vista;

public class jpAddTutoria extends javax.swing.JPanel {
    public jpAddTutoria() {
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtDescripcion1 = new javax.swing.JTextField();
        btnEliminar = new javax.swing.JButton();
        txtNombre = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbTutoria = new javax.swing.JTable();
        btnAgregar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btnActualizar = new javax.swing.JButton();
        txtBuscar = new javax.swing.JTextField();
        txtDescripcion2 = new javax.swing.JTextField();
        btnLimpiar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        txtDescripcion1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnEliminar.setBackground(new java.awt.Color(19, 82, 92));
        btnEliminar.setFont(new java.awt.Font("Dubai", 0, 18)); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 320, 120, 60));

        txtNombre.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        txtNombre.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 100, 590, 40));

        jLabel6.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel6.setText("Descripción de la tutoría");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, -1, -1));

        jtbTutoria.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jtbTutoria);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 410, 910, 280));

        btnAgregar.setBackground(new java.awt.Color(19, 82, 92));
        btnAgregar.setFont(new java.awt.Font("Dubai", 0, 18)); // NOI18N
        btnAgregar.setText("Agregar");
        add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 320, 120, 60));

        jLabel5.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel5.setText("Nombre de la tutoría");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, -1, -1));

        jLabel1.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Añadir una tutoría nueva");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 20, -1, -1));

        btnActualizar.setBackground(new java.awt.Color(19, 82, 92));
        btnActualizar.setFont(new java.awt.Font("Dubai", 0, 18)); // NOI18N
        btnActualizar.setText("Actualizar");
        add(btnActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 320, 120, 60));

        txtBuscar.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        txtBuscar.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        add(txtBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 250, 350, 40));

        txtDescripcion2.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        txtDescripcion2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        add(txtDescripcion2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 170, 590, 40));

        btnLimpiar.setBackground(new java.awt.Color(19, 82, 92));
        btnLimpiar.setFont(new java.awt.Font("Dubai", 0, 18)); // NOI18N
        btnLimpiar.setText("Limpiar");
        add(btnLimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 320, 120, 60));

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel2.setText("Busca una tutoría");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 260, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEliminarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnActualizar;
    public javax.swing.JButton btnAgregar;
    public javax.swing.JButton btnEliminar;
    public javax.swing.JButton btnLimpiar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable jtbTutoria;
    public javax.swing.JTextField txtBuscar;
    public javax.swing.JTextField txtDescripcion1;
    public javax.swing.JTextField txtDescripcion2;
    public javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
