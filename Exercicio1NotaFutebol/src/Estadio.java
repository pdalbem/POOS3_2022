public class Estadio {
    private String nome;
    private String cidade;

    public Estadio(String nome, String cidade) {
        this.nome = nome;
        this.cidade = cidade;
    }

    public Estadio() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
}
