package controlador;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import modelo.Tutoria;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import modelo.Leccion;
import vista.frmMenuPrincipal;
import vista.jpAddLeccion;
import vista.jpAddTutoria;

public class ctrlMenuPrincipal implements MouseListener {

    //mandar a llamar las capas
    private frmMenuPrincipal vista;
    private jpAddTutoria panel;
    private Tutoria modelo;
    private jpAddLeccion panelLec;
    private Leccion modeloLec;

    public ctrlMenuPrincipal(frmMenuPrincipal Vista, jpAddTutoria Panel, Tutoria Modelo, jpAddLeccion PanelLec, Leccion ModeloLec) {
        this.vista = Vista;
        this.panel = Panel;
        this.modelo = Modelo;
        this.panelLec = PanelLec;
        this.modeloLec = ModeloLec;
        
      
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
          
            modelo.GuardarTuto();
              modelo.Mostrar(panel.jtbTutoria);
            System.out.println("Funciona");

        }

        if (e.getSource() == panel.btnEliminar) {
            modelo.Eliminar(panel.jtbTutoria);
            modelo.Mostrar(panel.jtbTutoria);
            System.out.println("Funciona");

        }

        if (e.getSource() == panel.btnActualizar) {
            modelo.setNombreTutoria(panel.txtNombre.getText());
            modelo.setDescripcionTutoria(panel.txtNombre.getText());

            modelo.Actualizar(panel.jtbTutoria);
            modelo.Mostrar(panel.jtbTutoria);
                        System.out.println("Funciona");

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
        
        
        if(e.getSource()== panelLec.btnAgregarLec){
            modeloLec.setTituloLec(panelLec.txtTituloLec.getText());
            modeloLec.setFechaLec(panelLec.txtFechaLec.getText());
            modeloLec.setContenidoLec(panelLec.txtContenidoLec.getText());
            modeloLec.LimpiarDatosLec(panelLec);
          
            modeloLec.GuardarLec();
            modeloLec.MostrarLec(panelLec.jtbLeccion);
            System.out.println("Funciona"); 
        }
        
        
        if (e.getSource() == panelLec.btnEliminarLec) {
            modeloLec.EliminarLec(panelLec.jtbLeccion);
            modeloLec.MostrarLec(panelLec.jtbLeccion);
            System.out.println("Funciona");

        }

        if (e.getSource() == panelLec.btnActualizarLec) {
            modeloLec.setTituloLec(panelLec.txtTituloLec.getText());
            modeloLec.setFechaLec(panelLec.txtFechaLec.getText());
            modeloLec.setContenidoLec(panelLec.txtContenidoLec.getText());


            modeloLec.ActualizarLec(panelLec.jtbLeccion);
            modeloLec.MostrarLec(panelLec.jtbLeccion);
                        System.out.println("Funciona");

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
