package models;

public class RegraVelocidade extends RegraMulta {
    private int limiteVelocidade;
    private String logradouro;

    public RegraVelocidade(int limiteVelocidade, String logradouro) {
        this.limiteVelocidade = limiteVelocidade;
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
        // Supor que tipoOcorrencia indica a velocidade registrada no evento
        int velocidade = ocorrencia.getTipoOcorrencia();
        return velocidade > limiteVelocidade ? 3 : 0;
    }

    @Override
    public String obterDescricaoMulta() {
        return "Multa por excesso de velocidade no logradouro: " + logradouro +
               ", limite de " + limiteVelocidade + " km/h.";
    }
}
