/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;
import javax.swing.JOptionPane;
import modelo.CambioClave;
import modelo.Usuario;
import vista.frmCambioContrasenia;
import vista.login;
/**
 *
 * @author Steven
 */
public class CambioClaveController implements ActionListener {

    private frmCambioContrasenia cambioClave;
    private final String VALIDAR = "Validar Codigo";
    private final String CAMBIO_CLAVE = "Actualizar clave";
    private CambioClave modelo;

    public CambioClaveController(frmCambioContrasenia cambioClave) {
        this.cambioClave = cambioClave;
        this.cambioClave.setLocationRelativeTo(null);
        this.cambioClave.setVisible(true);
        adicionarListener();
        desabilitarCampos(true);
    }

    private void adicionarListener() {
        this.cambioClave.getjTxtCode().addActionListener(this);
        this.cambioClave.getjTxtClave1().addActionListener(this);
        this.cambioClave.getjTxtClave2().addActionListener(this);
        this.cambioClave.getjBtnEnviar().addActionListener(this);
    }

    private void desabilitarCampos(boolean primeraVez) {
        if (primeraVez) {
            this.cambioClave.getjLblCode().setVisible(true);
            this.cambioClave.getjTxtCode().setVisible(true);
            this.cambioClave.getjLblClave1().setVisible(false);
            this.cambioClave.getjLblClave2().setVisible(false);
            this.cambioClave.getjTxtClave1().setVisible(false);
            this.cambioClave.getjTxtClave2().setVisible(false);
            this.cambioClave.getjBtnEnviar().setText(VALIDAR);
        } else {
            this.cambioClave.getjLblCode().setVisible(false);
            this.cambioClave.getjTxtCode().setVisible(false);
            this.cambioClave.getjLblClave1().setVisible(true);
            this.cambioClave.getjLblClave2().setVisible(true);
            this.cambioClave.getjTxtClave1().setVisible(true);
            this.cambioClave.getjTxtClave2().setVisible(true);
            this.cambioClave.getjBtnEnviar().setText(CAMBIO_CLAVE);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == cambioClave.getjTxtCode()) {
            cambioClave.getjTxtCode().requestFocus();
        }

        if (e.getSource() == cambioClave.getjTxtClave1()) {
            cambioClave.getjTxtClave1().requestFocus();
        }

        if (e.getSource() == cambioClave.getjTxtClave2()) {
            cambioClave.getjTxtClave2().requestFocus();
        }

        if (e.getSource() == cambioClave.getjBtnEnviar()) {
            generarAccionBtn();
        }

    }

    private void generarAccionBtn() {

        if (cambioClave.getjBtnEnviar().getText().equals(VALIDAR)) {

            if (cambioClave.getjTxtCode().getText() == null || cambioClave.getjTxtCode().getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Debe de agregar un codigo");
                return;
            }

            CambioClave cv = new CambioClave();

            modelo = cv.encontroCodigo(cambioClave.getjTxtCode().getText());

            if (Objects.isNull(modelo)) {
                JOptionPane.showMessageDialog(null, "Codigo no valido.");
                return;
            }

            desabilitarCampos(false);
        } else {

            if (cambioClave.getjTxtClave1().getText() == null || cambioClave.getjTxtClave1().getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Debe de ingresar la nueva clave");
                return;
            }

            if (cambioClave.getjTxtClave2().getText() == null || cambioClave.getjTxtClave2().getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Debe de ingresar la clave repetida");
                return;
            }

            if (!cambioClave.getjTxtClave1().getText().equals(cambioClave.getjTxtClave2().getText())) {
                JOptionPane.showMessageDialog(null, "Las claves no coinciden");
                return;
            }

            CambioClave cv = new CambioClave();
            Usuario u = new Usuario();

            cv.actualizarEstado(modelo.getCorreo(), modelo.getCodigo());
            int value = u.actualizarClave(modelo.getCorreo(), cambioClave.getjTxtClave1().getText());

            if (value > 0) {
                JOptionPane.showMessageDialog(null, "Se ha actualizado la clave.");
                login l = new login();
                this.cambioClave.dispose();
                new LoginController(l);
            } else {
                JOptionPane.showMessageDialog(null, "Ocurrio un error inesperado, intente mas tarde.");
            }
        }
    }

}
