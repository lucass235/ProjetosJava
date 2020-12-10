package livraria;

import java.util.Scanner;

public class Livraria {

    public static void main(String[] args) {
        Scanner in = new Scanner (System.in);
        CadastroLivro ca = new CadastroLivro();
        Livro li;
        String isbn, titulo;
        double preco;
        int estoque, op;
        do {
            menu();
            op = in.nextInt();
            in.nextLine();
            switch(op) {
                case 1:
                    System.out.print("Informe o ISBN do livro: ");
                    isbn = in.nextLine();
                    System.out.print("Informe o título do livro: ");
                    titulo = in.nextLine();
                    System.out.print("Informe o preco do livro: ");
                    preco = in.nextDouble();
                    System.out.print("Informe o estoque do livro: ");
                    estoque = in.nextInt();
                    li = new Livro(isbn, titulo, preco, estoque);
                    ca.cadastro(li);
                    break;
                case 2:
                    ca.exibirDadosLi();
                    break;
                case 3:
                    System.out.print("Informe o ISBN do livro: ");
                    isbn = in.nextLine();
                    System.out.print("Informe o preco do livro: ");
                    preco = in.nextDouble();
                    ca.alterarPreco(isbn, preco);
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
        System.out.println("1-Cadastrar Livro\n2-ExibirLivros Cadastrados"
                + "\n3-Alterar Preço de um livro\n0-Sair do programa");
    }
}
