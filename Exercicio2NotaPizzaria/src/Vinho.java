public class Vinho extends Bebida{
    private String uva;
    private String paisOrigem;

    //sobrescrita
    @Override
    public void mostrarDados() {
        System.out.println("\n Descrição: "+ this.getDescricao() +
                "\n Preço: " + this.getPreco() +
                "\n Estoque: " +this.getQuantidadeEstoque() +
                "\n Uva: " + this.getUva() +
                "\n Origem: " + this.getPaisOrigem());
    }

    public Vinho(String descricao, double preco, int quantidadeEstoque, String uva, String paisOrigem) {
        super(descricao, preco, quantidadeEstoque);
        this.uva = uva;
        this.paisOrigem = paisOrigem;
    }

    public String getUva() {
        return uva;
    }

    public void setUva(String uva) {
        this.uva = uva;
    }

    public String getPaisOrigem() {
        return paisOrigem;
    }

    public void setPaisOrigem(String paisOrigem) {
        this.paisOrigem = paisOrigem;
    }
}
