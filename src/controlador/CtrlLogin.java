
package controlador;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import modelo.Usuario;
import vista.FrmLogin;
import vista.frmMenuPrincipal;
import vista.frmRegistro;

public class CtrlLogin implements MouseListener {
   
    Usuario modelo;
    FrmLogin vista;
    
    //2-Constructor 
    public CtrlLogin(Usuario Modelo, FrmLogin Vista) {
        this.modelo = Modelo;
        this.vista = Vista;
        
        vista.jBtnInicia.addMouseListener(this);
        vista.lblCrearCta.addMouseListener(this);
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == vista.jBtnInicia) {

            modelo.setCorreoUsuario(vista.getjTxtMail().getText());
            modelo.setContrasenaUsuario(vista.getjTxtPass().getText());
            //Creo una variable llamada "comprobar" 
            //que guardará el resultado de ejecutar el metodo iniciarSesion()            
            boolean comprobar = modelo.iniciarSesion();

            //Si la variable es "true" significa que si existe el usuario ingresado    
            if (comprobar == true) {
                JOptionPane.showMessageDialog(vista,"Usuario existe, ¡Bienvenido!");
                frmMenuPrincipal.initfrmMenuPrincipal();
            } else {
                JOptionPane.showMessageDialog(vista, "Usuario no encontrado");
            }
        }
        
        //Clic al botón de Ir Al Registro
        if(e.getSource() == vista.getLblCrearCta()){
            frmRegistro.initfrmRegistro();
             vista.dispose();
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
