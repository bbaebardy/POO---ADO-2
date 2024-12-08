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
        int nivel = verificaNivelMulta(ocorrencia);
        if (nivel > 0) {
            return new Multa(ocorrencia.getPlaca(), String.join(", ", logradouros), obterDescricaoMulta(), nivel);
        }
        return null;
    }

    @Override
    public int verificaNivelMulta(Ocorrencia ocorrencia) {
        // Supor que tipoOcorrencia é o dia da semana
        int dia = ocorrencia.getTipoOcorrencia();
        int placaFinal = Integer.parseInt(ocorrencia.getPlaca().substring(ocorrencia.getPlaca().length() - 1));
        return (dia == diaSemana && placaFinal == digitoFinalPlaca) ? 2 : 0;
    }

    @Override
    public String obterDescricaoMulta() {
        return "Multa por desrespeitar rodízio nos logradouros: " + String.join(", ", logradouros) +
               ". Dia da semana: " + diaSemana;
    }
}
