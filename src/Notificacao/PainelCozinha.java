package Notificacao;
import Pedido.Pedido;
import Pedido.ObservadorPedido;
import Pedido.StatusPedido;

public class PainelCozinha implements ObservadorPedido {
    @Override
    public void atualizar(Pedido pedido) {
        if (pedido.getStatus() == StatusPedido.CRIADO) {
            System.out.println("Cozinha: Novo pedido recebido, iniciando preparo!");
        }
    }
}