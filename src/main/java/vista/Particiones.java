/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import java.sql.*;
import ConexionBD.Conexion;

/**
 *
 * @author User-Hp
 */
public class Particiones {
    private Conexion conexion;

    public Particiones() {
                conexion = Conexion.getInstancia();
    }

    public void mostrarInformacionParticiones() {
        String query = "SELECT PARTITION_NAME, PARTITION_EXPRESSION, PARTITION_DESCRIPTION, TABLE_ROWS " +
                       "FROM INFORMATION_SCHEMA.PARTITIONS " +
                       "WHERE TABLE_SCHEMA = 'autosamistosos' AND TABLE_NAME = 'vendedor_particionada'";

        try (Connection conn = conexion.getConexion();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                String partitionName = rs.getString("PARTITION_NAME");
                String partitionExpression = rs.getString("PARTITION_EXPRESSION");
                String partitionDescription = rs.getString("PARTITION_DESCRIPTION");
                long tableRows = rs.getLong("TABLE_ROWS");

                System.out.println("Partition Name: " + partitionName);
                System.out.println("Partition Expression: " + partitionExpression);
                System.out.println("Partition Description: " + partitionDescription);
                System.out.println("Table Rows: " + tableRows);
                System.out.println("-------------------------");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Particiones particiones = new Particiones();
        particiones.mostrarInformacionParticiones();
    }
}