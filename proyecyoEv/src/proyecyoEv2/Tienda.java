package proyecyoEv2;

import java.util.Scanner;
import java.io.FileWriter;

public class Tienda {

 public static void main(String[] args) {

     Scanner sc = new Scanner(System.in);

     Inventario inventario = new Inventario();
     Carrito carrito = new Carrito();

     int menuPrincipal;
     int idVenta = 1;

     do {

         System.out.println("SISTEMA DE TIENDA VIRVUTO\n");
         System.out.println("1. Cliente");
         System.out.println("2. Administrador");
         System.out.println("3. Salir");
         System.out.print("\nSeleccione una opcion: ");

         menuPrincipal = sc.nextInt();

         if (menuPrincipal == 1) {

             int opcionCliente;

             do {

                 System.out.println("\n MENU CLIENTE DE VIRVUTO");
                 System.out.println("1. Ver inventario");
                 System.out.println("2. Ver carrito");
                 System.out.println("3. Finalizar compra");
                 System.out.print("\nSeleccione una opcion: ");

                 opcionCliente = sc.nextInt();

                 switch (opcionCliente) {

                     case 1:

                         inventario.mostrarInventario();

                         System.out.print("\nSeleccione producto: ");
                         int producto = sc.nextInt();

                         if (producto >= 1 &&
                                 producto <= inventario.cantidadProductos()) {

                             carrito.agregarProducto(
                                     inventario.obtenerProducto(producto - 1)
                             );
                         }

                         break;

                     case 2:

                         carrito.mostrarCarrito();

                         if (carrito.cantidadProductos() > 0) {

                             System.out.print(
                                     "\nIngrese producto a eliminar (o 0 para volver): "
                             );

                             int eliminar = sc.nextInt();

                             if (eliminar != 0 &&
                                     eliminar <= carrito.cantidadProductos()) {

                                 carrito.eliminarProducto(eliminar - 1);
                             }
                         }

                         break;

                     case 3:

                         System.out.println(
                                 "\nCompra realizada con exito."
                         );

                         for (int i = 0;
                              i < carrito.cantidadProductos();
                              i++) {

                             Producto p =
                                     carrito.obtenerProducto(i);

                             guardarVenta(
                                     idVenta,
                                     1,
                                     p,
                                     1
                             );

                             idVenta++;
                         }

                         carrito.vaciarCarrito();

                         break;

                     default:
                         System.out.println("\nOpcion invalida.");
                 }

             } while (opcionCliente != 3);
         }

         else if (menuPrincipal == 2) {

             System.out.print("\nIngrese contraseña de administrador: ");
             String contrasena = sc.next();

             if (contrasena.equals("amamosIntro")) {

                 int opcionAdmin;

                 do {

                     System.out.println("MENU ADMIN DE VIRVUTO\n");
                     System.out.println("1. Ver inventario");
                     System.out.println("2. Agregar producto");
                     System.out.println("3. Eliminar producto");
                     System.out.println("4. Salir");

                     System.out.print("\nSeleccione una opcion: ");

                     opcionAdmin = sc.nextInt();

                     switch (opcionAdmin) {

                         case 1:

                             inventario.mostrarInventario();

                             break;

                         case 2:

                             System.out.println(
                                     "Los productos ahora se gestionan desde productos.csv"
                             );

                             break;

                         case 3:

                             System.out.println(
                                     "Los productos ahora se gestionan desde productos.csv"
                             );

                             break;

                         case 4:
                             break;

                         default:
                             System.out.println("\nOpcion invalida.");
                     }

                 } while (opcionAdmin != 4);

             } else {

                 System.out.println("\nContraseña incorrecta.");
             }
         }

     } while (menuPrincipal != 3);

     sc.close();
 }

 public static void guardarVenta(
         int idVenta,
         int idUsuario,
         Producto producto,
         int cantidad
 ) {

     try {

         FileWriter fw =
                 new FileWriter(
                         "ventas.csv",
                         true
                 );

         double total =
                 producto.getPrecio() * cantidad;

         String fecha =
                 "2026-05-22";

         fw.write(

                 idVenta + "," +
                 idUsuario + "," +
                 producto.getId() + "," +
                 cantidad + "," +
                 total + "," +
                 fecha + "\n"
         );

         fw.close();

     } catch (Exception e) {

         System.out.println(
                 "Error guardando venta"
         );
     }
 }
}
