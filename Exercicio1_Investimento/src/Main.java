import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.println("Digite o Capital Inicial");
        double capitalInicial = entrada.nextDouble();

        System.out.println("Digite a taxa de juros");
        double taxaJuros = entrada.nextDouble();

        System.out.println("Digite o tempo da aplicação");
        int tempo = entrada.nextInt();

        double montante = capitalInicial * Math.pow((1+taxaJuros),tempo);

        System.out.printf("Montante: %.2f", montante);
    }

}
