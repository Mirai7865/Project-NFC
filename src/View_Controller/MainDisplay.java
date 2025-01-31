/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View_Controller;

import BackendModels.*;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.CLOSED_OPTION;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;

public class MainDisplay extends JFrame {

    BackendModels backendModels;
    DrawMap map;
    Guide guidebook[] = new Guide[10];

    JList caseNumberList;
    JButton langJpButton;
    JButton langEnButton;
    JButton sortButton;
    JTextArea sourceHyperLink;
    JTabbedPane mainPane;

    JPanel clockLabel;
    JTextArea clockTextArea;
    JPanel caseNumberPanel;
    JPanel guidePanel;
    JTabbedPane guidePane;
    JPanel settingsPanel;
    JTextArea dataPane;

    JTextArea weatherText[];
    JPanel weatherPanel;
    JLabel weatherIcons[];
    JScrollPane weatherPane;

    JButton githubButton;
    JTextArea disclaimerText;

    JLabel mapLabelGBP;
    JPanel mapPanelGBP;
    JComboBox langChoices;
    JButton langChoiceApply;

    JPanel translatePanel;
    JTextArea translatingText;
    JTextArea translateInstrct;
    JButton translateButton;

    JLabel mapLabelCNP;
    JPanel mapPanelCNP;

    JScrollPane caseNumberPane;
    DefaultListModel<String> listModel;

