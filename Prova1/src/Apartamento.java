public class Apartamento extends Imovel{
    private String edificio;
    private int andar;

    @Override
    public void mostrarDadosImovel() {
        System.out.println("\n Endereco: " + this.getEndereco() +
                "\n Area: " + this.getAreaConstruida()+
                "\n Vagas: " + this.getVagaGaragem()+
                "\n Aluguel: " + this.getValorAluguel() +
                "\n Edificio: " + this.edificio +
                "\n Andar: " + this.andar +
                "\n Proprietario: " + this.getProprietario().getNome());
    }

    public Apartamento(String endereco, double areaConstruida, int vagaGaragem, double valorAluguel, Proprietario proprietario, String edificio, int andar) {
        super(endereco, areaConstruida, vagaGaragem, valorAluguel, proprietario);
        this.edificio = edificio;
        this.andar = andar;
    }

    public String getEdificio() {
        return edificio;
    }

    public void setEdificio(String edificio) {
        this.edificio = edificio;
    }

    public int getAndar() {
        return andar;
    }

    public void setAndar(int andar) {
        this.andar = andar;
    }
}
