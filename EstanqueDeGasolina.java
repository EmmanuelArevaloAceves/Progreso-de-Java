import java.util.Scanner;

public class EstanqueDeGasolina {
     public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        double lleno = 70;
        double mediolleno = 60;
        double estanqueTresCuartos = 40;
        double medio = 35;
        double suficiente = 20;
        double insuficiente = 1;
        System.out.println("Cual es la capacidad actual del tanque de gasolina");
        double tanqueActual = lector.nextDouble();
 
        if (tanqueActual >= lleno) {
            System.out.println("El tanque de gasolina esta lleno");
        }
        else if (tanqueActual >= mediolleno) {
            System.out.println("Tanque de gasolina medio lleno");
        }
        else if (tanqueActual >= estanqueTresCuartos) {
            System.out.println("tanque de gasolina 3/4");
        }
        else if (tanqueActual >= medio) {
            System.out.println("tanque de gasolina a la mitad");
        }
        else if (tanqueActual >= suficiente) {
            System.out.println("tanque de gasolina suficiente");
        }
        else if (tanqueActual >= insuficiente) {
            System.out.println("tanque de gasolina bajo");
        }
    }
}
