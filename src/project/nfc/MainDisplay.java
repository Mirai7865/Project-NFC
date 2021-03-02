/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.nfc;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.Arrays;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

public class MainDisplay extends JFrame {

    BackendModels backendModels;
    DrawMap map;

    JList caseNumberList;
    JButton langJpButton;
    JButton langEnButton;
    JButton sortByRiskButton;
    JTabbedPane mainPane;

    JTextArea clock;
    JPanel caseNumberPanel;
    JPanel guidePanel;
    JTextArea sidePanel;

    JTextArea guidebookText;
    JScrollPane guideSectionPane;
    JPanel guideSectionImagePane1;
    JPanel guideSectionImagePane2;
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

        this.listModel = new DefaultListModel<>();
        this.caseNumberList = new JList(this.listModel);
        this.caseNumberList.setFont(new Font("monospaced", Font.BOLD, 14));

        this.clock = new JTextArea();
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Clock();
            }

        });

        this.caseNumberPane = new JScrollPane(this.caseNumberList);
        this.caseNumberPane.setPreferredSize(new Dimension(380, 500));
        this.caseNumberPane.setBorder(BorderFactory.createTitledBorder(Localization.getLangDataAt(51)));

        this.langJpButton = new JButton();
        this.langJpButton.setText("日本語");

        this.langEnButton = new JButton();
        this.langEnButton.setText("English");

        this.sortByRiskButton = new JButton();
        this.sortByRiskButton.setText("Sort By Risk");

        this.mapPanel = new JPanel();
        this.mapPanel.add(new JLabel(map.initialDraw(this.backendModels.japanPrefecture)));
        this.mapPanel.setBorder(BorderFactory.createTitledBorder(Localization.getLangDataAt(50)));

        this.guidebookText = new JTextArea();
        this.guidebookText.setEditable(false);

        this.sidePanel = new JTextArea();
        this.sidePanel.setPreferredSize(new Dimension(250, 200));
