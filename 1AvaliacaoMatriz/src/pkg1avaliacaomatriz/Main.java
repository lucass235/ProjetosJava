package pkg1avaliacaomatriz;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int i, j;
        System.out.println("Informe a quantidade de linhas: ");
        i = in.nextInt();
        while (i <= 0) {
            System.out.println("Quantidade de linhas inválida, digite um valor maior que 0");
            i = in.nextInt();
        }
        System.out.println("Informe a quantidade de colunas: ");
        j = in.nextInt();
        while (j <= 0) {
            System.out.println("Quantidade de colunas inválida, digite um valor maior que 0");
            j = in.nextInt();
        }
        int[][] mat = new int[i][j];
        int[] somaLi = new int[i];
        int[] somaCo = new int[j];
        preencherMatriz(mat);
        somaLinhas(mat, somaLi);
        somaColunas(mat, somaCo);
        System.out.println("Soma das linhas: ");
        exibir(somaLi);
        System.out.println("Soma das Colunas: ");
        exibir(somaCo);

    }

    public static boolean buscarValor(int[][] mat, int valor) {
        boolean achou = false;
        for (int j = 0; j < mat[0].length; j++) {
            for (int i = 0; i < mat.length; i++) {
                if (mat[i][j] == valor) {
                    achou = true;
                }
            }
        }
        return achou;
    }

    public static void preencherMatriz(int[][] mat) {
        Scanner in = new Scanner(System.in);
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                System.out.printf("Informe o valor de A(%d,%d): ", (i + 1), (j + 1));
                mat[i][j] = in.nextInt();
            }
        }
    }

    public static void somaLinhas(int[][] mat, int[] soLi) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                soLi[i] += mat[i][j];
            }
        }
    }

    public static void somaColunas(int[][] mat, int[] soCo) {
        for (int j = 0; j < mat[0].length; j++) {
            for (int i = 0; i < mat.length; i++) {
                soCo[j] += mat[i][j];
            }
        }
    }

    public static void exibir(int[] vet) {
        for (int i = 0; i < vet.length; i++) {
            System.out.println((i + 1) + "º - " + vet[i]);
        }
    }
}
