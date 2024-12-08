

import models.BaseDeDados;

public class Main {
    public static void main(String[] args) {
        BaseDeDados baseDeDados = new BaseDeDados();
        baseDeDados.inicializaRegras();

        System.out.println("Importando ocorrências...");
        baseDeDados.importarOcorrenciasDeArquivo("C:\\Users\\tiago\\OneDrive\\Desktop\\Commit_1\\ocorrencias.txt");

        System.out.println("Ocorrências não processadas:");
        baseDeDados.listarOcorrenciasNaoProcessadas().forEach(System.out::println);

        System.out.println("\nProcessando ocorrências...");
        baseDeDados.processarOcorrencias();

        System.out.println("Ocorrências processadas:");
        baseDeDados.listarOcorrenciasProcessadas().forEach(System.out::println);

        System.out.println("\nMultas geradas:");
        baseDeDados.listarMultas().forEach(System.out::println);
    }
}
