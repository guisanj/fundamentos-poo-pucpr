package modelo;

public class Apartamento extends Financiamento {

    public Apartamento (double valorImovel, int prazoFinanciamentoAnos, double taxaJurosAnual) {
        super(valorImovel, prazoFinanciamentoAnos, taxaJurosAnual);
    }

    @Override
    public double calcularPagamentoMensal() {
        double taxaJurosMensal = this.taxaJurosAnual / 12;
        int prazoFinanciamentoMeses = this.prazoFinanciamentoAnos / 12;
        double divisor = this.valorImovel * Math.pow(1 + taxaJurosMensal, prazoFinanciamentoMeses);
        double dividendo = Math.pow(1 + taxaJurosMensal, prazoFinanciamentoMeses) - 1;

        return divisor / dividendo;
    }
}