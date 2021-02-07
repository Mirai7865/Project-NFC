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
import java.io.IOException;
import java.util.Formatter;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.WindowConstants;

public class MainDisplay extends JFrame {

    BackendModels backendModels;

    JList caseNumberTextField;
    JButton langJpButton;
    JButton langEnButton;
//    ImageIcon mapIcon;
//    ImageIcon redDot;
//    ImageIcon yellowDot;
//    ImageIcon greenDot;
//    JLabel redDotLabel;
    JLabel mapLabel;
    JPanel mapPanel;
    DefaultListModel<String> listModel;

    String[] str = new String[48];
    JScrollPane pane;

    public void initialComponents() {
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setMinimumSize(new Dimension(1000, 600));
        this.setTitle("Project NFC");

        this.listModel = new DefaultListModel<>();
//        this.listModel.addElement("Collecting data from server....");
//        str[0] = "Collecting data from server";
        this.caseNumberTextField = new JList(this.listModel);
        this.caseNumberTextField.setFont(new Font("monospaced", Font.BOLD, 14));
//        this.caseNumberTextField.setPreferredSize(new Dimension(510, 1550));

        this.pane = new JScrollPane(this.caseNumberTextField);
        this.pane.setPreferredSize(new Dimension(380, 500));

        this.langJpButton = new JButton();
        this.langJpButton.setText("日本語");

        this.langEnButton = new JButton();
        this.langEnButton.setText("English");

//        this.setMap("japan_map.png");
        DrawMap map = new DrawMap();
        this.mapLabel = new JLabel(map.initialDraw(this.backendModels.japan));

        this.mapPanel = new JPanel();
        this.mapPanel.add(this.mapLabel);

        Container mainDisplayPane = this.getContentPane();
        mainDisplayPane.setLayout(new GridBagLayout());

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
        mainDisplayPane.add(this.langJpButton, gbc);

        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 0;
        gbc.gridheight = 0;
        gbc.weightx = 1;
        gbc.weighty = 1;
//        gbc.fill = GridBagConstraints.CENTER;
        gbc.anchor = GridBagConstraints.NORTH;
        mainDisplayPane.add(this.langEnButton, gbc);

        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 1;
        gbc.weighty = 1;
//        gbc.fill = GridBagConstraints.CENTER;
//        gbc.anchor = GridBagConstraints.NORTH;
        mainDisplayPane.add(this.pane, gbc);

        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 1;
        gbc.weighty = 1;
//        gbc.fill = GridBagConstraints.CENTER;
        gbc.anchor = GridBagConstraints.NORTH;
        mainDisplayPane.add(this.mapPanel, gbc);

        this.mapPanel.setVisible(true);
        this.setVisible(true);
        this.pack();
    }

    public MainDisplay(BackendModels bem) {
        //Create JFrame and locate "mainDsiplay"
        this.backendModels = bem;
//        this.initialComponents();
        this.backendModels.initialSetUp();
        this.initialComponents();
        this.updateCaseNumberTextField();

    }

//    private void setMap(String mapName) {
//        Image map = new Image();
//        try {
//            map.loadImage(mapName);
//            this.mapIcon = new ImageIcon(map.getImage());
//        } catch (IOException IOE) {
//            System.out.println("Unable to find japan_map.png.");
//        }
//    }
//    private void setDots() {
//        Image dot = new Image();
//        try {
//            dot.loadImage("red dot.png");
//            this.redDot = new ImageIcon(dot.getImage());
//        } catch (IOException IOE) {
//            System.out.println("Unable to find png.");
//        }
//    }
    public void updateCaseNumberTextField() {
        //update contents inside the mainDisplay
        this.listModel.clear();
        String langData[] = Localization.getLangData();

        if (Localization.getLang().equals("ja-jp")) { //Needs to differentiate the two, since tabbing works on ja-jp but not on en-us, and Formatter works for en-us but not for ja-jp
            for (int i = 0; i < backendModels.japan.length; i++) {
//                Formatter nft = new Formatter();
//                String str = nft.format(langData[47] + " " + "%-10.10s" + langData[48] + "%7s", langData[i], backendModels.japan[i].getCaseNumber()).toString();
                StringBuffer strB = new StringBuffer();
                strB.append("<html><pre>");
                strB.append(String.format(langData[47] + " " + langData[i] + "\t" +  langData[48] + "%7s" + " " + langData[49] + " " + backendModels.japan[i].getRisk(), backendModels.japan[i].getCaseNumber()));
                strB.append("</pre></html>");
                this.listModel.addElement(strB.toString());
//                nft.close();
            }
        } else if (Localization.getLang().equals("en-us")) {
            String str = "";
            for (int i = 0; i < backendModels.japan.length; i++) {
//                Formatter nft = new Formatter();
//                str = String.format(langData[47] + " " + "%-10.10s" + langData[48] + "%7s", langData[i], backendModels.japan[i].getCaseNumber()).toString();
//                this.listModel.addElement(str);
                StringBuffer strB = new StringBuffer();
                strB.append("<html><pre>");
                strB.append(String.format(langData[47] + " " + "%-10.10s" + langData[48] + "%7s" + " " + langData[49] + " " + backendModels.japan[i].getRisk(), langData[i], backendModels.japan[i].getCaseNumber()));
                strB.append("</pre></html>");
                this.listModel.addElement(strB.toString());
            }
        }
    }
}
