package com.company;

import java.util.Random;
import java.util.Scanner;

public class insercaoAlatoria {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] A = new int[100];
        int num, achou, resp;
        preencherVet(A);
        ordenarVet(A);
        do {
            System.out.println(" 1-Exibir Valores \n 2-Buscar valores " +
                    "\n 0-Encerrar programa");
            resp = in.nextInt();
            switch (resp) {
                case 1:
                    exibiVet(A);
                    break;
                case 2:
                    System.out.println("Informe um número entre 0 1 a 10000: ");
                    num = in.nextInt();
                    achou = buscaValor(A, num);
                    if (achou == -1) {
                        System.out.println("O valor " + num + " não foi encontrado!");
                    } else {
                        System.out.println("O valor " + num + " foi encontrado no indice [" + achou + "]");
                    }
                    break;
                case 0:
                    System.out.println("Programa Encerrado!");
                    break;
                default:
                    System.err.println("Opção Inválida");
            }
        } while (resp != 0);
    }

    public static void preencherVet(int[] vet) {
        Random ger = new Random();
        int num = ger.nextInt(10000) + 1;
        int pree = 0;
        boolean repetido = false;
        vet[pree] = num;
        pree++;
        do {
            num = ger.nextInt(10000) + 1;
            for (int i = 0; i <= pree; i++) {
                if (vet[i] == num) {
                    repetido = true;
                    break;
                }
                repetido = false;
            }
            if (repetido == false) {
                vet[pree] = num;
                pree++;
            }
        } while (pree < vet.length);

    }

    public static int buscaValor(int[] vet, int num) {
        int inicio = 0, meio, fim = vet.length-1;
        do {
            meio = (inicio + fim) / 2;
            if (num == vet[meio]) {
                return meio;
            } else if (num > vet[meio]) {
                fim = meio - 1;
            } else {
                inicio = meio + 1;
            }
        } while (inicio <= fim);
        return -1;
    }

    public static void ordenarVet(int[] vet) {
        int j, aux, para = vet.length - 2, ind=0;
        boolean troca;
        do {
            troca = false;
            for (j = 0; j <= para; j++) {
                if (vet[j] < vet[j + 1]) {
                    aux = vet[j];
                    vet[j] = vet[j + 1];
                    vet[j + 1] = aux;
                    ind = j;
                    troca = true;
                }
            }
            para = ind - 1;
        } while (troca == true);
    }

    public static void exibiVet(int[] vet) {
        for (int i = 0; i < vet.length; i++) {
            System.out.println(vet[i]);
        }
    }
}

