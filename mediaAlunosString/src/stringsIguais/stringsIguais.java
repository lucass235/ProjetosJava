package stringsIguais;

import java.util.Scanner;

public class stringsIguais {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String frase1, frase2;
        int tam1, tam2;
        char valor1, valor2;
        boolean resul;
        System.out.println("Digite a primeira frase: ");
        frase1 = in.nextLine();
        System.out.println("Digite a segunda frase: ");
        frase2 = in.nextLine();
        resul = verir(frase1, frase2);
        if ( resul == false) {
            System.err.println("As Frases são diferentes!");
        } else {
            System.out.println("As frases são iguais!");
        }
    }

    public static boolean verir(String f1, String f2) { // hoje é quarta // hoje o quarta
        int tam1, tam2;
        char valor1, valor2;
        tam1 = f1.length();
        tam2 = f2.length();
        if (tam1 != tam2) {
            return false;
        } else {
            for (int i = 0; i < tam1; i++) {
                valor1 = f1.charAt(i);
                valor2 = f2.charAt(i);
                if (Character.toUpperCase(valor1) != Character.toUpperCase(valor2)) {
                    return false;
                }
            }
        }
        return true;
    }
}
