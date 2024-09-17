/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author lenovo
 */
public class CambioClave {

    private String correo;
    private String codigo;
    private String estadoCodigo;

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getEstadoCodigo() {
        return estadoCodigo;
    }

    public void setEstadoCodigo(String estadoCodigo) {
        this.estadoCodigo = estadoCodigo;
    }

    public boolean almarcarRegistro(String correo, String codigo) {
        Connection conexion = ClaseConexion.getConexion();
        String sql = "insert into tbRegistroCodigo(correo, codigo, estado) "
                + "values(?,?,?)";
        try (PreparedStatement st = conexion.prepareCall(sql)) {

            st.setString(1, correo);
            st.setString(2, codigo);
            st.setString(3, "A");

            return st.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al registrar el usuario: " + e.getMessage());
            return false;
        } finally {
            try {
                if (conexion != null && !conexion.isClosed()) {
                    conexion.close();
                }
            } catch (SQLException ex) {
                System.out.println("Error al cerrar la conexión: " + ex.getMessage());
            }
        }
    }

    public CambioClave encontroCodigo(String codigo) {
        Connection conexion = ClaseConexion.getConexion();
        try {

            CambioClave cv = null;
            Statement st = conexion.createStatement();
            String sql = "select * from tbRegistroCodigo where codigo = '"
                    .concat(codigo).concat("' and estado = 'A'");

            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                cv = new CambioClave();
                cv.setCorreo(rs.getString("correo"));
                cv.setCodigo(rs.getString("codigo"));
                cv.setEstadoCodigo(rs.getString("estado"));
            }

            return cv;
        } catch (Exception e) {
            System.out.println("Error al registrar el usuario: " + e.getMessage());
            return null;
        } finally {
            try {
                if (conexion != null && !conexion.isClosed()) {
                    conexion.close();
                }
            } catch (SQLException ex) {
                System.out.println("Error al cerrar la conexión: " + ex.getMessage());
            }
        }
    }

    public boolean actualizarEstado(String correo, String codigo) {
        Connection conexion = ClaseConexion.getConexion();

        try {
            Statement st = conexion.createStatement();
            String sql = "update tbRegistroCodigo set estado = '".concat("I")
                    .concat("' Where correo = '").concat(correo)
                    .concat("' and codigo = '").concat(codigo).concat("'");

            return st.executeUpdate(sql) > 0;
        } catch (SQLException e) {
            System.out.println("Error al registrar el usuario: " + e.getMessage());
            return false;
        } finally {
            try {
                if (conexion != null && !conexion.isClosed()) {
                    conexion.close();
                }
            } catch (SQLException ex) {
                System.out.println("Error al cerrar la conexión: " + ex.getMessage());
            }
        }
    }
}
