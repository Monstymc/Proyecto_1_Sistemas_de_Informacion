package proyecyoEv2;


import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Inventario {

    private ArrayList<Producto> productos;

    public Inventario() {

        productos = new ArrayList<>();

        cargarProductosCSV();
    }

    public void cargarProductosCSV() {

        try {

            BufferedReader br =
                    new BufferedReader(
                            new FileReader("C:\\Users\\P3E009-E\\Desktop\\ev\\MIS_VIRVUTO_COMPLETO\\productos_200.csv")
                    );

            String linea;

            br.readLine();

            while ((linea = br.readLine()) != null) {

                String[] datos = linea.split(",");

                int id =
                        Integer.parseInt(datos[0]);

                String nombre =
                        datos[1];

                double precio =
                        Double.parseDouble(datos[2]);

               

                String categoria =
                        datos[3];

                productos.add(

                        new Producto(
                                id,
                                nombre,
                                precio,
                                categoria
                        )
                );
            }

            br.close();

        } catch (Exception e) {

            System.out.println(e );
        }
    }

    public void mostrarInventario() {

        System.out.println(
                "===== INVENTARIO =====\n"
        );

        for (int i = 0; i < productos.size(); i++) {

            System.out.println(
                    (i + 1) +
                            ". " +
                            productos.get(i)
            );
        }
    }

    public Producto obtenerProducto(int indice) {

        return productos.get(indice);
    }

    public int cantidadProductos() {

        return productos.size();
    }
}
