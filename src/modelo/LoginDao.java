/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import Modelo.ClaseConexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author lenovo
 */
public class LoginDao {

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
}
