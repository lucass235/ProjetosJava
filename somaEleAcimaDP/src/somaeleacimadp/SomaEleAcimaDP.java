package somaeleacimadp;

import java.util.Scanner;

public class SomaEleAcimaDP {

    public static void main(String[] args) {
        int valor;
        Scanner in = new Scanner(System.in);
        int[][] mat = new int[4][4];
        preencher(mat);
        exibirMat(mat);
        valor =somaElem(mat);
        System.out.printf("A soma dos elementos acima da DP foi: %d %n", valor);
    }

    public static void preencher(int[][] mat) {
        Scanner in = new Scanner(System.in);
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                System.out.printf("Informe o valor da posição [%d][%d] da Matriz: ", (i + 1), (j + 1));
                mat[i][j] = in.nextInt();
            }
        }
    }

    public static int somaElem(int[][] mat) {
        int soma = 0;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (j > i) {
                    soma += mat[i][j];
                }
            }
        }
        return soma;
    }

    public static void exibirMat(int[][] mat) {
        System.out.println("==================================================");
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("==================================================");
    }
}
