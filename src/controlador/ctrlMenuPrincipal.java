package controlador;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import modelo.Tutoria;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import vista.frmMenuPrincipal;
import vista.jpAddLeccion;
import vista.jpAddTutoria;

public class ctrlMenuPrincipal implements MouseListener {

    //mandar a llamar las capas
    private frmMenuPrincipal vista;
    private jpAddTutoria panel;
    private Tutoria modelo;
    private jpAddLeccion panelLec;

    public ctrlMenuPrincipal(frmMenuPrincipal Vista, jpAddTutoria Panel, Tutoria Modelo, jpAddLeccion PanelLec) {
        this.vista = Vista;
        this.panel = Panel;
        this.modelo = Modelo;
        this.panelLec = PanelLec;
        
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);
        //panel tutoria--------------------------------
        vista.btnIrTutoria.addMouseListener(this);
        modelo.Mostrar(panel.jtbTutoria);
        panel.btnAgregar.addMouseListener(this);
        panel.btnEliminar.addMouseListener(this);
        panel.btnActualizar.addMouseListener(this);
        
        //panel leccion--------------------------------
        vista.btnIrLeccion.addMouseListener(this);
        
        
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        //para que se vean los paneles***************************************************************************************************
        if (e.getSource() == vista.btnIrTutoria) {
            System.out.println("se dio clic al boton ir a tutoria");
            jpAddTutoria objAddTuto = new jpAddTutoria();

            vista.jpContenedor.removeAll();
            vista.jpContenedor.add(objAddTuto);
            vista.jpContenedor.revalidate();
            vista.jpContenedor.repaint();

        }
        
        if(e.getSource() == vista.btnIrLeccion){
            jpAddLeccion objAddLec = new jpAddLeccion();
            
            vista.jpContenedor.removeAll();
            vista.jpContenedor.add(objAddLec);
            vista.jpContenedor.revalidate();
            vista.jpContenedor.repaint();
        }           
            
        
        
        //Botones de crud Tutoria************************************************************************************************************
        if (e.getSource() == panel.btnAgregar) {
            modelo.setNombreTutoria(panel.txtNombre.getText());
            modelo.setDescripcionTutoria(panel.txtDescripcion.getText());
            modelo.LimpiarDatos(panel);
            modelo.Mostrar(panel.jtbTutoria);
            modelo.GuardarTuto();
            System.out.println("Funciona");

        }

        if (e.getSource() == panel.btnEliminar) {
            modelo.Eliminar(panel.jtbTutoria);
            modelo.Mostrar(panel.jtbTutoria);

        }

        if (e.getSource() == panel.btnActualizar) {
            modelo.setNombreTutoria(panel.txtNombre.getText());
            modelo.setDescripcionTutoria(panel.txtNombre.getText());

            modelo.Actualizar(panel.jtbTutoria);
            modelo.Mostrar(panel.jtbTutoria);
        }

        /*if (e.getSource() == panel.btnLimpiar) {
            modelo.LimpiarDatos(panel);
        }*/

        //validaciones
        /*]if (panel.txtNombre.getText().isEmpty() || panel.txtDescripcion.getText().isEmpty()) {
            //esto es un alert
            JOptionPane.showMessageDialog(vista, "Llene todos los campos");
        }*/
        
        
        
        //Botones de crud Leccion*******************************************************************************************************************
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
