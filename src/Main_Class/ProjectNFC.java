/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main_Class;

import View_Controller.*;

public class ProjectNFC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        // TODO code application logic here
//        TranslatorApi trs = new TranslatorApi();
        SplashScreen splscrn = new SplashScreen();

        BackendModels backendModels = new BackendModels();
        splscrn.setCurrentWork("Getting the GUI ready...");
        MainDisplay mainDisplay = new MainDisplay(backendModels);
        MainDisplayController mdc = new MainDisplayController(backendModels, mainDisplay);
        splscrn.hide();
    }

}
