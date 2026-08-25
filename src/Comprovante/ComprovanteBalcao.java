package Comprovante;
import Pedido.Pedido;

public class ComprovanteBalcao implements Comprovante {
    private final Pedido pedido;

    public ComprovanteBalcao(Pedido pedido) {
        this.pedido = pedido;
    } // Acessar variável privada

    @Override
    public void ImprimirComprovante() {
        System.out.println("====================================");
        System.out.println("         COMPROVANTE BALCÃO      ");
        System.out.println("====================================");
        System.out.println(" Status: " + pedido.getStatus());
        System.out.println(" Taxa de Entrega: ISENTO");
        System.out.printf(" Total Final: R$ %.2f\n",pedido.calcularTotal() );
        System.out.println("====================================");
    }
}