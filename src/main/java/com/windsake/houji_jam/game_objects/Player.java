package com.windsake.houji_jam.game_objects;

public class Player {
    private String Name;
    private int Power;

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
