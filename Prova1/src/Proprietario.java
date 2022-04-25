import java.util.List;

public class Proprietario extends Pessoa{
    private String banco;
    private String conta;


    public Proprietario(String nome, String cpf, String telefone, String banco, String conta) {
        super(nome, cpf, telefone);
        this.banco = banco;
        this.conta = conta;
    }


    @Override
    public void mostrarDadosPessoais() {
        System.out.println("\n Nome: " + this.getNome() +
                           "\n CPF: " + this.getCpf() +
                           "\n Telefone: " + this.getTelefone() +
                           "\n Banco: " + this.banco +
                            "\n Conta: " + this.conta);
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public String getConta() {
        return conta;
    }

    public void setConta(String conta) {
        this.conta = conta;
    }
}
