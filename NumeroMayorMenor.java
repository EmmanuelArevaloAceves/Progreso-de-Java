import java.util.Scanner;

public class NumeroMayorMenor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("(Escribe 2 numeros)");
         int numeroA = scanner.nextInt();
         int numeroB = scanner.nextInt();

          if (numeroA < numeroB) {
            System.out.println("El orden es: " + numeroB +" "+ numeroA);
        } else if (numeroB < numeroA) {
            System.out.println("El orden es: " + numeroA +" "+ numeroB);
        } else {
            System.out.println("Ambos números son iguales.");
        }
        scanner.close();
    }
}
