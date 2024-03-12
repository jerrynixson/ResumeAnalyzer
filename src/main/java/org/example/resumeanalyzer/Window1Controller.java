package org.example.resumeanalyzer;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class Window1Controller implements Initializable {

    @FXML
    private Button filePickerButton;

    private String selectedFilePath;

    @FXML
    private Button analyzeButton;

    String myJob;

    @FXML
    private Pane pane;

    @FXML
    private void FilePickerButtonAction() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Upload PDF");

        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("PDF files (*.pdf)", "*.pdf");
        fileChooser.getExtensionFilters().add(extFilter);

        Stage pstage = (Stage) filePickerButton.getScene().getWindow();
        File selectedFile = fileChooser.showOpenDialog(pstage);

        if (selectedFile != null) {
            selectedFilePath = selectedFile.getAbsolutePath();
            // Use the selectedFilePath as needed
            System.out.println(selectedFilePath);
        }
    }

    @FXML
    private ChoiceBox<String> jobChoiceBox;

    private DBconnect DBConnect;
    String[] jobs = DBConnect.getJobTitles();

    @FXML
    public void initialize(URL arg0, ResourceBundle arg1) {
        jobChoiceBox.getItems().addAll(jobs);
        jobChoiceBox.setOnAction(this::getJob);
        analyzeButton.setOnAction(event -> {
            openWindow2();

            Stage stage = (Stage) analyzeButton.getScene().getWindow();
            stage.close();

        });
    }

    public void getJob(ActionEvent event) {
        myJob = jobChoiceBox.getValue();
        System.out.println(myJob);
    }

    //private void analyzeButtonAction (ActionEvent event) {
        //if (myJob == null || myJob.isEmpty()) {
            //showAlert("Error", "Please select a job from the list.");
        //} else if (selectedFilePath == null || selectedFilePath.isEmpty()) {
            //showAlert("Error", "Please select a file to analyze");
        //} else {
            //try {
                //Analyse me = new Analyse(selectedFilePath, myJob);
                //openWindow2();
                //Stage stage = (Stage) analyzeButton.getScene().getWindow();
                //stage.close();
            //} catch (Exception e) {
                //e.printStackTrace();
                //showAlert("Error", "An error occurred while analyzing the file: " + e.getMessage());
            //}
        //}
    //}

    //private void showAlert(String title, String content) {
        //Alert alert = new Alert(Alert.AlertType.ERROR);
        //alert.setTitle(title);
        //alert.setHeaderText(null);
        //alert.setContentText(content);
        //alert.showAndWait();
    //}

    private void openWindow2() {
        try {
            Analyse me = new Analyse(selectedFilePath, myJob);
            Window2App window2 = new Window2App(me.matchPercentage, me.toImprove);
            window2.start(new Stage());
            Stage stage = (Stage) analyzeButton.getScene().getWindow();
            stage.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}





