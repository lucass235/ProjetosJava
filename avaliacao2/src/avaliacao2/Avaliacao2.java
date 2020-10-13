package avaliacao2;

import java.util.Scanner;

public class Avaliacao2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double[] num = {2.5, 5.1, 10.4, 1.4};
        int indice;
        System.out.println("Sem ordenação");
        for (int i = 0; i < num.length; i++) {
            System.out.print(num[i] + " ");
        }
        System.out.println();
        ordenarDecrescente(num);
        System.out.println();
        System.out.println("Ordenado!");
        for (int i = 0; i < num.length; i++) {
            System.out.print(num[i] + " ");
        }
        System.out.println();
        indice = buscaBinariaDecrecente(num, 2.5);
        System.out.println(indice);
    }

    public static int buscaBinariaDecrecente(double[] vet, double num) {
        int inicio = 0, fim = vet.length - 1, meio;
        do {
            meio = (inicio + fim) / 2;
            if (num == vet[meio]) {
                return meio; // achei meu valor
            } else if (num > vet[meio]) {
                fim = meio - 1;
            } else {
                inicio = meio + 1;
            }
        } while (inicio <= fim);
        return -1;
    }

    public static void ordenarDecrescente(double[] vet) {
        int para = vet.length - 1, indice = 0, i;
        double aux;
        boolean repetir;
        do {
            repetir = false;
            for (i = 0; i < para; i++) {
                if (vet[i] < vet[i + 1]) {
                    aux = vet[i];
                    vet[i] = vet[i + 1];
                    vet[i + 1] = aux;
                    indice = i;
                    repetir = true;
                }
            }
            para = indice;
        } while (repetir == true);

    }
}
