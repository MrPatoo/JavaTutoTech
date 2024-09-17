package modelo;

import java.sql.*;

public class Usuario {

    private String nombre;
    private int edad;
    private String correo;
    private String contrasena;
    private String rol;

    // Constructor, getters y setters
    public Usuario(String nombre, int edad, String correo, String contrasena, String rol) {
        this.nombre = nombre;
        this.edad = edad;
        this.correo = correo;
        this.contrasena = contrasena;
        this.rol = rol;
    }

    public Usuario() {
    }

    // Getters y setters
    // ...
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public boolean validarCredenciales(String usuario, String clave) {
        Connection con = ClaseConexion.getConexion();

        try {

            Statement st = con.createStatement();
            String sql = "select * from tbUsuario where upper(correoUsuario) = '".concat(usuario)
                    .concat("' and contrasenaUsuario = '").concat(clave).concat("'");
            ResultSet rs = st.executeQuery(sql);

            return rs.next();

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public boolean validarUsuario(String usuario) {
        Connection con = ClaseConexion.getConexion();

        try {

            Statement st = con.createStatement();
            String sql = "select * from tbUsuario where upper(correoUsuario) = '".concat(usuario).concat("'");
            ResultSet rs = st.executeQuery(sql);

            return rs.next();

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public int actualizarClave(String correo, String clave) {
        Connection con = ClaseConexion.getConexion();

        try {

            Statement st = con.createStatement();
            String sql = "update tbUsuario set contrasenaUsuario = '".concat(clave)
                    .concat("' where upper(correoUsuario) = '").concat(correo).concat("'");
            return st.executeUpdate(sql);

        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public boolean registrarUsuario(String idUsuario, String nombre, int edad, String correo, String contrasena, String foto, int idRole) {
        Connection conexion = ClaseConexion.getConexion(); // Obtiene la conexión a la base de datos
        String sql = "INSERT INTO tbUsuario (idUsuario, nombreUsuario, edadUsuario, correoUsuario, contrasenaUsuario, fotoUsuario, idRole) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement pstmt = conexion.prepareStatement(sql)) {
            pstmt.setString(1, idUsuario);
            pstmt.setString(2, nombre);
            pstmt.setInt(3, edad);
            pstmt.setString(4, correo);
            pstmt.setString(5, contrasena);
            pstmt.setString(6, foto);
            pstmt.setInt(7, idRole);

            int filasAfectadas = pstmt.executeUpdate();
            return filasAfectadas > 0; // Retorna true si se registró con éxito
        } catch (SQLException e) {
            System.out.println("Error al registrar el usuario: " + e.getMessage());
            return false;
        } finally {
            try {
                if (conexion != null && !conexion.isClosed()) {
                    conexion.close(); // Cierra la conexión
                }
            } catch (SQLException ex) {
                System.out.println("Error al cerrar la conexión: " + ex.getMessage());
            }
        }

    }

}
