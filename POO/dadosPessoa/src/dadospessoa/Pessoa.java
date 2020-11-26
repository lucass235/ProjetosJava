package dadospessoa;

public class Pessoa implements Comparable<Pessoa> {

    private String nome;
    private int idade;
    private char genero;
    private double peso, altura, pesoI;

    public Pessoa(String nome, int idade, char genero, double peso, double altura) {
        this.nome = nome;
        this.idade = idade;
        this.genero = genero;
        this.peso = peso;
        this.altura = altura;
    }

    private void setNome(String newNome) {
        this.nome = newNome;
    }

    private void setIdade(int newIdade) {
        this.idade = newIdade;
    }

    private void setGenero(char newGenero) {
        this.genero = newGenero;
    }

    private void setPeso(double newPeso) {
        this.peso = newPeso;
    }

    private void setPesoI(double newPesoI) {
        this.pesoI = newPesoI;
    }

    private void setAltura(double newAltura) {
        this.altura = newAltura;
    }

    // gets.
    private String getNome() {
        return this.nome;
    }

    private int getIdade() {
        return this.idade;
    }

    private char getGenero() {
        return this.genero;
    }

    private double getPeso() {
        return this.peso;
    }

    private double getPesoI() {
        return this.pesoI;
    }

    private double getAltura() {
        return this.altura;
    }

    public void atualizarAltura(Double altu) {
        double novoPesoI;
        if (altu < 0.5 || altu > 2.0) {
            System.err.println("Altura inválida");
        } else {
            this.setAltura(altu);
            novoPesoI = this.getPeso() / Math.pow(this.getAltura(), 2);
            this.setPesoI(novoPesoI);
            System.out.println("Novo Altura: " + this.getAltura());
        }
    }

    public void atualizarPeso(Double peso) {
        double novoPesoI;
        if (peso < 3 || peso > 200) {
            System.err.println("Peso inválida");
        } else {
            this.setPeso(peso);
            novoPesoI = this.getPeso() / Math.pow(this.getAltura(), 2);
            this.setPesoI(novoPesoI);
            System.out.println("Novo Peso: " + this.getPeso());
        }
    }

    public void atualizarIdade(int idade) {
        if (idade < 0 || idade > 130) {
            System.err.println("Idade inválida");
        } else {
            this.setIdade(idade);
            System.out.println("Nova Idade: " + this.getIdade());
        }
    }

    public String nomePessoa() {
        return this.getNome();
    }

    public String toString() {
        return "Dados de " + this.getNome() + ": \nGênero: " + this.getGenero()
                + " \nIdade: " + this.getIdade() + " \nAltura: " + this.getAltura()
                + " \nPeso: " + this.getPeso();
    }

    public int compareTo(Pessoa pes) {
        return 0;
    }
}
