package insercaoordenada;

import java.util.Scanner;

public class InsercaoOrdenada {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] A = new int[50];
        int[] B = new int[50];
        int quantA = 0, quantB = 0, valor, opc, cont, busca;

        do {
            exibiMenu();
            opc = in.nextInt();
            switch (opc) {
                case 1:
                    System.out.println("Informe o valor para a inserção: ");
                    valor = in.nextInt();
                    if (valor % 2 == 0) {
                        cont = insercaoOrdenada(A, quantA, valor);
                        switch (cont) {
                            case -1:
                                System.err.println("O valor inserido já existe no vetor!");
                                break;
                            case -2:
                                System.err.println("O vetor de números par está cheio!");
                                break;
                            default:
                                quantA = cont;
                                System.out.println("Valor inserido!");
                                break;
                        }
                    } else {
                        cont = insercaoOrdenada(B, quantB, valor);
                        switch (cont) {
                            case -1:
                                System.err.println("O valor inserido já existe no vetor!");
                                break;
                            case -2:
                                System.err.println("O vetor de números par está cheio!");
                                break;
                            default:
                                quantB = cont;
                                System.out.println("Valor inserido!");
                                break;
                        }
                    }
                    break;
                case 2:
                    System.out.println("Informe o valor para buscar: ");
                    valor = in.nextInt();
                    if (valor % 2 == 0) {
                        busca = buscarValor(A, quantA, valor);
                    } else {
                        busca = buscarValor(B, quantB, valor);
                    }
                    if (busca == -1) {
                        System.err.println("O valor não foi encontrado!");
                    } else {
                        System.out.println("O valor foi encontrado no indice [" + busca + "]");
                    }
                    break;
                case 3:
                    int r;
                    System.out.println("Informe o valor a ser removido: ");
                    valor = in.nextInt();
                    if (valor % 2 == 0) {
                        r = removValor(A, quantA, valor);
                    } else {
                        r = removValor(B, quantB, valor);
                    }
                    if (r == -1) {
                        System.err.println("O valor não foi encontrado!");
                    } else if (r == -2) {
                        System.err.println("O vetor está vazio!");
                    } else {
                        System.out.println("Valor removido!");
                    }
                    break;
                case 4:
                    if (quantA == 0) {
                        System.err.println("Vetor vazio!");
                    } else {
                        System.out.println("Números no vetor de pares: ");
                        exibirVet(A, quantA);
                    }
                    break;
                case 5:
                    if (quantB == 0) {
                        System.err.println("Vetor vazio!");
                    } else {
                        System.out.println("Números no vetor de ímpares: ");
                        exibirVet(B, quantB);
                    }
                    break;
                case 0:
                    System.out.println("Fim do programa!");
                    break;
                default:
                    System.err.println("Opção inválida! informe a opção novamente.");
            }
        } while (opc != 0);
    }

    public static void exibiMenu() {
        System.out.println(" 1- Inserir valor \n 2- Buscar valor \n "
                + "3- remover valor \n 4- Exibir vetor de pares"
                + " \n 5- Exibir vetor de ímpares \n 0- Encerrar programa");
        System.out.println("Digite a opção desejada: ");
    }

    public static int insercaoOrdenada(int[] vet, int q, int v) {
        boolean repetido = false;
        int i, j;
        if (q == 0) {
            vet[q] = v;
            q++;
            return q;

        } else if (q < vet.length) {
            for (i = 0; i < q; i++) {
                if (v == vet[i]) {
                    repetido = true;
                    break;
                }
            }
            if (repetido == true) {
                return -1;
            } else {
                if (v > vet[q - 1]) {
                    vet[q] = v;
                    q++;
                    return q;
                } else {
                    for (i = 0; i < q; i++) {
                        if (vet[i] > v) {
                            break;
                        }
                    }
                    for (j = q; j > i; j--) {
                        vet[j] = vet[j - 1];
                    }
                    vet[i] = v;
                    q++;
                    return q;
                }
            }

        } else {
            return -2;
        }
    }

    public static int buscarValor(int[] vet, int q, int v) {
        int meio, inicio = 0, fim = q;
        do {
            meio = (inicio + fim) / 2;
            if (vet[meio] == v) {
                return meio;
            } else if (vet[meio] < v) {
                inicio = meio + 1;
            } else {
                fim = meio - 1;
            }
        } while (inicio <= fim);
        return -1;
    }

    public static void exibirVet(int[] vet, int p) {
        for (int i = 0; i < p; i++) {
            System.out.print(vet[i] + " ");
        }
        System.out.println();
    }

    public static int removValor(int[] vet, int p, int v) {
        int bus;
        bus = buscarValor(vet, p, v);
        if (bus != -1) {
            for (int i = bus; i < p; i++) {
                vet[i] = vet[i + 1];
            }
            p--;
            return p;
        } else if (p == 0) {
            return -2;
        } else {
            return -1;
        }

    }
}
