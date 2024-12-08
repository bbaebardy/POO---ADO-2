

import models.BaseDeDados;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BaseDeDados baseDeDados = new BaseDeDados();
        baseDeDados.inicializaRegras();

        System.out.println("Importando ocorrências...");
        baseDeDados.importarOcorrenciasDeArquivo("ocorrencias.txt");

        System.out.println("Ocorrências não processadas:");
        baseDeDados.listarOcorrenciasNaoProcessadas().forEach(System.out::println);

        System.out.println("\nProcessando ocorrências...");
        baseDeDados.processarOcorrencias();

        System.out.println("Ocorrências processadas:");
        baseDeDados.listarOcorrenciasProcessadas().forEach(System.out::println);

        System.out.println("\nMultas geradas:");
        baseDeDados.listarMultas().forEach(System.out::println);

        // Funcionalidade de busca de multas
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nDigite uma data para buscar multas (formato: yyyy-MM-dd):");
        String data = scanner.nextLine();
        System.out.println("Multas na data " + data + ":");
        baseDeDados.buscarMultasPorData(data).forEach(System.out::println);

        System.out.println("\nDigite uma placa para buscar multas:");
        String placa = scanner.nextLine();
        System.out.println("Multas para a placa " + placa + ":");
        baseDeDados.buscarMultasPorPlaca(placa).forEach(System.out::println);

        scanner.close();
    }
}

import models.BaseDeDados;
import models.Ocorrencia;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BaseDeDados baseDeDados = new BaseDeDados();
        baseDeDados.inicializaRegras();

        Scanner scanner = new Scanner(System.in);
        boolean executar = true;

        while (executar) {
            System.out.println("\nSistema de Controle de Multas");
            System.out.println("1. Importar ocorrências de arquivo");
            System.out.println("2. Cadastrar nova ocorrência");
            System.out.println("3. Processar ocorrências");
            System.out.println("4. Listar ocorrências não processadas");
            System.out.println("5. Listar multas geradas");
            System.out.println("6. Buscar multas por data");
            System.out.println("7. Buscar multas por placa");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha

            switch (opcao) {
                case 1:
                    System.out.print("Digite o caminho do arquivo: ");
                    String caminhoArquivo = scanner.nextLine();
                    baseDeDados.importarOcorrenciasDeArquivo(caminhoArquivo);
                    System.out.println("Ocorrências importadas com sucesso.");
                    break;

                case 2:
                    System.out.print("Digite a placa do veículo: ");
                    String placa = scanner.nextLine();
                    System.out.print("Digite o logradouro: ");
                    String logradouro = scanner.nextLine();
                    System.out.print("Digite a data e hora (yyyy-MM-dd HH:mm:ss): ");
                    String dataHora = scanner.nextLine();
                    System.out.print("Digite o tipo de ocorrência (ex: velocidade ou hora): ");
                    int tipoOcorrencia = scanner.nextInt();
                    scanner.nextLine(); // Consumir a quebra de linha

                    Ocorrencia novaOcorrencia = new Ocorrencia(placa, logradouro, dataHora, tipoOcorrencia);
                    baseDeDados.adicionarOcorrencia(novaOcorrencia);
                    System.out.println("Ocorrência cadastrada com sucesso.");
                    break;

                case 3:
                    baseDeDados.processarOcorrencias();
                    System.out.println("Ocorrências processadas.");
                    break;

                case 4:
                    System.out.println("Ocorrências não processadas:");
                    baseDeDados.listarOcorrenciasNaoProcessadas().forEach(System.out::println);
                    break;

                case 5:
                    System.out.println("Multas geradas:");
                    baseDeDados.listarMultas().forEach(System.out::println);
                    break;

                case 6:
                    System.out.print("Digite a data (yyyy-MM-dd): ");
                    String data = scanner.nextLine();
                    System.out.println("Multas na data " + data + ":");
                    baseDeDados.buscarMultasPorData(data).forEach(System.out::println);
                    break;

                case 7:
                    System.out.print("Digite a placa: ");
                    String buscaPlaca = scanner.nextLine();
                    System.out.println("Multas para a placa " + buscaPlaca + ":");
                    baseDeDados.buscarMultasPorPlaca(buscaPlaca).forEach(System.out::println);
                    break;

                case 0:
                    executar = false;
                    System.out.println("Saindo do sistema. Até logo!");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }

        scanner.close();
    }
}
