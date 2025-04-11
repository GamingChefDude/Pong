package entity;

import main.GamePanel;
import main.KeyHandler;
import java.awt.*;

public class Player {
    // player variables
    static int speed = 7;
    static int width = 15;
    static int height = 125;
    static int posY = GamePanel.screenHeight / 2 - height / 2;
    static int posX = 0;

    public static void update() {
        // player movement
        if (KeyHandler.up) {
            posY -= speed;
        }
        else if (KeyHandler.down) {
            posY += speed;
        }
    }

    public static void draw(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(posX, posY, width, height);
    }
}