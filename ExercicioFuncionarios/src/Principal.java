import java.util.Scanner;

public class Principal {
    final static int TAM=5;

    public static void main(String[] args) {
        Scanner ent = new Scanner(System.in);
        Funcionario[] vet = new Funcionario[TAM];

        double soma=0;

        for (int i=0; i<TAM;i++){
            System.out.println("Digite o nome: ");
            String nome = ent.nextLine();

            System.out.println("Digite o salário: ");
            double salario = ent.nextDouble();
            ent.nextLine(); //limpeza do buffer
            soma=soma+salario;
            vet[i] = new Funcionario(nome, salario);
        }
        double media = soma / TAM;
        System.out.println("Média: "+ media);

        for (Funcionario f : vet){
            System.out.printf("Salário antigo: %.2f \n" , f.getSalario());

            if (f.getSalario()>=media)
                f.setSalario(f.getSalario()*1.05);
              else
                f.setSalario(f.getSalario()*1.10);

              System.out.printf("Salário atual: %.2f \n\n" , f.getSalario());
        }


    }

}
