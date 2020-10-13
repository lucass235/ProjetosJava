
package mercadinhomatriz;

import java.util.Scanner;

public class MercadinhoMatriz {

    public static void main(String[] args) {
        double[] produtos = {2.5,3.1,5.4,12.2,5.8,3.9,5.3,11.5,12.0,10.0};
        int[][] quant = new int[3][4];
        for (int i = 0; i < produtos.length; i++) {
            System.out.printf("Preço do produto %d R$%.2f %n",(i+1),produtos[i]);
        }
        preencher(quant);
        System.out.println("====================================================");
        exibirQtdProEsto(quant);
        System.out.println("====================================================");
        exibirQtdTodPro(quant);
        System.out.println("====================================================");
        exibirPreProMaiEst(quant, produtos);
        System.out.println("====================================================");
        exibirMenoEstoque(quant);
        System.out.println("====================================================");
        exibirValArm(quant, produtos);
        System.out.println("====================================================");
                
    }
    
    public static void preencher(int[][] mat){
        Scanner in = new Scanner(System.in);
        for (int j = 0; j < mat[0].length-1; j++) {
            for (int i = 0; i < mat.length-1; i++) {
                System.out.printf("Informe a quantidade do produto %d no armazem %d: ", (j+1), (i+1));
                mat[i][j] = in.nextInt();
                mat[mat.length-1][j] += mat[i][j];
            }
        }
        for (int i = 0; i < mat.length-1; i++) { // totais de produtos no armazem
            for (int j = 0; j < mat[0].length-1; j++) {
                mat[i][mat[0].length-1] += mat[i][j];
            }
        }
    }
    
    public static void exibirQtdProEsto(int[][] mat) {
        
            for (int i = 0; i < mat.length-1; i++) {
                System.out.printf("A quantidade do produto estocado no armazem %d, é: %d. %n"
                , (i+1), mat[i][mat[0].length-1]);
            }
    }
    
    public static void exibirQtdTodPro (int[][] mat) {
        for (int i = 0; i < mat[0].length-1; i++) {
            System.out.printf("A quantidado do produto %d, em todos os armazens é: %d. %n"
            , (i+1), mat[mat.length-1][i]);
        }
    }
    
    public static void exibirPreProMaiEst (int[][] mat, double[] produto) {
        int maiorIndice = 0, maior = 0;
        for (int i = 0; i < mat.length-1; i++) {
            for (int j = 0; j < mat[0].length-1; j++) {
                if (mat[i][j] > maior) {
                    maior = mat[i][j];
                    maiorIndice = j;
                }
            }
        }
        System.out.printf("O  preço do produto com maior estoque é: R$%.2f. %n", produto[maiorIndice]);
    }
    
    public static void exibirMenoEstoque (int[][] mat){
        int menor = mat[0][0],mL = 0, mC = 0;
        for (int i = 0; i < mat.length-1; i++) {
            for (int j = 0; j < mat[0].length-1; j++) {
                if (mat[i][j] < menor) {
                    menor = mat[i][j];
                    mL = i;
                    mC = j;
                }
            }
        }
        System.out.printf("O menor estoque armazenado é: %d, do produto %d no armazem %d. %n"
        , menor, (mC+1), (1+mL));
    }
    
    public static void exibirValArm (int[][] mat, double[] pro){
        double valorT;
        for (int i = 0; i < mat.length-1; i++) {
            valorT = 0;
            for (int j = 0; j < mat[0].length-1; j++) {
                valorT += pro[j] * mat[i][j];
            }
            System.out.printf("O valor armazenada no armazem %d é: R$%.2f. %n", (1+i), valorT);
        }
    }
}
