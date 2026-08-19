package Pedido;

public enum Cardapio {
    X_BURGER("X-Burger", 25.00),
    BATATA_FRITA("Batata Frita", 12.00),
    REFRIGERANTE("Refrigerante", 8.00);

    private final String nome;
    private final Double preco;

    Cardapio(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public Item toItem() {
        return new Item(this.nome, this.preco);
    }
}