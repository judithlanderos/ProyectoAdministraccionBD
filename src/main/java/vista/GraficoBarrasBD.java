package vista;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import ConexionBD.Conexion;
import javax.swing.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
/**
 *
 * @author User-Hp
 */
public class GraficoBarrasBD {
    private Conexion conexion;

    public JPanel crearPanel() {
        JFreeChart chart = crearGrafico();
        return new ChartPanel(chart);
    }

    private JFreeChart crearGrafico() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        try {
                conexion = Conexion.getInstancia();
            Connection conexionBD = conexion.getConexion();
            String consulta = "SELECT modelo, precio_lista FROM automovil";
            Statement statement = conexionBD.createStatement();
            ResultSet resultSet = statement.executeQuery(consulta);

            while (resultSet.next()) {
                String modelo = resultSet.getString("modelo");
                double precioLista = resultSet.getDouble("precio_lista");
                dataset.addValue(precioLista, "Precio Lista", modelo);
            }

            resultSet.close();
            statement.close();
            conexionBD.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ChartFactory.createBarChart(
                "Precios de Automóviles",
                "Modelo",
                "Precio Lista",
                dataset,
                PlotOrientation.VERTICAL,
                true,
                true,
                false
        );
    }

    public void mostrarGraficaEnVentana() {
        JFrame frame = new JFrame("Gráfico de Barras");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.add(crearPanel());
        frame.pack();
        frame.setLocationRelativeTo(null); // Centra la ventana en la pantalla
        frame.setVisible(true);
    }
}
