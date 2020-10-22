package jogodavelha;

import java.util.Scanner;
import java.security.SecureRandom;

public class JogoDaVelha {

    public static void main(String[] args) {
        int valorA;
        SecureRandom gera = new SecureRandom();
        Scanner in = new Scanner(System.in);
        String[] nomes = new String[2];
        int resp, resp2, nivel;

        do {
            String[][] jogo = {{"-", "-", "-"}, {"-", "-", "-"}, {"-", "-", "-"}};
            System.out.println("Jogo da velha \n1-Jogar \n2-Sair");
            resp = in.nextInt(); // inicialização do jogo ou saida.
            switch (resp) {
                case 1: // caso de inicializaçao do jogo.
                    System.out.println("Jogo da Velha \n1-Um jogador \n2-Dois Jogadores");
                    resp2 = in.nextInt(); // escolha de 1 ou 2 jogadores.
                    in.nextLine(); // buffer
                    switch (resp2) { // switch de 1 ou 2 jogadores.
                        case 1: // caso de 1 jagador.
                            System.out.print("Informe seu nome: ");
                            nomes[0] = in.nextLine();
                            nomes[1] = "Maquina";
                            System.out.print("Nível do jogo \n1-Fácil \n2-Díficil ");
                            nivel = in.nextInt(); // escolha de nivel do jogo.
                            switch (nivel) { // switch de nivel facil ou dificil.
                                case 1: // caso de jogo facil.
                                    modoFacil(jogo, nomes);
                                    break;
                                case 2: // caso do jogo dificil.
                                    modoDificil(jogo, nomes);
                                    break;
                            }
                            break;
                        case 2: // caso de 2 jagadores.
                            doisJogadores(jogo, nomes);
                            break;
                    }
                    break;
                case 2: // caso de saida do jogo.
                    System.err.println("Obrigado por jogar, até mais!!");
                    break;
                default: // caso de digitação de um valor != de 1 ou 2.
                    System.err.println("Opção inválida!");
            }
        } while (resp != 2); // loop do jogo entre joga ou sair.
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
        for (int i = 0; i < jogo.length; i++) { // verificação de acertos nas linhas.
            for (int j = 0; j < jogo[0].length; j++) {
                if (jogo[i][j] == val) {
                    acertos++; // contador de 3 acertos nas linhas.
                }
            }
            if (acertos == 3) { // condição de 3 acertos nas linhas(vitoria!).
                return 1;
            }
            acertos = 0;
        }
        for (int j = 0; j < jogo[0].length; j++) { // verificação de acertos nas colunas.
            for (int i = 0; i < jogo.length; i++) {
                if (jogo[i][j] == val) {
                    acertos++; // contador de 3 acertos nas colunas.
                }
            }
            if (acertos == 3) { // condição de 3 acertos nas colunas(vitoria!).
                return 1;
            }
            acertos = 0;
        }
        for (int i = 0; i < jogo.length; i++) { // verificação de acertos na diagonalP.
            if (jogo[i][i] == val) {
                acertos++; // contador de 3 acertos na diagonalP.
            }
        }
        if (acertos == 3) { // condição de 3 acertos na diagonalP(vitoria!).
            return 1;
        }
        acertos = 0;
        // ifs de acerto na diagonalS.
        if (jogo[0][2] == val) {
            acertos++;
        }
        if (jogo[1][1] == val) {
            acertos++;
        }
        if (jogo[2][0] == val) {
            acertos++;
        }
        if (acertos == 3) { // condição de 3 acertos na diagonalS(vitoria!).
            return 1;
        }
        return 2; // retorno em caso de nenhuma vitoria.
    }

