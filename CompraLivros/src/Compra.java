import java.util.List;

public class Compra {
    private String numeroCompra;
    private String data;
    private Cliente cliente;
    private double valorTotal;
    private List<ItensCompra> itensCompra;

    public void calcularValorTotal()
    {
        for (ItensCompra i : itensCompra)
          this.valorTotal = this.valorTotal+i.getValorParcial();
    }

    public Compra() {
    }

    public Compra(String numeroCompra, String data, Cliente cliente) {
        this.numeroCompra = numeroCompra;
        this.data = data;
        this.cliente = cliente;
    }

    public List<ItensCompra> getItensCompra() {
        return itensCompra;
    }

    public void setItensCompra(List<ItensCompra> itensCompra) {
        this.itensCompra = itensCompra;
    }

    public String getNumeroCompra() {
        return numeroCompra;
    }

    public void setNumeroCompra(String numeroCompra) {
        this.numeroCompra = numeroCompra;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }
}
