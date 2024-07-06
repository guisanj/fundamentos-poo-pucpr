package modelo;

public class Casa extends Financiamento {

    private double areaConstruida;
    private double tamanhoTerreno;

    public Casa(double valorImovel, int prazoFinanciamentoAnos, double taxaJurosAnual, double areaConstruida, double tamanhoTerreno) {
        super(valorImovel, prazoFinanciamentoAnos, taxaJurosAnual);
        this.areaConstruida = areaConstruida;
        this.tamanhoTerreno = tamanhoTerreno;
    }

    @Override
    public double calcularPagamentoMensal() {
        double pagamentoMensalPadrao = this.valorImovel / (this.prazoFinanciamentoAnos * 12) * (1 + (this.taxaJurosAnual / 12));
        return pagamentoMensalPadrao + 80;
    }
}