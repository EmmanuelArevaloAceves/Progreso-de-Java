import java.util.Scanner;
import javax.swing.JOptionPane;

public class NombreMasLargoDeTres {
      public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
 
        String nombre = JOptionPane.showInputDialog(null,"Ingresa el nombre y despues el apellido del primer miembro");
        String nombre2 = JOptionPane.showInputDialog(null,"Ingresa el nombre y despues el apellido del segundo miembro");
        String nombre3 = JOptionPane.showInputDialog(null,"Ingresa el nombre y despues el apellido del tercer miembro");
 
        String max = (nombre.split(" ")[0].length() < nombre2.split(" ")[0].length()) ? nombre2 : nombre;
        max = (nombre3.split(" ")[0].length() < max.split(" ")[0].length()) ? max: nombre3;
       JOptionPane.showMessageDialog(null,"La persona con el nombre mas largo es: " + max);
    }
}
