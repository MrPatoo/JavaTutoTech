package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import modelo.CambioClave;
import modelo.EnviarCorreo;
import modelo.Usuario;
import vista.frmCambioContrasenia;
import vista.login;
import vista.recuperacionClave;

/**
 *
 * @author Steven
 */
public class CtrlIngresoCorreo implements ActionListener {

    private recuperacionClave vista;

    private String correo;

    public CtrlIngresoCorreo(recuperacionClave vista) {
        this.vista = vista;
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);
        addListener();
    }

    private void addListener() {
        vista.getjTxtMailRecu().addActionListener(this);
        vista.getjBtnEnviaCorreo().addActionListener(this);

        vista.getjLblIniSesion().addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent e) {
                login login = new login();
                vista.dispose();
                new LoginController(login);
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == vista.getjTxtMailRecu()) {
            vista.getjTxtMailRecu().requestFocus();
        }

        if (e.getSource() == vista.getjBtnEnviaCorreo()) {
            generarEmail();
        }
    }

    private void generarEmail() {
        correo = vista.getjTxtMailRecu().getText().trim();

        if (correo.equals("")) {
            JOptionPane.showMessageDialog(null, "El correo es requerido");
            vista.getjTxtMailRecu().requestFocus();
            return;
        }

        Usuario ld = new Usuario();
        CambioClave cc = new CambioClave();

        if(!ld.validarUsuario(correo.toUpperCase())){
            JOptionPane.showMessageDialog(null, "El correo no existe en nuestros registros");
            return;
        }

        int caracteres = (int) (Math.random() * 99999);

        String titulo = "Recuperacion de contraseña";
        String contenido = "Codigo generado:  " + caracteres;

        boolean enviado = EnviarCorreo.enviarCorreo(correo, titulo, contenido);


        JOptionPane.showMessageDialog(null,
                enviado ? "Se ha enviado el correo" : "No se pudo enviar el correo");

        if (enviado) {
            cc.almacenarRegistro(correo, String.valueOf(caracteres));
            frmCambioContrasenia frmCambio = new frmCambioContrasenia();
            vista.dispose();
            new CambioClaveController(frmCambio);
        }

    }
}
