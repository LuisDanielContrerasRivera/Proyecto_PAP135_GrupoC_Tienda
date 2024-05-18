package com.tienda;

import java.util.List;

public class Venta {
    private List<Producto> productos;
    private List<Integer> cantidades;
    private Cliente cliente;
    private double total;
    public Venta(List<Producto> productos, List<Integer> cantidades, Cliente cliente) {
        this.productos = productos;
        this.cantidades = cantidades;
        this.cliente = cliente;
        this.total = calcularTotalVenta();
    }
    public double calcularTotalVenta() {
        double total = 0;
        for (int i = 0; i < productos.size(); i++) {
            total += productos.get(i).calcularPrecioTotal(cantidades.get(i));
        }
        return total;
    }
    public List<Producto> getProductos() {
        return productos;
    }
    public List<Integer> getCantidades() {
        return cantidades;
    }
    public Cliente getCliente() {
        return cliente;
    }
    public double getTotal() {
        return total;
    }
}
