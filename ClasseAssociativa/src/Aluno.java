public class Aluno {
    private String nome;
    private String prontuario;
    private Matricula[] matriculas;

    public Aluno(String nome, String prontuario) {
        this.nome = nome;
        this.prontuario = prontuario;
    }

    public Aluno() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getProntuario() {
        return prontuario;
    }

    public void setProntuario(String prontuario) {
        this.prontuario = prontuario;
    }

    public Matricula[] getMatriculas() {
        return matriculas;
    }

    public void setMatriculas(Matricula[] matriculas) {
        this.matriculas = matriculas;
    }
}
