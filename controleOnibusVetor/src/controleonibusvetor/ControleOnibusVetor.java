package controleonibusvetor;

import java.util.Scanner;

public class ControleOnibusVetor {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        char fileira, deci, passa;
        int poltrona;
        boolean fA, fB, fC, fD;
        boolean[] A = new boolean[13]; // vetor de acentos na janela
        boolean[] B = new boolean[13]; // vetor de acentos no corredor
        boolean[] C = new boolean[13]; // vetor de acentos na janela
        boolean[] D = new boolean[13]; // vetor de acentos no corredor
        System.out.println("Bem vindo ao ônibus Viagem Bem com destino Recife-Fortaleza!");
        System.out.println("A seguir é mostrados os acentos livre(false) e os ocupados(true)");
        exibiAcentos(A, B, C, D);
        do {
            System.out.print("Escolha sua preferência do lugar , na janela(J) ou no corredor(C): ");
            deci = in.next().charAt(0);
            deci = Character.toLowerCase(deci);
            while (deci != 'j' && deci != 'c') {
                System.out.println("Resposta invalida, digite 'J' (janela) ou 'C' (corredor): ");
                deci = in.next().charAt(0);
                deci = Character.toLowerCase(deci);
            }
            fA = veriFile(A);
            fB = veriFile(B);
            fC = veriFile(C);
            fD = veriFile(D);
            if (deci == 'j' && (fA == false || fC == false)) {
                System.out.print("escolha a fileira A ou C: ");
                fileira = in.next().charAt(0);
                fileira = Character.toLowerCase(fileira);
                while (fileira != 'a' && fileira != 'c') {
                    System.out.println("Resposta invalida, digite a fileira 'A'  ou 'C' : ");
                    fileira = in.next().charAt(0);
                    fileira = Character.toLowerCase(fileira);
                }
                System.out.print("Escolha uma poltrona: ");
                poltrona = in.nextInt();
                while (poltrona < 1 || poltrona > 12) {
                    System.out.println("Resposta invalida, digite o nº no intervalo de 1 à 12 : ");
                    poltrona = in.nextInt();
                }
                while (fileira =='a' && A[poltrona] == true ) {
                    System.out.println("Esse acento  ja está ocupado, informe outra lugar:");
                    System.out.print("escolha a fileira A ou C: ");
                    fileira = in.next().charAt(0);
                    fileira = Character.toLowerCase(fileira);
                    while (fileira != 'a' && fileira != 'c') {
                        System.out.println("Resposta invalida, digite a fileira 'A'  ou 'C' : ");
                        fileira = in.next().charAt(0);
                        fileira = Character.toLowerCase(fileira);
                    }
                    System.out.print("Escolha uma poltrona: ");
                    poltrona = in.nextInt();
                    while (poltrona < 1 || poltrona > 12) {
                        System.out.println("Resposta invalida, digite o nº no intervalo de 1 à 12 : ");
                        poltrona = in.nextInt();
                    }
                }
                 while (fileira =='c' && C[poltrona] == true ) {
                    System.out.println("Esse acento ja está ocupado, informe outra lugar:");
                    System.out.print("escolha a fileira A ou C: ");
                    fileira = in.next().charAt(0);
                    fileira = Character.toLowerCase(fileira);
                    while (fileira != 'a' && fileira != 'c') {
                        System.out.println("Resposta invalida, digite a fileira 'A'  ou 'C' : ");
                        fileira = in.next().charAt(0);
                        fileira = Character.toLowerCase(fileira);
                    }
                    System.out.print("Escolha a poltrona: ");
                    poltrona = in.nextInt();
                    while (poltrona < 1 || poltrona > 12) {
                        System.out.println("Resposta invalida, digite o nº no intervalo de 1 à 12 : ");
                        poltrona = in.nextInt();
                    }
                }
                if (fileira == 'a') {
                    A[poltrona] = true;
                } else {
                    C[poltrona] = true;
                }
            } else if (deci == 'c' && (fB == false || fD == false)) {
                System.out.print("escolha a fileira B ou D: ");
                fileira = in.next().charAt(0);
                fileira = Character.toLowerCase(fileira);
                while (fileira != 'b' && fileira != 'd') {
                    System.out.println("Resposta invalida, digite a fileira 'B'  ou 'D' : ");
                    fileira = in.next().charAt(0);
                    fileira = Character.toLowerCase(fileira);
                }
                System.out.print("Escolha a poltrona: ");
                poltrona = in.nextInt();
                while (poltrona < 1 || poltrona > 12) {
                    System.out.println("Resposta invalida, digite o nº no intervalo de 1 à 12 : ");
                    poltrona = in.nextInt();
                }
                while (fileira =='b' && B[poltrona] == true ) {
                    System.out.println("Esse acento ja está ocupado, informe outra lugar:");
                    System.out.print("escolha a fileira B ou D: ");
                    fileira = in.next().charAt(0);
                    fileira = Character.toLowerCase(fileira);
                    while (fileira != 'b' && fileira != 'd') {
                        System.out.println("Resposta invalida, digite a fileira 'B'  ou 'D' : ");
                        fileira = in.next().charAt(0);
                        fileira = Character.toLowerCase(fileira);
                    }
                    System.out.print("Escolha a poltrona: ");
                    poltrona = in.nextInt();
                    while (poltrona < 1 || poltrona > 12) {
                        System.out.println("Resposta invalida, digite o nº no intervalo de 1 à 12 : ");
                        poltrona = in.nextInt();
                    }
                }
                 while (fileira =='d' && D[poltrona] == true ) {
                    System.out.println("Esse acento  ja está ocupado, informe outra lugar:");
                    System.out.print("escolha a fileira B ou D: ");
                    fileira = in.next().charAt(0);
                    fileira = Character.toLowerCase(fileira);
                    while (fileira != 'b' && fileira != 'd') {
                        System.out.println("Resposta invalida, digite a fileira 'B'  ou 'D' : ");
                        fileira = in.next().charAt(0);
                        fileira = Character.toLowerCase(fileira);
                    }
                    System.out.print("Escolha a poltrona: ");
                    poltrona = in.nextInt();
                    while (poltrona < 1 || poltrona > 12) {
                        System.out.println("Resposta invalida, digite o nº no intervalo de 1 à 12 : ");
                        poltrona = in.nextInt();
                    }
                }
                if (fileira == 'b') {
                    B[poltrona] = true;
                } else {
                    D[poltrona] = true;
                }
            } else if(deci == 'j' && fA == true && fC == true && (fB == false || fD == false)){
                System.out.println("Os acentos da janela estão cheios!");
            }else if (deci == 'c' && fB == true && fD == true && (fA == false || fC == false)) {
                System.out.println("Os acentos do corredor estão cheios!");
            } else{
                System.out.println("Infelismente o onibus esta cheio, desculpe!");
                System.exit(0);
            }
            exibiAcentos(A, B, C, D);
            System.out.println("Existe mais passageiros? digite 'S' ou 'N'");
            passa = in.next().charAt(0);
            passa = Character.toLowerCase(passa);
            while (passa != 's' && passa != 'n') {
                System.out.println("Resposta invalida, digite 'S' para sim ou 'N' para não: ");
                passa = in.next().charAt(0);
                passa = Character.toLowerCase(passa);
            }
        } while (passa == 's');
        System.out.println("Boa viagem!");
    }

    public static void exibiAcentos(boolean[] A, boolean[] B, boolean[] C, boolean[] D) {
        System.out.println("     A(j)    B(C)            D(C)    C(J)");
        for (int i = 1; i < A.length; i++) {
            System.out.println(i + "   " + A[i] + "   " + B[i] + "           "
                    + D[i] + "   " + C[i]);
        }
    }

    public static boolean veriFile(boolean[] v) {
        boolean deci = true;
        for (int i = 1; i < v.length; i++) {
            if (v[i] == false) {
                deci = false;
            }
        }
        return deci;
    }
}
