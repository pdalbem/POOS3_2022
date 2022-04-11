import java.util.ArrayList;
import java.util.List;

public class Principal {
    public static void main(String[] args) {
        Jogador j1 = new Jogador("Neymar", "atacante", 10);
        Jogador j2 = new Jogador("Alisson", "goleiro", 1);
        Jogador j3 = new Jogador("Coutinho", "meio campo", 11);
        Jogador j4 = new Jogador("Lucas Paquetá", "meio campo", 17);

        //Usando o construtor que recebe somente os atributos nome e quantidadeTitulos
        Time brasil = new Time("Brasil", 5);

        //Usando o método adicionarJogador(Jogador... jogador):
        brasil.adicionarJogador(j1,j2,j3,j4);

        //Poderia fazer assim também:
        //List<Jogador> jogadoresBrasil=new ArrayList<>();
        //jogadoresBrasil.add(j1);
        //jogadoresBrasil.add(j2);
        //jogadoresBrasil.add(j3);
        //jogadoresBrasil.add(j4);
        //brasil.setJogadores(jogadoresBrasil);

        Jogador j5 = new Jogador("Messi", "atacante", 10);
        Jogador j6 = new Jogador("Di Maria", "meio campo", 9);
        Time argentina = new Time("Argentina", 2);
        //Novamente usando o método com quantidade de argumentos variável
        argentina.adicionarJogador(j5,j6);

        Estadio estadio = new Estadio("Maracanã",  "Rio de janeiro");
        Partida partida = new Partida("10/ABR/2022", "21h00",brasil,argentina,estadio);

        partida.mostrarResultado();
        partida.atualizarResultado(2,1);
        partida.mostrarResultado();

        //Mostrar os jogadores do Brasil:
        for (Jogador j : brasil.getJogadores())
            System.out.println(j.getNome());
    }
}
