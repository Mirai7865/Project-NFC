/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackendModels;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;

public class Image {

    private BufferedImage img;

    public Image(String path) {
        this.img = null;
        this.loadImage(path);
    }

    private void loadImage(String name) {
        File imgPath;
        try {
            imgPath = new File(("data" + File.separator + "images" + File.separator + name));
            this.img = ImageIO.read(imgPath);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "No such file found: " + name, "Error", ERROR_MESSAGE);
            System.exit(0);
        }
    }

    public BufferedImage getImage() {
        return this.img;
    }
}
