package models;

public abstract class RegraMulta {
    protected static final double VALOR_MULTA_LEVE = 100.00;
    protected static final double VALOR_MULTA_MEDIA = 200.00;
    protected static final double VALOR_MULTA_GRAVE = 300.00;

    public abstract Multa calcularMulta(Ocorrencia ocorrencia);
    public abstract int verificaNivelMulta(Ocorrencia ocorrencia);
    public abstract String obterDescricaoMulta();
}
