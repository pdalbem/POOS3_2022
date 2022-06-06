package model;

public class Aluno   {
    private int idAluno;
    private String prontuario;
    private String nome;
    private Curso curso;
    private Cidade cidade;



    public void mostrarDados(){
        System.out.println("\n Id: " + getIdAluno() +
                "\n Nome: " + this.getNome() +
                "\n Prontuario: " + this.getProntuario()+
                "\n model.Curso: " + getCurso().getNome() +
                "\n model.Cidade: " + getCidade().getNome());
    }
    public Aluno(int idAluno, String prontuario, String nome, Curso curso, Cidade cidade) {
        this.idAluno = idAluno;
        this.prontuario = prontuario;
        this.nome = nome;
        this.curso = curso;
        this.cidade = cidade;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public int getIdAluno() {
        return idAluno;
    }

    public void setIdAluno(int idAluno) {
        this.idAluno = idAluno;
    }

    public String getProntuario() {
        return prontuario;
    }

    public void setProntuario(String prontuario) {
        this.prontuario = prontuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }
}
