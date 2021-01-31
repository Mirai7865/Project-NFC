/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capstone.project;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;

public class MainDisplay extends JFrame {

    JTextArea mainTextField;
    JFrame mainFrame = new JFrame();
    JButton randomButton;
    ImageIcon mapIcon;
    JLabel mapLabel;

    public void initialComponents() {
        this.mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.mainFrame.setMinimumSize(new Dimension(1200, 600));

        this.mainTextField = new JTextArea();
        this.mainTextField.setSize(200, 200);
        this.mainTextField.setText("");

        this.setMap("japan_map.png");
        mapLabel = new JLabel(this.mapIcon);

        Container mainDisplayPane = this.mainFrame.getContentPane();
        mainDisplayPane.setLayout(new GridBagLayout());

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
        mainDisplayPane.add(this.mainTextField, gbc);

//        gbc = new GridBagConstraints();
//        gbc.gridx = 0;
//        gbc.gridy = 0;
//        gbc.gridwidth = 1;
//        gbc.gridheight = 5;
//        gbc.weightx = 1;
//        gbc.weighty = 1;
//        gbc.fill = GridBagConstraints.CENTER;
//        gbc.anchor = GridBagConstraints.NORTH;
//        mainDisplayPane.add(this.randomButton, gbc);
        mainDisplayPane.add(this.mapLabel);

        this.mainFrame.setVisible(true);
        this.mainFrame.pack();
    }

    public MainDisplay() {
        //Create JFrame and locate "mainDsiplay"
        this.initialComponents();
    }

    private void setMap(String mapName) {
        Image map = new Image();
        try {
            map.loadImage(mapName);
            this.mapIcon = new ImageIcon(map.getImage());
        } catch (IOException IOE) {
            updateMainDisplay("Unable to find japan_map.png.");
        }
    }

    public void updateMainDisplay(String text) {
        //update contents inside the mainDisplay
        this.mainTextField.setText(text);
    }
}
