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
    public void start(@SuppressWarnings("exports") Stage primaryStage) throws IOException {
        Main.primaryStage = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("/de/game/view/mainMenu.fxml"));
        System.out.println("'mainMenu.fxml' successfully loaded: " + (root != null));
        Scene scene = new Scene(root, 800, 600);
        scene.getStylesheets().add(getClass().getResource("/de/game/view/styles.css").toExternalForm());
        primaryStage.setTitle("Modern Wars");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void setRoot(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/de/game/view/" + fxml + ".fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = primaryStage.getScene();
        if (scene == null) {
            scene = new Scene(root, 800, 600);
            primaryStage.setScene(scene);
        } else {
            scene.setRoot(root);
        }
        scene.getStylesheets().add(Main.class.getResource("/de/game/view/styles.css").toExternalForm());

        System.out.println("Switched scene to: " + fxml);
    }

    public static void setScene(@SuppressWarnings("exports") FXMLLoader fxmlLoader) throws IOException {
        Parent root = fxmlLoader.getRoot();
        Scene scene = primaryStage.getScene();
        if (scene == null) {
            scene = new Scene(root, 800, 600);
            primaryStage.setScene(scene);
        } else {
            scene.setRoot(root);
        }
        scene.getStylesheets().add(Main.class.getResource("/de/game/view/styles.css").toExternalForm());
    }

    @SuppressWarnings("exports")
    public static FXMLLoader getLoader(String fxml) throws IOException {
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("/de/game/view/" + fxml + ".fxml"));
        loader.load();
        return loader;
    }

    @SuppressWarnings("exports")
    public static Stage getPrimaryStage() {
        return primaryStage;
    }    

    public static void main(String[] args) {
        launch(args);
    }
}
