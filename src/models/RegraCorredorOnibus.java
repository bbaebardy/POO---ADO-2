package models;

public class RegraCorredorOnibus extends RegraMulta {
    private int horaInicio;
    private int horaFim;
    private String logradouro;

    public RegraCorredorOnibus(int horaInicio, int horaFim, String logradouro) {
        this.horaInicio = horaInicio;
        this.horaFim = horaFim;
        this.logradouro = logradouro;
    }

    @Override
    public Multa calcularMulta(Ocorrencia ocorrencia) {
        return null;
    }

    @Override
    public int verificaNivelMulta(Ocorrencia ocorrencia) {
        return 0;
    }

    @Override
    public String obterDescricaoMulta() {
        return "Multa por uso irregular de corredor de ônibus.";
    }
}
