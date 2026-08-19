package Pagamento;

public class PagamentoVoucher implements MetodoPagamento {
    @Override
    public Double calcular(Double valorTotal){
        return valorTotal + 2;
    }
}