package armazem;

import java.util.Scanner;

public class Armazem {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String cod, des, forn;
        double pre, valor;
        int qtdE, resp, inQtd, qtdP, num;
        System.out.println("Informe quantos produtos serão registrados: ");
        qtdP = in.nextInt();
        in.nextLine();
        Produto[] produtos = new Produto[qtdP];
        for (int i = 0; i < qtdP; i++) {
            System.out.print("Informe o código do produto " + (1 + i) + ": ");
            cod = in.nextLine();
            System.out.print("Informe a descrição do produto " + (1 + i) + ": ");
            des = in.nextLine();
            System.out.print("Informe o fornecedor do produto " + (1 + i) + ": ");
            forn = in.nextLine();
            System.out.print("Informe o preço do produto " + (1 + i) + ": ");
            pre = in.nextDouble();
            System.out.print("Informe a quantidade do estoque do produto " + (1 + i) + ": ");
            qtdE = in.nextInt();
            in.nextLine();
            produtos[i] = new Produto(cod, des, forn, pre, qtdE);
        }
        System.out.println("==================================================");
        for (int i = 0; i < qtdP; i++) {
            System.out.println("Produto "+(i+1)+": "+produtos[i].nomeProduto());
            System.out.println(produtos[i]);
            System.out.println("==================================================");
        }
        

        do {
            System.out.println("1-Aplicar desconto \n2-Aplicar aumento \n3-Atualizar estoque"
                    + " \n4-Vender produto\n0-Finalizar");
            resp = in.nextInt();
            switch (resp) {
                case 1:
                    System.out.println("Informe a numeração do produto: ");
                    num = in.nextInt();
                    System.out.print("Informe a porcentagem do desconto: ");
                    valor = in.nextDouble();
                    produtos[num-1].aplicarDesconto(valor);
                    break;
                case 2:
                    System.out.println("Informe a numeração do produto: ");
                    num = in.nextInt();
                    System.out.print("Informe a porcentagem do aumento: ");
                    valor = in.nextDouble();
                    produtos[num-1].aplicaAumento(valor);
                    break;
                case 3:
                    System.out.println("Informe a numeração do produto: ");
                    num = in.nextInt();
                    System.out.print("Informe a quantidade do produto para o estoque: ");
                    inQtd = in.nextInt();
                    produtos[num-1].atualizarEstoque(inQtd);
                    break;
                case 4:
                    System.out.println("Informe a numeração do produto: ");
                    num = in.nextInt();
                    System.out.print("Informe a quantidade do produto vendido: ");
                    inQtd = in.nextInt();
                    produtos[num-1].venderProduto(inQtd);
                    break;
                            
                case 0:
                    
                    System.out.println("Até mais");
                    break;
                default:
                    System.err.print("Resposta inválida!");
            }
        } while (resp != 0);

    }

}
