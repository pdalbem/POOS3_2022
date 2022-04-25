public class Inquilino extends Pessoa{
    private double rendaMensal;

    @Override
    public void mostrarDadosPessoais() {
        System.out.println("\n Nome: " + this.getNome() +
                "\n CPF: " + this.getCpf() +
                "\n Telefone: " + this.getTelefone() +
                "\n Renda: " + this.rendaMensal);
    }


    public Inquilino(String nome, String cpf, String telefone, double rendaMensal) {
        super(nome, cpf, telefone);
        this.rendaMensal = rendaMensal;
    }

    public double getRendaMensal() {
        return rendaMensal;
    }

    public void setRendaMensal(double rendaMensal) {
        this.rendaMensal = rendaMensal;
    }
}
