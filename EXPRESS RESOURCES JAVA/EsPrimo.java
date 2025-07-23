import java.util.Scanner;

public class EsPrimo {
    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);

         System.out.println("Dame un numero y te dire si es primo o no: ");
         int numero = scanner.nextInt();

        boolean primo = es_primo(numero);

        if (primo == true){
            System.out.println("Es primo");
        }else {
            System.out.println("No es primo");
        }
    }

    public static boolean es_primo (int numero){
        boolean primo = true;
         double raiz = Math.sqrt(numero);
        
        for (int i=2; i <=raiz; i++){
             if (numero % i == 0){
            primo = false;
                break;
            }
        }
        return primo;
    }
}
