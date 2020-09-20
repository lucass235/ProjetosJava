package jogodedadosvetor;

import java.util.Random;

public class JogoDeDadosVetor {

    public static void main(String[] args) {
        int[] faces = new int[6]; // criação do vetor de faces
        Random gerador = new Random(); // criação do gerador de nº aleatorios
        System.out.println("Um dado foi lançado 1.000.000 de vezes, a seguir são mostrado"
                + "a ocorrência de cada face");
        for (int i = 0; i < 1000000; i++) { // vezes de repetição de faces jogadas
            int valores = gerador.nextInt(6) + 1; // variavel pra armazenar o gerador
            switch (valores) { // casos de faces exibidas(contador)
                case 1:
                    faces[0]++;
                    break;
                case 2:
                    faces[1]++;
                    break;
                case 3:
                    faces[2]++;
                    break;
                case 4:
                    faces[3]++;
                    break;
                case 5:
                    faces[4]++;
                    break;
                default:
                    faces[5]++;
            }
        }
        for (int i = 0; i < faces.length; i++) {
            System.out.println("A face " + (i + 1) + " Apareceu " + faces[i] + " Vezes.");
        }
    }

}
