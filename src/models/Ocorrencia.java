package models;

public class Ocorrencia {
    private String placa;
    private String logradouro;
    private String dataHora;
    private int tipoOcorrencia;

    public Ocorrencia(String placa, String logradouro, String dataHora, int tipoOcorrencia) {
        this.placa = placa;
        this.logradouro = logradouro;
        this.dataHora = dataHora;
        this.tipoOcorrencia = tipoOcorrencia;
    }

    // Getters e Setters
}
