package com.tienda;

import java.util.Scanner;

public class Menu {
    private Tienda tienda = new Tienda();
    /**
     * @description
     */
    public void ejecutarMenu() {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            mostrarMenu();
            System.out.println("Seleccione una opción: ");
            opcion = scanner.nextInt();
            ejecutarOpcion(opcion, scanner);
        } while (opcion != 8);

        scanner.close();
    }
    /**
     * @description
     */
    public void mostrarMenu() {
        System.out.println("Menu");
        System.out.println("1. Realizar Venta");
        System.out.println("2. Mostrar Inventario");
        System.out.println("3. Mostrar Historial de Ventas");
        System.out.println("4. Mostrar Clientes");
        System.out.println("5. Registrar Promoción");
        System.out.println("6. Registrar Producto");
        System.out.println("7. Registrar Cliente");
        System.out.println("8. Salir");
    }
    /**
     * @description
     * @param opcion
     * @param scanner
     */
    public void ejecutarOpcion(int opcion, Scanner scanner) {
        switch (opcion) {
            case 1:
                 realizarVenta(scanner);
                break;
            case 2:
                tienda.mostrarInventario();
                break;
            case 3:
                tienda.mostrarHistorialVentas();
                break;
            case 4:
                tienda.mostrarClientes();
                break;
            case 5:
                crearPromocion(scanner);
                break;
            case 6:
                crearProducto(scanner);
                break;
            case 7:
                crearCliente(scanner);
                break;
        
            default:
                break;
        }
    }
    /**
     * @description
     * @param scanner
     */
    public void crearProducto(Scanner scanner) {
        System.out.println("Ingrese el Nombre: ");
        String nombre = scanner.next();

        System.out.println("Ingrese el Precio: ");
        double precio = scanner.nextDouble();

        System.out.println("Ingrese el stock: ");
        int stock = scanner.nextInt();

        Producto producto = new Producto(nombre, precio, stock);

        tienda.registrarProducto(producto);
        System.out.println("Producto Creado!!!");
    }
    /**
     * @description
     * @param scanner
     */
    public void crearCliente(Scanner scanner) {
        System.out.println("Ingrese el Nombre: ");
        String nombre = scanner.next();

        System.out.println("Ingrese el Telefono: ");
        String telefono = scanner.next();

        System.out.println("Ingrese la Dirección: ");
        String direccion = scanner.next();
        
        Cliente cliente = new Cliente(nombre, telefono, direccion);

        tienda.registrarCliente(cliente);
        System.out.println("Cliente Registrado!!!");
    }
    /**
     * @description
     * @param scanner
     */
    public void crearPromocion(Scanner scanner) {
        System.out.println("Ingrese el Monto de Compra Minima: ");
        double montoCompraMinima = scanner.nextDouble();

        System.out.println("Ingrese el Porcentaje de Descuento: ");
        double porcentajeDescuento = scanner.nextDouble();

        Promocion promocion = new Promocion(montoCompraMinima, porcentajeDescuento);

        tienda.registrarPromocion(promocion);
        System.out.println("Promoción Registrada!!!");
    }
    /**
     * @description
     * @param scanner
     */
    public void realizarVenta(Scanner scanner) {
        tienda.mostrarInventario();
        tienda.mostrarClientes();
        // tienda.realizarVenta(null, null, null); 
    }
}
