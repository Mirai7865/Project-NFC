/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.nfc;

import javax.swing.JTextArea;

public class SidePanelUpdater implements Runnable {

    private boolean run;
    public JTextArea sidePanel;
    public BackendModels backendModels;
    private int selectedIndex;

    public SidePanelUpdater(BackendModels bem, int index) {
        this.run = true;
        this.backendModels = bem;
        this.selectedIndex = index;
    }

    @Override
    public void run() {
        while (this.run) {
            this.backendModels.japanPrefecture[selectedIndex - 1].setWeatherForecast();
        }
    }
}
