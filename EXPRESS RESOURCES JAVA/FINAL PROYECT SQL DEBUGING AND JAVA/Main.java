
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;
        if (Conexion.obtenerConexion() != null) {
            System.out.println("Conexión exitosa a la base de datos.");
        } else {
            System.out.println("Falló la conexión.");
        }

        do { 
            System.out.println("----MENU-----");
            System.out.println("1. Insertar");
            System.out.println("2. Listar todo");
            System.out.println("3.Buscar por nombre");
            System.out.println("4. Actualizar");
            System.out.println("5. Borrar");
            System.out.println("0. Salir");
            System.out.println("Elige una opcion");

            opcion = scanner.nextInt();
            scanner.nextLine();
             switch (opcion) {
                case 1:
                    System.out.print("Nombre: ");
                    String nombreInsertar = scanner.nextLine();
                    System.out.print("Precio: ");
                    double precio = scanner.nextDouble();
                    System.out.print("Stock: ");
                    int stock = scanner.nextInt();
                    scanner.nextLine(); // limpiar

                    Producto nuevo = new Producto(nombreInsertar, precio, stock);
                    ProductoDAO.insertar(nuevo);
                    break;

                case 2:
                    ArrayList<Producto> lista = ProductoDAO.listarTodos();
                    for (Producto p : lista) {
                        System.out.println(p);
                    }
                    break;

                case 3:
                     scanner.nextLine(); 
                        System.out.print("Ingresa el nombre a buscar: ");
                        String nombreBuscar = scanner.nextLine();

                        Producto p = ProductoDAO.buscarPorNombre(nombreBuscar);

                        if (p != null) {
                            System.out.println("Producto encontrado: " + p);
                        } else {
                            System.out.println("Producto no encontrado.");
                        }
                    break;

                case 4:
                    ProductoDAO.actualizarProducto(scanner);
                    break;

                case 5:
                    ProductoDAO.eliminarProducto(scanner);
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opción inválida");
            }

        } while (opcion != 0);

        scanner.close();
    }
}
