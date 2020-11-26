package dadospessoa;

import java.util.Scanner;

public class DadosPessoa {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String nome;
        int idade, resp, num;
        char genero;
        double peso, altura;
        int qtdPe;
        System.out.print("Informe a quantidade de pessoas: ");
        qtdPe = in.nextInt();
        while (qtdPe <= 0) {
            System.out.print("Quantidade inválida, digite novamente: ");
            qtdPe = in.nextInt();
        }
        in.nextLine();
        Pessoa[] pessoas = new Pessoa[qtdPe];
        for (int i = 0; i < qtdPe; i++) {
            System.out.printf("Informe o nome da %dª pessoa: ", (i + 1));
            nome = in.nextLine();
            System.out.print("Informe o seu gênero, M-masculino e F-feminino: ");
            genero = in.next().charAt(0);
            System.out.print("Informe a sua idade: ");
            idade = in.nextInt();
            System.out.print("Informe o seu peso: ");
            peso = in.nextDouble();
            System.out.print("Informe sua Altura: ");
            altura = in.nextDouble();
            in.nextLine();
            pessoas[i] = new Pessoa(nome, idade, genero, peso, altura);
        }
        System.out.println("===================================================");
        for (int i = 0; i < qtdPe; i++) {
            System.out.println((1 + i) + "ª pesssoa: " + pessoas[i].nomePessoa());
            System.out.println(pessoas[i]);
            System.out.println("=================================================");
        }

        do {
            System.out.println("1-Atualizar Altura\n2-Atualizar Peso\n3-Atualizar Idade"
                    + "\n0-Encerrar");
            resp = in.nextInt();
            switch (resp) {
                case 1:
                    System.out.print("Informe a numeração referente a pessoa: ");
                    num = in.nextInt();
                    while (num <= 0 || num > qtdPe) {
                        System.out.println("Numeração inválida, digite novamente: ");
                        num = in.nextInt();
                    }
                    System.out.print("Informe a nova altura: ");
                    altura = in.nextDouble();
                    pessoas[num - 1].atualizarAltura(altura);
                    break;
                case 2:
                    System.out.print("Informe a numeração referente a pessoa: ");
                    num = in.nextInt();
                    while (num <= 0 || num > qtdPe) {
                        System.out.println("Numeração inválida, digite novamente: ");
                        num = in.nextInt();
                    }
                    System.out.print("Informe o novo peso: ");
                    peso = in.nextDouble();
                    pessoas[num - 1].atualizarPeso(peso);
                    break;
                case 3:
                    System.out.print("Informe a numeração referente a pessoa: ");
                    num = in.nextInt();
                    while (num <= 0 || num > qtdPe) {
                        System.out.println("Numeração inválida, digite novamente: ");
                        num = in.nextInt();
                    }
                    System.out.print("Informe a nova idade: ");
                    idade = in.nextInt();
                    pessoas[num - 1].atualizarIdade(idade);
                    break;
                case 0:
                    System.out.println("Obrigado! Até mais.");
                    break;
                default:
                    System.err.println("Resposta inválida!");
            }
        } while (resp != 0);
    }
}
