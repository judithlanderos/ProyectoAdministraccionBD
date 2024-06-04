/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author User-Hp
 */
public class VistaAutomovilVenta {
    private String idAutomovil;
    private String modelo;
    private double precioLista;
    private String fechaFabricacion;
    private String placa;
    private String clienteId;
    private String marcaId;
    private String idVenta;
    private String fechaVenta;
    private double precioFinal;

    public VistaAutomovilVenta(String idAutomovil, String modelo, double precioLista, String fechaFabricacion,
                               String placa, String clienteId, String marcaId, String idVenta, String fechaVenta,
                               double precioFinal) {
        this.idAutomovil = idAutomovil;
        this.modelo = modelo;
        this.precioLista = precioLista;
        this.fechaFabricacion = fechaFabricacion;
        this.placa = placa;
        this.clienteId = clienteId;
        this.marcaId = marcaId;
        this.idVenta = idVenta;
        this.fechaVenta = fechaVenta;
        this.precioFinal = precioFinal;
    }

    public String getIdAutomovil() {
        return idAutomovil;
    }

    public void setIdAutomovil(String idAutomovil) {
        this.idAutomovil = idAutomovil;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public double getPrecioLista() {
        return precioLista;
    }

    public void setPrecioLista(double precioLista) {
        this.precioLista = precioLista;
    }

    public String getFechaFabricacion() {
        return fechaFabricacion;
    }

    public void setFechaFabricacion(String fechaFabricacion) {
        this.fechaFabricacion = fechaFabricacion;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getClienteId() {
        return clienteId;
    }

    public void setClienteId(String clienteId) {
        this.clienteId = clienteId;
    }

    public String getMarcaId() {
        return marcaId;
    }

    public void setMarcaId(String marcaId) {
        this.marcaId = marcaId;
    }

    public String getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(String idVenta) {
        this.idVenta = idVenta;
    }

    public String getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(String fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public double getPrecioFinal() {
        return precioFinal;
    }

    public void setPrecioFinal(double precioFinal) {
        this.precioFinal = precioFinal;
    }
}
