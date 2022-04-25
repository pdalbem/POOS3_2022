public class Casa extends Imovel{
    private String quadra;
    private String lote;

    @Override
    public void mostrarDadosImovel() {
        System.out.println("\n Endereco: " + this.getEndereco() +
                          "\n Area: " + this.getAreaConstruida()+
                          "\n Vagas: " + this.getVagaGaragem()+
                          "\n Aluguel: " + this.getValorAluguel() +
                          "\n Quadra: " + this.quadra +
                          "\n Lote: " + this.lote +
                           "\n Proprietario: " + this.getProprietario().getNome() );
    }

    public Casa(String endereco, double areaConstruida, int vagaGaragem, double valorAluguel, Proprietario proprietario, String quadra, String lote) {
        super(endereco, areaConstruida, vagaGaragem, valorAluguel, proprietario);
        this.quadra = quadra;
        this.lote = lote;
    }

    public String getQuadra() {
        return quadra;
    }

    public void setQuadra(String quadra) {
        this.quadra = quadra;
    }

    public String getLote() {
        return lote;
    }

    public void setLote(String lote) {
        this.lote = lote;
    }
}
