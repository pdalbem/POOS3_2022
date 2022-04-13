public abstract class Aluno extends Pessoa{
    private String prontuario;
    private double ira;
    private Curso curso;

    public Aluno(String cpf, String nome, String prontuario, double ira, Curso curso) {
        super(cpf, nome);
        this.prontuario = prontuario;
        this.ira = ira;
        this.curso = curso;
    }

    public String getProntuario() {
        return prontuario;
    }

    public void setProntuario(String prontuario) {
        this.prontuario = prontuario;
    }

    public double getIra() {
        return ira;
    }

    public void setIra(double ira) {
        this.ira = ira;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }
}
