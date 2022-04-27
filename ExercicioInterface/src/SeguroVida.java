public class SeguroVida extends Produto implements ITributavel{
    private double premio;

    public SeguroVida(String descricao, Cliente cliente, double premio) {
        super(descricao, cliente);
        this.premio = premio;
    }

    public double getPremio() {
        return premio;
    }

    public void setPremio(double premio) {
        this.premio = premio;
    }

    @Override
    public void mostrarDados() {
        System.out.println("\n Descricao: " + getDescricao() +
                "\n Cliente: " + getCliente().getNome() +
                "\n Premio: " + getPremio());
    }

    @Override
    public void calcularTributo() {
        double valor = premio * 0.10;
        System.out.println("Tributo: " + valor);
    }
}
