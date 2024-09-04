/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import modelo.RegistroDao;
import vista.frmRegistro;
import vista.login;

/**
 *
 * @author Carlos H
 */
public class CtrlRegistro extends MouseAdapter implements ActionListener {

    private final frmRegistro frmRegistro;
    private RegistroDao registroDao;

    public CtrlRegistro(frmRegistro vista) {
        frmRegistro = vista;
        frmRegistro.setLocationRelativeTo(null);
        frmRegistro.setVisible(true);

        frmRegistro.getBtnRegUser().addActionListener(this);
        frmRegistro.getTxtMail().addActionListener(this);
        frmRegistro.getTxtNombreUser().addActionListener(this);
        frmRegistro.getTxtEdadU().addActionListener(this);
        frmRegistro.getTxtClave().addActionListener(this);

        frmRegistro.getLblSesion().addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent e) {
                login lo = new login();
                frmRegistro.dispose();
                new LoginController(lo);
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == frmRegistro.getTxtMail()) {
            frmRegistro.getTxtMail().requestFocus();
        }

        if (e.getSource() == frmRegistro.getTxtNombreUser()) {
            frmRegistro.getTxtNombreUser().requestFocus();
        }

        if (e.getSource() == frmRegistro.getTxtEdadU()) {
            frmRegistro.getTxtEdadU().requestFocus();
        }

        if (e.getSource() == frmRegistro.getTxtClave()) {
            frmRegistro.getTxtClave().requestFocus();
        }

        if (e.getSource() == frmRegistro.getBtnRegUser()) {
            accionBtnRegUser();
        }

    }

    private void accionBtnRegUser() {

        registroDao = new RegistroDao();

        registroDao.registrarUsuario(
                frmRegistro.getTxtNombreUser().getText(),
                Integer.parseInt(frmRegistro.getTxtEdadU().getText()), frmRegistro.getTxtMail().getText(),
                frmRegistro.getTxtClave().getText());

        login lo = new login();
        frmRegistro.dispose();
        new LoginController(lo);

    }
}
