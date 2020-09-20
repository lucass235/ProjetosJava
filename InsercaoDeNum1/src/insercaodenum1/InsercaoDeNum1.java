package insercaodenum1;

import java.util.Scanner;

public class InsercaoDeNum1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] A = new int[5]; // vetor de números pares.
        int[] B = new int[5]; // vetor de números ímpares.
        boolean testeA, testeB;
        int valor, posicaoA = 0, posicaoB = 0, vez, opcao;
        do {
            exibirMenu(); // exibição do menu.
            opcao = in.nextInt(); // escolha do menu.
            while (opcao < 1 || opcao > 5) {
                System.out.print("Resposta invalida, digite a opção no intervalo de 1 à 5: ");
                opcao = in.nextInt();
            }
            switch (opcao) {
                case 1: // armazenar número.
                    System.out.print("Digite um número inteiro para ser armazenado: ");
                    valor = in.nextInt();
                    testeA = vetCheio(A, posicaoA); // verificação do vetor A esta cheio.
                    testeB = vetCheio(B, posicaoB); // verificação do vetor B esta cheio.
                    if (testeA == true && testeB == true) {
                        System.out.println("Todos os vetores estão cheios, informe outra opção no menu: ");
                    } else {
                        if (valor % 2 == 0) { // armazenagem no vetor de pares.
                            if (testeA == true) {
                                System.out.println("O vetor dos números pares está cheio, escolha outra opção do menu: ");
                            } else {
                                posicaoA = posicaoVet(A, posicaoA, valor);
                            }
                        } else { // armazenagem no vetor de ímpares.
                            if (testeB == true) {
                                System.out.println("O vetor dos números ìmpares está cheio, escolha outra opção do menu: ");
                            } else {
                                posicaoB = posicaoVet(B, posicaoB, valor);
                            }
                        }
                    }
                    break;
                case 2: // procurar número.
                    System.out.print("Digite o numero a ser procurado: ");
                    valor = in.nextInt();
                    if (valor % 2 == 0) { // busca no vetor de pares.
                        vez = buscaValor(A, posicaoA, valor);
                    } else { // busca no vetor de ímpres.
                        vez = buscaValor(B, posicaoB, valor);
                    }
                    System.out.println("A quantidade de vezes que o valor " + valor
                            + " foi encontrado foi: " + vez);
                    break;
                case 3: // exibir números pares.
                    System.out.println("Esses são os números Pares armazenados: ");
                    exibirValor(A, posicaoA);
                    break;
                case 4: // exibir números ímpares
                    System.out.println("Esses são os números Ímpares armazenados: ");
                    exibirValor(B, posicaoB);
            }
            System.out.println();
        } while (opcao != 5); // condição de encerramento do programa.
    }

    public static void exibirMenu() {
        System.out.print(" 1- Armazenar número \n 2- Procurar número "
                + "\n 3- Exibir número pares \n 4-Exibir números ímpares "
                + "\n 5- Encerrar programa \n Digite a opção desejada: ");
    }

    public static int posicaoVet(int[] vet, int posicao, int valor) {
        
        for (int i = 0; i < vet.length; i++) {
            if (vet[i] == 0) {
                vet[i] = valor;
                posicao++; // incremento de 1, indicando a a ocupação de 1 valor.
                break;
            }
        }
        return posicao;
    }

    public static int buscaValor(int[] vet, int pos, int valor) {
        int vezes = 0;
        for (int i = 0; i < pos; i++) {
            if (vet[i] == valor) {
                vezes++; //quantidade de vezes que o valor é achado no vetor.
            }
        }
        return vezes;
    }

    public static void exibirValor(int[] vet, int pos) {
        for (int i = 0; i < pos; i++) {
            System.out.println(vet[i]);
        }
    }

    public static boolean vetCheio(int[] vet, int pos) {
        boolean cheio = false;
        if (pos == vet.length) {
            cheio = true;
        }
        return cheio;
    }
}
