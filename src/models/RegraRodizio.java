package models;

public class RegraRodizio extends RegraMulta {
    private int diaSemana;
    private String[] logradouros;
    private int digitoFinalPlaca;

    public RegraRodizio(int diaSemana, String[] logradouros, int digitoFinalPlaca) {
        this.diaSemana = diaSemana;
        this.logradouros = logradouros;
        this.digitoFinalPlaca = digitoFinalPlaca;
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
        return "Multa por desrespeitar rodízio de veículos.";
    }
}
