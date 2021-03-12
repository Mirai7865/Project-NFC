/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main_Class;

import Controller.*;
import BackendModels.*;

public class ProjectNFC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
//        WeatherAPI.getForecast("Chiba");
        Localization.setLang("en-us");
        BackendModels backendModels = new BackendModels();
        MainDisplay mainDisplay = new MainDisplay(backendModels);
        MainDisplayController mdc = new MainDisplayController(backendModels, mainDisplay);
    }

}