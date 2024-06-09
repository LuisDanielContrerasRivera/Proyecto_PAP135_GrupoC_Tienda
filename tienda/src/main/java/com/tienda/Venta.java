package com.tienda;

import java.util.List;

public class Venta {
    private List<Producto> productos;
    private List<Integer> cantidades;
    private Cliente cliente;
    private double total;
    /**
     * @description Constructor
     * @param productos
     * @param cantidades
     * @param cliente
     */
    public Venta(List<Producto> productos, List<Integer> cantidades, Cliente cliente) {
        this.productos = productos;
        this.cantidades = cantidades;
        this.cliente = cliente;
        this.total = calcularTotalVenta();
    }
    /**
     * @description Calcula el total de la venta
     * @return double
     */
    public double calcularTotalVenta() {
        double total = 0;
        for (int i = 0; i < productos.size(); i++) {
            total += productos.get(i).calcularPrecioTotal(cantidades.get(i));
        }
        return total;
    }
    /**
     * @description Getter para la propiedad productos
     * @return List<Producto>
     */
    public List<Producto> getProductos() {
        return productos;
    }
    /**
     * @description Getter para la propiedad cantidades
     * @return List<Integer>
     */
    public List<Integer> getCantidades() {
        return cantidades;
    }
    /**
     * @description Getter para la propiedad cliente
     * @return Cliente
     */
    public Cliente getCliente() {
        return cliente;
    }
    /**
     * @description Getter para la propiedad total
     * @return double
     */
    public double getTotal() {
        return total;
    }
    /**
     * @description Actualiza el total de la venta
     * @param total
     */
    public void setTotal(double total) {
        this.total = total;
    }
    @Override
    public String toString() {
        return "Venta [productos: " + productos + ", cantidades: " + cantidades + ", " + cliente + ", total: "
                + total + "]";
    }
}
