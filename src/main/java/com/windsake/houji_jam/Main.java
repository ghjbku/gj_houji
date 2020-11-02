package com.windsake.houji_jam;

import com.windsake.houji_jam.control_objects.XmlMethods;
import com.windsake.houji_jam.game_objects.Player;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main extends Application {
    private XmlMethods xml_methods = new XmlMethods();
    private Player player = new Player();
    private static Stage primarystage;
    public static boolean play_pressed = false;
    final ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();

    public Main() throws URISyntaxException {
    }

    /**
     * start method of the program , that comes with the Application extension.
     *
     * @param primaryStage the Stage.
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
        primaryStage.setTitle("Houji Game Jam Project");
        primaryStage.setScene(new Scene(root, 1024, 768));
        primaryStage.show();
        primarystage = primaryStage;
        executorService.scheduleAtFixedRate(this::start_play_button_loop, 0, 1, TimeUnit.SECONDS);
    }

    public void start_play_button_loop() {
        if (!play_pressed) {
            System.out.println("not pressed");
        }
        else if (play_pressed){
            System.out.println("pressed");
        }
    }

    /**
     * method that uses the <code>XmlMethods</code> class as its base to save the playerdata into the xml file.
     *
     * @throws FileNotFoundException the xml file doesnt exists.
     * @throws JAXBException         if there is an error with the xml file.
     */
    public void savetoxml() throws FileNotFoundException, JAXBException {
        xml_methods.save(player);
    }

    /**
     * method that uses the <code>XmlMethods</code> class as its base to load the playerdata from the xml .
     *
     * @throws JAXBException         if there is an error with the xml file.
     * @throws FileNotFoundException the xml file doesnt exists.
     */
    public void readxml() throws JAXBException, FileNotFoundException {
        Player loadplayer = xml_methods.load();
        player = loadplayer;

    }

    /**
     * method to start the game and change the stage's scene from the main screen into the first level: ForestScene.
     *
     * @throws IOException   error occured with the fxml file.
     * @throws JAXBException if there is an error with the xml file.
     */
    public void start_game() throws IOException, JAXBException {
        savetoxml();
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
    public Player getPlayer() {
        return player;
    }

}
