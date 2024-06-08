package modelo;

public class Financiamento {
    private double valorImovel;
    private int prazoFinanciamentoAnos;
    private double taxaJurosAnual;

    public double getvalorImovel() {
        return this.valorImovel;
    }

    public int getPrazoFinanciamentoAnos() {
        return this.prazoFinanciamentoAnos;
    }

    public double gettaxaJurosAnual() {
        return this.taxaJurosAnual;
    }

    public Financiamento(double valorImovel, int prazoFinanciamento, double taxaJurosAnual) {
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