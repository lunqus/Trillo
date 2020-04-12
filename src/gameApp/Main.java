package gameApp;


import javax.swing.*;

public class Main {


    public static void main(String[] args) {

        JFrame frame = new JFrame("Trillo");

        // Start screen implementation
        JFrame startScreen = new JFrame();
        JButton start = new JButton("Start");

        BlockBreakerPanel panel = new BlockBreakerPanel(frame, startScreen);

        start.addActionListener(listener -> {
            startScreen.setVisible(false);
            frame.setVisible(true);
        });

        // Game Screen
        frame.getContentPane().add(panel);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setVisible(false);
        frame.setSize(490, 600);
        frame.setResizable(false);

        // Start Screen
        startScreen.getContentPane().add(start);

        startScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        startScreen.setVisible(true);
        startScreen.setSize(490, 600);
        startScreen.setResizable(false);
    }

}
