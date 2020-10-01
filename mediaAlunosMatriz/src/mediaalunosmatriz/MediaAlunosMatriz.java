package mediaalunosmatriz;

import java.util.Scanner;

public class MediaAlunosMatriz {

    public static void main(String[] args) {
        String[] nomes = new String[20];
        double[][] notas = new double[20][3];
        preencherMatriz(nomes, notas);
    }

    public static void preencherMatriz(String[] nomes, double[][] notas) {
        Scanner in = new Scanner(System.in);
        int media= notas[0].length-1, i, j;
        for ( i = 0; i < notas.length; i++) {
            System.out.printf("Informe o nome do(a) %dº aluno(a): ", (i + 1));
            nomes[i] = in.nextLine();
            for ( j = 0; j < notas[0].length - 1; j++) {
                System.out.printf("Informe a %dº nota do(a) aluno(a): ", (j + 1));
                notas[i][j] = in.nextDouble();
            }
            notas[i][media] = ((notas[i][0] * 2.0) + (notas[i][1] * 3.0)) / 5.0;
            in.nextLine();
            System.out.printf("O(a) aluna(a) %S obteve a média %.2f %n", nomes[i],notas[i][media]);
        }
    }

    
}
