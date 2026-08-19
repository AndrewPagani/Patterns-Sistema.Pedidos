package Pagamento;

public class PagamentoCartao implements MetodoPagamento {
    @Override
    public Double calcular(Double valorTotal){
        return valorTotal;
    }
}