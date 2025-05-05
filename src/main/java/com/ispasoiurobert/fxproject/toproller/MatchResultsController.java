package com.ispasoiurobert.fxproject.toproller;

import javafx.animation.FadeTransition;
import javafx.animation.ParallelTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.util.Duration;

public class MatchResultsController {

    @FXML
    private Label firstPlayerScoreLabel;
    @FXML
    private Label secondPlayerScoreLabel;
    @FXML
    private Label displayWinnerLabel;
    @FXML
    private Button playAgainButton;

    private int firstPlayerScore = 0;
    private int secondPlayerScore = 0;

    private boolean scoresWereSet = false;

    private String firstPlayerUsername;
    private String secondPlayerUsername;

    @FXML
    public void initialize() {

        displayWinnerLabel.setOpacity(0);

        playAgainButton.setDisable(true);
        playAgainButton.setOpacity(0);

        if(scoresWereSet && firstPlayerScoreLabel != null && secondPlayerScoreLabel != null) {
            firstPlayerScoreLabel.setText(firstPlayerUsername + " rolled " + firstPlayerScore);
            secondPlayerScoreLabel.setText(secondPlayerUsername + " rolled " + secondPlayerScore);
        }

        labelAnimation(firstPlayerScoreLabel);
        labelAnimation(secondPlayerScoreLabel);
    }

    public void setScores(String firstPlayerUsernameAndScore, String secondPlayerUsernameAndScore) {

        String[] firstPlayerParts = firstPlayerUsernameAndScore.split(" ");
        String[] secondPlayerParts = secondPlayerUsernameAndScore.split(" ");

        firstPlayerUsername = firstPlayerParts[0];
        secondPlayerUsername = secondPlayerParts[0];

        this.firstPlayerScore = Integer.parseInt(firstPlayerParts[1]);
        this.secondPlayerScore = Integer.parseInt(secondPlayerParts[1]);
        this.scoresWereSet = true;

        if(firstPlayerScoreLabel != null && secondPlayerScoreLabel != null) {
            firstPlayerScoreLabel.setText(firstPlayerUsername + " rolled " + firstPlayerScore);
            secondPlayerScoreLabel.setText(secondPlayerUsername + " rolled " + secondPlayerScore);
        }

        labelAnimation(firstPlayerScoreLabel);
        labelAnimation(secondPlayerScoreLabel);
    }

    public void labelAnimation(Label label) {
        TranslateTransition translateTransition1 = new TranslateTransition();
        translateTransition1.setNode(label);
        translateTransition1.setDuration(Duration.seconds(1));

        translateTransition1.setFromY(-200);

        translateTransition1.setToY(0);
        translateTransition1.play();

        translateTransition1.setOnFinished(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent actionEvent) {

                if(firstPlayerScore > secondPlayerScore)
                    displayWinnerLabel.setText(firstPlayerUsername.toUpperCase() + " Wins!");
                else if(secondPlayerScore > firstPlayerScore)
                    displayWinnerLabel.setText(secondPlayerUsername.toUpperCase() + " Wins!");
                else displayWinnerLabel.setText("TIE!");

                displayWinnerLabel.setOpacity(1);

                ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(500), displayWinnerLabel);
                scaleTransition.setFromX(1.0);
                scaleTransition.setFromY(1.0);
                scaleTransition.setToX(1.2);
                scaleTransition.setToY(1.2);
                scaleTransition.setCycleCount(ScaleTransition.INDEFINITE);
                scaleTransition.setAutoReverse(true);

                FadeTransition fadeTransition = new FadeTransition(Duration.millis(500), displayWinnerLabel);
                fadeTransition.setFromValue(0);
                fadeTransition.setToValue(1);
                fadeTransition.setCycleCount(1);

                ParallelTransition parallelTransition = new ParallelTransition(scaleTransition, fadeTransition);

                parallelTransition.play();

                playAgainButton.setDisable(false);
                FadeTransition fadeTransition1 = new FadeTransition(Duration.millis(500), playAgainButton);
                fadeTransition1.setFromValue(0);
                fadeTransition1.setToValue(1);
                fadeTransition1.setCycleCount(1);
                fadeTransition1.play();
            }
        });
    }

    public void clickPlayAgainButton(ActionEvent event) {
        Utils.switchScenes(event, "/com/ispasoiurobert/fxproject/toproller/MainScene.fxml", null, null, null);
    }
}
