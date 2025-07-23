import java.util.InputMismatchException;
import java.util.Scanner;

public class PromedioDebug {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
    try{
        System.out.println("Ingresa 3 calificaciones:");
        double cal1 = scanner.nextDouble();
        double cal2 = scanner.nextDouble();
        double cal3 = scanner.nextDouble();

        double resultado = calcularPromedio(cal1, cal2, cal3);

        System.out.println("El promedio es: " + resultado);
     } catch (InputMismatchException e){
         System.err.println("Error: Solo se permiten numeros.");
        }
    }

    public static double calcularPromedio(double a, double b, double c) {
        double promedio = (a + b + c) / 3;
        System.out.println(promedio);
        return promedio;
    }
}
