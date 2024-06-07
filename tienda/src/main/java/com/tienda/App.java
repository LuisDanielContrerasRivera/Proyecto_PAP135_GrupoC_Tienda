package com.tienda;

import java.util.Arrays;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Menu menu = new Menu();
        menu.ejecutarMenu();
        // Tienda tienda = new Tienda();

        // // Crear algunos productos
        // Producto p1 = new Producto("Laptop", 1000, 10);
        // Producto p2 = new Producto("Mouse", 50, 100);

        // // Registrar productos en la tienda
        // tienda.registrarProducto(p1);
        // tienda.registrarProducto(p2);

        // // Crear un cliente5
        // Cliente c1 = new Cliente("Juan Perez", "555-1234", "Calle Falsa 123");

        // // Registrar cliente en la tienda
        // tienda.registrarCliente(c1);
        // tienda.realizarVenta(Arrays.asList(p1, p2), Arrays.asList(1, 2), c1);

        // // Mostrar inventario, historial de ventas y clientes
        // tienda.mostrarInventario();
        // tienda.mostrarHistorialVentas();
        // tienda.mostrarClientes();
    }
}
