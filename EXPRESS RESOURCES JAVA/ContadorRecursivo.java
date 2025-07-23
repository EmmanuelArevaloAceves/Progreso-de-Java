public class ContadorRecursivo {
    public static void main(String[] args) {
        int inicio = 1;
        contarHastaDiez(inicio);
    }

    public static void contarHastaDiez(int numero) {
        if (numero <= 10){
        System.out.println("Número: " + numero);
        contarHastaDiez(numero + 1);
        }else {
            System.out.println("Fin del programa :)");
        }
    }
}
