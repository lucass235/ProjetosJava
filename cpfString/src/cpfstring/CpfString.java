package cpfstring;

import java.util.Scanner;

public class CpfString {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String cpf;
        boolean resul ;
        System.out.println("Digite seu CPF: ");
        cpf = in.nextLine();
        resul = validacaoCpf(cpf);
        if (resul == false) {
            System.err.println("CPF inválido!");
        }  else {
            exibir(cpf);
            System.out.println("CPF válido!");
        }
    }

    public static boolean validacaoCpf(String cpf) {
        int tam;
        char valor;
        boolean veri = false;
        tam = cpf.length();
        if (tam != 11) {
            return false;
        } else {
            for (int i = 0; i < tam; i++) {
                valor = cpf.charAt(i); // cpf = l92.609.704.07
                if (Character.isLetter(valor) || Character.isSpaceChar(valor)) {
                    return false;
                } else if (Character.isDigit(valor)) {
                    veri = true;
                } else {
                    return false;
                }
            }
        }
        return veri; // cpf valido!
    }
    
    public static void exibir (String cpf) {
       int tam;
       char valor;
       tam = cpf.length();
        for (int i = 0; i < tam; i++) { // cpf = 092.6097.040-07
            valor = cpf.charAt(i);
            if (i== 3 || i == 6 ) {
                System.out.print(".");
                System.out.print(valor);
            } else if (i == 9)  {
                System.out.print("-");
                System.out.print(valor);
            } else{
                System.out.print(valor);
            }
        }
        System.out.println();
    }
}
