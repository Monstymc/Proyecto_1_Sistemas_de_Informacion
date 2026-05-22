package Proyecto;


import java.util.ArrayList;

public class Carrito {

 private ArrayList<Producto> carrito;

 public Carrito() {
     carrito = new ArrayList<>();
 }

 public void agregarProducto(Producto producto) {
     carrito.add(producto);
     System.out.println("\nProducto agregado al carrito.");
 }

 public void mostrarCarrito() {

     if (carrito.isEmpty()) {
         System.out.println("Carrito vacio.");
         return;
     }

     double total = 0;

     System.out.println(" TU CARRITO DE VIRVUTO\n");

     for (int i = 0; i < carrito.size(); i++) {
         System.out.println((i + 1) + ". " + carrito.get(i));
         total += carrito.get(i).getPrecio();
     }

     System.out.println("\nTotal: $" + String.format("%.2f", total));
 }

 public void eliminarProducto(int posicion) {
     carrito.remove(posicion);
     System.out.println("\nProducto eliminado.");
 }

 public int cantidadProductos() {
     return carrito.size();
 }

 public void vaciarCarrito() {
     carrito.clear();
 }
}