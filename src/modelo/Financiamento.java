package modelo;

public abstract class Financiamento {
    protected double valorImovel;
    protected int prazoFinanciamentoAnos;
    protected double taxaJurosAnual;

    public double getvalorImovel() {
        return this.valorImovel;
    }

    public int getPrazoFinanciamentoAnos() {
        return this.prazoFinanciamentoAnos;
    }

    public double gettaxaJurosAnual() {
        return this.taxaJurosAnual;
    }

    public Financiamento(double valorImovel, int prazoFinanciamentoAnos, double taxaJurosAnual) {
        this.valorImovel = valorImovel;
        this.prazoFinanciamentoAnos = prazoFinanciamentoAnos;
        this.taxaJurosAnual = taxaJurosAnual;
    }

    public abstract double calcularPagamentoMensal();

    public double calcularTotalPagamento() {
        return calcularPagamentoMensal() * this.prazoFinanciamentoAnos * 12;
    }
}