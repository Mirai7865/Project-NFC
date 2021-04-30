package View_Controller;

import BackendModels.*;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        this.mainDisplay.caseNumberList.addMouseListener(new OpenSidePanelAction());
        this.mainDisplay.sortByRiskButton.addActionListener(new SortAction());
        this.mainDisplay.langChoiceApply.addActionListener(new ApplyLangSettingAction());
        this.mainDisplay.sourceHyperLink.addMouseListener(new OpenCaseNumberSourceAction());
        this.mainDisplay.githubButton.addActionListener(new JumpToGithubAction());
        for (Guide article : this.mainDisplay.guidebook) {
            if (article.pathIsURL()) {
                article.getHyperLink().addMouseListener(new OpenWikiAction());
            }
        }
    }

    private class ChangeLanguageToJaAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            Localization.setLang("ja");
            mainDisplay.updateAllComponents(selectedIndexCaseNumberField, sort);
        }
    }

    private class ChangeLanguageToEnAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            Localization.setLang("en");
            mainDisplay.updateAllComponents(selectedIndexCaseNumberField, sort);
        }
    }

    private class SortAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            if (sort == 0) {
                mainDisplay.sortByRisk();
                mainDisplay.sortByRiskButton.setText(Localization.getLangDataAt(66) + " " + Localization.getLangDataAt(68));
                sort = 1;
            } else if (sort == 1) {
                mainDisplay.sortByCaseNumber();
                mainDisplay.sortByRiskButton.setText(Localization.getLangDataAt(66) + " " + Localization.getLangDataAt(69));
                sort = 2;
            } else {
                mainDisplay.sortByRegionNumber();
                mainDisplay.sortByRiskButton.setText(Localization.getLangDataAt(66) + " " + Localization.getLangDataAt(67));
                sort = 0;
            }
        }
    }

    private class OpenSidePanelAction implements MouseListener {

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
            mainDisplay.updateAllComponents(selectedIndexCaseNumberField, sort);

        }
    }

    private class OpenCaseNumberSourceAction implements MouseListener {

        @Override
        public void mouseExited(MouseEvent me) {
            mainDisplay.sourceHyperLink.setForeground(Color.BLUE);
        }

        @Override
        public void mouseReleased(MouseEvent me) {
            try {
                Desktop.getDesktop().browse(new URI("https://corona.go.jp/dashboard/"));
            } catch (IOException ex) {
                System.out.println("Possibly no internet connection.");
            } catch (URISyntaxException ex) {
                Logger.getLogger(MainDisplayController.class.getName()).log(Level.SEVERE, null, ex);
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
            mainDisplay.sourceHyperLink.setForeground(new Color(128, 0, 128));
        }
    }

    private class JumpToGithubAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                Desktop.getDesktop().browse(new URI("https://github.com/Mirai7865/Project-NFC"));
            } catch (IOException ex) {
                System.out.println("Possibly no internet connection.");
            } catch (URISyntaxException ex) {
                Logger.getLogger(MainDisplayController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private class OpenWikiAction implements MouseListener {

        @Override
        public void mouseExited(MouseEvent me) {
            mainDisplay.guidebook[mainDisplay.guidePane.getSelectedIndex()].getHyperLink().setForeground(Color.BLUE);
        }

        @Override
        public void mouseReleased(MouseEvent me) {
            try {
                Desktop.getDesktop().browse(new URI(mainDisplay.guidebook[mainDisplay.guidePane.getSelectedIndex()].getArticlePath()));
            } catch (IOException ex) {
                System.out.println("Possibly no internet connection.");
            } catch (URISyntaxException ex) {
                Logger.getLogger(MainDisplayController.class.getName()).log(Level.SEVERE, null, ex);
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
            mainDisplay.guidebook[mainDisplay.guidePane.getSelectedIndex()].getHyperLink().setForeground(new Color(128, 0, 128));
        }
    }
}
