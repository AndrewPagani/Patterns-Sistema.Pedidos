package Comprovante;
import Pedido.Pedido;

public class ComprovanteFactory {
    public static Comprovante criarComprovante(String tipo, Pedido pedido) {
        if ("delivery".equalsIgnoreCase(tipo)) {
            return new ComprovanteDelivery(pedido);
        }
        else if ("balcao".equalsIgnoreCase(tipo)) {
            return new ComprovanteBalcao(pedido);
        }
        else {
            throw new IllegalArgumentException("Tipo de comprovante inválido: " + tipo);
        }
    }
}