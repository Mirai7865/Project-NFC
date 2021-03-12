/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import BackendModels.*;
import javax.swing.JTextArea;

public class SidePanelThread implements Runnable {

    private boolean run;
    private JTextArea sidePanel;
    private BackendModels backendModels;
    private int selectedIndex;
    private MainDisplay mainDisplay;

    public SidePanelThread(BackendModels bem, MainDisplay mainDisplay, int index) {
        this.run = true;
        this.backendModels = bem;
        this.selectedIndex = index;
        this.mainDisplay = mainDisplay;
    }

    @Override
    public void run() {
        this.backendModels.japanPrefecture[selectedIndex - 1].setWeatherForecast();
        String content = this.mainDisplay.sidePanel.getText();
        content = content.replaceAll("Updating...", backendModels.japanPrefecture[selectedIndex - 1].getWeatherForecast());
        this.mainDisplay.sidePanel.setText(content);
    }
}
