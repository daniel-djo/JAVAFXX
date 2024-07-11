package de.game.controllers;

import java.io.IOException;

import de.game.Main;
import javafx.fxml.FXML;

public class GameMapSelectionController {
@FXML
    private void switchToMainMenu() throws IOException {
        Main.setRoot("mainMenu");
    }
}
