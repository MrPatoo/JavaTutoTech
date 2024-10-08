/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.util.UUID;
/**
 *
 * @author Steven
 */
public class Usuario {
    
    
     //1-Parametros
    private String idUsuario;
    private String nombreUsuario;
    private String edadUsuario;
    private String correoUsuario;
    private String contrasenaUsuario;

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getEdadUsuario() {
        return edadUsuario;
    }

    public void setEdadUsuario(String edadUsuario) {
        this.edadUsuario = edadUsuario;
    }

    public String getCorreoUsuario() {
        return correoUsuario;
    }

    public void setCorreoUsuario(String correoUsuario) {
        this.correoUsuario = correoUsuario;
    }

    public String getContrasenaUsuario() {
        return contrasenaUsuario;
    }

    public void setContrasenaUsuario(String contrasenaUsuario) {
        this.contrasenaUsuario = contrasenaUsuario;
    }
    
    public void GuardarUsuario() {
        //Creamos una variable igual a ejecutar el método de la clase de conexión
        Connection conexion = ClaseConexion.getConexion();
        try {
            //Creamos el PreparedStatement que ejecutará la Query
            PreparedStatement addUsuario = conexion.prepareStatement("INSERT INTO tbUsuario(IdUsuario, nombreUsuario, edadUsuario, correoUsuario, ContrasenaUsuario) VALUES (?, ?, ?, ?, ?)");
            String contrasenaEncriptada = convertirSHA256(getContrasenaUsuario());

            //Establecer valores de la consulta SQL
            addUsuario.setString(1, UUID.randomUUID().toString());
            addUsuario.setString(2, getNombreUsuario());
            addUsuario.setString(3, getEdadUsuario());
            addUsuario.setString(4, getCorreoUsuario());
            addUsuario.setString(5, contrasenaEncriptada);
 
            //Ejecutar la consulta
            addUsuario.executeUpdate();
 
        } catch (SQLException ex) {
            System.out.println("este es el error en el modelo:metodo guardar " + ex);
        }
    }
        
        //El método devuelve un valor booleano (verdadero o falso)
       //Verdadero si existe el usuario y Falso si no existe
       public boolean iniciarSesion() {
        //Obtenemos la conexión a la base de datos
        Connection conexion = ClaseConexion.getConexion();
        boolean resultado = false;
        try {
            //Preparamos la consulta SQL para verificar el usuario
            String sql = "SELECT * FROM tbUsuario WHERE correoUsuario = ? AND contrasenaUsuario = ?";
          
            PreparedStatement statement = conexion.prepareStatement(sql);
            String contrasenaEncriptada = convertirSHA256(getContrasenaUsuario());

            statement.setString(1, getCorreoUsuario());
            
            statement.setString(2, contrasenaEncriptada);
            //Ejecutamos la consulta
            ResultSet resultSet = statement.executeQuery();
            //Si hay un resultado, significa que el usuario existe y la contraseña es correcta
            if (resultSet.next()) {
                resultado = true;
            }
        } catch (SQLException ex) {
            System.out.println("Error en el modelo: método iniciarSesion " + ex);
        }
        return resultado;
    }
       
       public String convertirSHA256(String password) {
	MessageDigest md = null;
	try {
		md = MessageDigest.getInstance("SHA-256");
	}
	catch (NoSuchAlgorithmException e) {
		System.out.println(e.toString());
		return null;
	}
	byte[] hash = md.digest(password.getBytes());
	StringBuffer sb = new StringBuffer();
 
	for(byte b : hash) {
		sb.append(String.format("%02x", b));
	}
 
	return sb.toString();
}
 
       
}