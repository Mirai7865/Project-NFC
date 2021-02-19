package project.nfc;

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

    int selectedIndex = 0;

    public MainDisplayController(BackendModels models, MainDisplay mainDisplay) {
        this.backendModels = models;
        this.mainDisplay = mainDisplay;
        this.initialSetup();
    }

    private void initialSetup() {
        this.mainDisplay.langJpButton.addActionListener(new ChangeLanguageToJaAction());
        this.mainDisplay.langEnButton.addActionListener(new ChangeLanguageToEnAction());
        this.mainDisplay.caseNumberList.addMouseListener(new openSidePanelAction());
    }

    private class ChangeLanguageToJaAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            Localization.setLang("ja-jp");
            mainDisplay.updateCaseNumberTextPane();
            mainDisplay.caseNumberPane.setBorder(BorderFactory.createTitledBorder(Localization.getLangDataAtIndex(51)));
            mainDisplay.mapPanel.setBorder(BorderFactory.createTitledBorder(Localization.getLangDataAtIndex(50)));
            mainDisplay.updateSidePanel(selectedIndex);
        }
    }

    private class ChangeLanguageToEnAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            Localization.setLang("en-us");
            mainDisplay.updateCaseNumberTextPane();
            mainDisplay.caseNumberPane.setBorder(BorderFactory.createTitledBorder(Localization.getLangDataAtIndex(51)));
            mainDisplay.mapPanel.setBorder(BorderFactory.createTitledBorder(Localization.getLangDataAtIndex(50)));
            mainDisplay.updateSidePanel(selectedIndex);
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
        }

        @Override
        public void mouseClicked(MouseEvent e) {
//            int index = mainDisplay.caseNumberList.getSelectedIndex();
//            System.out.println(index);
//            System.out.println("This is mouseClicked responding");
        }

        @Override
        public void mousePressed(MouseEvent e) {
//            int index = mainDisplay.caseNumberList.getSelectedIndex();
//            System.out.println(index);
//            System.out.println("This is mousePressed responding");
        }

        @Override
        public void mouseEntered(MouseEvent e) {
//            int index = mainDisplay.caseNumberList.getSelectedIndex();
//            System.out.println(index);
//            System.out.println("This is mouseEntered responding");
        }
    }
}
