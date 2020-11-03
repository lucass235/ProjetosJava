package placastring;

import java.util.Scanner;

public class PlacaString {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String placa;
        boolean valida;
        System.out.println("Digite a placa");
        placa = in.nextLine();
        valida = placaValida(placa);
        if (valida == false) {
            System.err.println("A placa não é válida!");
        } else {
            System.out.printf("A placa %s é válida! %n", placa);
        }
    }

    public static boolean placaValida(String placa) {
        int tam;
        char car;
        tam = placa.length();
        if (tam != 7) {
            return false;
        } else {
            for (int i = 0; i < tam; i++) {
                car = placa.charAt(i);
                if (Character.isDigit(car) == false) { // é uma letra ou um numero.
                    if (Character.isLetter(car) == false) {
                        return false;
                    }
                }
            }
            for (int i = 0; i < tam; i++) { // validação dos digitos letra e digito.
                car = placa.charAt(i);
                if (i < 3) {
                    if (Character.isLetter(car) == false) {
                        return false;
                    }
                } else {
                    if (Character.isDigit(car) == false) {
                        return false;
                    }
                }
            }
        }
        return true; // placa valida
    }
}
