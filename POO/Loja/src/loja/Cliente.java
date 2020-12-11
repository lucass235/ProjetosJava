package loja;

public class Cliente implements Comparable<Cliente> {

    private String cpf;
    private String nome;
    private String email;
    private String fone;

    public Cliente(String c, String n, String e, String f) {
        this.cpf = c;
        this.nome = n;
        this.email = e;
        this.fone = f;
    }

    private void setCpf(String c) {
        this.cpf = c;
    }

    private void setNome(String n) {
        this.nome = n;
    }

    private void setEmail(String e) {
        this.email = e;
    }

    private void setFone(String f) {
        this.fone = f;
    }

    private String getCpf() {
        return this.cpf;
    }

    private String getNome() {
        return this.nome;
    }

    private String getEmail() {
        return this.email;
    }

    private String getFone() {
        return this.fone;
    }
    
    public void alterarEmail (String newE) {
        boolean valido;
        char c;
        int qtdA = 0;
        int tam = newE.length();
        valido = true;
        for (int i = 0; i < tam; i++) {
            c = newE.charAt(i);
            if (Character.isLetter(c) == false) {
                if (Character.isDigit(c) == false) {
                    if (c != '.') {
                        if (c != '@') {
                            valido = false;
                            break;
                        } else {
                            qtdA++;
                        }
                    }
                }
            } 
        }
        if (valido == true && qtdA == 1) {
            this.setEmail(newE);
            System.out.println("===============================================");
            System.out.println("E-mail Alterado!");
            System.out.println("===============================================");
        } else {
            System.out.println("===============================================");
            System.err.println("E-mail Inválido!");
            System.out.println("===============================================");
        }
    }
    
    public void alterarFone (String newF) {
        int tam = newF.length();
        boolean valido = true;
        char c;
        for (int i = 0; i < tam; i++) {
            c = newF.charAt(i);
            if (Character.isDigit(c)== false) {
                valido = false;
                System.out.println("===============================================");
                System.err.println("Fone inválido!");
                System.out.println("===============================================");
                break;
            }
            if (valido == true) {
                this.setFone(newF);
                System.out.println("===============================================");
                System.out.println("Fone Alterado!");
                System.out.println("===============================================");
            }
        }
    }

    public String toString() {
        String dados;
        dados = "CPF: " + this.getCpf()+"\n";
        dados += "Nome: " + this.getNome() +"\n";
        dados += "Telefone: " + this.getFone() +"\n";
        dados += "E-mail: " + this.getEmail() +"\n";
        return dados;
    }

    public int compareTo(Cliente c) {
        return this.getCpf().compareTo(c.getCpf());
    }
    
}
