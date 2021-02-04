/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capstone.project;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;

public class MainDisplay extends JFrame {

    BackendModels backendModels;

    JTextArea caseNumberTextField;
    JFrame mainFrame = new JFrame();
    JButton hokkaidoButton;
    ImageIcon mapIcon;
    JLabel mapLabel;

    public void initialComponents() {
        this.mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.mainFrame.setMinimumSize(new Dimension(1200, 800));
        this.mainFrame.setTitle("Project NFC");
        this.mainFrame.setLayout(null);

        this.caseNumberTextField = new JTextArea();
        this.caseNumberTextField.setSize(200, 200);
        this.caseNumberTextField.setText("Collecting data from server.");
        this.caseNumberTextField.setEditable(false);

        this.setMap("japan_map.png");
        this.mapLabel = new JLabel(this.mapIcon);

//        this.hokkaidoButton = new JButton();
//        this.hokkaidoButton.setFont(new Font("Arial", Font.PLAIN, 16));
//        this.hokkaidoButton.setText("Hokkaido " + backendModels.japan[0].getCaseNumber());
        Container mainDisplayPane = this.mainFrame.getContentPane();
        mainDisplayPane.setLayout(new GridLayout());

//        this.hokkaidoButton.setBounds(500, 50, 150, 50);
//        this.mainFrame.add(this.hokkaidoButton);
        GridBagConstraints gbc;

        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.gridheight = 5;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.CENTER;
        gbc.anchor = GridBagConstraints.NORTH;
        this.mainFrame.add(this.caseNumberTextField, gbc);
        //        gbc = new GridBagConstraints();
        //        gbc.gridx = 0;
        //        gbc.gridy = 0;
        //        gbc.gridwidth = 1;
        //        gbc.gridheight = 5;
        //        gbc.weightx = 1;
        //        gbc.weighty = 1;
        //        gbc.fill = GridBagConstraints.CENTER;
        //        gbc.anchor = GridBagConstraints.NORTH;
        //        mainDisplayPane.add(this.randomButton, gbc)
//        this.mapLabel.setBounds(0, 0, 800, 600);
        mainDisplayPane.add(this.mapLabel);
        this.mainFrame.setVisible(true);
        this.mainFrame.pack();
    }

    public MainDisplay() {
        //Create JFrame and locate "mainDsiplay"
        this.initialComponents();
        this.backendModels = new BackendModels();
        updateCaseNumberTextField();

    }

    private void setMap(String mapName) {
        Image map = new Image();
        try {
            map.loadImage(mapName);
            this.mapIcon = new ImageIcon(map.getImage());
        } catch (IOException IOE) {
            System.out.println("Unable to find japan_map.png.");
        }
    }

    public void updateCaseNumberTextField() {
        //update contents inside the mainDisplay
        StringBuffer strB = new StringBuffer();
        for (Region region : this.backendModels.japan) {
            strB.append(region.toString());
            strB.append("\n");
        }
        this.caseNumberTextField.setText(strB.toString());
    }
}
