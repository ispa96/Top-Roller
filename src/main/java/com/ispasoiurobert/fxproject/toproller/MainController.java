package com.ispasoiurobert.fxproject.toproller;

import javafx.animation.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainController {

    @FXML
    private Label welcomeLabel;
    @FXML
    private Label infoLabel;
    @FXML
    private Button startGameButton, howToPlayButton, settingsButton;
    @FXML
    private ImageView die1ImageView, die2ImageView, die3ImageView, die4ImageView, die5ImageView, die6ImageView;

    @FXML
    public void initialize() {

        final ArrayList<ImageView> imageViews = new ArrayList<>(Arrays.asList(
                die1ImageView, die2ImageView, die3ImageView,
                die4ImageView, die5ImageView, die6ImageView));

        double delay = 2.0;

        for (ImageView imageView : imageViews) {
            FadeTransition fadeIn = new FadeTransition(Duration.seconds(1), imageView);
            fadeIn.setFromValue(0);
            fadeIn.setToValue(1);
            fadeIn.setCycleCount(Animation.INDEFINITE);

            ScaleTransition pulse = new ScaleTransition(Duration.seconds(1), imageView);
            pulse.setFromX(1);
            pulse.setFromY(1);
            pulse.setToX(1.1);
            pulse.setToY(1.1);
            pulse.setCycleCount(Animation.INDEFINITE);

            ParallelTransition showAndPulse = new ParallelTransition(fadeIn, pulse);
            showAndPulse.setDelay(Duration.seconds(delay));
            showAndPulse.play();

            delay += 0.1;
        }


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
                    howToPlayButton.setDisable(false);
                    startGameButton.setDisable(false);
                    settingsButton.setDisable(false);

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

    public void clickHowToPlayButton(ActionEvent event) {
        Utils.switchScenes(event, "/com/ispasoiurobert/fxproject/toproller/HowToPlayScene.fxml", null, null);
    }

    public void clickStartGameButton(ActionEvent event) {
        Utils.switchScenes(event, "/com/ispasoiurobert/fxproject/toproller/ChoosePlayersUsernamesScene.fxml", null, null);
    }
}