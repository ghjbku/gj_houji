package com.windsake.houji_jam.control_objects;
import com.windsake.houji_jam.Main;
import com.windsake.houji_jam.game_objects.Player;
import jaxb.JAXBHelper;

import javax.xml.bind.JAXBException;
import java.io.*;
import java.net.URISyntaxException;


/**
 * Class for the xml saving and loading methods.
 */
public class XmlMethods {
    File file = new File(Main.class.getProtectionDomain().getCodeSource().getLocation().toURI());

    /**
     * default constructor for the class.
     */
    public XmlMethods() throws URISyntaxException {
    }

    /**
     * method to save the player's data into an xml file, outside of the jar.
     *
     * @param plr the player object to save into the xml
     * @throws JAXBException         if there is an error with the xml file
     * @throws FileNotFoundException if the file does not exist
     */
    public void save(Player plr) throws FileNotFoundException, JAXBException {
        JAXBHelper.toXML(plr, System.out);
        JAXBHelper.toXML(plr, new FileOutputStream(file.getParent() + "/player_data.xml"));
    }

    /**
     * function that loads the player data from an external xml file, outside of the jar.
     *
     * @return the xml file's data as an object
     * @throws JAXBException if there is an error with the xml file
     * @throws FileNotFoundException if the xml file is missing.
     */
    public Player load() throws JAXBException, FileNotFoundException {
        return JAXBHelper.fromXML(Player.class, new FileInputStream(file.getParent() + "/player_data.xml"));
    }

}

