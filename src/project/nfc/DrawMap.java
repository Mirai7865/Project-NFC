/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.nfc;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Scanner;
import javax.swing.ImageIcon;

public class DrawMap {

    BufferedImage map;
    BufferedImage dotRed;
    BufferedImage dotGreen;
    BufferedImage dotOrange;
    BufferedImage dotBlue;
    private int[] xLoc;
    private int[] yLoc;

    public DrawMap() {
        Scanner scr = new Scanner(AccessFile.readFile("data" + File.separator + "dotLocation.txt"));
        scr.useDelimiter("@");
        int count = 0;
        xLoc = new int[47];
        yLoc = new int[47];

        while (scr.hasNext()) {
            String str = scr.next();
            int indexEqualSign = str.indexOf("=");
            int indexComma = str.indexOf(",");
            int indexCommaLast = str.lastIndexOf(",");
            xLoc[count] = Integer.parseInt(str.substring(indexEqualSign + 1, indexComma));
            yLoc[count] = Integer.parseInt(str.substring(indexComma + 1, indexCommaLast));
            count++;
        }
    }

    public ImageIcon initialDraw(Prefecture[] pref) {
        this.setMap("japan_map.png");
        this.setDots();
        Graphics g = this.map.getGraphics();
        for (int i = 0; i < xLoc.length; i++) {
            if (pref[i].getRisk().equals("High")) {
                g.drawImage(this.dotRed, xLoc[i], yLoc[i], null);
            } else if (pref[i].getRisk().equals("Moderate")) {
                g.drawImage(this.dotOrange, xLoc[i], yLoc[i], null);
            } else if (pref[i].getRisk().equals("Low")) {
                g.drawImage(this.dotGreen, xLoc[i], yLoc[i], null);
            }
        }
        return new ImageIcon(this.map);
    }

    private void setMap(String mapName) {
        Image map = new Image(mapName);
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
