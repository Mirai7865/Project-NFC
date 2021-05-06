/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackendModels;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;

public class AccessImage {

    private BufferedImage img;

    public AccessImage(String path) {
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

    public ImageIcon getImageIcon() {
        return new ImageIcon(this.img);
    }

    public ImageIcon getScaledImage(int maxWidth, int maxHeight) {
        BufferedImage scalingImage = this.getImage();
        Image finalImage = scalingImage;
        if (scalingImage.getHeight() > maxHeight || scalingImage.getWidth() > maxWidth) {

            double heightScaling = (double)maxHeight / scalingImage.getHeight();
            double widthScaling = (double)maxWidth / scalingImage.getWidth();
            double scaling = 1.0;

            if (heightScaling < widthScaling) {
                scaling = heightScaling;
            } else {
                scaling = widthScaling;
            }
            
            int width = (int) (scalingImage.getWidth() * scaling);
            int height = (int) (scalingImage.getHeight() * scaling);
            finalImage = scalingImage.getScaledInstance(width, height, BufferedImage.SCALE_DEFAULT);
        }
        return new ImageIcon(finalImage);
    }
}
