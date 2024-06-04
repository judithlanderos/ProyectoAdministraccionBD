/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User-Hp
 */

class ConsultaAutomovilThread extends Thread {
    private String consultaSQL;
    private PreparedStatement pstmt;
    private DefaultTableModel
            modeloTabla;

    public ConsultaAutomovilThread(String consultaSQL, PreparedStatement pstmt, DefaultTableModel modeloTabla) {
        this.consultaSQL = consultaSQL;
        this.pstmt = pstmt;
        this.modeloTabla = modeloTabla;
    }

    @Override
    public void run() {
        try {
            ResultSet resultado = pstmt.executeQuery();
            while (resultado.next()) {
                Object[] fila = {
                    resultado.getString("idAutomovil"),
                    resultado.getString("modelo"),
                    resultado.getString("precio_lista"),
                    resultado.getString("fecha_fabricacion"),
                    resultado.getString("cliente_idCliente"),
                    resultado.getString("placa"),
                    resultado.getString("Marca_idMarca")
                };
                modeloTabla.addRow(fila);
            }
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}