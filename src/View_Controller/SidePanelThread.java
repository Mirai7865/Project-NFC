/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View_Controller;

import BackendModels.*;
import javax.swing.JTextArea;

public class SidePanelThread implements Runnable {

    private BackendModels backendModels;
    private int selectedIndex;
    private MainDisplay mainDisplay;
    private JTextArea sidePanel;

    public SidePanelThread(BackendModels bem, MainDisplay mainDisplay, JTextArea textArea, int index) {
        this.backendModels = bem;
        this.selectedIndex = index;
        this.mainDisplay = mainDisplay;
        this.sidePanel = textArea;
    }

    @Override
    public void run() {
        this.backendModels.japanPrefecture[selectedIndex - 1].callAPI();
        String content = this.sidePanel.getText();
        content = content.replace(Localization.getLangDataAt(72), backendModels.japanPrefecture[selectedIndex - 1].getWeather());
        content = content.replace(Localization.getLangDataAt(72),  backendModels.japanPrefecture[selectedIndex - 1].getTemp());
        this.sidePanel.setText(content);
    }
}
