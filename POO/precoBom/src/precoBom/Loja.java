package precoBom;

public class Loja {

    private int qtd;
    private Produto[] produtos;

    public Loja(int tam) {
        this.produtos = new Produto[tam];
    }

    public void cadastrarProduto(Produto newPro) {
        int pos;
        pos = buscarProduto(newPro);
        if (pos == -1) {
            if (this.qtd < this.produtos.length) {
                this.produtos[this.qtd] = newPro;
                this.qtd++;
                System.out.println("===========================================");
                System.out.println("produto cadastrado!");
                System.out.println("===========================================");
            } else {
                System.out.println("===========================================");
                System.out.println("Armazem cheio!");
                System.out.println("===========================================");
            }
        } else {
            System.out.println("===========================================");
            System.err.println("O produto já esta cadastrado!");
            System.out.println("===========================================");
        }
    }

    public void exibirProdutos() {
        if (qtd == 0) {
            System.err.println("Loja sem produtos");
        } else {
            for (int i = 0; i < this.qtd; i++) {
                System.out.println("Produto " + (1 + i) + ":");
                System.out.println(produtos[i]);
                System.out.println("===========================================");
            }
        }
    }

    public void alterarPreço(String codigo, double perce, int tipoAlte) {
        int pos;
        Produto pro = new Produto(codigo, "", "", 0, 0);
        pos = buscarProduto(pro);
        if (pos == -1) {
            System.out.println("===========================================");
            System.out.println("Produto não cadastrado!");
            System.out.println("===========================================");
        } else {
            switch (tipoAlte) {
                case 1:
                    this.produtos[pos].aplicaAumento(perce);
                    break;
                default:
                    this.produtos[pos].aplicarDesconto(perce);
            }
        }
    }

    public void atualizarEstoque(String codigo, int qtdEs) {
        int pos;
        Produto pro = new Produto(codigo, "", "", 0, 0);
        pos = buscarProduto(pro);
        if (pos == -1) {
            System.out.println("===========================================");
            System.out.println("Produto não cadastrado!");
            System.out.println("===========================================");
        } else {
            this.produtos[pos].atualizarEstoque(qtdEs);
        }
    }

    public void realizarVenda(String codigo, int cont) {
        int pos;
        Produto pro = new Produto(codigo, "", "", 0, 0);
        pos = buscarProduto(pro);
        if (pos == -1) {
            System.out.println("===========================================");
            System.out.println("Produto não cadastrado!");
            System.out.println("===========================================");
        } else {
            this.produtos[pos].venderProduto(cont);
        }
    }

    public int buscarProduto(Produto pro) {
        for (int i = 0; i < this.qtd; i++) {
            if (pro.compareTo(this.produtos[i]) == 0) {
                return i;
            }
        }
        return -1;
    }
}
