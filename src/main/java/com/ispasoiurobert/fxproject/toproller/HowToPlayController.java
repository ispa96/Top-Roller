package com.ispasoiurobert.fxproject.toproller;

import javafx.animation.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class HowToPlayController {

    @FXML
    private Button okButton;
    @FXML
    private Label howToPlayLabel;
    @FXML
    private Text howToPlayText;

    @FXML
    public void initialize() {
        TranslateTransition translateTransition = new TranslateTransition();
        translateTransition.setNode(howToPlayLabel);
        translateTransition.setDuration(Duration.seconds(1));
        translateTransition.setCycleCount(1);
        translateTransition.setFromY(-200);
        translateTransition.setToY(0);
        translateTransition.play();

        translateTransition.setOnFinished(actionEvent -> {
            TranslateTransition slideIn = new TranslateTransition(Duration.seconds(1), howToPlayText);
            slideIn.setFromX(-1000);
            slideIn.setToX(0);

            FadeTransition fadeIn = new FadeTransition(Duration.seconds(1), howToPlayText);
            fadeIn.setFromValue(0);
            fadeIn.setToValue(1);

            ParallelTransition appearAndSlide = new ParallelTransition(slideIn, fadeIn);
            appearAndSlide.play();

            appearAndSlide.setOnFinished(new EventHandler<ActionEvent>() {

                @Override
                public void handle(ActionEvent actionEvent) {

                    okButton.setDisable(false);

                    FadeTransition fadeInButton = new FadeTransition(Duration.seconds(1), okButton);
                    fadeInButton.setFromValue(0);
                    fadeInButton.setToValue(1);

                    ScaleTransition pulse = new ScaleTransition(Duration.seconds(1.5), okButton);
                    pulse.setFromX(1);
                    pulse.setFromY(1);
                    pulse.setToX(1.1);
                    pulse.setToY(1.1);
                    pulse.setAutoReverse(true);
                    pulse.setCycleCount(1);

                    ParallelTransition showAndPulse = new ParallelTransition(fadeInButton, pulse);
                    showAndPulse.play();
                }
            });
        });

    }

    public void clickOkButton(ActionEvent event) {
        Utils.switchScenes(event, "/com/ispasoiurobert/fxproject/toproller/MainScene.fxml", null, null, null);
    }
}
