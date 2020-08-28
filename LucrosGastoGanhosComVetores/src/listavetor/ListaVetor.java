package listavetor;
import java.util.Scanner;
public class ListaVetor {
    public static void main(String[] args) {
        double[] vetGanhos = new double[4];
        double[] vetGastos = new double[4];
        double[] vetLucros = new double[4];
        System.out.println("Informe os valores dos ganhos:");
        PreencherVet(vetGanhos);
        System.out.println("Informe os valores dos gastos:");
        PreencherVet(vetGastos);
        calcLucros(vetGanhos, vetGastos, vetLucros);
        System.out.println("Valores dos Ganhos:");
        exibiVet(vetGanhos);
        System.out.println("Valores dos Gastos:");
        exibiVet(vetGastos);
        System.out.println("Valores dos Lucros:");
        exibiVet(vetLucros);
        somaVet(vetGanhos);
        somaVet(vetGastos);
        somaVet(vetLucros);
        mediaVet(vetLucros);
        System.out.println("O total de ganhos foi: R$" + somaVet(vetGanhos));
        System.out.println("O total de gastos foi: R$" + somaVet(vetGastos));
        System.out.println("O total de Lucros foi: R$" + somaVet(vetLucros));
        System.out.println("O lucro médio no ano de 2019 foi de R$" + mediaVet(vetLucros));
    }
    public static void PreencherVet(double[] vet) {
        Scanner in = new Scanner(System.in);
        int mes = 1;
        for (int i = 0; i < vet.length; i++) {
            System.out.print("Digite o valor do mês " + mes + " : ");
            vet[i] = in.nextDouble();
            mes++;
        }
    }
    public static void calcLucros(double[] vetGan, double[] vetGas, double[] vetLu) {
        for (int i = 0; i < vetGan.length; i++) {
            vetLu[i] = vetGan[i] - vetGas[i];
        }
    }
    public static void exibiVet(double[] vet) {
        int i;
        int mes = 1;
        for ( i = 0; i < vet.length; i++) {
            System.out.println("Mês " + mes + " R$" + vet[i]);
            mes++;
        }
    }
    public static double somaVet(double[] vet) {
        double soma = 0;
        for (int i = 0; i < vet.length; i++) {
            soma = soma + vet[i];
        }
        return soma;
    }
    public static double mediaVet(double[] vetL) {
        double media = somaVet(vetL) / vetL.length;
        return media;
    }
}
