
package loja;

import java.util.Scanner;

public class Loja {

    public static void main(String[] args) {
     Scanner in = new Scanner(System.in);
     Cliente c;
     CadastroClientes cC = new CadastroClientes();
     String cpf, n, e, f;
     int op;
        do {
            menu();
            op = in.nextInt();
            in.nextLine();
            switch (op) {
                case 1:
                    System.out.print("Infome o cpf do cliente: ");
                    cpf = in.nextLine();
                    System.out.print("Infome o nome do cliente: ");
                    n = in.nextLine();
                    System.out.print("Infome o e-mail do cliente: ");
                    e = in.nextLine();
                    System.out.print("Infome o telefone do cliente: ");
                    f = in.nextLine();
                    c = new Cliente(cpf, n, e, f);
                    cC.cadastrarCliente(c);
                    break;
                case 2:
                    cC.ordenarCpfs();
                    break;
                case 3:
                    System.out.print("Infome o cpf do cliente: ");
                    cpf = in.nextLine();
                    cC.consultarCliente(cpf);
                    break;
                case 4:
                    System.out.print("Infome o cpf do cliente: ");
                    cpf = in.nextLine();
                    cC.alterarDados(cpf);
                    break;
                case 5:
                    System.out.print("Infome o cpf do cliente: ");
                    cpf = in.nextLine();
                    cC.removerCliente(cpf);
                    break;
                case 0:
                    System.out.println("===============================================");
                    System.out.println("Programa encerrado!");
                    System.out.println("===============================================");
                    break;
                default:
                    System.out.println("===============================================");
                    System.err.println("Opção inválida!");
                    System.out.println("===============================================");
            }
        } while (op != 0);
        
    }
    public static void menu () {
        System.out.print("Escolha uma opção:\n1 - Cadastrar um cliente\n2 - "
                + "Ordenar crescente por CPF\n3 - Consultar um cliente\n"
                + "4 - Alterar os dados de um cliente\n5 - Remover um cliente\n"
                + "0 - Sair do programa\n");
    }
}
