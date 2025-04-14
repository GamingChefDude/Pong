package entity;

import main.KeyHandler;
import java.awt.*;

public class Player {
    // player variables
    int speed = 7;
    public static int width = 15;
    public static int height = 125;
    int posY;
    int posX;
    int id;

    public Player(int posY, int posX, int id) {
        this.posY = posY;
        this.posX = posX;
        this.id = id;
    }

    public void update() {
        // player movement
        if (KeyHandler.up1 && id == 1) {
            posY -= speed;
        } else if (KeyHandler.down1 && id == 1) {
            posY += speed;
        }
        if (KeyHandler.up2 && id == 2) {
            posY -= speed;
        } else if (KeyHandler.down2 && id == 2) {
            posY += speed;
        }
    }

    public void draw(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(posX, posY, width, height);
    }
}