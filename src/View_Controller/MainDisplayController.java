package View_Controller;

import BackendModels.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
public class MainDisplayController {

    BackendModels backendModels;
    MainDisplay mainDisplay;

    private int selectedIndex = 0;
    private int sort = 0;

    public MainDisplayController(BackendModels models, MainDisplay mainDisplay) {
        this.backendModels = models;
        this.mainDisplay = mainDisplay;
        this.initialSetup();
    }

    private void initialSetup() {
        this.mainDisplay.langJpButton.addActionListener(new ChangeLanguageToJaAction());
        this.mainDisplay.langEnButton.addActionListener(new ChangeLanguageToEnAction());
        this.mainDisplay.caseNumberList.addMouseListener(new openSidePanelAction());
        this.mainDisplay.sortByRiskButton.addActionListener(new SortAction());
    }

    private class ChangeLanguageToJaAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            Localization.setLang("ja-jp");
            mainDisplay.updateCaseNumberTextPane();
            mainDisplay.caseNumberPane.setBorder(BorderFactory.createTitledBorder(Localization.getLangDataAt(51)));
            mainDisplay.mapPanel.setBorder(BorderFactory.createTitledBorder(Localization.getLangDataAt(50)));
            mainDisplay.updateSidePanel(selectedIndex);
        }
    }

    private class ChangeLanguageToEnAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            Localization.setLang("en-us");
            mainDisplay.updateCaseNumberTextPane();
            mainDisplay.caseNumberPane.setBorder(BorderFactory.createTitledBorder(Localization.getLangDataAt(51)));
            mainDisplay.mapPanel.setBorder(BorderFactory.createTitledBorder(Localization.getLangDataAt(50)));
            mainDisplay.updateSidePanel(selectedIndex);
        }
    }

    private class SortAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            if (sort == 0) {
                mainDisplay.sortByRisk();
                mainDisplay.sortByRiskButton.setText("Sort By Total Case Number");
                sort = 1;
            } else if (sort == 1) {
                mainDisplay.sortByCaseNumber();
                mainDisplay.sortByRiskButton.setText("Reset sort");
                sort = 2;
            } else {
                mainDisplay.sortByRegionNumber();
                mainDisplay.sortByRiskButton.setText("Sort By Risk");
                sort = 0;
            }
        }
    }

    private class openSidePanelAction implements MouseListener {

        @Override
        public void mouseExited(MouseEvent me) {

        }

        @Override
        public void mouseReleased(MouseEvent me) {
            selectedIndex = mainDisplay.caseNumberList.getSelectedIndex();
            mainDisplay.updateSidePanel(selectedIndex);
            if (selectedIndex - 1 >= 0) {
                if (backendModels.japanPrefecture[selectedIndex - 1].getWeather().equals("Updating...")) {
                    SidePanelThread updater = new SidePanelThread(backendModels, mainDisplay, mainDisplay.sidePanel, selectedIndex);
                    Thread updaterThread = new Thread(updater);
                    updaterThread.start();
                }
            }
        }

        @Override
        public void mouseClicked(MouseEvent e) {
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }
    }
}
