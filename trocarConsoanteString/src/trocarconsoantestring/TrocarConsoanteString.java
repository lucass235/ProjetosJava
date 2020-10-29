package trocarconsoantestring;

import java.util.Scanner;

public class TrocarConsoanteString {

    public static void main(String[] args) {
        String frase;
        int tam;
        char valor;
        Scanner in = new Scanner(System.in);
        System.out.println("Digite uma frase: ");
        frase = in.nextLine();
        tam = frase.length();
        
        for (int i = 0; i < tam; i++) { // lucas
            valor = Character.toLowerCase(frase.charAt(i));
            if (valor == 'a' || valor == 'e' || valor == 'i' || valor == 'o' || valor == 'u'
                    || Character.isSpaceChar(valor) || Character.isDigit(valor)) {
                
            } else {
                frase = frase.replace(valor, '#');
            }
        }
        System.out.println("Frase criptografada:");
        System.out.println(frase);
    }
}
