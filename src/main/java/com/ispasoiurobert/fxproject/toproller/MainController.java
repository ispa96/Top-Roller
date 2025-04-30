package com.ispasoiurobert.fxproject.toproller;

import javafx.animation.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

public class MainController {

    @FXML
    private Label welcomeLabel;
    @FXML
    private Label infoLabel;
    @FXML
    private Button startGameButton, howToPlayButton, settingsButton;

    @FXML
    public void initialize() {
        RotateTransition rotateTransition = new RotateTransition();
        rotateTransition.setNode(welcomeLabel);
        rotateTransition.setDuration(Duration.seconds(1));
        rotateTransition.setCycleCount(2);
        rotateTransition.setInterpolator(Interpolator.LINEAR);
        rotateTransition.setByAngle(360);
        rotateTransition.setAxis(Rotate.Y_AXIS);
        rotateTransition.play();

        ScaleTransition scaleTransition = new ScaleTransition();
        scaleTransition.setNode(welcomeLabel);
        scaleTransition.setDuration(Duration.seconds(1));
        scaleTransition.setCycleCount(2);
        scaleTransition.setInterpolator(Interpolator.LINEAR);
        scaleTransition.setByX(2);
        scaleTransition.setByY(2);
        scaleTransition.setAutoReverse(true);
        scaleTransition.play();

        scaleTransition.setOnFinished(actionEvent -> {

            FadeTransition fadeTransition = new FadeTransition();
            fadeTransition.setNode(infoLabel);
            fadeTransition.setDuration(Duration.seconds(1));
            fadeTransition.setCycleCount(1);
            fadeTransition.setInterpolator(Interpolator.LINEAR);
            fadeTransition.setFromValue(0);
            fadeTransition.setToValue(1);
            fadeTransition.play();

            fadeTransition.setOnFinished(new EventHandler<ActionEvent>() {

                @Override
                public void handle(ActionEvent actionEvent) {
                    FadeTransition fadeTransition = new FadeTransition();
                    fadeTransition.setNode(howToPlayButton);
                    fadeTransition.setDuration(Duration.seconds(1));
                    fadeTransition.setCycleCount(1);
                    fadeTransition.setInterpolator(Interpolator.LINEAR);
                    fadeTransition.setFromValue(0);
                    fadeTransition.setToValue(1);
                    fadeTransition.play();

                    FadeTransition fadeTransition1 = new FadeTransition();
                    fadeTransition1.setNode(startGameButton);
                    fadeTransition1.setDuration(Duration.seconds(1));
                    fadeTransition1.setCycleCount(1);
                    fadeTransition1.setInterpolator(Interpolator.LINEAR);
                    fadeTransition1.setFromValue(0);
                    fadeTransition1.setToValue(1);
                    fadeTransition1.play();

                    FadeTransition fadeTransition2 = new FadeTransition();
                    fadeTransition2.setNode(settingsButton);
                    fadeTransition2.setDuration(Duration.seconds(1));
                    fadeTransition2.setCycleCount(1);
                    fadeTransition2.setInterpolator(Interpolator.LINEAR);
                    fadeTransition2.setFromValue(0);
                    fadeTransition2.setToValue(1);
                    fadeTransition2.play();
                }
            });
        });
    }
}