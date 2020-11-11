package avaliacaostring;

import java.util.Scanner;

public class AvaliacaoString {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String frase;
        int valido;
        System.out.println("Digite o codigo");
        frase = in.nextLine();
        valido = validarCodigo(frase);
        if (valido == 1) {
            System.out.println("Codigo válido!");
        } else if (valido == 2) {
            System.err.println("Código com quantidade inválida de caracteres.");
        } else {
            System.err.println("Código com formato inválido.");
        }
    }
    
    public static int validarCodigo(String cod) {
        int tam;
        tam = cod.length();
        char carc;
        if (tam != 9) { // validação tamanho.
            return 2;
        } else {
            for (int i = 0; i < tam; i++) {
                carc = cod.charAt(i);
                if (i < 4) { // validação letras com A no inicio.
                    if (Character.isLetter(carc) == false) {
                        return 3;
                    } else {
                        if (Character.isLetter(carc) == true) {
                            if (i == 0) {
                                if (Character.toUpperCase(carc) != 'A') {
                                    return 3;
                                }
                            }
                        }
                    }
                } else { // validação dos numeros.
                    if (Character.isDigit(carc) == false) {
                        return 3;
                    }
                }
            }
        }

        return 1; // codigo valido!
    }
}
