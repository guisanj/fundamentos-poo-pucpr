package modelo;

public class Terreno extends Financiamento {

    public enum TipoZona {
        RESIDENCIAL,
        COMERCIAL
    }

    private TipoZona tipoZona;

    public Terreno(double valorImovel, int prazoFinanciamentoAnos, double taxaJurosAnual, TipoZona tipoZona) {
        super(valorImovel, prazoFinanciamentoAnos, taxaJurosAnual);
        this.tipoZona = tipoZona;
    }

    @Override
    public double calcularPagamentoMensal() {
        double pagamentoMensalPadrao = this.valorImovel / (this.prazoFinanciamentoAnos * 12) * (1 + (this.taxaJurosAnual / 12));
        double acrescimo = pagamentoMensalPadrao * 0.02;
        return pagamentoMensalPadrao + acrescimo;
    }
}