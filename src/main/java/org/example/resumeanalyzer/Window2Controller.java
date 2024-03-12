package org.example.resumeanalyzer;

import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.transform.Translate;

import java.net.URL;
import java.util.ResourceBundle;

public class Window2Controller implements Initializable {

    @FXML
    private Label matchPercentageLabel;

    @FXML
    private Label toImproveLabel;

    @FXML
    private ImageView circle;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Initialize the controller
        RotateTransition rotateTransition = new RotateTransition();
        rotateTransition.setNode(circle);
        rotateTransition.setCycleCount(TranslateTransition.INDEFINITE);
        rotateTransition.setInterpolator(Interpolator.LINEAR);
        rotateTransition.setByAngle(360);
        rotateTransition.play();
    }
    public void setMatchPercentage(int matchPercentage) {
        System.out.println(matchPercentage);
        matchPercentageLabel.setText(String.valueOf(matchPercentage)+"%");
    }

    public void setToImprove(String[] toImprove) {
        StringBuilder toImproveText = new StringBuilder();
        for (String s : toImprove) {
            toImproveText.append(s).append(", "); // Appending elements with a space delimiter
        }
        toImproveLabel.setText(toImproveText.toString().trim()); // Using trim() to remove trailing whitespace
    }

}
