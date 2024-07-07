package util;

import java.util.Scanner;
import java.util.InputMismatchException;

public class InterfaceUsuario {

    public static int pedirTipoFinanciamento() {
        Scanner scanner = new Scanner(System.in);
        int tipoFinanciamento = 0;
        boolean valorValido = false;

        System.out.println("*** Bem-vindo ao sistema de financiamento! ***");

        do {
            System.out.println("\nDeseja simular um financiamento de:");
            System.out.println("1 - CASA");
            System.out.println("2 - APARTAMENTO");
            System.out.println("3 - TERRENO");
            System.out.print("Digite o número correspondente: ");
            try {
                tipoFinanciamento = scanner.nextInt();
                if (tipoFinanciamento < 1 || tipoFinanciamento > 3) {
                    throw new IllegalArgumentException("Opção inválida. Escolha 1, 2 ou 3.");
                }
                valorValido = true;
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Digite um número.");
                scanner.next();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while (!valorValido);
        System.out.println("Tipo de financiamento selecionado: " + tipoFinanciamento);
        return tipoFinanciamento;
    }

    public static Object[] pedirDadosComplementares(int tipoFinanciamento) {
        Scanner scanner = new Scanner(System.in);
        double areaConstruida = 0;
        double tamanhoTerreno = 0;
        int numeroVagasGaragem = 0;
        int numeroAndar = 0;
        String tipoZona = "";
        int escolhaTipoZona = 0;

        if (tipoFinanciamento == 1) {
            do {
                System.out.print("Qual a área construída? ");
                try {
                    areaConstruida = scanner.nextDouble();
                    if (areaConstruida <= 0) {
                        throw new IllegalArgumentException("Área não pode ser igual ou menor que zero. Tente novamente.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Valor inválido. Tente novamente.");
                    scanner.next();
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            } while (areaConstruida <= 0);

            do {
                System.out.print("Qual o tamanho do terreno? ");
                try {
                    tamanhoTerreno = scanner.nextDouble();
                    if (tamanhoTerreno <= 0 || tamanhoTerreno < areaConstruida) {
                        throw new IllegalArgumentException("Tamanho do terreno inválido. Deve ser maior que zero e maior ou igual à área construída.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Valor inválido. Tente novamente.");
                    scanner.next();
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            } while (tamanhoTerreno <= 0 || tamanhoTerreno < areaConstruida);

            return new Object[] { tipoFinanciamento, areaConstruida, tamanhoTerreno };

        } else if (tipoFinanciamento == 2) {
            do {
                System.out.print("Qual o número de vagas na garagem? ");
                try {
                    numeroVagasGaragem = scanner.nextInt();
                    if (numeroVagasGaragem < 0) {
                        throw new IllegalArgumentException("O número de vagas não pode ser menor que zero. Tente novamente.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Valor inválido. Tente novamente.");
                    scanner.next();
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            } while (numeroVagasGaragem < 0);

            do {
                System.out.print("Qual o número do andar? ");
                try {
                    numeroAndar = scanner.nextInt();
                    if (numeroAndar <= 0) {
                        throw new IllegalArgumentException("O número do andar não pode ser menor ou igual a zero. Tente novamente.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Valor inválido. Tente novamente.");
                    scanner.next();
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            } while (numeroAndar <= 0);

            return new Object[] { tipoFinanciamento, numeroVagasGaragem, numeroAndar };

        } else if (tipoFinanciamento == 3) {
            do {
                System.out.println("Qual o tipo de zona do terreno? (1 - RESIDENCIAL; 2 - COMERCIAL)");
                try {
                    escolhaTipoZona = scanner.nextInt();
                    if (escolhaTipoZona != 1 && escolhaTipoZona != 2) {
                        throw new IllegalArgumentException("Opção inválida. Escolha 1 ou 2.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Valor inválido. Tente novamente.");
                    scanner.next();
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            } while (escolhaTipoZona != 1 && escolhaTipoZona != 2);

            tipoZona = (escolhaTipoZona == 1) ? "RESIDENCIAL" : "COMERCIAL";
            return new Object[] { tipoFinanciamento, tipoZona };
        } else {
            throw new IllegalArgumentException("Tipo de financiamento inválido.");
        }
    }

    public static double pedirValorImovel() {
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

    public static int pedirPrazoFinanciamento() {
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

    public static double pedirTaxaJuros() {
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
