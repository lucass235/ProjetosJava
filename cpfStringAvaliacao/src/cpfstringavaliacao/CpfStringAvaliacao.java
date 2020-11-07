package cpfstringavaliacao;

import java.util.Scanner;

public class CpfStringAvaliacao {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String cpf;
        int resp;
        boolean valido;
        do {
            menu();
            resp = in.nextInt();
            in.nextLine();
            switch (resp) {
                case 1:
                    System.out.println("Informe um cpf");
                    cpf = in.nextLine();
                    valido = validarCpf(cpf);
                    if (valido) {
                        System.out.println("============================================");
                        System.out.println("O CPF digitado é válido!");
                        System.out.println("============================================");
                    } else {
                        System.out.println("============================================");
                        System.err.println("CPF digitado inválido!!");
                        System.out.println("============================================");
                    }
                    break;
                case 0:
                    System.out.println("Obrigado por usar nosso programa, até a proxima!!");
                    break;
                default:
                    System.out.println("Valor inválido, digite 1 ou 0");
            }
        } while (resp != 0);
    }

    public static boolean validarCpf(String cpf) {
        int[] num;
        int tam, digito1, digito2, soma = 0, resto, val;
        tam = cpf.length();
        char carac;
        if (tam != 11) {
            return false;
        } else {
            for (int i = 0; i < tam; i++) {
                carac = cpf.charAt(i);
                if (Character.isDigit(carac) == false) {
                    return false;
                }
            }
            num = converteInt(cpf);
            // calculo do 1º digito
            soma = 0;
            digito1 = num[num.length - 2];
            for (int i = 0; i < 9; i++) {
                soma += num[i] * (10 - i);
            }
            resto = soma % 11;
            if (resto < 2) {
                val = 0;
            } else {
                val = 11 - resto;
            }

            if (val == digito1) {
                // calculo 2º digito
                soma = 0;
                digito2 = num[num.length - 1];
                for (int i = 0; i < 10; i++) {
                    soma += num[i] * (11 - i);
                }
                resto = soma % 11;

                if (resto < 2) {
                    val = 0;
                } else {
                    val = 11 - resto;
                }
                if (val == digito2) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
    }

    public static int[] converteInt(String cpf) {
        int tam;
        char carac;
        tam = cpf.length();
        int[] valores = new int[tam];
        for (int i = 0; i < valores.length; i++) {
            carac = cpf.charAt(i);
            valores[i] = carac - '0';
        }
        return valores;
    }

    public static void menu() {
        System.out.println("Informe uma opção:\n1-Consultar CPF\n0-Sair");
    }
}
