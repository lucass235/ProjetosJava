package livraria;

public class CadastroLivro {

    private int qtd;
    private Livro[] l;

    public CadastroLivro() {
        this.l = new Livro[500];
    }

    public void cadastro(Livro li) {
        int pos;
        if (this.qtd < this.l.length) {
            if (this.qtd == 0) {
                this.l[this.qtd] = li;
                this.qtd++;
                System.out.println("================================================");
                System.out.println("Cadastro feito!");
                System.out.println("================================================");
            } else {
                pos = this.buscarLivro(li);
                if (pos == -1) {
                    this.l[this.qtd] = li;
                    this.qtd++;
                    System.out.println("================================================");
                    System.out.println("Cadastro feito!");
                    System.out.println("================================================");
                } else {
                    System.out.println("================================================");
                    System.err.println("Cadastro não efetuado, livro já cadastrado!");
                    System.out.println("================================================");
                }
            }
        } else {
            System.out.println("================================================");
            System.out.println("Livraria cheia!");
            System.out.println("================================================");
        }
    }

    public void exibirDadosLi() {
        for (int i = 0; i < this.qtd; i++) {
            System.out.println(this.l[i]);
        }
    }

    private int buscarLivro(Livro li) {
        for (int i = 0; i < qtd; i++) {
            if (this.l[i].compareTo(li) == 0) {
                return i;
            }
        }
        return -1;
    }
    
    public  void alterarPreco (String is, double p) {
        int pos;
        Livro li = new Livro(is, " ", 0,0); 
        pos = this.buscarLivro(li);
        if (pos != -1) {
            this.l[pos].alterarPreco(p);
        } else {
            System.out.println("================================================");
            System.err.println("Livro não encontrado!");
            System.out.println("================================================");
        }
    }

}
