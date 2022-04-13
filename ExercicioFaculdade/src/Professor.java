public class Professor extends Pessoa{
    private String titulacao;
    private String matricula;

    @Override
    public void mostrarDados() {
        System.out.println("\n Nome: "+ this.getNome() +
                           "\n CPF: " + this.getCpf() +
                           "\n Titulação: " + this.titulacao +
                           "\n Matricula: " + this.matricula);
    }

    public Professor(String cpf, String nome, String titulacao, String matricula) {
        super(cpf, nome);
        this.titulacao = titulacao;
        this.matricula = matricula;
    }

    public String getTitulacao() {
        return titulacao;
    }

    public void setTitulacao(String titulacao) {
        this.titulacao = titulacao;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
}
