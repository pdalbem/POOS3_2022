public  class PessoaFisica extends Pessoa{
    private String cpf;
    private String nome;

    //Implementação do método abstrato mostrarDados()
    @Override
    public void mostrarDados() {
        System.out.println("\n CPF: "+ cpf
                + "\n Nome: "+ nome
                + "\n E-mail: "+ getEmail());
    }


    public PessoaFisica(String cpf, String nome, String endereco, String telefone, String email) {
        super(endereco, telefone, email);
        this.nome = nome;
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public boolean validarCPF(){
        //código para validar CPF
        return false;
    }


}
