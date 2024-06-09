package com.tienda;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private Tienda tienda = new Tienda();
    /**
     * @description 
     */
    public void ejecutarMenu() {
        Scanner scanner = new Scanner(System.in);
        Boolean continuar = true;

        while (continuar) {
            mostrarMenu();
            System.out.println("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            if (opcion == 8) { break; }
            scanner.nextLine();

            ejecutarOpcion(opcion, scanner);
            continuar = mostrarContinuar(scanner);
        }

        limpiarConsola();
        System.out.println("Gracias por usar el sistema de gestión de la tienda.");
        scanner.close();
    }
    /**
     * @description Menu de la aplicación
     */
    private void mostrarMenu() {
        limpiarConsola();
        System.out.println("********* Menu ***********");
        System.out.println();
        System.out.println("1. Realizar Venta");
        System.out.println("2. Mostrar Inventario");
        System.out.println("3. Mostrar Historial de Ventas");
        System.out.println("4. Mostrar Clientes");
        System.out.println("5. Registrar Promoción");
        System.out.println("6. Registrar Producto");
        System.out.println("7. Registrar Cliente");
        System.out.println("8. Salir");
        System.out.println();
    }
    /**
     * @description Muestra la opción seleccionada como encabezado
     * @param opcion
     * @param descripcion
     */
    private void mostrarEncabezado(int opcion, String descripcion) {
        limpiarConsola();
        System.out.println("Opción " + opcion + ": " + descripcion);
        System.out.println();
    }
    /**
     * @description Muestra un mesnsaje para continuar ejecutando la aplicación
     * @param scanner
     * @return
     */
    private Boolean mostrarContinuar(Scanner scanner) {
        while (true) {
            System.out.println();
            System.out.println("¿Desea Continuar? (S/N): ");
            String respuesta = scanner.nextLine().trim().toUpperCase();
            
            if (respuesta.equals("S")) {
                return true;
            } else if (respuesta.equals("N")) {
                return false;
            } else {
                System.out.println("Entrada no válida. Por favor, ingrese 'S' para sí o 'N' para no.");
            }
        }
    }
    /**
     * @description Limpia la consola
     */
    private static void limpiarConsola() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    /**
     * @description
     * @param opcion
     * @param scanner
     */
    private void ejecutarOpcion(int opcion, Scanner scanner) {
        switch (opcion) {
            case 1:
                mostrarEncabezado(1, "Realizar Venta");
                realizarVenta(scanner);
                break;
            case 2:
                mostrarEncabezado(2, "Mostrar Inventario");
                tienda.mostrarInventario();
                break;
            case 3:
                mostrarEncabezado(3, "Mostrar Historial de Ventas");
                tienda.mostrarHistorialVentas();
                break;
            case 4:
                mostrarEncabezado(4, "Mostrar Clientes");
                tienda.mostrarClientes();
                break;
            case 5:
                mostrarEncabezado(5, "Registrar Promoción");
                crearPromocion(scanner);
                break;
            case 6:
                mostrarEncabezado(6, "Registrar Producto");
                crearProducto(scanner);
                break;
            case 7:
                mostrarEncabezado(7, "Registrar Cliente");
                crearCliente(scanner);
                break;
            case 8:
                
                break;
            default:
                System.out.println("Opción no válida.");
                break;
        }
    }
    /**
     * @description
     * @param scanner
     */
    private void crearProducto(Scanner scanner) {
        System.out.println("Ingrese el Nombre: ");
        String nombre = scanner.nextLine();

        System.out.println("Ingrese el Precio: ");
        double precio = scanner.nextDouble();

        System.out.println("Ingrese el stock: ");
        int stock = scanner.nextInt();
        scanner.nextLine();

        Producto producto = new Producto(nombre, precio, stock);

        tienda.registrarProducto(producto);

        limpiarConsola();
        System.out.println("Producto Creado!");
        System.out.println();
        System.out.println(producto.toString());
    }
    /**
     * @description
     * @param scanner
     */
    private void crearCliente(Scanner scanner) {
        System.out.println("Ingrese el Nombre: ");
        String nombre = scanner.nextLine();

        System.out.println("Ingrese el Telefono: ");
        String telefono = scanner.nextLine();

        System.out.println("Ingrese la Dirección: ");
        String direccion = scanner.nextLine();
        
        Cliente cliente = new Cliente(nombre, telefono, direccion);

        tienda.registrarCliente(cliente);
        limpiarConsola();
        System.out.println("Cliente Registrado!");
        System.out.println();
        System.out.println(cliente.toString());
    }
    /**
     * @description
     * @param scanner
     */
    private void crearPromocion(Scanner scanner) {
        System.out.println("Ingrese el Monto de Compra Minima: ");
        double montoCompraMinima = scanner.nextDouble();

        System.out.println("Ingrese el Porcentaje de Descuento: ");
        double porcentajeDescuento = scanner.nextDouble();

        Promocion promocion = new Promocion(montoCompraMinima, porcentajeDescuento);

        tienda.registrarPromocion(promocion);
        limpiarConsola();
        System.out.println("Promoción Registrada!");
        System.out.println();
        System.out.println(promocion.toString());
    }
    /**
     * @description
     * @param scanner
     */
    private void realizarVenta(Scanner scanner) {
        List<Producto> productosVendidos = new ArrayList<>();
        List<Integer> cantidadesVendidas = new ArrayList<>();

        System.out.println("Seleccione un cliente:");
        tienda.mostrarClientes();
        System.out.println();
        System.out.println("Ingrese el número del cliente: ");
        int clienteIndex = scanner.nextInt() - 1;
        scanner.nextLine();
        Cliente cliente = tienda.getClientes().get(clienteIndex);

        boolean agregarOtroProducto = true;
        while (agregarOtroProducto) {
            limpiarConsola();
            mostrarEncabezado(1, "Realizar Venta");
            System.out.println("Seleccione un producto:");
            tienda.mostrarInventario();
            System.out.println();
            System.out.print("Ingrese el número del producto: ");
            int productoIndex = scanner.nextInt() - 1;
            scanner.nextLine();
            Producto producto = tienda.getInventario().get(productoIndex);
            System.out.print("Ingrese la cantidad del producto: ");
            int cantidad = scanner.nextInt();
            scanner.nextLine();

            productosVendidos.add(producto);
            cantidadesVendidas.add(cantidad);

            System.out.println();
            System.out.print("¿Desea agregar otro producto? (S/N): ");
            String respuesta = scanner.nextLine().trim().toUpperCase();
            if (!respuesta.equals("S")) {
                agregarOtroProducto = false;
            }

            Promocion promocion = null;
            if (tienda.getPromociones().size() > 0) {
                limpiarConsola();
                mostrarEncabezado(1, "Realizar Venta");
                System.out.println("Seleccione una promoción (opcional):");
                tienda.mostrarPromociones();
                System.out.print("Ingrese el número de la promoción (o 0 para omitir): ");
                int promocionIndex = scanner.nextInt() - 1;
                scanner.nextLine();
                if (promocionIndex >= 0) {
                    promocion = tienda.getPromociones().get(promocionIndex);
                }
            }

            tienda.realizarVenta(productosVendidos, cantidadesVendidas, cliente, promocion);
        }
    }    
}
