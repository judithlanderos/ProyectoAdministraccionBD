package vista;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import ConexionBD.Conexion;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.view.JasperViewer;
import java.sql.Connection;
/**
 *
 * @author User-Hp
 */
public class Reporte {
    private Conexion conexion;

    public void generarYMostrarReporte() {
        try {
           conexion = Conexion.getInstancia();
            Connection conexionBD = conexion.getConexion();
            
            JasperReport jasperReport = JasperCompileManager.compileReport("C:\\Users\\User-Hp\\Documents\\NetBeansProjects\\ProyectoAdministraccionBD\\src\\main\\resources\\ReporteBaseDeDatos.jrxml");

            // Llenar el informe con datos
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, conexionBD);

            JasperExportManager.exportReportToPdfFile(jasperPrint, "C:\\Users\\User-Hp\\Documents\\NetBeansProjects\\ProyectoAdministraccionBD\\src\\main\\resources\\ReporteBaseDeDatos.pdf");

            JasperViewer.viewReport(jasperPrint, false);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
