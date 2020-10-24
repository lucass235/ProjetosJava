package buscarcaracstring;

import java.util.Scanner;

public class BuscarCaracString {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String frase;
        char caracter;
        int qtdVogais;
        System.out.println("Digite uma frase: ");
        frase = in.nextLine();
        System.out.print("Digite uma caracter existente na sua frase: ");
        caracter = in.next().charAt(0);
        qtdVogais = qtdCaracter(frase, caracter);
        while (qtdVogais == 0) {
            System.err.println("Caracter não encontrado!");
            System.out.print("Digite uma caracter existente na sua frase: ");
            caracter = in.next().charAt(0);
            qtdVogais = qtdCaracter(frase, caracter);
        }
        System.out.printf("A quantidade do caracter '%s' na frase: '%s' é (%d) %n", caracter, frase, qtdVogais);
    }

    public static int qtdCaracter(String frase, char carac) {
        int qtd = 0, tam;
        tam = frase.length();
        for (int i = 0; i < tam; i++) {
            if (Character.toLowerCase(frase.charAt(i)) == Character.toLowerCase(carac)) {
                qtd++;
            }
        }
        return qtd;
    }
}
