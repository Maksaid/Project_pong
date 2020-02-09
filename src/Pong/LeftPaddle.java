package Pong;

import javax.swing.*;
import java.awt.event.KeyEvent;


public class LeftPaddle {
    public LeftPaddle(JFrame frame) {

        this.frame = frame;
        LY = frame.getHeight()/2-frame.getHeight()/14;
        paddleHeight = frame.getHeight()/7;
    }

    JFrame frame;
    private int LY;
    private int speed = 10;
    private int paddleHeight;

    private Direction playerDirectionL = Direction.NONE;

    public void move() {

        switch(playerDirectionL) {
            case DOWN:
                if(LY < frame.getHeight()-paddleHeight - 10)
                LY += speed;

                break;
            case UP:
                if (LY > 5)
                LY -= speed;

                break;
            default:
                break;
        }
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if(key == KeyEvent.VK_W ) {
            playerDirectionL = Direction.UP;
        }
        if(key == KeyEvent.VK_S) {
            playerDirectionL = Direction.DOWN;
        }

    }
    public void keyReleased(KeyEvent e){
        int key = e.getKeyCode();

        playerDirectionL = Direction.NONE;
    }

    public void keyTyped(KeyEvent e){
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_W) {
            playerDirectionL = Direction.UP;
        }
        if (key == KeyEvent.VK_S) {
            playerDirectionL = Direction.DOWN;
        }

    }



    public int getLY() {
        return LY;
    }

    public void setLY(int LY) {
        this.LY = LY;
    }



    public int getSpeed() {
        return speed;
    }

    public int getPaddleHeight() {
        return paddleHeight;
    }
}
