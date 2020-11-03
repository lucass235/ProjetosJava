package stringvalida;

import java.util.Scanner;

public class StringValida {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String frase;
        boolean valido;
        int qtdP;
        System.out.println("Digite uma frase: ");
        frase = in.nextLine();
        valido = validarString(frase);
        while (valido == false) {
            System.out.println("Frase inválida, Digite novamente: ");
            frase = in.nextLine();
            valido = validarString(frase);
        }
        qtdP = qtdPalavras(frase);
        System.out.printf("A quantidades de palavras na frase:%n%s é: %d%n", frase, qtdP);
    }

    public static boolean validarString(String frase) {
        int tam;
        char valor;
        tam = frase.length();
        for (int i = 0; i < tam; i++) {
            valor = frase.charAt(i);
            if (Character.isDigit(valor) == true) {
                return false;
            } else if (valor != '.' && valor != ',' && valor != ';' && valor != ':'
                    && valor != '?' && valor != '!') {
                if (Character.isLetter(valor) == false && Character.isSpaceChar(valor) == false) {
                    return false;
                }
            }
        }
        return true;
    }

    public static int qtdPalavras(String frase) {
        int tam, qtdP = 1;
        char valor;
        tam = frase.length();
        for (int i = 0; i < tam; i++) {
            valor = frase.charAt(i);
            if (Character.isSpaceChar(valor)) {
                qtdP++;
            } else if (valor == '.' || valor == ':' || valor == ';' || 
                    valor == '?' || valor == '!' || valor == ',' ) {
                qtdP++;
            }
        }
        
        return qtdP;
    }
}
