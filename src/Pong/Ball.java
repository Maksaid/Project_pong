package Pong;

import javax.swing.*;
import java.io.FileInputStream;
import java.util.Random;


public class Ball {
    private int BallX;
    private int BallY;
    private int BalldirX;
    private int BalldirY;
    private int BallSpeed = 6;
    private int p1score, p2score;
    private boolean firstmove = true;
    JFrame frame;
    Ball ball;
    Paddle leftPaddle;
    Paddle rightPaddle;

    public Ball(JFrame frame) {
        this.frame = frame;
        p1score = p2score = 0;
        BallX = frame.getWidth() / 2;
        BallY = frame.getHeight() / 2;
        Random r = new Random();
    }

    void move() {
        if (Main.menu) {
            firstmove = true;
            p1score = 0;
            p2score = 0;
        }
        if (firstmove && !Main.menu) {
            leftPaddle.setY(frame.getHeight() / 2 - frame.getHeight() / 14);
            rightPaddle.setY(frame.getHeight() / 2 - frame.getHeight() / 14);
            spawnBall();
            firstmove = false;
        }
        BallX += BalldirX;
        BallY += BalldirY;
        if (BallX + BalldirX >= frame.getWidth() || BallX + BalldirX <= 0) {
            if (BallX + BalldirX >= frame.getWidth()) {
                spawnBall();
                p1score++;
                BallX = frame.getWidth() / 2;
                BallY = frame.getHeight() / 2;
            } else {
                p2score++;
                spawnBall();
                BallX = frame.getWidth() / 2;
                BallY = frame.getHeight() / 2;
            }


        }
        if (BallY + BalldirY >= frame.getHeight() || BallY + BalldirY <= 0) {
            BalldirY *= -1;
        }
        //столкновение с ракетками
        if (BallX + BalldirX >= 125 && BallX + BalldirX <= 130 && (BallY + BalldirY < leftPaddle.getY() + leftPaddle.getPaddleHeight() + 20) && BallY + BalldirY > leftPaddle.getY() - 20) {
            BalldirX = (BalldirX * -1);
            if (BalldirY == 2 || BalldirY == -2) {
                BalldirY = BalldirY + ((Math.random() < 0.5) ? -1 : 1);
            } else if (BalldirY < 0) {
                BalldirY = -2;
            } else
                BalldirY = 2;


        }
        if (BallX + BalldirX >= frame.getWidth() - 130 && BallX + BalldirX <= frame.getWidth() - 125 && BallY + BalldirY <= rightPaddle.getY() + rightPaddle.getPaddleHeight() + 20 && BallY + BalldirY > rightPaddle.getY() - 20) {
            BalldirX = (BalldirX * -1);
            if (BalldirY == 2 || BalldirY == -2) {
                BalldirY = BalldirY + ((Math.random() < 0.5) ? -1 : 1);
            } else if (BalldirY < 0) {
                BalldirY = -2;
            } else
                BalldirY = 2;
        }
        if (((BallX <= 125 && BallX >= 100) || (BallX > frame.getWidth() - 130 && BallX < frame.getWidth() - 110)) && (BallY + 5 > leftPaddle.getY() + 125 && BallY - 5 < leftPaddle.getY()))
            BalldirY *= -1;


    }


    public void setXDirection(int xDir) {
        BalldirX = xDir;
    }

    public void setYDirection(int yDir) {
        BalldirY = yDir;
    }

    public int getBallX() {
        return BallX;
    }

    public int getBallY() {
        return BallY;
    }

    public void setRightPaddle(Paddle rightPaddle) {
        this.rightPaddle = rightPaddle;
    }

    public int getBallSpeed() {
        return BallSpeed;
    }

    public void setLeftPaddle(Paddle leftPaddle) {
        this.leftPaddle = leftPaddle;
    }

    public String getP1score() {
        return String.valueOf(p1score);
    }

    public String getP2score() {
        return String.valueOf(p2score);
    }

    private void spawnBall() {
        if (!Main.menu) try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        BallX = frame.getWidth() / 2;
        BallY = frame.getHeight() / 2;
        BalldirX = ((Math.random() < 0.5) ? -5 : 5);
        BalldirY = ((Math.random() < 0.5) ? -2 : 2);
        BalldirY = (int) Math.sqrt(BallSpeed * BallSpeed - BalldirX * BalldirX) * ((Math.random() < 0.5) ? -1 : 1);

    }

    public int getBallDirY() {
        return BalldirY;
    }
}
