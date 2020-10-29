package mediaalunosstring1;

import java.util.Scanner;

public class MediaAlunosString1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int qtdAlunos = 0, busca;
        System.out.print("Informe quantos alunos existe no Cólegio Minha Escolinha: ");
        qtdAlunos = in.nextInt();
        String aluno;
        String[] nomes = new String[qtdAlunos];
        String[] situacao = new String[qtdAlunos];
        double[] medias = new double[qtdAlunos];
        preencher(nomes, medias, situacao);
        in.nextLine();
        System.out.print("Informe o nome do aluno a ser consultado: ");
        aluno = in.nextLine();
        busca = buscarNome(nomes, aluno);
        exibirResultado(nomes, medias, situacao, busca);
    }

    public static void preencher(String[] nomes, double[] medias, String[] situacao) {
        Scanner in = new Scanner(System.in);
        double nota1, nota2;
        boolean valido;
        for (int i = 0; i < nomes.length; i++) {
            System.out.printf("Informe o nome do %dº aluno: ", (1 + i));
            nomes[i] = in.nextLine();
            
            valido = validacaoNome(nomes[i]);
            while (valido == false) {
                System.err.println("Nome Inválido!");
                System.out.printf("Informe o nome do %dº aluno: ", (1 + i));
                nomes[i] = in.nextLine();
                valido = validacaoNome(nomes[i]);
            }
            System.out.printf("Informe a 1º nota do(a) %s :", nomes[i]);
            nota1 = in.nextDouble();
            in.nextLine();
            while (nota1 < 0 || nota1 > 10) {
                System.out.println("Digite uma nota no intervalo de 0 e 10: ");
                nota1 = in.nextDouble();
                in.nextLine();
            }
            System.out.printf("Informe a 2º nota do(a) %s :", nomes[i]);
            nota2 = in.nextDouble();
            in.nextLine();
            while (nota2 < 0 || nota2 > 10) {
                System.out.println("Digite uma nota no intervalo de 0 e 10: ");
                nota2 = in.nextDouble();
                in.nextLine();
            }
            medias[i] = (nota1 * 2.0 + nota2 * 3.0) / 5.0;
            if(medias[i] < 3) {
                situacao[i] = "reprovado";
            } else if (medias[i] >= 3 && medias[i] < 7) {
                situacao[i] = "em recuperação";
            } else {
                situacao[i] = "aprovado";
            }
        }
        
    }

    public static boolean validacaoNome(String nome) {
        int tam;
        char valor;
        tam = nome.length();
        for (int i = 0; i < tam; i++) {
            valor = nome.charAt(i);
            if (Character.isDigit(valor)) {
                return false;
            } else if (Character.isLetter(valor) || Character.isDigit(valor)) {
            } else {
                return false;
            }
        }
        return true;
    }
    
    public static int buscarNome (String[] nomes, String aluno) {
         for (int i = 0; i < nomes.length; i++) {
             if (aluno.equalsIgnoreCase(nomes[i])) {
                 return i;
             }
        }
        return -1;
    }
    
    public static void exibirResultado (String[] nomes, double[] medias, String[] situacao, int i) {
        if(i == -1){
            System.out.println("Aluno não encontrado!");
        } else{
            System.out.printf("O aluno(a) %s obteve média %.2f e está %s. %n", nomes[i], medias[i], situacao[i]);
        }
    }
}
