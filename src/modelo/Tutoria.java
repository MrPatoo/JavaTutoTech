package modelo;


import modelo.ClaseConexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.UUID;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import vista.jpAddTutoria;



public class Tutoria {
    //parametros
    private String uuidTutoria;
    private String nombreTutoria;
    private String descripcionTutoria;
    
    
    
    //getters y setters
    public String getUuidTutoria() {
        return uuidTutoria;
    }

    public void setUuidTutoria(String uuidTutoria) {
        this.uuidTutoria = uuidTutoria;
    }

    public String getNombreTutoria() {
        return nombreTutoria;
    }

    public void setNombreTutoria(String nombreTutoria) {
        this.nombreTutoria = nombreTutoria;
    }

    public String getDescripcionTutoria() {
        return descripcionTutoria;
    }

    public void setDescripcionTutoria(String descripcionTutoria) {
        this.descripcionTutoria = descripcionTutoria;
    }
    
    //METODOS////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    //GUARDAR------------------------------------------------------------------------------------------------------------------
            public void GuardarTuto() {
        // Creamos una variable igual a ejecutar el método de la clase de conexión
        Connection conexion = ClaseConexion.getConexion();

        // Generar ID para la nueva tutoría
        String idTutoria = UUID.randomUUID().toString();

        // Variables para el PreparedStatement
        PreparedStatement addTutoria = null;
        PreparedStatement insertAuditoria = null;

        try {
            // Iniciar la transacción
            conexion.setAutoCommit(false);

            // Preparar la consulta para insertar en tbTutoria
            addTutoria = conexion.prepareStatement("INSERT INTO tbTutoria(idTutoria, nombreTutoria, descripcionTutoria) VALUES (?, ?, ?)");

            // Establecer valores de la consulta SQL
            addTutoria.setString(1, idTutoria);
            addTutoria.setString(2, getNombreTutoria());
            addTutoria.setString(3, getDescripcionTutoria());

            // Ejecutar la consulta
            addTutoria.executeUpdate();

            // Preparar la consulta para la tabla de auditoría
            String sqlAuditoria = "INSERT INTO tbAuditoria (tipoAccion, tablaAfectada, idRegistroAfectado, descripcionAccion) "
                                + "VALUES (?, ?, ?, ?)";

            insertAuditoria = conexion.prepareStatement(sqlAuditoria);
            insertAuditoria.setString(1, "INSERT"); // Tipo de acción
            insertAuditoria.setString(2, "tbTutoria"); // Tabla afectada
            insertAuditoria.setString(3, idTutoria); // ID del registro afectado
            insertAuditoria.setString(4, "Inserción de una nueva tutoría con id: " + idTutoria); // Descripción de la acción

            // Ejecutar la consulta de auditoría
            insertAuditoria.executeUpdate();

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
                if (addTutoria != null) addTutoria.close();
                if (insertAuditoria != null) insertAuditoria.close();
                conexion.setAutoCommit(true); // Restaurar el modo autocommit
            } catch (SQLException e) {
                System.out.println("Error al cerrar recursos: " + e);
            }
        }
    }

           //MOSTRAR////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
           public void Mostrar(JTable tabla) {
        //Creamos una variable de la clase de conexion
        Connection conexion = ClaseConexion.getConexion();
        //Definimos el modelo de la tabla
        DefaultTableModel modeloDeDatos = new DefaultTableModel();
        modeloDeDatos.setColumnIdentifiers(new Object[]{"idTutoria", "nombreTutoria", "descripcionTutoria"});
        try {
            //Creamos un Statement
            Statement statement = conexion.createStatement();
            //Ejecutamos el Statement con la consulta y lo asignamos a una variable de tipo ResultSet
            ResultSet rs = statement.executeQuery("select * from tbTutoria");
            //Recorremos el ResultSet
            while (rs.next()) {
                //Llenamos el modelo por cada vez que recorremos el resultSet
                modeloDeDatos.addRow(new Object[]{rs.getString("idTutoria"), 
                    rs.getString("nombreTutoria"), 
                    rs.getString("descripcionTutoria")});
            }
            //Asignamos el nuevo modelo lleno a la tabla
            tabla.setModel(modeloDeDatos);
        } catch (Exception e) {
            System.out.println("Este es el error en el modelo, metodo mostrar " + e);
        }
    }
       
           //ELIMINAR//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        public void Eliminar(JTable tabla) {
            // Creamos una variable igual a ejecutar el método de la clase de conexión
            Connection conexion = ClaseConexion.getConexion();

            // Obtenemos que fila seleccionó el usuario
            int filaSeleccionada = tabla.getSelectedRow();

            // Obtenemos el id de la fila seleccionada
            String miId = tabla.getValueAt(filaSeleccionada, 0).toString();

            // Variables SQL para eliminación y auditoría
            PreparedStatement deleteEstudiante = null;
            PreparedStatement insertAuditoria = null;

            try {
                // Iniciar la transacción
                conexion.setAutoCommit(false);

                // Borrar el registro de la tabla tbTutoria
                deleteEstudiante = conexion.prepareStatement("DELETE FROM tbTutoria WHERE idTutoria = ?");
                deleteEstudiante.setString(1, miId);
                deleteEstudiante.executeUpdate();

                // Insertar el registro en la tabla de auditoría
                String sqlAuditoria = "INSERT INTO tbAuditoria (tipoAccion, tablaAfectada, idRegistroAfectado, descripcionAccion) "
                                    + "VALUES (?, ?, ?, ?)";

                insertAuditoria = conexion.prepareStatement(sqlAuditoria);
                insertAuditoria.setString(1, "DELETE"); // Tipo de acción
                insertAuditoria.setString(2, "tbTutoria"); // Tabla afectada
                insertAuditoria.setString(3, miId); // ID del registro afectado
                insertAuditoria.setString(4, "Eliminación de una tutoría con id: " + miId); // Descripción de la acción

                insertAuditoria.executeUpdate();

                // Confirmar la transacción
                conexion.commit();

            } catch (Exception e) {
                System.out.println("Este es el error en el método de eliminar: " + e);
                try {
                    if (conexion != null) {
                        conexion.rollback(); // Hacemos rollback si ocurre un error
                    }
                } catch (SQLException ex) {
                    System.out.println("Error al hacer rollback: " + ex);
                }
            } finally {
                try {
                    if (deleteEstudiante != null) deleteEstudiante.close();
                    if (insertAuditoria != null) insertAuditoria.close();
                    conexion.setAutoCommit(true); // Restauramos el modo autocommit
                } catch (SQLException e) {
                    System.out.println("Error al cerrar recursos: " + e);
                }
            }
        }

        
        
    //CARGAR/////////////////////////////////////////////////////////////////////    
    public void cargarDatosTabla(jpAddTutoria vista) {
        // Obtén la fila seleccionada 
        int filaSeleccionada = vista.jtbTutoria.getSelectedRow();
 
        // Debemos asegurarnos que haya una fila seleccionada antes de acceder a sus valores
        if (filaSeleccionada != -1) {
            String UUIDDeTb = vista.jtbTutoria.getValueAt(filaSeleccionada, 0).toString();
            String NombreDeTB = vista.jtbTutoria.getValueAt(filaSeleccionada, 1).toString();
            String DescripcionDeTB = vista.jtbTutoria.getValueAt(filaSeleccionada, 2).toString();
 
            // Establece los valores en los campos de texto
            vista.txtNombre.setText(NombreDeTB);
            vista.txtDescripcion.setText(DescripcionDeTB);
        }
    }
    //ACTUALIZAR/////////////////////////////////////////////////////
