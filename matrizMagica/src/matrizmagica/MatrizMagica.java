package matrizmagica;

import java.util.Scanner;

public class MatrizMagica {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int ordem, resul;
        System.out.println("Informe a ordem da matriz: ");
        ordem = in.nextInt();
        while(ordem <=0){
            System.err.println("Valor incorreto, digite um nº maior que 0: ");
            ordem = in.nextInt();
        }
        int[][] mat = new int[ordem + 1][ordem + 1];
        int[] somaDiagonais = new int[2];
        preencherMat(mat, somaDiagonais);
        resul = quadradoMagico(mat, somaDiagonais);
        if (resul == 1) {
            System.out.println("A matriz é um quadrado mágico!");
        } else{
            System.err.println("A matriz não é um quadrado mágico!");
        }
    }

    public static void preencherMat(int[][] mat, int[] somaD) {
        int somaI, somaJ;
        Scanner in = new Scanner(System.in);
        for (int i = 0; i < mat.length - 1; i++) {
            somaI = 0;
            for (int j = 0; j < mat[0].length - 1; j++) {
                System.out.printf("Informe o valor da posição(%d,%d): ", (i + 1), (1 + j));
                mat[i][j] = in.nextInt();
                somaI += mat[i][j]; // armazenagem dos valores para soma da linha
                if (i == j) {
                    somaD[0] += mat[i][j];
                } else if (i+j == mat.length+1){
                    somaD[1] += mat[i][j];
                }
            }
            mat[i][mat[0].length - 1] = somaI;
        }
        for (int j = 0; j < mat[0].length-1; j++) {
            somaJ = 0;
            for (int i = 0; i < mat.length-1; i++) {
                somaJ += mat[i][j];
            }
            mat[mat.length - 1][j] = somaJ;
        }
        
    }

    public static int quadradoMagico(int[][] mat, int[] somaD) {
        for (int i = 0; i < mat.length; i++) {
            if (mat[i][mat[0].length-1] != mat[mat.length-1][i] && somaD[0] != somaD[1]) {
               return 0;
            } 
        }
        return 1;
    }
}
