public class Principal {
    public static void main(String[] args) {
        Cliente cliente = new Cliente("123", "Maria");
        Corrente corrente = new Corrente("Especial",
                                         cliente,
                                 "1010", 1000,500);

        corrente.calcularTributo();
        cliente.mostrarDados();
        corrente.mostrarDados();
    }
}
