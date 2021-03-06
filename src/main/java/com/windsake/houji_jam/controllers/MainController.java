package com.windsake.houji_jam.controllers;

import com.windsake.houji_jam.Main;
import com.windsake.houji_jam.control_objects.XmlMethods;
import com.windsake.houji_jam.game_objects.Player;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class MainController {
    private static XmlMethods xml_methods = new XmlMethods();

    @FXML
    public ImageView play_button;
    @FXML
    public TextField player_name_box;

    public MainController() {
    }

    @FXML
    public void onclick() {
        try {
            if (!player_name_box.getText().isEmpty()) {
                Player player = Main.getPlayer();
                player.setName(player_name_box.getText());
                xml_methods.save(player);
            }
            Main.start_game();
        } catch (Exception e) {
            e.printStackTrace();
        }

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
