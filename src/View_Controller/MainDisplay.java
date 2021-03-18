/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View_Controller;

import BackendModels.DrawMap;
import BackendModels.*;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.text.NumberFormat;
import java.util.Arrays;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class MainDisplay extends JFrame {

    BackendModels backendModels;
    DrawMap map;

    JList caseNumberList;
    JButton langJpButton;
    JButton langEnButton;
    JButton sortByRiskButton;
    JTextArea hyperLink;
    JTabbedPane mainPane;

    JTextArea clockTextArea;
    JPanel caseNumberPanel;
    JPanel guidePanel;
    JPanel settingsPanel;
    JTextArea sidePane;

    JTextArea guidebookText;
    JScrollPane guideSectionPane;
    JPanel guideSectionImagePane1;
    JPanel guideSectionImagePane2;

    JComboBox langChoices;
    JButton langChoiceApply;

    JLabel mapLabel;
    JPanel mapPanel;
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

        this.listModel = new DefaultListModel<>();
        this.caseNumberList = new JList(this.listModel);
        this.caseNumberList.setFont(new Font("monospaced", Font.BOLD, 14));

        this.clockTextArea = new JTextArea();
        this.clockTextArea.setFont(new Font("Times New Roman", Font.BOLD, 40));
//        this.clockTextArea.setBackground(new Color(0, 0, 0, 0));
        this.clockTextArea.setEditable(false);
        this.clockTextArea.setFocusable(false);
//        this.clockTextArea.setBorder(BorderFactory.createTitledBorder("Current Time in JST"));

        this.caseNumberPane = new JScrollPane(this.caseNumberList);
        this.caseNumberPane.setPreferredSize(new Dimension(380, 500));
        this.caseNumberPane.setBorder(BorderFactory.createTitledBorder(Localization.getLangDataAt(51)));

        this.langJpButton = new JButton();
        this.langJpButton.setText("日本語");

        this.langEnButton = new JButton();
        this.langEnButton.setText("English");

        this.sortByRiskButton = new JButton();
        this.sortByRiskButton.setText("Sort By Risk");

        this.hyperLink = new JTextArea();
        this.hyperLink.setEditable(false);
//        this.hyperLink.setBackground(new Color(0, 0, 0, 0));
        this.hyperLink.setText("Source: https://corona.go.jp/dashboard");
        this.hyperLink.setForeground(Color.BLUE);

        this.mapPanel = new JPanel(new GridBagLayout());
        this.mapPanel.setBackground(Color.WHITE);
        this.mapPanel.setBorder(BorderFactory.createTitledBorder(Localization.getLangDataAt(50)));

        this.guidebookText = new JTextArea();
        this.guidebookText.setEditable(false);

        this.sidePane = new JTextArea();
        this.sidePane.setPreferredSize(new Dimension(250, 200));
//        this.sidePane.setBackground(new Color(0, 0, 0, 0));
        this.sidePane.setFont(new Font("MS Gothic", Font.BOLD, 20));
        this.sidePane.setEditable(false);
        this.sidePane.setBorder(BorderFactory.createTitledBorder("Region Data"));
        this.updateSidePanel(0);

        Guide sensouji = new Guide("Sensoji", null);
        this.guidebookText.setText(sensouji.getArticle());
        this.guidebookText.setFont(new Font(Font.SERIF, Font.PLAIN, 18));
        this.guidebookText.setSize(new Dimension(700, 700));
        this.guidebookText.setLineWrap(true);
        this.guidebookText.setWrapStyleWord(true);

        this.guideSectionPane = new JScrollPane(this.guidebookText);
        this.guideSectionPane.setBorder(BorderFactory.createTitledBorder("Senso-ji"));
        this.guideSectionPane.setPreferredSize(new Dimension(700, 600));

        this.guideSectionImagePane1 = new JPanel();
        this.guideSectionImagePane1.add(new JLabel(this.fetchImage("Kaminarimon.jpg")));
        this.guideSectionImagePane1.setBorder(BorderFactory.createTitledBorder("The face of Senso-ji, \"Kaminarimon\""));

        this.guideSectionImagePane2 = new JPanel();
        this.guideSectionImagePane2.add(new JLabel(this.fetchImage("Kaminarimon from distance.jpg")));
        this.guideSectionImagePane2.setBorder(BorderFactory.createTitledBorder("Take another look at Kaminarimon!"));

        this.langChoices = new JComboBox(Localization.getLangFileNames());
        this.langChoices.setEditable(false);
        this.langChoiceApply = new JButton();
        this.langChoiceApply.setText("Apply language setting");

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
        this.caseNumberPanel.add(this.sortByRiskButton, gbc);

        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 0;
        gbc.gridheight = 0;
        gbc.weightx = 1;
        gbc.weighty = 1;
//        gbc.fill = GridBagConstraints.CENTER;
        gbc.anchor = GridBagConstraints.NORTHWEST;
//        mainDisplayPane.add(this.langJpButton, gbc);
        this.caseNumberPanel.add(this.clockTextArea, gbc);

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
        this.caseNumberPanel.add(this.mapPanel, gbc);

        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 3;
        gbc.gridheight = 3;
        gbc.weightx = 1;
        gbc.weighty = 1;
//        gbc.fill = GridBagConstraints.CENTER;
//        gbc.anchor = GridBagConstraints.NORTH;
        this.mapPanel.add(new JLabel(backendModels.map.initialDraw(this.backendModels.japanPrefecture)));

        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 1;
        gbc.weighty = 1;
//        gbc.fill = GridBagConstraints.CENTER;
        gbc.anchor = GridBagConstraints.SOUTHEAST;
        this.mapPanel.add(this.hyperLink, gbc);

        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.CENTER;
        gbc.anchor = GridBagConstraints.NORTH;
        this.caseNumberPanel.add(this.sidePane, gbc);

        Container mainDisplayPane = this.getContentPane();
        mainDisplayPane.setLayout(new GridBagLayout());

        this.mainPane.addTab(Localization.getLangDataAt(52), null, this.caseNumberPanel, "Shows case numbers");

        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 1;
        gbc.weighty = 1;
//        gbc.fill = GridBagConstraints.CENTER;
        gbc.anchor = GridBagConstraints.NORTH;
        this.guidePanel.add(this.guideSectionPane, gbc);

        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 1;
        gbc.weighty = 1;
//        gbc.fill = GridBagConstraints.CENTER;
        gbc.anchor = GridBagConstraints.NORTH;
        this.guidePanel.add(this.guideSectionImagePane1, gbc);

        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 1;
        gbc.weighty = 1;
//        gbc.fill = GridBagConstraints.CENTER;
        gbc.anchor = GridBagConstraints.SOUTH;
        this.guidePanel.add(this.guideSectionImagePane2, gbc);

        this.mainPane.addTab(Localization.getLangDataAt(53), null, this.guidePanel, "Guidebook section");

        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 1;
        gbc.weighty = 1;
//        gbc.fill = GridBagConstraints.CENTER;
//        gbc.anchor = GridBagConstraints.SOUTHEAST;
        this.settingsPanel.add(this.langChoices, gbc);

        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 1;
        gbc.weighty = 1;
//        gbc.fill = GridBagConstraints.CENTER;
        gbc.anchor = GridBagConstraints.NORTH;
        this.settingsPanel.add(this.langChoiceApply, gbc);

        this.mainPane.addTab("User settings", null, this.settingsPanel, "Per ser settings");

        mainDisplayPane.add(this.mainPane);
        this.mapPanel.setVisible(true);
        this.setVisible(true);
        this.pack();

        this.backendModels.clock = new Clock(this.clockTextArea);
        this.backendModels.cThread = new Thread(this.backendModels.clock);
        this.backendModels.cThread.start();
    }

    public MainDisplay(BackendModels bem) {
        //Create JFrame and locate all the components. Also update caseNumber.
        this.backendModels = bem;
        this.backendModels.map = new DrawMap();
        this.initialComponents();
        this.updateCaseNumberTextPane();
    }

    public void updateCaseNumberTextPane() {
        //update contents inside the caseNumberList
        this.listModel.clear();
        String risk = this.convertRisk(0);

        if (Localization.getLang().equals("ja")) {
            this.listModel.addElement("<html><pre>" + (String.format(Localization.getLangDataAt(58) + "   " + Localization.getLangDataAt(57) + "\t" + Localization.getLangDataAt(48) + "%7s" + " " + Localization.getLangDataAt(49) + " " + risk, backendModels.japan.getCaseNumber())) + "</pre></html>");
        } else if (Localization.getLang().equals("en")) {
            this.listModel.addElement("<html><pre>" + (String.format(Localization.getLangDataAt(58) + " " + "%-13.13s" + Localization.getLangDataAt(48) + "%7s" + "\n" + Localization.getLangDataAt(49) + " " + risk, Localization.getLangDataAt(57), backendModels.japan.getCaseNumber())) + "</pre></html>");
        }

        for (int i = 0; i < this.backendModels.japanPrefecture.length; i++) {
            risk = this.convertRisk(i + 1);
            if (Localization.getLang().equals("ja")) {
                this.listModel.addElement("<html><pre>" + (String.format(Localization.getLangDataAt(47) + " " + Localization.getLangDataAt(Localization.indexOf(this.backendModels.japanPrefecture[i].getRegionName())) + "\t" + Localization.getLangDataAt(48) + "%7s" + " " + Localization.getLangDataAt(49) + " " + risk, backendModels.japanPrefecture[i].getCaseNumber())) + "</pre></html>");
            } else if (Localization.getLang().equals("en")) {
                this.listModel.addElement("<html><pre>" + (String.format(Localization.getLangDataAt(47) + " " + "%-10.10s" + Localization.getLangDataAt(48) + "%7s" + "\n" + Localization.getLangDataAt(49) + " " + risk, Localization.getLangDataAt(Localization.indexOf(this.backendModels.japanPrefecture[i].getRegionName())), backendModels.japanPrefecture[i].getCaseNumber())) + "</pre></html>");
            }
        }
    }

    private ImageIcon fetchImage(String name) {
        Image image = new Image(name);
        ImageIcon imageIcon = new ImageIcon(image.getImage());
        return imageIcon;
    }

    public void updateSidePanel(int index) {
        String risk = this.convertRisk(index);
        NumberFormat fmt = NumberFormat.getInstance();
        fmt.setGroupingUsed(true);

        if (index == 0) {
            this.sidePane.setText(Localization.getLangDataAt(58) + Localization.getLangDataAt(57)
                    + "\n" + Localization.getLangDataAt(60));
            this.sidePane.append(fmt.format(this.backendModels.japan.getPopulation()));
            this.sidePane.append("\n" + Localization.getLangDataAt(48));
            this.sidePane.append(fmt.format(this.backendModels.japan.getCaseNumber()));
            this.sidePane.append("\n" + Localization.getLangDataAt(59));
            this.sidePane.append(fmt.format(this.backendModels.japan.getCaseNumberDeltaWithDayPrior()));
            this.sidePane.append("\n" + Localization.getLangDataAt(49) + risk);

        } else {
            this.sidePane.setText(Localization.getLangDataAt(47) + "" + Localization.getLangDataAt(Localization.indexOf(this.backendModels.japanPrefecture[index - 1].getRegionName()))
                    + "\n" + Localization.getLangDataAt(60));
            this.sidePane.append(fmt.format(this.backendModels.japanPrefecture[index - 1].getPopulation()));
            this.sidePane.append("\n" + Localization.getLangDataAt(48));
            this.sidePane.append(fmt.format(this.backendModels.japanPrefecture[index - 1].getCaseNumber()));
            this.sidePane.append("\n" + Localization.getLangDataAt(59) + this.backendModels.japanPrefecture[index - 1].getCaseNumberDeltaWithDayPrior()
                    + "\n" + Localization.getLangDataAt(49) + risk
                    + "\n" + "Weather: " + this.backendModels.japanPrefecture[index - 1].getWeather()
                    + "\n" + "Temperature: " + this.backendModels.japanPrefecture[index - 1].getTemp()
            );
        }
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

    public void sortByCaseNumber() {
        CompareByCase compare = new CompareByCase();
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
            System.out.println("The index " + index + " is out of bounds.");
        }
        return risk;
    }
}
