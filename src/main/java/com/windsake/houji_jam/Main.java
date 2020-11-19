package com.windsake.houji_jam;

import com.windsake.houji_jam.control_objects.XmlMethods;
import com.windsake.houji_jam.game_objects.Player;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    private static XmlMethods xml_methods = new XmlMethods();
    private static Player player = new Player("Player");
    private static Stage primarystage;

    public Main() {
    }

    /**
     * start method of the program , that comes with the Application extension.
     *
     * @param primaryStage the Stage.
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Views/Main.fxml"));
        primaryStage.setTitle("Houji Game Jam Project");
        primaryStage.setScene(new Scene(root, 1024, 768));
        primaryStage.show();
        primarystage = primaryStage;
    }

    /**
     * method that uses the <code>XmlMethods</code> class as its base to save the playerdata into the xml file.
     */
    public static void savetoxml() {
        xml_methods.save(player);
    }

    /**
     * method that uses the <code>XmlMethods</code> class as its base to load the playerdata from the xml .
     */
    public static void readxml() {
        Player loadplayer = xml_methods.load();
        System.out.println("player name: "+loadplayer.getName());
        player = loadplayer;
    }

    /**
     * method to start the game and change the stage's scene from the main screen into the game level.
     *
     * @throws IOException error occured with the fxml file.
     */
    public static void start_game() throws IOException {
       try {
            readxml();
        }
       catch (Exception e){
           e.printStackTrace();
           savetoxml();
       }
        Parent root = FXMLLoader.load(Main.class.getResource("Views/Stage.fxml"));
        primarystage.setScene(new Scene(root, 1024, 768));
        primarystage.show();
        System.out.println("game starting now");
    }

    /**
     * main method of the program.
     *
     * @param args optional arguments.
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * a function that is used to get the class's stage.
     *
     * @return primarystage, which is the Start method's parameter
     */
    public static Stage getPrimarystage() {
        return primarystage;
    }

    /**
     * getter that returns the player.
     *
     * @return player obj.
     */
    public static Player getPlayer() {
        return player;
    }

}
