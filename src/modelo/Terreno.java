package modelo;

public class Terreno extends Financiamento {

    public Terreno (double valorImovel, int prazoFinanciamentoAnos, double taxaJurosAnual) {
        super(valorImovel, prazoFinanciamentoAnos, taxaJurosAnual);
    }

    @Override
    public double calcularPagamentoMensal() {
        double pagamentoMensalPadrao = super.calcularPagamentoMensal();
        double acrescimo = pagamentoMensalPadrao * 0.02;
        return pagamentoMensalPadrao + acrescimo;
    }
}


// public double calcularPagamentoMensal() {
//     return (this.valorImovel / (this.prazoFinanciamentoAnos * 12) * (1 + (this.taxaJurosAnual / 12)));
// }