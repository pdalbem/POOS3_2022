public class Poupanca extends Conta{
    private double rendimentoAnual;



    public Poupanca(String descricao, Cliente cliente, String numero, double saldo, double rendimentoAnual) {
        super(descricao, cliente, numero, saldo);
        this.rendimentoAnual = rendimentoAnual;
    }

    public double getRendimentoAnual() {
        return rendimentoAnual;
    }

    public void setRendimentoAnual(double rendimentoAnual) {
        this.rendimentoAnual = rendimentoAnual;
    }

    @Override
    public void mostrarDados() {
        System.out.println("\n Descricao: " + getDescricao() +
                "\n Cliente: " + getCliente().getNome() +
                "\n Numero: " + getNumero() +
                "\n Saldo: " + getSaldo() +
                "\n Rendimento: " + getRendimentoAnual());
    }
}
