public class AlunoGraduacao extends Aluno{
    private double horasAtividadesComplementares;


    @Override
    public void mostrarDados() {
        System.out.println("\n Nome: "+ this.getNome() +
                "\n CPF: " + this.getCpf() +
                "\n Prontuário: " + this.getProntuario() +
                "\n IRA: " + this.getIra() +
                "\n Curso: " + this.getCurso().getNome());
    }

    public AlunoGraduacao(String cpf, String nome, String prontuario, double ira, Curso curso, double horasAtividadesComplementares) {
        super(cpf, nome, prontuario, ira, curso);
        this.horasAtividadesComplementares = horasAtividadesComplementares;
    }

    public double getHorasAtividadesComplementares() {
        return horasAtividadesComplementares;
    }

    public void setHorasAtividadesComplementares(double horasAtividadesComplementares) {
        this.horasAtividadesComplementares = horasAtividadesComplementares;
    }
}
