package model;


public class Cidade {
    private int idCidade;
    private String nome;


    public void mostrarDados(){
        System.out.println("\n Id: " + getIdCidade() +
                "\n Nome: " + getNome());
    }

    public Cidade(int idCidade, String nome) {
        this.idCidade = idCidade;
        this.nome = nome;
    }

    public int getIdCidade() {
        return idCidade;
    }

    public void setIdCidade(int idCidade) {
        this.idCidade = idCidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
