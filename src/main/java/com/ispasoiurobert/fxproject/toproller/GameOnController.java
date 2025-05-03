package com.ispasoiurobert.fxproject.toproller;

import javafx.animation.FadeTransition;
import javafx.animation.ParallelTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
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
    private Button rollButton;
    @FXML
    private Button nextPlayerButton;
    @FXML
    private ImageView firstDieImageView;
    @FXML
    private ImageView secondDieImageView;

    private String player1Username;
    private String player2Username;

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
    }
}
