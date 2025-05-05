package entity;

import main.GamePanel;
import java.awt.*;

public class Ball {
    // ball variables
    public int width = 15;
    public int height = 15;
    public int posY = GamePanel.screenHeight / 2 -height;
    public int posX = GamePanel.screenWidth / 2 - width;
    public int velocityY = 7;
    public int velocityX = 5;

    public void update() {
        if (posY <= 0 || posY >= GamePanel.screenHeight - height) {
            velocityY = -velocityY;
            posY += velocityY;
        }
        posX += velocityX;
        posY += velocityY;
    }

    public void draw(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(posX, posY, width, height);
    }
}