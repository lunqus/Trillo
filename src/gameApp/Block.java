package gameApp;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class Block extends Rectangle {

    Image pic;        // Declare Image for Block
    boolean destroyed;  // Block destroyer

    int posX, posY;
    int width, height;

    /***
     *
     * @param x - corner coordinate X of the block
     * @param y - corner coordinate Y of the block
     * @param w - block width
     * @param h - block height
     * @param s - location of the image
     */
    public Block(int x, int y, int w, int h, String s) {
        posX = x;
        posY = y;
        width = w;
        height = h;

        // Asign the picture to the actual location
        try {
            pic = ImageIO.read(new File(s));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void draw(Graphics g, Component c) {

        if (!destroyed) // gonna draw the block if it's not destroyed
            g.drawImage(pic,posX,posY,width,height,c);
    }
}
