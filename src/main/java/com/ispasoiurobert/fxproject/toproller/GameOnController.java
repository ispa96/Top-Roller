package com.ispasoiurobert.fxproject.toproller;

import javafx.animation.FadeTransition;
import javafx.animation.ParallelTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class GameOnController {

    @FXML
    private Label playersTurnLabel;
    @FXML
    private Label playersScore;
    @FXML
    private Button rollButton;
    @FXML
    private Button nextPlayerButton;
    @FXML
    private ImageView firstDieImageView;
    @FXML
    private ImageView secondDieImageView;

    private String player1Username;
    private String player2Username;

    private int player1Score = 0;
    private int player2Score = 0;

    private int score = 0;

    private boolean playersWereSet = false;

    public void setPlayers(String player1Username, String player2Username) {
        this.player1Username = player1Username;
        this.player2Username = player2Username;
        this.playersWereSet = true;

        if (playersTurnLabel != null) {
            playersTurnLabel.setText(player1Username.toUpperCase() + "'s turn");
        }
    }

    @FXML
    public void initialize() {
        if (playersWereSet && player1Username != null) {
            playersTurnLabel.setText(player1Username.toUpperCase() + "'s turn");
        }

        nextPlayerButton.setOpacity(0);
        playersScore.setOpacity(0);
    }

    public void clickRollButton(ActionEvent event) {
        rollButton.setDisable(true);

        FadeTransition fadeOutRollButton = new FadeTransition(Duration.seconds(1), rollButton);
        fadeOutRollButton.setFromValue(1);
        fadeOutRollButton.setToValue(0);

        fadeOutRollButton.setOnFinished(actionEvent -> {
            DieComingAnimation(firstDieImageView, 1);
            DieComingAnimation(secondDieImageView, 2);

            nextPlayerButton.setDisable(false);
            FadeTransition showNextPlayerButton = new FadeTransition(Duration.seconds(1), nextPlayerButton);
            showNextPlayerButton.setFromValue(0);
            showNextPlayerButton.setToValue(1);
            showNextPlayerButton.play();
        });

        fadeOutRollButton.play();
    }


    public void DieComingAnimation(ImageView imageView, int dieCounter) {
        int rolledValue = (int)(Math.random() * 6) + 1;
        score += rolledValue;

        String imagePath = "/images/die" + rolledValue + ".png";
        Image diceImage = new Image(getClass().getResourceAsStream(imagePath));
        imageView.setImage(diceImage);

        TranslateTransition translateTransition = new TranslateTransition(Duration.seconds(1), imageView);
        if (dieCounter == 1)
            translateTransition.setFromX(-700);
        else
            translateTransition.setFromX(700);
        translateTransition.setToX(0);

        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(1), imageView);
        fadeTransition.setFromValue(0);
        fadeTransition.setToValue(1);

        ParallelTransition transition = new ParallelTransition(translateTransition, fadeTransition);
        transition.play();

        transition.setOnFinished(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent actionEvent) {

                if(dieCounter == 2) {
                    if(player1Score != 0) {
                        player2Score = score;
                    }
                    else player1Score = score;
                }

                playersScore.setText("You rolled " + score + "!");
                FadeTransition showScoreTransition = new FadeTransition(Duration.seconds(1), playersScore);
                showScoreTransition.setFromValue(0);
                showScoreTransition.setToValue(1);
                showScoreTransition.play();
            }
        });
    }

    public void clickNextPlayerButton(ActionEvent event) {

        if(nextPlayerButton.getText().equals("Match Results")) {
            Utils.switchScenes(event, "/com/ispasoiurobert/fxproject/toproller/MatchResultsScene.fxml", null, null);
        }

        nextPlayerButton.setText("Match Results");

        nextPlayerButton.setOpacity(0);
        playersTurnLabel.setText(player2Username.toUpperCase() + "'s turn");
        playersScore.setOpacity(0);
        score = 0;
        firstDieImageView.setOpacity(0);
        secondDieImageView.setOpacity(0);
        rollButton.setDisable(false);
        rollButton.setOpacity(1);

        /*System.out.println("Player1 score: " + player1Score);
        System.out.println("Player2 score: " + player2Score);*/
    }
}
