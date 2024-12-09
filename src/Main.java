

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.control.*;
import javafx.geometry.Insets;
import models.*;

public class main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        // Criar instâncias das regras com os parâmetros necessários
        RegraVelocidade regraVelocidade = new RegraVelocidade(80, "Avenida Paulista");
        RegraRodizio regraRodizio = new RegraRodizio(2, new String[]{"Rua 1", "Rua 2"}, 5);
        RegraCorredorOnibus regraCorredorOnibus = new RegraCorredorOnibus(7, 9, "Avenida Faria Lima");

        // Criar os campos de entrada para os dados da ocorrência
        TextField placaField = new TextField();
        placaField.setPromptText("Placa do Veículo");

        TextField velocidadeField = new TextField();
        velocidadeField.setPromptText("Velocidade (km/h)");

        ComboBox<Integer> diaSemanaComboBox = new ComboBox<>();
        diaSemanaComboBox.getItems().addAll(1, 2, 3, 4, 5, 6, 7); // Dias da semana (1 = segunda-feira, 7 = domingo)
        diaSemanaComboBox.setPromptText("Dia da Semana");

        Spinner<Integer> horaSpinner = new Spinner<>(0, 23, 0);
        horaSpinner.setPromptText("Hora da Infração");

        Button btnAplicarMulta = new Button("Aplicar Multa");

        // Ação do botão para aplicar as multas
        btnAplicarMulta.setOnAction(e -> {
            // Verificar se todos os campos foram preenchidos corretamente
            String placa = placaField.getText();
            double velocidade = 0;
            int diaSemana = diaSemanaComboBox.getValue();
            int hora = horaSpinner.getValue();

            try {
                velocidade = Double.parseDouble(velocidadeField.getText());
            } catch (NumberFormatException ex) {
                showAlert("Erro", "Por favor, insira um valor numérico válido para a velocidade.");
                return;
            }

            if (placa.isEmpty() || diaSemanaComboBox.getValue() == null) {
                showAlert("Erro", "Por favor, preencha todos os campos.");
                return;
            }

            // Criar a ocorrência com os dados fornecidos
            Ocorrencia ocorrencia = new Ocorrencia(placa, "Algum Logradouro", "2024-12-08 " + hora + ":00:00", 1);

            // Verificar as regras e aplicar as multas
            if (regraVelocidade.verificarRegra(ocorrencia)) {
                regraVelocidade.aplicarMulta(ocorrencia);
            } else if (regraRodizio.verificarRegra(ocorrencia)) {
                regraRodizio.aplicarMulta(ocorrencia);
            } else if (regraCorredorOnibus.verificarRegra(ocorrencia)) {
                regraCorredorOnibus.aplicarMulta(ocorrencia);
            } else {
                showAlert("Sem Multa", "Não foi detectada nenhuma infração.");
            }
        });

        // Layout da interface
        VBox vbox = new VBox(10, placaField, velocidadeField, diaSemanaComboBox, horaSpinner, btnAplicarMulta);
        vbox.setPadding(new Insets(20));

        // Configurações da janela
        Scene scene = new Scene(vbox, 300, 250);
        primaryStage.setTitle("Sistema de Multas");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Função para exibir alertas
    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}