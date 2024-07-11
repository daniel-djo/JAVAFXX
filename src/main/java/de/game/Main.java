package de.game;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    private static Stage primaryStage;

    @Override
    public void start(Stage primaryStage) throws IOException {
        Main.primaryStage = primaryStage; // Set the primary stage
        Parent root = FXMLLoader.load(getClass().getResource("/de/game/view/mainMenu.fxml"));
        Scene scene = new Scene(root, 800, 600);
        scene.getStylesheets().add(getClass().getResource("/de/game/view/styles.css").toExternalForm());
        primaryStage.setTitle("Advance Wars");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void setRoot(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/de/game/view/" + fxml + ".fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root, 800, 600);
        scene.getStylesheets().add(Main.class.getResource("/de/game/view/styles.css").toExternalForm());
        primaryStage.setScene(scene);
    }
    

    public static void main(String[] args) {
        launch(args);
    }
}