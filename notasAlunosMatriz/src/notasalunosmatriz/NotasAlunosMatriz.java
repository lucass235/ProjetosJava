package notasalunosmatriz;

import java.util.Scanner;

public class NotasAlunosMatriz {

    public static void main(String[] args) {
        char[] gabarito = new char[100];
        char[][] resp = new char[50][100];
        String[] nomes = new String[50];
        int[] acertos = new int[50];
        preencher(gabarito, resp, nomes, acertos);
        exibirAlunos(acertos, nomes, gabarito);
    }

    public static void preencher(char[] gabarito, char[][] resp, String[] nomes, int[] acertos) {
        Scanner in = new Scanner(System.in);
        for (int i = 0; i < gabarito.length; i++) { // pree gabarito
            System.out.printf("Informe o gabarito da quetão %d: ", (i + 1));
            gabarito[i] = in.next().charAt(0);
            gabarito[i] = Character.toLowerCase(gabarito[i]);
            while (gabarito[i] < 'a' || gabarito[i] > 'e') {
                System.out.println("Informe uma resposta entre 'a' e 'e'");
                gabarito[i] = in.next().charAt(0);
                gabarito[i] = Character.toLowerCase(gabarito[i]);
            }
            in.nextLine();
        }
        for (int i = 0; i < resp.length; i++) { // pree nomes e respostas
            System.out.printf("Informe o nome do %d Aluno(a): ", (i + 1));
            nomes[i] = in.nextLine();
            for (int j = 0; j < resp[0].length; j++) {
                System.out.printf("Informe a resposta do(e) %S da %dº questão :"
                        + "", nomes[i], (j + 1));
                resp[i][j] = in.next().charAt(0);
                resp[i][j] = Character.toLowerCase(resp[i][j]);
                while (resp[i][j] < 'a' || resp[i][j] > 'e') {
                    System.out.println("Informe uma resposta entre 'a' e 'e'");
                    resp[i][j] = in.next().charAt(0);
                    resp[i][j] = Character.toLowerCase(resp[i][j]);
                }
                if (resp[i][j] == gabarito[j]) {
                    acertos[i]++;
                }
            }
            in.nextLine();
            System.out.printf("O(A) aluno(a) %S acertou %d questoes!%n", nomes[i], acertos[i]);
        }
    }
    
    public static void exibirAlunos(int[] acertos, String[] nomes, char[] gaba) {
        System.out.println("Alunos aprovados!");
        for (int i = 0; i < nomes.length; i++) {
            if (acertos[i] >= (gaba.length*0.7)) {
                System.out.printf("O(A) aluno(a) %S foi aprovado com %d acertos de um "
                        + "total de %d questões.%n", nomes[i], acertos[i], gaba.length);
            }
        }
        System.out.println("=========================================================");
        System.out.println("Alunos reprovados!");
        for (int i = 0; i < nomes.length; i++) {
            if (acertos[i] < (gaba.length*0.7)) {
                System.out.printf("O(A) aluno(a) %S foi reprovado com %d acertos de um "
                        + "total de %d questões.%n", nomes[i], acertos[i], gaba.length);
            }
        }
    }
}
