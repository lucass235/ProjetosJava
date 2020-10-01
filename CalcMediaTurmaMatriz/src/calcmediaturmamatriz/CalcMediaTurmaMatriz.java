package calcmediaturmamatriz;

import java.util.Scanner;

public class CalcMediaTurmaMatriz {

    public static void main(String[] args) {
        String[] nomes = new String[2];
        double[][] notas = new double[2][3];
        double mediaTurma;
        int alAbaixo;
        preencherMatriz(nomes, notas);
        calcMedia(notas);
        mediaTurma = mediaTurma(nomes, notas);
        System.out.println("================================");
        System.out.printf("A média da turma foi: %.2f %n", mediaTurma);
        alAbaixo = alunosAbaixoMedia(notas, mediaTurma);
        System.out.println("================================");
        System.out.printf("%d Alunos ficaram Abaixo da média da turma %n", alAbaixo);
        System.out.println("================================");
        maiorMenorMedia(notas);
    }

    public static void preencherMatriz(String[] nomes, double[][] notas) {
        Scanner in = new Scanner(System.in);
        for (int i = 0; i < notas.length; i++) {
            System.out.printf("Informe o nome do(a) %dº aluno(a): ", (i + 1));
            nomes[i] = in.nextLine();
            for (int j = 0; j < notas[0].length - 1; j++) {
                System.out.printf("Informe a %dº nota do(a) aluno(a): ", (j + 1));
                notas[i][j] = in.nextDouble();
            }
            in.nextLine();
        }
    }

    public static void calcMedia(double[][] notas) {
        int media = notas[0].length - 1;
        for (int i = 0; i < notas.length; i++) {
            for (int j = 0; j < notas[0].length - 2; j++) {
                notas[i][media] = ((notas[i][j] * 2.0) + (notas[i][j + 1] * 3.0)) / 5.0;
            }
        }
    }

    public static double mediaTurma(String[] nome, double[][] notas) {
        double mediaTurma = 0;
        int media = notas[0].length - 1;
        for (int i = 0; i < notas.length; i++) {
            mediaTurma += notas[i][media];
        }
        mediaTurma = mediaTurma / notas.length;
        return mediaTurma;
    }

    public static int alunosAbaixoMedia(double[][] notas, double mediaT) {
        int quant = 0;
        int media = notas[0].length - 1;
        for (int i = 0; i < notas.length; i++) {
            if (notas[i][media] < mediaT) {
                quant++;
            }
        }
        return quant;
    }

    public static void maiorMenorMedia(double[][] notas) {
        int media = notas[0].length - 1;
        double maior = 0, menor = notas[0][media];
        for (int i = 0; i < notas.length; i++) {
            if (notas[i][media] > maior) {
                maior = notas[i][media];
            }
            if (notas[i][media] < menor) {
                menor = notas[i][media];
            }
        }
        System.out.printf("A maior média foi %.2f e a menor foi %.2f %n", maior, menor);
    }
}
