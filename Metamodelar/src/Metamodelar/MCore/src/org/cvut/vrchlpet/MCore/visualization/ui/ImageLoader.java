
package org.cvut.vrchlpet.MCore.visualization.ui;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

/**
 *
 * Trida obstaravajici nahravani obrazku
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public class ImageLoader {

    public static BufferedImage loadImage(String path) {
        BufferedImage image = null;
        try {
            image = ImageIO.read(new File(path));
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e.getMessage() + "\n" + path);
        }

        return image;
    }
    
    
    public static BufferedImage loadImage(InputStream is) {
        BufferedImage image = null;
        try {
            image = ImageIO.read(is);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

        return image;
    }

    public static Image loadImage(byte[] data) {
        return Toolkit.getDefaultToolkit().createImage(data);
    }
}

