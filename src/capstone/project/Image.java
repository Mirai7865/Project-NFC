/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capstone.project;

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
        File imgPath = null;
        try {
            imgPath = new File(getClass().getClassLoader().getResource("images" + File.separator + name).toURI());
        } catch (URISyntaxException ex) {
            Logger.getLogger(Image.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.img = ImageIO.read(/*CapstoneProject.class.getResource("capstone" + File.separator + "project" + File.separator + "data" + File.separator + "img" + File.separator + name)*/imgPath);
    }

    public BufferedImage getImage() {
        return this.img;
    }
}
