public class Cliente implements IPrint{
    private String cpf;
    private String nome;


    @Override
    public void mostrarDados() {
        System.out.println("\n Nome: " + nome +
                          "\n CPF: "+ cpf);
    }

    public Cliente(String cpf, String nome) {
        this.cpf = cpf;
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
