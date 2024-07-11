package de.game;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class Main extends Application {
    private static Stage primaryStage;
    public static String viewPath = "/de/game/view/";

    @Override
    public void start(Stage primaryStage) throws IOException {
        Main.primaryStage = primaryStage;

        String mainMenuFXML = viewPath + "mainMenu.fxml";
        System.out.println("Loading mainMenu.fxml from: " + getClass().getResource(mainMenuFXML));

        FXMLLoader loader = new FXMLLoader(getClass().getResource(mainMenuFXML));
        BorderPane root = loader.load();

        String stylesCSS = viewPath + "styles.css";
        System.out.println("Loading styles.css from: " + getClass().getResource(stylesCSS));

        Scene scene = new Scene(root);
        scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource(stylesCSS)).toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void setRoot(String fxml) throws IOException {
        String fxmlPath = viewPath + fxml;
        System.out.println("Loading " + fxml + " from: " + Main.class.getResource(fxmlPath));

        FXMLLoader loader = new FXMLLoader(Main.class.getResource(fxmlPath));
        BorderPane root = loader.load();
        String stylesCSS = viewPath + "styles.css";
        System.out.println("Loading styles.css from: " + Main.class.getResource(stylesCSS));

        Scene scene = new Scene(root);
        scene.getStylesheets().add(Objects.requireNonNull(Main.class.getResource(stylesCSS)).toExternalForm());
        primaryStage.setScene(scene);
    }

    public static void main(String[] args) {
        launch();
    }
}
