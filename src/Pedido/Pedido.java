package Pedido;

import java.util.ArrayList;
import java.util.List;
import Pagamento.MetodoPagamento;

public class Pedido {
    private final List<Item> itens = new ArrayList<>();
    private MetodoPagamento metodoPagamento;
    private StatusPedido status;
    private final List<ObservadorPedido> observadores = new ArrayList<>();

    private void notificarObservadores() {
        for (ObservadorPedido obs : observadores) {
            obs.atualizar(this);
        }
    } // Passa o pedido para os observadores

    public void setStatus(StatusPedido novoStatus) {
        this.status = novoStatus;
        notificarObservadores(); // Se o status muda, ele avisa
    }

    public StatusPedido getStatus() {
        return status;
    }

    public void adicionarItem(Item item) {
        itens.add(item); // Coloca no array
    }

    public void setMetodoPagamento(MetodoPagamento metodoPagamento) {
        this.metodoPagamento = metodoPagamento;
    } // Chama a interface Pagamento.MetodoPagamento

    public double calcularTotal() {
        double subtotal = 0;
        for (Item item : itens) {
            subtotal += item.getValor(); // Realiza a soma para o valor da compra
        }
        return metodoPagamento.calcular(subtotal);
    }

    public boolean estaVazio() {
        return this.itens.isEmpty();
    }
}