import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        final  int TAM =7;

        int[] vetor = new int[TAM];
        int soma = 0;

        Scanner entrada = new Scanner(System.in);

        for (int i=0;i<TAM;i++){
            System.out.println("Digite o número de casos: ");
            vetor[i] = entrada.nextInt();
            soma = soma + vetor[i];

        }
        double media = (double) soma / TAM;
        System.out.println("Média: " + media);

        int cont =0;
        for (int e : vetor)
             if (e>media) {
                 System.out.println("Número de casos: " + e);
                 cont++;

             }
        System.out.println("Qtd de dias acima da média: " + cont);
    }
}
