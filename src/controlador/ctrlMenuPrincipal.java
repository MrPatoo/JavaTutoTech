package controlador;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import modelo.Tutoria;
import modelo.Leccion;
import vista.frmMenuPrincipal;
import vista.jpAddLeccion;
import vista.jpAddTutoria;

public class ctrlMenuPrincipal implements MouseListener {
    
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
        panelLeccion.btnAgregarLec.addMouseListener(this);
        panelLeccion.btnEliminarLec.addMouseListener(this);
        panelLeccion.btnActualizarLec.addMouseListener(this);
        
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
            modeloTutoria.setNombreTutoria(panelTutoria.txtNombre.getText());
            modeloTutoria.setDescripcionTutoria(panelTutoria.txtBuscar.getText());
            modeloTutoria.GuardarTuto();
            modeloTutoria.Mostrar(panelTutoria.jtbTutoria);
            System.out.println("Tutoria agregada");
        } if (e.getSource() == panelTutoria.btnEliminar) {
            modeloTutoria.Eliminar(panelTutoria.jtbTutoria);
            modeloTutoria.Mostrar(panelTutoria.jtbTutoria);
            System.out.println("Tutoria eliminada");
        } if(e.getSource() == panelTutoria.jtbTutoria){
            modeloTutoria.cargarDatosTabla(panelTutoria);
        } if (e.getSource() == panelTutoria.btnActualizar) {
            modeloTutoria.setNombreTutoria(panelTutoria.txtNombre.getText());
            modeloTutoria.setDescripcionTutoria(panelTutoria.txtNombre.getText());
            modeloTutoria.Actualizar(panelTutoria.jtbTutoria);
            modeloTutoria.Mostrar(panelTutoria.jtbTutoria);
            System.out.println("Tutoria actualizada");
        }
        // CRUD en panel de Lección
        if (e.getSource() == panelLeccion.btnAgregarLec) {
            modeloLeccion.setTituloLec(panelLeccion.txtTituloLec.getText());
            modeloLeccion.setFechaLec(panelLeccion.txtFechaLec.getText());
            modeloLeccion.setContenidoLec(panelLeccion.txtContenidoLec.getText());
            modeloLeccion.setStatusLec(Integer.parseInt(panelLeccion.txtStatusLec.getText()));
            modeloLeccion.GuardarLec();
            modeloLeccion.MostrarLec(panelLeccion.jtbLeccion);
            System.out.println("Funciona");
        } if(e.getSource() == panelLeccion.jtbLeccion){
            modeloLeccion.cargarDatosTablaLec(panelLeccion);
        } if (e.getSource() == panelLeccion.btnEliminarLec) {
            modeloLeccion.EliminarLec(panelLeccion.jtbLeccion);
            modeloLeccion.MostrarLec(panelLeccion.jtbLeccion);
            System.out.println("Funciona");
        } if (e.getSource() == panelLeccion.btnActualizarLec) {
            modeloLeccion.setTituloLec(panelLeccion.txtTituloLec.getText());
            modeloLeccion.setFechaLec(panelLeccion.txtFechaLec.getText());
            modeloLeccion.setContenidoLec(panelLeccion.txtContenidoLec.getText());
            // Forzar la actualización del campo de texto
                panelLeccion.txtStatusLec.requestFocus();
                panelLeccion.txtStatusLec.transferFocus();
                // Imprimir el valor leído del campo para depuración
                System.out.println("Valor leído de txtStatusLec: '" + panelLeccion.txtStatusLec.getText() + "'");

                String statusText = panelLeccion.txtStatusLec.getText().trim();  // Elimina espacios en blanco

                if (!statusText.isEmpty()) {
                    try {
                        modeloLeccion.setStatusLec(Integer.parseInt(statusText));  // Convertir a entero
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(vista, "El campo de estado debe ser un número entero válido (1 o 2).", "Error de formato", JOptionPane.ERROR_MESSAGE);
                        return;  // Salir del método para evitar la actualización con datos incorrectos
                    }
                } else {
                    JOptionPane.showMessageDialog(vista, "El campo de estado no puede estar vacío.", "Campo vacío", JOptionPane.WARNING_MESSAGE);
                    return;  // Salir del método
                }
                // Realizar la actualización
                modeloLeccion.ActualizarLec(panelLeccion.jtbLeccion);
                modeloLeccion.MostrarLec(panelLeccion.jtbLeccion);
                System.out.println("Lección actualizada");
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
    public void mousePressed(MouseEvent e) {}
    @Override
    public void mouseReleased(MouseEvent e) {}
    @Override
    public void mouseEntered(MouseEvent e) {}
    @Override
    public void mouseExited(MouseEvent e) {}
}
