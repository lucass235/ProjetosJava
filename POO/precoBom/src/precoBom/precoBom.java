package precoBom;

import java.util.Scanner;

public class precoBom {
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int qtd, resp, val;
        String cod, des, forn;
        double preco;
        System.out.println("Informe a quantidade de produtos: ");
        qtd = in.nextInt();
        Loja loja = new Loja(qtd);
        Produto pro;
        do {
            menu();
            resp = in.nextInt();
            in.nextLine();
            switch (resp) {
                case 1:
                    System.out.print("Informe o código do produto: ");
                    cod = in.nextLine();
                    System.out.print("Informe a descrição do produto: ");
                    des = in.nextLine();
                    System.out.print("Informe o fornecedor do produto: ");
                    forn = in.nextLine();
                    System.out.print("Informe o preço do produto: ");
                    preco = in.nextDouble();
                    System.out.print("Informe a quantidade do estoque: ");
                    val = in.nextInt();
                    pro = new Produto(cod, des, forn, preco, val);
                    loja.cadastrarProduto(pro);
                    break;
                case 2:
                    loja.exibirProdutos();
                    break;
                case 3:
                    System.out.print("Informe o código do produto: ");
                    cod = in.nextLine();
                    System.out.print("Informe o percentual de alteração: ");
                    preco = in.nextDouble();
                    System.out.print("Deseja aplicar 1-Um aumento ou 2-Um desconto: ");
                    val = in.nextInt();
                    loja.alterarPreço(cod, preco, val);
                    break;
                case 4:
                    System.out.print("Informe o código do produto: ");
                    cod = in.nextLine();
                    System.out.print("Informe a quantidado do novo estoque: ");
                    val = in.nextInt();
                    loja.atualizarEstoque(cod, val);
                    break;
                case 5:
                    System.out.print("Informe o código do produto: ");
                    cod = in.nextLine();
                    System.out.print("Informe a quantidado de venda: ");
                    val = in.nextInt();
                    loja.realizarVenda(cod, val);
                    break;
                case 0:
                    System.out.println("Obrigado por usar nosso programa!");
                    break;
                default:
                    System.out.println("Resposta inválida!");
            }
        } while (resp != 0);
    }

    public static void menu() {
        System.out.println("1-Cadastrar produto\n2-Exibir dados dos Produtos"
                + "\n3-Alterar Preço do produto\n4-Atualizar Estoque"
                + "\n5-Realizar Venda\n0-Encerrar Programa:");
    }
}
