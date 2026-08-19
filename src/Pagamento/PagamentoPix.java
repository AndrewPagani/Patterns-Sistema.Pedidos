package Pagamento;

public class PagamentoPix implements MetodoPagamento {
    @Override
    public Double calcular(Double valorTotal){
        return valorTotal * 0.9;
    }
}