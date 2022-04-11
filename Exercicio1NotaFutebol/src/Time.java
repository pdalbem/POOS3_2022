import java.util.ArrayList;
import java.util.List;

public class Time {
    private String pais;
    private int quantidadeTitulos;
    private List<Jogador> jogadores = new ArrayList<>();

    public void adicionarJogador(Jogador jogador)
    {
        this.jogadores.add(jogador);
    }

    //método com quantidade de argumentos variável
    public void adicionarJogador(Jogador... jogador)
    {
        for (Jogador j: jogador)
            this.jogadores.add(j);
    }

    public Time(String pais, int quantidadeTitulos, List<Jogador> jogadores) {
        this.pais = pais;
        this.quantidadeTitulos = quantidadeTitulos;
        this.jogadores = jogadores;
    }

    public Time(String pais, int quantidadeTitulos) {
        this.pais = pais;
        this.quantidadeTitulos = quantidadeTitulos;
    }

    public Time() {
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public int getQuantidadeTitulos() {
        return quantidadeTitulos;
    }

    public void setQuantidadeTitulos(int quantidadeTitulos) {
        this.quantidadeTitulos = quantidadeTitulos;
    }

    public List<Jogador> getJogadores() {
        return jogadores;
    }

    public void setJogadores(List<Jogador> jogadores) {
        this.jogadores = jogadores;
    }
}
