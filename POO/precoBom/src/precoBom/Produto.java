package precoBom;

public class Produto implements Comparable<Produto> {

    private String codigo, descricao, fornecedor;
    private double preco;
    private int qtdEsto;

    public Produto(String cod, String des, String forn, double pre, int qtd) {
        this.codigo = cod;
        this.descricao = des;
        this.fornecedor = forn;
        this.preco = pre;
        this.qtdEsto = qtd;
    }

    // sets.
    private void setCodigo(String newCod) {
        this.codigo = newCod;
    }

    private void setDescricao(String newDes) {
        this.descricao = newDes;
    }

    private void setFornecedor(String newForn) {
        this.fornecedor = newForn;
    }

    private void setPreco(double pre) {
        this.preco = pre;
    }

    private void setqtdEsto(int qtd) {
        this.qtdEsto = qtd;
    }

    // gets.
    private String getCodigo() {
        return this.codigo;
    }

    private String getDescricao() {
        return this.descricao;
    }

    private String getFornecedor() {
        return this.fornecedor;
    }

    private double getPreco() {
        return this.preco;
    }

    private int getqtdEsto() {
        return this.qtdEsto;
    }

    public void aplicarDesconto(double valor) {
        if (valor <= 0 || valor > 100) {
            System.err.println("Informe um porcentagem entre 0 e 100!");
        } else {
            double desc = (valor / 100.0) * this.getPreco();
            double newPreco = this.preco - desc;
            this.setPreco(newPreco);
            System.out.println("Preço atualizado: R$" + this.getPreco());
        }
    }

    public void aplicaAumento(double valor) {
        if (valor <= 0 || valor > 100) {
            System.err.println("Informe um porcentagem entre 0 e 100!");
        } else {
            double aume = (valor / 100.0) * this.getPreco();
            double newPreco = this.getPreco() + aume;
            this.setPreco(newPreco);
            System.out.println("Preço atualizado: R$" + this.getPreco());
        }
    }

    public void atualizarEstoque(int novoQtd) {
        if (novoQtd <= 0) {
            System.err.println("Informe uma quantidade maior que 0!");
        } else {
            int newEs = this.getqtdEsto() + novoQtd;
            this.setqtdEsto(newEs);
            System.out.println("Novo estoque: " + this.getqtdEsto());
        }
    }

    public void venderProduto(int novoQtd) {
        if (novoQtd <= 0) {
            System.err.println("Informe uma quantidade maior que 0!");
        } else {
            if (novoQtd > this.getqtdEsto()) {
                System.err.println("Quantidade maior do que a do estoque!");
            } else {
                int newEs = this.getqtdEsto() - novoQtd;
                this.setqtdEsto(newEs);
                System.out.println("O total a pagar é: R$" + (novoQtd * this.getPreco()));
            }
        }
    }

    public String nomeProduto() {
        return this.getDescricao();
    }

    public String toString() {
        return "Os dados do produto são: \ncodigo: " + this.getCodigo() + " \nDescrição: "
                + this.getDescricao() + " \nFornecedor: " + this.getFornecedor()
                + " \nPreço: R$" + this.getPreco() + " \nQuantidade do estoque: " + this.getqtdEsto() + "";
    }

    public int compareTo(Produto pro) {
        return this.getCodigo().compareTo(pro.getCodigo());
    }
}