    private void initialComponents() {

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setMinimumSize(new Dimension(1500, 600));
        this.setTitle("Project NFC");
        this.setResizable(false);

        this.mainPane = new JTabbedPane(JTabbedPane.TOP);
        this.caseNumberPanel = new JPanel(new GridBagLayout());
        this.guidePanel = new JPanel(new GridBagLayout());
        this.settingsPanel = new JPanel(new GridBagLayout());
        this.translatePanel = new JPanel(new GridBagLayout());

        this.listModel = new DefaultListModel<>();
        this.caseNumberList = new JList(this.listModel);
        this.caseNumberList.setFont(new Font("Arial", Font.BOLD, 14));

        this.clockTextArea = new JTextArea();
        this.clockTextArea.setFont(new Font("Times New Roman", Font.BOLD, 42));
        this.clockTextArea.setEditable(false);
        this.clockTextArea.setFocusable(false);

        this.clockLabel = new JPanel();
        this.clockLabel.add(this.clockTextArea);
        this.clockLabel.setBackground(Color.WHITE);
        this.clockLabel.setBorder(BorderFactory.createTitledBorder(Localization.getLangDataAt(64)));

        this.caseNumberPane = new JScrollPane(this.caseNumberList);
        this.caseNumberPane.setPreferredSize(new Dimension(380, 500));
        this.caseNumberPane.setBorder(BorderFactory.createTitledBorder(Localization.getLangDataAt(51)));

        this.langJpButton = new JButton();
        this.langJpButton.setText("日本語");

        this.langEnButton = new JButton();
        this.langEnButton.setText("English");

        this.sortButton = new JButton();
        this.sortButton.setText(Localization.getLangDataAt(66) + " " + Localization.getLangDataAt(69));

        this.sourceHyperLink = new JTextArea();
        this.sourceHyperLink.setEditable(false);
        this.sourceHyperLink.setOpaque(false);
        this.sourceHyperLink.setText(Localization.getLangDataAt(63) + " https://corona.go.jp/dashboard");
        this.sourceHyperLink.setForeground(Color.BLUE);

        this.guidePane = new JTabbedPane(JTabbedPane.TOP);

        this.guidebook[0] = new Guide("Sensoji", null, 12);
        this.guidePane.addTab(guidebook[0].getArticleTitle(), guidebook[0].getArticleComponent());

        guidebook[1] = new Guide("Tokyo_Skytree", null, 12);
        this.guidePane.addTab(guidebook[1].getArticleTitle(), guidebook[1].getArticleComponent());

        guidebook[2] = new Guide("Tokyo_Imperial_Palace", null, 12);
        this.guidePane.addTab(guidebook[2].getArticleTitle(), guidebook[2].getArticleComponent());

        this.guidebook[3] = new Guide("Tokyo_Disneyland", null, 11);
        this.guidePane.addTab(this.guidebook[3].getArticleTitle(), this.guidebook[3].getArticleComponent());

        this.guidebook[4] = new Guide("Mount_Fuji", null, 21);
        this.guidePane.addTab(this.guidebook[4].getArticleTitle(), this.guidebook[4].getArticleComponent());

        this.guidebook[5] = new Guide("Hiroshima_Peace_Memorial_Park", null, 33);
        this.guidePane.addTab(this.guidebook[5].getArticleTitle(), this.guidebook[5].getArticleComponent());

        this.guidebook[6] = new Guide("Itsukushima_Shrine", null, 33);
        this.guidePane.addTab(this.guidebook[6].getArticleTitle(), this.guidebook[6].getArticleComponent());

        this.guidebook[7] = new Guide("Tōdai-ji", null, 25);
        this.guidePane.addTab(this.guidebook[7].getArticleTitle(), this.guidebook[7].getArticleComponent());

        this.guidebook[8] = new Guide("Historic_Villages_of_Shirakawa-gō_and_Gokayama", null, 20);
        this.guidePane.addTab(this.guidebook[8].getArticleTitle(), this.guidebook[8].getArticleComponent());

        this.guidebook[9] = new Guide("Okinawa_Prefecture", null, 46);
        this.guidePane.addTab(this.guidebook[9].getArticleTitle(), this.guidebook[9].getArticleComponent());

        this.mapPanelCNP = new JPanel(new GridBagLayout());
        this.mapPanelCNP.setBackground(Color.WHITE);
        this.mapPanelCNP.setBorder(BorderFactory.createTitledBorder(Localization.getLangDataAt(50)));

        this.githubButton = new JButton();
        this.githubButton.setText(Localization.getLangDataAt(86));

        this.disclaimerText = new JTextArea();
        this.disclaimerText.setPreferredSize(new Dimension(700, 550));
        this.disclaimerText.setLineWrap(true);
        this.disclaimerText.setWrapStyleWord(true);
        this.disclaimerText.setEditable(false);
        this.disclaimerText.setFont(new Font("MS Gothic", Font.BOLD, 20));
        this.disclaimerText.setText(Localization.getLangDataAt(82) + "\n\n" + Localization.getLangDataAt(83) + "\n\n" + Localization.getLangDataAt(84));
        this.disclaimerText.setBorder(BorderFactory.createTitledBorder(Localization.getLangDataAt(85)));

        this.dataPane = new JTextArea();
        this.dataPane.setPreferredSize(new Dimension(300, 200));
        this.dataPane.setFont(new Font("MS Gothic", Font.BOLD, 20));
        this.dataPane.setEditable(false);
        this.dataPane.setWrapStyleWord(true);
        this.dataPane.setBorder(BorderFactory.createTitledBorder(Localization.getLangDataAt(70)));

        this.weatherText = new JTextArea[4];
        for (int i = 0; i < 4; i++) {
            this.weatherText[i] = new JTextArea();
            this.weatherText[i].setFont(new Font("MS Gothic", Font.BOLD, 20));
            this.weatherText[i].setEditable(false);
            this.weatherText[i].setWrapStyleWord(true);
        }

        this.weatherPanel = new JPanel(new GridBagLayout());
        this.weatherPanel.setBackground(Color.white);

        this.weatherIcons = new JLabel[3];

        this.weatherPane = new JScrollPane(this.weatherPanel);
        this.weatherPane.getVerticalScrollBar().setUnitIncrement(15);
        this.weatherPane.setPreferredSize(new Dimension(300, 400));
        this.weatherPane.setBorder(BorderFactory.createTitledBorder(Localization.getLangDataAt(73)));

        this.updateSidePanel(0);

        this.mapPanelGBP = new JPanel(new GridBagLayout());
        this.mapPanelGBP.setBackground(Color.WHITE);
        this.mapPanelGBP.setBorder(BorderFactory.createTitledBorder("The map of Japan"));
        this.mapLabelGBP = new JLabel(backendModels.map.DrawLocationMap(12));

        this.langChoices = new JComboBox(Localization.getLangFileNames());
        this.langChoices.setEditable(false);
        this.langChoiceApply = new JButton();
        this.langChoiceApply.setText(Localization.getLangDataAt(71));

        this.translatingText = new JTextArea();
        this.translatingText.setFont(new Font("MS Gothic", Font.BOLD, 20));
//        this.translatingText.setEditable(false);
        this.translatingText.setWrapStyleWord(true);
        this.translatingText.setText("Type the translating text here....");
        this.translatingText.setPreferredSize(new Dimension(1100, 600));
        this.translatingText.setBorder(BorderFactory.createTitledBorder("Translator Textbox"));

        this.translateInstrct = new JTextArea();
        this.translateInstrct.setFont(new Font("MS Gothic", Font.BOLD, 20));
        this.translateInstrct.setOpaque(false);
        this.translateInstrct.setEditable(false);
        this.translateInstrct.setWrapStyleWord(true);
        this.translateInstrct.setText("Type in the text into the text box, and then hit the button."
                + "\nThen, the program will open Google translate in your default web browser.");
        this.translateInstrct.setBorder(BorderFactory.createTitledBorder("Instructions"));

        this.translateButton = new JButton();
        this.translateButton.setText(Localization.getLangDataAt(81));

        GridBagConstraints gbc;

        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 0;
        gbc.gridheight = 0;
        gbc.weightx = 1;
        gbc.weighty = 1;
//        gbc.fill = GridBagConstraints.CENTER;
        gbc.anchor = GridBagConstraints.NORTH;
//        mainDisplayPane.add(this.langJpButton, gbc);
        this.caseNumberPanel.add(this.langJpButton, gbc);

        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 0;
        gbc.gridheight = 0;
        gbc.weightx = 1;
        gbc.weighty = 1;
//        gbc.fill = GridBagConstraints.CENTER;
        gbc.anchor = GridBagConstraints.NORTH;
//        mainDisplayPane.add(this.langEnButton, gbc);
        this.caseNumberPanel.add(this.langEnButton, gbc);

        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 0;
        gbc.gridheight = 0;
        gbc.weightx = 1;
        gbc.weighty = 1;
//        gbc.fill = GridBagConstraints.CENTER;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        this.caseNumberPanel.add(this.sortButton, gbc);

        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 0;
        gbc.gridheight = 0;
        gbc.weightx = 1;
        gbc.weighty = 1;
//        gbc.fill = GridBagConstraints.CENTER;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        this.caseNumberPanel.add(this.clockLabel, gbc);

        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 1;
        gbc.weighty = 1;
//        gbc.fill = GridBagConstraints.CENTER;
        gbc.anchor = GridBagConstraints.SOUTH;
//        this.mainPane.addTab("Main Tab", this.caseNumberPane);
        this.caseNumberPanel.add(this.caseNumberPane, gbc);

        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 1;
        gbc.weighty = 1;
//        gbc.fill = GridBagConstraints.CENTER;
        gbc.anchor = GridBagConstraints.NORTH;
        this.caseNumberPanel.add(this.mapPanelCNP, gbc);

        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 3;
        gbc.gridheight = 3;
        gbc.weightx = 1;
        gbc.weighty = 1;
//        gbc.fill = GridBagConstraints.CENTER;
//        gbc.anchor = GridBagConstraints.NORTH;
        this.mapPanelCNP.add(new JLabel(backendModels.map.DrawRiskMap()));

        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 1;
        gbc.weighty = 1;
//        gbc.fill = GridBagConstraints.CENTER;
        gbc.anchor = GridBagConstraints.SOUTHEAST;
        this.mapPanelCNP.add(this.sourceHyperLink, gbc);

        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 1;
        gbc.weighty = 1;
//        gbc.fill = GridBagConstraints.CENTER;
        gbc.anchor = GridBagConstraints.NORTH;
        this.caseNumberPanel.add(this.dataPane, gbc);

        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 0.5;
        gbc.weighty = 0.5;
//        gbc.fill = GridBagConstraints.CENTER;
        gbc.anchor = GridBagConstraints.SOUTH;
        this.caseNumberPanel.add(this.weatherPane, gbc);

        Container mainDisplayPane = this.getContentPane();
        mainDisplayPane.setLayout(new GridBagLayout());

        this.mainPane.addTab(Localization.getLangDataAt(52), null, this.caseNumberPanel, "Shows case numbers");

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 1;
        gbc.weighty = 1;
//        gbc.fill = GridBagConstraints.CENTER;
        gbc.anchor = GridBagConstraints.NORTH;
        this.guidePanel.add(this.mapPanelGBP, gbc);

        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 3;
        gbc.gridheight = 3;
        gbc.weightx = 1;
        gbc.weighty = 1;
//        gbc.fill = GridBagConstraints.CENTER;
//        gbc.anchor = GridBagConstraints.NORTH;
        this.mapPanelGBP.add(this.mapLabelGBP, gbc);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 1;
        gbc.weighty = 1;
//        gbc.fill = GridBagConstraints.CENTER;
//        gbc.anchor = GridBagConstraints.NORTH;
        this.guidePanel.add(this.guidePane, gbc);

        this.mainPane.addTab(Localization.getLangDataAt(53), null, this.guidePanel, "Guidebook section");

        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 1;
        gbc.weighty = 1;
//        gbc.fill = GridBagConstraints.CENTER;
        gbc.anchor = GridBagConstraints.SOUTH;
        this.translatePanel.add(this.translateInstrct, gbc);

        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 1;
        gbc.weighty = 1;
//        gbc.fill = GridBagConstraints.CENTER;
        gbc.anchor = GridBagConstraints.NORTH;
        this.translatePanel.add(this.translatingText, gbc);

        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 1;
        gbc.weighty = 1;
//        gbc.fill = GridBagConstraints.CENTER;
        gbc.anchor = GridBagConstraints.SOUTHWEST;
        this.translatePanel.add(this.translateButton, gbc);

        this.mainPane.addTab(Localization.getLangDataAt(81), null, this.translatePanel, "Translator section");

        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 1;
        gbc.weighty = 1;
//        gbc.fill = GridBagConstraints.CENTER;
//        gbc.anchor = GridBagConstraints.SOUTH;
        this.settingsPanel.add(this.langChoices, gbc);

        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 1;
        gbc.weighty = 1;
//        gbc.fill = GridBagConstraints.CENTER;
        gbc.anchor = GridBagConstraints.WEST;
        this.settingsPanel.add(this.langChoiceApply, gbc);

        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 1;
        gbc.weighty = 1;
//        gbc.fill = GridBagConstraints.CENTER;
//        gbc.anchor = GridBagConstraints.NORTH;
        this.settingsPanel.add(this.githubButton, gbc);

        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.gridwidth = 3;
        gbc.gridheight = 3;
        gbc.weightx = 1;
        gbc.weighty = 1;
//        gbc.fill = GridBagConstraints.CENTER;
        gbc.anchor = GridBagConstraints.CENTER;
        this.settingsPanel.add(this.disclaimerText, gbc);

        this.mainPane.addTab(Localization.getLangDataAt(65), null, this.settingsPanel, "Per user settings");

        mainDisplayPane.add(this.mainPane);
        this.mapPanelCNP.setVisible(true);
        this.setVisible(true);
        this.pack();

        this.backendModels.clock = new Clock(this.clockTextArea);
        this.backendModels.cThread = new Thread(this.backendModels.clock);
        this.backendModels.cThread.start();
    }

