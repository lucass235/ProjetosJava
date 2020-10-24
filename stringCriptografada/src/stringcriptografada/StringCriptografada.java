package stringcriptografada;

import java.util.Scanner;

public class StringCriptografada {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String frase;
        int tam;
        char valor;
        System.out.println("Digite uma Frase: ");
        frase = in.nextLine();
        tam = frase.length();
        for (int i = 0; i < tam; i++) {
            valor = frase.charAt(i);
            switch (Character.toLowerCase(valor)) {
                case 'a':
                    frase = frase.replace(valor, '@');
                    // replace, converte um char x por um char y.
                    break;
                case 'e':
                    frase = frase.replace(valor, '$');
                    break;
                case 'i':
                    frase = frase.replace(valor, '&');
                    break;
                case 'o':
                    frase = frase.replace(valor, '*');
                    break;
                case 'u':
                    frase = frase.replace(valor, '#');
                    break;
            }
        }
        System.out.println("Frase criptografada");
        System.out.println(frase);
    }

}
