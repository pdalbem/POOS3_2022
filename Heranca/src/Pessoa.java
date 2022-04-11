public abstract class Pessoa {
    private String endereco;
    private String telefone;
    private String email;

    //método abstrato. Classes filhas (subclasses) deverão implementá-lo
    public abstract void mostrarDados();

    public Pessoa(String endereco, String telefone, String email) {
        this.endereco = endereco;
        this.telefone = telefone;
        this.email = email;
    }
    public Pessoa() {
    }

    @Override
    public String toString(){
        return "Nome: " + this.getEmail();
    }


    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
