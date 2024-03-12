package org.example.resumeanalyzer;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class Window2App extends Application {
    public int matchPercentage;
    private String[] toImprove;

    public Window2App(int matchPercentage, String[] toImprove) {
        this.matchPercentage = matchPercentage;
        this.toImprove = toImprove;
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("window2-view.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);

        String css = this.getClass().getResource("style.css").toExternalForm();
        scene.getStylesheets().add(css);

        Window2Controller controller = loader.getController();
        controller.setMatchPercentage(matchPercentage);
        controller.setToImprove(toImprove);
        stage.setTitle("Resume Analyzer");

        Image icon = new Image("file:C:\\Users\\jerry\\IdeaProjects\\ResumeAnalyzer\\src\\profile.png");
        stage.getIcons().add(icon);

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

