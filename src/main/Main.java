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

        listaFinanciamento.add(new Apartamento(350000, 27, 8.2, 2, 10));
        listaFinanciamento.add(new Terreno(210000, 12, 9.1, Terreno.TipoZona.RESIDENCIAL));
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