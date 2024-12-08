package models;

public class Multa {
    private String placa;
    private String logradouro;
    private String descricao;
    private int nivelMulta;

    public Multa(String placa, String logradouro, String descricao, int nivelMulta) {
        this.placa = placa;
        this.logradouro = logradouro;
        this.descricao = descricao;
        this.nivelMulta = nivelMulta;
    }

    // Getters e Setters
}
