package gameApp;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class BlockBreakerPanel extends JPanel implements KeyListener {

    public BlockBreakerPanel() {
        Block paddle = new Block(175,480,150,25,"paddle.png");

        addKeyListener(this); // Add this class as a key listener
        setFocusable(true);     // Gonna facus on the component
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
