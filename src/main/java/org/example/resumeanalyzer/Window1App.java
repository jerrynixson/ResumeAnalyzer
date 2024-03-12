package org.example.resumeanalyzer;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class Window1App extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("window1-view.fxml"));
            Scene scene = new Scene(root);

            String css = this.getClass().getResource("style.css").toExternalForm();
            scene.getStylesheets().add(css);

            Image icon = new Image("file:C:\\Users\\jerry\\IdeaProjects\\ResumeAnalyzer\\src\\profile.png");
            stage.getIcons().add(icon);

            stage.setTitle("Resume Analyzer");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

