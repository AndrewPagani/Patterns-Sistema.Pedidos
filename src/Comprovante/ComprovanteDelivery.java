package Comprovante;
import Pedido.Pedido;

public class ComprovanteDelivery implements Comprovante {
    private final Pedido pedido;

    public ComprovanteDelivery(Pedido pedido) {
        this.pedido = pedido;
    } // Acessar variável privada

    @Override
    public void ImprimirComprovante() {
        double taxaDeDelivery = 5.00;
        double totalComTaxa = pedido.calcularTotal() + taxaDeDelivery;

        System.out.println("====================================");
        System.out.println("         COMPROVANTE DELIVERY      ");
        System.out.println("====================================");
        System.out.println(" Status: " + pedido.getStatus());
        System.out.println(" Taxa de Entrega: R$5,00");
        System.out.printf(" Total Final (com taxa): R$ %.2f\n", totalComTaxa);
        System.out.println("====================================");
    }
}
