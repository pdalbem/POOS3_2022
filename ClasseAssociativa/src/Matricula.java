public class Matricula {
    private Aluno aluno;
    private Disciplina disciplina;
    private double nota;
    private int frequencia;
    private String periodo;


    public Matricula(Aluno aluno, Disciplina disciplina, double nota, int frequencia, String periodo) {
        this.aluno = aluno;
        this.disciplina = disciplina;
        this.nota = nota;
        this.frequencia = frequencia;
        this.periodo = periodo;
    }

    public Matricula() {
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public int getFrequencia() {
        return frequencia;
    }

    public void setFrequencia(int frequencia) {
        this.frequencia = frequencia;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }
}
