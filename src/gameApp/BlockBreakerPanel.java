package gameApp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class BlockBreakerPanel extends JPanel implements KeyListener {

    ArrayList<Block> blocks = new ArrayList<Block>();
    Block ball = new Block(237,345,25,25,"ball.png");
    Block paddle = new Block(175,480,150,25,"paddle.png");


    BlockBreakerPanel() {

        addKeyListener(this); // Add this class as a key listener
        setFocusable(true);     // Gonna facus on the component
    }

    // Imolement running Thread
    public void paintComponent(Graphics g) {
        paddle.draw(g, this);
    }

    public void update() {
        repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        // Gonna run the Thread
        if(e.getKeyCode() == KeyEvent.VK_ENTER) {
            new Thread(() -> {
                while(true) {
                    update();
                    try {
                        Thread.sleep(10);
                    } catch(InterruptedException err) {
                        err.printStackTrace();
                    }
                }
            }).start();
        }

        if(e.getKeyCode() == KeyEvent.VK_RIGHT && paddle.x < (getWidth() - paddle.width)) {
            paddle.x += 15;
        }
        if(e.getKeyCode() == KeyEvent.VK_LEFT && paddle.x > 0) {
            paddle.x -= 15;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }


}
