package multids;

import java.util.Scanner;

public class MultiDS {

    public static void main(String[] args) {
        double[][] mat = new double[3][3];
        preencher(mat);
        System.out.println("Matriz original:");
        exibirMat(mat);
        multiDS(mat);
        System.out.println("Nova Matriz:");
        exibirMat(mat);
    }

    public static void preencher(double[][] mat) {
        Scanner in = new Scanner(System.in);
        for (int j = 0; j < mat[0].length; j++) {
            for (int i = 0; i < mat.length; i++) {
                System.out.printf("Informe o valor da posição [%d][%d] da Matriz: ", (i + 1), (j + 1));
                mat[i][j] = in.nextInt();
            }
        }
    }

    public static void multiDS(double[][] mat) {
        double maior = maiorElem(mat);
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if ((i + j) == (mat.length - 1)) {
                    mat[i][j] = mat[i][j] * maior * 1.0;
                }
            }
        }
    }

    public static double maiorElem(double[][] mat) {
        double maior = 0;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] > maior) {
                    maior = mat[i][j];
                }
            }
        }
        return maior;
    }

    public static void exibirMat(double[][] mat) {
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
