package de.game.controllers;

import de.game.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import java.io.IOException;

public class Controller {

    @FXML
    private void switchToGame() throws IOException {
        Main.setRoot("gameView");
    }

    @FXML
    private void exitGame() {
        System.exit(0);
    }

    public void loadGame() {
    }

    public void showOptions() {
    }

    public void startGame() {
    }
}
