
package livraria;

public class Livro implements Comparable <Livro> {
    private String isbn;
    private String titulo;
    private double preco;
    private int estoque;
    public Livro (String is, String t, double p, int e) {
        this.isbn = is;
        this.titulo = t;
        this.preco = p;
        this.estoque = e;
    }
    
    private String getIsbn() {
        return this.isbn;
    }
    
    private void setIsbn(String is) {
        this.isbn = is;
    }
    
    private String getTitulo() {
        return this.titulo;
    }
    
    private void setTitulo(String t) {
        this.titulo = t;
    }
    
    private double getPreco() {
        return this.preco;
    }
    
    private void setPreco(double p) {
        this.preco = p;
    }
    
    private int getEstoque() {
        return this.estoque;
    }
    
    private void setEstoque(int i) {
        this.estoque = i;
    }
    
    public void alterarPreco (double p) {
        if (p <=0) {
            System.err.println("Preço inválido!");
        } else {
            this.setPreco(p);
            System.out.println("================================================");
            System.out.println("Preço alterado");
            System.out.println("================================================");
        }
    }
    
    public String toString () {
        
        return " "+this.getIsbn() + " " + this.getTitulo() + " " + this.getEstoque() + " " + this.getPreco();
    }
    
    public int compareTo(Livro l) {
        return this.getIsbn().compareTo(l.getIsbn());
    }
}
