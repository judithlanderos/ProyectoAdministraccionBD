/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import ConexionBD.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import Modelo.Automovil;
import Modelo.VistaAutomovilVenta;

/**
 *
 * @author User-Hp
 */
public class AutomovilDAO {

 private Conexion conexion;

    public AutomovilDAO() {
        conexion = Conexion.getInstancia();
    }
    public void iniciarTransaccion() throws SQLException {
        conexion.iniciarTransaccion();
    }

    public void confirmarTransaccion() throws SQLException {
        conexion.confirmarTransaccion();
    }

    public void revertirTransaccion() throws SQLException {
        conexion.revertirTransaccion();
    }
      public void agregarAutomovil(String idAutomovil, String modelo, double precioLista, String fechaFabricacion, String placa, String idCliente, String idMarca) {
        int cantidadAutomoviles = contarAutomovilesPorId(idAutomovil);
        if (cantidadAutomoviles > 0) {
            System.out.println("El ID del automóvil ya está en uso. Por favor, elija un ID diferente.");
            return;
        }
          try {
            String sql = "INSERT INTO automovil (idAutomovil, modelo, precio_lista, fecha_fabricacion, Cliente_idCliente, placa, Marca_idMarca) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = conexion.getConexion().prepareStatement(sql);
            statement.setString(1, idAutomovil);
            statement.setString(2, modelo);
            statement.setDouble(3, precioLista);
            statement.setString(4, fechaFabricacion);
            statement.setString(5, idCliente);
            statement.setString(6, placa);
            statement.setString(7, idMarca);
            int filasAfectadas = statement.executeUpdate();

            if (filasAfectadas > 0) {
                System.out.println("Automóvil agregado correctamente.");
            } else {
                System.out.println("Error al agregar el automóvil.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
     public int contarAutomovilesPorId(String idAutomovil) {
         
            int cantidad = 0;
            try {
                String sql = "SELECT COUNT(*) FROM automovil WHERE idAutomovil = ?";
                PreparedStatement statement = conexion.getConexion().prepareStatement(sql);
                statement.setString(1, idAutomovil);
                ResultSet resultSet = statement.executeQuery();
                if (resultSet.next()) {
                    cantidad = resultSet.getInt(1);
                }
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return cantidad;
        }

    public void eliminarAutomovil(String idAutomovil) {
    try {
        Automovil automovilEliminado = obtenerAutomovilPorId(idAutomovil);

        String sql = "DELETE FROM automovil WHERE idAutomovil = ?";
        PreparedStatement statement = conexion.getConexion().prepareStatement(sql);
        statement.setString(1, idAutomovil);
        int filasAfectadas = statement.executeUpdate();

        if (filasAfectadas > 0) {
            System.out.println("Automóvil eliminado correctamente.");
            // Guardar el automóvil eliminado en la tabla de respaldo
            guardarAutomovilEnRespaldo(automovilEliminado);
        } else {
            System.out.println("No se encontró ningún automóvil con la información especificada.");
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

    private void guardarAutomovilEnRespaldo(Automovil automovil) {
        try {
            String sql = "INSERT INTO respaldo (idAutomovil, modelo, precio_lista, fecha_fabricacion, Cliente_idCliente, placa, Marca_idMarca) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = conexion.getConexion().prepareStatement(sql);
            statement.setString(1, automovil.getIdAutomovil());
            statement.setString(2, automovil.getModelo());
            statement.setDouble(3, automovil.getPrecioLista());
            statement.setString(4, automovil.getFechaFabricacion());
            statement.setString(5, automovil.getClienteId());
            statement.setString(6, automovil.getPlaca());
            statement.setString(7, automovil.getMarcaId());

            int filasAfectadas = statement.executeUpdate();

            if (filasAfectadas > 0) {
                System.out.println("Automóvil guardado en la tabla de respaldo correctamente.");
            } else {
                System.out.println("Error al guardar el automóvil en la tabla de respaldo.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
}

    public Automovil obtenerAutomovilPorId(String idAutomovil) {
        Automovil automovil = null;
        try {
            String sql = "SELECT * FROM automovil WHERE idAutomovil = ?";
            PreparedStatement statement = conexion.getConexion().prepareStatement(sql);
            statement.setString(1, idAutomovil);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String modelo = resultSet.getString("modelo");
                double precioLista = resultSet.getDouble("precio_lista");
                String fechaFabricacion = resultSet.getString("fecha_fabricacion");
                String placa = resultSet.getString("placa");
                String clienteId = resultSet.getString("Cliente_idCliente");
                String marcaId = resultSet.getString("Marca_idMarca");

                automovil = new Automovil(idAutomovil, modelo, precioLista, fechaFabricacion, clienteId, placa, marcaId);
            }
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return automovil;
    }

    public void actualizarAutomovil(String placa, String nuevoModelo, double nuevoPrecioLista) {
        try {
            String sql = "UPDATE automovil SET modelo = ?, precio_lista = ? WHERE placa = ?";
            PreparedStatement statement = conexion.getConexion().prepareStatement(sql);
            statement.setString(1, nuevoModelo);
            statement.setDouble(2, nuevoPrecioLista);
            statement.setString(3, placa);

            int filasAfectadas = statement.executeUpdate();

            if (filasAfectadas > 0) {
                System.out.println("Automóvil actualizado correctamente.");
            } else {
                System.out.println("No se encontró ningún automóvil con la placa especificada.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public ArrayList<Automovil> consultarAutomoviles() {
        ArrayList<Automovil> listaAutomoviles = new ArrayList<>();
        try {
            Statement statement = conexion.getConexion().createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM automovil");

            while (resultSet.next()) {
                String idAutomovil = resultSet.getString("idAutomovil");
                String modelo = resultSet.getString("modelo");
                double precioLista = resultSet.getDouble("precio_lista");
                String fechaFabricacion = resultSet.getString("fecha_fabricacion");
                String placa = resultSet.getString("placa");
                String clienteId = resultSet.getString("Cliente_idCliente");
                String marcaId = resultSet.getString("Marca_idMarca");

                Automovil automovil = new Automovil(idAutomovil, modelo, precioLista, fechaFabricacion, clienteId, placa, marcaId);
                listaAutomoviles.add(automovil);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaAutomoviles;
    }
    public ArrayList<VistaAutomovilVenta> consultarVistaAutomovilVenta() {
        ArrayList<VistaAutomovilVenta> listaVista = new ArrayList<>();
        try {
            Statement statement = conexion.getConexion().createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM vista_automovil_venta");

            while (resultSet.next()) {
                String idAutomovil = resultSet.getString("idAutomovil");
                String modelo = resultSet.getString("modelo");
                double precioLista = resultSet.getDouble("precio_lista");
                String fechaFabricacion = resultSet.getString("fecha_fabricacion");
                String placa = resultSet.getString("placa");
                String clienteId = resultSet.getString("Cliente_idCliente");
                String marcaId = resultSet.getString("Marca_idMarca");
                String idVenta = resultSet.getString("idVenta");
                String fechaVenta = resultSet.getString("fecha_venta");
                double precioFinal = resultSet.getDouble("precio_final");

                VistaAutomovilVenta vista = new VistaAutomovilVenta(idAutomovil, modelo, precioLista, fechaFabricacion,
                        placa, clienteId, marcaId, idVenta, fechaVenta, precioFinal);
                listaVista.add(vista);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaVista;
}

}

