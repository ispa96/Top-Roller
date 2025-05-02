package com.ispasoiurobert.fxproject.toproller;

import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.util.Duration;

public class ChoosePlayersUsernamesController {

    @FXML
    private Button playButton;
    @FXML
    private Button backButton;
    @FXML
    private TextField player1UsernameTextField;
    @FXML
    private TextField player2UsernameTextField;
    @FXML
    private Label player1UsernameLabel;
    @FXML
    private Label player2UsernameLabel;
    @FXML
    private Label choosePlayersUsernamesLabel;

    @FXML
    public void initialize() {

        player1UsernameTextField.textProperty().addListener((observable, oldValue, newValue) -> checkTextFields());
        player2UsernameTextField.textProperty().addListener((observable, oldValue, newValue) -> checkTextFields());

        TranslateTransition translateTransition1 = new TranslateTransition();
        translateTransition1.setNode(player1UsernameLabel);
        translateTransition1.setDuration(Duration.seconds(1));
        translateTransition1.setFromX(-500);
        translateTransition1.setToX(0);
        translateTransition1.play();

        TranslateTransition translateTransition2 = new TranslateTransition();
        translateTransition2.setNode(player2UsernameLabel);
        translateTransition2.setDuration(Duration.seconds(1));
        translateTransition2.setFromX(500);
        translateTransition2.setToX(0);
        translateTransition2.play();

        choosePlayersUsernamesLabel.setOpacity(0);
        FadeTransition fadeTransition = new FadeTransition();
        fadeTransition.setNode(choosePlayersUsernamesLabel);
        fadeTransition.setFromValue(0);
        fadeTransition.setToValue(1);
        fadeTransition.setDuration(Duration.seconds(1));
        fadeTransition.play();
    }

    private void checkTextFields() {
        String text1 = player1UsernameTextField.getText();
        String text2 = player2UsernameTextField.getText();

        playButton.setDisable(text1.isEmpty() || text2.isEmpty() || text1.equals(text2));
    }

    public void clickBackButton(ActionEvent event) {
        Utils.switchScenes(event, "/com/ispasoiurobert/fxproject/toproller/MainScene.fxml", null, null);
    }
}
