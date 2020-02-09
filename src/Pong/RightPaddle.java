package Pong;

import javax.swing.*;
import java.awt.event.KeyEvent;

public class RightPaddle {
    public RightPaddle(JFrame frame) {
        this.frame = frame;

        RY = frame.getHeight() / 2 - frame.getHeight() / 14;
        paddleHeight = frame.getHeight()/7;

    }

    private Direction playerDirectionR = Direction.NONE;
    Ball ball;
    JFrame frame;
    private int RY;
    private int Rspeed = 10;
    private int paddleHeight;

    public void moveR() {
        switch (playerDirectionR) {
            case DOWN:
                if (RY < frame.getHeight() - paddleHeight- 10)
                    RY += Rspeed;

                break;
            case UP:
                if (RY > 5)
                    RY -= Rspeed;

                break;
            default:
                break;
        }
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_UP) {
            playerDirectionR = Direction.UP;
        }
        if (key == KeyEvent.VK_DOWN) {
            playerDirectionR = Direction.DOWN;
        }}
        public void keyReleased(KeyEvent e){

            playerDirectionR = Direction.NONE;
        }
        public void keyTyped(KeyEvent e){
            int key = e.getKeyCode();

            if (key == KeyEvent.VK_UP) {
                playerDirectionR = Direction.UP;
            }
            if (key == KeyEvent.VK_DOWN) {
                playerDirectionR = Direction.DOWN;
            }
        }



    public int getRY() {
        return RY;
    }

    public int getRspeed() {
        return Rspeed;
    }

    public int getPaddleHeight() {
        return paddleHeight;
    }
}
