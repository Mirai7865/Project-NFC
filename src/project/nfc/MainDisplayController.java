package project.nfc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
//        this.mainDisplay.updateCaseNumberTextField();
        ChangeLanguageToJaAction a = new ChangeLanguageToJaAction();
//        int i = 0;
//        while (i < 5000000) {
//            i++;
//        }
//        a.actionPerformed(new ActionEvent(this.mainDisplay.langJpButton, 0, "a"));
//        this.mainDisplay.listModel.addElement("aaaa");
//        this.mainDisplay.listModel.remove(this.mainDisplay.listModel.getSize() - 1);
//        System.out.println(this.mainDisplay.caseNumberTextField.getModel().toString());
    }

    private class ChangeLanguageToJaAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            Localization.setLang("ja-jp");
            mainDisplay.updateCaseNumberTextField();
        }
    }

    private class ChangeLanguageToEnAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            Localization.setLang("en-us");
            mainDisplay.updateCaseNumberTextField();
        }
    }
}
