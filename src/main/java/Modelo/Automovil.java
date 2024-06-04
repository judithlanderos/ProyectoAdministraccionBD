/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author User-Hp
 */
public class Automovil {
     private String idAutomovil;
    private String modelo;
    private double precioLista;
    private String fechaFabricacion;
    private String clienteId;
    private String placa;
    private String marcaId;

    public Automovil(String idAutomovil, String modelo, double precioLista, String fechaFabricacion,
            String clienteId, String placa, String marcaId) {
        this.idAutomovil = idAutomovil;
        this.modelo = modelo;
        this.precioLista = precioLista;
        this.fechaFabricacion = fechaFabricacion;
        this.clienteId = clienteId;
        this.placa = placa;
        this.marcaId = marcaId;
    }

    public String getIdAutomovil() {
        return idAutomovil;
    }

    public String getModelo() {
        return modelo;
    }

    public double getPrecioLista() {
        return precioLista;
    }

    public String getFechaFabricacion() {
        return fechaFabricacion;
    }

    public String getClienteId() {
        return clienteId;
    }

    public String getPlaca() {
        return placa;
    }

    public String getMarcaId() {
        return marcaId;
    }

    public void setIdAutomovil(String idAutomovil) {
        this.idAutomovil = idAutomovil;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setPrecioLista(double precioLista) {
        this.precioLista = precioLista;
    }

    public void setFechaFabricacion(String fechaFabricacion) {
        this.fechaFabricacion = fechaFabricacion;
    }

    public void setClienteId(String clienteId) {
        this.clienteId = clienteId;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public void setMarcaId(String marcaId) {
        this.marcaId = marcaId;
    }

}
