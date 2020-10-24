package qtdvogaisstring;

import java.util.Scanner;

public class QtdVogaisString {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String frase;
        int qtdVogais;
        System.out.println("Digite uma frase: ");
        frase = in.nextLine();
        qtdVogais = calcularVogais(frase);
        System.out.printf("A quantidade de vogais na frase: %s é %d %n", frase, qtdVogais);
    }

    public static int calcularVogais(String frase) {
        int qtd = 0, tam;
        tam = frase.length();
        for (int i = 0; i < tam; i++) {
            switch (Character.toLowerCase(frase.charAt(i))) {
                case 'a':
                    qtd++;
                    break;
                case 'e':
                    qtd++;
                    break;
                case 'i':
                    qtd++;
                    break;
                case 'o':
                    qtd++;
                    break;
                case 'u':
                    qtd++;
                    break;
            }
        }
        return qtd;
    }
}
