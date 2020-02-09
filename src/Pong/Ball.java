package Pong;

import javax.swing.*;
import java.util.Random;

public class Ball {
    private int BallX;
    private int BallY;
    private int BalldirX;
    private int BalldirY;
    private int BallSpeed = 10;
    private int p1score, p2score;
    private boolean firstmove = true;
    JFrame frame;
    Ball ball;
    LeftPaddle leftPaddle;
    RightPaddle rightPaddle;

    public Ball(JFrame frame){
        this.frame = frame;
        p1score=p2score=0;
        BallX = frame.getWidth()/2 ;
        BallY = frame.getHeight()/2;
        Random r = new Random();
    }
    void move(){
        if (firstmove){
            firstmove = false;
             BalldirX = (int) (Math.random()*BallSpeed*2)- BallSpeed;
           if(BalldirX  ==  0)
                BalldirX +=2;
            BalldirY = (int) (Math.random()*2) - 1;
            if(BalldirY == 0)
                BalldirY+=1;
            BalldirY = (int) Math.sqrt(BallSpeed*BallSpeed - BalldirX*BalldirX) * BalldirY;
        }
        BallX += BalldirX;
        BallY += BalldirY;
        if(BallX + BalldirX >= frame.getWidth() || BallX + BalldirX <= 0){
            if(BallX + BalldirX >= frame.getWidth())
                p1score++;
            else
                p2score++;
            firstmove = true;
            BallX = frame.getWidth()/2 ;
            BallY = frame.getHeight()/2;
        }
        if(BallY + BalldirY >= frame.getHeight() || BallY + BalldirY <= 0 ){
            BalldirY *= -1;
        }
        if (BallX >=105 && BallX <= 130 && (BallY < leftPaddle.getLY()+leftPaddle.getPaddleHeight() + 5 )&& BallY > leftPaddle.getLY() + 5 )
            BalldirX *= -1;
        if (BallX >= frame.getWidth()-130 && BallX <= frame.getWidth()-105 && BallY <= rightPaddle.getRY() + rightPaddle.getPaddleHeight() + 5 && BallY > rightPaddle.getRY() + 5)
            BalldirX *= -1;
        //столкновение с краями ракеток
        if (BallX <= 130 && BallX >= 95 && BallY >= leftPaddle.getLY() + 5 && BallY <= leftPaddle.getLY() -15) //с левой ракеткой сверху
            BalldirY *=-1;
        if (BallX <= 125 && BallX >=0 && BallY <= leftPaddle.getLY() + frame.getHeight()/7 && BallY >= leftPaddle.getLY() + frame.getHeight()/7 - 10) //с левой ракеткой сверху
            BalldirY *=-1;

    }


    public void setXDirection(int xDir){
        BalldirX = xDir;
    }
    public void setYDirection(int yDir){
        BalldirY = yDir;
    }

    public int getBallX() {
        return BallX;
    }

    public int getBallY() {
        return BallY;
    }

    public void setRightPaddle(RightPaddle rightPaddle) {
        this.rightPaddle = rightPaddle;
    }

    public int getBallSpeed() {
        return BallSpeed;
    }

    public void setLeftPaddle(LeftPaddle leftPaddle) {
        this.leftPaddle = leftPaddle;
    }

    public String getP1score() {
        return String.valueOf(p1score);
    }

    public String getP2score() {
        return String.valueOf(p2score);
    }


}
