package com.example.epj2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

/**
 * The main application class for the JavaFX application.
 * This class initializes and shows the main window of the application.
 */
public class MainWindow extends Application {

    /**
     * Starts the JavaFX application by setting up the main stage.
     * @param stage the primary stage for this application
     * @throws IOException if an I/O error occurs during loading the FXML file
     */
    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(MainWindow.class.getResource("mainWindow.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1180, 810);
        stage.setScene(scene);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.show();
    }

    /**
     * The main entry point for the JavaFX application.
     * This method launches the JavaFX application.
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch();
    }
}