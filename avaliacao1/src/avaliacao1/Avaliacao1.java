package avaliacao1;

import java.util.Scanner;

public class Avaliacao1 {

    public static void main(String[] args) {
        int totalD2019, totalD2020;
        int[] v2019 = new int[92];
        int[] v2020 = new int[92];
        preencher(v2019, v2020);
        totalD2019 = somaDown(v2019);
        System.out.println("Total de Downloads dos apps em 2019 " + totalD2019);
        totalD2020 = somaDown(v2020);
        System.out.println("Total de Downloads dos apps em 2019 " + totalD2020);
        comparar(v2019, v2020);
    }

    public static void preencher(int[] vet2019, int[] vet2020) {
        Scanner in = new Scanner(System.in);
        for (int i = 0; i < vet2020.length; i++) {
            System.out.printf("Quanto downloads foram feitos no app "
                    + "%d em 2019: ", (i + 1));
            vet2019[i] = in.nextInt();
            while (vet2019[i] < 0) {
                System.err.println("Quantidade inválida, digite um nº maior ou "
                        + " a (0) igual");
                vet2019[i] = in.nextInt();
            }
            System.out.printf("Quanto downloads foram feitos no app "
                    + "%d em 2020: ", (i + 1));
            vet2020[i] = in.nextInt();
            while (vet2020[i] < 0) {
                System.err.println("Quantidade inválida, digite um nº maior ou "
                        + " a (0) igual");
                vet2020[i] = in.nextInt();
            }
        }
    }

    public static int somaDown(int[] vet) {
        int total = 0;
        for (int i = 0; i < vet.length; i++) {
            total += vet[i];
        }
        return total;
    }

    public static void comparar(int[] vet2019, int[] vet2020) {
        for (int i = 0; i < vet2019.length; i++) {
            if (vet2019[i] > vet2020[i]) {
                System.out.printf("A quantidade de donwloas do app %d foi"
                        + " maior em 2019 %n", (i + 1));
            } else if (vet2019[i] < vet2020[i]) {
                System.out.printf("A quantidade de donwloas do app %d foi"
                        + " maior em 2020 %n", (i + 1));
            } else {
                System.out.printf("A quantidade de donwloas do app %d foi"
                        + " igual nos dois anos! %n", (i + 1));
            }
        }
    }
}
