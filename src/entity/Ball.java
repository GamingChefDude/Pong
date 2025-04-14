package entity;

import main.GamePanel;
import java.awt.*;

public class Ball {
    // ball variables
    static int speed = 5;
    static int width = 15;
    static int height = 15;
    static int posY = GamePanel.screenHeight / 2 -height;
    static int posX = GamePanel.screenWidth / 2 - width;

    public static void update() {
        posX -= speed;
    }

    public static void draw(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(posX, posY, width, height);
    }
}