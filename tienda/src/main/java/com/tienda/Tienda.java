package com.tienda;

import java.util.ArrayList;
import java.util.List;

public class Tienda {
    private List<Producto> inventario;
    private List<Cliente> clientes;
    private List<Venta> historial;
    private List<Promocion> promociones;
    /**
     * @description Constructor
     */
    public Tienda() {
        this.inventario = new ArrayList<>();;
        this.clientes = new ArrayList<>();;
        this.historial = new ArrayList<>();;
        this.promociones = new ArrayList<>();;
    }
    /**
     * 
     * @return
     */
    public List<Producto> getInventario() {
        return inventario;
    }
    /**
     * 
     * @return
     */
    public List<Cliente> getClientes() {
        return clientes;
    }
    /**
     * 
     * @return
     */
    public List<Promocion> getPromociones() {
        return promociones;
    }
    /**
     * @description Registra un producto en la tienda
     * @param producto
     */
    public void registrarProducto(Producto producto) {
        inventario.add(producto);
    }
    /**
     * @description Registra un cliente en la tienda
     * @param cliente
     */
    public void registrarCliente(Cliente cliente) {
        clientes.add(cliente);
    }
    /**
     * @description Registra una promoción en la tienda
     * @param promocion
     */
    public void registrarPromocion(Promocion promocion) {
        promociones.add(promocion);
    }
    /**
     * @description Realiza una venta
     * @param productosVendidos
     * @param cantidadesVendidas
     * @param cliente
     */
    public void realizarVenta(List<Producto> productosVendidos, List<Integer> cantidadesVendidas, Cliente cliente, Promocion promocion) {
        Venta venta = new Venta(productosVendidos, cantidadesVendidas, cliente);
        if (promocion != null) {
            venta.setTotal(promocion.aplicarDescuento(venta.getTotal()));
        }
        historial.add(venta);
        actualizarStock(productosVendidos, cantidadesVendidas);
        System.out.println("Venta realizada. Total: " + venta.getTotal());
    }
    /**
     * @description Actualiza el stock de los productos
     * @param productosVendidos
     * @param cantidadesVendidas
     */
    private void actualizarStock(List<Producto> productosVendidos, List<Integer> cantidadesVendidas) {
        for (int i = 0; i < productosVendidos.size(); i++) {
            Producto producto = productosVendidos.get(i);
            int cantidadVendida = cantidadesVendidas.get(i);
            producto.actualizarStock(-cantidadVendida);
        }
    }
    /**
     * @description Muestra la todos los productos
     */
    public void mostrarInventario() {
        if (inventario.size() > 0) {
            for (int i = 0; i < inventario.size(); i++) {
                System.out.println(i + 1 + ". " + inventario.get(i).toString());
            }
        } else {
            System.out.println("No hay productos registrados.");
        }
    }
    /**
     * @description Muestra todas las ventas realizadas
     */
    public void mostrarHistorialVentas() {
        if (historial.size() > 0) {
            for (int i = 0; i < historial.size(); i++) {
                System.out.println(i + 1 + ". " + historial.get(i).toString());
            }
        } else {
            System.out.println("No hay ventas registradas.");
        }
    }
    /**
     * @description Muestra todos los clientes de la tienda
     */
    public void mostrarClientes() {
        if (clientes.size() > 0) {
            for (int i = 0; i < clientes.size(); i++) {
                System.out.println(i + 1 + ". " + clientes.get(i).toString());
            }
        } else {
            System.out.println("No hay clientes registrados.");
        }
    }
    /**
     * @description Muestra todas las promociones de la tienda
     */
    public void mostrarPromociones() {
        if (promociones.size() > 0) {
            for (int i = 0; i < promociones.size(); i++) {
                System.out.println(i + 1 + ". " + promociones.get(i).toString());
            }
        } else {
            System.out.println("No hay promociones registradas.");
        }
    }
}
