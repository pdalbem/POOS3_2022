public class Corretor extends Pessoa{
   private String creci;
  private double comissao;

    @Override
    public void mostrarDadosPessoais() {
        System.out.println("Nome: " + this.getNome() +
                "CPF: " + this.getCpf() +
                "Telefone: " + this.getTelefone() +
                "Creci: " + this.creci +
                "Comissao: " + this.comissao);
    }

    public Corretor(String nome, String cpf, String telefone, String creci, double comissao) {
        super(nome, cpf, telefone);
        this.creci = creci;
        this.comissao = comissao;
    }

    public String getCreci() {
        return creci;
    }

    public void setCreci(String creci) {
        this.creci = creci;
    }
}
