package dadosdealunoscomvetores;

import java.util.Scanner;

public class DadosDeAlunosComVetores {

    public static void main(String[] args) {
        double per;
        int totalAluAcMed;
        String[] nomes = new String[50]; // criação do vetor de nomes
        double[] notas1 = new double[50]; // criação do vetor de notas1
        double[] notas2 = new double[50]; // criação do vetor de notas2
        double[] media = new double[50]; // criação do vetor de media
        prencherExibir(nomes, notas1, notas2, media);
        /* chamada do procedimento
        que preenche os vetores: nomes, notas1 e notas2 e exibir a media e nome
        de cada aluno*/
        mediaTotal(media); // chamada da função que calculo a media da turma
        per = percentualAbMedia(media, mediaTotal(media));
        /* chamada da função
        que calcula o percentual de medias abaixo da media da turma */
        totalAluAcMed = totalAlunosAcMedia(media, mediaTotal(media));
        /* chamada
        da função que calcula as medias acima da media da turma        
         */
        maiorMedia(media); // chamada da função que mostra a maior media
        System.out.println("A média da turma foi: " + mediaTotal(media));
        System.out.println("O percentual de medias abaixo da media da turma foi: " + per + "%");
        System.out.println("O total de Alunos acima da média da turma foi: " + totalAluAcMed);
        System.out.println("A maior média da turma foi: " + maiorMedia(media));
    }

    public static void prencherExibir(String[] nomes, double[] pNota, double[] sNota, double[] me) {
        Scanner in = new Scanner(System.in);
        for (int i = 0; i < nomes.length; i++) {
            System.out.print("Inform o Nome do " + (i + 1) + "º aluno(a): ");
            nomes[i] = in.nextLine(); // atribuição do elemento no vetor
            System.out.print("Informe a primeira nota de " + nomes[i] + ": ");
            pNota[i] = in.nextDouble(); // atribuição do elemento no vetor
            System.out.print("Informe a segunda nota de " + nomes[i] + ": ");
            sNota[i] = in.nextDouble(); // atribuição do elemento no vetor
            in.nextLine();
            calcMedia(pNota, sNota, me);
            /* chamada do procedimento que preencher
            o vetor de medias.
             */
            System.out.println("O Aluno(a) " + nomes[i] + " Obteve média " + me[i]);
            System.out.println();
        }
    }

    public static void calcMedia(double[] nota1, double[] nota2, double[] me) {
        for (int i = 0; i < me.length; i++) {
            me[i] = (nota1[i] * 2 + nota2[i] * 3) / 5;
        }
    }

    public static double mediaTotal(double[] media) {
        double totalDeMedias = 0, valor;
        for (int i = 0; i < media.length; i++) {
            totalDeMedias += media[i];
        }
        return totalDeMedias / media.length;
    }

    public static double percentualAbMedia(double[] media, double totalM) {
        int total = 0;
        for (int i = 0; i < media.length; i++) {
            if (media[i] < totalM) {
                total++;
            }
        }
        return total * 100.0 / media.length;
    }

    public static int totalAlunosAcMedia(double[] media, double totalM) {
        int total = 0;
        for (int i = 0; i < media.length; i++) {
            if (media[i] > totalM) {
                total++;
            }
        }
        return total;
    }

    public static double maiorMedia(double[] media) {
        double maior = media[0];
        for (int i = 0; i < media.length; i++) {
            if (media[i] >= maior) {
                maior = media[i];
            }
        }
        return maior;
    }
}
