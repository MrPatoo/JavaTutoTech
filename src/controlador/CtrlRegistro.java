/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import modelo.Usuario;
import vista.frmRegistro;
import vista.FrmLogin;

/**
 *
 * @author Carlos H
 */
public class CtrlRegistro implements MouseListener{
    
    //1-Llamar a las otras capas
    Usuario modelo;
    frmRegistro vista;
    FrmLogin vistaFrmLogin;
    
    //2-Constructor 
    public CtrlRegistro(Usuario Modelo, frmRegistro vista){
        this.modelo = Modelo;
        this.vista = vista;
        
        vista.btnRegUser.addMouseListener(this);
        vista.lblSesion.addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
        if(e.getSource() == vista.btnRegUser){
            modelo.setCorreoUsuario(vista.getTxtClave().getText());
            modelo.setNombreUsuario(vista.getTxtNombreUser().getText());
          modelo.setContrasenaUsuario(modelo.convertirSHA256(vista.txtClave.getText()));
            modelo.GuardarUsuario();
            
            //Muestro una alerta que el usuario se ha guardado
            JOptionPane.showMessageDialog(vista, "Usuario Guardado");
        }
        
         //Clic al botón de Ir Al Login
        if(e.getSource() == vista.lblSesion){
            vistaFrmLogin.initFrmLogin();
            vistaFrmLogin.dispose();
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
