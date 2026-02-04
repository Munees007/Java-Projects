package ui;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class GenerateImage {
    static String mainPath = "src\\images";
    public static ImageIcon create(String filename,int width,int height)
    {
        ImageIcon ic = null;
        try{
            BufferedImage bi = ImageIO.read(new File(mainPath + filename));
            Image image = bi.getScaledInstance(width, height,Image.SCALE_SMOOTH);
            ic = new ImageIcon(image);
        }
        catch(IOException e)
        {
            System.out.println(e.getMessage());
        }
        return ic;
    }
}