public void Actualizar(JTable tabla) {
    //Creamos una variable igual a ejecutar el método de la clase de conexión
    Connection conexion = ClaseConexion.getConexion();

    //obtenemos que fila seleccionó el usuario
    int filaSeleccionada = tabla.getSelectedRow();
    if (filaSeleccionada != -1) {
        //Obtenemos el id de la fila seleccionada
        String miUUId = tabla.getValueAt(filaSeleccionada, 0).toString();
        try { 
            // Obtenemos los datos actuales antes de la actualización (para la auditoría)
            PreparedStatement obtenerDatos = conexion.prepareStatement("SELECT nombreTutoria, descripcionTutoria FROM tbTutoria WHERE idTutoria = ?");
            obtenerDatos.setString(1, miUUId);
            ResultSet rs = obtenerDatos.executeQuery();

            String nombreTutoriaAnterior = "";
            String descripcionTutoriaAnterior = "";

            if (rs.next()) {
                nombreTutoriaAnterior = rs.getString("nombreTutoria");
                descripcionTutoriaAnterior = rs.getString("descripcionTutoria");
            }

            //Ejecutamos la Query de actualización
            PreparedStatement updateUser = conexion.prepareStatement("UPDATE tbTutoria SET nombreTutoria = ?, descripcionTutoria = ? WHERE idTutoria = ?");

            updateUser.setString(1, getNombreTutoria());
            updateUser.setString(2, getDescripcionTutoria());
            updateUser.setString(3, miUUId);
            updateUser.executeUpdate();

        } catch (Exception e) {
            System.out.println("Este es el error en el método de actualizar: " + e);
        }
    } else {
        System.out.println("No hay ninguna fila seleccionada para actualizar.");
    }
}
    //LIMPIAR//////////////////////////////////////////////////////////
    public void LimpiarDatos(jpAddTutoria vista) {
        // Establece los valores en los campos de texto
        vista.txtNombre.setText("");
        vista.txtDescripcion.setText("");
    }
    //
    
    
    
    
    //card-----------------------------------------------------------------
    public ArrayList<String> getTuto() {
        ArrayList<String> tutoname = new ArrayList<>();
        Connection con = new ClaseConexion().getConexion();
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT nombreTutoria FROM tbTutoria");
            while (rs.next()) {
                tutoname.add(rs.getString("nombreTutoria"));
            }
            rs.close();
            stmt.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tutoname;
    }
}
