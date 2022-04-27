public abstract class Produto implements IPrint{
    private String descricao;
    private Cliente cliente;

    public Produto(String descricao, Cliente cliente) {
        this.descricao = descricao;
        this.cliente = cliente;
    }

    public Produto(){}

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
