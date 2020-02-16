package Pong;

import javax.swing.*;
import java.awt.event.KeyEvent;

public class Paddle {
    public Direction playerDirection = Direction.NONE;
    Ball ball;
    JFrame frame;
    private int X, Y;
    private int paddleHeight;
    private int speed = 5 ;

    public Paddle(JFrame frame) {


        this.frame = frame;
        Y = frame.getHeight() / 2 - frame.getHeight() / 14;
        paddleHeight = frame.getHeight() / 7;

    }



    public void keyPressed(KeyEvent e,  int key1, int key2) {
        int key = e.getKeyCode();
        if (key == key1) {
            playerDirection = Direction.UP;
        }
        if (key == key2) {
            playerDirection = Direction.DOWN;
        }
    }
    public void move() {

        switch(playerDirection) {
            case DOWN:
                if(Y < frame.getHeight()-paddleHeight - 10)
                    Y += speed;
                else
                    playerDirection = Direction.NONE;


                break;
            case UP:
                if (Y > 5)
                    Y -= speed;

                break;
            default:
                break;
        }}

    public Direction getPlayerDirection() {
        return playerDirection;
    }

    public int getPaddleHeight() {
        return paddleHeight;
    }

    public int getX() {
        return X;
    }

    public int getY() {
        return Y;
    }

    public void setX(int x) {
        X = x;
    }
}
