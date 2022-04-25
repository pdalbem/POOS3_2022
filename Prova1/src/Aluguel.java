public class Aluguel {
    private String inicioContrato;
    private String fimContrato;
    private int diaPagamento;
    private Corretor corretor;
    private Inquilino inquilino;
    private Imovel imovel;


    public void mostrarDadosAluguel()
    {
        System.out.println("\n Inicio: " + inicioContrato+
                           "\n Fim: " + fimContrato +
                           "\n Dia: " + diaPagamento +
                           "\n Corretor: " + corretor.getNome() +
                            "\n Inquilino: " + inquilino.getNome() +
                           "\n Proprietario: " + imovel.getProprietario().getNome());

    }

    public Aluguel(String inicioContrato, String fimContrato, int diaPagamento, Corretor corretor, Inquilino inquilino, Imovel imovel) {
        this.inicioContrato = inicioContrato;
        this.fimContrato = fimContrato;
        this.diaPagamento = diaPagamento;
        this.corretor = corretor;
        this.inquilino = inquilino;
        this.imovel = imovel;
    }

    public String getInicioContrato() {
        return inicioContrato;
    }

    public void setInicioContrato(String inicioContrato) {
        this.inicioContrato = inicioContrato;
    }

    public String getFimContrato() {
        return fimContrato;
    }

    public void setFimContrato(String fimContrato) {
        this.fimContrato = fimContrato;
    }

    public int getDiaPagamento() {
        return diaPagamento;
    }

    public void setDiaPagamento(int diaPagamento) {
        this.diaPagamento = diaPagamento;
    }

    public Corretor getCorretor() {
        return corretor;
    }

    public void setCorretor(Corretor corretor) {
        this.corretor = corretor;
    }

    public Inquilino getInquilino() {
        return inquilino;
    }

    public void setInquilino(Inquilino inquilino) {
        this.inquilino = inquilino;
    }

    public Imovel getImovel() {
        return imovel;
    }

    public void setImovel(Imovel imovel) {
        this.imovel = imovel;
    }
}