    public MainDisplay(BackendModels bem) {
        //Create JFrame and locate all the components. Also update caseNumber.
        this.backendModels = bem;
        this.backendModels.map = new DrawMap(this.backendModels.japanPrefecture, "japan_map.png");
        this.initialComponents();
        this.updateCaseNumberTextPane();
        this.map = this.backendModels.map;

    }

    public void updateCaseNumberTextPane() {
        //update contents inside the caseNumberList
        this.listModel.clear();
        String risk = this.convertRisk(0);

        if (Localization.getLang().equals("ja")) {
            this.listModel.addElement("<html><pre>" + (String.format(Localization.getLangDataAt(58) + ":   " + Localization.getLangDataAt(57) + "\t" + Localization.getLangDataAt(48) + "%7s" + " " + Localization.getLangDataAt(49) + " " + risk, backendModels.japan.getCaseNumber())) + "</pre></html>");
        } else if (Localization.getLang().equals("en")) {
            this.listModel.addElement("<html><pre>" + (String.format(Localization.getLangDataAt(58) + ": " + "%-13.13s" + "\n" + Localization.getLangDataAt(48) + "%7s" + " " + Localization.getLangDataAt(49) + " " + risk, Localization.getLangDataAt(57), backendModels.japan.getCaseNumber())) + "</pre></html>");
        }

        for (int i = 0; i < this.backendModels.japanPrefecture.length; i++) {
            risk = this.convertRisk(i + 1);
            if (Localization.getLang().equals("ja")) {
//                this.listModel.addElement("<html><pre>" + (String.format(Localization.getLangDataAt(47) + " " + Localization.getLangDataAt(Localization.indexOf(this.backendModels.japanPrefecture[i].getRegionName())) + "\t" + Localization.getLangDataAt(48) + "%7s" + " " + Localization.getLangDataAt(49) + " " + risk, backendModels.japanPrefecture[i].getCaseNumber())) + "</pre></html>");
                String text = String.format(Localization.getLangDataAt(47) + " " + Localization.getLangDataAt(Localization.indexOf(this.backendModels.japanPrefecture[i].getRegionName())) + "\t" + Localization.getLangDataAt(48) + "%7s" + " " + Localization.getLangDataAt(49) + " " + risk, backendModels.japanPrefecture[i].getCaseNumber());
                javax.swing.SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        listModel.addElement("<html><pre>" + text + "</pre></html>");
                    }
                });
            } else if (Localization.getLang().equals("en")) {
                String text = String.format(Localization.getLangDataAt(47) + " " + "%-10.10s" + "\n" + Localization.getLangDataAt(48) + "%7s" + " " + Localization.getLangDataAt(49) + " " + risk, Localization.getLangDataAt(Localization.indexOf(this.backendModels.japanPrefecture[i].getRegionName())), backendModels.japanPrefecture[i].getCaseNumber());
                javax.swing.SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        listModel.addElement("<html><pre>" + text + "</pre></html>");
                    }
                });
            }
        }
    }

    public void updateSidePanel(int index) {
        String risk = this.convertRisk(index);
        NumberFormat fmt = NumberFormat.getInstance();
        fmt.setGroupingUsed(true);

        if (index == 0) {
            this.dataPane.setText(Localization.getLangDataAt(58) + ":" + Localization.getLangDataAt(57)
                    + "\n" + Localization.getLangDataAt(60) + ":");
            this.dataPane.append(fmt.format(this.backendModels.japan.getPopulation()));
            this.dataPane.append("\n" + Localization.getLangDataAt(48));
            this.dataPane.append(fmt.format(this.backendModels.japan.getCaseNumber()));
            this.dataPane.append("\n" + Localization.getLangDataAt(59) + ":");
            this.dataPane.append(fmt.format(this.backendModels.japan.getNewCaseNumber()));
            this.dataPane.append("\n" + Localization.getLangDataAt(49) + risk);
            this.weatherPane.setVisible(false);
        } else {
            this.dataPane.setText(Localization.getLangDataAt(47) + "" + Localization.getLangDataAt(this.backendModels.japanPrefecture[index - 1].getRegionNumber() - 1)
                    + "\n" + Localization.getLangDataAt(60) + ":");
            this.dataPane.append(fmt.format(this.backendModels.japanPrefecture[index - 1].getPopulation()));
            this.dataPane.append("\n" + Localization.getLangDataAt(48));
            this.dataPane.append(fmt.format(this.backendModels.japanPrefecture[index - 1].getCaseNumber()));
            this.dataPane.append("\n" + Localization.getLangDataAt(59) + ":" + this.backendModels.japanPrefecture[index - 1].getNewCaseNumber()
                    + "\n" + Localization.getLangDataAt(49) + risk);

            String cityName = "";
            if (Localization.getLang().equals("ja")) {
                cityName = Localization.getLangDataAt(74).replaceFirst("__", this.backendModels.japanPrefecture[index - 1].getMajorCityJp());
            } else {
                cityName = Localization.getLangDataAt(74).replaceFirst("__", this.backendModels.japanPrefecture[index - 1].getMajorCityEng());
            }
            this.weatherText[0].setText(cityName + "\n\n" + Localization.getLangDataAt(76) + "\n");
            GridBagConstraints gbc = new GridBagConstraints();

            this.weatherPanel.removeAll();

            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.gridwidth = 1;
            gbc.gridheight = 1;
            gbc.weightx = 1;
            gbc.weighty = 1;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.anchor = GridBagConstraints.NORTH;
            this.weatherPanel.add(this.weatherText[0], gbc);

            for (int i = 0; i <= 2; i++) {
                String date = Localization.getLangDataAt(77 + i);
                if (i >= 2) {
                    date = "";
                }

                this.weatherText[i + 1].setText(/*Localization.getLangDataAt(77 + day)+ "\n" + Localization.getLangDataAt(61) + " "
                        + this.localizeWeather(this.backendModels.japanPrefecture[index - 1].getWeather(i))
                        +*/ "\n" + Localization.getLangDataAt(62) + " " + this.localizeTemp(this.backendModels.japanPrefecture[index - 1].getTemp(i))
                        + "\n" + Localization.getLangDataAt(75) + " " + this.localizeTemp(this.backendModels.japanPrefecture[index - 1].getFeelsLikeTemperature(i))
                );

                if (i > 0) {
                    this.weatherText[i + 1].append("\n" + Localization.getLangDataAt(79) + ": " + this.localizeTemp(this.backendModels.japanPrefecture[index - 1].getMaxTemperature(i)));
                    this.weatherText[i + 1].append("\n" + Localization.getLangDataAt(80) + ": " + this.localizeTemp(this.backendModels.japanPrefecture[index - 1].getMinTemperature(i)));
                }

                this.weatherText[i + 1].append("\n\n" + date);

                gbc = new GridBagConstraints();
                gbc.gridx = 0;
                gbc.gridy = 2 + 3 * (i + 1);
                gbc.gridwidth = 1;
                gbc.gridheight = 1;
                gbc.weightx = 1;
                gbc.weighty = 1;
                gbc.fill = GridBagConstraints.HORIZONTAL;
                gbc.anchor = GridBagConstraints.SOUTH;
                this.weatherPanel.add(this.weatherText[i + 1], gbc);
            }

            this.addWeatherIconImage(index, 0);
            this.addWeatherIconImage(index, 1);
            this.addWeatherIconImage(index, 2);

            this.weatherText[0].setCaretPosition(0);
            this.weatherPane.setVisible(true);
        }
    }

    private void addWeatherIconImage(int index, int day) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.NORTH;
        this.weatherPanel.add(this.weatherText[0], gbc);
        try {
            if (!(this.backendModels.japanPrefecture[index - 1].getWeatherIconURL(day).equals(""))) {
                String cityName = "";
                if (Localization.getLang().equals("ja")) {
                    cityName = Localization.getLangDataAt(74).replaceFirst("__", this.backendModels.japanPrefecture[index - 1].getMajorCityJp());
                } else {
                    cityName = Localization.getLangDataAt(74).replaceFirst("__", this.backendModels.japanPrefecture[index - 1].getMajorCityEng());
                }

                URL url = new URL(this.backendModels.japanPrefecture[index - 1].getWeatherIconURL(day));
                AccessImage image = new AccessImage(url);
                this.weatherIcons[day] = new JLabel(image.getImageIcon());

//                GridBagConstraints gbc = new GridBagConstraints();
                gbc.gridx = 0;
                gbc.gridy = 1 + 3 * (day + 1);
                gbc.gridwidth = 1;
                gbc.gridheight = 1;
                gbc.weightx = 1;
                gbc.weighty = 1;
//                gbc.fill = GridBagConstraints.HORIZONTAL;
                gbc.anchor = GridBagConstraints.SOUTH;
                this.weatherPanel.add(this.weatherIcons[day], gbc);

            }
        } catch (MalformedURLException ex) {
            Logger.getLogger(MainDisplay.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

//    private String localizeWeather(String weather) {
//        if (weather.equals("Updating...")) {
//            return Localization.getLangDataAt(72);
//        }
//        return weather;
//    }

    private String localizeTemp(String temp) {
        if (temp.equals("Updating...")) {
            return Localization.getLangDataAt(72);
        }
        return temp;
    }

    public void sortByRisk() {
        CompareByRisk compare = new CompareByRisk();
        Arrays.sort(this.backendModels.japanPrefecture, compare);
        this.updateCaseNumberTextPane();
    }

    public void sortByRegionNumber() {
        CompareByRegionNum compare = new CompareByRegionNum();
        Arrays.sort(this.backendModels.japanPrefecture, compare);
        this.updateCaseNumberTextPane();
    }

    public void sortByTotalCaseNumber() {
        CompareByTotalCase compare = new CompareByTotalCase();
        Arrays.sort(this.backendModels.japanPrefecture, compare);
        this.updateCaseNumberTextPane();
    }

    public void sortByNewCaseNumber() {
        CompareByNewCase compare = new CompareByNewCase();
        Arrays.sort(this.backendModels.japanPrefecture, compare);
        this.updateCaseNumberTextPane();
    }

    private String convertRisk(int index) {
        String risk = "";
        if (index == 0) {
            if (this.backendModels.japan.getRisk().equals("High")) {
                risk = Localization.getLangDataAt(54);
            } else if (this.backendModels.japan.getRisk().equals("Moderate")) {
                risk = Localization.getLangDataAt(55);
            } else {
                risk = Localization.getLangDataAt(56);
            }
        } else if (index <= this.backendModels.japanPrefecture.length) {
            if (this.backendModels.japanPrefecture[index - 1].getRisk().equals("High")) {
                risk = Localization.getLangDataAt(54);
            } else if (this.backendModels.japanPrefecture[index - 1].getRisk().equals("Moderate")) {
                risk = Localization.getLangDataAt(55);
            } else {
                risk = Localization.getLangDataAt(56);
            }
        } else {
            risk = "Error";
            JOptionPane.showMessageDialog(null, "Error in MainDispaly.convertRisk", "Error", CLOSED_OPTION);
            System.exit(0);
        }
        return risk;
    }

    public void updateAllComponents(int index, int sortType) {
        this.updateSidePanel(index);
        if (index > 0) {
            SidePanelThread updater = new SidePanelThread(backendModels, this, this.dataPane, index + 1);
            Thread updaterThread = new Thread(updater);
            updaterThread.start();
        }

        this.updateCaseNumberTextPane();
        this.caseNumberPane.setBorder(BorderFactory.createTitledBorder(Localization.getLangDataAt(51)));
        this.dataPane.setBorder(BorderFactory.createTitledBorder(Localization.getLangDataAt(70)));
        this.weatherPane.setBorder(BorderFactory.createTitledBorder(Localization.getLangDataAt(73)));
        this.clockLabel.setBorder(BorderFactory.createTitledBorder(Localization.getLangDataAt(64)));
        this.mapPanelCNP.setBorder(BorderFactory.createTitledBorder(Localization.getLangDataAt(50)));
        this.sourceHyperLink.setText(Localization.getLangDataAt(63) + " https://corona.go.jp/dashboard");
        this.mainPane.setTitleAt(0, Localization.getLangDataAt(52));
        this.mainPane.setTitleAt(1, Localization.getLangDataAt(53));
        this.mainPane.setTitleAt(2, Localization.getLangDataAt(81));
        this.mainPane.setTitleAt(3, Localization.getLangDataAt(65));
        this.langChoiceApply.setText(Localization.getLangDataAt(71));
        this.disclaimerText.setText(Localization.getLangDataAt(82) + "\n\n" + Localization.getLangDataAt(83) + "\n\n" + Localization.getLangDataAt(84));
        this.disclaimerText.setBorder(BorderFactory.createTitledBorder(Localization.getLangDataAt(85)));
        this.githubButton.setText(Localization.getLangDataAt(86));

        if (sortType == 0) {
            this.sortButton.setText(Localization.getLangDataAt(66) + " " + Localization.getLangDataAt(69));
        } else if (sortType == 1) {
            this.sortButton.setText(Localization.getLangDataAt(66) + " " + Localization.getLangDataAt(67));
        } else if (sortType == 2) {
            this.sortButton.setText(Localization.getLangDataAt(66) + " " + Localization.getLangDataAt(59));
        } else {
            this.sortButton.setText(Localization.getLangDataAt(66) + " " + Localization.getLangDataAt(68));
        }
    }
}
