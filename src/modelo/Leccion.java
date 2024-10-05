package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.UUID;
import javax.swing.JTable;
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
        //Creamos una variable igual a ejecutar el método de la clase de conexión
        Connection conexion = ClaseConexion.getConexion();
        try {
            //Creamos el PreparedStatement que ejecutará la Query
            PreparedStatement addLec = conexion.prepareStatement("INSERT INTO tbLeccion(idLeccion, tituloLeccion, fechaLeccion, contenidoLeccion, statusLeccion) VALUES (?, ?, ?, ?, ?)");
            //Establecer valores de la consulta SQL
            addLec.setString(1, UUID.randomUUID().toString());
            addLec.setString(2, getTituloLec());
            addLec.setString(3, getFechaLec());
            addLec.setString(4, getContenidoLec());
            addLec.setInt(5, 0);
 
            //Ejecutar la consulta
            addLec.executeUpdate();
 
        } catch (SQLException ex) {
            System.out.println("este es el error en el modelo:metodo guardar " + ex);
        }
    
    }
    
    //mostrar---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    public void MostrarLec(JTable tabla){
    //conexion
        Connection conexion = ClaseConexion.getConexion();
        
        DefaultTableModel modeloDeDatos = new DefaultTableModel();
        
        
          modeloDeDatos.setColumnIdentifiers(new Object[]{"idLeccion", "tituloLeccion", "fechaLeccion", "contenidoLeccion", "statusLeccion", "idTutoria", "idUsuario"});
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
                    rs.getInt("statusLeccion"),
                    rs.getString("idTutoria"),
                    rs.getString("idUsuario")                
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
            String tituloTb = vista.jtbLeccion.getValueAt(filaSeleccionada, 0).toString();
            String fechaTb = vista.jtbLeccion.getValueAt(filaSeleccionada, 1).toString();
            String contenidoTb = vista.jtbLeccion.getValueAt(filaSeleccionada, 2).toString();
           

            // Establece los valores en los campos de texto
            vista.txtTituloLec.setText(tituloTb);
            vista.txtFechaLec.setText(fechaTb);
            vista.txtContenidoLec.setText(contenidoTb);
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
                // Obtenemos los datos actuales antes de la actualización (para la auditoría)
                PreparedStatement obtenerDatos = conexion.prepareStatement("SELECT tituloLeccion, fechaLeccion, contenidoLeccion FROM tbLeccion WHERE idLeccion = ?");
                obtenerDatos.setString(1, miUUId);
                ResultSet rs = obtenerDatos.executeQuery();

                String tituloLecAnterior = "";
                String fechaLecAnterior = "";
                String contenidoLecAnterior = "";

                if (rs.next()) {
                    tituloLecAnterior = rs.getString("tituloLeccion");
                    fechaLecAnterior = rs.getString("fechaLeccion");
                    contenidoLecAnterior = rs.getString("fechaLeccion");
                }

                //Ejecutamos la Query de actualización
                PreparedStatement updateUser = conexion.prepareStatement("UPDATE tbLeccion SET tituloLeccion = ?, fechaLeccion = ?, contenidoLeccion = ? WHERE idLeccion = ?");

                updateUser.setString(1, getTituloLec());
                updateUser.setString(2, getFechaLec());
                updateUser.setString(3, getContenidoLec());
                updateUser.setString(4, miUUId);

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
    }
    
    
    
    
    
    
    
    
    
    
    
    }
    
    
    
    
    

