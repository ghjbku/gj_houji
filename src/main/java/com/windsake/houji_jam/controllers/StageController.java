package com.windsake.houji_jam.controllers;

import javafx.animation.*;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Point2D;
import javafx.scene.control.Label;
import javafx.scene.robot.Robot;
import javafx.scene.shape.Line;
import javafx.scene.shape.QuadCurve;
import javafx.util.Duration;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class StageController {
    final Timeline timeline = new Timeline();
    private AnimationTimer timer;
    private int counter = 1;

    @FXML
    public Label Monologe_label;
    @FXML
    public Line bow_body;
    @FXML
    public QuadCurve bow_line;

    String monologe_1 = "Welcome dear Children! It's time for tonight's tale!";
    String monologe_2 = "This time I've decided to tell you all about a Legendary Archer...";
    String monologe_3 = "His name was Hou Ji, and for those who did not hear of him yet, let me tell you a story...";
    private double start_x = 0;
    private double start_y = 0;
    double end_x = 0;
    double end_y = 0;
    private double x_dif = 0;
    private double y_dif = 0;
    private Integer i = 0;

    public StageController() {
    }

    //one can add a specific action when the keyframe is reached
    EventHandler onFinished = new EventHandler<ActionEvent>() {
        public void handle(ActionEvent t) {
            bow_line.setControlX(50);
            bow_line.setControlX(0);
            //reset counter
            i = 0;
        }
    };

    @FXML
    public void on_click() {
        Monologe_label.setText("");
        final IntegerProperty i = new SimpleIntegerProperty(0);
        Timeline timeline = new Timeline();
        switch (counter) {
            case 1:
                KeyFrame keyFrame = new KeyFrame(
                        Duration.seconds(.15),
                        event -> {
                            if (i.get() > monologe_1.length()) {
                                timeline.stop();
                                System.out.println("stopped");
                                counter++;
                            } else {
                                Monologe_label.setText(monologe_1.substring(0, i.get()));
                                i.set(i.get() + 1);
                            }
                        });
                timeline.getKeyFrames().add(keyFrame);
                timeline.setCycleCount(Animation.INDEFINITE);
                timeline.play();
                break;
            case 2:
                keyFrame = new KeyFrame(
                        Duration.seconds(.15),
                        event -> {
                            if (i.get() > monologe_2.length()) {
                                timeline.stop();
                                System.out.println("stopped");
                                counter++;
                            } else {
                                Monologe_label.setText(monologe_2.substring(0, i.get()));
                                i.set(i.get() + 1);
                            }
                        });
                timeline.getKeyFrames().add(keyFrame);
                timeline.setCycleCount(Animation.INDEFINITE);
                timeline.play();
                break;
            case 3:
                keyFrame = new KeyFrame(
                        Duration.seconds(.15),
                        event -> {
                            if (i.get() > monologe_3.length()) {
                                timeline.stop();
                                System.out.println("stopped");
                                counter++;
                            } else {
                                Monologe_label.setText(monologe_3.substring(0, i.get()));
                                i.set(i.get() + 1);
                            }
                        });
                timeline.getKeyFrames().add(keyFrame);
                timeline.setCycleCount(Animation.INDEFINITE);
                timeline.play();
                break;
        }
    }

    @FXML
    public void bow_start_drag() {
        timeline.setCycleCount(2);
        timeline.setAutoReverse(true);
        Robot robot = new Robot();
        Point2D point = robot.getMousePosition();
        start_x = point.getX();
        start_y = point.getY();
        System.out.println("x = " + start_x);
        System.out.println("y = " + start_y);

        timer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                System.out.println(i.toString());
                if (Math.floorMod(i,2)==0) {
                    end_x = point.getX() - start_x;
                    end_y = point.getY() - start_y;
                }
                i++;
            }
        };

        KeyValue keyValueX = new KeyValue( bow_line.controlXProperty(), -(end_x / 2));
        KeyValue keyValueY = new KeyValue( bow_line.controlYProperty(), (end_y / 2));

        //create a keyFrame, the keyValue is reached at time 2s ///////bow_line.setControlX(-(end_x / 2));

        KeyFrame keyFrame = new KeyFrame(Duration.millis(100), (ActionEvent t)->{
            bow_line.setControlX(50);
            bow_line.setControlX(0);
            //reset counter
            i = 0;
            timeline.pause();
        } , keyValueX, keyValueY);

        //add the keyframe to the timeline
        timeline.getKeyFrames().add(keyFrame);
        timeline.play();
        timer.start();

    }

    @FXML
    public void bow_stop_drag() {
        timeline.play();
        Robot robot = new Robot();
        Point2D point = robot.getMousePosition();
        double end_x = point.getX();
        double end_y = point.getY();
        System.out.println("x = " + end_x);
        System.out.println("y = " + end_y);
        x_dif = Math.abs(end_x - start_x);
        y_dif = Math.abs(end_y - start_y);
        System.out.println("x diff = " + x_dif + "\ny diff = " + y_dif);
        timer.stop();
    }
}

