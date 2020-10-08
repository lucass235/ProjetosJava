
package minmaxmatriz;

import java.util.Scanner;

public class MinMaxMatriz {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int i, j, liMenorEle;
        System.out.println("Informe a quantidade de linhas da matriz: ");
        i = in.nextInt();
        while(i <=0){
            System.err.println("Valor incorreto, digite um nº maior que 0: ");
            i = in.nextInt();
        }
        System.out.println("Informe a quantidade de colunas da matriz: ");
        j = in.nextInt();
        while(j <=0){
            System.err.println("Valor incorreto, digite um nº maior que 0: ");
            j = in.nextInt();
        }
        double[][] mat = new double[i][j];
        preencherMat(mat);
        liMenorEle = linMenEle(mat);
        exibirMinMax(mat, linMenEle(mat));
    }

    public static void preencherMat(double[][] mat) {
        Scanner in = new Scanner(System.in);
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                System.out.printf("Informe o elemento (%d,%d): ", (i+1), (j+1));
                mat[i][j] = in.nextDouble();
            }
        }
    }
    
    public static int linMenEle (double[][] mat) {
        double menor = mat[0][0];
        int linha = 0;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] < menor) {
                    menor = mat[i][j];
                    linha = i;
                }
            }
        }
    return linha;
    }
    
    public static void exibirMinMax (double[][]mat, int i) {
        double maior = 0;
        int coluna = 0;
        for (int j = 0; j < mat[0].length; j++) {
            if (mat[i][j] > maior) {
                maior = mat[i][j];
                coluna = j;
            }
        }
        System.out.printf("O elemento MINMAX é %.2f que está na posição (%d,%d)%n",maior,(i+1),(coluna+1));
    }
}
