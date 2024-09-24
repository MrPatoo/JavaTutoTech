/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import modelo.Tutoria;
import modelo.Usuario;
import vista.frmMenuPrincipal;
import vista.frmRegistro;
import vista.jpAddLeccion;
import vista.jpAddTutoria;
import vista.login;
import vista.recuperacionClave;

/**
 *
 * @author lenovo
 */
public class LoginController implements MouseListener {

    private login vista;
    private Usuario usuarioModelo;

    private String usuario;
    private String clave;

    public LoginController(login vista) {
        this.vista = vista;
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);
        addListener();
    }

    private void addListener() {
        vista.getjTxtMail().addMouseListener(this);
        vista.getjTxtPass().addMouseListener(this);
        vista.getjBtnInicia().addMouseListener(this);

        vista.getLblRecupera().addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent e) {
                recuperacionClave recupera = new recuperacionClave();
                vista.dispose();
                new CtrlIngresoCorreo(recupera);
            }
        });

        vista.getLblCrearCta().addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent e) {
                frmRegistro reg = new frmRegistro();
                vista.dispose();
                new CtrlRegistro(reg);
            }
        });
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == vista.getjTxtMail()) {
            vista.getjTxtMail().requestFocus();
        }

        if (e.getSource() == vista.getjTxtPass()) {
            vista.getjTxtPass().requestFocus();
        }

        if (e.getSource() == vista.getjBtnInicia()) {
            usuario = vista.getjTxtMail().getText().trim().toUpperCase();
            clave = vista.getjTxtPass().getText().trim();

            if (usuario.equals("")) {
                JOptionPane.showMessageDialog(null, "El usuario es requerido");
                vista.getjTxtMail().requestFocus();
            } else if (clave.equals("")) {
                JOptionPane.showMessageDialog(null, "La clave es requerida");
                vista.getjTxtPass().requestFocus();
            } else {
                usuarioModelo = new Usuario();
                usuarioModelo.setCorreo(usuario);
                usuarioModelo.setContrasena(clave);

                if (usuarioModelo.validarCredenciales()) {
                    vista.dispose();
                    new ctrlMenuPrincipal(new frmMenuPrincipal(), new jpAddTutoria(), new Tutoria(), new jpAddLeccion());
                } else {
                    JOptionPane.showMessageDialog(null, "Usuario o contraseña no valido");
                }
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
