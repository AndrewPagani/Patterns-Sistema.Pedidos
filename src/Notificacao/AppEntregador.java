package Notificacao;
import Pedido.ObservadorPedido;
import Pedido.Pedido;
import Pedido.StatusPedido;

public class AppEntregador implements ObservadorPedido {
    @Override
    public void atualizar(Pedido pedido) {
        if (pedido.getStatus() == StatusPedido.SAIU_PARA_ENTREGA) {
            System.out.println("App Entregador: Nova rota de entrega disponível!");
        }
    }
}