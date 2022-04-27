public class Corrente extends Conta implements ITributavel{
   private double limiteDisponivel;

    public Corrente(String descricao, Cliente cliente, String numero, double saldo, double limiteDisponivel) {
        super(descricao, cliente, numero, saldo);
        this.limiteDisponivel = limiteDisponivel;
    }


    @Override
    public void mostrarDados() {
        System.out.println("\n Descricao: " + getDescricao() +
                           "\n Cliente: " + getCliente().getNome() +
                           "\n Numero: " + getNumero() +
                           "\n Saldo: " + getSaldo() +
                           "\n Limite: " + getLimiteDisponivel());
    }

    @Override
    public void calcularTributo() {
        double valor = getSaldo() * 0.05;
        System.out.println("Tributo: " + valor);
    }

    public double getLimiteDisponivel() {
        return limiteDisponivel;
    }

    public void setLimiteDisponivel(double limiteDisponivel) {
        this.limiteDisponivel = limiteDisponivel;
    }
}
