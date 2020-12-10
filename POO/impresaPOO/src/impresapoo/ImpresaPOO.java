
package impresapoo;

import java.util.Scanner;

public class ImpresaPOO {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Cadastro cadas = new Cadastro();
        Funcionario f;
        int op, ano;
        String matricula, nome, cargo;
        double salario, perc;
        do {
            menu();
            op = in.nextInt();
            in.nextLine();
            switch(op) {
                case 1:
                    System.out.print("Informe a matrícula do funcionário: ");
                    matricula = in.nextLine();
                    System.out.print("Informe o nome do funcionário: ");
                    nome = in.nextLine();
                    System.out.print("Informe o cargo do funcionário: ");
                    cargo = in.nextLine();
                    System.out.print("Informe o salário do funcionário: ");
                    salario = in.nextDouble();
                    System.out.print("Informe o ano de contratação do funcionário: ");
                    ano = in.nextInt();
                    f = new Funcionario(matricula, nome, cargo, salario, ano);
                    cadas.cadastrar(f);
                    break;
                case 2:
                    cadas.exibirTodosFun();
                    break;
                case 3:
                    System.out.print("Informe a matrícula do funcionário: ");
                    matricula = in.nextLine();
                    System.out.print("Informe o percentual do aumento: ");
                    perc = in.nextDouble();
                    cadas.aplicarAum(matricula, perc);
                    break;
                case 4:
                    System.out.print("Informe a matrícula do funcionário: ");
                    matricula = in.nextLine();
                    cadas.exibirFun(matricula);
                    break;
                case 5:
                    System.out.print("Informe a matrícula do funcionário: ");
                    matricula = in.nextLine();
                    cadas.demitirFun(matricula);
                    break;
                case 0:
                    System.out.println("Programa encerrado!");
                    break;
                default:
                    System.err.println("Opção inválida!");
            }
        } while (op != 0);
        
        
    }
    public static void menu() {
        System.out.println("Informe uma opção:");
        System.out.print("1-cadastar funcionário\n2-Exibir dados dos funcionários"
                + "\n3-Aplicar aumento\n4-Exibir dados de 1 funcionário\n"
                + "5-Demitir funcionário\n0-Encerrar programa\n");
    }
}
