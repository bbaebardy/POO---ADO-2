package models;

public class Multa {
    private String placa;
    private String logradouro;
    private String descricao;
    private int nivelMulta;
    private double valorMulta;

    public Multa(String placa, String logradouro, String descricao, int nivelMulta) {
        this.placa = placa;
        this.logradouro = logradouro;
        this.descricao = descricao;
        this.nivelMulta = nivelMulta;
        this.valorMulta = calcularValorMulta(nivelMulta);
    }

    // Método para calcular o valor da multa com base no nível
    private double calcularValorMulta(int nivelMulta) {
        switch (nivelMulta) {
            case 1: return RegraMulta.VALOR_MULTA_LEVE;
            case 2: return RegraMulta.VALOR_MULTA_MEDIA;
            case 3: return RegraMulta.VALOR_MULTA_GRAVE;
            default: return 0.0;
        }
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getNivelMulta() {
        return nivelMulta;
    }

    public void setNivelMulta(int nivelMulta) {
        this.nivelMulta = nivelMulta;
        this.valorMulta = calcularValorMulta(nivelMulta); // Atualiza o valor da multa
    }

    public double getValorMulta() {
        return valorMulta;
    }

    @Override
    public String toString() {
        return "Multa{" +
                "Placa='" + placa + '\'' +
                ", Logradouro='" + logradouro + '\'' +
                ", Descrição='" + descricao + '\'' +
                ", Nível Multa=" + nivelMulta +
                ", Valor Multa=" + valorMulta +
                '}';
    }
}
