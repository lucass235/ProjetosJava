package tabelapreçosmatriz;

import java.util.Scanner;

public class TabelaPreçosMatriz {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double[][] mat = new double[9][13];
        int resp;
        String entrada;
        String[] meses = {"Jan", "Fev", "Mar", "Abr", "Mai", "Jun", "Jul", "Ago", "Set", "Out"
            + "Nov", "Dez"};
        String[] frutas = {"Abacaxi", "Banana", "Maçã", "Mamão", "Melancia", "Melão",
            "Tangerina", "Uva"};
        preencher(mat, meses, frutas);
        do {
            menu();
            System.out.println("Informe uma opção: ");
            resp = in.nextInt();
            switch (resp) {
                case 1:
                    System.out.println("====================================");
                    System.out.println("O mercadinho fatura " + mediaMes(mat) + " "
                            + "em média por mes!");
                    System.out.println("====================================");
                    break;
                case 2:
                    in.nextLine();
                    System.out.println("Informe o nome da fruta para exibir"
                            + " o seu faturameto anual!");
                    entrada = in.next();
                    double ff = faturamentoFru(mat, entrada, frutas);
                    if (ff != -1) {
                        System.out.println("====================================");
                        System.out.println("O faturamento da fruta foi "
                                + ff);
                        System.out.println("====================================");
                    } else {
                        System.err.println("Fruta não encontrada");
                    }
                    break;
                case 3:
                    in.nextLine();
                    System.out.println("Informe o nome do mes para exibir"
                            + " o faturameto nesse mes(informe as 3 primiras letras do mes)!");
                    entrada = in.next();
                    double fm = faturamentoMes(mat, entrada, meses);
                    if (fm != -1) {
                        System.out.println("====================================");
                        System.out.println("O faturamento desse mes foi " + fm);
                        System.out.println("====================================");
                    } else {
                        System.err.println("valor inválido");
                    }
                    break;
                case 4:
                    System.out.println("====================================");
                    System.out.println("O mercadinho faturou " + faturamentoAno(mat)
                            + " no ano");
                    System.out.println("====================================");
                    break;
                case 0:
                    System.out.println("Até mais!!");
                    break;
                default:
                    System.err.println("Opção Inválida!");
            }
        } while (resp != 0);
    }

    public static void preencher(double[][] mat, String[] mes, String[] fru) {
        Scanner in = new Scanner(System.in);
        for (int i = 0; i < mat[0].length - 1; i++) {
            for (int j = 0; j < mat.length - 1; j++) {
                System.out.printf("Informe o valor das vendas do(a) %S no mes de"
                        + " %S :", fru[j], mes[i]);
                mat[j][i] = in.nextDouble();
                mat[mat.length - 1][i] += mat[j][i]; // total mes
            }
        }
    }

    public static double mediaMes(double[][] mat) {
        double media, total = 0;
        for (int i = 0; i < mat[0].length - 1; i++) {
            total += mat[mat.length - 1][i];
        }
        media = total / (mat[0].length - 1 * 1.0);
        return media;
    }

    public static double faturamentoFru(double[][] mat, String in, String[] fruta) {
        for (int i = 0; i < mat.length - 1; i++) {
            if (in.equalsIgnoreCase(fruta[i])) {
                for (int j = 0; j < mat[0].length - 1; j++) {
                    mat[i][mat.length - 1] += mat[i][j];
                }
                return mat[i][mat.length - 1];
            }
        }
        return -1;
    }

    public static double faturamentoMes(double[][] mat, String in, String[] mes) {
        for (int i = 0; i < mat[0].length - 1; i++) {
            if (in.equalsIgnoreCase(mes[i])) {
                return mat[mat.length - 1][i];
            }
        }
        return -1;
    }

    public static double faturamentoAno(double[][] mat) {
        double total = 0;
        for (int i = 0; i < mat[0].length - 1; i++) {
            total += mat[mat.length - 1][i];
        }
        return total;
    }

    public static void menu() {
        System.out.println(" 1-Faturamento em média por mes \n 2-Faturamento anual"
                + " da fruta \n 3-Faturamento por mes \n 4-Faturamento anual \n "
                + "0-Encerrar");
    }
}
