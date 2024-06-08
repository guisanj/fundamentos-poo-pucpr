package util;

import java.util.Scanner;

public class InterfaceUsuario {

    public double pedirValorImovel() {
        Scanner scanner = new Scanner(System.in);
        double valorImovel = 0;
        boolean valorValido = false;

        do {
            System.out.println("Digite o valor do imóvel: ");

            if (scanner.hasNextDouble()) {
                try {
                    valorImovel = scanner.nextDouble();
                    if (valorImovel < 150000 || valorImovel > 1500000) {
                        throw new IllegalArgumentException("O valor do imóvel deve ser maior do que 200 mil e menor que 1,5 milhões. Tente novamente.");
                    }
                    valorValido = true;
                } catch (NumberFormatException e) {
                    System.out.println("O valor digitado não é um número válido. Tente novamente.");
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            } else {
                System.out.println("O valor digitado não é um número. Tente novamente.");
                scanner.next();
            }
        } while (!valorValido);
        System.out.println("Valor selecionado do imóvel: " + valorImovel);
        return valorImovel;
    }


    public int pedirPrazoFinanciamento() {
        Scanner scanner = new Scanner (System.in);
        int prazoFinanciamentoAnos = 0;
        boolean valorValido = false;
        do {
            System.out.println("Digite o prazo em anos do financiamento: ");
            try {
                prazoFinanciamentoAnos = scanner.nextInt();
                if (prazoFinanciamentoAnos <= 0 || prazoFinanciamentoAnos > 35) {
                    throw new IllegalArgumentException("O prazo do financiamento deve ser entre 1 e 35 anos. Tente novamente.");
                }
                valorValido = true;
            } catch (NumberFormatException e) {
                System.out.println("O prazo escolhido para o financiamento é inválido. Tente novamente.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while (!valorValido);
        System.out.println("Valor selecionado do imóvel: " + prazoFinanciamentoAnos);
        return prazoFinanciamentoAnos;
    }

    public double pedirTaxaJuros() {
        Scanner scanner = new Scanner (System.in);
        double taxaJurosAnual = 0;
        boolean valorValido = false;
        do {
            System.out.println("Digite a taxa de juros anual: ");
            try {
                taxaJurosAnual = scanner.nextDouble();
                if (taxaJurosAnual <= 0 || taxaJurosAnual > 15) {
                    throw new IllegalArgumentException("A taxa de juros anual deve ser emtre 1 e 15%. Tente novamente.");
                }
                valorValido = true;
            } catch (NumberFormatException e) {
                System.out.println("A taxa de juros escolhida é inválida. Tente novamente.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while (!valorValido);
        System.out.println("Valor selecionado do imóvel: " + taxaJurosAnual);
        return taxaJurosAnual;
    }
}
