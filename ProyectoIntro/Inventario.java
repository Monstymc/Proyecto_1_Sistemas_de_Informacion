package Proyecto;


import java.util.ArrayList;

public class Inventario {

 private ArrayList<Producto> productos;

 public Inventario() {
     productos = new ArrayList<>();

     productos.add(new Producto("Camiseta", 15.99));
     productos.add(new Producto("Pantalon", 25.50));
     productos.add(new Producto("Chaqueta", 40.00));
     productos.add(new Producto("Zapatos", 35.75));
     productos.add(new Producto("Gorra", 10.25));
 }

 public void mostrarInventario() {
     System.out.println("===== INVENTARIO =====\n");

     for (int i = 0; i < productos.size(); i++) {
         System.out.println((i + 1) + ". " + productos.get(i));
     }
 }

 public void agregarProducto(String nombre, double precio) {
     productos.add(new Producto(nombre, precio));
     System.out.println("\nProducto agregado correctamente.");
 }

 public void eliminarProducto(int posicion) {
     productos.remove(posicion);
     System.out.println("\nProducto eliminado del inventario.");
 }

 public Producto obtenerProducto(int indice) {
     return productos.get(indice);
 }

 public int cantidadProductos() {
     return productos.size();
 }
}