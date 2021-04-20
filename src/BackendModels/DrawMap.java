/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackendModels;

import BackendModels.*;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Scanner;
import javax.swing.ImageIcon;

public class DrawMap {

    private BufferedImage map;
    private BufferedImage dotRed;
    private BufferedImage dotGreen;
    private BufferedImage dotOrange;
    private BufferedImage dotBlue;
    private int[] xLoc;
    private int[] yLoc;
    private Prefecture[] pref;
    private String mapName;

    public DrawMap(Prefecture[] pref, String fileName) {

        this.mapName = fileName;
        this.setDots();
        this.pref = pref;

        Scanner scr = new Scanner(AccessFile.readFile("data" + File.separator + "images" + File.separator + "dotLocation.txt"));
        scr.useDelimiter("@");
        int count = 0;
        this.xLoc = new int[47];
        this.yLoc = new int[47];
        int indexEqualSign = -1;
        int indexComma = -1;
        int indexCommaLast = -1;

        while (scr.hasNext()) {
            String str = scr.next();
            indexEqualSign = str.indexOf("=");
            indexComma = str.indexOf(",");
            indexCommaLast = str.lastIndexOf(",");
            this.xLoc[count] = Integer.parseInt(str.substring(indexEqualSign + 1, indexComma));
            this.yLoc[count] = Integer.parseInt(str.substring(indexComma + 1, indexCommaLast));
            count++;
        }
    }

    public ImageIcon DrawRiskMap() {
        this.resetMap();
        Graphics g = this.map.getGraphics();
        for (int i = 0; i < this.xLoc.length; i++) {
            if (this.pref[i].getRisk().equals("High")) {
                g.drawImage(this.dotRed, this.xLoc[i], this.yLoc[i], null);
            } else if (this.pref[i].getRisk().equals("Moderate")) {
                g.drawImage(this.dotOrange, this.xLoc[i], this.yLoc[i], null);
            } else if (this.pref[i].getRisk().equals("Low")) {
                g.drawImage(this.dotGreen, this.xLoc[i], this.yLoc[i], null);
            }
        }

        g.drawImage(this.dotRed, 10, 10, null);
        g.drawImage(this.dotOrange, 10, 50, null);
        g.drawImage(this.dotGreen, 10, 90, null);

        g.setFont(new Font("TimesRoman", Font.PLAIN, 13));
        g.setColor(java.awt.Color.black);
        g.drawString("= High Risk", 35, 25);
        g.drawString("= Moderate Risk", 35, 65);
        g.drawString("= Low Risk", 35, 105);
        return new ImageIcon(this.map);
    }

    public ImageIcon DrawLocationMap(int index) {
        if (index > 46) {
            return null;
        }
        this.resetMap();
        Graphics g = this.map.getGraphics();
        g.drawImage(this.dotBlue, this.xLoc[index], this.yLoc[index], null);

        g.drawImage(this.dotBlue, 10, 10, null);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 13));
        g.setColor(java.awt.Color.black);
        g.drawString("= Location of the site", 35, 25);

        return new ImageIcon(this.map);
    }

    private void resetMap() {
        Image map = new Image(this.mapName);
        this.map = (map.getImage());
    }

    private void setDots() {
        Image dot;
        dot = new Image("red dot.png");
        this.dotRed = (dot.getImage());
        dot = new Image("green dot.png");
        this.dotGreen = (dot.getImage());
        dot = new Image("orange dot.png");
        this.dotOrange = (dot.getImage());
        dot = new Image("blue dot.png");
        this.dotBlue = (dot.getImage());
    }
}
