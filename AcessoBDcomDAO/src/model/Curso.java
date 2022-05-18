package model;

public class Curso {
    private int idCurso;
    private String nome;

    public void mostrarDados(){
        System.out.println("\n Id: " + getIdCurso() +
                "\n Nome: " + getNome());
    }
    public Curso(int idCurso, String nome) {
        this.idCurso = idCurso;
        this.nome = nome;
    }

    public int getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
