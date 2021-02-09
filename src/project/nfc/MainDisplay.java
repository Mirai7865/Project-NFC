/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.nfc;

import java.awt.Container;
import java.awt.Panel;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
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
import javax.swing.JTextField;
import static javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER;
import javax.swing.WindowConstants;

public class MainDisplay extends JFrame {

    BackendModels backendModels;

    JList caseNumberList;
    JButton langJpButton;
    JButton langEnButton;
    JTabbedPane mainPane;
    JPanel caseNumberPanel;
    JPanel guidePanel;
    JTextArea guidebookText;
    JScrollPane guideSectionPane;
    JPanel guideSectionImagePane1;
    JPanel guideSectionImagePane2;

//    ImageIcon mapIcon;
//    ImageIcon redDot;
//    ImageIcon yellowDot;
//    ImageIcon greenDot;
//    JLabel redDotLabel;
    JLabel mapLabel;
    JPanel mapPanel;
    JScrollPane caseNumberPane;
    DefaultListModel<String> listModel;

    private void initialComponents() {
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setMinimumSize(new Dimension(1200, 600));
        this.setTitle("Project NFC");

        this.mainPane = new JTabbedPane(JTabbedPane.TOP);
        this.caseNumberPanel = new JPanel(new GridBagLayout());
        this.guidePanel = new JPanel(new GridBagLayout());

        this.listModel = new DefaultListModel<>();
        this.caseNumberList = new JList(this.listModel);
        this.caseNumberList.setFont(new Font("monospaced", Font.BOLD, 14));
//        this.caseNumberList.setPreferredSize(new Dimension(510, 1550));

        this.caseNumberPane = new JScrollPane(this.caseNumberList);
        this.caseNumberPane.setPreferredSize(new Dimension(380, 500));
        this.caseNumberPane.setBorder(BorderFactory.createTitledBorder(Localization.getLangDataAtIndex(51)));

        this.langJpButton = new JButton();
        this.langJpButton.setText("日本語");

        this.langEnButton = new JButton();
        this.langEnButton.setText("English");

        DrawMap map = new DrawMap();
//        this.mapLabel = new JLabel(map.initialDraw(this.backendModels.japan));
        this.mapPanel = new JPanel();
        this.mapPanel.add(new JLabel(map.initialDraw(this.backendModels.japan)));
        this.mapPanel.setBorder(BorderFactory.createTitledBorder(Localization.getLangDataAtIndex(50)));

        this.guidebookText = new JTextArea();
        this.guidebookText.setEditable(false);

        Guide sensouji = new Guide("Sensouji", "Sensouji");
        this.guidebookText.setText(sensouji.getArticle());
        this.guidebookText.setFont(new Font(Font.SERIF, Font.PLAIN, 18));
        this.guidebookText.setSize(new Dimension(700, 700));
        this.guidebookText.setLineWrap(true);
        this.guidebookText.setWrapStyleWord(true);

        this.guideSectionPane = new JScrollPane(this.guidebookText);
        this.guideSectionPane.setBorder(BorderFactory.createTitledBorder("Senso-ji"));
//        this.guideSectionPane.setHorizontalScrollBarPolicy(HORIZONTAL_SCROLLBAR_NEVER);
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
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 1;
        gbc.weighty = 1;
//        gbc.fill = GridBagConstraints.CENTER;
//        gbc.anchor = GridBagConstraints.NORTH;
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

        Container mainDisplayPane = this.getContentPane();
        mainDisplayPane.setLayout(new GridBagLayout());

        this.mainPane.addTab(Localization.getLangDataAtIndex(52), null, this.caseNumberPanel, "Shows case numbers");

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

        this.mainPane.addTab(Localization.getLangDataAtIndex(53), null, this.guidePanel, "Guidebook section");

        mainDisplayPane.add(this.mainPane);
        this.mapPanel.setVisible(true);
        this.setVisible(true);
        this.pack();
    }

    public MainDisplay(BackendModels bem) {
        //Create JFrame and locate all the components. Also update caseNumber.
        this.backendModels = bem;
//        this.backendModels.initialSetUp();
        this.initialComponents();
        this.updateCaseNumberTextPane();

    }

    public void updateCaseNumberTextPane() {
        //update contents inside the caseNumberList
        this.listModel.clear();
//        String langData[] = Localization.getLangData();
        StringBuffer strB;
        String risk = null;

        if (Localization.getLang().equals("ja-jp")) { //Needs to differentiate the two, since tabbing works on ja-jp but not on en-us, and Formatter works for en-us but not for ja-jp
            for (int i = 0; i < backendModels.japan.length; i++) {
                if (backendModels.japan[i].getRisk().equals("High")) {
                    risk = Localization.getLangDataAtIndex(54);
                } else if (backendModels.japan[i].getRisk().equals("Moderate")) {
                    risk = Localization.getLangDataAtIndex(55);
//                    risk = "中";
                } else if (backendModels.japan[i].getRisk().equals("Low")) {
                    risk = Localization.getLangDataAtIndex(56);
//                    risk = "低";
                }
//                strB = new StringBuffer();
//                strB.append("<html><pre>");
//                strB.append(String.format(Localization.getLangDataAtIndex(47) + " " + Localization.getLangDataAtIndex(i) + "\t" + Localization.getLangDataAtIndex(48) + "%7s" + " " + Localization.getLangDataAtIndex(49) + " " + risk, backendModels.japan[i].getCaseNumber()));
//                strB.append("<html><pre>" + (String.format(Localization.getLangDataAtIndex(47) + " " + Localization.getLangDataAtIndex(i) + "\t" + Localization.getLangDataAtIndex(48) + "%7s" + " " + Localization.getLangDataAtIndex(49) + " " + risk, backendModels.japan[i].getCaseNumber())) + "</pre></html>");
                this.listModel.addElement("<html><pre>" + (String.format(Localization.getLangDataAtIndex(47) + " " + Localization.getLangDataAtIndex(i) + "\t" + Localization.getLangDataAtIndex(48) + "%7s" + " " + Localization.getLangDataAtIndex(49) + " " + risk, backendModels.japan[i].getCaseNumber())) + "</pre></html>");
            }
        } else if (Localization.getLang().equals("en-us")) {
            for (int i = 0; i < backendModels.japan.length; i++) {
                if (backendModels.japan[i].getRisk().equals("High")) {
                    risk = Localization.getLangDataAtIndex(54);
                }
                if (backendModels.japan[i].getRisk().equals("Moderate")) {
                    risk = Localization.getLangDataAtIndex(55);
                }
                if (backendModels.japan[i].getRisk().equals("Low")) {
                    risk = Localization.getLangDataAtIndex(56);
                }
//                strB = new StringBuffer();
//                strB.append("<html><pre>");
//                strB.append(String.format(Localization.getLangDataAtIndex(47) + " " + "%-10.10s" + Localization.getLangDataAtIndex(48) + "%7s" + " " + Localization.getLangDataAtIndex(49) + " " + risk, Localization.getLangDataAtIndex(i), backendModels.japan[i].getCaseNumber()));
//                strB.append("</pre></html>");
                this.listModel.addElement("<html><pre>" + (String.format(Localization.getLangDataAtIndex(47) + " " + "%-10.10s" + Localization.getLangDataAtIndex(48) + "%7s" + "\n" + Localization.getLangDataAtIndex(49) + " " + risk, Localization.getLangDataAtIndex(i), backendModels.japan[i].getCaseNumber())) + "</pre></html>");
            }
        }
    }

    public ImageIcon fetchImage(String name) {
        Image image = new Image(name);
        return new ImageIcon(image.getImage());
    }
}
