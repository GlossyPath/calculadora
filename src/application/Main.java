package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        try {
            AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("/vista/CalculadoraFX.fxml"));
            Scene scene = new Scene(root);
            scene.getStylesheets().add(getClass().getResource("/vista/css/style.css").toExternalForm());
            primaryStage.setScene(scene);
            primaryStage.setTitle("CalculadoraFx");
            primaryStage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}