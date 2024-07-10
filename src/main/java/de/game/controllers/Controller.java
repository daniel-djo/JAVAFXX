package de.game.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class Controller {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onFirstButtonClick() {
        welcomeText.setText("Test");
    }
}