import java.util.ArrayList;
import java.util.List;

public class Principal {
    public static void main(String[] args) {
        Proprietario proprietario = new Proprietario("Joao", "123", "111", "Bradesco", "9090");
        Corretor corretor = new Corretor("Pablo", "555", "6666", "123456", 10);
        Inquilino inquilino = new Inquilino("Maria", "777", "8888",2000);

        Casa casa = new Casa("Rua X", 150, 2,1000, proprietario,"10","A");
        Aluguel aluguel = new Aluguel("19/04/2022","19/04/2023", 10,corretor, inquilino, casa);

        Inquilino inquilino2 = new Inquilino("Jorge", "777", "8888",2000);
        Apartamento apartamento = new Apartamento("Rua Y",80,1,700,proprietario,"Edificio", 10);
        Aluguel aluguel2 = new Aluguel("19/04/2022","19/04/2023",5,corretor,inquilino2,apartamento);

        List<Imovel> imoveis = new ArrayList<>();
        imoveis.add(casa);
        imoveis.add(apartamento);

        for (Imovel i : imoveis)
            i.mostrarDadosImovel();


    }
}
