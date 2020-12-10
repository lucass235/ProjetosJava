package impresapoo;

public class Funcionario implements Comparable <Funcionario> {

    private String matricula;
    private String nome;
    private String cargo;
    private double salario;
    private int anoContra;

    public Funcionario(String m, String n, String c, double s, int a) {
        this.matricula = m;
        this.nome = n;
        this.cargo = c;
        this.salario = s;
        this.anoContra = a;
    }
    private void setNome(String n) {
        this.nome = n;
    }
    private void setMatricula(String m) {
        this.matricula = m;
    }
    private void setCargo(String c) {
        this.cargo = c;
    }
    private void setSalario(double s) {
        this.salario = s;
    }
    private void setAnoContra(int a) {
        this.anoContra = a;
    }
    
    private String getNome () {
        return this.nome;
    }
    private String getCargo () {
        return this.cargo;
    }
    private String getMatricula () {
        return this.matricula;
    }
    private double getSalario () {
        return this.salario;
    }
    private int getAnoContra () {
        return this.anoContra;
    }
    
    public void alterarS (double perc) {
        double aumento;
        if (perc < 0) {
            System.err.println("Percentual inválido!");
        } else {
            aumento = this.getSalario() * (perc/100.0);
            aumento += this.getSalario();
            this.setSalario(aumento);
            System.out.println("Salário alterado!");
        }
    }

    @Override
    public String toString() {
        String dados, n, m, c, s, a;
        n =  this.nome + "\n";
        m = "Matrícula: " + this.matricula + "\n";
        c = "Cargo: " + this.cargo + "\n";
        s = "Sálario: " + this.salario + "\n";
        a = "Ano de contratação: " + this.anoContra + "\n";
        dados = "Dados de " + n + m + c + s + a;
        return dados;
    }

    @Override
    public int compareTo(Funcionario f) {
        return this.getMatricula().compareTo(f.getMatricula());
    }
}
