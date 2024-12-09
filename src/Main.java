import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import rules.RegraVelocidade;
import rules.RegraRodizio;
import rules.RegraCorredorOnibus;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        // Criar instâncias das regras
        RegraVelocidade regraVelocidade = new RegraVelocidade();
        RegraRodizio regraRodizio = new RegraRodizio();
        RegraCorredorOnibus regraCorredorOnibus = new RegraCorredorOnibus();

        // Criar os botões para aplicar as regras
        Button btnVelocidade = new Button("Aplicar Regra de Velocidade");
        Button btnRodizio = new Button("Aplicar Regra de Rodízio");
        Button btnCorredorOnibus = new Button("Aplicar Regra de Corredor de Ônibus");

        // Ações para os botões
        btnVelocidade.setOnAction(e -> {
            // Verifica a regra de velocidade e aplica a multa se necessário
            if (regraVelocidade.verificarRegra()) {
                regraVelocidade.aplicarMulta();
                showAlert("Multa de Velocidade Aplicada", "A multa foi aplicada por excesso de velocidade.");
            } else {
                showAlert("Sem Multa", "A velocidade está dentro do limite.");
            }
        });

        btnRodizio.setOnAction(e -> {
            // Verifica a regra de rodízio e aplica a multa se necessário
            if (regraRodizio.verificarRegra()) {
                regraRodizio.aplicarMulta();
                showAlert("Multa de Rodízio Aplicada", "A multa foi aplicada por infringir a regra de rodízio.");
            } else {
                showAlert("Sem Multa", "A restrição de rodízio não foi violada.");
            }
        });

        btnCorredorOnibus.setOnAction(e -> {
            // Verifica a regra de corredor de ônibus e aplica a multa se necessário
            if (regraCorredorOnibus.verificarRegra()) {
                regraCorredorOnibus.aplicarMulta();
                showAlert("Multa de Corredor de Ônibus Aplicada", "A multa foi aplicada por transitar no corredor de ônibus.");
            } else {
                showAlert("Sem Multa", "Você não transitou no corredor de ônibus.");
            }
        });

        // Layout da interface (Usando VBox para organizar os botões)
        VBox vbox = new VBox(10, btnVelocidade, btnRodizio, btnCorredorOnibus);
        Scene scene = new Scene(vbox, 300, 200);

        // Configurações da janela
        primaryStage.setTitle("Sistema de Multas");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Função para exibir alertas
    private void showAlert(String title, String message) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
