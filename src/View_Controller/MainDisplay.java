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
import java.text.NumberFormat;
import java.util.Arrays;
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
    Guide guidebook[] = new Guide[4];

    JList caseNumberList;
    JButton langJpButton;
    JButton langEnButton;
    JButton sortByRiskButton;
    JTextArea sourceHyperLink;
    JTabbedPane mainPane;

    JPanel clockLabel;
    JTextArea clockTextArea;
    JPanel caseNumberPanel;
    JPanel guidePanel;
    JTabbedPane guidePane;
    JPanel settingsPanel;
    JTextArea sidePane;

    JButton githubButton;

    JLabel mapLabelGBP;
    JPanel mapPanelGBP;
    JComboBox langChoices;
    JButton langChoiceApply;

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

        this.sortByRiskButton = new JButton();
        this.sortByRiskButton.setText(Localization.getLangDataAt(66) + " " + Localization.getLangDataAt(67));

        this.sourceHyperLink = new JTextArea();
        this.sourceHyperLink.setEditable(false);
        this.sourceHyperLink.setOpaque(false);
        this.sourceHyperLink.setText(Localization.getLangDataAt(63) + " https://corona.go.jp/dashboard");
        this.sourceHyperLink.setForeground(Color.BLUE);

        this.guidePane = new JTabbedPane(JTabbedPane.TOP);

        guidebook[0] = new Guide("Sensoji", null, 12);
        this.guidePane.addTab(guidebook[0].getArticleTitle(), guidebook[0].getArticleComponent());

        guidebook[1] = new Guide("Tokyo_Skytree", null, 12);
        this.guidePane.addTab(guidebook[1].getArticleTitle(), guidebook[1].getArticleComponent());

        guidebook[2] = new Guide("Tokyo_Imperial_Palace", null, 12);
        this.guidePane.addTab(guidebook[2].getArticleTitle(), guidebook[2].getArticleComponent());

        this.guidebook[3] = new Guide("Tokyo_Disneyland", null, 11);
        this.guidePane.addTab(this.guidebook[3].getArticleTitle(), this.guidebook[3].getArticleComponent());

        this.mapPanelCNP = new JPanel(new GridBagLayout());
        this.mapPanelCNP.setBackground(Color.WHITE);
        this.mapPanelCNP.setBorder(BorderFactory.createTitledBorder(Localization.getLangDataAt(50)));

        this.githubButton = new JButton();
        this.githubButton.setText("Jump to Github");

        this.sidePane = new JTextArea();
        this.sidePane.setPreferredSize(new Dimension(300, 620));
        this.sidePane.setFont(new Font("MS Gothic", Font.BOLD, 20));
        this.sidePane.setEditable(false);
        this.sidePane.setWrapStyleWord(true);
        this.sidePane.setBorder(BorderFactory.createTitledBorder(Localization.getLangDataAt(70)));
        this.updateSidePanel(0);

        this.mapPanelGBP = new JPanel(new GridBagLayout());
        this.mapPanelGBP.setBackground(Color.WHITE);
        this.mapPanelGBP.setBorder(BorderFactory.createTitledBorder("The map of Japan"));
        this.mapLabelGBP = new JLabel(backendModels.map.DrawLocationMap(12));

        this.langChoices = new JComboBox(Localization.getLangFileNames());
        this.langChoices.setEditable(false);
        this.langChoiceApply = new JButton();
        this.langChoiceApply.setText(Localization.getLangDataAt(71));

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
        gbc.fill = GridBagConstraints.CENTER;
        gbc.anchor = GridBagConstraints.NORTH;
        this.caseNumberPanel.add(this.sidePane, gbc);

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

        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 1;
        gbc.weighty = 1;
//        gbc.fill = GridBagConstraints.CENTER;
        gbc.anchor = GridBagConstraints.SOUTH;
        this.settingsPanel.add(this.githubButton, gbc);

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
                    + "\n\n" + Localization.getLangDataAt(61) + " " + this.localizeWeather(this.backendModels.japanPrefecture[index - 1].getWeather())
                    + "\n" + Localization.getLangDataAt(62) + " " + this.localizeTemp(this.backendModels.japanPrefecture[index - 1].getTemp())
            );

        }
    }

    private String localizeWeather(String weather) {
        if (weather.equals("Updating...")) {
            return Localization.getLangDataAt(72);
        }
        return weather;
    }

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
            JOptionPane.showMessageDialog(null, "Error in MainDispaly.convertRisk", "Error", CLOSED_OPTION);
            System.exit(0);
        }
        return risk;
    }

    public void updateAllComponents(int index, int sortType) {
        this.updateCaseNumberTextPane();
        this.caseNumberPane.setBorder(BorderFactory.createTitledBorder(Localization.getLangDataAt(51)));
        this.sidePane.setBorder(BorderFactory.createTitledBorder(Localization.getLangDataAt(70)));
        this.clockLabel.setBorder(BorderFactory.createTitledBorder(Localization.getLangDataAt(64)));
        this.mapPanelCNP.setBorder(BorderFactory.createTitledBorder(Localization.getLangDataAt(50)));
        this.sourceHyperLink.setText(Localization.getLangDataAt(63) + " https://corona.go.jp/dashboard");
        this.mainPane.setTitleAt(0, Localization.getLangDataAt(52));
        this.mainPane.setTitleAt(1, Localization.getLangDataAt(53));
        this.mainPane.setTitleAt(2, Localization.getLangDataAt(65));
        this.langChoiceApply.setText(Localization.getLangDataAt(71));
        this.updateSidePanel(index);
        if (sortType == 0) {
            this.sortByRiskButton.setText(Localization.getLangDataAt(66) + " " + Localization.getLangDataAt(67));
        } else if (sortType == 1) {
            this.sortByRiskButton.setText(Localization.getLangDataAt(66) + " " + Localization.getLangDataAt(68));
        } else {
            this.sortByRiskButton.setText(Localization.getLangDataAt(66) + " " + Localization.getLangDataAt(69));
        }
    }
}
