
package matriztrasposta;

import java.util.Scanner;

public class MatrizTrasposta {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int i, j, resp;
        System.out.print("Informe a quantidades de linhas da matriz: ");
        i = in.nextInt();
        System.out.print("Informe a quantidades de colunas da matriz: ");
        j = in.nextInt();
        int[][] A = new int[i][j];
        int[][] B ;
        preencherMatriz(A);
        B = matrizTra(A);
        do {
        System.out.println("1-Exibir a matriz \n2-Exibir a matriz Trasposta"
                + " \n0-Encerrar");
        System.out.print("Informe uma das opção: ");
        resp = in.nextInt();
        switch  (resp){
            case 1:
                System.out.println();
                exibirMat(A);
                System.out.println();
                break;
            case 2:
                System.out.println();
                exibirMat(B);
                System.out.println();
                break;
            case 0:
                System.out.printf("%S %n","Até mais!!");
                break;
            default:
                System.err.println("Valor Inválido!");
        }
    } while (resp !=0);
        }

    public static void preencherMatriz (int[][] mat) {
        Scanner in = new Scanner(System.in);
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                System.out.printf("Informe o valor de A(%d,%d): ",(i+1),(j+1));
                mat[i][j] = in.nextInt();
            }
        }
    }
    
    public static int[][] matrizTra (int[][] matriz) {
        int li = matriz[0].length;
        int co = matriz.length;
        int[][] B = new int[li][co];
        for (int i = 0; i < B.length; i++) {
            for (int j = 0; j < B[0].length; j++) {
                B[i][j] = matriz[j][i];
            }
        }
        return B;
    }

    public static void exibirMat(int[][] mat){
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                System.out.print(mat[i][j]+" ");
            }
            System.out.println();
        }
    }
}
