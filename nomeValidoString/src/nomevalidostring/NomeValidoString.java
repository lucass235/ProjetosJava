package nomevalidostring;

import java.util.Scanner;

public class NomeValidoString {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String nome;
        boolean resul;
        System.out.println("Digite Um Nome: ");
        nome = in.nextLine();
        resul = nomeValido(nome);
        while(resul == false){
            System.err.println("O nome digitado não é valido");
            System.out.println("Digite outro Nome: ");
            nome = in.nextLine();
            resul = nomeValido(nome);
        }
        System.out.println(nome);
        System.out.println("Nome válido!");
    }

    public static boolean nomeValido(String nome) {
        boolean valido = false;
        char valor;
        int tam;
        tam = nome.length();
        for (int i = 0; i < tam; i++) {
            valor = nome.charAt(i);
            if (Character.isLetter(valor) || valor == ' ') {
                valido = true;
            } else {
                return false;
            }
        }
        return valido;
    }
}
