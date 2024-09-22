package controlador;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import modelo.Tutoria;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import vista.frmMenuPrincipal;      
import vista.jpAddTutoria;

public class ctrlMenuPrincipal implements ActionListener, MouseListener{
    
    //mandar a llamar las capas
    private frmMenuPrincipal vista;
    private jpAddTutoria panel;
    private Tutoria modelo;
    
    public ctrlMenuPrincipal(frmMenuPrincipal menu) {
        this.vista = menu;
        //this.panel = panel;
        //this.modelo = modelo;
        
        vista.btnIrTutoria.addMouseListener(this);
    }
    
    public void abrirApp(){
        vista.setTitle("Dashboard");
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);
        vista.setExtendedState(JFrame.NORMAL);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
 //No Usar
    }

    @Override
    public void mouseClicked(MouseEvent e) {
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

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
    
}
