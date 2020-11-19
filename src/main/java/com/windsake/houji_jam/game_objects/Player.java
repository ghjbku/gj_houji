package com.windsake.houji_jam.game_objects;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Player {
    private String Name;
    private int Power;

    public Player(){}
    public Player(String name){
       Name=name;
    }

    public int getPower() {
        return Power;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setPower(int power) {
        Power = power;
    }
}
