package de.game.controllers;

import java.io.IOException;

import de.game.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

public class GameMapSelectionController {

    @FXML
    private void switchToMainMenu() throws IOException {
        Main.setRoot("mainMenu");
    }

    @FXML
    private void createMapLI() throws IOException {
        char[][] map = {
            {'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S'},
            {'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'P', 'W', 'P', 'P', 'P', 'W', 'S'},
            {'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'P', 'T', 'T', 'T', 'T', 'T', 'T', 'T', 'P', 'P', 'S'},
            {'S', 'S', 'S', 'S', 'S', 'S', 'S', 'M', 'P', 'T', 'P', 'W', 'P', 'P', 'P', 'P', 'P', 'P', 'S'},
            {'S', 'S', 'S', 'S', 'S', 'W', 'P', 'W', 'W', 'T', 'P', 'P', 'P', 'W', 'P', 'W', 'P', 'S', 'S'},
            {'S', 'S', 'W', 'P', 'P', 'P', 'W', 'P', 'P', 'T', 'W', 'W', 'W', 'P', 'S', 'S', 'S', 'S', 'S'},
            {'S', 'P', 'P', 'P', 'P', 'P', 'W', 'W', 'P', 'T', 'P', 'M', 'S', 'S', 'S', 'S', 'S', 'S', 'S'},
            {'S', 'P', 'P', 'T', 'T', 'T', 'T', 'T', 'T', 'T', 'P', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S'},
            {'S', 'W', 'P', 'P', 'P', 'W', 'P', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S'},
            {'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S'}
        };

        char[][] unitMap ={
            {'I', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '}
        };
        switchToGame(map, unitMap);
    }

    @FXML
    private void createMapES() throws IOException {
        char[][] map = {
            {'W', 'P', 'P', 'P', 'W', 'T', 'T', 'T', 'T', 'T', 'T', 'T', 'T', 'T', 'T', 'T', 'T', 'P', 'W'},
            {'P', 'P', 'P', 'P', 'S', 'S', 'M', 'W', 'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P', 'T', 'P', 'P'},
            {'P', 'P', 'P', 'P', 'S', 'S', 'S', 'W', 'P', 'P', 'P', 'P', 'W', 'P', 'P', 'P', 'T', 'P', 'W'},
            {'P', 'P', 'W', 'S', 'S', 'S', 'S', 'S', 'W', 'W', 'S', 'S', 'P', 'P', 'P', 'W', 'T', 'P', 'P'},
            {'S', 'T', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'M', 'W', 'P', 'P', 'T', 'M', 'P'},
            {'P', 'P', 'P', 'P', 'W', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'W', 'P', 'W', 'T', 'W', 'P'},
            {'P', 'P', 'P', 'P', 'W', 'S', 'S', 'T', 'T', 'S', 'S', 'S', 'W', 'P', 'P', 'P', 'T', 'P', 'P'},
            {'P', 'P', 'P', 'P', 'P', 'S', 'T', 'T', 'S', 'S', 'S', 'S', 'W', 'P', 'W', 'P', 'T', 'W', 'P'},
            {'P', 'P', 'T', 'T', 'T', 'T', 'T', 'S', 'S', 'S', 'S', 'S', 'T', 'T', 'T', 'T', 'T', 'P', 'P'},
            {'P', 'M', 'T', 'P', 'W', 'W', 'S', 'S', 'S', 'S', 'S', 'T', 'T', 'S', 'W', 'P', 'P', 'P', 'P'},
            {'P', 'P', 'T', 'P', 'P', 'W', 'S', 'S', 'S', 'S', 'T', 'T', 'S', 'S', 'W', 'P', 'P', 'P', 'P'},
            {'P', 'P', 'T', 'W', 'P', 'W', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'P', 'P', 'M'},
            {'M', 'P', 'T', 'P', 'P', 'P', 'M', 'W', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'T', 'S'},
            {'P', 'W', 'T', 'P', 'W', 'P', 'P', 'P', 'P', 'W', 'P', 'S', 'S', 'S', 'S', 'S', 'P', 'P', 'P'},
            {'P', 'P', 'T', 'P', 'P', 'P', 'W', 'P', 'P', 'P', 'W', 'P', 'S', 'S', 'S', 'S', 'W', 'P', 'P'},
            {'W', 'P', 'T', 'P', 'P', 'P', 'W', 'W', 'P', 'P', 'P', 'P', 'W', 'S', 'S', 'P', 'P', 'P', 'P'},
            {'W', 'P', 'T', 'T', 'T', 'T', 'T', 'T', 'T', 'T', 'T', 'T', 'T', 'T', 'W', 'P', 'P', 'P', 'W'}
        };

        char[][] unitMap ={
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '}
        };
        switchToGame(map, unitMap); 
    }

    @FXML
    private void createMapPD() throws IOException {
        char[][] map = {
            {'P', 'P', 'P', 'W', 'W', 'P', 'P', 'P', 'P', 'P', 'P', 'W', 'W', 'W', 'W', 'P', 'P', 'P', 'P', 'P', 'P', 'W', 'W', 'P', 'P', 'P'},
            {'W', 'P', 'T', 'T', 'T', 'T', 'T', 'T', 'T', 'T', 'T', 'T', 'T', 'T', 'T', 'T', 'T', 'T', 'T', 'T', 'T', 'T', 'T', 'T', 'P', 'P'},
            {'W', 'P', 'T', 'W', 'P', 'P', 'W', 'P', 'P', 'W', 'P', 'W', 'T', 'T', 'W', 'P', 'P', 'W', 'P', 'P', 'W', 'P', 'P', 'T', 'P', 'W'},
            {'P', 'P', 'T', 'P', 'W', 'P', 'P', 'P', 'W', 'S', 'S', 'W', 'T', 'T', 'W', 'S', 'S', 'W', 'P', 'W', 'P', 'P', 'P', 'T', 'P', 'W'},
            {'P', 'P', 'T', 'P', 'P', 'P', 'P', 'W', 'S', 'S', 'S', 'W', 'T', 'T', 'W', 'S', 'S', 'S', 'W', 'P', 'P', 'P', 'P', 'T', 'P', 'P'},
            {'S', 'S', 'T', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'P', 'T', 'T', 'P', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'T', 'S', 'S'},
            {'S', 'S', 'T', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'P', 'T', 'T', 'P', 'P', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'T', 'S', 'S'},
            {'S', 'S', 'T', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'W', 'T', 'T', 'P', 'W', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'T', 'S', 'S'},
            {'S', 'S', 'T', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'P', 'T', 'T', 'P', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'T', 'S', 'S'},
            {'P', 'P', 'T', 'P', 'W', 'W', 'W', 'P', 'S', 'S', 'S', 'W', 'T', 'T', 'W', 'S', 'S', 'S', 'P', 'W', 'W', 'W', 'P', 'T', 'P', 'P'},
            {'P', 'P', 'T', 'P', 'P', 'P', 'P', 'P', 'P', 'S', 'S', 'W', 'T', 'T', 'W', 'S', 'S', 'P', 'W', 'P', 'P', 'P', 'P', 'T', 'P', 'P'},
            {'W', 'P', 'T', 'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P', 'W', 'T', 'T', 'W', 'P', 'P', 'W', 'P', 'P', 'P', 'P', 'P', 'T', 'P', 'W'},
            {'W', 'P', 'T', 'T', 'T', 'T', 'T', 'T', 'T', 'T', 'T', 'T', 'T', 'T', 'T', 'T', 'T', 'T', 'T', 'T', 'T', 'T', 'T', 'T', 'P', 'W'},
            {'P', 'P', 'P', 'W', 'W', 'P', 'P', 'P', 'P', 'P', 'P', 'W', 'W', 'W', 'W', 'P', 'P', 'P', 'P', 'P', 'P', 'W', 'W', 'P', 'P', 'P'}
        };

        char[][] unitMap ={
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '}
        };
        switchToGame(map, unitMap); 
    }

    private void switchToGame(char[][] map, char[][] unitMap) throws IOException {
        FXMLLoader loader = Main.getLoader("gameView");
        GameController controller = loader.getController();
        controller.createGrid(map, unitMap);

        Main.setScene(loader);
    }
}
