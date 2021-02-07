/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.nfc;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class Image {

    private BufferedImage img;

    public Image() {

    }

    public void loadImage(String name) throws IOException {
        File imgPath = new File(("data" + File.separator + "images" + File.separator + name));
        this.img = ImageIO.read(imgPath);
    }

    public BufferedImage getImage() {
        return this.img;
    }
}
