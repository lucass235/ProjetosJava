package elementosconsecutivos;

import java.util.Scanner;

public class ElementosConsecutivos {

    public static void main(String[] args) {
        double[] valores = new double[25];// criação do vetor dos valores
        preVet(valores); // procedimento para preencher os vetores
        maiorDi(valores); // função que calcula a maior diferença
        System.out.println("Dentre os 25 valores digitados");
        System.out.println("A maior diferença é: " + maiorDi(valores));
    }

    public static void preVet(double[] val) {
        Scanner in = new Scanner(System.in);
        for (int i = 0; i < val.length; i++) {
            System.out.print("Informe o " + (i + 1) + "º valor: ");
            val[i] = in.nextDouble();
        }
    }

    public static double maiorDi(double[] val) {
        double maior = 0;// armazenar a maior diferença
        double diferenca; // armazenar diferença
        for (int i = 0; i < val.length - 1; i++) {
            diferenca = val[i] - val[i + 1];
            if (diferenca >= maior) { // condição de maior diferença
                maior = diferenca;
            }
        }
        return maior; // retorna da maior difernça
    }
}
