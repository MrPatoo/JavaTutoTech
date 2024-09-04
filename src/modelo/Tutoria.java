package modelo;


import Modelo.ClaseConexion;
import java.sql.*;
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
        //Creamos una variable igual a ejecutar el método de la clase de conexión
        Connection conexion = ClaseConexion.getConexion();
        try {
            //Creamos el PreparedStatement que ejecutará la Query
            PreparedStatement addTutoria = conexion.prepareStatement("INSERT INTO tbTutoria(idTutoria, nombreTutoria, descripcionTutoria) VALUES (?, ?, ?)");
            //Establecer valores de la consulta SQL
            addTutoria.setString(1, UUID.randomUUID().toString());
            addTutoria.setString(2, getNombreTutoria());
            addTutoria.setString(3, getDescripcionTutoria());
            
            //Ejecutar la consulta
            addTutoria.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("este es el error en el modelo:metodo guardar " + ex);
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
        //Creamos una variable igual a ejecutar el método de la clase de conexión
        Connection conexion = ClaseConexion.getConexion();
 
        //obtenemos que fila seleccionó el usuario
        int filaSeleccionada = tabla.getSelectedRow();
        //Obtenemos el id de la fila seleccionada
        String miId = tabla.getValueAt(filaSeleccionada, 0).toString();
        //borramos 
        try {
            PreparedStatement deleteEstudiante = conexion.prepareStatement("delete from tbTutoria where idTutoria = ?");
            deleteEstudiante.setString(1, miId);
            deleteEstudiante.executeUpdate();
            
            // Verificar la tabla de auditoría
            PreparedStatement verificarAuditoria = conexion.prepareStatement(
                "SELECT * FROM auditoria WHERE accion = 'DELETE' AND tabla_nombre = 'tbTutoria' ORDER BY fecha DESC FETCH FIRST 1 ROWS ONLY"
            );
            
            ResultSet rs = verificarAuditoria.executeQuery();
        
            // Si hay un resultado, imprimimos la verificación de auditoría
            if (rs.next()) {
                String datosAnteriores = rs.getString("datos_anteriores");
                System.out.println("Registro de auditoría (DELETE): " + datosAnteriores);
            } else {
                System.out.println("No se encontró registro de auditoría para el DELETE.");
            }
        } catch (Exception e) {
            System.out.println("este es el error metodo de eliminar" + e);
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

            // Insertar en la tabla de auditoría el cambio realizado
            PreparedStatement auditoriaUpdate = conexion.prepareStatement(
                "INSERT INTO auditoria (tabla_nombre, accion, datos_anteriores, datos_nuevos) VALUES (?, ?, ?, ?)"
            );

            auditoriaUpdate.setString(1, "tbTutoria");
            auditoriaUpdate.setString(2, "UPDATE");

            // Concatenamos los datos anteriores y nuevos para almacenarlos en la auditoría
            String datosAnteriores = "nombreTutoria: " + nombreTutoriaAnterior + ", descripcionTutoria: " + descripcionTutoriaAnterior;
            String datosNuevos = "nombreTutoria: " + getNombreTutoria() + ", descripcionTutoria: " + getDescripcionTutoria();

            auditoriaUpdate.setString(3, datosAnteriores);
            auditoriaUpdate.setString(4, datosNuevos);

            // Ejecutamos la auditoría
            auditoriaUpdate.executeUpdate();

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
}
