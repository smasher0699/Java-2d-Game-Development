package src.entity;

import src.main.GamePanel;
import src.main.KeyHandler;
import java.awt.Graphics2D;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.Image;
import java.io.File;

public class Player extends Entity {

    GamePanel gp;
    KeyHandler keyH;

    public Player(GamePanel gp, KeyHandler key) {
        this.gp = gp;
        this.keyH = key;
        setDefaultValues();
    }

    public void setDefaultValues() {
        x = 100;
        y = 100;
        speed = 4;
        direction = "down";
    }

    public void getPlayerImage() {
        up1 = "\\plr_up_1.png";
        up2 = "\\plr_up_2.png";
        down1 = "\\plr_down_1.png";
        down2 = "\\plr_down_2.png";
        left1 = "\\plr_left_1.png";
        left2 = "\\plr_left_2.png";
        right1 = "\\plr_right_1.png";
        right2 = "\\plr_right_2.png";
    }

    public void update() {
        if (keyH.upPressed == true) {
            direction = "up";
            y -= speed;
        }
        if (keyH.downPressed == true) {
            direction = "down";
            y += speed;
        }
        if (keyH.leftPressed == true) {
            direction = "left";
            x -= speed;
        }
        if (keyH.rightPressed == true) {
            direction = "right";
            x += speed;
        }
    }

    public void draw(Graphics2D g2) {

        getPlayerImage();

        if (direction == "up") {
            url = up1;
        } else if (direction == "down") {
            url = down1;
        } else if (direction == "left") {
            url = left1;
        } else if (direction == "right") {
            url = right1;
        }

        try {

            Image image = ImageIO.read(new File("E:\\Languages\\Java\\Java game 2nd attempt\\src\\res\\player" + url));
            BufferedImage buffered = (BufferedImage) image;
            g2.drawImage(buffered, x, y, gp.tileSize, gp.tileSize, null);

        } catch (IOException e) {
            System.out.println("IO Exception");
        }

    }
}
