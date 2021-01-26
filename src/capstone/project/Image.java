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


/**
 *
 * @author 1100000436
 */
public class Image {
    private BufferedImage img;
    public Image() {

    }

    public void loadImage(String path) throws IOException{
        this.img = null;
        this.img = ImageIO.read(new File (path));
    }
    
    public BufferedImage getImage () {
        return this.img;
    }
}
