package controlador;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import modelo.Tutoria;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.frmMenuPrincipal;      
import vista.jpAddTutoria;

public class ctrlMenuPrincipal implements ActionListener{
    
    //mandar a llamar las capas
    private frmMenuPrincipal vista;
    private jpAddTutoria panel;
    private Tutoria modelo;
    
    public ctrlMenuPrincipal(frmMenuPrincipal menu) {
        vista = menu;
    }
    
    public void abrirApp(){
        vista.setTitle("Dashboard");
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);
        vista.setExtendedState(JFrame.NORMAL);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //para que se vea el panel
        if(e.getSource() == vista.btnIrTutoria){
            jpAddTutoria objAddTuto = new jpAddTutoria();
            
            vista.jpContenedor.removeAll();
            vista.jpContenedor.add(objAddTuto);
            vista.jpContenedor.revalidate();
            vista.jpContenedor.repaint();
        }
        
        
        if(e.getSource() == panel.btnAgregar){
            modelo.setNombreTutoria(panel.txtNombre.getText());
            modelo.setDescripcionTutoria(panel.txtDescripcion.getText());
            
            
            modelo.GuardarTuto();
        }
        
        if(e.getSource() == panel.btnEliminar){
            modelo.Eliminar(panel.jtbTutoria);
            modelo.Mostrar(panel.jtbTutoria);

            
            if (e.getSource() == panel.btnActualizar ) {
            modelo.setNombreTutoria(panel.txtNombre.getText());
            modelo.setDescripcionTutoria(panel.txtDescripcion.getText());
            
            modelo.Actualizar(panel.jtbTutoria);
            modelo.Mostrar(panel.jtbTutoria);
        }
        
        if (e.getSource() == panel.btnLimpiar ) {
            modelo.LimpiarDatos(panel);
        }
            
                   
            //validaciones---------------------------------------------------------------------------------------
            if(panel.txtNombre.getText().isEmpty() || panel.txtDescripcion.getText().isEmpty()){
                //esto es un alert
                JOptionPane.showMessageDialog(vista, "Llene todos los campos");
            }
            
            
        }
    }
    
}
