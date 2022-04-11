public abstract class Bebida extends Produto{
    private int quantidadeEstoque;

    public Bebida(String descricao, double preco, int quantidadeEstoque) {
        super(descricao, preco);
        this.quantidadeEstoque = quantidadeEstoque;
    }

    //Como esta classe também é abstrata,
    // não precisa implementar o método mostrarDados()

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(int quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }
}
