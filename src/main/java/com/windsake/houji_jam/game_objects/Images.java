package com.windsake.houji_jam.game_objects;

import com.windsake.houji_jam.Main;
import javafx.scene.image.Image;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * a class that contains all the images the game has.
 */
public class Images {
    /**
     * default constructor.
     *
     * @throws MalformedURLException throws when the url given is wrong.
     */
    public Images() throws MalformedURLException {
    }

    URL play_button_image1_url = new URL(Main.class.getResource("images/play.jpg").toExternalForm());
    private final Image play_button1_img = new Image(play_button_image1_url.toExternalForm());
    URL play_button_image2_url = new URL(Main.class.getResource("images/castle.jpg").toExternalForm());
    private final Image play_button2_img = new Image(play_button_image2_url.toExternalForm());
    URL player_image_url = new URL(Main.class.getResource("images/player.png").toExternalForm());
    private final Image player_img = new Image(player_image_url.toExternalForm());

    /**
     * function that returns an Image based on the string it got as param.
     *
     * @param str the "unique identifier" of the Image the program needs.
     * @return an Image.
     */
    public Image getimage(String str) {

        switch (str){
            case "p1":
                return play_button1_img;

            case "p2":
                return play_button2_img;

            case "player":
                return player_img;

            default:
                return null;
        }

       /* if (str.equals("p1")) {
            return play_button1_img;
        } else if (str.equals("p2")) {
            return play_button2_img;
        }
        return null;*/
    }
}
