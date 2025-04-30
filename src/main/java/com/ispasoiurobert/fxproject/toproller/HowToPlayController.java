package com.ispasoiurobert.fxproject.toproller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class HowToPlayController {

    @FXML
    private Button okButton;

    @FXML
    public void initialize() {

    }

    public void clickOkButton(ActionEvent event) {
        Utils.switchScenes(event, "/com/ispasoiurobert/fxproject/toproller/MainScene.fxml", null, null);
    }
}
