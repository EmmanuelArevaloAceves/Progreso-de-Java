import java.util.Scanner;

public class DetalleDeFactura {
     public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);
 
        System.out.println("Ingresa el nombre de la factura");
        String nombre = scanner.next();
        System.out.println("Ingrese los precios de sus dos productos");
        double productoA = scanner.nextDouble();
        double productoB = scanner.nextDouble();
        double montoBruto = productoA + productoB;
        double impuesto = (productoA + productoB)*.19;
        double total = productoA + productoB + impuesto;
        System.out.println("Nombre de la factura: " + nombre);
        System.out.println("total sin impuestos = " + montoBruto);
        System.out.println("Impuesto agregado = " + impuesto);
        System.out.println("total = " + total);
 
 
    }
}
