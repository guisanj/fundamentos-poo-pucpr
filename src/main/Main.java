package main;

import modelo.Financiamento;
import modelo.Apartamento;
import modelo.Terreno;
import modelo.Casa;
import util.InterfaceUsuario;


import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        InterfaceUsuario interfaceUsuario = new InterfaceUsuario();
        List<Financiamento> listaFinanciamento = new ArrayList<Financiamento>();

        int tipoFinanciamento = InterfaceUsuario.pedirTipoFinanciamento();
        Object[] dadosComplementares = InterfaceUsuario.pedirDadosComplementares(tipoFinanciamento);
        double valorImovel = InterfaceUsuario.pedirValorImovel();
        int prazoFinanciamentoAnos = InterfaceUsuario.pedirPrazoFinanciamento();
        double taxaJurosAnual = InterfaceUsuario.pedirTaxaJuros();

        Financiamento novoFinanciamento;

        switch (tipoFinanciamento) {
            case 1:
                double areaConstruida = (double) dadosComplementares[1];
                double tamanhoTerreno = (double) dadosComplementares[2];
                novoFinanciamento = new Casa(valorImovel, prazoFinanciamentoAnos, taxaJurosAnual, areaConstruida, tamanhoTerreno);
                break;
            case 2:
                int numeroVagasGaragem = (int) dadosComplementares[1];
                int numeroAndar = (int) dadosComplementares[2];
                novoFinanciamento = new Apartamento(valorImovel, prazoFinanciamentoAnos, taxaJurosAnual, numeroVagasGaragem, numeroAndar);
                break;
            case 3:
                String tipoZonaString = (String) dadosComplementares[1];
                Terreno.TipoZona tipoZona = Terreno.TipoZona.valueOf(tipoZonaString);
                novoFinanciamento = new Terreno(valorImovel, prazoFinanciamentoAnos, taxaJurosAnual, tipoZona);
                break;
            default:
                throw new IllegalArgumentException("Tipo de financiamento inválido.");
        }

        listaFinanciamento.add(novoFinanciamento);

        listaFinanciamento.add(new Apartamento(350000, 27, 8.2, 2, 10));
        listaFinanciamento.add(new Apartamento(600000, 25, 7.8, 9, 33));
        listaFinanciamento.add(new Terreno(250000, 18, 13.1, Terreno.TipoZona.RESIDENCIAL));
        listaFinanciamento.add(new Terreno(210000, 12, 9.1, Terreno.TipoZona.COMERCIAL));
        listaFinanciamento.add(new Casa(720000,30,9.9, 20000, 30000));
        listaFinanciamento.add(new Casa(530000,31,7.4, 10000, 20000));

        double somaValorImovel = 0;
        double somaTotalFinanciamentos = 0;

        for (Financiamento financiamento : listaFinanciamento) {
                somaValorImovel += financiamento.getvalorImovel();
                somaTotalFinanciamentos += financiamento.calcularTotalPagamento();

                System.out.println("Tipo de imóvel: " + financiamento.getClass().getSimpleName());
                System.out.println("Valor do imóvel: " + financiamento.getvalorImovel());
                System.out.println("Valor do financiamento: " + financiamento.calcularTotalPagamento());
        }

        System.out.println("Total de todos os imóveis - Valor do imóvel = " + somaValorImovel + "; Total de todos os financiamentos = " + somaTotalFinanciamentos);
    }
}