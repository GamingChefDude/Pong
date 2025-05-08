package main;

import entity.Player;
import entity.Ball;
import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable {
    // make multiple players
    Player player1 = new Player(screenHeight / 2 - Player.height / 2, 0, 1);
    Player player2 = new Player(screenHeight / 2 - Player.height / 2, screenWidth - Player.width, 2);
    Ball ball = new Ball();

    // variables
    public static int screenWidth = 800;
    public static int screenHeight = 600;
    int fps = 60;
    public static int leftScore = 0;
    public static int rightScore = 0;

    KeyHandler keyH = new KeyHandler();
    Thread gameThread;

    GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.DARK_GRAY);
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }

    public void startGameThread() {
        // starting the gameThread
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        // the main gameLoop
        // running update and repaint 60 times a second because fps = 60

        // making variables for delta time / the fps
        double drawInterval = (double) 1000000000 /fps;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;
        int drawCount = 0;

        while (gameThread != null) {
            // making the update and repaint happen with the frames
            currentTime = System.nanoTime();

            delta += (currentTime - lastTime) / drawInterval;
            timer += (currentTime - lastTime);
            lastTime = currentTime;

            if (delta >= 1) {
                update();
                repaint();
                delta--;
                drawCount++;
            }

            if (timer >= 1000000000) {
                System.out.println("FPS: " + drawCount);
                drawCount = 0;
                timer = 0;
            }
        }
    }

    public boolean checkCollision(Player p, Ball b) {
        return p.posX < b.posX + b.width &&
                p.posX + Player.width > b.posX &&
                p.posY < b.posY + b.height &&
                p.posY + Player.height > b.posY;
    }

    public void collision() {
        ball.velocityX = -ball.velocityX;
        ball.posX += ball.velocityX;
    }

    void update() {
        player1.update();
        player2.update();
        ball.update();

        if (checkCollision(player1, ball)) {
            collision();
        }

        if (checkCollision(player2, ball)) {
            collision();
        }

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        player1.draw(g);
        player2.draw(g);
        ball.draw(g);

        int scoreSize = 30;
        int scoreX = screenWidth / 2 - 85;
        int scoreY = 30;

        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, scoreSize));
        g.drawString("Score: " + leftScore + " - " + rightScore, scoreX, scoreY);

        g.dispose();
    }
}