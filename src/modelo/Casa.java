package modelo;

public class Casa extends Financiamento {

    public Casa (double valorImovel, int prazoFinanciamentoAnos, double taxaJurosAnual) {
        super(valorImovel, prazoFinanciamentoAnos, taxaJurosAnual);
    }

    @Override
    public double calcularPagamentoMensal() {
        double pagamentoMensalPadrao = super.calcularPagamentoMensal();
        return pagamentoMensalPadrao + 80;
    }
}
