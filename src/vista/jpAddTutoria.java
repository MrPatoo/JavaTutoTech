/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package vista;

/**
 *
 * @author USUARIO
 */
public class jpAddTutoria extends javax.swing.JPanel {

    /**
     * Creates new form jpAddTutoria
     */
    public jpAddTutoria() {
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

        txtNombre = new javax.swing.JTextField();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnBuscarimg = new javax.swing.JButton();
        txtDescripcion = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbTutoria = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        btnAgregar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtNombre.setBackground(new java.awt.Color(255, 255, 255));
        txtNombre.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 100, 550, 40));

        btnEditar.setBackground(new java.awt.Color(19, 82, 92));
        btnEditar.setFont(new java.awt.Font("Dubai", 0, 18)); // NOI18N
        btnEditar.setText("Editar");
        add(btnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 310, 120, 60));

        btnEliminar.setBackground(new java.awt.Color(19, 82, 92));
        btnEliminar.setFont(new java.awt.Font("Dubai", 0, 18)); // NOI18N
        btnEliminar.setText("Eliminar");
        add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 310, 120, 60));

        btnBuscarimg.setBackground(new java.awt.Color(19, 82, 92));
        btnBuscarimg.setFont(new java.awt.Font("Dubai", 0, 18)); // NOI18N
        btnBuscarimg.setText("Buscar");
        add(btnBuscarimg, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 260, 90, 30));

        txtDescripcion.setBackground(new java.awt.Color(255, 255, 255));
        txtDescripcion.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        add(txtDescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 180, 550, 40));

        jLabel6.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Descripción de la tutoría");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 190, -1, -1));

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

        jLabel4.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("¿Desea buscar una imagen?");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 260, -1, -1));

        btnAgregar.setBackground(new java.awt.Color(19, 82, 92));
        btnAgregar.setFont(new java.awt.Font("Dubai", 0, 18)); // NOI18N
        btnAgregar.setText("Agregar");
        add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 310, 120, 60));

        jLabel5.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Nombre de la tutoría");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 110, -1, -1));

        jLabel1.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Añadir una tutoría nueva");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 20, -1, -1));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnAgregar;
    public javax.swing.JButton btnBuscarimg;
    public javax.swing.JButton btnEditar;
    public javax.swing.JButton btnEliminar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable jtbTutoria;
    public javax.swing.JTextField txtDescripcion;
    public javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
