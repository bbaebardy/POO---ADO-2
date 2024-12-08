package models;

public class Ocorrencia {
    private String placa;
    private String logradouro;
    private String dataHora; // Formato esperado: "yyyy-MM-dd HH:mm:ss"
    private int tipoOcorrencia; // Dados adicionais, como velocidade ou hora para regras

    public Ocorrencia(String placa, String logradouro, String dataHora, int tipoOcorrencia) {
        this.placa = placa;
        this.logradouro = logradouro;
        this.dataHora = dataHora;
        this.tipoOcorrencia = tipoOcorrencia;
    }

    // Getters e Setters
    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getDataHora() {
        return dataHora;
    }

    public void setDataHora(String dataHora) {
        this.dataHora = dataHora;
    }

    public int getTipoOcorrencia() {
        return tipoOcorrencia;
    }

    public void setTipoOcorrencia(int tipoOcorrencia) {
        this.tipoOcorrencia = tipoOcorrencia;
    }

    @Override
    public String toString() {
        return "Ocorrência{" +
                "Placa='" + placa + '\'' +
                ", Logradouro='" + logradouro + '\'' +
                ", Data/Hora='" + dataHora + '\'' +
                ", Tipo Ocorrência=" + tipoOcorrencia +
                '}';
    }
}
