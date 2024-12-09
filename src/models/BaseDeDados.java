package models;

import models.BaseDeDados;
import models.Ocorrencia;
import models.Multa;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BaseDeDadosTest {

    private BaseDeDados baseDeDados;

    @BeforeEach
    public void setUp() {
        baseDeDados = new BaseDeDados();
        baseDeDados.inicializaRegras();
    }

    // Teste para verificar se as ocorrências podem ser adicionadas corretamente
    @Test
    public void testAdicionarOcorrencia() {
        Ocorrencia ocorrencia = new Ocorrencia("ABC1234", "Avenida Paulista", "2024-12-06 14:00:00", 1);
        baseDeDados.adicionarOcorrencia(ocorrencia);
        assertEquals(1, baseDeDados.listarOcorrenciasNaoProcessadas().size());
    }

    // Teste para verificar se a validação de placa funciona corretamente
    @Test
    public void testValidarPlacaValida() {
        assertTrue(baseDeDados.validarPlaca("ABC1234"));
    }

    @Test
    public void testValidarPlacaInvalida() {
        assertFalse(baseDeDados.validarPlaca("1234ABC"));
    }

    // Teste para verificar se a validação de data/hora funciona corretamente
    @Test
    public void testValidarDataHoraValida() {
        assertTrue(baseDeDados.validarDataHora("2024-12-06 14:00:00"));
    }

    @Test
    public void testValidarDataHoraInvalida() {
        assertFalse(baseDeDados.validarDataHora("2024-12-06 25:00:00"));
    }

    // Teste para verificar se as multas são geradas corretamente após o processamento
    @Test
    public void testProcessarOcorrencias() {
        Ocorrencia ocorrencia = new Ocorrencia("ABC1234", "Avenida Paulista", "2024-12-06 14:00:00", 1);
        baseDeDados.adicionarOcorrencia(ocorrencia);
        baseDeDados.processarOcorrencias();

        assertEquals(1, baseDeDados.listarMultas().size());
    }

    // Teste para exportar multas em formato JSON
    @Test
    public void testExportarMultasComoJSON() {
        baseDeDados.exportarMultasComoJSON("multas_test.json");
        // Aqui você poderia adicionar um código para verificar se o arquivo JSON foi realmente gerado,
        // mas para simplificação estamos apenas testando a execução do método.
    }

    // Teste para exportar multas em formato CSV
    @Test
    public void testExportarMultasComoCSV() {
        baseDeDados.exportarMultasComoCSV("multas_test.csv");
        // Similar ao JSON, pode-se testar se o arquivo foi gerado corretamente.
    }
}
