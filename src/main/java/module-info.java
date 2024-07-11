module de.game {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    opens de.game to javafx.fxml;
    exports de.game;
    exports de.game.controllers;
    opens de.game.controllers to javafx.fxml;
}