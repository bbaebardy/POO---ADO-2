

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
