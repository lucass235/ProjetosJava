package loja;

import java.util.Scanner;

public class CadastroClientes {

    private Cliente[] c;
    private int qtd;
    private boolean ordenado;

    public CadastroClientes() { // construtor.
        this.c = new Cliente[2000];
    } 

    public void ordenarCpfs() {
        int pos = 0, fim = this.qtd - 1;
        Cliente aux;
        boolean troca;
        do {
            troca = false;
            for (int i = 0; i < fim; i++) {
                if (this.c[i].compareTo(this.c[i + 1]) > 0) {
                    aux = this.c[i];
                    this.c[i] = this.c[i + 1];
                    this.c[i + 1] = aux;
                    pos = i;
                    troca = true;
                }
            }
            fim = pos - 1;
        } while (troca == true);
        this.ordenado = true;
        System.out.println("===============================================");
        System.out.println("Dados ordenados");
        System.out.println("===============================================");
    }

    public int buscarCliente(String cpf) {
        if (this.ordenado == false) {
            Cliente cli = new Cliente(cpf, "", "", "");
            for (int i = 0; i < this.qtd; i++) {
                if (this.c[i].compareTo(cli) == 0) {
                    return i;
                }
            }
            return -1;
        } else {
            int inicio = 0, meio, fim = this.qtd - 1;
            Cliente cli = new Cliente(cpf, "", "", "");
            do {
                meio = (inicio + fim) / 2;
                if (cli.compareTo(this.c[meio]) == 0) {
                    return meio;
                } else if (cli.compareTo(this.c[meio]) > 0) {
                    inicio = meio + 1;
                } else {
                    fim = meio - 1;
                }
            } while (inicio <= fim);
            return -1;
        }
    }

    public void cadastrarCliente(Cliente newC) {
        if (this.qtd == 0) {
            this.c[this.qtd] = newC;
            qtd++;
            System.out.println("===============================================");
            System.out.println("Cliente cadastrado!");
            System.out.println("===============================================");
        } else if (this.qtd == this.c.length) {
            System.out.println("===============================================");
            System.err.println("Loja cheia!");
            System.out.println("===============================================");
        } else {
            for (int i = 0; i < this.qtd; i++) {
                if (this.c[i].compareTo(newC) == 0) {
                    System.out.println("===============================================");
                    System.err.println("Esse CPF já está cadastrado!");
                    System.out.println("===============================================");
                    return;
                }
            }
            this.c[this.qtd] = newC;
            qtd++;
            System.out.println("===============================================");
            System.out.println("Cliente cadastrado!");
            System.out.println("===============================================");
        }
    }

    public void consultarCliente(String cpf) {
        int pos = buscarCliente(cpf);
        if (this.qtd == 0) {
            System.out.println("===============================================");
            System.err.println("Loja sem cliente!");
            System.out.println("===============================================");
        } else {
            if (pos == -1) {
                System.out.println("===============================================");
                System.err.println("Cliente não encontrado!");
                System.out.println("===============================================");
            } else {
                System.out.println("===============================================");
                System.out.println(this.c[pos]);
                System.out.println("===============================================");
            }
        }
    }

    public void alterarDados(String cpf) {
        Scanner in = new Scanner(System.in);
        int pos = buscarCliente(cpf), op;
        String e, t;
        if (this.qtd == 0) {
            System.out.println("===============================================");
            System.err.println("Loja sem clientes!");
            System.out.println("===============================================");
        } else {
            if (pos == -1) {
                System.out.println("===============================================");
                System.err.println("Cliente não cadastrado!");
                System.out.println("===============================================");
            } else {
                do {
                    System.out.print("O que você deseja alterar:\n1-E-mail\n2-Telefone\n");
                    op = in.nextInt();
                    in.nextLine();
                    switch (op) {
                        case 1:
                            System.out.println("===============================================");
                            System.out.print("Informe o novo e-mail: ");
                            e = in.nextLine();
                            this.c[pos].alterarEmail(e);
                            break;
                        case 2:
                            System.out.println("===============================================");
                            System.out.print("Informe o novo telefone: ");
                            t = in.nextLine();
                            this.c[pos].alterarFone(t);
                            break;
                        default:
                            System.out.println("===============================================");
                            System.err.println("Opção inválida!");
                            System.out.println("===============================================");
                    }
                } while (op != 1 && op != 2);
            }
        }
    }

    public void removerCliente(String cpf) {
        int pos = buscarCliente(cpf);
        if (this.qtd == 0) {
            System.out.println("===============================================");
            System.err.println("Loja sem clientes!");
            System.out.println("===============================================");
        } else {
            if (pos == -1) {
                System.out.println("===============================================");
                System.out.println("Cliente não cadastrado!");
                System.out.println("===============================================");
            } else {
                for (int i = pos; i < this.qtd; i++) {
                    this.c[i] = this.c[i + 1];
                }
                this.qtd--;
                System.out.println("===============================================");
                System.out.println("Cliente Removido!");
                System.out.println("===============================================");
            }
        }
    }
}
