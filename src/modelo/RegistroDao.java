package modelo;

import javax.swing.JOptionPane;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.UUID;
import vista.login;
import Modelo.ClaseConexion;


public class RegistroDao {

    public boolean validarCampos(String nombre, int edad, String correo, String contrasena) {
        if (nombre.isEmpty() || correo.isEmpty() || contrasena.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios.");
            return false;
        }

        if (edad < 18 || edad > 100) {
            JOptionPane.showMessageDialog(null, "La edad debe estar entre 18 y 100 años.");
            return false;
        }

        if (!correo.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
            JOptionPane.showMessageDialog(null, "El correo no es válido.");
            return false;
        }

        return true;
    }

    public String encriptarSHA256(String contrasena) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] encodedhash = digest.digest(contrasena.getBytes(StandardCharsets.UTF_8));
            StringBuilder hexString = new StringBuilder();
            for (byte b : encodedhash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            JOptionPane.showMessageDialog(null, "Error al encriptar la contraseña: " + e.getMessage());
            return null;
        }
    }

    public void registrarUsuario(String nombre, int edad, String correo, String contrasena) {
        //Validar campos antes de registrar
        if (!validarCampos(nombre, edad, correo, contrasena)) {
            return;
        }

        String contrasenaEncriptada = encriptarSHA256(contrasena);
        if (contrasenaEncriptada == null) {
            return; // Salir si hay un error en la encriptación
        }

        Connection conn = null;
        PreparedStatement ps = null;

        String sql = "INSERT INTO tbUsuario (idUsuario, nombreUsuario, edadUsuario, correoUsuario, contrasenaUsuario, idRole) VALUES (?, ?, ?, ?, ?, ?)";
        
        try {
            // Obtener la conexión
            conn = ClaseConexion.getConexion();
            ps = conn.prepareStatement(sql);
            ps.setString(1, UUID.randomUUID().toString());
            ps.setString(2, nombre);
            ps.setInt(3, edad);
            ps.setString(4, correo);
            ps.setString(5, contrasena);
            ps.setInt(6, 2);  // Asumiendo que 2 es el rol de usuario regular.
            ps.executeUpdate();

            JOptionPane.showMessageDialog(null, "Usuario registrado exitosamente.");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al registrar el usuario: " + e.getMessage());
        } finally {
            // Cerrar los recursos
            try {
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
            }
        }
    }
}
