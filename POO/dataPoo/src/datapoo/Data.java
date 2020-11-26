package datapoo;

public class Data implements Comparable <Data> {

    private int dia;
    private int mes;
    private int ano;

    public Data(int d, int m, int a) {
        if (a <= 0) {
            this.dia = 1;
            this.mes = 1;
            this.ano = 1;
        } else if (m <= 0 || m > 12) {
            this.dia = 1;
            this.mes = 1;
            this.ano = 1;
        } else {
            if (m == 3 || m == 6 || m == 9 || m == 11) { // meses de 30 dias
                if (d <= 0 || d >= 31) {
                    this.dia = 1;
                    this.mes = 1;
                    this.ano = 1;
                } else {
                    this.ano = a;
                    this.mes = m;
                    this.dia = d;
                }
            } else if (m == 1 || m == 4 || m == 5 || m == 7 || m == 8 || m == 10 || m == 12) { // meses de 31 dias
                if (d <= 0 || d > 31) {
                    this.dia = 1;
                    this.mes = 1;
                    this.ano = 1;
                } else {
                    this.ano = a;
                    this.mes = m;
                    this.dia = d;
                }
            } else { // mes 2, fevereiro
                boolean anoB;
                // verificação de ano bissexto.
                if (a % 4 == 0 && a % 100 != 0) {
                    anoB = true;
                } else if (a % 400 == 0) {
                    anoB = true;
                } else {
                    anoB = false;
                }
                // fim de verificação de ano bissexto.
                if (anoB == true) {
                    if (d <= 0 || d > 29) {
                        this.dia = 1;
                        this.mes = 1;
                        this.ano = 1;
                    } else {
                        this.ano = a;
                        this.mes = m;
                        this.dia = d;
                    }
                } else {
                    if (d <= 0 || d > 28) {
                        this.dia = 1;
                        this.mes = 1;
                        this.ano = 1;
                    } else {
                        this.ano = a;
                        this.mes = m;
                        this.dia = d;
                    }
                }
            }
        }
    }

    // sets.
    private void setDia(int novoD) { // atualizar dia.
        this.dia = novoD;
    }

    private void setMes(int novoM) { // atualizar mes.
        this.mes = novoM;
    }

    private void setA(int novoA) { // atulizar ano.
        this.ano = novoA;
    }
    // fim dos sets.

    // gets.
    private int getD() {
        return this.dia;
    }

    private int getM() {
        return this.mes;
    }

    private int getA() {
        return this.ano;
    }
    // fim dos gets.
    public void exibiDataCompleta() {
        switch (getM()) {
            case 1:
                System.out.printf("%d de janeiro de %d\n", getD(), getA());
                break;
            case 2:
                System.out.printf("%d de fevereiro de %d\n", getD(), getA());
                break;
            case 3:
                System.out.printf("%d de março de %d\n", getD(), getA());
                break;
            case 4:
                System.out.printf("%d de abril de %d\n", getD(), getA());
                break;
            case 5:
                System.out.printf("%d de maio de %d\n", getD(), getA());
                break;
            case 6:
                System.out.printf("%d de junho de %d\n", getD(), getA());
                break;
            case 7:
                System.out.printf("%d de julho de %d\n", getD(), getA());
                break;
            case 8:
                System.out.printf("%d de agosto de %d\n", getD(), getA());
                break;
            case 9:
                System.out.printf("%d de setembro de %d\n", getD(), getA());
                break;
            case 10:
                System.out.printf("%d de outubro de %d\n", getD(), getA());
                break;
            case 11:
                System.out.printf("%d de novembro de %d\n", getD(), getA());
                break;
            default:
                System.out.printf("%d de dezembro de %d\n", getD(), getA());
        }
    }
    
    public String toString() { // print que retorna uma string.
        return this.getD() + "/" + this.getM() + "/" + this.getA();
    }

    public int compareTo(Data d) {
        if (this.getD() == d.getD() && this.getM() == d.getM() && this.getA() == d.getA()) {
            return 0;
        } else if (this.getA() > d.getA()) {
            return 1;
        } else if (this.getA() < d.getA()) {
            return -1;
        } else if (this.getM() > d.getM()) {
            return 1;
        } else if (this.getM() < d.getM()) {
            return -1;
        } else if (this.getD() > d.getD()) {
            return 1;
        } else {
            return -1;
        }
    }
}
