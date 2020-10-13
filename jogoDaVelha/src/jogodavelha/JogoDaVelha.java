package jogodavelha;

import java.util.Scanner;
import java.security.SecureRandom;

public class JogoDaVelha {

    public static void main(String[] args) {
        int valorA;
        SecureRandom gera = new SecureRandom();
        Scanner in = new Scanner(System.in);

        String[] nomes = new String[2];
        int resp, resp2, vez, li, co, qtd = 0, resultado = 0, nivel;

        do {
            String[][] jogo = {{"-", "-", "-"}, {"-", "-", "-"}, {"-", "-", "-"}};
            System.out.println("Jogo da velha \n1-Jogar \n2-Sair");
            resp = in.nextInt();
            switch (resp) {
                case 1:
                    System.out.println("Jogo da Velha \n1-Um jogador \n2-Dois Jogadores");
                    resp2 = in.nextInt();
                    in.nextLine();
                    switch (resp2) {
                        case 1:
                            qtd = 0;
                            System.out.print("Informe seu nome: ");
                            nomes[0] = in.nextLine();
                            nomes[1] = "Maquina";
                            System.out.print("Nível do jogo \n1-Fácil \n2-Díficil ");
                            nivel = in.nextInt();

                            switch (nivel) {
                                case 1:

                                    valorA = gera.nextInt(2);
                                    System.out.println(nomes[0] + "-X \n" + nomes[1] + "-O");
                                    if (valorA == 0) {
                                        vez = 0;
                                        System.out.println("O(a) " + nomes[0] + " inicia o jogo ");
                                    } else {
                                        vez = 1;
                                        System.out.println("O(a) " + nomes[1] + " inicia o jogo ");
                                    }
                                    do {
                                        if (qtd == jogo.length * jogo[0].length) {
                                            System.out.println("Impate!");
                                            resultado = 1;
                                        } else if (vez == 0) {
                                            exibirTabela(jogo);
                                            System.out.println(nomes[0] + " é sua vez de jogar: ");
                                            System.out.print("Informe a linha: ");
                                            li = in.nextInt();
                                            li -= 1;
                                            System.out.print("Informe a coluna: ");
                                            co = in.nextInt();
                                            co -= 1;
                                            while (jogo[li][co] == "x" || jogo[li][co] == "o") {
                                                System.out.println("Essa posição já esta ocupada, informe outra: ");
                                                System.out.print("Informe a linha: ");
                                                li = in.nextInt();
                                                li -= 1;
                                                System.out.print("Informe a coluna: ");
                                                co = in.nextInt();
                                                co -= 1;
                                            }
                                            jogo[li][co] = "x";
                                            qtd++;
                                            resultado = vencedor(jogo, "x");
                                            if (resultado == 1) {
                                                exibirTabela(jogo);
                                                System.err.println("Você Venceu!");
                                            } else {
                                                vez = 1;
                                            }
                                        } else {
                                            li = gera.nextInt(3);
                                            co = gera.nextInt(3);
                                            while (jogo[li][co] == "x" || jogo[li][co] == "o") {
                                                li = gera.nextInt(3);
                                                co = gera.nextInt(3);
                                            }
                                            jogo[li][co] = "o";
                                            qtd++;
                                            resultado = vencedor(jogo, "o");
                                            if (resultado == 1) {
                                                exibirTabela(jogo);
                                                System.err.println("A " + nomes[1] + " Venceu!");
                                            } else {
                                                vez = 0;
                                            }
                                        }
                                    } while (resultado != 1);
                                    break;
                                case 2:
                                    break;
                            }
                            break;
                        case 2:
                            qtd = 0;
                            System.out.print("Informe o nome do jogador 1: ");
                            nomes[0] = in.nextLine();
                            System.out.print("Informe o nome do jogador 2: ");
                            nomes[1] = in.nextLine();
                            valorA = gera.nextInt(2);
                            System.out.println(nomes[0] + "-X \n" + nomes[1] + "-O");
                            if (valorA == 0) {
                                vez = 0;
                                System.out.println("O(a) " + nomes[0] + " inicia o jogo ");
                            } else {
                                vez = 1;
                                System.out.println("O(a) " + nomes[1] + " inicia o jogo ");
                            }
                            do {
                                if (qtd == jogo.length * jogo[0].length) {
                                    System.err.println("Impate!");
                                    resultado = 1;
                                } else {
                                    exibirTabela(jogo);
                                    System.out.println(nomes[vez] + " é sua vez de jogar: ");
                                    System.out.print("Informe a linha: ");
                                    li = in.nextInt();
                                    li -= 1;
                                    System.out.print("Informe a coluna: ");
                                    co = in.nextInt();
                                    co -= 1;
                                    while (jogo[li][co] == "x" || jogo[li][co] == "o") {
                                        System.out.println("Essa posição já esta ocupada, informe outra: ");
                                        System.out.print("Informe a linha: ");
                                        li = in.nextInt();
                                        li -= 1;
                                        System.out.print("Informe a coluna: ");
                                        co = in.nextInt();
                                        co -= 1;
                                    }
                                    if (vez == 0) {
                                        jogo[li][co] = "x";
                                        qtd++;
                                        resultado = vencedor(jogo, "x");
                                        if (resultado == 1) {
                                            exibirTabela(jogo);
                                            System.err.println("O jagador(a) " + nomes[0] + " Venceu!");
                                        } else {
                                            vez = 1;
                                        }
                                    } else {
                                        jogo[li][co] = "o";
                                        qtd++;
                                        resultado = vencedor(jogo, "o");
                                        if (resultado == 1) {
                                            exibirTabela(jogo);
                                            System.err.println("O jagador(a) " + nomes[1] + " Venceu!");
                                        } else {
                                            vez = 0;
                                        }
                                    }
                                }
                            } while (resultado != 1);
                            break;
                    }
                    break;
                case 2:
                    System.out.println("Obrigado por jogar, até mais!!");
                    break;
                default:
                    System.err.println("Opção inválida!");
            }
        } while (resp != 2);

    }

    public static void exibirTabela(String[][] jogo) {
        System.out.println();
        for (int i = 0; i < jogo.length; i++) {
            for (int j = 0; j < jogo[0].length; j++) {
                System.out.print(jogo[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static int vencedor(String[][] jogo, String val) {
        int acertos = 0;
        for (int i = 0; i < jogo.length; i++) {
            for (int j = 0; j < jogo[0].length; j++) {
                if (jogo[i][j] == val) {
                    acertos++;
                }
            }
            if (acertos == 3) {
                return 1;
            }
            acertos = 0;
        }
        for (int j = 0; j < jogo[0].length; j++) {
            for (int i = 0; i < jogo.length; i++) {
                if (jogo[i][j] == val) {
                    acertos++;
                }
            }
            if (acertos == 3) {
                return 1;
            }
            acertos = 0;
        }
        for (int i = 0; i < jogo.length; i++) {
            if (jogo[i][i] == val) {
                acertos++;
            }
        }
        if (acertos == 3) {
            return 1;
        }
        acertos = 0;
        if (jogo[0][2] == val) {
            acertos++;
        }
        if (jogo[1][1] == val) {
            acertos++;
        }
        if (jogo[2][0] == val) {
            acertos++;
        }
        if (acertos == 3) {
            return 1;
        }
        return 2;
    }
}
