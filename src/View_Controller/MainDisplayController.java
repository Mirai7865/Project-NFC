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

    private int selectedIndexCaseNumberField = 0;
    private int selectedIndexLanguageField = 0;
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
//        this.mainDisplay.langChoices.addMouseListener(new chooseLanguageAction());
        this.mainDisplay.langChoiceApply.addActionListener(new ApplyLangSettingAction());
    }

    private class ChangeLanguageToJaAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            Localization.setLang("ja");
            mainDisplay.updateCaseNumberTextPane();
            mainDisplay.caseNumberPane.setBorder(BorderFactory.createTitledBorder(Localization.getLangDataAt(51)));
            mainDisplay.mapPanel.setBorder(BorderFactory.createTitledBorder(Localization.getLangDataAt(50)));
            mainDisplay.updateSidePanel(selectedIndexCaseNumberField);
        }
    }

    private class ChangeLanguageToEnAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            Localization.setLang("en");
            mainDisplay.updateCaseNumberTextPane();
            mainDisplay.caseNumberPane.setBorder(BorderFactory.createTitledBorder(Localization.getLangDataAt(51)));
            mainDisplay.mapPanel.setBorder(BorderFactory.createTitledBorder(Localization.getLangDataAt(50)));
            mainDisplay.updateSidePanel(selectedIndexCaseNumberField);
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
            selectedIndexCaseNumberField = mainDisplay.caseNumberList.getSelectedIndex();
            mainDisplay.updateSidePanel(selectedIndexCaseNumberField);
            if (selectedIndexCaseNumberField - 1 >= 0) {
                if (backendModels.japanPrefecture[selectedIndexCaseNumberField - 1].getWeather().equals("Updating...")) {
                    SidePanelThread updater = new SidePanelThread(backendModels, mainDisplay, mainDisplay.sidePane, selectedIndexCaseNumberField);
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

    private class ApplyLangSettingAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            selectedIndexLanguageField = mainDisplay.langChoices.getSelectedIndex();
            if (selectedIndexLanguageField == 0) {
                Localization.setLang("en");
            } else if (selectedIndexLanguageField == 1) {
                Localization.setLang("ja");
            }
            mainDisplay.updateCaseNumberTextPane();
            mainDisplay.caseNumberPane.setBorder(BorderFactory.createTitledBorder(Localization.getLangDataAt(51)));
            mainDisplay.mapPanel.setBorder(BorderFactory.createTitledBorder(Localization.getLangDataAt(50)));
            mainDisplay.mainPane.setTitleAt(0, Localization.getLangDataAt(52));
            mainDisplay.mainPane.setTitleAt(1, Localization.getLangDataAt(53));
            mainDisplay.mainPane.setTitleAt(2, "User settings");
            mainDisplay.updateSidePanel(selectedIndexCaseNumberField);

        }

    }
}
