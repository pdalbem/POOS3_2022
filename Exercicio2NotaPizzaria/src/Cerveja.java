public class Cerveja extends Bebida{
    private double teorAlcoolico;

    //sobrecrita do método
    @Override
    public void mostrarDados() {
        System.out.println("\n Descrição: "+ this.getDescricao() +
                          "\n Preço: " + this.getPreco() +
                          "\n Estoque: " +this.getQuantidadeEstoque() +
                          "\n Teor alcoólico: " + this.getTeorAlcoolico());
    }

    public Cerveja(String descricao, double preco, int quantidadeEstoque, double teorAlcoolico) {
        super(descricao, preco, quantidadeEstoque);
        this.teorAlcoolico = teorAlcoolico;
    }

    public double getTeorAlcoolico() {
        return teorAlcoolico;
    }

    public void setTeorAlcoolico(double teorAlcoolico) {
        this.teorAlcoolico = teorAlcoolico;
    }
}
