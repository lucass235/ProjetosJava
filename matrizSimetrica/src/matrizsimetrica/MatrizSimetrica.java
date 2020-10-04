package matrizsimetrica;

import java.util.Scanner;

public class MatrizSimetrica {

    public static void main(String[] args) {
        int[][] A = new int[4][4];
        preeMat(A);
        matSime(A);
        if (matSime(A) == 1) {
            System.out.println("A matriz é simétrica");
        } else {
            System.out.println("A matriz não é simétrica");
        }
    }

    public static void preeMat(int[][] mat) {
        Scanner in = new Scanner(System.in);
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                System.out.printf("Informe o valor na posição (%d,%d):",
                        +(i + 1), (j + 1));
                mat[i][j] = in.nextInt();
            }
        }
    }

    public static int matSime(int[][] mat) {
        boolean simetrica = false;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] != mat[j][i]) {
                    return 0;
                }
            }
        }
        return 1;
    }
}
