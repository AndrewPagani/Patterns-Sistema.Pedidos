package Notificacao;
import Pedido.Pedido;
import Pedido.ObservadorPedido;

public class NotificadorCliente implements ObservadorPedido {
    @Override
    public void atualizar(Pedido pedido) {
        System.out.println("Status do Pedido.Pedido: " + pedido.getStatus());
    }
}