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
        int nivel = verificaNivelMulta(ocorrencia);
        if (nivel > 0) {
            return new Multa(ocorrencia.getPlaca(), logradouro, obterDescricaoMulta(), nivel);
        }
        return null;
    }

    @Override
    public int verificaNivelMulta(Ocorrencia ocorrencia) {
        // Supor que tipoOcorrencia é a hora do evento
        int hora = ocorrencia.getTipoOcorrencia();
        return (hora >= horaInicio && hora <= horaFim) ? 1 : 0;
    }

    @Override
    public String obterDescricaoMulta() {
        return "Multa por uso irregular de corredor de ônibus no logradouro: " + logradouro;
    }
}
