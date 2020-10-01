package com.insercaodestrings;

import java.util.Scanner;

public class insercaoDeStrings {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] nome = new String[20];
        int resp, busc;
        String valor;
        System.out.println("Informe a seguir 20 nomes não repetidos!");
        preencherVet(nome);
        ordenarVet(nome);
        do {
            System.out.println("Informe uma opção: \n 1-Buscar Nome \n 2-Exibir Nomes" +
                    " \n 0-Encerrar");
            resp = in.nextInt();
            switch (resp) {
                case 1:
                    in.nextLine();
                    System.out.println("Informe o nome para busca:");
                    valor = in.nextLine();
                    busc = buscaValor(nome, valor);
                    if (busc == -1) {
                        System.err.println("Nome não encontrado!");
                    } else {
                        System.out.printf("O(a) " + valor + " foi encontrado no vetor " + busc);
                    }
                    break;
                case 2:
                    exibirNomes(nome);
                    break;
                case 0:
                    System.out.println("Programa Encerrado!");
                    break;
                default:
                    System.err.println("Opção inválida");
            }
        } while (resp != 0);

    }

    public static void exibirNomes(String[] nomes) {
        for (int i = 0; i < nomes.length; i++) {
            System.out.println(nomes[i]);

        }
    }

    public static void preencherVet(String[] nomes) {
        Scanner in = new Scanner(System.in);
        String nome;
        int i, j;
        boolean repetido;
        for (i = 0; i < nomes.length; ) {
            System.out.print("Informe o " + (i + 1) + "º nome:");
            nome = in.nextLine();
            repetido = false;
            for (j = 0; j < i; j++) {
                if (nomes[j].equalsIgnoreCase(nome)) {
                    repetido = true;
                    break;
                }
            }
            if (repetido == false) {
                nomes[i] = nome;
                i++;
            } else {
                System.err.println("O nome informado já existe!");
            }
        }
    }

    public static int buscaValor(String[] vet, String nome) {
        int inicio = 0, meio, fim = vet.length;
        do {
            meio = (inicio + fim) / 2;
            if (vet[meio].equalsIgnoreCase(nome)) {
                return meio;
            } else if (vet[meio].compareToIgnoreCase(nome) < 0) {
                inicio = meio + 1;
            } else {
                fim = meio - 1;
            }
        } while (inicio <= fim);
        return -1;
    }

    public static void ordenarVet(String[] vet) {
        String aux;
        for (int i = 0; i < vet.length - 1; i++) {
            for (int j = 0; j < vet.length - 1; j++) {
                if (vet[j].compareToIgnoreCase(vet[j + 1]) > 0) {
                    aux = vet[j];
                    vet[j] = vet[j + 1];
                    vet[j + 1] = aux;
                }
            }
        }
    }
}