    public static boolean verificarPossibilidade(String[][] mat) {
        int qtd = 0, liLivre = 0, coLivre = 0;
        boolean jogada = false; // variavel de condição de possibilidade de vitoria.
        for (int i = 0; i < mat.length; i++) { /* verifica se há possibilidade da maquina
            ganhar imediatamente nas linhas */
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == "o") {
                    qtd++;
                } else if (mat[i][j] != "x") {
                    liLivre = i; // linha livre
                    coLivre = j; // coluna livre
                }
            }
            if (qtd == 2 && mat[liLivre][coLivre] != "x") { // verificação de possibilidade verdadeira.
                mat[liLivre][coLivre] = "o"; // armazenagem na posição livre.
                jogada = true; // houve uma possibilidade de vitoria.
                return jogada; // retorno da possibilidade verdadeira.
            }
            qtd = 0;
        }
        for (int j = 0; j < mat[0].length; j++) { /* verifica se há possibilidade da maquina
            ganhar imediatamente nas colunas */
            for (int i = 0; i < mat.length; i++) {
                if (mat[i][j] == "o") {
                    qtd++;
                } else if (mat[i][j] != "x") {
                    liLivre = i; // linha livre.
                    coLivre = j; // coluna livre.
                }
            }
            if (qtd == 2 && mat[liLivre][coLivre] != "x") { // verificação de possibilidade verdadeira.
                mat[liLivre][coLivre] = "o"; // armazenagem na posição livre.
                jogada = true; // houve uma possibilidade de vitoria.
                return jogada; // retorno da possibilidade verdadeira.
            }
            qtd = 0;
        }
        for (int i = 0; i < mat.length; i++) { /* verifica se há possibilidade da maquina
            ganhar imediatamente na diagonalP */
            if (mat[i][i] == "0") {
                qtd++;
            } else if (mat[i][i] != "x") {
                liLivre = i; // linha e coluna livre
            }
        }
        if (qtd == 2 && mat[liLivre][coLivre] != "x") { // verificação de possibilidade verdadeira.
            mat[liLivre][coLivre] = "o"; // armazenagem na posição livre.
            jogada = true; // houve uma possibilidade de vitoria.
            return jogada; // retorno da possibilidade verdadeira.
        }
        qtd = 0;
        /* verifica se há possibilidade da maquina ganhar imediatamente na diagonalS */
        if (mat[0][2] == "o") {
            qtd++;
        } else if (mat[0][2] != "x") {
            liLivre = 0;
            coLivre = 2;

        }
        if (mat[1][1] == "o") {
            qtd++;
        } else if (mat[1][1] != "x") {
            liLivre = 1;
            coLivre = 1;

        }
        if (mat[2][0] == "o") {
            qtd++;
        } else if (mat[2][0] != "x") {
            liLivre = 2;
            coLivre = 0;

        }
        if (qtd == 2 && mat[liLivre][coLivre] != "x") { // verificação de possibilidade verdadeira.
            jogada = true; // houve uma possibilidade de vitoria.
            return jogada; // retorno da possibilidade verdadeira.
        }
        for (int i = 0; i < mat.length; i++) { // jogada em linhas
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == "x") {
                    qtd++;
                } else if (mat[i][j] != "o") {
                    liLivre = i;
                    coLivre = j;
                }
            }
            if (qtd == 2 && mat[liLivre][coLivre] != "o") {
                mat[liLivre][coLivre] = "o";
                jogada = true;
                return jogada;
            }
            qtd = 0;
        }
        // condiçoes a seguir de impedimento do jagador 1 ganhar.
        for (int j = 0; j < mat[0].length; j++) { // jogada nas colunas
            for (int i = 0; i < mat.length; i++) {
                if (mat[i][j] == "x") {
                    qtd++;
                } else if (mat[i][j] != "o") {
                    liLivre = i;
                    coLivre = j;
                }
            }
            if (qtd == 2 && mat[liLivre][coLivre] != "o") {
                mat[liLivre][coLivre] = "o";
                jogada = true;
                return jogada;
            }
            qtd = 0;

        }
        for (int i = 0; i < mat.length; i++) { //jogada na diagonal
            if (mat[i][i] == "x") {
                qtd++;
            } else if (mat[i][i] != "o") {
                liLivre = i;

            }
        }
        if (qtd == 2 && mat[liLivre][coLivre] != "o") {
            mat[liLivre][coLivre] = "o";
            jogada = true;
            return jogada;
        }
        qtd = 0;
        // jogada na diagonal secundaria
        if (mat[0][2] == "x") {
            qtd++;
        } else if (mat[0][2] != "o") {
            liLivre = 0;
            coLivre = 2;

        }
        if (mat[1][1] == "x") {
            qtd++;
        } else if (mat[1][1] != "o") {
            liLivre = 1;
            coLivre = 1;

        }
        if (mat[2][0] == "x") {
            qtd++;
        } else if (mat[2][0] != "o") {
            liLivre = 2;
            coLivre = 0;
        }
        if (qtd == 2 && mat[liLivre][coLivre] != "o") {
            mat[liLivre][coLivre] = "o";
            jogada = true;
            return jogada;
        }
        return jogada; // retorno de nenhuma possibilidade aceita.
    }

    public static void modoFacil(String[][] jogo, String[] nomes) {
        Scanner in = new Scanner(System.in); 
        int valorA;
        SecureRandom gera = new SecureRandom();// criação do gerador de nº aleatorios.
        int vez, qtd = 0, li, co, resultado = 0;

        valorA = gera.nextInt(2); // armazenagem do valor aleatorio(0 ou 1) em valorA.
        System.out.println(nomes[0] + "-X \n" + nomes[1] + "-O");
        if (valorA == 0) { // if da vez de jogada do inico do jogo.
            vez = 0;
            System.out.println("O(a) " + nomes[0] + " inicia o jogo ");
        } else {
            vez = 1;
            System.out.println("O(a) " + nomes[1] + " inicia o jogo ");
        }
        do { // loop do jogo.
            if (qtd == jogo.length * jogo[0].length) { // caso do jogo impatar.
                exibirTabela(jogo);
                System.err.println("Impate!");
                resultado = 1;
            } else if (vez == 0) { // jogada do 1 jogador.
                exibirTabela(jogo);
                System.out.println(nomes[0] + " é sua vez de jogar: ");
                System.out.print("Informe a linha: ");
                li = in.nextInt();
                while(li <= 0 || li > 3) { // validação da digitação das linhas.
                    System.out.println("Posição incorreta, digite uma entre 1 e 3");
                    li = in.nextInt();
                }
                li -= 1;
                System.out.print("Informe a coluna: ");
                co = in.nextInt();
                while(co <= 0 || co > 3) { // validação da digitação das colunas.
                    System.out.println("Posição incorreta, digite uma entre 1 e 3");
                    co = in.nextInt();
                }
                co -= 1;
                while (jogo[li][co] == "x" || jogo[li][co] == "o") { // validação de posição ocupada.
                    System.out.println("Essa posição já esta ocupada, informe outra: ");
                    System.out.print("Informe a linha: ");
                    li = in.nextInt();
                    while(li <= 0 || li > 3) { // validação da digitação das linhas.
                    System.out.println("Posição incorreta, digite uma entre 1 e 3");
                    li = in.nextInt();
                }
                    li -= 1;
                    System.out.print("Informe a coluna: ");
                    co = in.nextInt();
                    while(co <= 0 || co > 3) { // validação da digitação das colunas.
                    System.out.println("Posição incorreta, digite uma entre 1 e 3");
                    co = in.nextInt();
                }
                    co -= 1;
                }
                jogo[li][co] = "x"; // entrada do posição escolhida do jagador 1.
                qtd++; // contador de posição ocupadas na matriz.
                resultado = vencedor(jogo, "x"); // verificação de vitoria.
                if (resultado == 1) { // caso de vitoria.
                    exibirTabela(jogo);
                    System.err.println("Você Venceu!");
                } else { // caso de nenhuma vitoria.
                    vez = 1; // passagem da vez pra o outro jaador.
                }
            } else { // jogada da maquina.
                li = gera.nextInt(3); // geração de um valor aleatorio(0 à 2) para linhas.
                co = gera.nextInt(3); // geração de um valor aleatorio(0 à 2) para coluna.
                while (jogo[li][co] == "x" || jogo[li][co] == "o") { // validação de posição ocupada.
                    li = gera.nextInt(3);
                    co = gera.nextInt(3);
                }
                jogo[li][co] = "o"; // entrada da posição gerada pela maquina.
                qtd++; // contador de posições ocupadas pela matriz.
                resultado = vencedor(jogo, "o"); // verificação de vitoria.
                if (resultado == 1) { // caso de vitoria.
                    exibirTabela(jogo);
                    System.err.println("A " + nomes[1] + " Venceu!");
                } else { // caso de nenhuma vitoria.
                    vez = 0; // passagem da vez para o outro jagador.
                }
            }
        } while (resultado != 1); // loop inicia caso não houver vencedor.

    }

    public static void modoDificil(String[][] jogo, String[] nomes) {
        Scanner in = new Scanner(System.in);
        int valorA;
        SecureRandom gera = new SecureRandom(); // criação do gerador de nº (0 ou 1).
        int vez, qtd = 0, li, co, resultado;

        valorA = gera.nextInt(2); // armazenagem do valor aletorio em valorA.
        System.out.println(nomes[0] + "-X \n" + nomes[1] + "-O");
        if (valorA == 0) { // if de inicialição do jagador.
            vez = 0;
            System.out.println("O(a) " + nomes[0] + " inicia o jogo ");
        } else {
            vez = 1;
            System.out.println("O(a) " + nomes[1] + " inicia o jogo ");
        }
        do { // loop do jogo.
            if (qtd == jogo.length * jogo[0].length) { // caso de impate.
                exibirTabela(jogo);
                System.err.println("Impate!");
                resultado = 1;
            } else if (vez == 0) { // jogada do 1 jogador.
                exibirTabela(jogo);
                System.out.println(nomes[0] + " é sua vez de jogar: ");
                System.out.print("Informe a linha: ");
                li = in.nextInt();
                while(li <= 0 || li > 3) { // validação das linhas matriz.
                    System.out.println("Posição incorreta, digite uma entre 1 e 3");
                    li = in.nextInt();
                }
                li -= 1;
                System.out.print("Informe a coluna: ");
                co = in.nextInt();
                while(co <= 0 || co > 3) { // validação das colunas da matriz.
                    System.out.println("Posição incorreta, digite uma entre 1 e 3");
                    co = in.nextInt();
                }
                co -= 1;
                while (jogo[li][co] == "x" || jogo[li][co] == "o") { // validação de posição ocupada.
                    System.out.println("Essa posição já esta ocupada, informe outra: ");
                    System.out.print("Informe a linha: ");
                    li = in.nextInt();
                    while(li <= 0 || li > 3) { // validação das linhas.
                    System.out.println("Posição incorreta, digite uma entre 1 e 3");
                    li = in.nextInt();
                }
                    li -= 1;
                    System.out.print("Informe a coluna: ");
                    co = in.nextInt();
                    while(co <= 0 || co > 3) { // validação das colunas.
                    System.out.println("Posição incorreta, digite uma entre 1 e 3");
                    co = in.nextInt();
                }
                    co -= 1;
                }
                jogo[li][co] = "x"; // entrada na posição escolhida do jogador 1.
                qtd++; // contador de posiçoes ocupadas na matriz.
                resultado = vencedor(jogo, "x"); // verificação de vitoria.
                if (resultado == 1) { // caso de vitoria do jogador 1.
                    exibirTabela(jogo);
                    System.err.println("Você Venceu!");
                } else { // caso de nenhum ganho.
                    vez = 1; // passagem da vez para o outro jogador
                }
            } else { // jogada do 2 jogador.
                boolean veri = verificarPossibilidade(jogo); /* verificação inteligente
                de possibilidade da maquina ou o jogador ganhar imediatamente */
                if (veri == true) { // verificação inteligente executada.
                    resultado = vencedor(jogo, "o"); // verificação de vitoria.
                    qtd++; // contador de posiçoes ocupadas na matriz.
                } else { // verificação inteligente não executada.
                    li = gera.nextInt(3); // geração de valor aleatorio(0 à 2) para as linhas.
                    co = gera.nextInt(3); // geração de valor aleatorio(0 à 2) para as linhas.
                    while (jogo[li][co] == "x" || jogo[li][co] == "o") { // validação de posição ocupada.
                        li = gera.nextInt(3);
                        co = gera.nextInt(3);
                    }
                    jogo[li][co] = "o"; // entrada de posição gerada pela maquina.
                    qtd++; // contador de posiçoes ocupadas na matriz.
                    resultado = vencedor(jogo, "o"); // verificação de vitoria.
                }
                if (resultado == 1) { // caso de votoria da maquina.
                    exibirTabela(jogo);
                    System.err.println("A " + nomes[1] + " Venceu!");
                } else { // caso de nenhuma vitoria.
                    vez = 0; // passagem da vez do outro jagador.
                }
            }
        } while (resultado != 1); // loop inicia se não houver vencedor.

    }

    public static void doisJogadores(String[][] jogo, String[] nomes) {
        Scanner in = new Scanner(System.in);
        int valorA;
        SecureRandom gera = new SecureRandom();
        int vez, qtd = 0, li, co, resultado = 0;

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
                System.out.println();
                System.err.println("Impate!");
                resultado = 1;
            } else {
                exibirTabela(jogo);
                System.out.println(nomes[vez] + " é sua vez de jogar: ");
                System.out.print("Informe a linha: ");
                li = in.nextInt();
                while(li <= 0 || li > 3) {
                    System.out.println("Posição incorreta, digite uma entre 1 e 3");
                    li = in.nextInt();
                }
                li -= 1;
                System.out.print("Informe a coluna: ");
                co = in.nextInt();
                while(co <= 0 || co > 3) {
                    System.out.println("Posição incorreta, digite uma entre 1 e 3");
                    co = in.nextInt();
                }
                co -= 1;
                while (jogo[li][co] == "x" || jogo[li][co] == "o") {
                    System.out.println("Essa posição já esta ocupada, informe outra: ");
                    System.out.print("Informe a linha: ");
                    li = in.nextInt();
                    while(li <= 0 || li > 3) {
                    System.out.println("Posição incorreta, digite uma entre 1 e 3");
                    li = in.nextInt();
                }
                    li -= 1;
                    System.out.print("Informe a coluna: ");
                    co = in.nextInt();
                    while(co <= 0 || co > 3) {
                    System.out.println("Posição incorreta, digite uma entre 1 e 3");
                    co = in.nextInt();
                }
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
    }
}
