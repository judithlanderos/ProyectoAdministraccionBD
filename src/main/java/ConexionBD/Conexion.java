/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ConexionBD;
import java.sql.*;
import java.sql.DriverManager;
/**
 *
 * @author User-Hp
 */
public class Conexion {
    private static Conexion instancia = null;
    private Connection conexion;
    private PreparedStatement preparedStatement;
    //private Statement statement;
    /* NOTA: Es preferible utilizar PreparedStatement para evitar
         SQL INJECTION
     */

    private ResultSet resultSet;

    private Conexion() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String URL = "jdbc:mysql://localhost:3306/autosamistosos"; //direccion de a que se conecta a mysql
            conexion = DriverManager.getConnection(URL, "judith", "judilth@3");

            System.out.println("Yeeeeiiiii ya casi soy ISC");
        } catch (ClassNotFoundException e) {
            // throw new RuntimeException(e);
            System.out.println("Error en el DRIVER");
        } catch (SQLException e) {
            System.out.println("Error en la URL");
        }
    }

    public static Conexion getInstancia() {
        if (instancia == null) {
            instancia = new Conexion();
        }
        return instancia;
    }

    public Connection getConexion() {
        return conexion;
    }

    //*****************CONEXION A POSTGRESQL****************
    //try {
    //   System.out.println("Estableciendo conexión con la base de datos...");
    //   Class.forName("org.postgresql.Driver");
    //  String URL = "jdbc:postgresql://localhost:5432/autosamistosos";
    //    String usuario = "postgres";
    //    String contrasena = "judith";
    //   conexion = DriverManager.getConnection(URL, usuario, contrasena);
    //   System.out.println("Conexión establecida con éxito!");
    // } catch(ClassNotFoundException e){
    //    System.out.println("Error en el controlador JDBC: " + e.getMessage());
    //} catch (SQLException e) {
    //   System.out.println("Error en la conexión a la base de datos: " + e.getMessage());
    //}
    //}

    //Metodos para operaciones ABCC (ALTAS, BAJAS, CAMBIOS, CONSULTAS )
    //(DataManipulation Languaje)
    public boolean ejecutarInstruccionDML(String instruccionSQL) throws SQLException {
        try {
            preparedStatement = conexion.prepareStatement(instruccionSQL);
            return preparedStatement.executeUpdate() >= 1;
        } finally {
            cerrarRecursos();
        }
    }

    //metodo para consultas
    public ResultSet ejecutarConsultaSQL(String instruccionSQL) throws SQLException {
        try {
            preparedStatement = conexion.prepareStatement(instruccionSQL);
            resultSet = preparedStatement.executeQuery();
            return resultSet;
        } finally {

        }
    }

    public boolean autenticarUsuario(String usuario, String contrasena) {
        String sql = "SELECT * FROM usuarios WHERE usuario = ? AND password = ?";
        try {
            preparedStatement = conexion.prepareStatement(sql);
            preparedStatement.setString(1, usuario);
            preparedStatement.setString(2, contrasena);
            resultSet = preparedStatement.executeQuery();
            return resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            cerrarRecursos();
        }
    }

    public void iniciarTransaccion() throws SQLException {
        conexion.setAutoCommit(false);
    }

    public void confirmarTransaccion() throws SQLException {
        conexion.commit();
    }

    public void revertirTransaccion() throws SQLException {
        conexion.rollback();
    }

    public void prepararConsulta(String sql) throws SQLException {
        preparedStatement = conexion.prepareStatement(sql);
    }

    public PreparedStatement getPreparedStatement() {
        return preparedStatement;
    }

    private void cerrarRecursos() {
        try {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (resultSet != null) {
                resultSet.close();
            }
            // No cerramos la conexión aquí, ya que es única y se reutiliza
        } catch (SQLException e) {
            System.out.println("Error al cerrar los recursos de la base de datos");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Conexion conexion = Conexion.getInstancia();
        // Resto del código utilizando la conexión única
    }
}