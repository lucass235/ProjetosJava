package listavetorparte2;
import java.util.Scanner;
public class ListaVetorParte2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        char deci;
        int voto;
        int totalV = 0;
        int[] vetorCandi = new int[10];
        exibiCandi();
        do {
            System.out.println("Informe o seu voto:");
            voto = in.nextInt();
            if (voto < 0 || voto > 8) {
                vetorCandi[9] += 1;
            } else {
                vetorCandi[voto] += 1;
            }
            System.out.println("Existe outro eleitor(a)? digite 'S' ou 'N':");
            deci = in.next().charAt(0);
            deci = Character.toLowerCase(deci);
            while (deci != 's' && deci != 'n') {
                System.out.println("Valor inválido, digite 'S' para sim ou 'N' para não:");
                deci = in.next().charAt(0);
                deci = Character.toLowerCase(deci);
            }
        } while (deci == 's');
        for (int i = 0; i < vetorCandi.length; i++) {
            totalV += vetorCandi[i];
        }
        System.out.println("O percentual de votos Brancos foi: " + (vetorCandi[0] * 100.0) / totalV + "%");
        System.out.println("O percentual de votos nulos foi: " + (vetorCandi[9] * 100.0) / totalV + "%");
        for (int i = 1; i < 9; i++) {
            System.out.println("O Percentual do candidato " + i + " foi "
                    + "" + (vetorCandi[i] * 100.0) / totalV + "%");
        }
    }
    public static void exibiCandi() {
        System.out.println(" 0 - Nulo \n 1 - João \n 2 - Maria"
                + "\n 3 - Pedro \n 4 - Luís \n 5 - Ana \n 6 - Luiza \n 7 - Silvia"
                + " \n 8 - André");
    }
}
