package matrizpermutacao;

import java.util.Scanner;

public class MatrizPermutacao {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int ordem;
        boolean matPer;
        System.out.print("Informe a ordem da Matriz: ");
        ordem = in.nextInt();
        while(ordem < 1) {
            System.out.print("Informe um valor maior que 0: ");
            ordem = in.nextInt();
        }
        int[][] mat = new int[ordem][ordem];
        preencher(mat);
        matPer = matrizPermu(mat);
        exibirMat(mat);
        if (matPer == false) {
            System.err.printf("%S %n", "Essa matriz não é de Permutação!");
        } else {
            System.out.printf("%S %n", "Essa é uma matriz de Permutação!");
        }
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

    public static boolean matrizPermu(int[][] mat) {
        int contL0 = 0, contL1 = 0, contC0 = 0, contC1 = 0;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 0) {
                    contL0++;
                } else if (mat[i][j] == 1) {
                    contL1++;
                }
            }
            if (contL0 != (mat.length - 1) && contL1 != 1) {
                return false;
            }
            contL0 = 0;
            contL1 = 0;
        }
        for (int j = 0; j < mat[0].length; j++) {
            for (int i = 0; i < mat.length; i++) {
                if (mat[i][j] == 0) {
                    contC0++;
                } else if (mat[i][j] == 1) {
                    contC1++;
                }
            }
            if (contC0 != (mat.length - 1) && contC1 != 1) {
                return false;
            }
            contC0 = 0;
            contC1 = 0;
        }
        return true;
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
