import java.util.ArrayList;
import java.util.List;

public class Principal {
    public static void main(String[] args) {
        Editora e1 = new Editora("Pearson", "10123123000112");
        Editora e2 = new Editora("Novatec", "99123123000115");

        Autor a1 = new Autor("Paul Deitel", "12345678");
        Autor a2 = new Autor("Harvey Deitel", "98765432");
        Autor a3 = new Autor("Peter Junior", "10293847");

        List<Autor> autoresJava = new ArrayList<>();
        autoresJava.add(a1);
        autoresJava.add(a2);

        Livro livro1 = new Livro("Java: Como Programar",e1,autoresJava,2016,350.00);
       // Livro livro1 = new Livro("Java: Como Programar",e1,new ArrayList<Autor>(list.of(a1,a2)),2016,350.00);

        Livro livro2 = new Livro("Java: Guia do  Programador", e2,new ArrayList<Autor>(List.of(a3)),2021,120.00);

        //Saber quem sao autores  do livro1
        //for (Autor a : livro2.getAutor())
        //    System.out.println(a.getNome());

        Cliente cli = new Cliente("Maria", "12345678910");

        Compra compra1 = new Compra("Compra1","15/03/2022",cli);
        ItensCompra itensCompra1 = new ItensCompra(compra1,livro1,2);
        itensCompra1.calcularValorParcial();

        ItensCompra itensCompra2 = new ItensCompra(compra1,livro2,1);
        itensCompra2.calcularValorParcial();

        compra1.setItensCompra(new ArrayList<ItensCompra>(List.of(itensCompra1,itensCompra2)));
        compra1.calcularValorTotal();

        System.out.println("Parcial: "+itensCompra1.getValorParcial());
        System.out.println("Total: "+compra1.getValorTotal());

    }
}
