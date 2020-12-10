package impresapoo;

public class Cadastro {

    private Funcionario[] f;
    private int qtd;

    public Cadastro() {
        this.f = new Funcionario[100];
    }

    public void cadastrar(Funcionario newF) {
        boolean funEncontrado = false;
        if (qtd == 0) {
            this.f[this.qtd] = newF;
            qtd++;
            System.out.println("===========================================");
            System.out.println("Funcionário cadastrado!");
            System.out.println("===========================================");
        } else {
            if (this.qtd < this.f.length) {
                for (int i = 0; i < qtd; i++) {
                    if (this.f[i].compareTo(newF) == 0) {
                        funEncontrado = true;
                        break;
                    }
                }
                if (funEncontrado == true) {
                    System.out.println("===========================================");
                    System.out.println("Funcionário já cadastrado!");
                    System.out.println("===========================================");
                } else {
                    if (this.f[qtd - 1].compareTo(newF) < 0) {
                        f[qtd] = newF;
                        qtd++;
                        System.out.println("===========================================");
                        System.out.println("Cadastro Realizado!");
                        System.out.println("===========================================");
                    } else {
                        int pontoParada = 0;
                        for (int i = 0; i < qtd; i++) {
                            if (this.f[i].compareTo(newF) > 0) {
                                pontoParada = i;
                                break;
                            }
                            for (int j = this.qtd; j > pontoParada; j--) {
                                this.f[qtd] = this.f[j - 1];
                            }
                            this.f[i] = newF;
                            qtd++;
                            System.out.println("===========================================");
                            System.out.println("Cadastro Realizado!");
                            System.out.println("===========================================");
                        }
                    }
                }
            } else {
                System.out.println("===========================================");
                System.out.println("Impresa cheia!");
                System.out.println("===========================================");
            }
        }
    }

    public void exibirTodosFun() {
        if (qtd == 0) {
            System.out.println("Impresa sem funcionário!");
        } else {
            for (int i = 0; i < qtd; i++) {
                System.out.println("===============================================");
                System.out.println(this.f[i]);
            }
        }
    }

    public int buscarFun(String m) {
        int inicio = 0, meio, fim = this.qtd - 1;
        do {
            meio = (inicio + fim) / 2;
            Funcionario f = new Funcionario(m, "", "", 0, 0);
            if (f.compareTo(this.f[meio]) == 0) {
                return meio;
            } else if (f.compareTo(this.f[meio]) > 0) {
                inicio = meio + 1;
            } else {
                fim = meio - 1;
            }
        } while (inicio <= fim);
        return -1;
    }

    public void aplicarAum(String m, double perc) {
        if (this.qtd == 0) {
            System.out.println("Impresa sem funcionário!");
        } else {
            int pos = buscarFun(m);
            if (pos == -1) {
                System.err.println("Funcionário não cadastrado!");
            } else {
                this.f[pos].alterarS(perc);
                System.out.println("Aumento atribuido!");
            }
        }
    }

    public void exibirFun(String m) {
        if (this.qtd == 0) {
            System.out.println("===========================================");
            System.out.println("Impresa sem funcionários!");
            System.out.println("===========================================");
        } else {
            int pos = buscarFun(m);
            if (pos == -1) {
                System.err.println("Funcionário não cadastrado!");
            } else {
                System.out.println(this.f[pos]);
            }
        }
    }

    public void demitirFun(String m) {
        if (this.qtd == 0) {
            System.out.println("===========================================");
            System.out.println("Impresa sem funcionário!");
            System.out.println("===========================================");
        } else {
            int pos = buscarFun(m);
            if (pos == -1) {
                System.out.println("===========================================");
                System.err.println("Funcionário não cadastrado!");
                System.out.println("===========================================");
            } else {
                for (int i = pos; i < this.qtd - 1; i++) {
                    this.f[i] = this.f[i + 1];
                    System.out.println("qtd: " + this.qtd);
                    System.out.println("i: " + i);
                }
                f[this.qtd-1] = null;
                this.qtd--;
                System.out.println("===========================================");
                System.out.println("Funcionário demitido!");
                System.out.println("===========================================");
            }
        }
    }
}
