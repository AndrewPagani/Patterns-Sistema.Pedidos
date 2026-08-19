import Pedido.Pedido;
import Pedido.Item;
import Pedido.StatusPedido;
import Pedido.Cardapio;

import java.awt.*;
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
                montandoPedido = false;
                continue;
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

            // Necessário verificar se há ou não itens no carrinho, para evitar o erro.

            System.out.print("Digite a quantidade desejada ");
            int quantidade = scanner.nextInt();

            for (int i= 0; i < quantidade; i++) {
                pedido.adicionarItem(itemSelecionado);
            }

            System.out.println(quantidade + "x " + itemSelecionado.getNome() + " adicionado(s)!");
        }

        System.out.println("\n Total do pedido: R$ " + pedido.calcularTotal());

    }
}