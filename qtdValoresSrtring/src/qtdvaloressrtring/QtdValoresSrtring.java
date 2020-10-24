package qtdvaloressrtring;

import java.util.Scanner;

public class QtdValoresSrtring {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String frase;
        int tam;
        char valor;
        System.out.println("Digite uma frase: ");
        frase = in.nextLine();
        tam = frase.length();
        int qtdLe = 0, qtdDi = 0, qtdEs = 0, qtdSi = 0;
        for (int i = 0; i < tam; i++) {
            valor = frase.charAt(i);
            if (Character.isDigit(valor)) {
                qtdDi++;
            } else if(Character.isLetter(valor)){
                qtdLe++;
            } else if(valor == ' ') {
                qtdEs++;
            } else {
                qtdSi++;
            }
        }
        System.out.println(frase);
        System.out.println("A quantidade de letras na frase é: "+qtdLe);
        System.out.println("A quantidade de dígitos na frase é: "+qtdDi);
        System.out.println("A quantidade de espaços na frase é: "+qtdEs);
        System.out.println("A quantidade de símbolos na frase é: "+qtdSi);
    }
}
