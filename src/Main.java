import Pagamento.PagamentoCartao;
import Pagamento.PagamentoPix;
import Pagamento.PagamentoVoucher;
import Pedido.Pedido;
import Pedido.Item;
import Pedido.Cardapio;
import Pedido.StatusPedido;
import Comprovante.ComprovanteFactory;
import Comprovante.Comprovante;
import java.util.Scanner;

public class Main {
    static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Pedido pedido = new Pedido();
        boolean montandoPedido = true;

        while (montandoPedido) {
            System.out.println("\n==== CARDÁPIO ====");
            System.out.println("1 - X-Burguer (R$ 25,00)");
            System.out.println("2 - Batata Frita (R$ 12,00)");
            System.out.println("3 - Refrigerante (R$ 8,00)");
            System.out.println("4 - Finalizar e ir para o Pagamento");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();

                if (opcao == 4) {
                    if (pedido.estaVazio()) {
                        System.out.println("Seu carrinho está vazio!");
                        continue;
                    }
                    break;
                }

            Item itemSelecionado;

            switch (opcao) {
                case 1:
                    itemSelecionado = Cardapio.X_BURGER.toItem();
                    break;
                case 2:
                    itemSelecionado = Cardapio.BATATA_FRITA.toItem();
                    break;
                case 3:
                    itemSelecionado = Cardapio.REFRIGERANTE.toItem();
                    break;
                default:
                    System.out.print("Digite uma opção válida! ");
                    continue;
            }

            System.out.print("Digite a quantidade desejada ");
            int quantidade = scanner.nextInt();

            for (int i= 0; i < quantidade; i++) {
                pedido.adicionarItem(itemSelecionado);
            }

            System.out.println(quantidade + "x " + itemSelecionado.getNome() + " adicionado(s)!");
        }

        while (true) {

            System.out.println("\n==== Método de Pagamento ====");
            System.out.println("1 - PIX (10% OFF)");
            System.out.println("2 - Cartão");
            System.out.println("3 - Vale Refeição (Taxa de R$2,00)");
            System.out.print("Escolha uma opção: ");

            int payment = scanner.nextInt();

            switch (payment) {
                case 1:
                    pedido.setMetodoPagamento(new PagamentoPix());
                    break;
                case 2:
                    pedido.setMetodoPagamento(new PagamentoCartao());
                    break;
                case 3:
                    pedido.setMetodoPagamento(new PagamentoVoucher());
                    break;
                default:
                    System.out.print("Digite uma opção válida! ");
                    continue;
            }
            System.out.println("\n Total do pedido: R$ " + pedido.calcularTotal());
            pedido.setStatus(StatusPedido.CRIADO);
            break;
        }

        System.out.println("\n==== TIPO DE RETIRADA ====");
        System.out.println("Digite 'Delivery' para Entrega ou 'Balcao' para Retirada:");
        System.out.print("Opção: ");
        String comp = scanner.next();

        while (true) {
            try {
                Comprovante comprovante = ComprovanteFactory.criarComprovante(comp, pedido);
                comprovante.ImprimirComprovante();
                break;

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}