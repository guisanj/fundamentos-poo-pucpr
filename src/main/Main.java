package main;

import modelo.Financiamento;
import modelo.Apartamento;
import modelo.Terreno;
import modelo.Casa;
import util.InterfaceUsuario;


import java.util.ArrayList;
import java.util.List;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.FileInputStream;

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

        try {
            salvarDadosFinanciamentoTxt(listaFinanciamento, "dados_financiamento.txt");
            salvarDadosFinanciamentoSerializado(listaFinanciamento, "dados_financiamento.ser");
        } catch (IOException e) {
            System.out.println("Erro ao salvar os dados: " + e.getMessage());
        }
    }

    public static void salvarDadosFinanciamentoTxt(List<Financiamento> listaFinanciamento, String nomeArquivo) throws IOException {
        FileWriter escritor = new FileWriter(nomeArquivo);
        for (Financiamento financiamento : listaFinanciamento) {
            escritor.write(financiamento.getvalorImovel() + "," + financiamento.calcularTotalPagamento() + "," + financiamento.gettaxaJurosAnual() + "," + financiamento.getPrazoFinanciamentoAnos() + ",");

            if (financiamento instanceof Apartamento) {
                Apartamento apartamento = (Apartamento) financiamento;
                escritor.write(apartamento.numeroVagasGaragem + "," + apartamento.numeroAndar + "\n");
            } else if (financiamento instanceof Terreno) {
                Terreno terreno = (Terreno) financiamento;
                escritor.write(terreno.tipoZona + "\n");
            } else if (financiamento instanceof Casa) {
                Casa casa = (Casa) financiamento;
                escritor.write(casa.areaConstruida + "," + casa.tamanhoTerreno + "\n");
            }
        }
        escritor.close();
        System.out.println("Dados salvos em " + nomeArquivo);

        BufferedReader leitor = new BufferedReader(new FileReader(nomeArquivo));
        String linha;
        while ((linha = leitor.readLine()) != null) {
            System.out.println(linha);
        }
        leitor.close();
    }
    public static void salvarDadosFinanciamentoSerializado(List<Financiamento> listaFinanciamento, String nomeArquivo) throws IOException {
        FileOutputStream arquivo = new FileOutputStream(nomeArquivo);
        ObjectOutputStream objeto = new ObjectOutputStream(arquivo);
        objeto.writeObject(listaFinanciamento);
        objeto.close();
        arquivo.close();
        System.out.println("Dados salvos em " + nomeArquivo);

        FileInputStream arquivoLeitura = new FileInputStream(nomeArquivo);
        ObjectInputStream objetoLeitura = new ObjectInputStream(arquivoLeitura);
        try {
            List<Financiamento> listaLida = (List<Financiamento>) objetoLeitura.readObject();
            for (Financiamento financiamento : listaLida) {
                System.out.println(financiamento.getvalorImovel() + "," + financiamento.calcularTotalPagamento() + "," + financiamento.gettaxaJurosAnual() + "," + financiamento.getPrazoFinanciamentoAnos());
            }
        } catch (ClassNotFoundException e) {
            System.out.println("Classe não encontrada: " + e.getMessage());
        }
        objetoLeitura.close();
        arquivoLeitura.close();
    }
}