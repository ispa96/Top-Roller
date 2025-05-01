package com.ispasoiurobert.fxproject.toproller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

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
    public void initialize() {

        player1UsernameTextField.textProperty().addListener((observable, oldValue, newValue) -> checkTextFields());
        player2UsernameTextField.textProperty().addListener((observable, oldValue, newValue) -> checkTextFields());
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
