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

public class Image {

    private BufferedImage img;

    public Image(String path) {
        this.loadImage(path);
    }

    private void loadImage(String name) {
        File imgPath;
        try {
            imgPath = new File(("data" + File.separator + "images" + File.separator + name));
            this.img = ImageIO.read(imgPath);
        } catch (IOException e) {
            System.out.println("Unable to find image " + name);
        }
    }

    public BufferedImage getImage() {
        return this.img;
    }
}
