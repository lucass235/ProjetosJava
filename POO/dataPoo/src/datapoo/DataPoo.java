package datapoo;

import java.util.Scanner;

public class DataPoo {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int dia, mes, ano, resp;
        // primeira data.
        System.out.printf("Informe a primeira data \n");
        System.out.printf("Dia: ");
        dia = in.nextInt();
        System.out.printf("Mes: ");
        mes = in.nextInt();
        System.out.printf("Ano: ");
        ano = in.nextInt();
        Data d = new Data(dia, mes, ano);
        // segunda data
        System.out.printf("Informe a segunda data \n");
        System.out.printf("Dia: ");
        dia = in.nextInt();
        System.out.printf("Mes: ");
        mes = in.nextInt();
        System.out.printf("Ano: ");
        ano = in.nextInt();
        Data d2 = new Data(dia, mes, ano);
        do {
            System.out.printf("1-Exibir data normal\n2-Exibir data Completa"
                    + "\n3-Comparar datas\n0-Encerrar\n");
            resp = in.nextInt();
            switch (resp) {
                case 1:
                    System.out.printf("Primeira Data: %s \n", d);
                    System.out.printf("Segunda Data: %s \n", d2);
                    break;
                case 2:
                    System.out.println("primeira data:");
                    d.exibiDataCompleta();
                    System.out.println("Segunda data: ");
                    d2.exibiDataCompleta();
                    break;
                case 3:
                    if (d.compareTo(d2) == 0) {
                        System.out.println("Datas são iguais!");
                    } else if (d.compareTo(d2) == 1) {
                        System.out.println("Primeira data é maior!");
                    } else {
                        System.out.println("Segunda data é maior!");
                    }
                    break;
                case 0:
                    System.out.printf("Programa encerrado!\n");
                    break;
                default:
                    System.err.printf("Opção inválida!\n");
            }
        } while (resp != 0);
    }
}
