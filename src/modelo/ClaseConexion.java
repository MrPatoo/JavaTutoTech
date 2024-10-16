package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ClaseConexion {
    private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
    private static final String USUARIO = "system";
    private static final String CONTRASENA = "Bimbimcito135@";

    public static Connection getConexion() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            return DriverManager.getConnection(URL, USUARIO, CONTRASENA);
        } catch (SQLException e) {
            System.out.println("Error de SQL: " + e.getMessage());
            return null;
        } catch (ClassNotFoundException ex) {
            System.out.println("Error al cargar la clase del driver: " + ex.getMessage());
            return null;
        }
    }
}
