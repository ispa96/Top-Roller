package com.ispasoiurobert.fxproject.toproller;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class MediaPlayerSingleton {

    private static MediaPlayer mediaPlayer;

    private static final String PATH = "/audios/background1.mp3";

    private MediaPlayerSingleton() {

    }

    private static MediaPlayer getMediaPlayer() {

        if (mediaPlayer == null) {
            Media media = new Media(MediaPlayerSingleton.class.getResource(PATH).toExternalForm());
            mediaPlayer = new MediaPlayer(media);
            mediaPlayer.setVolume(0.1);
            mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);

           /* mediaPlayer.setOnReady(() -> {
                System.out.println("Media player is ready and playing.");
            });*/
        }

        return mediaPlayer;
    }

    public static void play() {

        MediaPlayer player = getMediaPlayer();

        if (player.getStatus() != MediaPlayer.Status.PLAYING)
            player.play();
    }

    public static void pause() {

        MediaPlayer player = getMediaPlayer();

        if (player.getStatus() == MediaPlayer.Status.PLAYING) {
            player.pause();
        }
    }
}
