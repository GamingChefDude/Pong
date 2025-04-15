package entity;

import main.GamePanel;
import java.awt.*;

public class Ball {
    // ball variables
    public static int speed = 5;
    public int width = 15;
    public int height = 15;
    public int posY = GamePanel.screenHeight / 2 -height;
    public int posX = GamePanel.screenWidth / 2 - width;

    public void update() {
        posX -= speed;
    }

    public void draw(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(posX, posY, width, height);
    }
}