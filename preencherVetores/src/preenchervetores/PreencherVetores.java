package preenchervetores;

import java.util.Scanner;

public class PreencherVetores {

    public static void main(String[] args) {
        int[] num = new int[20]; // criação do vetor dos numeros
        pVetores(num); // chamada do procedimento que preencher o vetor
        maiorV(num); // chamada da função que calcula o maior elemento do vetor
        menorIndice(num); // chamada do função que calcula o indice de menor valor
        System.out.println("O maior valor entre os 20 digitados é: " + maiorV(num));
        System.out.println("O Índice de menor valor dentre os 20 digitados é: " + menorIndice(num));
    }

    public static void pVetores(int[] n) {
        Scanner in = new Scanner(System.in);
        System.out.println("Informe a seguir 20 números inteiros");
        for (int i = 0; i < n.length; i++) {
            System.out.print("Informe o " + (i + 1) + "º número: ");
            n[i] = in.nextInt(); // armazenagem do elemento do vetor
        }
    }

    public static int maiorV(int[] n) {
        int maior = n[0];
        for (int i = 0; i < n.length; i++) {
            if (n[i] >= maior) { // condição de maior elemento
                maior = n[i];
            }
        }
        return maior;
    }

    public static int menorIndice(int[] n) {
        int menor = n[0]; // armazenagem do menor elemento do vetor
        int indice = 0; // armazenagem do indice de menor elemento

        for (int i = 0; i < n.length; i++) {
            if (n[i] <= menor) { // condição de menor elemento
                menor = n[i];
                indice = i;
            }
        }
        return indice; // retorno do indice de menor elemento
    }
}
