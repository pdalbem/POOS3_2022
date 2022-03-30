public class PessoaJuridica extends Pessoa{
    private String cnpj;
    private String razaoSocial;
    private String nomeFantasia;

    //Implementação do método abstrato mostrarDados()
    @Override
    public void mostrarDados() {
        System.out.println("\n Nome Fantasia: " + nomeFantasia
                + "\n Endereço: " + getEndereco()
                + "\n Telefone: " + getTelefone());
    }

    public PessoaJuridica(String cnpj,String razaoSocial,String nomeFantasia,
                          String endereco,String telefone,String email) {
        super(endereco, telefone, email);
        this.cnpj = cnpj;
        this.razaoSocial = razaoSocial;
        this.nomeFantasia = nomeFantasia;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public boolean validarCNPJ(){
        //código para validar cnpj
        return false;
    }


}
