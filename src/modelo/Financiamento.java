package modelo;

public class Financiamento {
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

    public double calcularPagamentoMensal() {
        return (this.valorImovel / (this.prazoFinanciamentoAnos * 12) * (1 + (this.taxaJurosAnual / 12)));
    }

    public double calcularTotalPagamento() {
        return (this.calcularPagamentoMensal() * this.prazoFinanciamentoAnos * 12);
    }
}