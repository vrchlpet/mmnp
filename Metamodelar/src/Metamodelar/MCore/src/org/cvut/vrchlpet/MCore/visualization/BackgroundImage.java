

package org.cvut.vrchlpet.MCore.visualization;


import java.awt.image.BufferedImage;
import java.io.File;
import org.cvut.vrchlpet.MCore.visualization.ui.ImageLoader;



/**
 *
 * Obrazek elementu
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public class BackgroundImage {

    public static final boolean DEFAUL_LOADED = false;
    
    
    
    private String path;
    private BufferedImage image;
    private boolean loaded;
    private String imgName;

    
    public BackgroundImage() {
        this.image = null;
        this.path = "";
        loaded = DEFAUL_LOADED;
    }

    public BackgroundImage(String path) {
        this();
        setPath(path);
    }

    public boolean isSVG() {
        return (getPath().endsWith(".svg") || getPath().endsWith(".SVG"));
    }

    /**
     * @return the image
     */
    public BufferedImage getImage() {
        return this.image;
    }

    /**
     * @param image the image to set
     */
    public void setImage(BufferedImage image) {
        this.image = image;
        loaded = image == null ? false : true;
        if ( image == null) {
            imgName = "";
            path = "";
        }
    }

    /**
     * @return the path
     */
    public String getPath() {
        return path;
    }

    /**
     * @param path the path to set
     */
    public void setPath(String path) {
        this.path = path;
        setImage(ImageLoader.loadImage(path));
        
        int i = path.lastIndexOf(File.separator);
        if ( i != -1)
            imgName = path.substring(i + 1);
    }

    /**
     * @return the loaded
     */
    public boolean isLoaded() {
        return loaded;
    }

    /**
     * @return the imgName
     */
    public String getImgName() {
        return imgName;
    }

    /**
     * @param imgName the imgName to set
     */
    public void setImgName(String imgName) {
        this.imgName = imgName;
    }


}
