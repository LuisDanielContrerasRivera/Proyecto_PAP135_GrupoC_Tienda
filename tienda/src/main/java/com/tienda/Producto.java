package com.tienda;

public class Producto {
    private String nombre;
    private double precio;
    private int stock;
    /**
     * @description Constructor
     * @param nombre
     * @param precio
     * @param stock
     */
    public Producto(String nombre, double precio, int stock) {
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }
    /**
     * @description Actualiza la cantidad
     * @param cantidad
     */
    public void actualizarStock(int cantidad) {
        this.stock += cantidad;
    }
    /**
     * @description Calcula el precio total del producto
     * @param cantidad
     * @return double
     */
    public double calcularPrecioTotal(int cantidad) {
        return this.precio * cantidad;
    }
    /**
     * @description Getter para la propiedad nombre
     * @return String
     */
    public String getNombre() {
        return nombre;
    }
    /**
     * @description Getter para la propiedad precio
     * @return double
     */
    public double getPrecio() {
        return precio;
    }
    /**
     * @description Getter para la propiedad stock
     * @return int
     */
    public int getStock() {
        return stock;
    }
}
