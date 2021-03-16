/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import BackendModels.*;

public class SidePanelThread implements Runnable {

    private BackendModels backendModels;
    private int selectedIndex;
    private MainDisplay mainDisplay;

    public SidePanelThread(BackendModels bem, MainDisplay mainDisplay, int index) {
        this.backendModels = bem;
        this.selectedIndex = index;
        this.mainDisplay = mainDisplay;
    }

    @Override
    public void run() {
        this.backendModels.japanPrefecture[selectedIndex - 1].callAPI();
        String content = this.mainDisplay.sidePanel.getText();
        content = content.replace("Weather: Updating...", "Weather: " + backendModels.japanPrefecture[selectedIndex - 1].getWeatherForecast());
        content = content.replace("Temperature: Updating...", "Temperature: " + backendModels.japanPrefecture[selectedIndex - 1].getTemp());
        this.mainDisplay.sidePanel.setText(content);
    }
}
