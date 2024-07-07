package modelo;

public class Apartamento extends Financiamento {

    public int numeroVagasGaragem;
    public int numeroAndar;

    public Apartamento(double valorImovel, int prazoFinanciamentoAnos, double taxaJurosAnual, int numeroVagasGaragem, int numeroAndar) {
        super(valorImovel, prazoFinanciamentoAnos, taxaJurosAnual);
        this.numeroVagasGaragem = numeroVagasGaragem;
        this.numeroAndar = numeroAndar;
    }

    @Override
    public double calcularPagamentoMensal() {
        double taxaJurosMensal = this.taxaJurosAnual / 12;
        int prazoFinanciamentoMeses = this.prazoFinanciamentoAnos * 12;
        double numerador = this.valorImovel * Math.pow(1 + taxaJurosMensal, prazoFinanciamentoMeses);
        double denominador = Math.pow(1 + taxaJurosMensal, prazoFinanciamentoMeses) - 1;

        return numerador / denominador;
    }
}
