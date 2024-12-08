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
        // Lógica a ser implementada em commits futuros
        return null;
    }

    @Override
    public int verificaNivelMulta(Ocorrencia ocorrencia) {
        // Lógica a ser implementada em commits futuros
        return 0;
    }

    @Override
    public String obterDescricaoMulta() {
        return "Multa por excesso de velocidade no logradouro: " + logradouro;
    }
}
