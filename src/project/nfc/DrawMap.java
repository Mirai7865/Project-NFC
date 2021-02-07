/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.nfc;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.ImageIcon;

public class DrawMap {

//    JLabel redDotLabel;
//    JLabel mapLabel;
    BufferedImage map;
    BufferedImage dotRed;
    BufferedImage dotGreen;
    BufferedImage dotOrange;
    BufferedImage dotBlue;
    public int[] xLoc;
    public int[] yLoc;
//    public String[] risk;

    public DrawMap() {
        Scanner scr = new Scanner(AccessFile.readFile("data" + File.separator + "dotLocation.txt"));
        scr.useDelimiter("<.{0,10}=");
        int count = 0;
        xLoc = new int[47];
        yLoc = new int[47];
//        size = new String[47];

        while (scr.hasNext()) {
            String str = scr.next();
            int index = str.indexOf(",");
            int indexLast = str.lastIndexOf(",");
            xLoc[count] = Integer.parseInt(str.substring(0, index));
            yLoc[count] = Integer.parseInt(str.substring(index + 1, indexLast));
//            size[count] = str.substring(indexLast + 1);
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
                g.drawImage((this.dotGreen), xLoc[i], yLoc[i], null);
            }
        }
        return new ImageIcon(this.map);
    }

    private void setMap(String mapName) {
        Image map = new Image();
        try {
            map.loadImage(mapName);
            this.map = (map.getImage());
        } catch (IOException IOE) {
            System.out.println("Unable to find japan_map.png.");
        }
    }

    private void setDots() {
        Image dot = new Image();
        try {
            dot.loadImage("red dot.png");
            this.dotRed = (dot.getImage());
            dot.loadImage("green dot.png");
            this.dotGreen = (dot.getImage());
            dot.loadImage("orange dot.png");
            this.dotOrange = (dot.getImage());
            dot.loadImage("blue dot.png");
            this.dotBlue = (dot.getImage());
        } catch (IOException IOE) {
            System.out.println("Unable to find png.");
        }
    }
}