package com.windsake.houji_jam.controllers;

import com.windsake.houji_jam.Main;
import com.windsake.houji_jam.game_objects.Images;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;

import java.net.MalformedURLException;

public class StageController {

    @FXML
    public ImageView play_button;
    private Images images = new Images();

    public StageController() throws MalformedURLException {
    }

    @FXML
    public void onclick() {
    }
    @FXML
    public void on_enter() {
        play_button.setScaleX(1.1);
        play_button.setScaleY(1.1);
    }

    @FXML
    public void on_exit() {
        play_button.setScaleX(1);
        play_button.setScaleY(1);
    }
}
