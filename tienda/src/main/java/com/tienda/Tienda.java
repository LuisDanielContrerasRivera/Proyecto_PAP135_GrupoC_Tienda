package com.tienda;

import java.util.ArrayList;
import java.util.List;

public class Tienda {
    private List<Producto> inventario;
    private List<Cliente> clientes;
    private List<Venta> historial;
    private List<Promocion> promociones;
    public Tienda() {
        this.inventario = new ArrayList<>();;
        this.clientes = new ArrayList<>();;
        this.historial = new ArrayList<>();;
        this.promociones = new ArrayList<>();;
    }
    public void registrarProducto(Producto producto) {
        inventario.add(producto);
    }
    public void registrarCliente(Cliente cliente) {
        clientes.add(cliente);
    }
    public void registrarPromocion(Promocion promocion) {
        promociones.add(promocion);
    }
    public void realizarVenta(List<Producto> productosVendidos, List<Integer> cantidadesVendidas, Cliente cliente) {
        Venta venta = new Venta(productosVendidos, cantidadesVendidas, cliente);
        historial.add(venta);
        actualizarStock(productosVendidos, cantidadesVendidas);
        System.out.println("Venta realizada. Total: " + venta.getTotal());
    }
    private void actualizarStock(List<Producto> productosVendidos, List<Integer> cantidadesVendidas) {
        for (int i = 0; i < productosVendidos.size(); i++) {
            Producto producto = productosVendidos.get(i);
            int cantidadVendida = cantidadesVendidas.get(i);
            producto.actualizarStock(-cantidadVendida);
        }
    }
    public void mostrarInventario() {
        for (Producto producto : inventario) {
            System.out.println("Producto: " + producto.getNombre() + ", Precio: " + producto.getPrecio() + ", Stock: " + producto.getStock());
        }
    }
    public void mostrarHistorialVentas() {
        for (Venta venta : historial) {
            System.out.println("Venta a cliente: " + venta.getCliente().getNombre() + ", Total: " + venta.getTotal());
        }
    }
    public void mostrarClientes() {
        for (Cliente cliente : clientes) {
            System.out.println("Cliente: " + cliente.getNombre() + ", Teléfono: " + cliente.getTelefono() + ", Dirección: " + cliente.getDireccion());
        }
    }
}
