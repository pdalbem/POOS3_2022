import java.util.ArrayList;
import java.util.List;

public class Principal {
    public static void main(String[] args) {
        Ingrediente i1 = new Ingrediente("muçarela");
        Ingrediente i2 = new Ingrediente("calabresa");
        Ingrediente i3 = new Ingrediente("molho de tomate");

        //Outra forma de passar os ingredientes:
        Pizza pizza = new Pizza("Calabresa",30,true, List.of(i1,i2,i3));
        pizza.mostrarDados();

        Cerveja c1 = new Cerveja("Heineken",15, 24,5.5);
        Vinho v1 = new Vinho("Concha y Toro", 50, 100, "Cabernet Sauvignon", "Chile");

        //Polimorfismo:
        List<Produto> produtos = new ArrayList<>();
        produtos.add(pizza);
        produtos.add(c1);
        produtos.add(v1);

        for (Produto produto : produtos)
            produto.mostrarDados();

    }
}
