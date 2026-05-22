package proyecyoEv2;

public class Producto {

    private int id;
    private String nombre;
    private double precio;
    private int stock;
    private String categoria;

    public Producto(
            int id,
            String nombre,
            double precio,
           
            String categoria
    ) {

        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
       
        this.categoria = categoria;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public int getStock() {
        return stock;
    }

    public String getCategoria() {
        return categoria;
    }

    @Override
    public String toString() {

        return id +
                " - " +
                nombre +
                " - $" +
                precio +
                 
                " - Categoria: " +
                categoria;
    }
}
