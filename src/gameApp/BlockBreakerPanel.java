package gameApp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class BlockBreakerPanel extends JPanel implements KeyListener {

    ArrayList<Block> blocks;
    Block ball;
    Block paddle;

    JFrame mainFrame, startScreen;

    // Reference to the main thread
    Thread thread;

    void reset() {

        blocks = new ArrayList<Block>();
        ball = new Block(237,345,25,25,"ball.png");
        paddle = new Block(175,480,150,25,"paddle.png");

        // Implementing blocks
        for (int i = 0; i < 8; i++) {
            blocks.add(new Block((i*60+2), 0, 60, 25, "blue.png"));
        }
        for (int i = 0; i < 8; i++) {
            blocks.add(new Block((i*60+2), 25, 60, 25, "green.png"));
        }for (int i = 0; i < 8; i++) {
            blocks.add(new Block((i*60+2), 50, 60, 25, "yellow.png"));
        }for (int i = 0; i < 8; i++) {
            blocks.add(new Block((i*60+2), 75, 60, 25, "red.png"));
        }

        addKeyListener(this); // Add this class as a key listener
        setFocusable(true);     // Gonna facus on the component
    }

    BlockBreakerPanel(JFrame frame, JFrame startScreen) {

        this.mainFrame = frame;
        this.startScreen = startScreen;

       reset();
    }

    // Imolement running Thread
    public void paintComponent(Graphics g) {
        blocks.forEach(block -> {
            block.draw(g, this);
        });
        ball.draw(g, this);
        paddle.draw(g, this);
    }

    public void update() {

        ball.x += ball.movX;
        ball.y += ball.movY;

        // Implementing ball to move horizontally
        if(ball.x > (getWidth() - 25) || ball.x < 0)
            ball.movX *= -1;
        // Implementing ball to move vertically
        if(ball.y < 0 || ball.intersects(paddle))
            ball.movY *= -1;

        // Interupting main Thread and Invoking End (Start) Screen
        if(ball.y > getHeight()) {
            thread = null;
            reset();
            mainFrame.setVisible(false);
            startScreen.setVisible(true);
        }

        blocks.forEach(block -> {
            if(ball.intersects(block) && !block.destroyed) {
                ball.movY *= -1;
                block.destroyed = true;
            }
        });

        repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        // Gonna run the Thread
        if(e.getKeyCode() == KeyEvent.VK_ENTER) {
            thread = new Thread(() -> {
                while(true) {
                    update();
                    try {
                        Thread.sleep(10);
                    } catch(InterruptedException err) {
                        err.printStackTrace();
                    }
                }
            });
                    thread.start();
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
