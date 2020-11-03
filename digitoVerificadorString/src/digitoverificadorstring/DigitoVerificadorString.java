package digitoverificadorstring;

import java.util.Scanner;

public class DigitoVerificadorString {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] val;
        int tamC, tamD;
        boolean valido, resul;
        String conta, digito;
        System.out.print("Digite sua conta: ");
        conta = in.nextLine();
        // validação conta.
        do { 
            tamC = conta.length();
            valido = true;
            if (tamC != 6) {
                valido = false;
                System.out.print("Quantidade incorreta, digite 6 números: ");
                conta = in.next();
                in.nextLine();
            } else {
                
                for (int i = 0; i < tamC; i++) {
                    if (Character.isDigit(conta.charAt(i)) == false) {
                        valido = false;
                        System.out.print("A conta só pode conte números, digite novamente: ");
                        conta = in.next();
                        in.nextLine();
                        break;
                    }
                }
            }
                   
        } while (valido == false); 
        // fim da validação conta.
        System.out.print("Digite o dígito verificador: ");
        digito = in.nextLine();
        // validação digito.
        do { 
            tamD = digito.length();
            valido = true;
            if (tamD != 1 || Character.isDigit(digito.charAt(0)) == false) {
                valido = false;
                System.out.print("valor incorreto, digite novamente: ");
                digito = in.next();
            } 
        } while (valido == false); 
        // fim da validação digito.
        val = trasformaInt(conta, digito);
        resul = calculoDigito(val);
        if (resul) {
            System.out.println("Digito verificador válido.");
        } else {
            System.err.println("Digito verificador inválido.");
        }
    }

    public static boolean calculoDigito(int[] val) {
        int dig = val[val.length-1];
        int soma = 0, resto, mod;
        for (int i = 0; i < val.length-1; i++) {
            soma += val[i] * Math.pow(2, i);
        }
        resto = soma % 11;
        
        if (resto == dig) {
            return true;
        } else {
            return false;
        }
    }

    public static int[] trasformaInt(String conta, String digito) {
        int tam;
        tam = conta.length();
        int[] val = new int[tam + 1];
        for (int i = 0; i < val.length - 1; i++) {
            val[i] = conta.charAt(i) - '0';
        }
        val[val.length - 1] = digito.charAt(0) - '0';
        return val;
    }
}
