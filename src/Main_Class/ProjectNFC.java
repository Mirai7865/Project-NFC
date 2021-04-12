/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main_Class;

import View_Controller.BackendModels;
import View_Controller.MainDisplayController;
import View_Controller.MainDisplay;
import BackendModels.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProjectNFC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            // TODO code application logic here
            TranslatorApi trs = new TranslatorApi();
        } catch (InterruptedException ex) {
            Logger.getLogger(ProjectNFC.class.getName()).log(Level.SEVERE, null, ex);
        }

        BackendModels backendModels = new BackendModels();
        MainDisplay mainDisplay = new MainDisplay(backendModels);
        MainDisplayController mdc = new MainDisplayController(backendModels, mainDisplay);
    }

}
