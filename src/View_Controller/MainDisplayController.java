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
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

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
        this.mainDisplay.sortButton.addActionListener(new SortAction());
        this.mainDisplay.langChoiceApply.addActionListener(new ApplyLangSettingAction());
        this.mainDisplay.sourceHyperLink.addMouseListener(new OpenCaseNumberSourceAction());
        this.mainDisplay.githubButton.addActionListener(new JumpToGithubAction());
        for (Guide article : this.mainDisplay.guidebook) {
            if (article.pathIsURL()) {
                article.getHyperLinkWiki().addMouseListener(new OpenWikiAction());
                article.getHyperLinkGoogleMap().addMouseListener(new OpenGoogleMapAction());
            }
        }
        this.mainDisplay.guidePane.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                if (e.getSource() instanceof JTabbedPane) {
                    JTabbedPane pane = (JTabbedPane) e.getSource();
                    mainDisplay.mapLabelGBP.setIcon(mainDisplay.map.DrawLocationMap(mainDisplay.guidebook[pane.getSelectedIndex()].getRegionNum()));
                }
            }
        }
        );
        this.mainDisplay.translateButton.addActionListener(new TranslateAction());
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
                mainDisplay.sortButton.setText(Localization.getLangDataAt(66) + " " + Localization.getLangDataAt(67));
                sort = 1;
            } else if (sort == 1) {
                mainDisplay.sortByTotalCaseNumber();
                mainDisplay.sortButton.setText(Localization.getLangDataAt(66) + " " + Localization.getLangDataAt(68));
                sort = 2;
            } else if (sort == 2) {
                mainDisplay.sortByNewCaseNumber();
                mainDisplay.sortButton.setText(Localization.getLangDataAt(66) + " " + Localization.getLangDataAt(59));
                sort = 3;
            } else {
                mainDisplay.sortByRegionNumber();
                mainDisplay.sortButton.setText(Localization.getLangDataAt(66) + " " + Localization.getLangDataAt(69));
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
                if (backendModels.japanPrefecture[selectedIndexCaseNumberField - 1].getWeather(0).equals("Updating...")) {
                    SidePanelThread updater = new SidePanelThread(backendModels, mainDisplay, mainDisplay.dataPane, selectedIndexCaseNumberField);
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
            mainDisplay.guidebook[mainDisplay.guidePane.getSelectedIndex()].getHyperLinkWiki().setForeground(Color.BLUE);
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
            mainDisplay.guidebook[mainDisplay.guidePane.getSelectedIndex()].getHyperLinkWiki().setForeground(new Color(128, 0, 128));
        }
    }

    private class OpenGoogleMapAction implements MouseListener {

        @Override
        public void mouseExited(MouseEvent me) {
            mainDisplay.guidebook[mainDisplay.guidePane.getSelectedIndex()].getHyperLinkGoogleMap().setForeground(Color.BLUE);
        }

        @Override
        public void mouseReleased(MouseEvent me) {
            try {
                String param = mainDisplay.guidebook[mainDisplay.guidePane.getSelectedIndex()].getArticleTitle().replaceAll(" ", "+");
                Desktop.getDesktop().browse(new URI("https://www.google.com/maps/search/?api=1&query=" + param));
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
            mainDisplay.guidebook[mainDisplay.guidePane.getSelectedIndex()].getHyperLinkGoogleMap().setForeground(new Color(128, 0, 128));
        }
    }

    private class TranslateAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            try {
                //try communicating with the API.
            } catch (Exception ex) {
                System.out.println("Possibly no internet connection.");
            }
        }
    }

}
