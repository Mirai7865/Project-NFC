/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.nfc;

import javax.swing.JTextArea;

public class SidePanelUpdater implements Runnable {

    private boolean run;
    private JTextArea sidePanel;
    private BackendModels backendModels;
    private int selectedIndex;
    private MainDisplay mainDisplay;

    public SidePanelUpdater(BackendModels bem, MainDisplay mainDisplay, int index) {
        this.run = true;
        this.backendModels = bem;
        this.selectedIndex = index;
        this.mainDisplay = mainDisplay;
    }

    @Override
    public void run() {
        backendModels.japanPrefecture[selectedIndex - 1].setWeatherForecast();
        mainDisplay.sidePanel.append("\n" + backendModels.japanPrefecture[selectedIndex - 1].getWeatherForecast());
//        System.out.println(backendModels.japanPrefecture[selectedIndex - 1].getWeatherForecast());
    }
}
