package com.ispasoiurobert.fxproject.toproller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;

public class SettingsController {

    @FXML
    private RadioButton onRadioButton;
    @FXML
    private RadioButton offRadioButton;
    @FXML
    private ToggleGroup AudioToggleGroup;
    @FXML
    private Button backButton;

    @FXML
    public void initialize() {

        AudioToggleGroup.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {

            @Override
            public void changed(ObservableValue<? extends Toggle> observableValue, Toggle oldValue, Toggle newValue) {

                if(newValue == onRadioButton)
                    MediaPlayerSingleton.play();
                else if (newValue == offRadioButton)
                    MediaPlayerSingleton.pause();
            }
        });

        if(!MediaPlayerSingleton.isPlaying)
            offRadioButton.setSelected(true);
        else onRadioButton.setSelected(true);
    }

    public void clickBackButton(ActionEvent event) {
        Utils.switchScenes(event, "/com/ispasoiurobert/fxproject/toproller/MainScene.fxml", null, null, null);
    }
}
