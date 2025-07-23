import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ProductoDAO {
    public static void insertar(Producto producto) {
        Connection conn = Conexion.obtenerConexion();
        String sql = "INSERT INTO productos(nombre, precio,stock) VALUES (?, ?, ?)";

        try (PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setString(1, producto.getNombre());
            stmt.setDouble(2, producto.getPrecio());
            stmt.setInt(3, producto.getStock());

            stmt.executeUpdate();
            System.out.println("Productos Insertados corrrectamente");
        }catch (SQLException e) {
            System.err.println("Error al insertar productos");
            e.printStackTrace();
        }
    }

    public static ArrayList<Producto> listarTodos() {
        ArrayList<Producto> lista = new ArrayList<>();
        Connection conn = Conexion.obtenerConexion();
        String sql = "SELECT * FROM productos";

        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Producto p = new Producto(
                    rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getDouble("precio"),
                    rs.getInt("stock")
                );
                lista.add(p);
            }
        } catch (SQLException e) {
            System.err.println("Error al listar productos:");
            e.printStackTrace();
        }
        return lista;
    }

    public static Producto buscarPorNombre (String nombre){
            Producto producto = null;
            String sql = "SELECT * FROM productos WHERE nombre = ?";

            try (Connection conn = Conexion.obtenerConexion();
            PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, nombre);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                producto = new Producto(
                    rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getDouble("precio"),
                    rs.getInt("stock")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return producto;
    }

    public static Producto buscarPorId(int id) {
    Producto producto = null;
    String sql = "SELECT * FROM productos WHERE id = ?";

    try (Connection conn = Conexion.obtenerConexion();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
        
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            producto = new Producto(
                rs.getInt("id"),
                rs.getString("nombre"),
                rs.getDouble("precio"),
                rs.getInt("stock")
            );
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return producto;
}


    public static void actualizarProducto(Scanner scanner) {
        System.out.print("ID del producto a actualizar: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // limpia buffer

        Producto actual = ProductoDAO.buscarPorId(id); // lo crearás ahorita
        if (actual == null) {
            System.out.println("No se encontró un producto con ese ID.");
            return;
        }

        System.out.println("Producto actual: " + actual);

        System.out.print("Nuevo nombre (" + actual.getNombre() + "): ");
        String nombre = scanner.nextLine();
        System.out.print("Nuevo precio (" + actual.getPrecio() + "): ");
        double precio = scanner.nextDouble();
        System.out.print("Nuevo stock (" + actual.getStock() + "): ");
        int stock = scanner.nextInt();
        scanner.nextLine();

        actual.setNombre(nombre);
        actual.setPrecio(precio);
        actual.setStock(stock);

        if (ProductoDAO.actualizar(actual)) {
            System.out.println("Producto actualizado.");
        } else {
            System.out.println("Error al actualizar producto.");
        }
    }


    public static boolean actualizar(Producto producto) {
    String sql = "UPDATE productos SET nombre = ?, precio = ?, stock = ? WHERE id = ?";

        try (Connection conn = Conexion.obtenerConexion();
            PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, producto.getNombre());
            stmt.setDouble(2, producto.getPrecio());
            stmt.setInt(3, producto.getStock());
            stmt.setInt(4, producto.getId());

            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

        public static void eliminarProducto(Scanner scanner) {
    System.out.print("ID del producto a eliminar: ");
    int id = scanner.nextInt();
    scanner.nextLine(); 

    Producto actual = ProductoDAO.buscarPorId(id);

    if (actual == null) {
        System.out.println("Producto no encontrado.");
        return;
    }

    System.out.println("Producto encontrado: " + actual);
    System.out.print("¿Estás seguro que deseas eliminarlo? (s/n): ");
    String confirmacion = scanner.nextLine();

    if (confirmacion.equalsIgnoreCase("s")) {
        boolean eliminado = ProductoDAO.eliminar(id);
        if (eliminado) {
            System.out.println("Producto eliminado.");
        } else {
            System.out.println("Ocurrió un error al eliminar.");
        }
    } else {
        System.out.println("Operación cancelada.");
    }
}


        public static boolean eliminar(int id) {
        String sql = "DELETE FROM productos WHERE id = ?";

        try (Connection conn = Conexion.obtenerConexion();
            PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
