/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capstone.project;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Image {

    private BufferedImage img;

    public Image() {

    }

    public void loadImage(String name) throws IOException {
        File imgPath = new File(/*"src" + File.separator + */"capstone" + File.separator + "project" + File.separator + "data" + File.separator + "img" + File.separator + name
        );
        this.img = ImageIO.read(imgPath);
    }

    public BufferedImage getImage() {
        return this.img;
    }
}
