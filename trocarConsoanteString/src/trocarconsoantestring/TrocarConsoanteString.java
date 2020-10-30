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
            valor = frase.charAt(i);
            valor = Character.toLowerCase(valor);
            if (valor == 'a' || valor == 'e' || valor == 'i' || valor == 'o' || valor == 'u'
                    || Character.isSpaceChar(valor) || Character.isDigit(valor)) {
                // faz nada.
            } else if (Character.isLetter(valor)) {
                frase = frase.replace(frase.charAt(i), '#');
            } else {
                // faz nada.
            }
        }
        System.out.println("Frase criptografada:");
        frase = inverteString(frase);
        System.out.println(frase);
    }

    public static String inverteString(String frase) { // lucas
        int tam;
        char aux;
        tam = frase.length();
        char[] vet = new char[tam];
        for (int i = 0; i < tam; i++) {
            vet[i] = frase.charAt(i);
        }
        for (int i = 0; i < tam / 2; i++) {
            aux = vet[i];
            vet[i] = vet[(tam - 1) - i];
            vet[(tam - 1) - i] = aux;
        }
        String fraseN = new String(vet);
        return fraseN;
    }
}
