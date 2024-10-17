package controlador;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import modelo.Tutoria;
import modelo.Leccion;
import vista.frmMenuPrincipal;
import vista.jpAddLeccion;
import vista.jpAddTutoria;

public class ctrlMenuPrincipal implements MouseListener, KeyListener {
    
    private frmMenuPrincipal vista;
    private jpAddTutoria panelTutoria;
    private Tutoria modeloTutoria;
    private jpAddLeccion panelLeccion;
    private Leccion modeloLeccion;

    // Constructor del controlador
    public ctrlMenuPrincipal(frmMenuPrincipal vista, jpAddTutoria panelTutoria, Tutoria modeloTutoria, jpAddLeccion panelLeccion, Leccion modeloLeccion) {
        this.vista = vista;
        this.panelTutoria = panelTutoria;
        this.modeloTutoria = modeloTutoria;
        this.panelLeccion = panelLeccion;
        this.modeloLeccion = modeloLeccion;
        
        // Asignar eventos a los botones del frmMenuPrincipal
        vista.btnIrTutoria.addMouseListener(this);
        vista.btnIrLeccion.addMouseListener(this);
        
        // Asignar eventos CRUD en los paneles
        panelTutoria.btnAgregar.addMouseListener(this);
        panelTutoria.btnEliminar.addMouseListener(this);
        panelTutoria.btnActualizar.addMouseListener(this);
        panelTutoria.btnLimpiar.addMouseListener(this);
        panelTutoria.txtBuscar.addKeyListener(this);
        panelTutoria.jtbTutoria.addMouseListener(this);
        panelTutoria.btnEliminar.addMouseListener(this);
        panelLeccion.btnAgregarLec.addMouseListener(this);
        panelLeccion.btnEliminarLec.addMouseListener(this);
        panelLeccion.btnActualizarLec.addMouseListener(this);
        panelLeccion.btnLimpiarLec.addMouseListener(this);
        panelLeccion.jtbLeccion.addMouseListener(this);
        panelLeccion.txtBuscarLec.addKeyListener(this);
        
        
        // Inicializar la vista mostrando el panel de Tutoria
        mostrarPanelTutoria();
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        //Navegar entre paneles
        if (e.getSource() == vista.btnIrTutoria) {
            mostrarPanelTutoria();
        }    
        if (e.getSource() == vista.btnIrLeccion) {
            mostrarPanelLeccion();
        }
        
        // CRUD en panel de Tutoria
        if (e.getSource() == panelTutoria.btnAgregar) {
            if (panelTutoria.txtNombre.getText().isEmpty() || panelTutoria.txtDescripcion2.getText().isEmpty()){ JOptionPane.showMessageDialog(vista, "Debes llenar todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                modeloTutoria.setNombreTutoria(panelTutoria.txtNombre.getText());
                modeloTutoria.setDescripcionTutoria(panelTutoria.txtDescripcion2.getText());
                modeloTutoria.GuardarTuto();
                modeloTutoria.Mostrar(panelTutoria.jtbTutoria);
                modeloTutoria.LimpiarDatos(panelTutoria);
                System.out.println("Funciona");
            }
        } if (e.getSource() == panelTutoria.btnEliminar) {
            modeloTutoria.Eliminar(panelTutoria.jtbTutoria);
            modeloTutoria.Mostrar(panelTutoria.jtbTutoria);
            modeloTutoria.LimpiarDatos(panelTutoria);
            System.out.println("Funciona");           
        } if(e.getSource() == panelTutoria.jtbTutoria){
            modeloTutoria.cargarDatosTabla(panelTutoria);
        } if (e.getSource() == panelTutoria.btnActualizar) {
            if (panelTutoria.txtNombre.getText().isEmpty() || panelTutoria.txtDescripcion2.getText().isEmpty()){ JOptionPane.showMessageDialog(vista, "Debes seleccionar los campos para actualizar", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                modeloTutoria.setNombreTutoria(panelTutoria.txtNombre.getText());
                modeloTutoria.setDescripcionTutoria(panelTutoria.txtDescripcion2.getText());
                modeloTutoria.Actualizar(panelTutoria.jtbTutoria);
                modeloTutoria.Mostrar(panelTutoria.jtbTutoria);
                modeloTutoria.LimpiarDatos(panelTutoria);
                System.out.println("Funciona");
            }
        } if (e.getSource() == panelTutoria.btnLimpiar) {
            modeloTutoria.LimpiarDatos(panelTutoria);
        }
        // CRUD en panel de Lección
        if (e.getSource() == panelLeccion.btnAgregarLec) {
            if (panelLeccion.txtTituloLec.getText().isEmpty() || panelLeccion.txtFechaLec.getText().isEmpty() || 
                    panelLeccion.txtContenidoLec.getText().isEmpty() || panelLeccion.txtStatusLec.getText().isEmpty()   ){
                JOptionPane.showMessageDialog(vista, "Debes llenar todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                try {
                    modeloLeccion.setTituloLec(panelLeccion.txtTituloLec.getText());
                    modeloLeccion.setFechaLec(panelLeccion.txtFechaLec.getText());
                    modeloLeccion.setContenidoLec(panelLeccion.txtContenidoLec.getText());
                    modeloLeccion.setStatusLec(Integer.parseInt(panelLeccion.txtStatusLec.getText()));
                    modeloLeccion.GuardarLec();
                    modeloLeccion.MostrarLec(panelLeccion.jtbLeccion);
                    modeloLeccion.LimpiarDatosLec(panelLeccion);
                    System.out.println("Funciona");
                } catch (Exception ex) {
                     JOptionPane.showMessageDialog(vista, "El status debe ser un número", "Error", JOptionPane.WARNING_MESSAGE);
                }
            }
        } if(e.getSource() == panelLeccion.jtbLeccion){
            modeloLeccion.cargarDatosTablaLec(panelLeccion);
        } if (e.getSource() == panelLeccion.btnEliminarLec) {
            if (panelLeccion.txtTituloLec.getText().isEmpty() || panelLeccion.txtFechaLec.getText().isEmpty() || 
                    panelLeccion.txtContenidoLec.getText().isEmpty() || panelLeccion.txtStatusLec.getText().isEmpty()   ){
                JOptionPane.showMessageDialog(vista, "Debes seleccionar un registro para eliminar", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                modeloLeccion.EliminarLec(panelLeccion.jtbLeccion);
                modeloLeccion.MostrarLec(panelLeccion.jtbLeccion);
                modeloLeccion.LimpiarDatosLec(panelLeccion);
                System.out.println("Funciona");
            }                      
        } if (e.getSource() == panelLeccion.btnActualizarLec) {
            if (panelLeccion.txtTituloLec.getText().isEmpty() || panelLeccion.txtFechaLec.getText().isEmpty() || 
                    panelLeccion.txtContenidoLec.getText().isEmpty() || panelLeccion.txtStatusLec.getText().isEmpty()   ){
                JOptionPane.showMessageDialog(vista, "Debes seleccionar los campos para actualizar", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                try {
                    modeloLeccion.setTituloLec(panelLeccion.txtTituloLec.getText());
                    modeloLeccion.setFechaLec(panelLeccion.txtFechaLec.getText());
                    modeloLeccion.setContenidoLec(panelLeccion.txtContenidoLec.getText());
                    modeloLeccion.setStatusLec(Integer.parseInt(panelLeccion.txtStatusLec.getText()));
                    modeloLeccion.ActualizarLec(panelLeccion.jtbLeccion);
                    modeloLeccion.MostrarLec(panelLeccion.jtbLeccion);
                    modeloLeccion.LimpiarDatosLec(panelLeccion);
                    System.out.println("Funciona");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(vista, "La edad debe ser un número", "Error", JOptionPane.WARNING_MESSAGE);
                }
            }
        } if (e.getSource() == panelLeccion.btnLimpiarLec) {
            modeloLeccion.LimpiarDatosLec(panelLeccion);
        } 
    }
    // Método para mostrar el panel de Tutoria en jpContenedor
    private void mostrarPanelTutoria() {
        vista.jpContenedor.removeAll();  // Eliminar contenido previo
        vista.jpContenedor.add(panelTutoria);  // Agregar el panel de Tutoria
        vista.jpContenedor.revalidate();  // Validar cambios
        vista.jpContenedor.repaint();  // Repintar el contenedor
        modeloTutoria.Mostrar(panelTutoria.jtbTutoria);  // Cargar datos del modelo
    }
    // Método para mostrar el panel de Lección en jpContenedor
    private void mostrarPanelLeccion() {
        vista.jpContenedor.removeAll();  // Eliminar contenido previo
        vista.jpContenedor.add(panelLeccion);  // Agregar el panel de Lección
        vista.jpContenedor.revalidate();  // Validar cambios
        vista.jpContenedor.repaint();  // Repintar el contenedor
        modeloLeccion.MostrarLec(panelLeccion.jtbLeccion);  // Cargar datos del modelo
    }
    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getSource() == panelTutoria.txtBuscar) {
            modeloTutoria.Buscar(panelTutoria.jtbTutoria, panelTutoria.txtBuscar);
        }
        if (e.getSource() == panelLeccion.txtBuscarLec) {
            modeloLeccion.BuscarLec(panelLeccion.jtbLeccion, panelLeccion.txtBuscarLec);
        }
    }
    @Override
    public void mousePressed(MouseEvent e) {}
    @Override
    public void mouseReleased(MouseEvent e) {}
    @Override
    public void mouseEntered(MouseEvent e) {}
    @Override
    public void mouseExited(MouseEvent e) {}
    @Override
    public void keyTyped(KeyEvent e) {}
    @Override
    public void keyPressed(KeyEvent e) {}
}