import java.util.Scanner;

public class Debuging {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);
        String nombreUsuario = scanner.nextLine();
        Debuging_example(nombreUsuario);
    }
    
    

    public static void Debuging_example(String nombreUsuario){
        if (nombreUsuario != null && !nombreUsuario.isEmpty()){
            System.out.println(nombreUsuario.length());   
        }else {
             System.err.println("Ingrese un valor valido!!!");
        }
    }
}
