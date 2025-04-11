package main;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        // variables for frame
        String title = "Learn game dev";

        // make the frame
        JFrame frame = new JFrame(title);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        // make an gamePanel object and adds it to frame
        GamePanel gamePanel = new GamePanel();
        frame.add(gamePanel);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        // start the gameLoop
        gamePanel.startGameThread();
    }
}