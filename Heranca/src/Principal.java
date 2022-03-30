import java.util.ArrayList;
import java.util.List;

public class Principal {
    public static void main(String[] args) {

       //Polimorfismo
       Pessoa pessoaFisica1 = new PessoaFisica("1234567810",
                "Maria",
               "Rua A, n10",
               "3351-1234",
               "maria@poo.com.br");

        //Polimorfismo
       Pessoa pessoaFisica2 = new PessoaFisica("98798798711",
               "João",
               "Rua C, n15",
               "3351-4646",
               "joao@joao.com.br");

        //Polimorfismo
       Pessoa pessoaJuridica = new PessoaJuridica("111222333000190",
               "Empresa S/A",
                "Empresa XPTO",
               "Rua B, n 20",
               "3351-9090",
               "empresa@empresa.com.br");

        //Polimorfismo também  (ArrayList é do tipo List) junto com Generics (List<Pessoa>)
       List<Pessoa> lista = new ArrayList<>();
       lista.add(pessoaFisica1);
       lista.add(pessoaFisica1);
       lista.add(pessoaJuridica);

       //Embora a lista possua objetos PessoaFisica e PessoaJurica,
        // todos são tratados como Pessoa  (superclasse)
       for (Pessoa p : lista)
            p.mostrarDados(); //em tempo de execução,
                             // é decidido qual comportamento o método irá exibir
                            // dependendo do tipo do objeto (PessoaFisica ou PessoaJuridica)

    }
}
