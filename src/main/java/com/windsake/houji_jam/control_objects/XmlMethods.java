package com.windsake.houji_jam.control_objects;
import com.windsake.houji_jam.Main;
import com.windsake.houji_jam.game_objects.Player;
import jaxb.JAXBHelper;

import javax.xml.bind.JAXBException;
import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * Class for the xml saving and loading methods.
 */
public class XmlMethods {
    public static File file;

    static {
        try {
            file = new File(Main.class.getProtectionDomain().getCodeSource().getLocation().toURI());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    /**
     * default constructor for the class.
     */
    public XmlMethods() {
    }

    /**
     * method to save the player's data into an xml file, outside of the jar.
     *
     * @param plr the player object to save into the xml
     */
    public void save(Player plr) {
        try {
            JAXBHelper.toXML(plr, System.out);
            JAXBHelper.toXML(plr, new FileOutputStream(file.getParent() + "/player_data.xml"));
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    /**
     * function that loads the player data from an external xml file, outside of the jar.
     *
     * @return the xml file's data as an object
     */
    public Player load() {
        Player plr = null;
        try {
            plr = JAXBHelper.fromXML(Player.class, new FileInputStream(file.getParent() + "/player_data.xml"));
         }catch(Exception e){
                 e.printStackTrace();
            }
        return plr;
    }
}

