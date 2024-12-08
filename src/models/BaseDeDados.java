package models;

import java.util.ArrayList;
import java.util.List;

public class BaseDeDados {
    private List<Ocorrencia> ocorrenciasNaoProcessadas = new ArrayList<>();
    private List<Ocorrencia> ocorrenciasProcessadas = new ArrayList<>();
    private List<Multa> multas = new ArrayList<>();

    public void inicializaRegras() {
        // Método a ser implementado em commits futuros
    }
}
