public class Disciplina {
    private String sigla;
    private String nomeDisciplina;
    private int cargaHoraria;
    private Matricula[] matriculas;

    public Disciplina(String sigla, String nomeDisciplina, int cargaHoraria) {
        this.sigla = sigla;
        this.nomeDisciplina = nomeDisciplina;
        this.cargaHoraria = cargaHoraria;
    }

    public Disciplina() {
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getNomeDisciplina() {
        return nomeDisciplina;
    }

    public void setNomeDisciplina(String nomeDisciplina) {
        this.nomeDisciplina = nomeDisciplina;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public Matricula[] getMatriculas() {
        return matriculas;
    }

    public void setMatriculas(Matricula[] matriculas) {
        this.matriculas = matriculas;
    }
}
