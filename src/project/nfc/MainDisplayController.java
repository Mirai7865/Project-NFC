package project.nfc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
public class MainDisplayController {

    BackendModels backendModels;
    MainDisplay mainDisplay;

    public MainDisplayController(BackendModels models, MainDisplay mainDisplay) {
        this.backendModels = models;
        this.mainDisplay = mainDisplay;
        this.initialSetup();
    }

    private void initialSetup() {
        this.mainDisplay.langJpButton.addActionListener(new ChangeLanguageToJaAction());
        this.mainDisplay.langEnButton.addActionListener(new ChangeLanguageToEnAction());
    }

    private class ChangeLanguageToJaAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            Localization.setLang("ja-jp");
            mainDisplay.updateCaseNumberTextPane();
            mainDisplay.caseNumberPane.setBorder(BorderFactory.createTitledBorder(Localization.getLangDataAtIndex(51)));
            mainDisplay.mapPanel.setBorder(BorderFactory.createTitledBorder(Localization.getLangDataAtIndex(50)));

        }
    }

    private class ChangeLanguageToEnAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            Localization.setLang("en-us");
            mainDisplay.updateCaseNumberTextPane();
            mainDisplay.caseNumberPane.setBorder(BorderFactory.createTitledBorder(Localization.getLangDataAtIndex(51)));
            mainDisplay.mapPanel.setBorder(BorderFactory.createTitledBorder(Localization.getLangDataAtIndex(50)));
        }
    }
}
