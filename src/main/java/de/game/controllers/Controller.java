package de.game.controllers;

import de.game.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import java.io.IOException;

public class Controller {

    @FXML
    private void switchToMapSelection() throws IOException {
        Main.setRoot("gameMapSelection");
    }

    @FXML
    private void switchToGame() throws IOException {
        Main.setRoot("gameView.fxml");
    }

    @FXML
    private void exitGame() {
        System.exit(0);
    }

    @FXML
    private void showOptions() {
    }

    @FXML
    private void startGame() {
    }
}
