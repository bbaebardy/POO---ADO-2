package models;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import com.google.gson.Gson;

public class BaseDeDados {
    private List<Ocorrencia> ocorrenciasNaoProcessadas = new ArrayList<>();
    private List<Ocorrencia> ocorrenciasProcessadas = new ArrayList<>();
    private List<Multa> multas = new ArrayList<>();
    private List<RegraMulta> regrasMulta = new ArrayList<>();

    // Inicialização das regras
    public void inicializaRegras() {
        regrasMulta.add(new RegraVelocidade(60, "Avenida Washington Luiz"));
        regrasMulta.add(new RegraVelocidade(70, "Avenida Nações Unidas"));
        regrasMulta.add(new RegraRodizio(1, new String[]{"Avenida Bandeirantes", "Avenida 23 de Maio"}, 1));
        regrasMulta.add(new RegraCorredorOnibus(6, 23, "Avenida Santo Amaro"));
        regrasMulta.add(new RegraCorredorOnibus(0, 24, "Avenida Vereador José Diniz"));
        // Adicionando mais regras (25 no total)
        regrasMulta.add(new RegraVelocidade(50, "Rua da Consolação"));
        regrasMulta.add(new RegraVelocidade(80, "Marginal Pinheiros"));
        regrasMulta.add(new RegraRodizio(2, new String[]{"Rua Augusta"}, 2));
        regrasMulta.add(new RegraRodizio(3, new String[]{"Avenida Paulista"}, 3));
        regrasMulta.add(new RegraCorredorOnibus(7, 22, "Avenida Brigadeiro Faria Lima"));
        // Continue adicionando regras conforme necessário
    }

    // Adicionar uma nova ocorrência
    public void adicionarOcorrencia(Ocorrencia ocorrencia) {
        ocorrenciasNaoProcessadas.add(ocorrencia);
    }

    // Processar todas as ocorrências não processadas
    public void processarOcorrencias() {
        for (Ocorrencia ocorrencia : ocorrenciasNaoProcessadas) {
            for (RegraMulta regra : regrasMulta) {
                Multa multa = regra.calcularMulta(ocorrencia);
                if (multa != null) {
                    multas.add(multa);
                }
            }
            ocorrenciasProcessadas.add(ocorrencia);
        }
        ocorrenciasNaoProcessadas.clear();
    }

    // Buscar multas por data
    public List<Multa> buscarMultasPorData(String data) {
        return multas.stream()
                .filter(multa -> multa.getDescricao().contains(data))
                .collect(Collectors.toList());
    }

    // Buscar multas por placa
    public List<Multa> buscarMultasPorPlaca(String placa) {
        return multas.stream()
                .filter(multa -> multa.getPlaca().equalsIgnoreCase(placa))
                .collect(Collectors.toList());
    }

    // Listar todas as ocorrências não processadas
    public List<Ocorrencia> listarOcorrenciasNaoProcessadas() {
        return new ArrayList<>(ocorrenciasNaoProcessadas);
    }

    // Listar todas as ocorrências processadas
    public List<Ocorrencia> listarOcorrenciasProcessadas() {
        return new ArrayList<>(ocorrenciasProcessadas);
    }

    // Listar todas as multas
    public List<Multa> listarMultas() {
        return new ArrayList<>(multas);
    }

    // Método para importar ocorrências de um arquivo
    public void importarOcorrenciasDeArquivo(String caminhoArquivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(",");
                if (dados.length == 4) {
                    String placa = dados[0].trim();
                    String logradouro = dados[1].trim();
                    String dataHora = dados[2].trim();
                    int tipoOcorrencia = Integer.parseInt(dados[3].trim());
                    Ocorrencia ocorrencia = new Ocorrencia(placa, logradouro, dataHora, tipoOcorrencia);
                    adicionarOcorrencia(ocorrencia);
                } else {
                    System.err.println("Linha inválida no arquivo: " + linha);
                }
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Erro ao converter tipo de ocorrência: " + e.getMessage());
        }
    }

    public List<RegraMulta> getRegrasMulta() {
        return regrasMulta;
    }

    public void adicionarRegra(RegraMulta regra) {
        regrasMulta.add(regra);
        System.out.println("Regra adicionada com sucesso: " + regra.obterDescricaoMulta());
    }

       public boolean validarDataHora(String dataHora) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            LocalDateTime.parse(dataHora, formatter);
            return true;
        } catch (DateTimeParseException e) {
            System.err.println("Data e hora inválidas: " + dataHora);
            return false;
        }
    }

    public boolean validarPlaca(String placa) {
        return placa.matches("[A-Z]{3}[0-9][A-Z0-9][0-9]{2}");
    }


    public void exportarMultasComoJSON(String caminhoArquivo) {
        Gson gson = new Gson();
        try (FileWriter writer = new FileWriter(caminhoArquivo)) {
            gson.toJson(multas, writer);
            System.out.println("Relatório exportado com sucesso em JSON para: " + caminhoArquivo);
        } catch (IOException e) {
            System.err.println("Erro ao exportar relatório JSON: " + e.getMessage());
        }
    }

    public void exportarMultasComoCSV(String caminhoArquivo) {
        try (FileWriter writer = new FileWriter(caminhoArquivo)) {
            writer.append("Placa,Logradouro,Descrição,Nível Multa,Valor Multa\n");
            for (Multa multa : multas) {
                writer.append(multa.getPlaca()).append(",")
                    .append(multa.getLogradouro()).append(",")
                    .append(multa.getDescricao()).append(",")
                    .append(String.valueOf(multa.getNivelMulta())).append(",")
                    .append(String.valueOf(multa.getValorMulta())).append("\n");
            }
            System.out.println("Relatório exportado com sucesso em CSV para: " + caminhoArquivo);
        } catch (IOException e) {
            System.err.println("Erro ao exportar relatório CSV: " + e.getMessage());
        }
    }


}