//        this.sidePanel.setBackground(Color.BLUE);
        this.sidePanel.setFont(new Font("MS Gothic", Font.BOLD, 20));
        this.updateSidePanel(0);
        this.sidePanel.setEditable(false);

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
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.CENTER;
        gbc.anchor = GridBagConstraints.NORTH;
        this.caseNumberPanel.add(this.sidePanel, gbc);

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

        mainDisplayPane.add(this.mainPane);
        this.mapPanel.setVisible(true);
        this.setVisible(true);
        this.pack();
    }

    public MainDisplay(BackendModels bem) {
        //Create JFrame and locate all the components. Also update caseNumber.
        this.backendModels = bem;
        this.map = new DrawMap();
        this.initialComponents();
        this.updateCaseNumberTextPane();

    }

    public void updateCaseNumberTextPane() {
        //update contents inside the caseNumberList
        this.listModel.clear();
        String risk = null;
        for (int i = 0; i < this.backendModels.japanPrefecture.length; i++) {
            if (this.backendModels.japanPrefecture[i].getRisk().equals("High")) {
                risk = Localization.getLangDataAt(54);
            } else if (this.backendModels.japanPrefecture[i].getRisk().equals("Moderate")) {
                risk = Localization.getLangDataAt(55);
            } else if (this.backendModels.japanPrefecture[i].getRisk().equals("Low")) {
                risk = Localization.getLangDataAt(56);
            }

            if (Localization.getLang().equals("ja-jp")) {
                this.listModel.addElement("<html><pre>" + (String.format(Localization.getLangDataAt(47) + " " + Localization.getLangDataContaining(this.backendModels.japanPrefecture[i].getRegionName()) + "\t" + Localization.getLangDataAt(48) + "%7s" + " " + Localization.getLangDataAt(49) + " " + risk, backendModels.japanPrefecture[i].getCaseNumber())) + "</pre></html>");
            } else if (Localization.getLang().equals("en-us")) {
                this.listModel.addElement("<html><pre>" + (String.format(Localization.getLangDataAt(47) + " " + "%-10.10s" + Localization.getLangDataAt(48) + "%7s" + "\n" + Localization.getLangDataAt(49) + " " + risk, Localization.getLangDataContaining(this.backendModels.japanPrefecture[i].getRegionName()), backendModels.japanPrefecture[i].getCaseNumber())) + "</pre></html>");
            }
        }
        if (this.backendModels.japan.getRisk().equals("High")) {
            risk = Localization.getLangDataAt(54);
        } else if (this.backendModels.japan.getRisk().equals("Moderate")) {
            risk = Localization.getLangDataAt(55);
        } else if (backendModels.japan.getRisk().equals("Low")) {
            risk = Localization.getLangDataAt(56);
        }

        if (Localization.getLang().equals("ja-jp")) {
            this.listModel.add(0, "<html><pre>" + (String.format(Localization.getLangDataAt(58) + "   " + Localization.getLangDataAt(57) + "\t" + Localization.getLangDataAt(48) + "%7s" + " " + Localization.getLangDataAt(49) + " " + risk, backendModels.japan.getCaseNumber())) + "</pre></html>");
        } else if (Localization.getLang().equals("en-us")) {
            this.listModel.add(0, "<html><pre>" + (String.format(Localization.getLangDataAt(58) + " " + "%-13.13s" + Localization.getLangDataAt(48) + "%7s" + "\n" + Localization.getLangDataAt(49) + " " + risk, Localization.getLangDataAt(57), backendModels.japan.getCaseNumber())) + "</pre></html>");
        }
    }

    public ImageIcon fetchImage(String name) {
        Image image = new Image(name);
        ImageIcon imageIcon = new ImageIcon(image.getImage());
        return imageIcon;
    }

    public void updateSidePanel(int index) {
        String risk = "";

        if (index == 0) {
            if (this.backendModels.japan.getRisk().equals("High")) {
                risk = Localization.getLangDataAt(54);
            } else if (this.backendModels.japan.getRisk().equals("Moderate")) {
                risk = Localization.getLangDataAt(55);
            } else if (this.backendModels.japan.getRisk().equals("Low")) {
                risk = Localization.getLangDataAt(56);
            }
//            String popProcessed = String.format("%-10.10s", this.backendModels.japan.getCaseNumber());
            this.sidePanel.setText((String.format(Localization.getLangDataAt(58) + Localization.getLangDataAt(57) + "\n" + Localization.getLangDataAt(60) + "%9.9s" + "\n" + Localization.getLangDataAt(48) + "%-15.15s" + "\n" + Localization.getLangDataAt(59) + this.backendModels.japan.getCaseNumberDeltaWithDayPrior() + "\n" + Localization.getLangDataAt(49) + risk, this.backendModels.japan.getPopulation(), this.backendModels.japan.getCaseNumber())));
        } else {
            if (this.backendModels.japanPrefecture[index - 1].getRisk().equals("High")) {
                risk = Localization.getLangDataAt(54);
            } else if (this.backendModels.japanPrefecture[index - 1].getRisk().equals("Moderate")) {
                risk = Localization.getLangDataAt(55);
            } else if (this.backendModels.japanPrefecture[index - 1].getRisk().equals("Low")) {
                risk = Localization.getLangDataAt(56);
            }
            this.sidePanel.setText(String.format(Localization.getLangDataAt(47) + "" + Localization.getLangDataContaining(this.backendModels.japanPrefecture[index - 1].getRegionName()) + "\n" + Localization.getLangDataAt(60) + "%9.9s" + "\n" + Localization.getLangDataAt(59) + this.backendModels.japanPrefecture[index - 1].getCaseNumberDeltaWithDayPrior() + "\n" + Localization.getLangDataAt(49) + risk, this.backendModels.japanPrefecture[index - 1].getPopulation()));
        }
    }

    public void sortByRisk() {
        RegionCompareByRisk compare = new RegionCompareByRisk();
        Arrays.sort(this.backendModels.japanPrefecture, compare);
        this.updateCaseNumberTextPane();
    }

    public void sortByRegionNumber() {
        RegionCompareByRegionNum compare = new RegionCompareByRegionNum();
        Arrays.sort(this.backendModels.japanPrefecture, compare);
        this.updateCaseNumberTextPane();
    }
}
