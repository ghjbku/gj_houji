package com.windsake.houji_jam.controllers;

import com.windsake.houji_jam.Main;
import com.windsake.houji_jam.game_objects.Images;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import java.net.MalformedURLException;

public class MainController {

    @FXML
    public ImageView play_button;
    private Images images = new Images();

    public MainController() throws MalformedURLException {
    }

    @FXML
    public void onclick() {
        Main.play_pressed = true;
        play_button.setImage(images.getimage("p2"));
    }

}
