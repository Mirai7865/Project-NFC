/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View_Controller;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Rectangle;
import java.awt.Toolkit;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JWindow;
import javax.swing.WindowConstants;

public class SplashScreen extends JWindow {

    BackendModels bem;
    JTextArea appName;
    JWindow window;
    JTextArea backgroundWork;

    public SplashScreen() {
//        this.bem = bem;
        this.components();
    }

    private void components() {
        this.window = new JWindow();
        this.window.setLayout(new GridBagLayout());
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        this.window.setBounds(((int) d.getWidth() - 300) / 2, ((int) d.getHeight() - 200) / 2, 300, 200);
        this.appName = new JTextArea();
        this.appName.setText("Welcome to Project-NFC");
        this.appName.setFont(new Font("Arial", Font.BOLD, 22));
        this.appName.setOpaque(false);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.CENTER;
        gbc.anchor = GridBagConstraints.SOUTH;
        this.window.add(this.appName, gbc);

        this.backgroundWork = new JTextArea();
        this.backgroundWork.setFont(new Font("Arial", Font.PLAIN, 16));
        this.backgroundWork.setText("Fetching data from the web...");
        this.backgroundWork.setOpaque(false);
        
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.CENTER;
//        gbc.anchor = GridBagConstraints.NORTH;
        this.window.add(this.backgroundWork, gbc);

        this.window.setVisible(true);
    }

    public void setCurrentWork(String work) {
        this.backgroundWork.setText(work);
    }

    public void hide() {
        this.window.setVisible(false);
    }
}
