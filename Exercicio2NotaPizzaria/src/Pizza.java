import java.util.List;

public class Pizza extends Produto{
    private boolean bordaRecheada;
    private List<Ingrediente> ingredientes;

    //sobrescrita
    @Override
    public void mostrarDados() {
        System.out.println("\n Descrição: "+ this.getDescricao() +
                "\n Preço: " + this.getPreco() +
                "\n Borda recheada: " + this.isBordaRecheada());
        //Para mostrar os ingredientes, é preciso percorrer a lista
        for (Ingrediente i : this.ingredientes)
            System.out.println(i.getNome());
    }

    public Pizza(String descricao, double preco, boolean bordaRecheada) {
        super(descricao, preco);
        this.bordaRecheada = bordaRecheada;
    }

    public Pizza(String descricao, double preco, boolean bordaRecheada, List<Ingrediente> ingredientes) {
        super(descricao, preco);
        this.bordaRecheada = bordaRecheada;
        this.ingredientes = ingredientes;
    }

    public boolean isBordaRecheada() {
        return bordaRecheada;
    }

    public void setBordaRecheada(boolean bordaRecheada) {
        this.bordaRecheada = bordaRecheada;
    }

    public List<Ingrediente> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(List<Ingrediente> ingredientes) {
        this.ingredientes = ingredientes;
    }
}
