package com.windsake.houji_jam.controllers;

import com.windsake.houji_jam.Main;
import com.windsake.houji_jam.game_objects.Images;
import com.windsake.houji_jam.game_objects.Player;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import java.net.MalformedURLException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class StageController {
    final Timeline timeline = new Timeline();

    @FXML
    public Label Monologe_label;

    private Images images = new Images();
    String monologe_1 = "Welcome my dear friend! It's time you finally arrived!";
    //String[] Monologe1_characters = monologe_1.split(",");

    public StageController() throws MalformedURLException {
    }

    @FXML
    public void on_click() {
        Monologe_label.setText("");
        final IntegerProperty i = new SimpleIntegerProperty(0);
        Timeline timeline = new Timeline();
        KeyFrame keyFrame = new KeyFrame(
                Duration.seconds(.15),
                event -> {
                    if (i.get() > monologe_1.length()) {
                        timeline.stop();
                        System.out.println("stopped");
                    } else {
                        Monologe_label.setText(monologe_1.substring(0, i.get()));
                        i.set(i.get() + 1);
                    }
                });
        timeline.getKeyFrames().add(keyFrame);
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
        }
       // timeline.stop();
}

