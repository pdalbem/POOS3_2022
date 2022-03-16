public class ItensCompra {
    private Compra compra;
    private Livro livro;
    private int quantidade;
    private double valorParcial;

    public void calcularValorParcial()
    {
        this.valorParcial = this.quantidade * livro.getPreco();
    }

    public ItensCompra() {
    }

    public ItensCompra(Compra compra, Livro livro, int quantidade) {
        this.compra = compra;
        this.livro = livro;
        this.quantidade = quantidade;
    }

    public Compra getCompra() {
        return compra;
    }

    public void setCompra(Compra compra) {
        this.compra = compra;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getValorParcial() {
        return valorParcial;
    }

    public void setValorParcial(double valorParcial) {
        this.valorParcial = valorParcial;
    }
}
