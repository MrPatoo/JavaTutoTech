package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.UUID;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import vista.jpAddLeccion;

public class Leccion {
    private String tituloLec;
    private String fechaLec;
    private String contenidoLec;
    private int statusLec;
    
    public String getTituloLec() {
        return tituloLec;
    }
    public void setTituloLec(String tituloLec) {
        this.tituloLec = tituloLec;
    }
    public String getFechaLec() {
        return fechaLec;
    }
    public void setFechaLec(String fechaLec) {
        this.fechaLec = fechaLec;
    }
    public String getContenidoLec() {
        return contenidoLec;
    }
    public void setContenidoLec(String contenidoLec) {
        this.contenidoLec = contenidoLec;
    }
    public int getStatusLec() {
        return statusLec;
    }
    public void setStatusLec(int statusLec) {
        this.statusLec = statusLec;
    }
    //METODOS************************************************
    //guardar----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    public void GuardarLec() {
        // Creamos una variable igual a ejecutar el método de la clase de conexión
        Connection conexion = ClaseConexion.getConexion();
        // Generar ID para la nueva tutoría
        String idLeccion = UUID.randomUUID().toString();
        // Variables para el PreparedStatement
        PreparedStatement addLeccion = null;
        PreparedStatement insertLeccion = null;
        try {
            // Iniciar la transacción
            conexion.setAutoCommit(false);
            // Preparar la consulta para insertar en tbTutoria
            addLeccion = conexion.prepareStatement("INSERT INTO tbLeccion(idLeccion, tituloLeccion, fechaLeccion, contenidoLeccion, statusLeccion) VALUES (?, ?, ?, ?, ?)");
            // Establecer valores de la consulta SQL
            addLeccion.setString(1, idLeccion);
            addLeccion.setString(2, getTituloLec());
            addLeccion.setString(3, getFechaLec());
            addLeccion.setString(4, getContenidoLec());
            addLeccion.setInt(5, getStatusLec());

            // Ejecutar la consulta
            addLeccion.executeUpdate();
            // Preparar la consulta para la tabla de auditoría
            String sqlAuditoria = "INSERT INTO tbAuditoria (tipoAccion, tablaAfectada, idRegistroAfectado, descripcionAccion) "
                    + "VALUES (?, ?, ?, ?)";
            insertLeccion = conexion.prepareStatement(sqlAuditoria);
            insertLeccion.setString(1, "INSERT"); // Tipo de acción
            insertLeccion.setString(2, "tbTutoria"); // Tabla afectada
            insertLeccion.setString(3, idLeccion); // ID del registro afectado
            insertLeccion.setString(4, "Inserción de una nueva lección con id: " + idLeccion); // Descripción de la acción
            // Ejecutar la consulta de auditoría
            insertLeccion.executeUpdate();
            // Confirmar la transacción
            conexion.commit();
        } catch (SQLException ex) {
            System.out.println("Este es el error en el modelo: método guardar " + ex);
            try {
                if (conexion != null) {
                    conexion.rollback(); // Hacer rollback si ocurre un error
                }
            } catch (SQLException rollbackEx) {
                System.out.println("Error al hacer rollback: " + rollbackEx);
            }
        } finally {
            try {
                if (addLeccion != null) {
                    addLeccion.close();
                }
                if (insertLeccion != null) {
                    insertLeccion.close();
                }
                conexion.setAutoCommit(true); // Restaurar el modo autocommit
            } catch (SQLException e) {
                System.out.println("Error al cerrar recursos: " + e);
            }
        }
    }
    //mostrar---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    public void MostrarLec(JTable tabla){
        //conexion
        Connection conexion = ClaseConexion.getConexion();
        DefaultTableModel modeloDeDatos = new DefaultTableModel();  
          modeloDeDatos.setColumnIdentifiers(new Object[]{"idLeccion", "tituloLeccion", "fechaLeccion", "contenidoLeccion", "statusLeccion"});
        try {
            //Creamos un Statement
            Statement statement = conexion.createStatement();
            //Ejecutamos el Statement con la consulta y lo asignamos a una variable de tipo ResultSet
            ResultSet rs = statement.executeQuery("SELECT * FROM tbLeccion");
            //Recorremos el ResultSet
            while (rs.next()) {
                //Llenamos el modelo por cada vez que recorremos el resultSet
                modeloDeDatos.addRow(new Object[]{
                    rs.getString("idLeccion"), 
                    rs.getString("tituloLeccion"), 
                    rs.getString("fechaLeccion"), 
                    rs.getString("contenidoLeccion"),
                    rs.getInt("statusLeccion")    
                });         
            }
            //Asignamos el nuevo modelo lleno a la tabla
            tabla.setModel(modeloDeDatos);
        } catch (Exception e) {
            System.out.println("Este es el error en el modelo, metodo mostrar " + e);
        }
    }    
    //eliminar----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    public void EliminarLec(JTable tabla){
        Connection conexion = ClaseConexion.getConexion();    
        int filaSeleccionada = tabla.getSelectedRow();
        String miId = tabla.getValueAt(filaSeleccionada, 0).toString();        
        //borramos
        try{
            PreparedStatement deleteLec = conexion.prepareStatement("delete from tbLeccion where idLeccion = ?");
            
            deleteLec.setString(1, miId);
            deleteLec.executeUpdate();           
        }
        catch(Exception e){
            System.out.println("error en metodo eliminar: " + e);
        }
    }    
    //cargar----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    public void cargarDatosTablaLec(jpAddLeccion vista) {
        // Obtén la fila seleccionada 
        int filaSeleccionada = vista.jtbLeccion.getSelectedRow();

        // Debemos asegurarnos que haya una fila seleccionada antes de acceder a sus valores
        if (filaSeleccionada != -1) {
            String UUIDtb = vista.jtbLeccion.getValueAt(filaSeleccionada, 0).toString();
            String tituloTb = vista.jtbLeccion.getValueAt(filaSeleccionada, 1).toString();
            String fechaTb = vista.jtbLeccion.getValueAt(filaSeleccionada, 2).toString();
            String contenidoTb = vista.jtbLeccion.getValueAt(filaSeleccionada, 3).toString();
            String statusTb = vista.jtbLeccion.getValueAt(filaSeleccionada, 4).toString();
         
            // Establece los valores en los campos de texto
            vista.txtTituloLec.setText(tituloTb);
            vista.txtFechaLec.setText(fechaTb);
            vista.txtContenidoLec.setText(contenidoTb);
            vista.txtStatusLec.setText(statusTb);
        }
    }      
    //actualizar--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    public void ActualizarLec(JTable tabla){       
        Connection conexion = ClaseConexion.getConexion();
         int filaSeleccionada = tabla.getSelectedRow();
        if (filaSeleccionada != -1) {
            //Obtenemos el id de la fila seleccionada
            String miUUId = tabla.getValueAt(filaSeleccionada, 0).toString();
            try {
                //Ejecutamos la Query de actualización
                PreparedStatement updateUser = conexion.prepareStatement("UPDATE tbLeccion SET tituloLeccion = ?, fechaLeccion = ?, contenidoLeccion = ?, statusLeccion = ? WHERE idLeccion = ?");

                updateUser.setString(1, getTituloLec());
                updateUser.setString(2, getFechaLec());
                updateUser.setString(3, getContenidoLec());
                updateUser.setInt(4, getStatusLec());
                updateUser.setString(5, miUUId);
                updateUser.executeUpdate();
            } catch (Exception e) {
                System.out.println("Este es el error en el método de actualizar: " + e);
            }     
        } else {
            System.out.println("No hay ninguna fila seleccionada para actualizar.");
        }         
    }
     public void LimpiarDatosLec(jpAddLeccion vista) {
        // Establece los valores en los campos de texto
        vista.txtTituloLec.setText("");
        vista.txtFechaLec.setText("");
        vista.txtContenidoLec.setText("");
        vista.txtStatusLec.setText("");
    }
     //metodo buscar
    public void BuscarLec(JTable tabla, JTextField txtBuscarLec) {
        //Creamos una variable igual a ejecutar el método de la clase de conexión
        Connection conexion = ClaseConexion.getConexion();
        //Definimos el modelo de la tabla
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(new Object[] {"idLeccion", "tituloLeccion", "fechaLeccion", "contenidoLeccion", "statusLeccion"});
        try {
            PreparedStatement buscarLec = conexion.prepareStatement("SELECT * FROM tbLeccion WHERE tituloLeccion LIKE ? || '%'");
            buscarLec.setString(1, txtBuscarLec.getText());
            ResultSet rs = buscarLec.executeQuery();
 
             while (rs.next()) {
                //Llenamos el modelo por cada vez que recorremos el resultSet
                modelo.addRow(new Object[]{rs.getString("idLeccion"), 
                    rs.getString("tituloLeccion"), 
                    rs.getString("fechaLeccion"), 
                    rs.getString("contenidoLeccion"), 
                    rs.getInt("statusLeccion")});
            }
            //Asignamos el nuevo modelo lleno a la tabla
            tabla.setModel(modelo);
        } catch (Exception e) {
            System.out.println("Este es el error en el modelo, metodo de buscar " + e);
        }
    }
}