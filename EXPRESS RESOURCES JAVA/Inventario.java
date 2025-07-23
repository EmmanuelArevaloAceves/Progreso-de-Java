
import java.util.ArrayList;
import  java.util.HashMap;
import java.util.Scanner;
   
    public class Inventario{
        public static void main(String[] args) {
            ArrayList<Producto>productos = new ArrayList<>();

            productos.add(new Producto("Camisa",199.99,10,"Ropa"));
            productos.add(new Producto("Bufanda", 25.50, 30,"Accesorio"));
            productos.add(new Producto("Gorra", 15.50, 25,"Accesorio"));

            for (Producto p: productos){
            System.out.println(p);
            }


             Scanner scanner = new Scanner(System.in);
                System.out.println("Buscar producto por nombre: ");
                String nombreBuscado = scanner.nextLine();

                boolean encontrado = false;
                    for (Producto p : productos){
                        if (p.getNombre().equalsIgnoreCase(nombreBuscado)){
                            System.out.println("Procuto encontrado: " + p);
                            encontrado = true;
                            break;
                        } else {
                            System.out.println("Producto no encontrado :(");
                        }

                    }

            HashMap <String, Integer> conteoCategorias = new HashMap<>();
            
            for (Producto p : productos){
                String cat = p.getCategoria();
                conteoCategorias.put(cat, conteoCategorias.getOrDefault(cat, 0) + 1);
            }

            System.err.println("\nConteo de productos por categoria");
            for (String cat : conteoCategorias.keySet()){
                System.out.println(cat + ": " + conteoCategorias.get(cat));
            }
        }

    }

    class Producto {
        private String nombre;
        private double precio;
        private int stock;
        private String categoria;

        

        public Producto(String nombre,double precio, int stock, String categoria) {
            this.nombre = nombre;
            this.precio = precio;
            this.stock = stock;
            this.categoria = categoria;
        }

        public String getNombre(){
            return nombre;
        }

        public String getCategoria() {
            return categoria;
        }

        public String toString(){
            return nombre + " | $" + precio + " | Stock: " + stock;
        }
    }